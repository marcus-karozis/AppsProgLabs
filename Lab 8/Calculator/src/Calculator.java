import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.*;

public class Calculator extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    private Label firstNumberLbl;
    private TextField firstNumberTf;
    private Label secondNumberLbl;
    private TextField secondNumberTf;
    private Label operationLbl;
    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private Label resultLbl;
    private TextField resultTf;


    @Override
    public void start(Stage stage) throws Exception
    {
        // 1. create the leaf nodes
        firstNumberLbl = new Label("First number:");
        firstNumberTf = new TextField();
        secondNumberLbl = new Label("Second number:");
        secondNumberTf = new TextField();
        operationLbl = new Label("Operation:");
        addBtn = new Button("+");
        subBtn = new Button("-");
        mulBtn = new Button("*");
        divBtn = new Button("/");
        resultLbl = new Label("Result:");
        resultTf = new TextField();

        // 2. create the branch node
        GridPane gp = new GridPane();
        gp.setHgap(10);

        gp.add(firstNumberLbl, 0, 0);
        gp.add(firstNumberTf, 1, 0, 4, 1);
        gp.add(secondNumberLbl, 0, 1);
        gp.add(secondNumberTf, 1, 1, 4, 1);
        gp.add(operationLbl, 0, 2);
        gp.add(addBtn, 1, 2);
        gp.add(subBtn, 2, 2);
        gp.add(mulBtn, 3, 2);
        gp.add(divBtn, 4, 2);
        gp.add(resultLbl, 0, 3);
        gp.add(resultTf, 1, 3, 4, 1);


        addBtn.setOnAction(new Addition());
        subBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event)
            {
                setResult(Integer.valueOf(firstNumberTf.getText()) - Integer.valueOf(secondNumberTf.getText()));
            }
        });

        mulBtn.setOnAction(event -> setResult(Integer.valueOf(firstNumberTf.getText()) * Integer.valueOf(secondNumberTf.getText())));
        divBtn.setOnAction(event -> setResult(Integer.valueOf(firstNumberTf.getText())
                / Integer.valueOf(secondNumberTf.getText())));
        // 3. set the scene, show the stage
        stage.setScene(new Scene(gp));
        stage.setTitle("Calculator");
        stage.show();
    }
    private class Addition implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent event)
        {
            setResult(Integer.valueOf(firstNumberTf.getText()) + Integer.valueOf(secondNumberTf.getText()));
        }
    }

    public int getFirstNumber()
    {
    return Integer.parseInt(firstNumberTf.getText());
    }

    public int getSecondNumber()
    {
    return Integer.parseInt(secondNumberTf.getText());
    }

    public void setResult(int value)
    {
        resultTf.setText(String.valueOf(value));
    }

    
}