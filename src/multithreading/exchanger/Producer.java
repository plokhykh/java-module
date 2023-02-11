package multithreading.exchanger;

public class Producer extends Subject implements Runnable {
    public Producer(String name, Item item) {
        super(name, item);
    }

    @Override
    public void run() {
        try {
            int proposedNumber = this.getItem().getNumber();
            Item item = exchanger.exchange(this.getItem());
            if (proposedNumber <= item.getNumber()) {
                System.out.println("Producer " + getName() + " повышает план производства товара");
            } else {
                System.out.println("Producer " + getName() + " снижает план производства товара");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
