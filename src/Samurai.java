package Game;

import java.util.Scanner;

public class Samurai extends Player {
    //Silah ve Zırhın yanlızca bir defa geliştirilmesini kontrol etmek için 2 adet boolean değişkeni oluşturuldu.
private boolean isArmorDeveloped;
private boolean isWeaponDeveloped;
    Scanner sc=new Scanner(System.in);
    public Samurai() {
        super(15, 14, "Samuray", new Inventory(new Weapon(1,"Samuray Kılıcı",6),new Armor(1,"Samuray kıyafeti",1)));
    }
    //Samuray sınıfına özel Envanter satın alma sınıfı oluşturulması..
    //Seçili envanter yalnızca 1 defa satın alınılabilir.
@Override
    public void buyItem(){
    System.out.println("Güncel Paranız: "+ this.getMoney());
    System.out.println();
     System.out.println("Silahlar\n 1-----Elmas Kılıç--Hasar:9 Fiyat:25");
     System.out.println("2----Kyuzo Kılıcı-- Hasar:12 Fiyat : 55");


    int choice=sc.nextInt();

    if(choice!=1 && choice!=2){
        System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyin!");
    }
       else if(choice==1 && this.getInventory().getWeapon().getWeaponName().equals("Elmas Kılıç")){
        System.out.println("Bu silah envanterinizde mevcut!");
    }
      else if(choice==2 && this.getInventory().getWeapon().getWeaponName().equals("Kyuzo Kılıcı")){
        System.out.println("Bu silah envanterinizde mevcut!");
    }
        else if(choice==1 && this.getMoney()>25) {
          this.getInventory().setWeapon(new Weapon(2,"Elmas Kılıç",9));
           this.setMoney(this.getMoney()-8);
        System.out.println("Yeni Silahınız: "+ this.getInventory().getWeapon().getWeaponName());
        System.out.println("Kalan bakiyeniz: "+ this.getMoney());
        isWeaponDeveloped=false;
        }


        else if(choice==2 && this.getMoney()>55) {
            this.getInventory().setWeapon(new Weapon(3,"Kyuzo Kılıcı",12));
            this.setMoney(12-this.getMoney());
        System.out.println("Yeni Silahınız: "+ this.getInventory().getWeapon().getWeaponName());
        System.out.println("Kalan bakiyeniz: "+ this.getMoney());
        isWeaponDeveloped=false;
        }
            else {
            System.out.println("Yeterli Paranız yok");
        }

    }
    //Samuray sınıfna özel zırh satın alma metodu
    //Seçili envanter yalnızca 1 defa satın alınılabilir.
    @Override
    public void buyArmor(){
        System.out.println("Güncel Paranız: "+ this.getMoney());
        System.out.println();
            System.out.println("Zırhlar\n 1-Kara Kuşak  -Engelleme:5 -Fiyat:15");
            System.out.println("2-Samuray Sensei   -Engelleme:7 -Fiyat : 25");


            int choice=sc.nextInt();

        if(choice!=1 && choice!=2){
            System.out.println("Yanlış seçim yaptınız lütfen tekrar deneyin!");
        }
        else if(choice==1 && this.getInventory().getArmor().getArmorName().equals("Kara Kuşak")){
            System.out.println("Bu zırh envanterinizde mevcut !!");
        }
        else if(choice==2 && this.getInventory().getArmor().getArmorName().equals("Samuray Sensei")){
            System.out.println("Bu zırh envanterinizde mevcut !!");
        }
            else if(choice==1 && this.getMoney()>15) {
                this.getInventory().setArmor(new Armor(2,"Kara Kuşak",5));
                this.setMoney(this.getMoney()-15);
            System.out.println("Yeni Zırhınız : "+ this.getInventory().getArmor().getArmorName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            isArmorDeveloped=false;
            }


            else if(choice==2 && this.getMoney()>25) {
               this.getInventory().setArmor(new Armor(3,"Samuray Sensei",5));
                this.setMoney(12-this.getMoney()-25);
            System.out.println("Yeni Zırhınız : "+ this.getInventory().getArmor().getArmorName());
            System.out.println("Kalan bakiyeniz: "+ this.getMoney());
            isArmorDeveloped=false;
            }
            else {
                System.out.println("Yeterli Paranız yok");
            }

        }
    //Samuray sınıfına özel envanter geliştirme metodu
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

