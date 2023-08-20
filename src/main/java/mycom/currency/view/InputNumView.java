package mycom.currency.view;

import mycom.MainMenu;


import javax.swing.*;

public class InputNumView {
    public static void showInputNumView(){
        String [] converters = new String[]{"Convertidor de moneda","Convertidor de Binario a decimal"};
        boolean isTheInputRight = false;
        Float election = 0.00f;

        do {
            try {
                election = Float.parseFloat((String)
                        JOptionPane.showInputDialog(null
                                , "Ingresa el numero a convertir (Solo caracteres numericos)"
                                , "Convertidor de Moneda", JOptionPane.QUESTION_MESSAGE
                                , MainMenu.logo
                                , null
                                , ""));

                isTheInputRight = true;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null
                        ,"Valor ingresado no es un numero, intentalo de nuevo"
                        ,"Convertidor de Moneda"
                        ,JOptionPane.ERROR_MESSAGE);
            }
        }while (!isTheInputRight);



        System.out.println(election);
    }

}
