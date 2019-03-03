package org.bt.javashop.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Stock implements Iterable<LineItem>, Serializable {

    private List<LineItem> stock;

    public List<LineItem> getStock() {
        return stock;
    }

    public void setStock(List<LineItem> stock) {
        this.stock = stock;
    }


    public Stock(List<LineItem> stock) {
        this.stock = stock;
    }

    public Stock(){
        stock = new ArrayList<LineItem>();

    }

    @Override
    public Iterator<LineItem> iterator() {
        return stock.iterator();
    }

}
