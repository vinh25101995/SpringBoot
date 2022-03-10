import com.sun.crypto.provider.HmacMD5KeyGenerator;

import java.awt.image.ImagingOpException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static int magicSquare(List<List<Integer>> magicSquare) {
        int[][][] MAGIC_SQUARE = {
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
             };
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 8; i++) {
            int sumS = 0;
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    int a = MAGIC_SQUARE[i][j][k];
                    int b = magicSquare.get(j).get(k);
                    sumS += Math.abs(a - b);
                }

            }
            if (min > sumS) {
                min = sumS;
            }
        }
        return min;
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int attackNum = 0;
//        int maxColumn = Math.min(c_q + 4, n);
//        int minColumn = Math.max(c_q - 4, 1);
//        int maxRow = Math.min(r_q + 4,n);
//        int minRow = Math.max(r_q - 4, 1);
        int sum = r_q + c_q;
        int difference = r_q - c_q;
        HashSet<Integer> obs = new HashSet<>();
        for(int i = 0)
        //Left
        for(int i = c_q; i<minColumn; i--){
            if(obstacles.contains(new List){
                break;
            }
            attackNum++;
        }
        return attackNum;
    }
    public static void main(String[] arg){
        List<List<Integer>> s = new ArrayList<>();
        queensAttack(4,0,4,4,s);
    }
}
