package StableMarrigeProblem;

import java.util.Arrays;

public class StableMarriageProblem {
    final static String menPath = "src/StableMarrigeProblem/menpreffernce.txt";
    final static String wemenPath = "src/StableMarrigeProblem/wemenprefference.txt";
    final static int N = 4;
    static int menPrefer[][];
    static int wemenPrefer[][];

    private static int search(int array[], int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return -1;
    }

    private static void stableMarriage() {
        int wPartner[] = new int[N];
        boolean mFree[] = new boolean[N];
        Arrays.fill(wPartner, -1);
        int freeCount = N;
        while (freeCount > 0) {
            int m;
            for (m = 0; m < N; m++)
                if (!mFree[m])
                    break;
            for (int i = 0; i < N && !mFree[m]; i++) {
                int w = menPrefer[m][i];
                if (wPartner[w] == -1) {
                    wPartner[w] = m;
                    mFree[m] = true;
                    freeCount--;
                } else {
                    int m1 = wPartner[w];
                    if (search(wemenPrefer[w], m) < search(wemenPrefer[w], m1)) {
                        wPartner[w] = m;
                        mFree[m] = true;
                        mFree[m1] = false;
                    }
                }
            }
        }
        System.out.println("Woman   Man");
        for (int i = 0; i < N; i++)
            System.out.println(" " + (i + 1) + "       " + (wPartner[i] + 1));
    }

    public static void main(String[] args) {
        menPrefer = new int[N][N];
        wemenPrefer = new int[N][N];
        Reader reader = new Reader();
        menPrefer = reader.readFromfile(menPath, N);
        wemenPrefer = reader.readFromfile(wemenPath, N);
        stableMarriage();
    }

}
