
package main;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
public class SilniaRekurecyjna implements Runnable {
    FXMLDocumentController c = FXMLDocumentController.getController();
    @Override
    public void run() {
                long start=System.nanoTime();
                BigInteger wynik = this.oblicz(BigInteger.valueOf(Long.parseLong(c.getText().getText())));
                long finish=System.nanoTime()-start;
                if (!c.flagStop){
                Platform.runLater(() -> {
                    c.getLabel1().setText("Czas rekurencyjny: " + Long.toString(finish) + " ns");
                    c.getLabel3().setText("Wynik: " + wynik.toString());
                    c.getButton1().setDisable(false);
                    c.getButton2().setDisable(true);
                });
            }}
            private BigInteger oblicz(BigInteger b){
                if (c.flagStop){
                return null;
                }
                if (b.equals(BigInteger.ZERO)){
                    return null;
                }
                 if (BigInteger.ONE.equals(b)){
                return BigInteger.ONE;
                }
                 synchronized(this){
                    try {
                        this.wait(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SilniaRekurecyjna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                b = b.multiply(this.oblicz(b.subtract(BigInteger.ONE)));
                return b;
            }
                    
            
    }
