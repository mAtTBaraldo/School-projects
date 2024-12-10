import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

    public class Es_file_write2 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Inserisci la parola da cercare"); // inserire la parola da cercare
            String parola = in.nextLine();
            String nome = "Prova.txt";
            try {
                File provaFile = new File(nome);
                if (provaFile.exists()) {
                    // Check se esiste il file
                    System.out.println("Il file esiste - path del file:");
                    System.out.println(provaFile.getPath());
                } 
                else if (provaFile.createNewFile()){   //se il file non esiste, lo si crea
                    System.out.println("Il file "+ nome + " è stato creato");
                }
                else {
                    System.out.println("Il file non esiste");
                }
    
                // Scrittura all'interno del file
                try (FileWriter scrivi = new FileWriter("Prova.txt")) {
                    scrivi.write("Ciao ");
                    scrivi.write("Mondo Ciao");
                    scrivi.write(", questa e' una prova con i file, Ciao.");
                }
    
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            // Lettura e conteggio parole all'interno del file
            try (FileReader leggi = new FileReader("Prova.txt")) {
                int c;
                StringBuilder contenuto = new StringBuilder();  //classe trovata su google, che contiene il metodo indexOf per contare le parole
                while ((c = leggi.read()) != -1) {
                    contenuto.append((char) c);
                }
                System.out.println("------------------------------------------");
                System.out.println("Contenuto del file:");
                System.out.println(contenuto.toString());
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
            in.close();
        }
    }