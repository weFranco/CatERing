package businesslogic.turni;

import static java.lang.Math.abs;

public class Turno {
    private String data;
    private int orarioInizio;
    private int orarioFine;

    public Turno(int inizio, int fine,String d){
        this.data=d;
        this.orarioFine=fine;
        this.orarioInizio=inizio;
    }

    public int delta(){
        return abs(orarioFine-orarioInizio);
    }

}
