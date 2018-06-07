package core.finalProject.utils;


import core.finalProject.entity.Room;

import java.util.Date;

public class Filter {
    private String name;
    private String country;
    private String city;
    private String street;
    private long numberOfGuests;
    private double price;
    private Boolean breakfastIncluded;
    private Boolean petsAllowed;
    private Date dateAvailableFrom;
    private Boolean defaultBolean;

    public Filter() {
        breakfastIncluded = defaultBolean;
        petsAllowed = defaultBolean;
    }

    public boolean findMatches(Room room) {

        if (numberOfGuests != 0 && room.getNumberOfGuests() != numberOfGuests) return false;
        if (price != 0.0d && Double.compare(price, room.getPrice()) != 0) return false;
        if (breakfastIncluded != defaultBolean && breakfastIncluded != room.isBreakfastIncluded()) return false;
        if (petsAllowed != defaultBolean && petsAllowed != room.isPetsAllowed()) return false;
        if (name != null && !name.equals(room.getHotel().getName())) return false;
        if (country != null && !country.equals(room.getHotel().getCountry())) return false;
        if (city != null && !city.equals(room.getHotel().getCity())) return false;
        if (street != null && !street.equals(room.getHotel().getStreet())) return false;
        if (dateAvailableFrom != null && !dateAvailableFrom.equals(room.getDateAvailableFrom())) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(long numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }
}
