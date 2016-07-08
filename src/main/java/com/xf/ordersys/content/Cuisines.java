package com.xf.ordersys.content;

/**
 * This class contains representations of the each object "Cuisines"
 *
 * @author Dawid Janik
 */
public  class Cuisines {

    private String nameCuisines = "";
    private String nameMainCourse = "";
    private String nameDessert = "";

    private Double price;

 //===================================================================
 //

    public Cuisines() {
        super();
    }

    public Cuisines(String name, Double price) {
        this.nameCuisines = name;
        this.price = price;
    }

//===================================================================
//

    public String getName() {
        return nameCuisines;
    }

    public void setName(String name) {
        this.nameCuisines = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getNameMainCourse() {
        return nameMainCourse;
    }

    public void setNameMainCourse(String nameMainCourse) {
        this.nameMainCourse = nameMainCourse;
    }

    public String getNameDessert() {
        return nameDessert;
    }

    public void setNameDessert(String nameDessert) {
        this.nameDessert = nameDessert;
    }

//===================================================================
//
    @Override
    public String toString() {
        return "Cuisines{" +
                "nameCuisines='" + nameCuisines + '\'' +
                ", nameMainCourse='" + nameMainCourse + '\'' +
                ", nameDessert='" + nameDessert + '\'' +
                ", price=" + price +
                '}';
    }



}// End of Cuisines
