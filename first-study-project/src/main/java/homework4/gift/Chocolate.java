package homework4.gift;

/**
 * Created by Алексей on 17.09.2018.
 */
public class Chocolate extends NewYearGift {

    double saturation;

    public Chocolate(String name, double weight, int price, double saturation) {
        super(name, weight, price);
        this.saturation = saturation;
    }

    public double getSaturation() {
        return saturation;
    }

    public void setSaturation(double saturation) {
        this.saturation = saturation;
    }

    @Override
    public String toString() {
        return "Chocolate + [" + super.toString() + ", saturation = " + saturation + "]";
    }
}
