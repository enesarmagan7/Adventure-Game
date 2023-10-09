package Game;

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLocation extends Location {
Obstacle obstacle;
    Scanner sc=new Scanner(System.in);

private int maxObstacle;
    public BattleLocation(Player player, String name, Obstacle obstacle, int maxObstacle) {
        super(player,name);
        this.obstacle = obstacle;
        this.maxObstacle=maxObstacle;

    }


    public Obstacle getObstacle() {
        return obstacle;
    }

    public boolean isAward() {

        return true;
    }



    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }


    public int maxObs() { //Canavar sayısını döndüren metot.

        Random random = new Random();
        int max = random.nextInt(getMaxObstacle()) + 1;
        return max;

    }


    @Override
    public boolean onLocation() {
        int obstacleNumber=this.maxObs();

        System.out.println("Dikkat burada " + obstacleNumber +" tane " + this.getObstacle().getName()+" yaşıyor!!");
        System.out.println("<S>avaş ya da <K>aç ");

        String input=sc.nextLine();
        String selectCase=input.toUpperCase();
        if(selectCase.equals("S" ) && combat(obstacleNumber)) {
            System.out.println("Tüm düşmanları yendiniz!!");

            return true;
        }
    if(this.getPlayer().getHealth()<=0) {
    System.out.println("Öldünüz");
    return false;
    }

        

    return true;

    }
    //Savaş Metodu
    public boolean combat(int obstacleNumber) {
        int defaultObstacleHealth=this.getObstacle().getHealth();  //Canavarın sağlığı
        for (int i = 1; i <=obstacleNumber; i++) {
            this.getObstacle().setHealth(defaultObstacleHealth);
            playerInfo();
            obstacleInfo(i);


            System.out.println("");
       //İlk Canavarın mı yoksa karakterin mi vuracağının belirlenmesi
            int randomValue = (int) (Math.random() * 2); // 0 veya 1

            if(randomValue==0){
                System.out.println("İlk Canavar Vurdu!!");
                this.getPlayer().setHealth(this.getPlayer().getHealth()+this.getPlayer().getInventory().getArmor().getArmorDefence()-this.getObstacle().getDamage());
                System.out.println("Canınız: "+ this.getPlayer().getHealth());
                System.out.println(this.getObstacle().getName()+" Canı: " + this.getObstacle().getHealth());
            }
     while(this.getPlayer().getHealth()> 0 && this.getObstacle().getHealth()>0) {

      //Canavarın karaktere vereceği hasar.
      int obsDamage=(this.getObstacle().getDamage()-this.getPlayer().getInventory().getArmor().getArmorDefence());



      // Kalan can miktarı
      System.out.println("Vurmak için 'V'  kaçmak için 'K' tuşuna bas! ");
      String ınput=sc.nextLine().toUpperCase();
      if(ınput.equals("V")) {
          System.out.println("Siz Vurdunuz!!");

          this.getObstacle().setHealth(this.getObstacle().getHealth()-this.getPlayer().getInventory().getWeapon().getWeaponDamage());
          afterHit(i);
          if(this.getObstacle().getHealth()>0) {
              System.out.println("Canavar vurdu!!");
              if(obsDamage<0){
                  obsDamage=0;
              }

              this.getPlayer().setHealth(this.getPlayer().getHealth()+this.getPlayer().getInventory().getArmor().getArmorDefence()-this.getObstacle().getDamage());

              afterHit(i);
              System.out.println();

          }





      }else {
          return false;
      }

  }
        }
     if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
      System.out.println("Düşmanı yendiniz");
      System.out.println("Kazandığınız Para ödülü: " + this.getObstacle().getAward());


         this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getObstacle().getAward());
         System.out.println("Güncel paranız : "+ this.getPlayer().getMoney());
         if(this.getObstacle().getName().equals("Vampir")) {
             this.getPlayer().getInventory().setFood(true);
             System.out.println("Bölüm sonu ödülü: Yemek");

         }else if(this.getObstacle().getName().equals("Zombi")){
             this.getPlayer().getInventory().setFireWood(true);
             System.out.println("Bölüm sonu ödülü: Odun");

         }else if (this.getObstacle().getName().equals("Ayı")){

             this.getPlayer().getInventory().setWater(true);
             System.out.println("Bölüm sonu ödülü: Su");

         }

     }
     else {
         return false;
     }

        return true;
    }
    //Oyuncu Bilgilerini yazdıran metot
        public void playerInfo(){
            System.out.println("Kalan canınız: "+ this.getPlayer().getHealth());
            System.out.println("Hasarınız: " + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
            System.out.println("Paranız: " + this.getPlayer().getMoney());
            System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getArmorDefence());
            System.out.println("Silahınız: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
            System.out.println("Zırhınız: " + this.getPlayer().getInventory().getArmor().getArmorName());

        }
        //Vuruş sonrası oluşan durumu yazdıran öetot
        public void afterHit(int obs){
            System.out.println("Canınız: "+ this.getPlayer().getHealth());
            System.out.println(obs+ "."+this.getObstacle().getName()+ " Canı : " + this.getObstacle().getHealth());
            System.out.println("------------");
        }
        //Canavar bilgilerini yazdıran metot
        public void obstacleInfo(int obs){
            System.out.println(obs+ "."+this.getObstacle().getName()+ " Canı : " + this.getObstacle().getHealth());
            System.out.println(obs+ "."+this.getObstacle().getName()+ " Hasarı: " + this.getObstacle().getDamage());


        }

    }

