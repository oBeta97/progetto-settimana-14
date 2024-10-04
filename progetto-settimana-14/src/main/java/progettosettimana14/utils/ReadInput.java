package progettosettimana14.utils;

import java.util.Scanner;

public class ReadInput {

    public static int readNumber(String question, Scanner s){

        int res = 0;
        while (true) {
            System.out.println(question);

            try{
                res = Integer.parseInt(s.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("valore non valido");
            }
        }

        return res;

    }

    public static String readString(String question, Scanner s){
        System.out.println(question);
        return s.nextLine();
    }

    public static boolean readYN(String question, Scanner s){

        String res = "";
        while (true) {
            System.out.println(question + " (y/n)");

            try{
                res = s.nextLine();
                if (!res.equals("y") && !res.equals("n"))
                    throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("valore non valido");
            }
        }

        return res.equals("y");
    }

}