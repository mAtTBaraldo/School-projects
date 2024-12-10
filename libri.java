public class libri {
    private String nome, tipo, autore;
    private double  prezzo;
    private int quantita;
    public libri(String nome, String autore, String tipologia, double prezzo, int quantity){
        this.nome=nome;
        this.prezzo=prezzo;
        this.tipo=tipologia;
        this.autore=autore;
        this.quantita=quantity;
    }
    public String getNome(){
        return this.nome;
    }
    public String getTipo(){
        return this.tipo;
    }
    public String getAutore(){
        return this.autore;
    }
    public double getPrezzo(){
        return this.prezzo;
    }
    public int getQuantity(){
        return this.quantita;
    }
    public void setNome(String x1){
        this.nome=x1;
    }
    public void setTipo(String x1){
        this.tipo=x1;
    }
    public void setAutore(String x1){
        this.autore=x1;
    }
    public void setPrezzo(double x1){
        this.prezzo=x1;
    }
    public void setQuantity(int x1){
        this.quantita=x1;
    }
    public void stampa(){
        System.out.println("nome:"+getNome());
        System.out.println("autore:"+ getAutore());
        System.out.println("tipologia:"+getTipo());
        System.out.println("prezzo:"+getPrezzo());
        System.out.println("quantità:"+getQuantity());
    }
}
