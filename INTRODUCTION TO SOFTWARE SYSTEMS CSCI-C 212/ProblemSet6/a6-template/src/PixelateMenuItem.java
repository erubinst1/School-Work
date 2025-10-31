import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PixelateMenuItem extends JMenuItem implements ActionListener {

    private final ImageEditor MAIN_PANEL;

    PixelateMenuItem(ImageEditor mainPanel) {
        super("Pixilate");
        this.MAIN_PANEL = mainPanel;
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of pixels you want per homogenized pixel:"));
        this.MAIN_PANEL.addImage(ImageOperations.pixilate(MAIN_PANEL.getImage(), n));
        this.MAIN_PANEL.repaint();
    }
}