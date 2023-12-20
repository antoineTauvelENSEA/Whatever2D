package TP2D;

import javax.swing.*;
import java.awt.*;

public class SolidThings extends Things {
    protected HitBox hitBox;

    public SolidThings(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.hitBox = new HitBox(x,y,width,height);
    }

    public SolidThings(int x, int y, Image image) {
        super(x, y, image);
        this.hitBox=new HitBox(x,y, image.getWidth(null), image.getHeight(null));
    }

    public HitBox getHitBox() {
        return hitBox;
    }
}
