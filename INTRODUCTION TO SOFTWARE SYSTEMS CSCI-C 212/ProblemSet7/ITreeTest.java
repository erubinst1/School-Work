import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ITreeTest {
    @Test
    void testITree() {
        ITree<Integer> t1 =
                new Node<>(5,
                        new Node<>(3,
                                new Node<>(1, new Empty<>(), new Empty<>()),
                                new Node<>(4, new Empty<>(), new Empty<>())),
                        new Node<>(7,
                                new Node<>(6, new Empty<>(), new Empty<>()),
                                new Node<>(8, new Empty<>(), new Empty<>())));
        ITree<Integer> et1 =
                new Node<>(6,
                        new Node<>(4,
                                new Node<>(2, new Empty<>(), new Empty<>()),
                                new Node<>(5, new Empty<>(), new Empty<>())),
                        new Node<>(8,
                                new Node<>(7, new Empty<>(), new Empty<>()),
                                new Node<>(9, new Empty<>(), new Empty<>())));
        Assertions.assertEquals(et1, t1.fmap(n -> n + 1));
    }
}
