package org.bt.javashop.model;


/**
 * An order can be placed for a given quantity of a item
 * The cost of the order is given in pence and is calculated by
 * multiplying the order quantity with the item's unit price.
 *
 * The quantity of an order can be increased and decreased.
 *
 * Two orders are equal if their associated items are the same.
 * Orders can also be compared by their associated items.
 *
 * @author la
 */
public class LineItem implements Comparable<LineItem> {

    //fields
    private Product item;
    private int quantity;


    //constructors
    public LineItem() {
        item = new Product();
        quantity = 0;

    }

    public LineItem(Product item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }


    //methods
    public void increaseQuantity() {
        quantity++;
    }

    public void decreaseQuantity() {
        quantity--;
    }

    public int getCost() {
        return quantity * item.getUnitPrice();
    }

    public Product getProduct() {
        return item;
    }

    public void setProduct(Product item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ":[item=" + item + ", quantity=" + quantity + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass())
            return false;

        LineItem other = (LineItem) obj;

        return this.item.equals(other.item);
    }

    @Override
    public int compareTo(LineItem other) {
        return this.item.compareTo(other.item);
    }

}

