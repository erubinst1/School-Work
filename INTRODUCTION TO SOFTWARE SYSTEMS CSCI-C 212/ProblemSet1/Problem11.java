// Exercise 2.12

class Problem11 {

    /**
     *Uses logic following the conditional connective
     *
     * @param p first boolean
     * @param q second boolean
     * @return boolean schema answer
     */
    static boolean cond( boolean p, boolean q){
        if( p && !q )
            return false;
        return true;
    }

    /**
     *Uses logic following the biconditional connective
     *
     * @param p first boolean
     * @param q second boolean
     * @return boolean schema answer
     */
    static boolean bicond( boolean p, boolean q){
        return (p&&q) || (!p&&!q);
    }

    /**
     * Uses logic following the joint connective
     *
     * @param p first boolean
     * @param q second boolean
     * @return boolean schema answer
     */
    static boolean and( boolean p, boolean q){
        return p&&q;
    }

    /**
     *Uses logic following the disjunction connective
     *
     * @param p first boolean
     * @param q second boolean
     * @return boolean schema answer
     */
    static boolean or( boolean p, boolean q){
        return p|q;
    }

    /**
     *Uses logic following the negation connective
     *
     * @param p boolean to be negated
     * @return negated boolean
     */
    static boolean not( boolean p ){
        return !p;
    }

}
