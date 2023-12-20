package TP2D;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainInterface extends JFrame implements KeyListener {
    Dungeon dungeon = new Dungeon(7,8);
    Hero hero = Hero.getInstance();
    GameRender panel = new GameRender(dungeon,hero);
    public MainInterface() throws HeadlessException {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.setSize(new Dimension(400,600));
        this.addKeyListener(this);
    }

    public static void main(String[] args){
        MainInterface mainInterface = new MainInterface();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                System.out.println("Left");
                hero.move(10,0);
                hero.setOrientation(Orientation.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                hero.move(-10,0);
                hero.setOrientation(Orientation.RIGHT);
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up");
                hero.move(0,-10);
                hero.setOrientation(Orientation.UP);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down");
                hero.move(0,10);
                hero.setOrientation(Orientation.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
