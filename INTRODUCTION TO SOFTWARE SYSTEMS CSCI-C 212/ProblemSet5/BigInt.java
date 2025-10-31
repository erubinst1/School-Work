import java.util.LinkedList;
import java.util.List;

class BigInt implements Comparable<BigInt> {

    private List<Integer> ls;
    private boolean isNeg;

    BigInt( String s){
        ls = new LinkedList<>();
        this.isNeg = s.startsWith("-");
        s = s.replaceFirst("^[+-]?", "").replaceFirst("^0+(?!$)", "");

        if(s.isEmpty() || s.equals("0")){
            ls.add(0);
            this.isNeg = false;
        }
        else{
            for(int i = s.length()-1; i >= 0; i--){
                ls.add(Character.getNumericValue(s.charAt(i)));
            }
        }



    }

    BigInt(){
        ls = new LinkedList<>();
        this.isNeg = false;
        ls.add(0);
    }

    //accessors
    List<Integer> getLs(){
        return this.ls;
    }

    boolean getIsNeg(){
        return this.isNeg;
    }

    /**
     * Overridden compareTo to compare BigInt objects
     *
     * @param o input object
     * @return true if the implicit and explicit objects are both BigInts and equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if( !(o instanceof BigInt)){
            return false;
        }
        BigInt othBigInt = (BigInt) o;

        if( this.areDifferentSigns(othBigInt)) return false;
        else{
            for( int i = 0; i < this.ls.size(); i++){
                if( this.ls.get(i) != othBigInt.ls.get(i)) return false;
            }
        }
        return true;
    }

    /**
     * Overridden compareTo method to compare BigInts
     *
     * @return -1 if this is less than o, 0 if this and o are equal, 1 if this is greater than o
     */
    @Override
    public int compareTo(BigInt o) {
        if( !this.isNeg && o.isNeg) return 1;
        if( this.isNeg && !o.isNeg) return -1;

        if( this.ls.size() > o.ls.size()) return 1;
        if( this.ls.size() < o.ls.size()) return -1;

        for(int i = ls.size()-1; i >= 0; i--){
            if( this.ls.get(i) > o.ls.get(i)) return 1;
            if( this.ls.get(i) < o.ls.get(i)) return -1;
        }
        return 0;
    }

    /**
     * Compares two BigInts while ignoring sign
     *
     * @return 1 if this is less than o, 0 if this and o are equal, 1 if this is greater than o
     */
    int absCompareTo(BigInt o) {
        if( this.ls.size() > o.ls.size()) return 1;
        if( this.ls.size() < o.ls.size()) return -1;

        for(int i = ls.size()-1; i >= 0; i--){
            if( this.ls.get(i) > o.ls.get(i)) return 1;
            if( this.ls.get(i) < o.ls.get(i)) return -1;
        }
        return 0;
    }

    /**
     * Overridden toString to produce a stringified version of the BigInt
     *
     * @return stringified version of the BigInt
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for( Integer n : this.ls) result.insert(0,n);
        if(this.isNeg) result.insert(0,"-");

        return result.toString();
    }

    /**
     * returns the sum of this and b
     *
     * @param b2 explicit BigInt input
     * @return sum of this and b
     */
    BigInt add(BigInt b2) {
        if (!this.areDifferentSigns(b2)) {
            BigInt result = this.addPositive(b2);
            if (result.toString().equals("0")) {
                result.isNeg = false;
            } else {
                result.isNeg = this.isNeg;
            }
            return result;
        }

        if (this.absCompareTo(b2) >= 0) {
            BigInt result = this.subPositive(b2);
            if (result.toString().equals("0")) result.isNeg = false;
            else result.isNeg = this.isNeg;
            return result;
        } else {
            BigInt result = b2.subPositive(this);
            if (result.toString().equals("0")) result.isNeg = false;
            else result.isNeg = b2.isNeg;
            return result;
        }
    }

    /**
     * returns a BigInt instance that is the sum of this and b under the assumption that this and b are non-negative, ie this >= 0 && b >= 0
     * @param b explicit BigInt input
     * @return BigInt instance that is the sum of this and b
     */
    private BigInt addPositive(BigInt b){
        LinkedList<Integer> result = new LinkedList<>();

        int i = 0;
        int j = 0;
        int carry = 0;

        while (i < this.ls.size() || j < b.ls.size() || carry > 0) {
            int dig1 = (i < this.ls.size()) ? this.ls.get(i) : 0;
            int dig2 = (j < b.ls.size()) ? b.ls.get(j) : 0;

            int sum = dig1 + dig2 + carry;

            result.add(sum % 10);
            carry = sum / 10;

            i++;
            j++;
        }

        BigInt sum = new BigInt("");
        sum.ls = result;
        sum.isNeg = false;
        return sum;
    }

    /**
     * returns the difference of this and b
     *
     * @param b2 explicit BigInt input
     * @return difference of this and b
     */
    BigInt sub(BigInt b2) {
        if (this.isNeg != b2.isNeg) {
            BigInt result = this.addPositive(b2);
            if (result.toString().equals("0")) result.isNeg = false;
            else result.isNeg = this.isNeg;
            return result;
        }

        if (this.absCompareTo(b2) >= 0) {
            BigInt result = this.subPositive(b2);
            if (result.toString().equals("0")) result.isNeg = false;
            else result.isNeg = this.isNeg;
            return result;
        } else {
            BigInt result = b2.subPositive(this);
            if (result.toString().equals("0")) result.isNeg = false;
            else result.isNeg = !this.isNeg;
            return result;
        }

    }

