package core.finalProject.entity;


import java.time.LocalDate;


public class Order extends Entity {
    private User user;
    private Room room;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double moneyPaid;

    public Order() {
    }

    public Order(User user, Room room, LocalDate dateFrom, LocalDate dateTo, double moneyPaid) {
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public Order(long id, User user, Room room, LocalDate dateFrom, LocalDate dateTo, double moneyPaid) {
        super.setId(id);
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (super.getId() != order.getId()) return false;
        if (Double.compare(order.moneyPaid, moneyPaid) != 0) return false;
        if (!user.equals(order.user)) return false;
        if (!room.equals(order.room)) return false;
        if (!dateFrom.equals(order.dateFrom)) return false;
        return dateTo.equals(order.dateTo);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (super.getId() ^ (super.getId() >>> 32));
        result = 31 * result + user.hashCode();
        result = 31 * result + room.hashCode();
        result = 31 * result + dateFrom.hashCode();
        result = 31 * result + dateTo.hashCode();
        temp = Double.doubleToLongBits(moneyPaid);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public double getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    @Override
    public String toString() {
        return super.getId() + "," +
                user.getId() + "," +
                room.getId() + "," +
                dateFrom + "," +
                dateTo + "," +
                moneyPaid;
    }
}
