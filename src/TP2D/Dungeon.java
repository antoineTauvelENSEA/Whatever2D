package TP2D;

public class Dungeon {
    private final int height;
    private final int width;
    private final TileManager tileManager;
    char[][] map;
    public Dungeon(int height, int width) {
        this.height = height;
        this.width = width;
        this.tileManager = new TileManager(50,50);
        this.map = new char[width][height];
        for (int x=0;x<width;x++){
            for (int y=0;y<height;y++){
                if ((x==0)||(x==width-1)||(y==0)||(y==height-1)){
                    this.map[y][x]='W';
                }
                else {
                    this.map[y][x]=' ';
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
                    System.out.print((map[y][x]));
                }
            }
            System.out.println("");
        }

    }

}