    /**
     * returns a BigInt instance that is the difference of this and b under the assumption that this and b are non-negative,
     * and the minuend is greater than or equal to the subtrahend, ie (this >= 0 && b >= 0) && this >= b
     * @param b explicit BigInt input
     * @return BigInt instance that is the difference of this and b
     */
    private BigInt subPositive(BigInt b){
        if (this.compareTo(b) == 0) {
            return new BigInt("0");
        }

        LinkedList<Integer> result = new LinkedList<>();

        int i = 0;
        int j = 0;
        int borrow = 0;

        while (i < this.ls.size() || j < b.ls.size()) {
            int dig1 = (i < this.ls.size()) ? this.ls.get(i) : 0;
            int dig2 = (j < b.ls.size()) ? b.ls.get(j) : 0;

            int diff = dig1 - dig2 - borrow;

            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.add(diff);

            i++;
            j++;
        }

        while (result.size() > 1 && result.getLast() == 0) {
            result.removeLast();
        }

        BigInt difference = new BigInt("");
        difference.ls = result;
        difference.isNeg = false;
        return difference;
    }


    /**
     * returns the product of this and b
     *
     * @param b2 explicit BigInt input
     * @return product of this and b
     */
    BigInt mul(BigInt b2) {
        if ((this.ls.size() == 1 && this.ls.get(0) == 0) || (b2.ls.size() == 1 && b2.ls.get(0) == 0)) {
            return new BigInt("0");
        }

        boolean resultSign = this.isNeg != b2.isNeg;
        int resultSize = this.ls.size() + b2.ls.size();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < resultSize; i++) {
            result.add(0);
        }

        for (int i = 0; i < this.ls.size(); i++) {
            int carry = 0;
            int dig1 = this.ls.get(i);

            for (int j = 0; j < b2.ls.size(); j++) {
                int dig2 = b2.ls.get(j);
                int sum = dig1 * dig2 + result.get(i + j) + carry;
                result.set(i + j, sum % 10);
                carry = sum / 10;
            }
            if (carry > 0) {
                result.set(i + b2.ls.size(), result.get(i + b2.ls.size()) + carry);
            }
        }

        while (result.size() > 1 && result.getLast() == 0) {
            result.removeLast();
        }

        BigInt product = new BigInt("");
        product.ls = result;
        product.isNeg = resultSign;
        return product;
    }

    /**
     * returns the quotient of this and divisor
     *
     * @param divisor explicit BigInt input
     * @return quotient of this and divisor
     */
    BigInt div(BigInt divisor){
        if (divisor.ls.size() == 1 && divisor.ls.getFirst() == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }

        boolean resultSign = this.isNeg != divisor.isNeg;

        BigInt dividend = new BigInt(this.toString());
        BigInt divisorAbs = new BigInt(divisor.toString());
        dividend.isNeg = false;
        divisorAbs.isNeg = false;

        BigInt quotient = new BigInt("0");
        BigInt remainder = new BigInt("0");

        for (int i = dividend.ls.size() - 1; i >= 0; i--) {
            remainder.ls.addFirst(dividend.ls.get(i));

            while (remainder.ls.size() > 1 && remainder.ls.getLast() == 0) {
                remainder.ls.removeLast();
            }

            int count = 0;
            while (remainder.absCompareTo(divisorAbs) >= 0) {

                int borrow = 0;
                for (int j = 0; j < remainder.ls.size(); j++) {
                    int dig1 = remainder.ls.get(j);
                    int dig2 = (j < divisorAbs.ls.size()) ? divisorAbs.ls.get(j) : 0;

                    int diff = dig1 - dig2 - borrow;
                    if (diff < 0) {
                        diff += 10;
                        borrow = 1;
                    } else {
                        borrow = 0;
                    }

                    remainder.ls.set(j, diff);
                }

                while (remainder.ls.size() > 1 && remainder.ls.getLast() == 0) {
                    remainder.ls.removeLast();
                }

                count++;
            }
            quotient.ls.addFirst(count);
        }

        while (quotient.ls.size() > 1 && quotient.ls.getLast() == 0) {
            quotient.ls.removeLast();
        }

        quotient.isNeg = resultSign;
        return quotient;
    }

    /**
     * Returns whether this instance and b have different signs
     * @param b explicit BigInt input
     * @return true if this and b have different signs, false otherwise
     */
    private boolean areDifferentSigns(BigInt b){
        return this.isNeg != b.isNeg;
    }


    /**
     * Creates a deep-copy of instance representing the same integer as this instance of BigInt
     *
     * @return instance representing the same integer as this instance of BigInt
     */
    BigInt copy() {
        return new BigInt(this.toString());
    }

    /**
     * Creates a deep-copy of instance representing the negated integer from this instance of BigInt
     *
     * @return instance representing the negated integer from this instance of BigInt
     */
    BigInt negate() {
        if (this.toString().equals("0")) return new BigInt("0");
        if (this.isNeg) return new BigInt(this.toString().substring(1));
        return new BigInt("-" + this);
    }
}
