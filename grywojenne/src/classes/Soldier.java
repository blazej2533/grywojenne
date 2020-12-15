package classes;

import java.util.ArrayList;

public class Soldier  {

    private Ranks ranks;
    private int experience;
    private int force;




    public Soldier(Ranks ranks, int experience, int force) {
        this.ranks = ranks;
        this.experience = experience;
        this.force = force;
    }


    @Override
    public String toString() {
        return "ranks=" + ranks +
                ", experience=" + experience +
                ", force=" + force ;
    }

    public Ranks getRanks() {
        return ranks;
    }

    public void setRanks(Ranks ranks) {
        this.ranks = ranks;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }



    public int getForce() {
        force =experience*ranks.getValue();
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public void updateRank(){
        if(experience==5*Ranks.Serial.getValue()){
            this.setRanks(Ranks.Capral);
            this.setExperience(1);
        }else if(experience==5*Ranks.Capral.getValue()){
            this.setRanks(Ranks.Capitan);
            this.setExperience(1);
        }else if(experience==5*Ranks.Major.getValue()){
            this.setRanks(Ranks.Major);
            this.setExperience(1);
        }
    }



}
