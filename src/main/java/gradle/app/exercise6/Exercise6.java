package gradle.app.exercise6;

public class Exercise6 {
    public interface Subject {
        int request(int id);
    }

    public static class Proxy implements Subject {
        private Subject target;

        public Proxy(Subject s) {
            target = s;
        }

        public int request(int id) {
            System.out.println("Proxy log : " + id);
            int value = target.request(id);
            System.out.println("return value : " + value);
            return value;
        }

        public void setTarget(Subject realSubject) {
            this.target = realSubject;
        }
    }

    public static class RealSubject implements Subject {
        public int request(int id) {
            System.out.println("RealSubject.request : " + id);
            return id;
        }
    }

}
