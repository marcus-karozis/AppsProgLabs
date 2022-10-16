import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.*;

public class StoreController
{
    private Store store;
    @FXML
    private Button sellBtn;
    @FXML
    private Text stockTxt;
    @FXML
    private Text priceTxt;
    @FXML
    private TextField amountTf;
    @FXML
    private Text cashTxt;
    @FXML
    private Text nameTxt;

    public final Button getSellBtn() { return this.sellBtn; }
    public final Text getStockTxt() { return this.stockTxt; }
    public final Text getPriceTxt() { return this.priceTxt; }
    public final TextField getAmountTf() { return this.amountTf; }
    public final Text getCashTxt() { return this.cashTxt; }
    public final Text getNameTxt() { return this.nameTxt; }

    @FXML private void initialize()
    {
        store = new Store();
        nameTxt.setText(store.getProduct().getName());
        stockTxt.textProperty().bind(store.getProduct().stockProperty().asString());
        priceTxt.textProperty().bind(store.getProduct().priceProperty().asString("$%.2f"));
        cashTxt.textProperty().bind(store.getCashRegister().cashProperty().asString("$%.2f"));

    }

    @FXML private void handleSell(ActionEvent event)
    {
        if (store.getProduct().getStock() >= Integer.valueOf(amountTf.getText()))
        {
            store.getProduct().sell(Integer.valueOf(amountTf.getText()));
            amountTf.setText("0");
        }
    }
}
