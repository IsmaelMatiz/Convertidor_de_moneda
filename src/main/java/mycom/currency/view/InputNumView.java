package mycom.currency.view;

import mycom.MainMenu;


import javax.swing.*;

public class InputNumView {
    public static void showInputNumView(){

        boolean isTheInputRight = false;
        Float inputNum = 0.00f;

        do {
            try {
                inputNum = Float.parseFloat((String)
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

        showInputCurrencies(inputNum);
    }

    public static void showInputCurrencies(Float numToConvert){

        final String [] currencies = new String[]{
                "De Pesos a Dolar",
                "De Pesos a Euro",
                "De Pesos a Libras",
                "De Pesos a Yen",
                "De Pesos a Won Coreano",
                "De Dolar a Pesos",
                "De Euro a Pesos",
                "De Libras a Pesos",
                "De Yen a Pesos",
                "De Won Coreano a Pesos"
        };

        String chosenCurrency = (String) JOptionPane.showInputDialog(null
                ,"Selecciona la moneda a la cual quieres convertir"
                ,"Convertidor de moneda"
                , JOptionPane.QUESTION_MESSAGE
                , MainMenu.logo
                ,currencies
                ,currencies[0]
        );

    }

}
