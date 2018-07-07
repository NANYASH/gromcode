package jdbc.lesson5;


import java.util.Date;


public class Order extends Entity {
    private long id;
    private User userOrdered;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (Double.compare(order.moneyPaid, moneyPaid) != 0) return false;
        if (userOrdered != null ? !userOrdered.equals(order.userOrdered) : order.userOrdered != null) return false;
        if (room != null ? !room.equals(order.room) : order.room != null) return false;
        if (dateFrom != null ? !dateFrom.equals(order.dateFrom) : order.dateFrom != null) return false;
        return dateTo != null ? dateTo.equals(order.dateTo) : order.dateTo == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userOrdered != null ? userOrdered.hashCode() : 0);
        result = 31 * result + (room != null ? room.hashCode() : 0);
        result = 31 * result + (dateFrom != null ? dateFrom.hashCode() : 0);
        result = 31 * result + (dateTo != null ? dateTo.hashCode() : 0);
        temp = Double.doubleToLongBits(moneyPaid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public User getUserOrdered() {
        return userOrdered;
    }

    public void setUserOrdered(User userOrdered) {
        this.userOrdered = userOrdered;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }
}
