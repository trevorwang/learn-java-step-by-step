package gradle.app.exercise11;

public class Speaker implements Visitor {
    public void visit(Animal a) {
        a.accept(this);
    }

    public void visit(Dog d) {
        System.out.println("wang~");
    }

    public void visit(Cat c) {
        System.out.println("miao");
    }

    public void visit(Fox f) {
        System.out.println("woo~");
    }
}
