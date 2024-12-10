import java.io.*;
import java.util.Scanner;

public class es9 {

    public static void Ordinamento(int[] a) {
        try {
            FileWriter writer = new FileWriter("fileordinato.txt");
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) { // Corretta la logica di ordinamento
                    if (a[j] < a[i]) { // Ordinamento in ordine crescente
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            }
            for (int i = 0; i < a.length; i++) {
                writer.write(a[i] + " "); // Scrivi i numeri ordinati nel file
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace(); // Stampa l'eccezione per il debug
        }
        /*File file = new File ("fileordinato.txt");
            if (file.exists()){
                file.delete();
            }*/
    }
    public static void Ordinamento2(int[] a) {
        try {
            FileWriter writer = new FileWriter("fileordinato2.txt");
            for (int i = 0; i < a.length - 1; i++) {
                for (int j = i + 1; j < a.length; j++) { // Corretta la logica di ordinamento
                    if (a[j] > a[i]) { // Ordinamento in ordine decrescente
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            }
            for (int i = 0; i < a.length; i++) {
                writer.write(a[i] + " "); // Scrivi i numeri ordinati nel file
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace(); // Stampa l'eccezione per il debug
        }
        /*File file = new File ("fileordinato2.txt");
            if (file.exists()){
                file.delete();
            }*/
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Corretto il costruttore Scanner
        System.out.println("Inserisci il nome del file: ");
        String nome = in.next();
        try {
            FileWriter writer = new FileWriter(nome + ".txt");
            int n;
            System.out.println("Inserisci la quantita' di numeri da generare: ");
            int n1 = in.nextInt();
            int[] a = new int[n1];
            for (int i = 0; i < n1; i++) {
                do {
                    n = (int) (Math.random() * 101) + 100; // Corretto il range dei numeri casuali
                } while (n < 100);
                writer.write(n + " ");
                a[i] = n;
            }
            writer.close();
            in.close();
            Ordinamento(a);
            Ordinamento2(a);
           /* File file = new File (nome+".txt");
            if (file.exists()){
                file.delete();
            }*/
        } catch (Exception e) {
            e.printStackTrace(); // Stampa l'eccezione per il debug
        }
    }
}