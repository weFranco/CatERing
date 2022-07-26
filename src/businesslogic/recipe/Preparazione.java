package businesslogic.recipe;

import businesslogic.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
* da rivedere ruolo di ricette e preparazioni
* */
public class Preparazione implements Mansione{
    private String nome;
    private ArrayList<Recipe> ricette;
    private ArrayList<Preparazione> preparazioni;
    private User proprietario;
    private User autore;
    private boolean fgAutore;
    private String descrizione;
    private int tempoExec;
    private int tipoTempoExec;
    private static Map<Integer, Preparazione> all = new HashMap<>();

    public Preparazione(String name){
        this.nome=name;
        ricette=new ArrayList<>();
        preparazioni=new ArrayList<>();
        proprietario=new User();
        autore=new User();
        fgAutore=false;
        descrizione="";
        tempoExec=0;
        tipoTempoExec=0;
    }


    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRicette(ArrayList<Recipe> ricette) {
        this.ricette = ricette;
    }

    public void setPreparazioni(ArrayList<Preparazione> preparazioni) {
        this.preparazioni = preparazioni;
    }

    public void setProprietario(User proprietario) {
        this.proprietario = proprietario;
    }

    public void setAutore(User autore) {
        this.autore = autore;
    }

    public void setFgAutore(boolean fgAutore) {
        this.fgAutore = fgAutore;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTempoExec(int tempoExec) {
        this.tempoExec = tempoExec;
    }

    public void setTipoTempoExec(int tipoTempoExec) {
        this.tipoTempoExec = tipoTempoExec;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Recipe> getRicette() {
        return ricette;
    }

    public ArrayList<Preparazione> getPreparazioni() {
        return preparazioni;
    }

    public User getProprietario() {
        return proprietario;
    }

    public User getAutore() {
        return autore;
    }

    public boolean isFgAutore() {
        return fgAutore;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public int getTempoExec() {
        return tempoExec;
    }

    public int getTipoTempoExec() {
        return tipoTempoExec;
    }

    //TODO:valutare se toglierla o meno e vedere DCD/DSD nel punto 2
    @Override
    public void add(Mansione m) {
        if(m!=null){
            Preparazione temp=(Preparazione) m;

        }
    }

    @Override
    public Preparazione create(String name) {
        Preparazione temp= new Preparazione(name);
        return temp;
    }

}
