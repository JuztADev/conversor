package org.alurachallenge;

public class Menu {
    public static void printMenu(){
        System.out.println("Bienvenido al conversor de monedas\n Por favor eliga una de las siguientes opciones para continuar\n 1.Listar los todos los codigos de monedas disponibles\n 2.Buscar el codigo por nombre del pais\n 3.Convertir monedas,\n 9.Salir de la aplicacion");
    }
    public  static  void printSearchByCountry(){
        System.out.println("Para buscar por pais, por favor ingrese el nombre del pais,\n si el pais se encuentra disponible para la conversion, podra visualizar el codigo y \n el nombre de este en pantalla. Tenga en cuenta que los paises se encuentran en ingles");
    }
}
