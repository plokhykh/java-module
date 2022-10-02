package innerClasses;

import innerClasses.homeWork.Factorial;

public class Main {
    public static void main(String[] args) {



//        System.out.println(Operation.ADD.count(2, 5));
//        System.out.println(Operation.MINUS.ordinal());
//        CharSequence c = "hello";
//        String a = "hello";
//        "hello".toLowerCase();
//        a.toLowerCase();

        Outer in = new Outer().new Inner1();
        in.print();

        new Object(){
            public void hello(){
                System.out.println("Hello");
            }
        }.hello();

        Object obj = new Object(){
            public void hello(){
                System.out.println("Hello!");
            }
        };

        User user1 = new User();
        user1.greetings();

        User user2 = new User() {
            @Override
            public void greetings() {
                System.out.println("Bye-bye");
            }
        };

        user2.greetings();
    }

    enum Operation {
        ADD(3) {
            @Override
            long count(int a, int b) {
                return a + b;
            }
        },
        MINUS(4) {
            @Override
            long count(int a, int b) {
                return a - b;
            }
        },
        MULTIPLY(5) {
            @Override
            long count(int a, int b) {
                return (long) a * b;
            }
        },
        DIVIDE(6) {
            @Override
            long count(int a, int b) {
                return a / b;
            }
        };
        private int ordinal;

        Operation(int i) {
            this.ordinal = i;
        }

        public int getOrdinal (){
            return this.ordinal;
        }

        abstract long count(int a, int b);

    }


}
