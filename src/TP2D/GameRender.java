package TP2D;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameRender extends JPanel {
    private Dungeon dungeon;
    private DynamicThings hero;

    public GameRender(Dungeon dungeon, DynamicThings hero) {
        this.dungeon = dungeon;
        this.hero = hero;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Things t : dungeon.getRenderList()){
            t.draw(g);
        }
    }
}