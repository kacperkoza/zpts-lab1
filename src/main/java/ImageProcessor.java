import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessor {

    private BufferedImage bufferedImage;

    /**
     * fileName - nazwa obrazku, który chcemy odczytac
     */
    public ImageProcessor(String fileName) throws IOException {
        File file = new File(fileName);
        Main_zad1_zad2_zad3.print("File exists = " + file.exists());
        bufferedImage = ImageIO.read(new File("kot.jpg"));
    }

    /**
     * Odczytuje pixel na pozycji (x, y)
     */
    public Color readPixel(int x, int y) {
        return new Color(bufferedImage.getRGB(x, y));
    }

    public double[][] readPixels(int n) {
        if (n % 4 != 0) {
            throw new IllegalArgumentException("N must be power >=0 of 2");
        }
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        if (n > width || n > height) {
            throw new IllegalArgumentException("N can't be greater than width or height");
        }
        double[][] result = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = readPixel(i,j).getRGB();
            }
        }
        return result;
    }

    public void setPixel(int x, int y, int rgb) {
        bufferedImage.setRGB(x, y, rgb);
    }

    public void saveAs(String newFileName) {
        File file = new File(newFileName);
        try {
            ImageIO.write(bufferedImage, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
            Main_zad1_zad2_zad3.print("IO exception in saveAs");
        }
    }

}
