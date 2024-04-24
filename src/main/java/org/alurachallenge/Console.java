package org.alurachallenge;

public class Console {
    public static void insertBlankSpaceInConsole() {
        System.out.println("--------------------------\n--------------------------");
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("--------------------------\n--------------------------");

    }
    public static void printInBox(int fBoxSize, int sBoxSize, String txtFBox, String txtSBox){
        printBordersBox(fBoxSize,false,"+","-");
        printBordersBox(sBoxSize,true,"+","-");
        System.out.print("|");
        System.out.print(calcSpaces(txtFBox,fBoxSize));
        System.out.print("|");
        System.out.print("|");
        System.out.print(calcSpaces(txtSBox,sBoxSize));
        System.out.println("|");
        printBordersBox(fBoxSize,false,"|"," ");
        printBordersBox(sBoxSize,true,"|"," ");

    }
    public static void printBordersBox(int boxSize, boolean ln, String filler,String sFiller){
        System.out.print(filler);
        for (int i = 0; i < boxSize; i++) {
            System.out.print(sFiller);

        }
        System.out.print(filler);
        if (ln){
            System.out.println(" ");
        }
    }
    public static String calcSpaces(String text, int size){
        size = size - (text.length()+1);
        StringBuilder txtWSpaces = new StringBuilder(" " + text);
        for (int i = 0; i < size; i++) {
            txtWSpaces.append(" ");
        }
        return txtWSpaces.toString();
    }
}
