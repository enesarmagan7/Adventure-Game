package Game;

public class SafeHouse extends NormalLocation {


    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    public boolean onLocation(){
        System.out.println("Güvenli Evdesiniz");
        return true;
    }
}
