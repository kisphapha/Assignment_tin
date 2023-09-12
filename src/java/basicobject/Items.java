/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicobject;

/**
 *
 * @author VNHCMLAP-0074
 */
public class Items {

    private String id;
    private String name;
    private Double price;
    private String cateid;

    public Items() {
    }

    public Items(String id, String name, Double price, String cateid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cateid = cateid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }
    
}
