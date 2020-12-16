package classes;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import org.junit.Test;

import java.util.*;

public class Battle implements Observable,Cloneable {



    Sekretarz sekretarz = new Sekretarz();

    List<Soldier> soldierList1 = new ArrayList<>();
    List<Soldier> soldierList2 = new ArrayList<>();
    General general1 = new General("Armia 1", 1000, soldierList1, this);
    General general2 = new General("Armia 2", 1000, soldierList2, this);

    private ArrayList<Observator> observators = new ArrayList<Observator>();

    @Override
    public void deleteObservator(Observator object) {


        observators.remove(object);

    }

    @Override
    public void addObservator(Observator object) {

        if (object != null)
            observators.add(object);

    }

    @Override
    public void notifyObservator(Battle battle) {

        for (Observator ob : observators)
            ob.update(battle);

    }

    public General getGeneral1() {
        return general1;
    }

    public void setGeneral1(General general1) {
        this.general1 = general1;
    }

    public General getGeneral2() {
        return general2;
    }

    public void setGeneral2(General general2) {
        this.general2 = general2;
    }

    @Override
    public Battle clone() {

        addObservator(sekretarz);

        Soldier soldier1 = new Soldier(Ranks.Serial, 3, 3);
        Soldier soldier2 = new Soldier(Ranks.Serial, 3, 3);
        Soldier soldier3 = new Soldier(Ranks.Capral, 2, 4);

        Soldier soldier4 = new Soldier(Ranks.Serial, 3, 3);
        Soldier soldier5 = new Soldier(Ranks.Serial, 3, 3);
        Soldier soldier6 = new Soldier(Ranks.Capitan, 2, 6);

        general1.addNewSoldier(soldier1);
        general1.addNewSoldier(soldier2);
        general1.addNewSoldier(soldier3);

        general2.addNewSoldier(soldier4);
        general2.addNewSoldier(soldier5);
        general2.addNewSoldier(soldier6);


        general1.buySoldier(Ranks.Major);
        general1.armyManeuver();
        general1.armyManeuver();
        general1.armyManeuver();


        general1.attackOtherGeneral(general1, general2);
        general1.attackOtherGeneral(general1, general2);
        try {
            return (Battle) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Battle();
        }

    }



}
