package Game;

import java.util.Scanner;

public class Wizard extends Player {
    //Silah ve Zırhın yanlızca bir defa geliştirilmesini kontrol etmek için 2 adet boolean değişkeni oluşturuldu.
    private boolean isWeaponDeveloped;
    private boolean isArmorDeveloped;
    Scanner sc=new Scanner(System.in);
    public Wizard( ) {
        super( 12, 15, "Büyücü", new Inventory(new Weapon(1,"Büyü Ateşi",7),new Armor(1,"Büyü Pelerini",1)));
    }


    //Büyücü sınıfına özel Envanter satın alma sınıfı oluşturulması..
    //Seçili envanter yalnızca 1 defa satın alınılabilir.
    @Override
    public void buyItem(){
        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println();
        System.out.println("Silahlar\n 1-Malmortiosun Küresi -Hasar:10 -Fiyat:25");
        System.out.println("2-Gandalfın Asası  -Hasar:13 -Fiyat : 35");


        int choice=sc.nextInt();
        if(choice!=1 && choice!=2){
            System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyin!");
        }
        else if(choice==1 && this.getInventory().getWeapon().getWeaponName().equals("Malmortiosun Küresi")){
            System.out.println("Bu silah envanterinizde mevcut!");
        }
        else if(choice==2 && this.getInventory().getWeapon().getWeaponName().equals("Gandalfın Asası")){
            System.out.println("Bu silah envanterinizde mevcut!");
        }
       else if(choice==1 && this.getMoney()>25) {
           this.getInventory().setWeapon(new Weapon(2,"Malmortiosun Küresi",10));
            this.setMoney(this.getMoney()-25);
            System.out.println("Yeni Silahınız: "+ this.getInventory().getWeapon().getWeaponName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            this.isWeaponDeveloped=false;
        }


        else if(choice==2 && this.getMoney()>35) {
            this.getInventory().setWeapon(new Weapon(3,"Gandalfın Asası",13));
            this.setMoney(this.getMoney()-35);
            System.out.println("Yeni Silahınız: "+ this.getInventory().getWeapon().getWeaponName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            this.isWeaponDeveloped=false;
        }
        else {
            System.out.println("Yeterli Paranız yok");
        }

    }
    //Büyücü sınıfna özel zırh satın alma metodu
    //Seçili envanter yalnızca 1 defa satın alınılabilir.
    @Override
    public void buyArmor(){
        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println();
        System.out.println("Zırhlar\n 1-----Koruyucu Melek--Engelleme:3 Fiyat: 15");
        System.out.println("2----Galadrielin Pelerini-- Engelleme:5 Fiyat : 25");


        int choice=sc.nextInt();

        if(choice!=1 && choice!=2){
            System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyin!");
        }
        else if(choice==1 && this.getMoney()>15) {
          this.getInventory().setArmor(new Armor(2,"Koruyucu Melek",3));
            System.out.println("Yeni Zırhınız : " + this.getInventory().getArmor().getArmorName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            this.setMoney(8-this.getMoney());
            isArmorDeveloped=false;
        }


        else if(choice==2 && this.getMoney()>25) {
            this.getInventory().setArmor(new Armor(3,"Galadrielin Pelerini",5));
            System.out.println("Yeni Zırhınız : " + this.getInventory().getArmor().getArmorName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            this.setMoney(12-this.getMoney());
            this.isArmorDeveloped=false;
        }
        else {
            System.out.println("Yeterli Paranız yok");
        }

    }
    //Büyücü sınıfına özel envanter geliştirme metodu
    //Bu metot oyuncudaki envanterleri zırh veya silahı geliştirir.
    //Bir item yalnızca 1 defa geliştirilebilir.
    public void developItem(){

        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println("Geliştirilecek eşyanızı seçiniz: ");
        System.out.println("1-Silah Geliştirme(10 Altın)\n2-Zırh Geliştirme(8 Altın)");
        int choice=sc.nextInt();

        if(isWeaponDeveloped==false){
            System.out.println("Silahınız yalnızca 1 defa geliştirilebilir..");
        }
        else if(choice==1 && this.getMoney()>10) {
            this.getInventory().getWeapon().setWeaponDamage(this.getInventory().getWeapon().getWeaponDamage() + 2);
            System.out.println(this.getInventory().getWeapon().getWeaponName() + " +2 Geliştirildi");
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            this.setMoney(this.getMoney() - 10);
            this.isWeaponDeveloped = true;
        }else{
            System.out.println("Yeterli Paranız Yok");
        }

        if(isArmorDeveloped==false){
            System.out.println("Zırhınız yalnızca 1 defa geliştirilebilir.");
        }
        else if(choice==2 && this.getMoney()>8){
            this.getInventory().getArmor().setArmorDefence(this.getInventory().getArmor().getArmorDefence()+1);
            System.out.println(this.getInventory().getArmor().getArmorName()+" +1 Geliştirildi");
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            this.setMoney(this.getMoney()-8);
            this.isArmorDeveloped=true;

        }else{
            System.out.println("Yeterli Paranız Yok");
        }



    }
    //Can satın alınmsaı için oluşturulmuş metot.
    //Can potu (+5) can yeniler.
    @Override
    public void buyHealth(){
        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println("Can Yenilemek için 1 Tuşuna basın");

        int choice= sc.nextInt();
        if(choice==1 && this.getMoney()>10){
            this.setHealth(this.getHealth()+5);
            System.out.println("Canınız + 5 yenilendi.");
            System.out.println("Güncel Canınız :"+ this.getHealth());
            this.setMoney(this.getMoney()-10);
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
        }else if(this.getMoney()<10){
            System.out.println("Yeterli Paranız Yok");

        }
        else{
            System.out.println("Yanlış bir seçim yaptınız.");
        }
    }
}
