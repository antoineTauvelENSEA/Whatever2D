package TP2D;

import java.awt.*;

public class Things {
    protected double x;
    protected double y;
    protected int width;
    protected int height;

    protected Image image;

    public Things(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Things(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    public void draw(Graphics g){
        g.drawImage(image,(int) x,(int) y,null);
    }

}
