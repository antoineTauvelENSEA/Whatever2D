package TP2D;

import java.util.ArrayList;

public class Dungeon {
    private final int height;
    private final int width;
    private final TileManager tileManager;
    private ArrayList <Things> renderList = new ArrayList<>();

    private char[][] map;
    public Dungeon(int height, int width) {
        this.height = height;
        this.width = width;
        this.tileManager = new TileManager(32,32);
        this.map = new char[width][height];
        for (int x=0;x<width;x++){
            for (int y=0;y<height;y++){
                if ((x==0)||(x==width-1)||(y==0)||(y==height-1)){
                    this.map[x][y]='W';
                }
                else {
                    this.map[x][y]=' ';
                }
            }
        }
        respawnListOfThings();
    }

    public Dungeon(int height, int width, TileManager tileManager) {
        this.height = height;
        this.width = width;
        this.tileManager = tileManager;
        this.map = new char[width][height];
        for (int x=0;x<width;x++){
            for (int y=0;y<height;y++){
                if ((x==0)||(x==width-1)||(y==0)||(y==height-1)){
                    this.map[x][y]='W';
                }
                else {
                    this.map[x][y]=' ';
                }
            }
        }
        respawnListOfThings();
    }
    private void respawnListOfThings(){
        renderList.clear();
        for (int x=0;x<width;x++){
            for (int y=0;y<height;y++){
                switch (this.map[x][y]){
                    case ' ' :  renderList.add(new Things(x* tileManager.getWidth(),y* tileManager.getHeigth(), tileManager.getTile(0,2)));
                                break;
                    case 'W' :  renderList.add(new SolidThings(x* tileManager.getWidth(),y* tileManager.getHeigth(), tileManager.getTile(0,0)));
                                break;
                    case 'E' :  renderList.add(new SolidThings(x* tileManager.getWidth(),y* tileManager.getHeigth(), tileManager.getTile(0,1)));
                                break;
                }
            }
        }
    }

    public void displayDungeonInConsole(HitBox hero){
        for(int y=0;y<height;y++){
            for(int x=0;x<width;x++){
                if (x==(hero.getX()/ tileManager.getWidth()) && y==(hero.getY()/ tileManager.getHeigth())) {
                    System.out.print("H");
                }
                else {
                    System.out.print((map[x][y]));
                }
            }
            System.out.println("");
        }

    }

    public ArrayList<Things> getRenderList() {
        return renderList;
    }
}
