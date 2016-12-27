package main;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;

public class SilniaIteracyjna implements Runnable {
    FXMLDocumentController d = FXMLDocumentController.getController();

            private BigInteger oblicz(BigInteger b){
                if (d.flagStop){
                    return null;
                }
                if (b.equals(BigInteger.ONE)){
                    return b;
                }
                BigInteger wynik =b;
                for (BigInteger i=b.subtract(BigInteger.ONE);i.compareTo(BigInteger.ONE)==1;i=i.subtract(BigInteger.ONE)){
                     synchronized(this){
                    try {
                        this.wait(200);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SilniaRekurecyjna.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 }
                    wynik = wynik.multiply(i);
                }
                return b;
                }

                @Override
                public void run() {
                    long start = System.nanoTime();
                    BigInteger wynik = this.oblicz(BigInteger.valueOf(Long.valueOf(d.getCopy().getText())));
                    long finish = System.nanoTime() - start;
                    Platform.runLater(()->{
                        if (!d.flagStop){
                        d.getLabel2().setText("Czas iteracyjnie: "+wynik.toString()+" ns");
        }  
      });
    }
}
