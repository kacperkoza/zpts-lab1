import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main_zad5 {

    public static void main(String[] args) throws IOException {
        //odczytanie wejscia
        List<Integer> input = readAllNumbersFromFile("input.dat");
        //odczytanie filtru
        List<Integer> filter = readAllNumbersFromFile("filter.dat");
        Main_zad1_zad2_zad3.print(input.toString());
        Main_zad1_zad2_zad3.print(filter.toString());

        List<Integer> result = splot(input, filter);
        Main_zad1_zad2_zad3.print(result.toString());

        //zapisanie do pliku wyniku
        writeToFile("output.txt", result);
    }

    static List<Integer> splot(List<Integer> input, List<Integer> filter) {
        List<Integer> result = new ArrayList<>();
        int resultSize = input.size() + filter.size() - 1;
        int n = 0;
        for (int i = 0; i < resultSize; i++) {
            int current = 0;
            for (int k = 0; k < input.size(); k++) {
                if (n - k >= 0 && n - k < filter.size()) {
                    current += filter.get(n - k) * input.get(k);
                }
            }
            result.add(current);
            n++;

        }
        return result;
    }


    /**
     * Wczytuje wszystkie liczby z danego pliku
     */
    static List<Integer> readAllNumbersFromFile(String fileName) throws IOException {
        List<Integer> integers = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                // read next line
                integers.add(Integer.valueOf(line.trim()));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            reader.close();
        }
        return integers;
    }

    /**
     * zapisuje liste 'list' do pliku 'filename'
     */
    static void writeToFile(String fileName, List<Integer> list) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        list.forEach(p -> {
            try {
                fileWriter.write(p.intValue() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fileWriter.close();
    }

}
