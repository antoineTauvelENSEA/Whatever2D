package TP2D;
public class HitBox {
    private final double height;
    private final double width;

    private double x;
    private double y;

    private String name;

    public HitBox(double x, double y, double width, double height){
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
    }

    public boolean intersect(HitBox anotherHitBox){
        HitBox upper = (this.y<anotherHitBox.y)?this :anotherHitBox;
        HitBox leftest = (this.x<anotherHitBox.x)?this :anotherHitBox;
        boolean xOverlap = Math.abs(x - anotherHitBox.x) < leftest.width;
        boolean yOverlap = Math.abs(y - anotherHitBox.y) < upper.height;

        //boolean xOverlap = Math.abs(x - anotherHitBox.x) < (width + anotherHitBox.width) / 2;
        //boolean yOverlap = Math.abs(y - anotherHitBox.y) < (height + anotherHitBox.height) / 2;

        return xOverlap && yOverlap;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(double dx, double dy){
        x=x+dx;
        y=y+dy;
    }
}
