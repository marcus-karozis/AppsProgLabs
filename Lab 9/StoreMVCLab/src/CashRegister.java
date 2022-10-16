import javafx.beans.property.*;
public class CashRegister implements ProductObserver
{
    private DoubleProperty cash = new SimpleDoubleProperty();;

    public CashRegister()
    {
        this.cash.set(0.0);
    }
    public final double getCash() { return this.cash.get(); }
    public ReadOnlyDoubleProperty cashProperty() { return this.cash; }

    public void add(double money)
    {
        this.cash.set(this.cash.get() + money);
    }

    @Override
    public void handleSale(double amount)
    {
        add(amount);
    }
}
