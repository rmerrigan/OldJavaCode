/*
 * Deals with a shared string object that is written to and cast between 
 * Int, Double, and string depending on context
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;


public class CalcFXMLController implements Initializable {
    
    @FXML
    Button one, two, three, four, five, six, seven, eight, nine, zero, add, sub, 
            div, mul, decimal, equal, del, clear, addSubSign, xSquared;
    
    @FXML public TextField numInput;
    String numString = "";
    
    public void oneBtn(){
        numString += "1";
        numInput.setText(numString);
    }
    
    public void twoBtn(){
        numString += "2";
        numInput.setText(numString);
    }
    
    public void threeBtn(){
        numString += "3";
        numInput.setText(numString);
    }
    
    public void fourBtn(){
        numString += "4";
        numInput.setText(numString);
    }
    
    public void fiveBtn(){
        numString += "5";
        numInput.setText(numString);
    }
    
    public void sixBtn(){
        numString += "6";
        numInput.setText(numString);
    }
    
    public void sevenBtn(){
        numString += "7";
        numInput.setText(numString);
    }
    
    public void eightBtn(){
        numString += "8";
        numInput.setText(numString);
    }
    
    public void nineBtn(){
        numString += "9";
        numInput.setText(numString);
    }
    
    public void zeroBtn(){
        numString += "0";
        numInput.setText(numString);
    }
    
    public void addBtn(){
    }
    
    public void subBtn(){
    }
    
    public void clrBtn(){
        numString = "";
        numInput.setText(numString);
    }
    
    public void delBtn(){
    }
    
    public void mulBtn(){
    }
    
    public void decimalBtn(){
    }
    
    public void signBtn(){
    }
    
    public void divBtn(){
    }
    
    public void xSquaredBtn(){
    }
    
    public void equBtn(){
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
