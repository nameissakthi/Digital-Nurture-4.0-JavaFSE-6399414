import java.util.Scanner;

public class Main {
    public static double futureValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return futureValue(principal, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Financial Forcasting");
        System.out.println("--------------------");

        System.out.print("\nEnter the Principal Amount : ");
        double principal = sc.nextDouble();

        System.out.print("\nEnter the Growth Rate : ");
        double rate = sc.nextDouble();

        System.out.print("\nEnter the No. of Years :");
        int years = sc.nextInt();

        double result = futureValue(principal, rate, years);
        System.out.println("\nFuture value after "+years+" years: "+result);
    }
}