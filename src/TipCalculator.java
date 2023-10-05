import java.util.ArrayList;

public class TipCalculator {
    private int numPeople;
    private int tipPercentage;
    private double totalBillBeforeTip = 0.0;
    private ArrayList<String> foodItems  = new ArrayList<>();
    private int numItems = 0;
    public TipCalculator(int numPeople, int tipPercentage) {
        this.numPeople = numPeople;
        this.tipPercentage = tipPercentage;
    }

    public double getTotalBillBeforeTip() {
        return totalBillBeforeTip;
    }
    public int getTipPercentage() {
        return tipPercentage;
    }

    public ArrayList<String> getFoodItemsList() {
        return foodItems;
    }

    public void addMeal(double cost, String itemName) {
        totalBillBeforeTip += cost;
        foodItems.add(itemName);
        numItems ++;
    }
    public double tipAmount() {
        double realTip = (double) tipPercentage / 100;
        return totalBillBeforeTip * realTip;
    }

    public double totalBill() {
        return totalBillBeforeTip + tipAmount();
    }
    public double perPersonCostBeforeTip() {
        return totalBillBeforeTip / numPeople;
    }
    public double perPersonTipAmount() {
        return tipAmount() / numPeople;
    }
    public double perPersonTotalCost() {
        return totalBill() / numPeople;
    }

    public int getNumItems() {
        return numItems;
    }

    public double roundNum(double num) {
        double temp = num * 100;
        temp = Math.round(temp);
        return temp / 100;
    }

}
