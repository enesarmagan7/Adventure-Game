package Game;

public class Obstacle {
    //Canavar sınıfının değişkenlerinin oluşturulması
    //Her canavarın hasarı, sağlığı, adı ve ödülü tamımlandı.
    private int id;
    private int damage;
    private int health;
    private String name;
    private int award;
    public Obstacle(int id, int damage, int health, String name,int award) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.name = name;
        this.award=award;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHealth(int health) {

        if(health<0){
            health=0;
        }
        this.health = health;
    }
}
