import java.awt.*;
import java.awt.image.BufferedImage;

class ImageOperations {

    /**
     * Removes the red channel from the colors of an image
     *
     * @param img input image
     * @return image with red removed
     */
    static BufferedImage zeroRed(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for( int i = 0; i < height; i++){
            for( int j = 0; j < width; j++){
                int rgb = img.getRGB(j, i);
                Color c = new Color(rgb);
                int g = c.getGreen();
                int b = c.getBlue();

                Color noRed = new Color(0, g, b);
                newImg.setRGB(j, i, noRed.getRGB());
            }
        }
        return newImg;
    }

    /**
     * Converts an image to grayscale
     *
     * @param img input image
     * @return Grayscaled image
     */
    static BufferedImage grayscale(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for( int i = 0; i < height; i++){
            for( int j = 0; j < width; j++){
                int rgb = img.getRGB(j, i);
                Color c = new Color(rgb);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int avg = (r+g+b)/3;

                Color gray = new Color(avg, avg, avg);
                newImg.setRGB(j, i, gray.getRGB());
            }
        }
        return newImg;
    }

    /**
     * Inverts an image
     * @param img input image
     * @return inverted image
     */
    static BufferedImage invert(BufferedImage img) {
        int width = img.getWidth();
        int height = img.getHeight();
        int maxColorValue = 255;

        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for( int i = 0; i < height; i++){
            for( int j = 0; j < width; j++){
                int rgb = img.getRGB(j, i);
                Color c = new Color(rgb);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();

                int invR = maxColorValue - r;
                int invG = maxColorValue - g;
                int invB = maxColorValue - b;

                Color inverted = new Color(invR, invG, invB);
                newImg.setRGB(j, i, inverted.getRGB());
            }
        }
        return newImg;
    }

