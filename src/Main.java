import TP2D.Dungeon;
import TP2D.HitBox;
import TP2D.TileManager;

public class Main {

    public static void main(String[] args){
        HitBox hero= new HitBox(10,75, 34,70);
        HitBox wall= new HitBox(45,75,10,70);
        System.out.println(hero.intersect(wall));
        System.out.println(wall.intersect(hero));

        Dungeon dungeon = new Dungeon(10,10);
        dungeon.displayDungeonInConsole(hero);
    }
}
