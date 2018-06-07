package core.lesson10;


import java.util.Date;

public class ElectronicsOrder extends Order {

    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if ((getShipFromCity().equals("Киев") || getShipFromCity().equals("Одесса") || getShipFromCity().equals("Днепр") |
                getShipFromCity().equals("Харьков")) && ((getShipToCity().equals("Киев") || getShipToCity().equals("Одесса")) |
                (getShipToCity().equals("Днепр") || (getShipToCity().equals("Харьков"))) && getBasePrice() >= 100 &&
                getCustomerOwned().getGender().equals("Женский"))) {
            setDateConfirmed(new Date());

        }

    }

    @Override
    public void calculatePrice() {
        if (getShipToCity().equals("Киев") || getShipToCity().equals("Одесса"))
            setTotalPrice(getBasePrice() + (getBasePrice() * 0.1));
        else
            setTotalPrice(getBasePrice() + (getBasePrice() * 0.15));
        if (getBasePrice() > 1000)
            setTotalPrice(getTotalPrice() - (getTotalPrice() * 0.05));

    }

    public int getGuaranteeMonths() {
        return guaranteeMonths;
    }
}
