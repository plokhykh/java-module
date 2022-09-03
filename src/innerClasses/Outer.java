package innerClasses;

public class Outer {
    public void print(){};
    class Inner1 extends Outer {
        public void print(){
            System.out.println("In inner");
        }
    }
}
