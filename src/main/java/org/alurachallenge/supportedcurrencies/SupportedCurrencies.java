package org.alurachallenge.supportedcurrencies;

import org.alurachallenge.Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class SupportedCurrencies {
    private HashMap<String, ArrayList<String>> supportedCurrencies;

    public SupportedCurrencies() {
        this.supportedCurrencies = new HashMap<String,ArrayList<String>>();
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("supportedc.txt");
            if (fileReader.ready()){
                bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine()) !=null){
                    String[] result = line.split(",");
                    ArrayList<String> strs = new ArrayList<>();
                    strs.add(result[2]);
                    strs.add(result[1]);
                    this.supportedCurrencies.put(result[0],strs);


                }
            }else{
                System.out.println("archivo no listo");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void searchByCountry(String st){
            boolean itemWasFound=false;
            st = st.toLowerCase().trim();
            Iterator<HashMap.Entry<String, ArrayList<String>>> iterator = this.supportedCurrencies.entrySet().iterator();

            while (iterator.hasNext()) {
                HashMap.Entry<String, ArrayList<String>> entry = iterator.next();
                String key = entry.getKey();
                ArrayList value = entry.getValue();
                if(st.equals(value.getFirst().toString().trim().toLowerCase())){
                    itemWasFound = true;
                    Console.printInBox(10,45,key,value.getFirst().toString());
                    break;
                }
            }
            if (!itemWasFound){
                System.out.println("Pais no encontrado");
            }
        }

    public void printAllCountries(){
        Iterator<HashMap.Entry<String, ArrayList<String>>> iterator = this.supportedCurrencies.entrySet().iterator();

        Console.printInBox(10,45,"Codigo","Nombre del Pais");
        while (iterator.hasNext()){
            HashMap.Entry<String, ArrayList<String>> entry = iterator.next();
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            Console.printInBox(10,45,key,value.getFirst());

        }
        Console.printBordersBox(10,false,"+","-");
        Console.printBordersBox(45,true,"+","-");
    }

    public boolean isAValidCode(String code){
        String codeUpper = code.toUpperCase();
        return  this.supportedCurrencies.containsKey(codeUpper);

    }


}
