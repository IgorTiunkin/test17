package com.example.test17.records;

public final class Rectangle1 {
    private final double length;
    private final double width;

    public Rectangle1(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double length() { return this.length; }
    double width()  { return this.width; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle1 rectangle = (Rectangle1) o;
        if (Double.compare(length, rectangle.length) != 0) return false;
        return Double.compare(width, rectangle.width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(length);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Rectangle1{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
