package org.alurachallenge;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.alurachallenge.converter.Converter;
import org.alurachallenge.converter.ConverterClient;
import org.alurachallenge.converter.ConverterGsonDeserializer;
import org.alurachallenge.supportedcurrencies.SupportedCurrencies;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        boolean executing = true;
        ConverterClient converterClient = new ConverterClient();
        SupportedCurrencies supportedCurrencies = new SupportedCurrencies();
        Scanner inputsUser = new Scanner(System.in);
        int options = 0;
        while (executing){
            Menu.printMenu();
            try {
                System.out.print("Seleccione una opcion: ");
                options =   Integer.parseInt(inputsUser.nextLine());
            }catch (NumberFormatException e){
                System.out.println("Opcion seleccionada no valida por favor presione enter para intentarlo de nuevo");
                inputsUser.nextLine();
                Console.insertBlankSpaceInConsole();
                continue;

            }
            switch (options){
                case 1:
                    supportedCurrencies.printAllCountries();
                    break;
                case 2:
                    Menu.printSearchByCountry();
                    String inputCountryName = inputsUser.nextLine();
                    supportedCurrencies.searchByCountry(inputCountryName);
                    System.out.println("Presione enter para volver al menu principal");
                    inputsUser.nextLine();
                    break;
                case 3:
                    boolean codes = true;
                    while(codes){
                        System.out.print("Ingrese el codigo de la primera moneda: ");
                        String inputFCode = inputsUser.nextLine();
                        if(!supportedCurrencies.isAValidCode(inputFCode)){
                            System.out.println("Codigo no valido por favor intente de nuevo");
                            continue;
                        }
                        System.out.print("Ingrese el codigo de la segunda moneda: ");
                        String inputSCode = inputsUser.nextLine();
                        if(!supportedCurrencies.isAValidCode(inputSCode)){
                            System.out.println("Codigo no valido por favor intente de nuevo");
                            continue;
                        }
                        System.out.print("Ingrese el monto que desea intercambiar de " + inputFCode + " a " + inputSCode + " :");
                        String inputAmount = inputsUser.nextLine();
                        try {
                            double parseToConfirm = Double.parseDouble(inputAmount);
                        }catch (Exception e){
                            System.out.println("Parece que hubo un error con el monto ingresado por favor intentelo de nuevo");
                            continue;
                        }
                        Gson gson = new GsonBuilder().registerTypeAdapter(Converter.class,new ConverterGsonDeserializer()).create();
                        Converter outputConverter = gson.fromJson(converterClient.convertCurrency(inputFCode,inputSCode,inputAmount), Converter.class);
                        System.out.println(outputConverter.toString());
                        codes = false;
                    }


                    break;
                case 9:
                    System.out.println("Tenga un buen dia!!");
                    executing =false;
                    break;
                default:
                    System.out.println("La opcion que selecciono no es valida por favor ingrese otra");
                    break;

            }
        }
    }
}