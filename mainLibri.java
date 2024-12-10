import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;
public class mainLibri {
    public static Scanner in = new Scanner (System.in);
   
    public static void remove(ArrayList <libri> x){  //FUNZIONE PER ELIMINARE IL LIBRO TRAMITE IL NOME
    stampa(x);
    System.out.println("inserisci il nome del libro che vuoi rimuovere:");
    String nome=in.next().toLowerCase();
    boolean found = false; 
    for (int i = 0; i < x.size(); i++) { 
        if (x.get(i).getNome().equals(nome)) {
            x.remove(i);
            found = true; 
            System.out.println("Libro rimosso con successo!");
            try {
                saveToFile(x);
            } catch (Exception e) {
                e.printStackTrace();
            }
            break; 
        }
    }
    if (!found) {
        System.out.println("Nessun libro trovato con il nome: " + nome);
            }
        }


    public static void stampa(ArrayList <libri> x){
        for (libri l : x){
            l.stampa();
            System.out.println();
         }
    }



    public static void add(ArrayList <libri> x) throws InterruptedException{ //FUNZIONE PER AGGIUNGERE LIBRI
        String nome, autore, tipologia;
        double prezzo;
        int quantita;
        System.out.println("inserisci il nome del libro:");
        in.nextLine();
        nome=in.nextLine().toLowerCase();
        System.out.println("inserisci il nome dell'autore:");
        autore=in.nextLine().toLowerCase();
        System.out.println("inserisci il tipo di libro: ");
        tipologia=in.nextLine().toLowerCase();
        System.out.println("inserisci il prezzo: ");
        prezzo = in.nextDouble();
        System.out.println("inserisci la quantità: ");
        quantita = in.nextInt();
        libri libro = new libri(nome, tipologia, autore, prezzo, quantita);
        x.add(libro);
        System.out.println("libro aggiunto con successo!");
        try {
            saveToFile(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modify(ArrayList<libri> x) { //FUNZIONE PER MODIFICARE IL LIBRO
        System.out.println("Quale libro vuoi modificare?");
        stampa(x);
        System.out.println("Cosa vuoi modificare?");
        String changes;
        in.nextLine();
        changes = in.nextLine();
        String[] cambi = {"nome", "autore", "prezzo", "tipologia", "quantita"};
        boolean sceltaValida = false;
        for (String i : cambi) {  //controllo se la scelta da cambiare è valida
            if (changes.equals(i)) {
                sceltaValida = true;
                break;
            }
        }
        if (!sceltaValida) {
            System.out.println("Scelta non valida!");
            return;
        }
        Boolean found = false;
        for (libri l : x) { //ciclo per fare in modo di poter modificare i libri
            System.out.println("inserisci il nome del libro che vuoi modificare");
            String nome = in.nextLine().toLowerCase();
            if (l.getNome().equals(nome)) {   //se si fa giusto il nome del libro e' possibile modificarlo
                found = true;
                System.out.println("inserisci il nuovo valore");
                switch (changes) {
                    case "nome" -> {
                        String nuovoNome = in.nextLine().toLowerCase();
                        l.setNome(nuovoNome);
                    }
                    case "autore" -> {
                        String nuovoAutore = in.nextLine().toLowerCase();
                        l.setAutore(nuovoAutore);
                    }
                    case "tipologia" -> {
                        String nuovaTipologia = in.nextLine().toLowerCase();
                        l.setTipo(nuovaTipologia);
                    }
                    case "prezzo" -> {
                        double newPrice = in.nextDouble();
                        in.nextLine(); 
                        l.setPrezzo(newPrice);
                    }
                    default -> {
                        int newQuantity = in.nextInt();
                        in.nextLine();
                        l.setQuantity(newQuantity);
                    }
                }
                break;
            }
        }
        try {
            saveToFile(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!found) {
            System.out.println("Nessun libro trovato");
        }
    }
    public static void found(ArrayList<libri> x){  //FUNZIONE PER CERCARE IL LIBRO
        System.out.println("come vuoi cercare in libro?");
        String modi;
        modi = in.next();
        String[] opzioni={"nome","autore","prezzo","tipologia", "quantita"};
        boolean sceltaValida = false;
        for (String i: opzioni){  //controllo se la scelta è valida
            if (modi.equals(i)){
                sceltaValida = true;
                break;
            }
        }
        if (!sceltaValida){
            System.out.println("Scelta non valida!");  
            return;
        }
        switch (modi){
            case "nome" -> { //MODO PER TROVARE IL LIBRO TRAMITE nome
                System.out.println("inserisci il nome del libro:");
                in.nextLine();
                String nome=in.nextLine();
                boolean found = false;
                for (libri l : x) {
                    if (l.getNome().equals(nome)) {
                        l.stampa();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Nessun libro trovato con il nome: " + nome);
                }
            }
            case "autore" -> { //MODO PER TROVARE IL LIBRO TRAMITE autore
                System.out.println("inserisci il nome dell'autore:");
                in.nextLine();
                String autore=in.nextLine();
                boolean found = false;
                for (libri l : x) {
                    if (l.getAutore().equals(autore)) {
                        l.stampa();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Nessun libro trovato con l'autore: " + autore);
                }
            }
            case "prezzo" -> { //MODO PER TROVARE IL LIBRO TRAMITE PREZZO
                System.out.println("inserisci il prezzo del libro:");
                double prezzo = in.nextDouble();
                boolean found = false;
                for (libri l : x) {
                    if (l.getPrezzo() == prezzo) {
                        l.stampa();
                        found = true;
                        break;
                    }
                }
                    if (!found) {
                        System.out.println("Nessun libro trovato con il prezzo: " + prezzo);
                    }
                    }
            case "tipologia" -> {  //MODO PER TROVARE IL LIBRO TRAMITE TIPOLOGIA
                System.out.println("inserisci il tipo di libro:");
                in.nextLine();
                String tipologia=in.nextLine();
                boolean found = false;
                for (libri l : x) {
                    if (l.getTipo().equals(tipologia)) {
                        l.stampa();
                        found = true;
                        break;
                    }
                }
                
                if (!found) {
                    System.out.println("Nessun libro trovato con la tipologia: " + tipologia);
                }
            }
        case "quantita" -> {  //MODO PER TROVARE IL LIBRO TRAMITE quantita'
                System.out.println("inserisci la quantità di libro:");
                int quantity=in.nextInt();
                boolean found = false;
                for (libri l : x) {
                    if (l.getQuantity()==(quantity)) {
                        l.stampa();
                        found = true;
                        break;
                    }
                }
                    if (!found) {
                    System.out.println("Nessun libro trovato con questa quantità: " + quantity);
                }
            }
        }
    }

    public static void clearScreen(int time) {  //metodo per pulire lo schermo
        try {
            Thread.sleep(time);
            System.out.print("\033[H\033[2J");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    public static void exit() throws Exception{  //metodo per l'uscita dal programma con una barra di caricamento
        String [] caricamento = {"/","-","|"};
        for (int i= 0; i<6;i++){
        for (int j = 0; j < 3; j++) {
        System.out.print("Loading: "+caricamento[j]);
        clearScreen(200);
        }
    }
        System.out.println("Uscita effettuata con successo!");
    }
    public static void saveToFile(ArrayList<libri> x)throws Exception{ //metodo per aggiungere il libro al .txt
        String nome= "Libri.txt";
        FileWriter writer = new FileWriter(nome);
        for (libri libro : x) {
        writer.append("nome: " + libro.getNome() + "\n");
        writer.append("Autore: " + libro.getAutore() + "\n");
        writer.append("tipologia: " + libro.getTipo() + "\n");
        writer.append("prezzo: " + libro.getPrezzo() + "\n");
        writer.append("quantità: " + libro.getQuantity() + "\n");
        writer.append("\n");
    }
    writer.close();
    }
    public static ArrayList<libri> loadBooksFromFile() { //metodo per "scaricare" i libri dal .txt
        ArrayList<libri> librilist = new ArrayList<>();
        String filename = "Libri.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            String nome = "", autore = "", tipologia = "";
            double prezzo = 0.0;
            int quantita = 0;

            while ((line = br.readLine()) != null) {   //con buffered reader leggo la linea
                if (line.startsWith("nome:")) {  //metodo per le stringhe verifcando il prefisso (metodo boolean)
                    nome = line.substring(5).trim();  //substring da indice 5 (nome:)
                } else if (line.startsWith("Autore:")) {
                    autore = line.substring(7).trim();
                } else if (line.startsWith("tipologia:")) {
                    tipologia = line.substring(10).trim();
                } else if (line.startsWith("prezzo:")) {
                    prezzo = Double.parseDouble(line.substring(7).trim());
                } else if (line.startsWith("quantità:")) {
                    quantita = Integer.parseInt(line.substring(10).trim());
                }
                // se la linea e' vuota abbiamo raggiunto la fine del libro
                if (line.isEmpty()) {
                    if (!nome.isEmpty()) {
                        libri libro = new libri(nome, tipologia, autore, prezzo, quantita);
                        librilist.add(libro);
                    }
                    // resettiamo le variabili da leggere
                    nome = autore = tipologia = "";
                    prezzo = 0.0;
                    quantita = 0;
                }
            }

            // controllo per l'ultimo libro
            if (!nome.isEmpty()) {
                libri libro = new libri(nome, tipologia, autore, prezzo, quantita);
                librilist.add(libro);
            }

        } catch (IOException e) {
            System.out.println("si e' verificato un errore: " + e.getMessage());
        }

        return librilist;
    }


    public static void main(String[] args) throws InterruptedException, Exception{ //main con i throws exception
    ArrayList <libri> librilist = new ArrayList<>();
    librilist=loadBooksFromFile();
    String[] opzioni= {"1)aggiungi libro","2)rimuovi libro","3)modifica libro","4)stampa lista","5)cerca libro","6)EXIT"}; //cose che si possono fare
    boolean n = true;
    while (n){  //while true
    System.out.println("Scegli l'opzione da svolgere:");
    for (String i: opzioni){
        System.out.println(i);
    }
    int option;
        while (true) {
            try {
                option = in.nextInt();
                break; 
            } catch (InputMismatchException e) {  //se si inserisce un input non valido
                System.out.println("Input non valido. Per favore inserisci un numero intero.");
                in.next();
            }
        }
        if (option > 6 || option <1){ //se si inserisce un input non valido
            System.out.println("Opzione non valida");
        }
    switch (option) { //richiamo di tutti i metodi per le opzioni con controlli
        case 1 -> add(librilist);  
        case 2 -> {
            if (!librilist.isEmpty()) {
                remove(librilist);
            } else {
                System.out.println("Nessun libro disponibile da rimuovere.");
            }
        }
        case 3 -> {
            if (!librilist.isEmpty()) {
                modify(librilist);
            } else {
                System.out.println("Nessun libro disponibile da modificare.");
            }
        }
        case 4 ->{
            if (!librilist.isEmpty()) {
                stampa(librilist);
            } else {
                System.out.println("lista vuota.");
            }
        }
        case 5 -> {
            if (!librilist.isEmpty()) {
                found(librilist);
            } else {
                System.out.println("Nessun libro disponibile da cercare.");
            }
        }
        case 6 -> {
            try {
                exit();
            } catch (Exception e) {
            }
            n=false;
        } 
    }
    clearScreen(3000);  //si pulisce lo schermo
  }
 }  
}