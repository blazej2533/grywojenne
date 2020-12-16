package classes;

public class Sekretarz implements Observator {
    Battle oldValue;

    @Override
    public void update(Battle battle)   {
        if (oldValue != null) {
            if (battle.getGeneral1().getSoldierList().size() > oldValue.getGeneral1().getSoldierList().size()) {
                System.out.println("Żołnierz dołączył do "+battle.getGeneral1().getArmyName());
            }
            if (battle.getGeneral2().getSoldierList().size() > oldValue.getGeneral2().getSoldierList().size()) {
                System.out.println("Żołnierz dołączył do "+battle.getGeneral2().getArmyName());
            }
        }

        oldValue=battle.clone();



    }
    public static void main(String[] args) {
        Battle battle=new Battle();
        System.out.println("Raport końcowy \n");
        System.out.println(battle.getGeneral1().getArmyName());
        System.out.println("-----------------------");
        System.out.println("Ilość monet: "+battle.getGeneral1().getCoins());
        System.out.println("Ilość żołnierzy: "+battle.getGeneral1().getSoldierList().size());
        for(Soldier s:battle.getGeneral1().getSoldierList()){
            System.out.println("-"+s.toString());
        }
        System.out.println("Łączna siła armi: "+battle.getGeneral1().getTotalForceArmy()+"\n");

        System.out.println(battle.getGeneral2().getArmyName());
        System.out.println("-----------------------");
        System.out.println("Ilość monet: "+battle.getGeneral2().getCoins());
        System.out.println("Ilość żołnierzy: "+battle.getGeneral2().getSoldierList().size());
        for(Soldier s:battle.getGeneral2().getSoldierList()){
            System.out.println("-"+s.toString());
        }
        System.out.println("Łączna siła armi: "+battle.getGeneral2().getTotalForceArmy());


    }
}

