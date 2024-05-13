package discount;

public class NoDiscount implements DiscountTypeStrategy {
    @Override
    public double applyDiscount(double billAmount) {
        return billAmount;
    }
}