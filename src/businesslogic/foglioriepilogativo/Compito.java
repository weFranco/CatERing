package businesslogic.foglioriepilogativo;

import businesslogic.recipe.Mansione;
import businesslogic.recipe.Preparazione;
import businesslogic.turni.Cuoco;
import businesslogic.turni.TabelloneTurni;
import businesslogic.turni.Turno;
import businesslogic.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Compito {
    private int id;
    private int porzioni;
    private int tempoStimato;
    private boolean compleato;
    private boolean inSvolgimento;
    private ArrayList<Mansione> mansioni;
    private TabelloneTurni tab;
    private User cc1;
    private Turno tr;

    private static Map<Integer, Compito> all = new HashMap<>();


    //TODO: da definire costruttore di compito
    public Compito(){
        id=0;
        porzioni=0;
        tempoStimato=0;
        compleato=false;
        inSvolgimento=false;
        mansioni=new ArrayList<>();
    }

    public Compito(int id,int porzioni, int tempoStimato, ArrayList<Mansione> mansioni) {
        this.id=id;
        this.porzioni = porzioni;
        this.tempoStimato = tempoStimato;
        this.inSvolgimento = false;
        this.mansioni = mansioni;
        this.compleato=false;
    }

    public void setPorzioni(int porzioni) {
        this.porzioni = porzioni;
    }

    public void setCompleato(boolean compleato) {
        this.compleato = compleato;
    }

    public void setTempoStimato(int tempoStimato) {
        this.tempoStimato = tempoStimato;
    }

    public void setInSvolgimento(boolean inSvolgimento) {
        this.inSvolgimento = inSvolgimento;
    }

    public void addMansione(Mansione m) {
        if(m!=null)
            mansioni.add(m);
    }



    public boolean isInSvolgimento() {
        return inSvolgimento;
    }

    public int getId() {
        return id;
    }

    //trovare senso al while qua sotto

    public Compito assign(Turno t, Mansione m) {
        tab=getTT();
        User cctemp=null;
        boolean f=false;
        while(f!=true){
            cctemp=tab.scegliCuoco(t);
            if(cctemp!=null)
                f=true;
        }
        this.setCompito(t,cctemp);
        this.addMansione(m);
    return this;
    }

    private void setCompito(Turno t, User cctemp) {
        this.tr=t;
        this.cc1=cctemp;
    }

    public TabelloneTurni  getTT(){
        TabelloneTurni newTab=null;
        newTab=newTab.getTab();
        return newTab;
    }

}