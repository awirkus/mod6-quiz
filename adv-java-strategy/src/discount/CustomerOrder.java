package discount;

public class CustomerOrder {

    private String customerName;
    private double billAmount;
    private DiscountTypeStrategy discountType;

    public CustomerOrder(String customerName, double billAmount, char discountType) {
        this.customerName = customerName;
        this.billAmount = billAmount;

        switch (Character.toLowerCase(discountType)) {
            case 's':
                this.discountType = new Sale();
                break;
            case 'd':
                this.discountType = new Discount();
                break;
            case 'l':
                this.discountType = new Liquidation();
                break;
            default:
                this.discountType = new NoDiscount();
                break;
        }
    }

    public double getBillAmount() {
        return discountType.applyDiscount(billAmount);
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{"
                + "customerName='" + customerName + '\''
                + ", billAmount=" + billAmount
                + ", discountType=" + discountType
                + '}';
    }
}
