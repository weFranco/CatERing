package businesslogic.turni;

public class PersonaleServizio extends Staff{
    private String nome;
    private String ruolo;

    public PersonaleServizio(String nome){
        super(nome);
        this.ruolo="PersonaleDiServizio";
    }
}
