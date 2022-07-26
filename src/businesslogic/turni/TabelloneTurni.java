package businesslogic.turni;

import businesslogic.user.User;
import javafx.collections.FXCollections;

import java.util.ArrayList;
import java.util.Map;


//TODO: come collegare logicamente User a Cuoco(etc etc) e renderlo omogeneo nel modello di dominio?
public class TabelloneTurni {
    private static Map<Turno, User> loadTabellone = FXCollections.observableHashMap();

    public TabelloneTurni(){

    }

    public TabelloneTurni getTab() {
        return this;
    }

    public User scegliCuoco(Turno t) {
        User ret= loadTabellone.get(t);
        return ret;
    }
}