package classes;

import org.junit.Test;

import java.util.*;

public class Battle implements Observable {
    private ArrayList<Observator> observators= new ArrayList<Observator>();
    @Override
    public void deleteObservator(Observator object) {

        observators.remove(object);

    }

    @Override
    public void addObservator(Observator object) {

        if(object!=null)
            observators.add(object);

    }

    @Override
    public void notifyObservator(Battle battle) {

        for(Observator ob:observators)
            ob.update();

    }

    public Battle() {
        Soldier soldier1 = new Soldier(Ranks.Serial, 3, 3);
        Soldier soldier2 = new Soldier(Ranks.Serial, 3, 3);
        Soldier soldier3 = new Soldier(Ranks.Capral, 2, 4);

        Soldier soldier4 = new Soldier(Ranks.Serial, 3, 3);
        Soldier soldier5 = new Soldier(Ranks.Serial, 3, 3);
        Soldier soldier6 = new Soldier(Ranks.Capitan, 2, 6);

        List<Soldier> soldierList1 = new ArrayList<>();
        List<Soldier> soldierList2 = new ArrayList<>();

        //soldierList2.add(soldier4);


        General general1 = new General("Armia 1", 1000, soldierList1,this);
        General general2 = new General("Armia 2", 1000, soldierList2,this);

        general1.addNewSoldier(soldier1);
        general1.addNewSoldier(soldier2);
        general1.addNewSoldier(soldier3);

        general2.addNewSoldier(soldier4);
        general2.addNewSoldier(soldier5);
        general2.addNewSoldier(soldier6);
        
        general1.buySoldier(Ranks.Major);
        general1.armyManeuver();

        general1.attackOtherGeneral(general1, general2);
        general1.attackOtherGeneral(general1, general2);


    }



}