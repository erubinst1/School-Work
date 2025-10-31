import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SwirlMenuItem extends JMenuItem implements ActionListener {

    private final ImageEditor MAIN_PANEL;

    SwirlMenuItem(ImageEditor mainPanel) {
        super("Swirl");
        this.MAIN_PANEL = mainPanel;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int x = Integer.parseInt(JOptionPane.showInputDialog("Enter the x coordinate of the center of the swirl, top left is 0,0:"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Enter the y coordinate of the center of the swirl, top left is 0,0:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog("Enter the strength of the swirl, larger values mean more swirl, positive means clockwise, negative means counterclockwise:"));
        this.MAIN_PANEL.addImage(ImageOperations.swirl(MAIN_PANEL.getImage(), x, y, s));
        this.MAIN_PANEL.repaint();
    }
}