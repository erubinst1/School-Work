class Line {

    private final Point INITIAL;
    private final Vector DIRECTION;

    Line(Point p, Vector v){
        this.INITIAL = p;
        this.DIRECTION = v;
    }

    /**
     * Creates a parameterized string of the x component of the parametric equation of this line
     *
     * @return parameterized string of the x component of the parametric equation of this line
     */
    String paramX() {
        if(this.getX() == 0.0 && this.getA() == 0.0){
            return "x = 0";
        }
        else if( this.getX() == 0.0){
            return "x = " + this.getA() + "t";
        }
        else if( this.getA() == 0.0){
            return "x = " + this.getX();
        }
        else if( this.getA() < 0){
            return "x = " + this.getX() + " - " + Math.abs(this.getA()) + "t";
        }
        else{
            return "x = " + this.getX() + " + " + this.getA() + "t";
        }
    }

    /**
     * Creates a parameterized string of the y component of the parametric equation of this line
     *
     * @return parameterized string of the y component of the parametric equation of this line
     */
    String paramY() {
        if(this.getY() == 0.0 && this.getB() == 0){
            return "y = 0";
        }
        else if( this.getY() == 0.0){
            return "y = " + this.getB() + "t";
        }
        else if( this.getB() == 0.0){
            return "y = " + this.getY();
        }
        else if( this.getB() < 0){
            return "y = " + this.getY() + " - " + Math.abs(this.getB()) + "t";
        }
        else{
            return "y = " + this.getY() + " + " + this.getB() + "t";
        }
    }

    /**
     * Creates a parameterized string of the z component of the parametric equation of this line
     *
     * @return parameterized string of the z component of the parametric equation of this line
     */
    String paramZ() {
        if(this.getZ() == 0.0 && this.getC() == 0){
            return "z = 0";
        }
        else if( this.getZ() == 0.0){
            return "z = " + this.getC() + "t";
        }
        else if( this.getC() == 0.0){
            return "z = " + this.getZ();
        }
        else if( this.getC() < 0){
            return "z = " + this.getZ() + " - " + Math.abs(this.getC()) + "t";
        }
        else{
            return "z = " + this.getZ() + " + " + this.getC() + "t";
        }
    }

    /**
     * Converts a line into a 3x2 matrix representing its parametric equations
     * @return 3x2 matrix representing its parametric equations
     */
    double[][] parameterize() {
        return new double[][] {new double[] {this.getX(), this.getA()},
                               new double[] {this.getY(), this.getB()},
                               new double[] {this.getZ(), this.getC()}
        };
    }

    //Accessors
    double getX(){
       return this.INITIAL.getX();
    }
    double getY(){
        return this.INITIAL.getY();
    }
    double getZ(){
        return this.INITIAL.getZ();
    }

    double getA(){
        return this.DIRECTION.getA();
    }
    double getB(){
        return this.DIRECTION.getB();
    }
    double getC(){
        return this.DIRECTION.getC();
    }
}
