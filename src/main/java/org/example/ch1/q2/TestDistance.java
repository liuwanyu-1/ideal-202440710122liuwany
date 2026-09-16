package org.example.ch1.q2;

@FunctionalInterface
interface Calculator {
    double calculate(Object o1, Object o2);
}

public class TestDistance {
    class InnerClass implements Calculator {
        @Override
        public double calculate(Object o1, Object o2) {
            Mpoint p1 = (Mpoint) o1;
            Mpoint p2 = (Mpoint) o2;
            double dx = p1.getX() - p2.getX();
            double dy = p1.getY() - p2.getY();
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    public static void main(String[] args) {
        Mpoint a = new Mpoint(1, 1);
        Mpoint b = new Mpoint(4, 5);

        Calculator c1 = new TestDistance().new InnerClass();
        System.out.println(c1.calculate(a, b));

        Calculator c2 = new Calculator() {
            @Override
            public double calculate(Object o1, Object o2) {
                Mpoint p1 = (Mpoint) o1;
                Mpoint p2 = (Mpoint) o2;
                double dx = p1.getX() - p2.getX();
                double dy = p1.getY() - p2.getY();
                return Math.sqrt(dx * dx + dy * dy);
            }
        };
        System.out.println(c2.calculate(a, b));

        Calculator c3 = (o1, o2) -> {
            Mpoint p1 = (Mpoint) o1;
            Mpoint p2 = (Mpoint) o2;
            double dx = p1.getX() - p2.getX();
            double dy = p1.getY() - p2.getY();
            return Math.sqrt(dx * dx + dy * dy);
        };
        System.out.println(c3.calculate(a, b));
    }
}
