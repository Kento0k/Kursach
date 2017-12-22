package Kursovi4koff;

import java.util.Random;
/*Класс поле. Каждый объект такого класса содержит координаты всех препятствий и размеры поля*/
public class Field {
    int[][] matrix;
    int width;
    int heigth;
    Random rnd= new Random();
    public Field(int width, int heigth){
        this.width= width;
        this.heigth= heigth;
        this.matrix= new int[heigth][width];
    }
}
