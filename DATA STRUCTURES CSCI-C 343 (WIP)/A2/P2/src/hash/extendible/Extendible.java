package hash.extendible;

import hash.AbstractHM;
import hash.chains.Entry;
import hash.exceptions.KeyNotFoundE;
import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * An implementation of a hash map using extendible hashing.
 * <p>
 * Extendible hashing is a dynamic hashing scheme where:
 * <p>
 * The hash table consists of a directory of pointers to buckets.
 * The directory can grow (by doubling its size) when a bucket overflows.
 * Each bucket has a local depth that indicates how many bits of the hash are relevant for that bucket.
 * If a bucket overflows, it may split, and the directory may expand if necessary.
 * <p>
 * This implementation supports insertion, deletion, and lookup in expected
 * constant time, while dynamically adapting its structure as needed.
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class Extendible<K, V> extends AbstractHM<K, V> {

    /**
     * Maximum number of entries allowed per bucket before a split occurs.
     */
    private static final int BUCKET_SIZE = 4;

    /**
     * A bucket stores a set of entries and has a local depth.
     * Local depth indicates how many hash bits are significant for this bucket.
     */
    private class Bucket {
        int localDepth;
        List<Entry<K, V>> entries;

        Bucket(int depth) {
            this.localDepth = depth;
            this.entries = new ArrayList<>();
        }

        boolean isFull() {
            return entries.size() >= BUCKET_SIZE;
        }

        V get(K key) throws KeyNotFoundE {
            for (Entry<K, V> e : entries) {
                if (e.getKey().equals(key)) {
                    return e.getValue();
                }
            }
            throw new KeyNotFoundE();
        }

        boolean remove(K key) {
            return entries.removeIf(e -> e.getKey().equals(key));
        }
    }

    /**
     * Number of bits used for directory indexing.
     */
    private int globalDepth;

    /**
     * Directory of buckets, indexed by a prefix of the hash of the key.
     */
    private List<Bucket> directory;

    /**
     * Number of key-value pairs stored in the map.
     */
    private int size;

    /**
     * Constructs an empty extendible hash map with two initial buckets.
     */
    public Extendible() {
        this.globalDepth = 1;
        this.directory = new ArrayList<>();
        this.size = 0;
        Bucket b1 = new Bucket(globalDepth);
        Bucket b2 = new Bucket(globalDepth);
        directory.add(b1);
        directory.add(b2);
    }

    /**
     * Computes the directory index for a given key based on its hash code
     * and the current global depth.
     *
     * @param key the key
     * @return the directory index
     */
    private int hash(K key) {
        return key.hashCode() & ((1 << globalDepth) - 1);
    }

    /**
     * isEmpty(): Checks if the map is empty.
     *
     * @return true if the map is empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * size(): Returns the number of key-value pairs in the map.
     *
     * @return the number of key-value pairs in the map.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * clear(): Removes all key-value pairs from the map.
     */
    @Override
    public void clear() {
        directory.clear();
        globalDepth = 1;
        Bucket b1 = new Bucket(globalDepth);
        Bucket b2 = new Bucket(globalDepth);
        directory.add(b1);
        directory.add(b2);
        size = 0;
    }

    /**
     * keySet(): Collects all keys from the map.
     * .
     *
     * @return a set of all keys in the map
     * .
     * Implementation guide:
     * - Create an empty Set<K> to avoid duplicates (multiple directory slots may point to the same bucket).
     * - For each directory slot, iterate that bucket's entries and add each key to the set.
     * - Return the set.
     */
    @Override
    public @NotNull Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Bucket b : this.directory) {
            for (Entry<K, V> e : b.entries) {
                keys.add(e.getKey());
            }
        }
        return keys;
    }

    /**
     * values(): Collects all values from the map.
     * .
     *
     * @return a set of all values in the map
     * .
     * Implementation guide:
     * - Create an empty Set<V> (or List if you need multisets; here a Set is fine).
     * - For each directory slot, walk the bucket's entries and add each value to the set.
     * - Return the set.
     */
    @Override
    public @NotNull Set<V> values() {
        Set<V> values = new HashSet<>();
        for (Bucket b : this.directory) {
            for (Entry<K, V> e : b.entries) {
                values.add(e.getValue());
            }
        }
        return values;
    }

    /**
     * containsKey(): Checks if a key exists in the map.
     * .
     *
     * @param key the given key
     * @return true if the key is found, otherwise false.
     * .
     * Implementation guide:
     * - Compute the directory index using hash(key).
     * - Scan that bucket's entries for a matching key with equals().
     * - Return true if found, otherwise false.
     */
    @Override
    public boolean containsKey(@NotNull K key) {
        Bucket b = directory.get(hash(key));
        for (Entry<K,V> e : b.entries) if (e.getKey().equals(key)) return true;
        return false;
    }

    /**
     * containsValue(): Iterates all buckets and checks if any value matches the given value.
     * .
     *
     * @param value the given value
     * @return true if the value is found, otherwise false.
     * .
     * Implementation guide:
     * - For each bucket in the directory, iterate its entries.
     * - If any entry.getValue().equals(value) return true.
     * - If none match, return false.
     */
    @Override
    public boolean containsValue(@NotNull V value) {
        Set<V> values = values();
        return values.contains(value);
    }

    /**
     * rehash(): Doubles the directory size by increasing the global depth by one.
     * Existing buckets are re-referenced accordingly.
     * .
     * Implementation guide:
     * - Increment globalDepth (so directory size becomes 2^globalDepth).
     * - Build a new ArrayList<Bucket> of length 2^globalDepth.
     * - For each old index i, copy its bucket reference into positions i and (i + 2^(globalDepth-1)).
     * (Each old slot now has two aliases in the expanded directory.)
     * - Replace the old directory with the new list.
     */
    @Override
    public void rehash() {
        int oldSize = directory.size();
        globalDepth++;
        int newSize = 1 << globalDepth;

        List<Bucket> newDir = new ArrayList<>(newSize);
        for (int i = 0; i < newSize; i++) newDir.add(null);

        for (int i = 0; i < oldSize; i++) {
            Bucket b = directory.get(i);
            newDir.set(i, b);
            newDir.set(i + oldSize, b);
        }
        directory = newDir;
    }

    /**
     * put(): Inserts a key-value pair into the map.
     * If the key already exists, update its value.
     * If the bucket overflows, split it and rehash.
     * .
     *
     * @param key   the key to insert
     * @param value the value to insert
     */
    @Override
    public void put(@NotNull K key, @NotNull V value) {
        int idx = hash(key);
        Bucket bucket = directory.get(idx);

        // If key exists, update its value
        for (Entry<K, V> e : bucket.entries) {
            if (e.getKey().equals(key)) {
                e.setValue(value);
                return;
            }
        }

        // Otherwise insert
        if (!bucket.isFull()) {
            bucket.entries.add(new Entry<>(key, value));
            size++;
        } else {
            splitBucket(idx);
            put(key, value); // retry after split
        }
    }

    /**
     * splitBucket(): Splits the bucket at a given directory index when it overflows.
     * May trigger directory expansion if the local depth equals global depth.
     * .
     *
     * @param idx the index of the overflowing bucket
     *            .
     *            Implementation guide:
     *            - Let 'bucket' be directory.get(idx).
     *            - If bucket.localDepth == globalDepth: rehash() so we have more directory bits.
     *            - Create a new Bucket with localDepth = bucket.localDepth + 1.
     *            - Increase bucket.localDepth by 1 as well (old and new now share localDepth).
     *            - Determine which directory indices should point to 'bucket' vs the 'newBucket':
     *            * Consider all directory indices whose low localDepth bits match bucket's pattern.
     *            * Redirect the half whose new highest bit = 1 to point to newBucket; leave the others pointing to bucket.
     *            - Redistribute entries: take a copy of bucket.entries, clear it, and for each entry recompute its directory index
     *            using hash(e.getKey()) and add to directory.get(newIndex).entries.
     */
    private void splitBucket(int idx) {
        Bucket bucket = directory.get(idx);

        if (bucket.localDepth == globalDepth) {
            rehash();
            bucket = directory.get(idx);
        }

        int newLD = bucket.localDepth + 1;
        Bucket newBucket = new Bucket(newLD);
        bucket.localDepth = newLD;

        int splitBitPos = newLD - 1;
        for (int i = 0; i < directory.size(); i++) {
            if (directory.get(i) == bucket) {
                int bit = (i >> splitBitPos) & 1;
                if (bit == 1) {
                    directory.set(i, newBucket);
                }
            }
        }

        List<Entry<K, V>> oldEntries = new ArrayList<>(bucket.entries);
        bucket.entries.clear();
        for (Entry<K, V> e : oldEntries) {
            int newIndex = hash(e.getKey());
            directory.get(newIndex).entries.add(e);
        }
    }

    /**
     * get(): Retrieves a value from the map.
     * .
     *
     * @param key the key to retrieve
     * @return the value associated with the key
     * .
     * Implementation guide:
     * - Compute directory index via hash(key).
     * - Delegate to the bucket's get(key) which throws if not found, or
     * scan entries and return the value if you prefer to implement here.
     * @throws KeyNotFoundE if the key is not found
     */
    @Override
    public @NotNull V get(@NotNull K key) throws KeyNotFoundE {
        int idx = hash(key);
        Bucket bucket = directory.get(idx);

        for (Entry<K, V> e : bucket.entries) {
            if (e.getKey().equals(key)) {
                return e.getValue();
            }
        }
        throw new KeyNotFoundE();
    }

    /**
     * remove(): Removes a key from the map.
     * .
     *
     * @param key the key to remove
     * @throws KeyNotFoundE if the key is not found
     *                      .
     *                      Implementation guide:
     *                      - Compute directory index via hash(key).
     *                      - Attempt to remove the key from that bucket (iterate or delegate).
     *                      - If an entry was removed, decrement size; otherwise throw per spec.
     *                      - Optional: you need not merge buckets for this assignment.
     */
    @Override
    public void remove(@NotNull K key) throws KeyNotFoundE {
        int idx = hash(key);
        Bucket bucket = directory.get(idx);
        boolean removed = false;

        for (Entry<K, V> e : bucket.entries) {
            if (e.getKey().equals(key)) {
                bucket.entries.remove(e);
                this.size--;
                removed = true;
                break;
            }
        }
        if (!removed) throw new KeyNotFoundE();
    }
}