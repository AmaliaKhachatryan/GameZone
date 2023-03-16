package tournament;

public class Player {
    private int ID;
    private String name;
    private int strength;

    public Player(int ID, String name, int strength) {
        this.ID = ID;
        this.name = name;
        this.strength = strength;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}