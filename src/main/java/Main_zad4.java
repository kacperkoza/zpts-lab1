import org.ejml.simple.SimpleMatrix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main_zad4 {

    static Random random = new Random();
    static HadamardGenerator hadamard = new HadamardGenerator();

    public static void main(String[] args) throws IOException {
        //długość wektora i rozmiar macierzy kwadratowej
        final int SIZE = 4;

        //wygenerowanie wektora
        SimpleMatrix vector = createRandomVector(SIZE);
        vector.print();

        //wygenerowanie macierzy Walsha-Hadamarda
        SimpleMatrix simpleMatrix = hadamard.hadamardMatrix(SIZE);
        simpleMatrix.print();

        //wymnożenie wektor * macierz
        SimpleMatrix result = vector.mult(simpleMatrix);
        result.print();
    }

    static SimpleMatrix createRandomVector(int n) {
        List<Double> integers = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            integers.add(random() % 2);
        }
        SimpleMatrix vector = new SimpleMatrix(1, n);
        for (int i = 0; i < integers.size(); i++) {
            vector.set(i, integers.get(i));
        }
        return vector;
    }

    static double random() {
        return random.nextDouble();
    }

}




