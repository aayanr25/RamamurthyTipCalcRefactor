import java.util.Scanner;

public class TipCalculatorRunner {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the tip calculator, where you'll never have to calculate a tip again!");
        System.out.print("How many people are in your group? ");
        int ppl = scan.nextInt();
        System.out.print("What percentage are you tipping? (0-100) ");
        int percent = scan.nextInt();
        TipCalculator calc = new TipCalculator(ppl, percent);
        scan.nextLine();

        // these variables are only used for the while loop
        String item = "";
        double num;
        while (!item.equals("-1")) {
            // I have the user input their item before the cost, but they still enter -1 to end.
            System.out.print("Enter one food item you ordered (-1 to end): ");
            item = scan.nextLine();
            if (item.equals("-1")) {
                break;
            }
            System.out.print("Enter a cost in dollars and cents (e.g. 12.50): ");
            num = scan.nextDouble();
            scan.nextLine();
            System.out.println();
            calc.addMeal(num, item);
        }

        /* I initialized the roundNum method in the TipCalculator
         class to make it easy to round to 2 decimal places. */
        System.out.println("--------------------");
        System.out.println("Total before tip: $" + calc.roundNum(calc.getTotalBillBeforeTip()));
        System.out.println("Total percentage: " + (calc.getTipPercentage()) + "%");
        System.out.println("Total tip: $" + calc.roundNum(calc.tipAmount()));
        System.out.println("Total bill with tip: $" + calc.roundNum(calc.totalBill()));
        System.out.println("Per person cost before tip: $" + calc.roundNum(calc.perPersonCostBeforeTip()));
        System.out.println("Tip per person: $" + calc.roundNum(calc.perPersonTipAmount()));
        System.out.println("Total cost per person: $" + calc.roundNum(calc.perPersonTotalCost()));
        System.out.println("--------------------");

        int i = 0;
        System.out.println("Items ordered: ");
        // this loop lists each item ordered.
        while (i < calc.getNumItems()) {
            System.out.println(calc.getFoodItemsList().get(i));
            i ++;
        }

    }
}
