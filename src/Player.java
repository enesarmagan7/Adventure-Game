package Game;

public class Player {

    private int health;
    private int money;
    private String name;
   private Inventory inventory;

    public Player( int health, int money, String name, Inventory inventory) {

        this.health = health;
        this.money = money;
        this.name = name;
        this.inventory = inventory;
    }








    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
public void buyItem(){

}
    public void buyArmor() {

    }
public void developItem(){

}
public void buyHealth(){

}
    }
