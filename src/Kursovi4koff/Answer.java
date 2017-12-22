package Kursovi4koff;
/*Класс ответ. Каждый объект такого класса содержит необходимые результаты. Есть проверка на повторы*/
public class Answer {
    int square;
    int x1;
    int y1;
    int x2;
    int y2;
    public Answer(int square, int x1, int y1, int x2, int y2){
        this.square= square;
        this.x1= x1;
        this.y1= y1;
        this.x2= x2;
        this.y2= y2;
    }

    public boolean equal(Answer anotherAnswer) {
        if(this.x1==anotherAnswer.x1){
            if(this.y1==anotherAnswer.y1){
                if(this.x2==anotherAnswer.x2){
                    if(this.y2==anotherAnswer.y2)
                        return true;
                }
            }
        }
        return false;
    }
}
