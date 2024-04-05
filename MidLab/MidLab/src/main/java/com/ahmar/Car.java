package com.ahmar;

public class Car {
    private Integer makeYear;
    private Integer price;
    private Boolean isNew;

    public Car(Integer makeYear, Integer price, Boolean isNew) {
        this.makeYear = makeYear;
        this.price = price;
        this.isNew = isNew;
    }

    public Integer getMakeYear() {
        return makeYear;
    }

    public void setMakeYear(Integer makeYear) {
        this.makeYear = makeYear;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean isNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }
}
