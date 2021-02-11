package game;

import javafx.scene.control.Cell;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Message.TextMessage;
import java.util.Random;

public class GameBoard extends JFrame implements MouseListener {

    public static final int CELL_SIDE_COUNT = 8;
    private GameCell[][] cells = new GameCell[8][8];
    private Object ChosenCell;
    private Cell chosenCell;

    public GameBoard() {

        this.setSize(800, 800);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.addMouseListener(this);

        Random random = new Random();
    }

    /**
     * @author Красимира Велева
     * Метод визуализиращ полетата на игралната дъска
     * @param g Graphics object
     */
    public void paint(Graphics g) {
        super.paint(g);
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (ChosenCell == null) {
                    g.setColor(Color.red);
                    g.fillRect(row, col, 800, 800);
                    g.setColor(Color.pink);
                    g.drawRect(row, col, 800, 800);
                }

                GameCell cell = new GameCell(row, col);
                cell.greenCell(g);
                cell.blueCell(g);
                cell.yellowCell(g);
                cell.render(g);
                cell.randomCell();
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = this.boardDimension(e.getY());
        int col = this.boardDimension(e.getX());

        if (this.ChosenCell != null) {
            this.repaint();
            return;
        } else {
            TextMessage.render(this, "Внимание", "Нямаш право да стъпваш тук");
        }

        if (this.isFull(row, col)) {
            this.ChosenCell = this.getPiece(row, col);
        }
    }

    private int boardDimension(int Disposition) {
        return Disposition / GameCell.CELL_SIZE;
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void renderGamePiece(Graphics g, int row, int col) {

        if(this.isFull(row, col)) {

            GameBoard g1 = (GameBoard) this.getPiece(row, col);
            g1.render(g);
        }
    }

    private void render(Graphics g) {
    }

    private Object getPiece(int row, int col) {
        return this.cells[row][col];
    }
    
    private boolean isFull(int row, int col){
        return this.getPiece(row, col) != null;
    }
}

