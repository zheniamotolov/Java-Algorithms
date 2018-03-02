package MaximumBipartiteMatching;


import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Reader {
    public ArrayList<ArrayList<Integer>> readFromfile(String path) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        ArrayList<Integer> inner;
        int i = 0;
        try (FileReader fileReader = new FileReader(path); Scanner input = new Scanner(fileReader)) {

            while (input.hasNextLine()) {
                String str=input.nextLine();
                str = str.replaceAll("[^-?0-9]+", " ");
                inner = new ArrayList<>();
                if(!str.isEmpty()){
                    for (String token : Arrays.asList(str.trim().split(" "))) {
                        inner.add(Integer.parseInt(token));
                    }
                }
                outer.add(inner);
//                inner = new ArrayList<>();
//                while (true) {
//                    if (input.hasNextInt()) {
//                        inner.add(input.nextInt());
//                    } else {
//                        input.next();
//                        outer.add(inner);
//                        break;
//                    }
//                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return outer;
    }
}
