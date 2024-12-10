//Es1, in un file testo sono inseriti dei nomi, in un secondo file, inserisco i nomi ma con le lettere in maiuscolo
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class Es_file{

    public static void main(String []args){
        try { 
        File file = new File("nomi.txt");
        if (file.exists()){ //boolean true o false
            System.out.print("Il file esiste");
        }
        else{
            System.out.print("Il file non esiste");
        }
//da mettere sotto l'if 
        try (FileReader leggi = new FileReader("nomi.txt")) {
            int c;
            StringBuilder contenuto = new StringBuilder();
              //classe trovata su google, che contiene il metodo indexOf per contare le parole
            //String c1="";
            while ((c = leggi.read()) != -1) {  //inserire il contenuto all'interno di un istanza contenuto
                contenuto.append((char) c); 
                //c1=c1+(char)c;
            }
            String testo;
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("Contenuto del file 1:");
            System.out.println(contenuto.toString());
            System.out.println("---------------------------------------");
        
            testo = contenuto.toString();
            String a;
            a=testo.toUpperCase();
            
            try (FileWriter scrivi = new FileWriter("nomi1.txt")){
                scrivi.write(a);
                try (FileReader leggi1 = new FileReader("nomi1.txt")) {
                    int h;
                    StringBuilder contenuto1 = new StringBuilder();
            while ((h = leggi1.read()) != -1) {
                contenuto1.append((char) h); 
            }
            System.out.println("Contenuto del file 2:");
            System.out.println(contenuto1.toString());
            System.out.println("---------------------------------------");
                System.out.println(a);
            }
            
            catch(Exception e){
                e.printStackTrace();
            }
            
    }
    catch(Exception e){
        e.printStackTrace();
    }
}
    catch (Exception e) {
    e.printStackTrace();
        }
}
catch (Exception e) {
    e.printStackTrace();
        }
}
}