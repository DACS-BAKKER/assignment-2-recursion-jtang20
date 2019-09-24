import java.util.Scanner;
import edu.princeton.cs.algs4.*;

public class HumanPyramids {
    public static void main(String args[]){
        Scanner sam = new Scanner(System.in);
        Stopwatch timer1= new Stopwatch();
        Stopwatch timer2= new Stopwatch();
        System.out.println("Enter row number");
        int x = sam.nextInt();
        System.out.println("Enter column number (number has to equal or be smaller than row number)");
        int y = sam.nextInt();
        double[][] arr= new double[x+1][y+1];
        //System.out.println(arr[x][y-1]); testing array indexes
        System.out.println(fastHumanPyramids(x,y,arr) + " is the weight person on row " + x + " column " + y + " feels (memoization).");
        double time1 = timer1.elapsedTime();
        System.out.println(slowHumanPyramids(x,y)+ " is the weight person on row " + x + " column " + y + " feels (no memoization).");
        double time2 = timer2.elapsedTime();
        System.out.println(time1 + " seconds for memoization. " +time2+" seconds for no memoization.");
    }

    public static double fastHumanPyramids(int r, int c, double[][] arr){
        if (r == 0) {
            return 0.0;
        } else if(arr[r][c]!=0){
            return arr[r][c];
        } else if (c == 0) {
            arr[r][c]=(fastHumanPyramids(r - 1, c,arr) + 200)/2;
            return (fastHumanPyramids(r - 1, c,arr) + 200) / 2;
        } else if (c == r) {
            arr[r][c]=(fastHumanPyramids(r - 1, c - 1,arr) + 200) / 2;
            return (fastHumanPyramids(r - 1, c - 1,arr) + 200) / 2;
        } else {
            arr[r][c] = 200 + (fastHumanPyramids(r - 1, c - 1, arr) / 2) + (fastHumanPyramids(r - 1, c, arr) / 2);
            return 200 + (fastHumanPyramids(r - 1, c - 1, arr) / 2) + (fastHumanPyramids(r - 1, c, arr) / 2);
        }
    }

    public static double slowHumanPyramids(int r, int c){
        if (r == 0) {
            return 0.0;
        } else if (c == 0) {
            return (slowHumanPyramids(r - 1, c) + 200) / 2;
        } else if (c == r) {
            return (slowHumanPyramids(r - 1, c - 1) + 200) / 2;
        } else {
            return 200 + (slowHumanPyramids(r - 1, c - 1) / 2) + (slowHumanPyramids(r - 1, c) / 2);
        }
    }
}
