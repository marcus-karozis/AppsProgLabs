public class Store
{
    private CashRegister cashRegister;
    private Product product;

    public Store()
    {
        cashRegister = new CashRegister();
        product = new Product("Sticky tape", 200, 2.99);
        product.addProductObserver(cashRegister);
    }

    public final CashRegister getCashRegister() { return this.cashRegister; }
    public final Product getProduct() { return this.product; }

}
