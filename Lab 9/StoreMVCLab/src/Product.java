import java.util.*;
import javafx.beans.property.*;

public class Product
{
    private LinkedList<ProductObserver> observers = new LinkedList<ProductObserver>();

    private final String name;
    private IntegerProperty stock = new SimpleIntegerProperty();
    private DoubleProperty price = new SimpleDoubleProperty();

    public Product(String name, int stock, double price)
    {
        this.name = name;
        this.stock.set(stock);
        this.price.set(price);
    }

    public final String getName() { return this.name; }
    public final int getStock() { return this.stock.get(); }
    public final IntegerProperty stockProperty() { return this.stock; }
    public final double getPrice() { return this.price.get(); }
    public final DoubleProperty priceProperty() { return this.price; }
    public final void setPrice(double value) { this.price.set(value); }


    public void sell(int n)
    {
        this.stock.set(this.stock.get()- n);
        double money = n * price.get();
        for (ProductObserver observer : observers)
            observer.handleSale(money);
    }

    public void restock(int n)
    {
        this.stock.set(this.stock.get() + n);
    }

    public boolean has(int n)
    {
        return this.stock.get() >= n;
    }

    public void addProductObserver(ProductObserver observer)
    {
        observers.add(observer);
    }

    @Override
    public String toString()
    {
        return stock + " " + name + " at $" + price;
    }
}
