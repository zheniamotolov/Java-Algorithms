package BetterPrimAlgorithm;


import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    public int[][] readFromfile(String path, int N) {
        int array[][] = new int[N][N];
        int i = 0;
        try (FileReader fileReader = new FileReader(path); Scanner input = new Scanner(fileReader)) {
            while (input.hasNextLine()) {

                for (int j = 0; j < N; j++) {
                    array[i][j] = input.nextInt();
                }


                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }






















}
