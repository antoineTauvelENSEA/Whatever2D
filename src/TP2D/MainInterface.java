package TP2D;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class MainInterface extends JFrame {
    Dungeon dungeon = new Dungeon(7,8);
    Hero hero = Hero.getInstance();
    GameRender panel = new GameRender(dungeon,hero);
    public MainInterface() throws HeadlessException {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.setSize(new Dimension(400,600));
    }

    public static void main(String[] args){
        MainInterface mainInterface = new MainInterface();
    }
}
