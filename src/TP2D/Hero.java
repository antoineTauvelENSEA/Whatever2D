package TP2D;

import javax.imageio.ImageIO;
import java.io.File;

public final class Hero extends DynamicThings{

    private static volatile Hero instance = null;
    private Orientation orientation;

    private Hero() {
            super(32,32, 32,320);
    }

    public final static Hero getInstance() {
        if (Hero.instance == null) {
            synchronized(Hero.class) {
                if (Hero.instance == null) {
                    Hero.instance = new Hero();
                }
            }
        }
        return Hero.instance;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}