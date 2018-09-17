package homework4.gift;

/**
 * Created by Алексей on 17.09.2018.
 */
public class Marmalade extends NewYearGift {

    int amount;

    public Marmalade(String name, double weight, int price, int amount) {
        super(name, weight, price);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Marmalade + [" + super.toString() + ", amount = " + amount + "]";
    }
}
