package TP2D;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainInterface extends JFrame implements KeyListener {
    TileManager tileManager = new TileManager(48,48,"./img/tileSet.png");
    Dungeon dungeon = new Dungeon("./gameData/level1.txt",tileManager);
    Hero hero = Hero.getInstance();
    GameRender panel = new GameRender(dungeon,hero);
    public MainInterface() throws HeadlessException {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(panel);
        this.setVisible(true);
        this.setSize(new Dimension(dungeon.getWidth()* tileManager.getWidth(), dungeon.getHeight()*tileManager.getHeigth()));
        this.addKeyListener(this);

        ActionListener animationTimer=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        };
        Timer timer = new Timer(50,animationTimer);
        timer.start();
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
                hero.moveIfPossible(-7,0,dungeon);
                hero.setOrientation(Orientation.LEFT);
                hero.setWalking(true);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("Right");
                hero.moveIfPossible(7,0,dungeon);
                hero.setOrientation(Orientation.RIGHT);
                hero.setWalking(true);
                break;
            case KeyEvent.VK_UP:
                System.out.println("Up");
                hero.moveIfPossible(0,-7,dungeon);
                hero.setOrientation(Orientation.UP);
                hero.setWalking(true);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("Down");
                hero.moveIfPossible(0,7,dungeon);
                hero.setOrientation(Orientation.DOWN);
                hero.setWalking(true);
                break;
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        hero.setWalking(false);

    }
}
