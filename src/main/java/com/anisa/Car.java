package com.anisa;


public class Car {
    private final String name;
    private final String manufacturer;
    private final int age;
    private final String photo;
    private  long price;

    public Car(String name,String manufacturer,int age,String photo, int price ) {
        this.name = name;
        this.manufacturer=manufacturer;
        this.age = age;
        this.photo=photo;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", age=" + age +
                ", price=" + price +
                '}';
    }

    public String getPhoto() {
        return photo;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
