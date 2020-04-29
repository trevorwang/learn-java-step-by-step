package gradle.app.exercise9;

public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private int id;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        if (left.getId() > right.getId()) {
            this.left = right;
            this.right = left;
        } else {
            this.left = left;
            this.right = right;
        }


    }

    @Override
    public void run() {
        try {
            think();
            synchronized (left) {
                synchronized (right) {
                    eat();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eat() throws InterruptedException {
        System.out.println("Philosopher " + id + " --->> eating");
        System.out.flush();
        Thread.sleep(1000);
    }

    public void think() throws InterruptedException {
        System.out.println("Philosopher " + id + " --->> thinking");
        System.out.flush();
        Thread.sleep(1000);
    }
}
