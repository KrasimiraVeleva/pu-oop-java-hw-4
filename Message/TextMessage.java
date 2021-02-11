package Message;

import javax.swing.*;

public class TextMessage extends JDialog {

    public TextMessage(JFrame parent, String heading, String message) {
        super(parent, heading, true);

        JPanel panel = new JPanel();
        JLabel label = new JLabel(message);

        panel.add(label);
        getContentPane().add(panel);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setSize(200, 100);
        setVisible(true);
    }

    public static void render(JFrame parent, String heading, String message) {
        new TextMessage(parent, heading, message);
    }
}
