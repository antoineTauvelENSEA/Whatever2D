package TP2D;

import javax.swing.*;
import java.awt.*;

public class AnimatedThings extends SolidThings {
    public AnimatedThings(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public AnimatedThings(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void draw(Graphics g){

    }
}
