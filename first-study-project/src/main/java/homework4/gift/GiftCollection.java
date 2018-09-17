package homework4.gift;

/**
 * Created by Алексей on 17.09.2018.
 */
public class GiftCollection {
    public static void collect() {
        Candy candy = new Candy("Red Candy",12.12, 15, "small");
        Chocolate chocolate = new Chocolate("Alenka", 23.23, 25, 3.5);
        Marmalade marmalade = new Marmalade("Bear", 34.34, 35, 5);

        NewYearGift [] box = {candy, chocolate, marmalade};
        for (NewYearGift elementOfGift : box) {
            System.out.println(elementOfGift.toString());
        }
        System.out.println("Total weight = " + (candy.getWeight() + chocolate.getWeight() + marmalade.getWeight()));
        System.out.println("Total price = " + (candy.getPrice() + chocolate.getPrice() + marmalade.getPrice()));
    }
}
