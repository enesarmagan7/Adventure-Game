package Game;

public class Armor {
    private String armorName;
    private int armorDefence;
      private int id;

    public Armor(int id,String armorName, int armorDefence) {
        this.armorName = armorName;
        this.armorDefence = armorDefence;
  this.id=id;
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
