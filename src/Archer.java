package Game;

import java.util.Scanner;

public class Archer extends Player {
//Silah ve Zırhın yanlızca bir defa geliştirilmesini kontrol etmek için 2 adet boolean değişkeni oluşturuldu.
    private boolean isWeaponDeveloped;
    private boolean isArmorDeveloped;

    Scanner sc=new Scanner(System.in);
    public Archer( ) {
        super(18, 22, "Okçu", new Inventory(new Weapon(1,"Ok Fırlatan",5),new Armor(1,"Okçu elbisesi",1)));

    }


    //Okçu sınıfına özel Envanter satın alma sınıfı oluşturulması..
    //Seçili envanter yalnızca 1 defa satın alınılabilir.
    @Override
    public void buyItem(){
        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println();
        System.out.println("Silahlar\n 1-----Hızlı Ok--Hasar:8 Fiyat:25");
        System.out.println("2----Zehirli Ok-- Hasar:13 Fiyat : 35");

        System.out.println("Lütfen seçim yapın: ");

        int choice=sc.nextInt();

        if(choice!=1 && choice!=2){
            System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyin!");
        }else if(choice==1 && this.getInventory().getWeapon().getWeaponName().equals("Hızlı Ok")){
            System.out.println("Bu silah envanterinizde mevcut!");
        }
        else if(choice==2 && this.getInventory().getWeapon().getWeaponName().equals("Zehirli Ok")){
            System.out.println("Bu silah envanterinizde mevcut!");
        }

        else if(choice==1 && this.getMoney()>25) {
            this.getInventory().setWeapon(new Weapon(2,"Hızlı Ok",8));
            this.setMoney(this.getMoney()-25);
            System.out.println("Yeni Silahınız: "+ this.getInventory().getWeapon().getWeaponName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            isWeaponDeveloped=false;
        }


        else if(choice==2 && this.getMoney()>35) {
            this.getInventory().setWeapon(new Weapon(3,"Zehirli Ok",13));
            this.setMoney(this.getMoney()-35);
            System.out.println("Yeni Silahınız: "+ this.getInventory().getWeapon().getWeaponName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            isWeaponDeveloped=false;
        }
        else {
            System.out.println("Yeterli Paranız yok");
        }

    }
    //Okçu sınıfna özel zırh satın alma metodu
    //Seçili envanter yalnızca 1 defa satın alınılabilir.
    @Override
    public void buyArmor(){
        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println();
        System.out.println("Zırhlar\n 1-Siyah Rüzgar -Engelleme:3 Fiyat:15 Altın");
        System.out.println("2-Altairin Zırhı -Engelleme:6 Fiyat : 25 Altın");


        int choice=sc.nextInt();
        if(choice!=1 && choice!=2){
            System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyin!");
        }
        else if(choice==1 && this.getInventory().getArmor().getArmorName().equals("Siyah Rüzgar")){
            System.out.println("Bu zırh envanterinizde mevcut !!");
        }
        else if(choice==2 && this.getInventory().getArmor().getArmorName().equals("Altairin Zırhı")){
            System.out.println("Bu zırh envanterinizde mevcut !!");
        }
        else if(choice==1 && this.getMoney()>15) {
               this.getInventory().setArmor(new Armor(2,"Siyah Rüzgar",3));
            this.setMoney(this.getMoney()-15);
            System.out.println("Yeni Zırhınız : "+ this.getInventory().getArmor().getArmorName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            isArmorDeveloped=false;
        }

        else if(choice==2 && this.getMoney()>25) {
            this.getInventory().setArmor(new Armor(3,"Altairin Zırhı",6));;
            this.setMoney(this.getMoney()-25);
            System.out.println("Yeni Zırhınız : "+ this.getInventory().getArmor().getArmorName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            isArmorDeveloped=false;
        }
        else {
            System.out.println("Yeterli Paranız yok");
        }

    }
    //Okçu sınıfına özel envanter geliştirme metodu
    //Bu metot oyuncudaki envanterleri zırh veya silahı geliştirir.
    //Bir item yalnızca 1 defa geliştirilebilir.
    @Override
    public void developItem(){
        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println();
        System.out.println("Geliştirilecek eşyanızı seçiniz: ");
        System.out.println("1-Silah Geliştirme(10 Altın)\n2-Zırh Geliştirme(8 Altın)");

        int choice=sc.nextInt();
switch (choice) {
    case 1: if (isWeaponDeveloped == true) {
        System.out.println("Silahınız yalnızca 1 defa geliştirilebilir..");
    } else if ( this.getMoney() > 10) {
        this.getInventory().getWeapon().setWeaponDamage(this.getInventory().getWeapon().getWeaponDamage() + 2);
        System.out.println(this.getInventory().getWeapon().getWeaponName() + " +2 Geliştirildi");
        System.out.println("Kalan bakiyeniz: "+ this.getMoney());
        this.setMoney(this.getMoney() - 10);
        this.isWeaponDeveloped = true;
    } else {
        System.out.println("Yeterli Paranız Yok");
    }
    break;


    case 2: if (isArmorDeveloped == true) {
        System.out.println("Zırhınız yalnızca 1 defa geliştirilebilir.");
    } else if ( this.getMoney() > 8) {
        this.getInventory().getArmor().setArmorDefence(this.getInventory().getArmor().getArmorDefence() + 1);
        System.out.println(this.getInventory().getArmor().getArmorName() + " +1 Geliştirildi");
        System.out.println("Kalan bakiyeniz: "+ this.getMoney());
        this.setMoney(this.getMoney() - 8);
        this.isArmorDeveloped = true;

    } else {
        System.out.println("Yeterli Paranız Yok");
    }
    break;
    default:
        System.out.println("Yanlış bir seçim yaptınız. Lütfen tekrar deneyiniz.");
}


    }
    @Override
    public void buyHealth(){
        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println("Can Yenilemek için 1 Tuşuna basın");

        int choice= sc.nextInt();
        if(choice==1 && this.getMoney()>10){
            this.setHealth(this.getHealth()+5);
            this.setMoney(this.getMoney()-10);
            System.out.println("Canınız + 5 yenilendi.");
            System.out.println("Güncel Canınız :"+ this.getHealth());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
        }else if(this.getMoney()<10){
            System.out.println("Yeterli Paranız Yok");

        }
        else{
            System.out.println("Yanlış bir seçim yaptınız.");
        }
    }

}
