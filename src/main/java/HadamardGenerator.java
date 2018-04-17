import org.ejml.simple.SimpleMatrix;


public class HadamardGenerator {

    public double[][] hadamard(int n) {
        if (n % 4 != 0 ) {
            throw new IllegalArgumentException("N must be 1, 2, 4, 8, 16 ...");
        }
        double[][] hadamard = new double[n][n];
        hadamard[0][0] = 1;
        for (int k = 1; k < n; k += k) {
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    hadamard[i + k][j] = hadamard[i][j];
                    hadamard[i][j + k] = hadamard[i][j];
                    hadamard[i + k][j + k] = (-1)*hadamard[i][j];
                }
            }
        }
        return hadamard;
    }

    public SimpleMatrix hadamardMatrix(int n) {
        return new SimpleMatrix(hadamard(n));
    }

}
