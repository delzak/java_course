package homework4.gift;

/**
 * Created by Алексей on 17.09.2018.
 */
public class Candy extends NewYearGift {

    String size;

    public Candy(String name, double weight, int price, String size) {
        super(name, weight, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Candy + [" + super.toString() + ", size = " + size + "]";
    }
}
