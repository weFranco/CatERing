package businesslogic.foglioriepilogativo;

import businesslogic.UseCaseLogicException;

import java.util.ArrayList;

public class CompitoManager {
    ArrayList<Compito> c;


    public boolean getCompitoInSvolgimento(Compito curr) throws UseCaseLogicException {
        if(c.contains(curr)&&curr!=null)
            return curr.isInSvolgimento();
        else throw new UseCaseLogicException();
    }
}
