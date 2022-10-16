import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.*;

public class LoginForm extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    private Label usrLbl;
    private TextField usrTf;
    private Label passLbl;
    private TextField passTf;
    private Button loginBtn;
    private Text resultTxt;


    @Override
    public void start(Stage stage) throws Exception
    {
        // 1. create the leaf nodes
        usrLbl = new Label("Username:");
        usrTf = new TextField();
        passLbl = new Label("Password:");
        passTf = new PasswordField();
        loginBtn = new Button("Login");
        resultTxt = new Text("");

        // 2. create the branch node
        GridPane gp = new GridPane();

        gp.add(usrLbl, 0, 0);
        gp.add(usrTf, 1, 0);
        gp.add(passLbl, 0, 1);
        gp.add(passTf, 1, 1);
        gp.add(loginBtn, 1, 2);
        gp.add(resultTxt, 1, 3);

        // 3. set the scene, show the stage
        stage.setScene(new Scene(gp));
        stage.setTitle("Login");
        stage.show();
        loginBtn.setOnAction(event -> setResult(checkAuth()));
    }

    public String getUsr()
    {
        return usrTf.getText();
    }

    public String getPass()
    {
        return passTf.getText();
    }

    public Boolean checkAuth()
    {
        return ((getUsr().equals("sam")) && (getPass().equals("mypassword")));
    }

    public void setResult(boolean value)
    {
        if (value)
        {
            resultTxt.setText("Password correct!");
        }
        else
        {
            resultTxt.setText("Password incorrect!");
        }
    }
}
