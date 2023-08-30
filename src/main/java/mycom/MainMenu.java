package mycom;

import javax.swing.*;

import mycom.binary.logic.BiCalculation;
import mycom.binary.view.InputBinaryConverterViews;
import mycom.currency.logic.CurAPICall;
import mycom.currency.view.InputNumView;

import java.text.DecimalFormat;

public class MainMenu {
        public static final ImageIcon logo = new ImageIcon("src/main/java/mycom/images/logo.png");
    public static final ImageIcon binaryLogo = new ImageIcon("src/main/java/mycom/images/binario.png");
        public static void main(String[] args) {

            //Get the currencies from the Api
            CurAPICall.getInstance().setRates();
            //Start the first GUI
            mainMenu();
        }

        public static void mainMenu(){
            //Calculator Options
            final String [] converters = new String[]{"Convertidor de moneda","Convertidor de Binario a decimal"};
            String election = (String) JOptionPane.showInputDialog(null,"Elije el convertidor a usar",
                    "Menu Principal",
                    JOptionPane.QUESTION_MESSAGE, logo,converters,converters[0]
            );
            //Show the next option
            if(election == converters[0]){
                InputNumView.showInputNumView();
            }else{
                InputBinaryConverterViews.showInputChooseConversionView();
            }
        }

    public  static void showConversionResult(Float Result, String Currency){

        JOptionPane.showMessageDialog(null
                ,"Tienes $"+Result+" "+Currency
                ,"Convertidor de moneda"
                ,JOptionPane.QUESTION_MESSAGE
                ,MainMenu.logo
        );

        showAskToContinue("Convertidor de moneda");
    }

    public  static void showConversionResult(Integer Result){

        JOptionPane.showMessageDialog(null
                ,"El Valor es " + Result
                ,"Convertidor de Binario"
                ,JOptionPane.QUESTION_MESSAGE
                ,MainMenu.binaryLogo
        );

        showAskToContinue("Convertidor de Binario");
    }

    public  static void showConversionResult(String Result){

        JOptionPane.showMessageDialog(null
                ,"El Valor es " + Result
                ,"Convertidor de Binario"
                ,JOptionPane.QUESTION_MESSAGE
                ,MainMenu.binaryLogo
        );

        showAskToContinue("Convertidor de Binario");
    }

    public static  void showAskToContinue(String title){
        Integer election =  JOptionPane.showConfirmDialog(null
                ,"¿Deseas continuar?"
                ,title
                ,JOptionPane.YES_NO_CANCEL_OPTION
                ,JOptionPane.QUESTION_MESSAGE
                ,MainMenu.logo
        );
        //If the user choose yes go back to the Main Menu
        if (election == 0){
            MainMenu.mainMenu();
        }else{
             JOptionPane.showMessageDialog(
                    null
                    ,"Programa Finalizado"
                    ,title
                    ,JOptionPane.QUESTION_MESSAGE
                    ,MainMenu.logo
            );

            JOptionPane.getRootFrame().dispose();
            System.exit(0);
        }
    }
}
