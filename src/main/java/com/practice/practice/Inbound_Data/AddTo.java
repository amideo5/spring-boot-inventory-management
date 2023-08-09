package com.practice.practice.Inbound_Data;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddTo {

    private Map<String, Integer> item_toList= new HashMap<>();


    public AddTo() {
    }

    public AddTo(Map<String, Integer> item_toList) {
        this.item_toList = item_toList;

    }
    public Map<String, Integer> getItem_toList() {
        return item_toList;
    }

    public void setItem_toList(Map<String, Integer> item_toList) {
        this.item_toList = item_toList;
    }


    @Override
    public String toString() {
        return "Inventory{" +
                ", itemToAdd=" + item_toList +
                '}';
    }
}