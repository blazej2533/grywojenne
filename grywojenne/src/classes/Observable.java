package classes;

public interface Observable {

    public void addObservator(Observator object);

    public void deleteObservator(Observator object);

    public void notifyObservator(Battle battle);
}
