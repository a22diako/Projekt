package com.example.projekt;

public class HPpoints {
    private String name;

    private String ID;
    private String type;

    private String company;
    private String location;
    private String category;

    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "HPpoints{" +
                "name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                ", category='" + category + '\'' +
                ", size='" + size + '\'' +
                ", cost='" + cost + '\'' +
                '}';
    }

    private String cost;
}


