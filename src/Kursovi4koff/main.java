package Kursovi4koff;
import java.util.*;
public class main {
    public static void main(String[] args) {
        int height, width;
        int square;
        Random rnd= new Random();
        width=10;
        height=5;
        Field field= new Field(width, height);
        List<List<Integer>> dynamics= new ArrayList<>();
        System.out.println("Field: ");
        for(int i=0; i<height;i++){
            for(int j=0; j<width;j++){
                System.out.print(field.matrix[i][j]+" ");
            }
            System.out.println("");
        }
        List<Answer> myAnswer= Algorhytms.findRectangle(field);
        for(Answer i: myAnswer) {
            System.out.println("Square= " + i.square);
            System.out.println("x1= " + i.x1);
            System.out.println("y1= " + i.y1);
            System.out.println("x2= " + i.x2);
            System.out.println("y2= " + i.y2);
        }
    }
}
