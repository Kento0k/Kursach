package Kursovi4koff;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Algorhytms {
    static Random rnd = new Random();

    /*Рассчет верхних динамик для строки. Верхняя динамика показывает строку . в которой
     содержится ближайшее занятое сверху поле для каждого элемента*/
    private static List<Integer> lineDynamics(Field field, int line, List<Integer> dynamic) {
        List<Integer> resultDynamic= new ArrayList<>();
        resultDynamic.addAll(dynamic);
        for (int i = 0; i < field.width; i++) {
                if(field.matrix[line][i]==1)
                    resultDynamic.set(i, line);
            }
        return resultDynamic;
    }
    /*Рассчет левых динамик для подстолбцов. Левая динамика показывает, до какого столбца можно
     сдвинуть влево каждый свободный подстолбец, берущий начало в текущей строке*/
    private static List<Integer> leftSideDynamics(Field field, List<Integer>lineDynamic, List<Integer> dynamic){
        List<Integer> resultDynamic= new ArrayList<>();
        resultDynamic.addAll(dynamic);
        Stack<Integer> findSideStack = new Stack<>();
        for(int i=0; i<field.width; ++i){
            while(!findSideStack.empty() && lineDynamic.get(findSideStack.peek())<=lineDynamic.get(i))
                findSideStack.pop();
            if(findSideStack.empty())
                resultDynamic.set(i, -1);
            else
                resultDynamic.set(i, findSideStack.peek());
            findSideStack.push(i);
        }
        return resultDynamic;
    }
    /*Рассчет правых динамик для подстолбцов. Левая динамика показывает, до какого столбца можно
     сдвинуть вправо каждый свободный подстолбец, берущий начало в текущей строке*/
    private static List<Integer> rightSideDynamics(Field field, List<Integer>lineDynamic, List<Integer> dynamic){
        List<Integer> resultDynamic= new ArrayList<>();
        resultDynamic.addAll(dynamic);
        Stack<Integer> findSideStack = new Stack<>();
        for(int i=field.width-1; i>=0; --i){
            while(!findSideStack.empty() && lineDynamic.get(findSideStack.peek())<=lineDynamic.get(i))
                findSideStack.pop();
            if(findSideStack.empty())
                resultDynamic.set(i, field.width);
            else
                resultDynamic.set(i, findSideStack.peek());
            findSideStack.push(i);
        }
        return resultDynamic;
    }
    /*Поиск искомых прямоугольников*/
    static List<Answer> findRectangle(Field field){
        List<Integer> topDynamic= new ArrayList<>();
        List<Integer> leftDynamic= new ArrayList<>();
        List<Integer> rightDynamic= new ArrayList<>();
        List<Answer> answers=new ArrayList<>();
        int square=0, resultSquare=0;
        int x1=0, y1=0;
        int x2=0, y2=0;
        // Инициализация динамик первой строки
        for(int i=0; i<field.width; i++) {
            topDynamic.add(i, -1);
            leftDynamic.add(i, -1);
            rightDynamic.add(i, field.width);
        }
        for(int i=0; i<field.heigth; i++){
            //Для каждой строки рассчитываем ее левые, правые и верхние динамики
            topDynamic= lineDynamics(field, i, topDynamic);
            leftDynamic= leftSideDynamics(field, topDynamic, leftDynamic);
            rightDynamic= rightSideDynamics(field, topDynamic, rightDynamic);
            for(int j=0; j<field.width; ++j){
                /*считаем площадь максимального прямоугольника для каждого подстолбца*/
                 square=  (i-topDynamic.get(j))*(rightDynamic.get(j)-leftDynamic.get(j)-1);
                 if(square>resultSquare){
                     resultSquare= square;
                     x1=(leftDynamic.get(j)+1)+1;
                     y1=(topDynamic.get(j)+1)+1;
                     x2=(rightDynamic.get(j)-1)+1;
                     y2=i+1;
                     if(!answers.isEmpty()){
                         answers.clear();
                     }
                     Answer myAnswer= new Answer(resultSquare, x1, y1, x2, y2);
                     answers.add(myAnswer);
                 }
                 /*Проверяем, не повторяются ли результаты при равенстве площадей*/
                 if(square==resultSquare){
                     x1=(leftDynamic.get(j)+1)+1;
                     y1=(topDynamic.get(j)+1)+1;
                     x2=(rightDynamic.get(j)-1)+1;
                     y2=i+1;
                     boolean repeat=false;
                     Answer myAnswer= new Answer(square, x1, y1, x2, y2);
                     for(Answer k: answers) {
                         if (k.equal(myAnswer)) {
                             repeat=true;
                             break;
                         }
                     }
                     if(!repeat)
                         answers.add(myAnswer);
                 }
            }
        }
        return answers;
    }
}
