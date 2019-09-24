import java.util.Scanner;

public class SummingDigits{
    public static void main(String args[]){
        Scanner sam = new Scanner(System.in);
        System.out.println("Enter a number");
        int x = sam.nextInt();
        System.out.println(sumOfDigits(x) + " is the sum of the digits in your number");
    }
    public static int sumOfDigits(int x){
        if (x == 0){
            return 0;
        }
        else{
            return (x % 10 + sumOfDigits(x / 10));
        }

    }
}
