class Point {
    private final int X;
    private final int Y;
    private final int Z;

    Point( int x, int y, int z){
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    //Accessors
    double getX(){
        return this.X;
    }

    double getY(){
        return this.Y;
    }

    double getZ(){
        return this.Z;
    }
}
