import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.fxml.*;

public class StoreApplication extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("store.fxml"));

        // Add code here to load the root node from the FXML file
        // and show it

        Parent root = loader.load();
        stage.setTitle("Store");
        stage.setScene(new Scene(root));
        stage.sizeToScene();
        stage.show();
    }
}
