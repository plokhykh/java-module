package multithreading.exchanger;

public class Consumer extends Subject implements Runnable {
    public Consumer(String name, Item item) {
        super(name, item);
    }

    @Override
    public void run() {
        try {
            int requiredNumber = this.getItem().getNumber();
            Item item = exchanger.exchange(this.getItem());
            if(requiredNumber >= item.getNumber()){
                System.out.println("Consumer " + getName() + " повышает стоимость товара");
            } else {
                System.out.println("Consumer " + getName() + " снижает стоимость товара");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
