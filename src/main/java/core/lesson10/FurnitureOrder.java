package core.lesson10;


import java.util.Date;

public class FurnitureOrder extends Order {

    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if ((getShipFromCity().equals("Киев") || getShipFromCity().equals("Львов")) && getBasePrice() >= 500 &&
                !getCustomerOwned().getName().equals("Тест")) {
            setDateConfirmed(new Date());
        }

    }

    @Override
    public void calculatePrice() {
        if (getBasePrice() > 5000)
            setTotalPrice(getBasePrice() + (getBasePrice() / 100 * 2));
        else setTotalPrice(getBasePrice() + (getBasePrice() / 100 * 5));
    }
}
