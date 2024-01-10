package TP2D;

public enum Orientation {
    UP(2), DOWN(0), LEFT(1), RIGHT(3);
    private final int i;
    Orientation(int i) {
        this.i=i;
    }

    public int getI() {
        return i;
    }
}
