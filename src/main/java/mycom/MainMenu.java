package mycom;

import javax.swing.*;
import mycom.currency.view.InputNumView;
public class MainMenu {
        public static ImageIcon logo = new ImageIcon("src/main/java/mycom/images/logo.png");
        public static void main(String[] args) {

                //Calculator Options
                String [] converters = new String[]{"Convertidor de moneda","Convertidor de Binario a decimal"};
               String election = (String) JOptionPane.showInputDialog(null,"Elije el convertidor a udar",
                        "Menu Principal",
                        JOptionPane.QUESTION_MESSAGE, logo,converters,converters[0]
                        );
               //Show the next option
                if(election == converters[0]){
                    InputNumView.showInputNumView();
                }
        }
}
