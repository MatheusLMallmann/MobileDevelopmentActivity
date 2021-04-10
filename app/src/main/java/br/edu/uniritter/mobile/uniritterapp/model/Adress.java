package br.edu.uniritter.mobile.uniritterapp.model;

public class Adress{

    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public Geo geo;

    public Adress(String street, String suite, String city, String zipcode, Geo geo){
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

}
