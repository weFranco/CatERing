package businesslogic.foglioriepilogativo;

import businesslogic.menu.Section;
import businesslogic.recipe.Mansione;
import businesslogic.turni.TabelloneTurni;
import businesslogic.turni.Turno;

import java.util.ArrayList;
//TODO: da gestire con Turno e altre classi affini provenienti dal modello di dominio
public class FoglioRiepilogativo {
    private int id;
    private String name;
    private ArrayList<Compito> compiti;
    private TabelloneTurni tabellone;

    public FoglioRiepilogativo(String name){
        this.name=name;
        this.compiti=new ArrayList<>();
        this.tabellone=new TabelloneTurni();
    }

    public String getName() {
        return name;
    }

    public void addCompito(Compito c){
        if(this.compiti!=null)
            compiti.add(c);
    }

    public void addTab(TabelloneTurni mytab){
        this.tabellone=mytab;
    }

    public void orderCompito(Compito c,int position){
        this.compiti.remove(c);
        this.compiti.add(position,c);
    }

    public int getId() {
        return this.id;
    }

    public Compito selectCompito(int id){
        Compito temp = null;
        boolean found=false;
        int i=0;
        while(found==false&&compiti.size()!=0&&i<compiti.size()){
            temp=compiti.get(i);
            if(temp.getId()==id)
                found=true;
        }
        return temp;
    }

    public TabelloneTurni getTab(){
        return tabellone;
    }

    //TODO: da riscrivere col while
    public void indicaTempisticheNPorzioni(Compito currentC, int tempo, int porzioni) {
        if(compiti.contains(currentC)){
            currentC.setPorzioni(porzioni);
            if(tempo!=0)
                currentC.setTempoStimato(tempo);
        }
    }

    public FoglioRiepilogativo assegnaCompito(Turno t, Mansione m, int id) {
        Compito myCompito=null;
        int i=0;
        while(i<compiti.size()){
            if(compiti.get(i).getId()==id){
                myCompito=compiti.get(i);
                i=i+compiti.size();
            }
        i++;
        }
        myCompito=myCompito.assign(t,m);
        return this;
    }
}
