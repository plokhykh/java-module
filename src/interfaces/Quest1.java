package interfaces;


class Main{
        public static void main(String[] args) {
            Quest1 quest = new Quest1();
            Quest10 quest10 = quest;
            Quest100 quest100 = quest;
            System.out.println(quest10.returner()+" "+quest100.returner());
        }

    }

interface Quest10{
    Number returner();
}

abstract class Quest100 {
    public abstract Integer returner();
}

public class Quest1 extends Quest100 implements Quest10{
    @Override
    public Integer returner() {
        return null;
    }
}

