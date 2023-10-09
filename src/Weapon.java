package Game;

public class Weapon {
    private String weaponName;
    private int weaponDamage;
private int id;

    public Weapon(int id,String weaponName, int weaponDamage) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;

    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
