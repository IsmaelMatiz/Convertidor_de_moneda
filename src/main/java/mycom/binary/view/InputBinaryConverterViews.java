package mycom.binary.view;

import mycom.MainMenu;

import javax.swing.*;

public class InputBinaryConverterViews {

    public static void showInputChooseConversionView(){

        final String [] ConvertionBiOptions = new String[]{
                "De Binario a Decimal",
                "De Pesos a Euro"
        };

        String chosenConversion = (String) JOptionPane.showInputDialog(null
                ,"Selecciona el sentido de la conversion"
                ,"Convertidor de Binario"
                , JOptionPane.QUESTION_MESSAGE
                , MainMenu.binaryLogo
                ,ConvertionBiOptions
                ,ConvertionBiOptions[0]
        );

        showInputBiNumView(chosenConversion);
    }

    public static void showInputBiNumView(String choosenConversion){

        boolean isTheInputRight = false;
        Integer inputNum = 0;

        do {
            try {
                inputNum = Integer.parseInt((String)
                        JOptionPane.showInputDialog(null
                                , "Ingresa el numero a convertir (Solo caracteres numericos)"
                                , "Convertidor de Binario"
                                , JOptionPane.QUESTION_MESSAGE
                                , MainMenu.binaryLogo
                                , null
                                , ""));
                isTheInputRight = true;
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null
                        ,"Valor ingresado no es un numero, intentalo de nuevo"
                        ,"Convertidor de Moneda"
                        ,JOptionPane.ERROR_MESSAGE);
            }catch (NullPointerException en){
                MainMenu.mainMenu();
            }
        }while (!isTheInputRight);

        MainMenu.showConversionResult(inputNum);
    }
}
