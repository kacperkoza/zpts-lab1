import org.ejml.simple.SimpleMatrix;

import java.awt.*;
import java.io.IOException;

public class Main_zad1_zad2_zad3 {

    static ImageProcessor imageProcessor;
    static HadamardGenerator hadamardGenerator = new HadamardGenerator();

    final static Color WHITE_PIXEL = new Color(255, 255, 255);

    public static void main(String[] args) throws IOException {
        zadanie1_2();
        zadanie3();
    }

    private static void zadanie3() {
        SimpleMatrix input = new SimpleMatrix(generateMatrix());
        input.print();
        SimpleMatrix result = multiply(input, input);
        System.out.println("Input * input is: ");
        result.print();
    }

    private static double[][] generateMatrix() {
        double[][] matrix = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matrix[i][j] = 1;
            }
        }
        return matrix;
    }

    /**
     * mnozenie dwóch macierzy
     */
    private static SimpleMatrix multiply(SimpleMatrix first, SimpleMatrix second) {
        return first.mult(second);
    }

    /**
     * mnozenie kota * macierz hadamarda
     */
    private static void zadanie3_2() throws IOException {
        imageProcessor = new ImageProcessor("kot.jpg");
        final int SIZE = (int) Math.pow(2, 8);
        double[][] pixels = imageProcessor.readPixels(SIZE);
        // odczytanie SIZE pixeli z obrazku
        SimpleMatrix image = new SimpleMatrix(pixels);
        // macierz hadamarda o dlugosci boku SIZE
        SimpleMatrix hadamard = hadamardGenerator.hadamardMatrix(SIZE);
        // macierz wynikowa
        SimpleMatrix result = image.mult(hadamard);

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                imageProcessor.setPixel(i, j, (int) result.get(i, j));
            }
        }
        imageProcessor.saveAs("hadamard_kot.jpg");
    }

    private static void zadanie1_2() throws IOException {
        imageProcessor = new ImageProcessor("kot.jpg");

        //odczytanie dwoch pikseli i wyswietlenie
        readPixel(0, 0);
        readPixel(100, 100);

        //ustawienie pikseli 0-100 w pionie i poziomie na bialy
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                imageProcessor.setPixel(i, j, WHITE_PIXEL.getRGB());
            }
        }
        //zapisanie kota jako przerobiony_kot.jpg
        imageProcessor.saveAs("przerobiony_kot.jpg");

        //wyswietlenie ramki ze zdjeciem
        new ImageFrame("kot.jpg");
        new ImageFrame("przerobiony_kot.jpg");
    }

    static void readPixel(int x, int y) {
        Color pixel = imageProcessor.readPixel(x, y);
        print("pixel r=" + pixel.getRed() + ", g=" + pixel.getGreen() + ", b=" + pixel.getBlue());
    }

    static void print(String s) {
        System.out.println(s);
    }

}
