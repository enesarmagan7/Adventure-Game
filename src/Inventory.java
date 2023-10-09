package Game;

public class Inventory {
    private boolean water;
    private boolean food;
    public boolean diamond;
    private boolean fireWood;

    private Weapon weapon;
    private Armor armor;




    public Inventory(Weapon weapon,Armor armor){
        this.weapon = weapon;

        this.armor=armor;


    }

    public boolean isDiamond() {
        return diamond;
    }

    public void setDiamond(boolean diamond) {
        this.diamond = diamond;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFireWood() {
        return fireWood;
    }

    public void setFireWood(boolean fireWood) {
        this.fireWood = fireWood;
    }


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}