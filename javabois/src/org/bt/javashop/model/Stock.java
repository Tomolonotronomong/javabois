package org.bt.javashop.model;

import java.util.Iterator;
import java.util.List;

public class Stock implements Iterable<LineItem> {

    public List<LineItem> getStock() {
        return stock;
    }

    public void setStock(List<LineItem> stock) {
        this.stock = stock;
    }

    private List<LineItem> stock;

    public Stock(List<LineItem> stock) {
        this.stock = stock;
    }

    public Stock(){
        
    }


    @Override
    public Iterator<LineItem> iterator() {
        return stock.iterator();
    }

}
