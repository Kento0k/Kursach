package Kursovi4koff;
import org.junit.Test;
import org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import org.junit.Before;

import static Kursovi4koff.Algorhytms.*;
import static org.junit.Assert.assertEquals;
public class TestSq {
    Field field = new Field(3, 3);
    List<Answer> answers=new ArrayList<>();
    @Test
    public void firstTest(){// Все поле забито
        List<Answer> answers=new ArrayList<>();
        for(int i=0; i<field.heigth; i++){
            for(int j=0; j<field.width; j++)
                field.matrix[i][j]=1;
        }
        answers= findRectangle(field);
        assertEquals(0, answers.get(0).square);
    }
    @Test
    public void secondTest(){// Все поле свободно
        answers= findRectangle(field);
        assertEquals(9, answers.get(0).square);
    }
    @Test
    public void thirdTest(){ // 3 ответа
        int size;
        int square;
        field.matrix[0][0]=1;
        field.matrix[1][2]=1;
        field.matrix[2][0]=1;
        field.matrix[2][1]=1;
        answers= findRectangle(field);
        size=answers.size();
        square=answers.get(0).square;
        assertEquals(3, size);
        assertEquals(2, square);
    }
    @Test
    public void fourthTest(){
        int square;
        field.matrix[0][0]=1;
        field.matrix[2][0]=1;
        field.matrix[2][1]=1;
        answers= findRectangle(field);
        square=answers.get(0).square;
        assertEquals(4, square);
    }
    @Test
    public void fifthTest(){
        int x1, x2;
        int y1, y2;
        field.matrix[0][0]=1;
        field.matrix[2][0]=1;
        field.matrix[2][1]=1;
        answers= findRectangle(field);
        x1= answers.get(0).x1;
        x2= answers.get(0).x2;
        y1= answers.get(0).y1;
        y2= answers.get(0).y2;
        assertEquals(2, x1);
        assertEquals(3, x2);
        assertEquals(1, y1);
        assertEquals(2, y2);
    }
}
