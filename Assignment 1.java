import java.util.Scanner;
public class WageCalculator {
public static final int STANDARD_HOURS = 40;
public static final double OVERTIME_MULTIPLIER = 1.5;
public static void main(String[] args) throws Exception {
Scanner input = new Scanner(System.in);
System.out.println("What is your regular hourly wage?");
double wage = input.nextDouble();
System.out.println("How many hours do you work per week?");
int hours = input.nextInt();
System.out.println("What is tax rate percentage as a whole number?");
int tax = input.nextInt();
double regularPay = calculateRegularPay(wage, hours);
double overtimePay = calculateOvertimePay(wage, hours);
double grossPay = calculateGrossPay(regularPay, overtimePay);
double taxWithheld = calculateTaxWithheld(grossPay, tax);
double netPay = calculateNetPay(grossPay, taxWithheld);
System.out.println("Regular Pay: $" + regularPay);
System.out.println("Overtime Pay: $" + overtimePay);
System.out.println("Gross Pay: $" + grossPay);
System.out.println("Tax Withheld: $" + taxWithheld);
System.out.println("Net Pay: $" + netPay);
input.close();
}
public static double calculateRegularPay(double wage, int hours) {
if (hours > STANDARD_HOURS) {
return wage * STANDARD_HOURS;
}
return wage * hours;
}
public static double calculateOvertimePay(double wage, int hours) {
if (hours <= STANDARD_HOURS) {
return 0;
}
return (hours - STANDARD_HOURS) * wage * OVERTIME_MULTIPLIER;
}
public static double calculateGrossPay(double regularPay, double overtimePay) {
return regularPay + overtimePay;
}
public static double calculateTaxWithheld(double grossPay, int taxRate) {
return grossPay * ((double) taxRate / 100);
}
public static double calculateNetPay(double grossPay, double taxWithheld) {
return grossPay - taxWithheld;
}
}
