import javax.swing.*;
import java.awt.*;

public class Main {
        public static void main(String[] args) {

                ImageIcon logo = new ImageIcon("src/main/java/images/logo.png");

                //Calculator Options
                String [] converters = new String[]{"Convertidor de moneda","Convertidor de Binario a decimal"};
                JOptionPane.showInputDialog(null,"Elije el convertidor a udar",
                        "Menu Principal",
                        JOptionPane.QUESTION_MESSAGE, logo,converters,converters[0]
                        );
        }
}
