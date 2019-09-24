import edu.princeton.cs.algs4.*;

import java.util.Scanner;

public class SierpinskiTriangle {
    public static void main(String args[]) { // coordinate plane starts on bottom left corner, x,y coordinate must be between 0 and 1
        Scanner sam = new Scanner(System.in);// in order for triangle to be fully visible
        System.out.println("Enter x coordinate");
        double x = sam.nextDouble();
        System.out.println("Enter y coordinate");
        double y = sam.nextDouble();
        System.out.println("Enter side length");
        double l = sam.nextDouble();
        System.out.println("Enter order");
        int o = sam.nextInt();
        drawSierpinskiTriangle(x, y, l, o);
    }
        public static void drawSierpinskiTriangle ( double x, double y, double sideLength, int order){
            if (order == 0) {
                StdDraw.line(x, y, x + sideLength, y);
                StdDraw.line(x, y, x + sideLength / 2, y + sideLength * Math.sqrt(3) / 2);
                StdDraw.line(x + sideLength / 2, y + sideLength * Math.sqrt(3) / 2, x + sideLength, y);
            } else {
                drawSierpinskiTriangle(x, y, sideLength / 2, order - 1);
                drawSierpinskiTriangle(x + sideLength/2, y, sideLength / 2, order - 1);
                drawSierpinskiTriangle(x + sideLength / 4, y + sideLength * Math.sqrt(3) / 4, sideLength / 2, order - 1);
            }
        }
    }