    /**
     * Mirrors an image vertically or horizontally
     *
     * @param img input image
     * @param dir mirror direction
     * @return mirrored image
     */
    static BufferedImage mirror(BufferedImage img, MirrorMenuItem.MirrorDirection dir) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        if (dir == MirrorMenuItem.MirrorDirection.VERTICAL) {
            for( int i = 0; i < height; i++){
                for( int j = 0; j < width/2; j++){
                    int rgb = img.getRGB(j,i);
                    newImg.setRGB(width-j-1, i, rgb);
                }
                for( int j = 0; j < width/2; j++){
                    int rgb = img.getRGB(j,i);
                    newImg.setRGB(j, i, rgb);
                }
            }
        } else {
            for( int i = 0; i < height/2; i++){
                for( int j = 0; j < width; j++){
                    int rgb = img.getRGB(j,i);
                    newImg.setRGB(j, height-i-1, rgb);
                }
            }
            for( int i = 0; i < height/2; i++){
                for( int j = 0; j < width; j++){
                    int rgb = img.getRGB(j,i);
                    newImg.setRGB(j, i, rgb);
                }
            }
        }
        return newImg;
    }

    /**
     * Rotates an image 90 degrees clockwise or counterclockwise
     *
     * @param img input image
     * @param dir rotation direction
     * @return rotated image
     */
    static BufferedImage rotate(BufferedImage img, RotateMenuItem.RotateDirection dir) {
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        if (dir == RotateMenuItem.RotateDirection.CLOCKWISE) {
            for(int i = 0; i < height; i++){
                for( int j = 0; j < width; j++){
                    int rgb = img.getRGB(j,i);
                    newImg.setRGB(height-i-1, j, rgb);
                }
            }
        } else {
            for(int i = 0; i < height; i++){
                for( int j = 0; j < width; j++){
                    int rgb = img.getRGB(j,i);
                    newImg.setRGB(i, width - j - 1, rgb);
                }
            }
        }
        return newImg;
    }

    /**
     * Repeats an image n number of times, vertically or horizontally
     *
     * @param img input image
     * @param n   integer input number of repetitions
     * @param dir direction of repetition
     * @return repeated image
     */
    static BufferedImage repeat(BufferedImage img, int n, RepeatMenuItem.RepeatDirection dir) {
        BufferedImage newImg = null;
        int width = img.getWidth();
        int height = img.getHeight();

        if (dir == RepeatMenuItem.RepeatDirection.HORIZONTAL) {
            newImg = new BufferedImage(width*n, height, BufferedImage.TYPE_INT_RGB);
            for (int i = 0; i < height; i++) {
                for (int repeat = 0; repeat < n; repeat++) {
                    for (int j = 0; j < width; j++) {
                        int rgb = img.getRGB(j, i);
                        newImg.setRGB(repeat * width + j, i, rgb);
                    }
                }
            }
        } else {
            newImg = new BufferedImage(width, height*n, BufferedImage.TYPE_INT_RGB);
            for (int repeat = 0; repeat < n; repeat++) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        int rgb = img.getRGB(j, i);
                        newImg.setRGB(j, repeat * height + i, rgb);
                    }
                }
            }
        }
        return newImg;
    }

    /** pixilates an image by the given pixelation factor, ex: if the pixilation factor is 2, every two pixels will be homogenized
     *
     * @param img input image
     * @param pixelationFactor number of pixels to be homogenized
     * @return pixilated image
     */
    static BufferedImage pixilate(BufferedImage img, int pixelationFactor){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < height; i += pixelationFactor) {
            for (int j = 0; j < width; j += pixelationFactor) {
                int combR = 0;
                int combG = 0;
                int combB = 0;
                int count = 0;

                for (int di = 0; di < pixelationFactor; di++) {
                    for (int dj = 0; dj < pixelationFactor; dj++) {
                        int pixelX = j + dj;
                        int pixelY = i + di;
                        if (pixelX < width && pixelY < height) {
                            int rgb = img.getRGB(pixelX, pixelY);
                            Color c = new Color(rgb);
                            combR += c.getRed();
                            combG += c.getGreen();
                            combB += c.getBlue();
                            count++;
                        }
                    }
                }

                int avgR = combR / count;
                int avgG = combG / count;
                int avgB = combB / count;
                Color avgColor = new Color(avgR, avgG, avgB);

                for (int di = 0; di < pixelationFactor; di++) {
                    for (int dj = 0; dj < pixelationFactor; dj++) {
                        int pixelX = j + dj;
                        int pixelY = i + di;
                        if (pixelX < width && pixelY < height) {
                            newImg.setRGB(pixelX, pixelY, avgColor.getRGB());
                        }
                    }
                }
            }
        }

        return newImg;
    }

    /**
     * Applies a swirl effect to an image.
     *
     * @param img input image
     * @param centerX x-coordinate of the swirl center
     * @param centerY y-coordinate of the swirl center
     * @param strength controls the intensity of the swirl
     * @return image with the swirl effect applied
     */
    static BufferedImage swirl(BufferedImage img, int centerX, int centerY, double strength) {
        int width = img.getWidth();
        int height = img.getHeight();
        BufferedImage newImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double disx = x - centerX;
                double disy = y - centerY;
                double distance = Math.sqrt(disx * disx + disy * disy);

                double angle = Math.atan2(disy, disx) + (strength * distance / width);

                int crtX = (int) (centerX + distance * Math.cos(angle));
                int crtY = (int) (centerY + distance * Math.sin(angle));

                if (crtX >= 0 && crtX < width && crtY >= 0 && crtY < height) {
                    newImg.setRGB(x, y, img.getRGB(crtX, crtY));
                } else {
                    newImg.setRGB(x, y, Color.BLACK.getRGB());
                }
            }
        }
        return newImg;
    }

    /**
     * Zooms in on the image. The zoom factor increases in multiplicatives of 10% and
     * decreases in multiplicatives of 10%.
     *
     * @param img        the original image to zoom in on. The image cannot be already zoomed in
     *                   or out because then the image will be distorted.
     * @param zoomFactor The factor to zoom in by.
     * @return the zoomed in image.
     */
    static BufferedImage zoom(BufferedImage img, double zoomFactor) {
        int newImageWidth = (int) (img.getWidth() * zoomFactor);
        int newImageHeight = (int) (img.getHeight() * zoomFactor);
        BufferedImage newImg = new BufferedImage(newImageWidth, newImageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = newImg.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.drawImage(img, 0, 0, newImageWidth, newImageHeight, null);
        g2d.dispose();
        return newImg;
    }
}
