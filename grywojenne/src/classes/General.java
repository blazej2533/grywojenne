package classes;
import java.util.*;
import java.util.List;


public class General {
    private String armyName;
    private double coins;
    private List<Soldier> soldierList;
    private Battle battle;

    public General(String armyName, double coins, List<Soldier> soldierList, Battle battle) {
        this.armyName = armyName;
        this.coins = coins;
        this.soldierList = soldierList;
        this.battle = battle;
    }

    public String getArmyName() {
        return armyName;
    }

    public void setArmyName(String armyName) {
        this.armyName = armyName;
    }

    public Battle getBattle() {
        return battle;
    }

    public void setBattle(Battle battle) {
        this.battle = battle;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }

    public List<Soldier> getSoldierList() {
        return soldierList;
    }

    @Override
    public String toString() {
        return soldierList.toString();
    }

    public void armyManeuver(){
        int coinsThisGeneral=0;
        for(Soldier soldier:soldierList){
            soldier.setExperience(soldier.getExperience()+1);
            coinsThisGeneral=coinsThisGeneral+soldier.getRanks().getValue();
        }
        this.setCoins(this.getCoins() - coinsThisGeneral) ;
    }


    public void buySoldier(Ranks type) {
        Soldier soldier=new Soldier(type,1,type.getValue());
        this.coins=this.coins-(10*type.getValue());
        this.soldierList.add(soldier);

    }

    public int getTotalForceArmy(){
        int totalForce=0;
        for (Soldier s:soldierList){
            totalForce=totalForce+s.getForce();
        }
        return totalForce;
    }

    public void attackOtherGeneral(General general1,General general2){
        int forceOfSecondGeneral=general2.getTotalForceArmy();
        int forceOfFirstGeneral=general1.getTotalForceArmy();
        List<Soldier> found = new ArrayList<Soldier>();
        if(forceOfFirstGeneral>forceOfSecondGeneral){
            general1.setCoins(general1.getCoins()+(general2.getCoins()*0.1));
            general2.setCoins(general2.getCoins()-(general2.getCoins()*0.1));
            for(Soldier s: general2.soldierList){
                s.setExperience(s.getExperience()-1);
                s.setForce(s.getExperience()*s.getRanks().getValue());

                if(s.getExperience()==0){
                    found.add(s);
                }
            }
            for(Soldier s:general1.soldierList){
                s.setExperience(s.getExperience()+1);
            }

        }

        if(forceOfFirstGeneral<forceOfSecondGeneral){
            general2.setCoins(general2.getCoins()+(general1.getCoins()*0.1));
            general1.setCoins(general1.getCoins()-(general1.getCoins()*0.1));
            for(Soldier s: general1.soldierList){
                s.setExperience(s.getExperience()-1);
                s.setForce(s.getExperience()*s.getRanks().getValue());
                if(s.getExperience()==0){
                    found.add(s);
                }


            }
            for(Soldier s:general2.soldierList){
                s.setExperience(s.getExperience()+1);

            }
        }
        general1.soldierList.removeAll(found);
        general2.soldierList.removeAll(found);

        if(forceOfFirstGeneral==forceOfSecondGeneral){
            Collections.shuffle(general1.soldierList);
            general1.soldierList.remove(0);
            Collections.shuffle(general2.soldierList);
            general2.soldierList.remove(0);
        }

    }

    public void addNewSoldier(Soldier soldier){
        this.soldierList.add(soldier);
        battle.notifyObservator(this.battle);

    }


}
