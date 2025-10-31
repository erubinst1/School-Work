// Exercise 4.8

class Matrix {

    private int[][] matrix;

    Matrix( int m, int n, int[][] arr){
        matrix = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = arr[i][j];
            }
        }
    }

    //Accessors

    int[][] getMatrix(){
        return this.matrix;
    }

    int getRows(){
        return this.matrix.length;
    }

    int getCols(){
        return this.matrix[0].length;
    }

    /**
     * Sets the value at row i and column j to val, if in bounds
     *
     * @param i input integer row index
     * @param j input integer column index
     * @param val input int value to put into the matrix
     */
    void set(int i, int j, int val) {
        if( i < this.getRows() && j < getCols()){
            matrix[i][j] = val;
        }
    }

    /**
     * Attempts to add the values of the explicit matrix to the implicit matrix,
     * returns false and does nothing if they do not have the same dimensions
     *
     * @param m input matrix to add
     * @return true if this.matrix and m have the same dimensions, false otherwise
     */
    boolean add(Matrix m) {
        if(m.getMatrix().length == 0 || m.getMatrix()[0].length == 0){
            return true;
        }
        if( this.getRows() == m.getRows() && this.getCols() == m.getCols()){
            for(int i = 0; i < this.getRows(); i++){
                for(int j = 0; j < this.getCols(); j++){
                    this.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
                }
            }
            return true;
        }
        return false;
    }

    /**
     *Attempts to multiply the values of the explicit matrix to the implicit matrix,
     * returns false and does nothing if they do not have the same dimensions
     *
     * @param m input matrix to multiply by
     * @return true if this.matrix and m have the proper dimensions for multiplication, false otherwise
     */
    boolean multiply(Matrix m) {
        if(m.getMatrix().length == 0 || m.getMatrix()[0].length == 0){
            return true;
        }

        if( this.getRows() == m.getCols() && this.getCols() == m.getRows()){

            Matrix result = new Matrix(this.getRows(), m.getCols(), new int[m.getCols()][this.getRows()]);

            for(int j = 0; j < m.getCols(); j++){
                for(int i = 0; i < this.getRows(); i++){
                    int sum = 0;
                    for(int k = 0; k < this.getCols(); k++){
                        sum += this.matrix[i][k] * m.matrix[k][j];
                    }
                    result.matrix[i][j] = sum;
                    sum = 0;
                }
            }
            this.matrix = result.matrix;
            return true;
        }
        return false;
    }

    /**
     * transposes the matrix, rows become columns and columns become rows
     */
    void transpose() {
        if(!(this.getRows() == 0 || this.getCols() == 0)){
            int[][] transposed = new int[this.getCols()][this.getRows()];

            for(int i = 0; i < this.getRows(); i++){
                for(int j = 0; j < this.getCols(); j++){
                    transposed[j][i] = this.matrix[i][j];
                }
            }

            this.matrix = transposed;
        }
    }

    /**
     * Rotates the matrix 90 degrees clockwise
     */
    void rotate() {
        if(this.getRows() == 0 || this.getCols() == 0){
            return;
        }

        this.transpose();
        int[][] rotated = this.getMatrix();
        int rowsr = rotated.length;
        int colsr = rotated[0].length;

        for (int i = 0; i < rowsr; i++) {
            for (int j = 0; j < colsr / 2; j++) {
                int temp = rotated[i][j];
                rotated[i][j] = rotated[i][colsr - 1 - j];
                rotated[i][colsr - 1 - j] = temp;
            }
        }

        this.matrix = rotated;
    }

    /**
     * Overridden toString method to print in a format that is more useful in this context
     *
     * @return string representation of the object.
     */
    @Override
    public String toString() {
        String format = "[";
        for(int i = 0; i < this.getRows(); i++){
            if( i == 0){
                format += "[";
            }
            for(int j = 0; j < this.getCols(); j++){
                if(j == this.getCols()-1){
                    format += this.matrix[i][j] ;
                }
                else{
                    format += this.matrix[i][j] + ", ";
                }

            }
            if( i == this.getRows()-1){
                format += "]";
            }
            else{
                format += "], [";
            }
        }
        format += "]";

        return format;
    }
}
