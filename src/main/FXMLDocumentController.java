package main;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author dompl
 */
public class FXMLDocumentController implements Initializable {
    boolean flagStop;
    private static FXMLDocumentController controller;
    @FXML
    private Label label1,label2,label3;
    @FXML
    private Button button1,button2;
    @FXML
    private TextField text;
    Thread f=null,g=null;
    TextField copy;

    public Label getLabel1() {
        return label1;
    }

    public Label getLabel2() {
        return label2;
    }

    public Label getLabel3() {
        return label3;
    }    
    public TextField getText() {
        return text;
    }
    @FXML
    private void oblicz() {
        copy=text;
        this.flagStop=false;
        button1.setDisable(true);
        button2.setDisable(false);
        this.label1.setText("");
        this.label2.setText("");
        this.label3.setText("");       
        f = new Thread(new SilniaRekurecyjna());
        g = new Thread(new SilniaIteracyjna());
        f.start();
        g.start();

    }

    public TextField getCopy() {
        return copy;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }
    @FXML
    private void stop() {
        this.flagStop=true;
        this.getButton1().setDisable(false);
        this.getButton2().setDisable(true);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        controller =this;
    }    
    public static FXMLDocumentController getController(){
        return controller;
    }
    
}
