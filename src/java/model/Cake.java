package model;

import java.util.Date;

public class Cake {
    
    private int id;
    private String name;
    private String fullDescription;
    private Date dayCreated;
    private String photoPath;
    private String price;
    private String shortDescription;

    public Cake(int id, String name, String fullDescription, Date dayCreated, String photoPath, String price, String shortDescription) {
        this.id = id;
        this.name = name;
        this.fullDescription = fullDescription;
        this.dayCreated = dayCreated;
        this.photoPath = photoPath;
        this.price = price;
        this.shortDescription = shortDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public Date getDayCreated() {
        return dayCreated;
    }

    public void setDayCreated(Date dayCreated) {
        this.dayCreated = dayCreated;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    @Override
    public String toString() {
        return "Cake{" + "id=" + id + ", name=" + name + ", fullDescription=" + fullDescription + ", dayCreated=" + dayCreated + ", photoPath=" + photoPath + ", price=" + price + ", shortDescription=" + shortDescription + '}';
    }
}
