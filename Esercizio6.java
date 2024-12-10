import java.io.*;
import java.util.Scanner;


public class Esercizio6{
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.println("inserisci il nome del file: ");
        String nome = in.next();
        try {
            FileReader reader = new FileReader(nome+".html");
            FileWriter write = new FileWriter(nome+"1.html");
            int c=reader.read();
            while(c!=-1){
                write.write((char) c);
                if (c==60){
                    write.write((char)1);
                }
                if (c==62){
                        write.write((char)13);
                    }  
                c=reader.read();
            }

        } catch (Exception e) {
        }
    }
}