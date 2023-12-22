package TP2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.Date;

public final class Hero extends DynamicThings{

    private static volatile Hero instance = null;
    private Orientation orientation=Orientation.RIGHT;
    private boolean isWalking = false;

    private Hero() {
            super(120,120, 48,52);
            try{this.setImage(ImageIO.read(new File("img/heroTileSheet.png")));}
            catch (Exception e){
                e.printStackTrace();
            }
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

    public void moveIfPossible(double dx, double dy, Dungeon dungeon){
        boolean movePossible=true;
        this.getHitBox().move(dx,dy);
        for (Things things : dungeon.getRenderList()){
            if (things instanceof SolidThings){
                if(((SolidThings) things).getHitBox().intersect(this.getHitBox())){
                    movePossible=false;
                    break;
                }
            }
        }

        if (movePossible){
            this.x=x+dx;
            this.y=y+dy;
        }
        else{
            this.getHitBox().move(-dx,-dy);
        }
    }

    public void setWalking(boolean walking) {
        isWalking = walking;
    }

    @Override
    public void draw(Graphics g){
        int attitude = switch (orientation) {
            case UP -> 2;
            case DOWN -> 0;
            case LEFT -> 1;
            case RIGHT -> 3;
            default -> 0;
        };
        int index = (int) ((System.currentTimeMillis()/125)%10);
        index=isWalking?index:0;
        g.drawImage(image,(int)x,(int)y,(int)x+48,(int) y+ 52,index*96,100*attitude,(index+1)*96,100*(attitude+1),null,null);
    }
}