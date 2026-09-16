package org.example.ch1.q2;

public class Mpoint {
    private double x;
    private double y;

    public Mpoint() {}

    public Mpoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Mpoint mpoint = (Mpoint) obj;
        return Double.compare(mpoint.x, x) == 0 && Double.compare(mpoint.y, y) == 0;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}