package Game;

public abstract class Location {
   private Player player;
   private String name;

    public Location(Player player, String name) {
        this.player = player;

    }

    public void Location() {

    }
    public abstract boolean onLocation ();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void buy(){

    }
}

