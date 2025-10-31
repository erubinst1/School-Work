import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;

class ImageEditor extends JPanel {

    private final Stack<BufferedImage> UNDO_STACK;
    private final Stack<BufferedImage> REDO_STACK;
    private final JPanel IMAGE_PANEL;
    private final JMenuBar MENU_BAR;
    private final JScrollPane SCROLL_PANE;
    private final ShortcutKeyMap SHORTCUT_KEY_MAP;
    private final ZoomMouseEventListener ZOOM_LISTENER;
    private int zoomImageIndex;

    ImageEditor() {
        this.UNDO_STACK = new Stack<>();
        this.REDO_STACK = new Stack<>();
        this.SHORTCUT_KEY_MAP = new ShortcutKeyMap(this);
        this.IMAGE_PANEL = new ImagePanel(this);
        this.SCROLL_PANE = new JScrollPane(this.IMAGE_PANEL, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.MENU_BAR = new MenuBar(this);
        this.ZOOM_LISTENER = new ZoomMouseEventListener(this, this.IMAGE_PANEL);
        this.zoomImageIndex = 0;
        this.setLayout(new BorderLayout());
        this.add(this.MENU_BAR, BorderLayout.NORTH);
        this.add(this.SCROLL_PANE, BorderLayout.CENTER);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.IMAGE_PANEL.repaint();
    }

    @Override
    public void revalidate() {
        super.revalidate();
        if (this.IMAGE_PANEL != null) {
            this.IMAGE_PANEL.revalidate();
        }
    }

    /**
     * When given a file name that contains a PPM image specification,
     * reads the data into a new BufferedImage object and returns that image
     *
     * @param in input image file name
     */
    void readPpmImage(String in) {
        try ( Scanner sc = new Scanner( new FileReader(in))) {
            sc.nextLine();
            int width = sc.nextInt();
            int height = sc.nextInt();
            sc.nextLine();
            sc.nextLine();

            BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            for( int i = 0; i < height; i++){
                for( int j = 0; j < width; j++){
                    int r = sc.nextInt();
                    int g = sc.nextInt();
                    int b = sc.nextInt();
                    int rgb = new Color(r, g, b).getRGB();
                    img.setRGB(j, i, rgb);
                }
            }

            // Do not modify the lines below.
            this.UNDO_STACK.clear();
            this.REDO_STACK.clear();
            this.zoomImageIndex = 0;
            this.addImage(img);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found: " + e);
        }
    }

    /**
     * When given a file name, opens the file and writes out the PPM header data, then the image/pixel data
     *
     * @param out output file name
     */
    void writePpmImage(String out) {
        try (FileWriter writer = new FileWriter(out)) {
            BufferedImage img = this.getImage();

            writer.write("P3\n");
            int width = img.getWidth();
            int height = img.getHeight();
            int maxColorValue = 255;
            writer.write(width + " " + height + "\n");
            writer.write(maxColorValue + "\n");

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    Color color = new Color(img.getRGB(j, i));
                    int r = color.getRed();
                    int g = color.getGreen();
                    int b = color.getBlue();
                    writer.write(r + " " + g + " " + b + " ");
                }
                if (i < height - 1) {
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing PPM file: " + e);
        }
    }

    /**
     * Adds a new image to the editor and the undo stack. It is assumed that the image
     * being passed is not zoomed. If so, use the other addImage method.
     *
     * @param img image to add.
     */
    void addImage(BufferedImage img) {
        this.UNDO_STACK.push(img);
        this.REDO_STACK.clear();
        this.revalidate();
        this.repaint();
        this.zoomImageIndex++;
    }

    /**
     * Adds a new zoomed image to the editor. Because we only want to apply transformations
     * to non-zoomed images, we need to keep track of where the last non-zoomed image is in
     * the undo stack.
     *
     * @param img    image to add.
     * @param zoomed flag indicating whether the image is zoomed. This is always true.
     */
    void addImage(BufferedImage img, boolean zoomed) {
        this.UNDO_STACK.push(img);
        this.REDO_STACK.clear();
        this.revalidate();
        this.repaint();
        if (!zoomed) {
            this.zoomImageIndex++;
        }
    }

    /**
     * Removes the current image from the editor and the undo stack.
     * The undone image is pushed to the redo stack. If there are no images
     * to undo, this method does nothing.
     */
    void undoImage() {
        if (!this.UNDO_STACK.isEmpty()) {
            this.REDO_STACK.push(this.UNDO_STACK.pop());
            this.revalidate();
            this.repaint();
        }
    }

    /**
     * Redoes the last undone image. The redone image is pushed to the undo stack.
     * If there are no images to redo, this method does nothing.
     */
    void redoImage() {
        if (!this.REDO_STACK.isEmpty()) {
            this.UNDO_STACK.push(this.REDO_STACK.pop());
            this.revalidate();
            this.repaint();
        }
    }

    Stack<BufferedImage> getUndoStack() {
        return this.UNDO_STACK;
    }

    Stack<BufferedImage> getRedoStack() {
        return this.REDO_STACK;
    }

    BufferedImage getImage() {
        return this.UNDO_STACK.isEmpty() ? null : this.UNDO_STACK.peek();
    }

    BufferedImage getOriginalImage() {
        if (this.UNDO_STACK.isEmpty()) {
            return null;
        }
        if (this.zoomImageIndex < 1 || this.zoomImageIndex > this.UNDO_STACK.size()) {
            return this.UNDO_STACK.firstElement();
        }
        return this.UNDO_STACK.elementAt(this.zoomImageIndex - 1);
    }

    MenuBar getMenuBar() {
        return (MenuBar) MENU_BAR;
    }

    JScrollPane getScrollPane() {
        return this.SCROLL_PANE;
    }

    ZoomMouseEventListener getZoomListener() {
        return this.ZOOM_LISTENER;
    }
}
