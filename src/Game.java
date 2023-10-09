package Game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
   private Player player;
   private Location location;
private String name;
Scanner sc=new Scanner(System.in);

    public Game() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game(Player player, Location location, String name) {
        this.player = player;
        this.location = location;
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void start() {
        System.out.println("Zindanlar diyarına Hoşgeldiniz!! \nBu diyarda sadece korku ve vahşet var!!");
        System.out.println("Lütfen oyuncu isminizi giriniz..");
        this.name = sc.nextLine();
        System.out.println("Karanlık Ormana giriş yaptın " + this.name);

        System.out.println("Lütfen bir karakter seçiniz..");

        System.out.println("1--- Okçu    Hasar:5 Sağlık : 18 Para: 22 ");
        System.out.println("2--- Büyücü  Hasar:7 Sağlık : 12 Para: 15");
        System.out.println("3--- Samuray Hasar:6 Sağlık : 15 Para: 14");
        int choice;
        choice = sc.nextInt();
        while (choice < 0 || choice > 3) {
            System.out.println("Lütfen 1 ile 3 arasında bir değer  girin!");
            choice = sc.nextInt();

        }
        switch (choice) {
            case 1:
                System.out.println("Hedefini doğru seç Okçu!!");
                player = new Archer();
                break;
            case 2:
                player = new Wizard();
                System.out.println("Sihirli kelimelerini kullan Büyücü!!");

                break;
            case 3:
                player = new Samurai();
                System.out.println("Kılıcın keskin olsun Samuray!!");
                break;
        }
        boolean isSafehouse=false;
        Location location = null;
        while (true) {
            System.out.println("Lütfen gitmek istediğiniz mekanı seçin--");
            System.out.println("0-- Çıkış");
            System.out.println("1-- Güvenli Ev");
            System.out.println("2-- Mağaza");
            System.out.println("3-- Orman");
            System.out.println("4-- Nehir");
            System.out.println("5-- Mağara");
            System.out.println("6-- Maden");

     int sec;
try {
     sec = sc.nextInt();
    switch (sec) {
        case 0:
            location = null;
            break;
        case 1:

                location = new SafeHouse(player);
                isSafehouse = true;


                break;

        case 2:
            location = new ToolStore(player);

            break;
        case 3:
            if(this.getPlayer().getInventory().isFireWood()==true){
            System.out.println("Bu bölge zaten açıldı.");
            System.out.println("Bu bölgeye tekrar giriş yapılamaz.");
            continue;
        }else{
            location = new Forest(player);
            break;
            }
        case 4:if(this.getPlayer().getInventory().isWater()==true){
            System.out.println("Bu bölge zaten açıldı.");
            System.out.println("Bu bölgeye tekrar giriş yapılamaz.");
            continue;
        }else {
            location = new River(player);
            break;
        }
        case 5:if(this.getPlayer().getInventory().isFood()==true){
            System.out.println("Bu bölge zaten açıldı.");
            System.out.println("Bu bölgeye tekrar giriş yapılamaz.");
            continue;
        }else {
            location = new Cave(player);
            break;
        }
        case 6:if(this.getPlayer().getInventory().isDiamond()==true){
            System.out.println("Bu bölge zaten açıldı.");
            System.out.println("Bu bölgeye tekrar giriş yapılamaz.");
            continue;
        }else {
            location = new Quarry(player);
            break;
        }
        default:
            System.out.println("Lütfen doğru bir değer girin.");
    }
}catch (InputMismatchException e){
    System.out.println("Lütfen doğru bir değer girin.");
}

            if(location==null) {
                System.out.println("Karanlık ormandan hemen vazgeçtin..");
                break;
            }

            if(!location.onLocation()) {
                System.out.println("Game Over");

                break;
            }


            if(location!=null) {
                location.buy();
            }

            if(isSafehouse==true && player.getInventory().isWater()==true && player.getInventory().isFireWood()==true && player.getInventory().isFood()==true &&player.getInventory().isDiamond()==true) {
                System.out.println("Tebrikler " +this.getName()+" oyunu kazandın!");
                System.out.println("Tüm düşmanları yendin ve tüm ödülleri topladın.");
                break;
            }
                isSafehouse=false;

        }
    }
}
