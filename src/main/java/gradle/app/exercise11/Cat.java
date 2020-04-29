package gradle.app.exercise11;

public class Cat implements Animal {
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
