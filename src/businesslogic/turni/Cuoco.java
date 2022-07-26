package businesslogic.turni;

public class Cuoco extends Staff{
    public String nome;
    public String ruolo;

    public Cuoco(String nome){
        super(nome);
        this.ruolo="Cuoco";
    }
}
