import java.util.List;

class Vector {

    private final List<Double> COMPONENTS;

    Vector(Point a, Point b) {
        this.COMPONENTS = List.of(b.getX() - a.getX(), b.getY() - a.getY(), b.getZ() - a.getZ());
    }

    Vector(double x, double y, double z) {
        this.COMPONENTS = List.of(x, y, z);
    }

    /**
     * Creates a new vector that is the corresponding unit vector to this
     *
     * @return corresponding unit vector
     */
    Vector unitVector() {
        double denominator = Math.sqrt( Math.pow(this.getA(), 2) + Math.pow(this.getB(), 2) + Math.pow(this.getC(), 2));
        if( denominator == 0){
            return new Vector(0, 0, 0);
        }
        return new Vector( (this.getA() / denominator), (this.getB() / denominator), (this.getC() / denominator));
    }

    /**
     * Computes the dot product between this vector and vector v
     *
     * @param v explicit vector input
     * @return dot product of this vector and vector v
     */
    double dotProduct(Vector v) {
        return (this.getA() * v.getA()) + (this.getB() * v.getB()) + (this.getC() * v.getC());
    }

    /**
     * Computes the cross product between this vector and vector v
     *
     * @param v explicit vector input
     * @return cross product between this vector and vector v
     */
    Vector crossProduct(Vector v) {
        double aComp = this.getB()*v.getC() - this.getC()*v.getB();
        double bComp = this.getC()*v.getA() - this.getA()*v.getC();
        double cComp = this.getA()*v.getB() - this.getB()*v.getA();
        return new Vector( aComp, bComp, cComp);
    }

    //Accessors.

    double getA(){
        return this.COMPONENTS.get(0);
    }

    double getB(){
        return this.COMPONENTS.get(1);
    }

    double getC(){
        return this.COMPONENTS.get(2);
    }

    List<Double> getVectorComponents(){
        return this.COMPONENTS;
    }

    //Overriding methods

    @Override
    public boolean equals(Object o){
        if( !(o instanceof Vector)){
            return false;
        }
        else{
            Vector othVector = (Vector) o;
            return this.COMPONENTS.equals(othVector.COMPONENTS);
        }
    }

    @Override
    public String toString(){
        return this.COMPONENTS.toString();
    }
}
