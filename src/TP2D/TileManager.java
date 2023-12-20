package TP2D;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class TileManager {
    private final int width;
    private final int heigth;

    private Image[][] tiles;
    private BufferedImage tileSheet;

    public TileManager(int width, int height) {
        this.width = width;
        this.heigth = height;
        setTiles(width, height, "./img/tileSetTest.png");
    }

    public TileManager(int width, int height, String fileName){
        this.width = width;
        this.heigth = height;
        setTiles(width, height, fileName);
    }

    private void setTiles(int width, int height, String fileName){
        try{
            tileSheet = ImageIO.read(new File(fileName));}
        catch (Exception e){
            e.printStackTrace();
        }
        tiles = new Image[tileSheet.getWidth()/width][tileSheet.getHeight()/height];
        for(int y=0;y+heigth<tileSheet.getHeight();y=y+height) {
            for (int x = 0; x +width < tileSheet.getWidth(); x = x + width) {
                tiles[x / width][y / height] = tileSheet.getSubimage(x, y, width, height);
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public Image getTile(int x, int y){
        return tiles[x][y];
    }
}
