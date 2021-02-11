package game;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GameCell extends JFrame {

    public static final int CELL_SIZE = 100;
    private int row;
    private int col;

    public GameCell(int row, int col) {

        this.row = row;
        this.col = col;
    }

    public int randomCell(){

        Random rand = new Random();
        int randCell = rand.nextInt(8);
        while (randCell == 2) {
            randCell= rand.nextInt(8);
        }
        return randCell;
    }
    
     void render(Graphics g) {
        greenCell(g);
        blueCell(g);
        randomCell();
    }

    /**
     * Метод визуализиращ GPS координати
     * @param g Graphics object
     */
    public void greenCell(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(100, 110, 100, 100);
        g.fillRect(100, 310, 100, 100);
        g.fillRect(200, 510, 100, 100);
        g.fillRect(300, 310, 100, 100);
        g.fillRect(500, 210, 100, 100);
        g.fillRect(600, 10,  100, 100);
        g.fillRect(600, 410, 100, 100);
        g.fillRect(600, 710, 100, 100);

        g.setColor(Color.green);
        g.drawRect(100, 110, 99, 99);
        g.drawRect(100, 310, 99, 99);
        g.drawRect(200, 510, 99, 99);
        g.drawRect(300, 310, 99, 99);
        g.drawRect(500, 210, 99, 99);
        g.drawRect(600, 10,  99, 99);
        g.drawRect(600, 410, 99, 99);
        g.drawRect(600, 710, 99, 99);

    }

    /**
     * Метод визуализиращ непроходимата територия
     * @param g Graphics object
     */
    public void blueCell(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(0,   510, 100, 100);
        g.fillRect(400, 110, 100, 100);
        g.fillRect(400, 610, 100, 100);
        g.fillRect(700, 210, 100, 100);
        g.fillRect(700, 510, 100, 100);

        g.setColor(Color.blue);
        g.drawRect(0,   510, 99, 99);
        g.drawRect(400, 110, 99, 99);
        g.drawRect(400, 610, 99, 99);
        g.drawRect(700, 210, 99, 99);
        g.drawRect(700, 510, 99, 99);
    }

    /**
     * Метод визуализаращ стартовия координат
     * @param g Graphics object
     */
    public void yellowCell(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(0, 710, 100, 100);

        g.setColor(Color.yellow);
        g.drawRect(0, 710, 99, 99);
    }
}
