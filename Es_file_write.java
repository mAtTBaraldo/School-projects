import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

    public class Es_file_write {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Inserisci la parola da cercare"); // inserire la parola da cercare
            String parola = in.nextLine();
            
            try {
                File provaFile = new File("Prova.txt");
                if (provaFile.exists()) {
                    // Check se esiste il file
                    System.out.println("Il file esiste - path del file:");
                    System.out.println(provaFile.getPath());
                } else {
                    System.out.println("Il file non esiste");
                }
    
                // Scrittura all'interno del file
                try (FileWriter scrivi = new FileWriter("Prova.txt")) {
                    scrivi.write("Ciao ");
                    scrivi.write("Mondo Ciao");
                }
    
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            // Lettura e conteggio parole all'interno del file
            try (FileReader leggi = new FileReader("Prova.txt")) {
                int c = leggi.read();
                StringBuilder contenuto = new StringBuilder();
                while (c != -1) {
                    contenuto.append((char) c);
                }
                System.out.println("------------------------------------------");
                System.out.println("Contenuto del file:");
                  while (c != -1) {
                    //stampa i caratteri del file
                    System.out.print((char) c);
                    c=leggi.read();
                }
                System.out.println("---------------------------------------");
                
                // Conteggio della parola con il metodo indexOf per gli oggetti
                int count = 0;
                int index = 0;
                while ((index = contenuto.indexOf(parola, index)) != -1) {
                    count++;
                    index += parola.length();
                }
    
                System.out.println("La parola '" + parola + "' è stata trovata " + count + " volte");
    
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }