package ru.job4j.tracker.oop;

public class Triangle {
    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double semiPerimeter(double ab, double ac, double bc) {
        return (ab + ac + bc) / 2;
    }

    public boolean exist(double ab, double ac, double bc) {
        if (ab <= 0 || ac <= 0 || bc <= 0) {
            return false;
        }
        if ((ab + ac <= bc) || (ab + bc <= ac) || (ac + bc <= ab)) {
            return false;
        }
        return true;
    }

    public double area() {
        double rsl = -1;
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
            double p = semiPerimeter(ab, ac, bc);
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
        }
        return  rsl;
    }
}