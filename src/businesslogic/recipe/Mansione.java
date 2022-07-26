package businesslogic.recipe;

import businesslogic.user.User;

import java.util.ArrayList;

public interface Mansione {
    String nome="";
    ArrayList<Recipe> ricette=new ArrayList<>();
    ArrayList<Preparazione> preparazioni=new ArrayList<>();
    User proprietario=new User();
    User autore=new User();
    boolean fgAutore=true;
    String descrizione="";
    int tempoExec=0;
    int tipoTempoExec = 0;

    public void setNome(String nome);

    public void setRicette(ArrayList<Recipe> ricette);

    public void setPreparazioni(ArrayList<Preparazione> preparazioni);

    public void setProprietario(User proprietario);

    public void setAutore(User autore);

    public void setFgAutore(boolean fgAutore);

    public void setDescrizione(String descrizione);

    public void setTempoExec(int tempoExec);

    public void setTipoTempoExec(int tipoTempoExec);

    public String getNome();

    public ArrayList<Recipe> getRicette();

    public ArrayList<Preparazione> getPreparazioni();

    public User getProprietario();

    public User getAutore();

    public boolean isFgAutore();

    public String getDescrizione();

    public int getTempoExec();

    public int getTipoTempoExec();

    public void add(Mansione mans);

    public Mansione create(String name);

}
