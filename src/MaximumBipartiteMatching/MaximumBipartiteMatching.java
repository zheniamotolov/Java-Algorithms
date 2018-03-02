package MaximumBipartiteMatching;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by eugene on 12/4/17.
 */

public class MaximumBipartiteMatching {
    final static String path = "src/MaximumBipartiteMatching/newData.txt";
    static final int M = 6;
    static final int N = 6;
    static int bpGraph[][];
    static boolean bpm(int u, boolean seen[], int emptyU[]) {
        for (int v = 0; v < N; v++) {
            if ((bpGraph[u][v] == 1) && !seen[v]) {
                seen[v] = true; // Mark v as visited
                if (emptyU[v] < 0 || bpm(emptyU[v], seen, emptyU)) {
                    emptyU[v] = u;
                    System.out.println(u + "-" + v);
                    return true;
                }
            }
        }
        return false;
    }
    static int maxBPM() {
        //i=v [i]=u
        //applicant=u jobs=v
        int emptyU[] = new int[N];
        for (int i = 0; i < N; ++i)
            emptyU[i] = -1;
        int result = 0;
        for (int u = 0; u < M; u++) {
            boolean seen[] = new boolean[N];
            if (bpm(u, seen, emptyU))
                result++;
        }
        return result;
    }
    public static void main(String[] args) {
        NewReader newReader = new NewReader();
        bpGraph = newReader.readFromfile(path, M, N);
        maxBPM();

    }
}





//public class MaximumBipartiteMatching {
//    final static String path = "src/MaximumBipartiteMatching/data.txt";
//    static ArrayList<ArrayList<Integer>> g;
//    static ArrayList<Integer> temp;
//    static int mt[];
//    static boolean used[];
//    static int k = 6;
//    static int n = 6;
//   static boolean try_kuhn(int v) {
//        if (used[v]) return false;
//        used[v] = true;
//        temp=g.get(v);
//        for (int i = 0; i < temp.size(); ++i) {
//            int to = temp.get(i);
//            if (mt[to] == -1 || try_kuhn(mt[to])) {
//                mt[to] = v;
//                return true;
//            }
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        Reader reader = new Reader();
//        g = reader.readFromfile(path);
//        mt = new int[k];
//        used = new boolean[n];
//        Arrays.fill(mt, -1);
//        for (int v=0; v<n; ++v) {
//            Arrays.fill(used, false);
////            used.assign (n, false);
//            try_kuhn(v);
//        }
//
//        for (int i=0; i<k; ++i)
//            if (mt[i] != -1)
//                System.out.printf("%d %d\n", mt[i], i);
//        for (ArrayList<Integer> innerLs : g) {
////            for (int a : innerLs) {
////                System.out.println(a);
////            }
//            Object[] arr =  innerLs.toArray();
//            System.out.println(Arrays.deepToString(arr));
//        }
//    }
//}
