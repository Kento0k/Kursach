package Kursovi4koff;

import java.util.Random;

public class Field {
    int[][] matrix;
    int width;
    int heigth;
    Random rnd= new Random();
    public Field(int width, int heigth){
        this.width= width;
        this.heigth= heigth;
        this.matrix= new int[heigth][width];
        int busyWidth, busyHeigth;
        /*for(int i=0; i<width*heigth/2; i++){
            busyHeigth= rnd.nextInt(heigth);
            busyWidth= rnd.nextInt(width);
            matrix[busyHeigth][busyWidth]=1;
        }*/
    }
}
