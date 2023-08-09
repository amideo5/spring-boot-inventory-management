package com.practice.practice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {

    @Id
    private String baseId;
    private String itemName;
    private double price;

    public Item(){

    }
    public Item(String itemName, double price) {

        this.itemName = itemName;
        this.price = price;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

}
