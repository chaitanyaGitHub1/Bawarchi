package com.example.raghavendra.bawarchi;

/**
 * Created by raghavendra on 5/9/2017.
 */

public class DataModel {

    String item;
  //  String version;
    int qty;
    float price;
   // int image;

    public DataModel(String item,  int qty, float price) {
        this.item = item;
        //this.version = version;
        this.qty = qty;
        this.price=price;
    }

    public String getItem() {
        return item;
    }

//    public String getVersion() {
//        return version;
//    }

    public float getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }
}
