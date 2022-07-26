package businesslogic.foglioriepilogativo;

import businesslogic.UseCaseLogicException;
import businesslogic.menu.MenuEventReceiver;
import businesslogic.recipe.Mansione;
import businesslogic.turni.Turno;
import businesslogic.user.User;

import java.util.ArrayList;

public class FRManager {
    ArrayList<FoglioRiepilogativo> fr;
    ArrayList <FRReceiver> frReceivers;

    public FRManager(){
        fr=new ArrayList<>();
        frReceivers= new ArrayList<>();
    }

    public FoglioRiepilogativo createFoglioRiepilogativo(String name){
        FoglioRiepilogativo temp=new FoglioRiepilogativo(name);
        fr.add(temp);
        notifyFRCreated(temp);
        return temp;
    }
    //TODO: tutti i metodi vanno riscritti col while al posto della contains... cosi' non aggiorna
    public void modifyFR(FoglioRiepilogativo n, Compito c, User u)throws UseCaseLogicException{
        if(u.isChef()) {
            if (fr.contains(n)) {
                n.addCompito(c);
                notifyFRModified(n);
            }
        }else throw new UseCaseLogicException();
    }
/*
    public void modifydelFR(FoglioRiepilogativo n, Compito c, User u)throws UseCaseLogicException{
        if(u.isChef()) {
            if (fr.contains(n)) {
                n.addCompito(c);
                notifyFRModified(n);
            }
        }else throw new UseCaseLogicException();
    }
*/
    public void indicaTempisticheNPorzioni(FoglioRiepilogativo n, Compito currentC, User u, int tempo, int porzioni)throws UseCaseLogicException{
        if(u.isChef()) {
            if (fr.contains(n)) {
                n.indicaTempisticheNPorzioni(currentC,tempo,porzioni);
                notifyFRModified(n);
            }
        }else throw new UseCaseLogicException();
    }

    public void ordinaCompiti(FoglioRiepilogativo n,Compito c,int position,User u)throws UseCaseLogicException{
        if(u.isChef()) {
            if (fr.contains(n)) {
                n.orderCompito(c,position);
                notifyFRModified(n);
            }
        }else throw new UseCaseLogicException();
    }

    public FoglioRiepilogativo modificaStep(FoglioRiepilogativo f,Turno t, int id, Mansione m,User u){
        FoglioRiepilogativo currentFR=null;
        if(u.isChef()){
            int i=0;
            while(i<fr.size()){
                if(fr.get(i)==f){
                    currentFR=fr.get(i);
                    i=i+fr.size();
                }
                i++;
            }
        currentFR=currentFR.assegnaCompito(t,m,id);
        }
        notifyFRModified(currentFR);
        return currentFR;
    }

    public void addReceiver(FRReceiver i){
        this.frReceivers.add(i);
    }
    public void removeReceiver(FRReceiver i){
        this.frReceivers.remove(i);
    }

    private void notifyFRCreated(FoglioRiepilogativo temp) {
        for (FRReceiver er : this.frReceivers) {
            er.updateFoglioRiepilogativoAdded(temp);
        }
    }

    private void notifyFRModified(FoglioRiepilogativo temp) {
        for (FRReceiver er : this.frReceivers) {
            er.updateFRModified(temp);
        }
    }



}
