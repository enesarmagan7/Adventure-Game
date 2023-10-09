package Game;

import java.util.Random;

public class Quarry extends BattleLocation {

    public Quarry(Player player) {
        super(player, "Maden", new Snake(), 5);
    }


    public int maxObs()
    {
        Random random = new Random();
        int max = random.nextInt(getMaxObstacle()) + 1;
        return max;
    }


    @Override
    public boolean onLocation() {
        int obstacleNumber=this.maxObs();

        System.out.println("Dikkat burada " + obstacleNumber +" tane " + this.getObstacle().getName()+" yaşıyor!!");
        System.out.println("Buradaki "+ this.getObstacle().getName()+ " farklı hasarlar verebilir !!");
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
    public boolean combat(int obstacleNumber) {
        Random random = new Random();
        int defaultObstacleHealth=this.getObstacle().getHealth();
        for (int i = 1; i <=obstacleNumber; i++) {
            this.getObstacle().setHealth(defaultObstacleHealth);
            playerInfo();
            obstacleInfo(i);


            System.out.println("");
            //İlk Canavar mı yoksa karakterinmi vuracağını belirlemek için random sayı oluşturuyoruz.


            int randomValue = (int) (Math.random() * 2); // 0 veya 1

            if(randomValue==0){
                System.out.println("İlk Canavar Vurdu!!");
                //Maden Sınıfına özel karşımıza çıkan her Yılan Canavarının hasarı değişkenlik göstermektedir.
                //Bu nedenle randomDamage adlı değişkeni oluşturduk. Bu değişken 3 ile 6 arasında sayı üretir.
                int randomDamage = random.nextInt(6 - 3 + 1) + 3;
                this.getObstacle().setDamage(randomDamage);
                this.getPlayer().setHealth(this.getPlayer().getHealth()+this.getPlayer().getInventory().getArmor().getArmorDefence()-this.getObstacle().getDamage());
                System.out.println("Canınız: "+ this.getPlayer().getHealth());
                System.out.println(this.getObstacle().getName()+"Canı: " + this.getObstacle().getHealth());
            }
            while(this.getPlayer().getHealth()> 0 && this.getObstacle().getHealth()>0) {
                int randomDamage = random.nextInt(6 - 3 + 1) + 3;
                this.getObstacle().setDamage(randomDamage);
                //Canavarın karaktere verdiği hasarını hesaplama
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
                        //Canavarın sağlığı 0'dan küçük olamaz. Bunu belirtiriyoruz.
                        if(obsDamage<0){
                            obsDamage=0;
                        }

                        this.getPlayer().setHealth(this.getPlayer().getHealth()+this.getPlayer().getInventory().getArmor().getArmorDefence()-this.getObstacle().getDamage());

                        afterHit(i);
                        System.out.println();


                    }





                }else if(ınput.equals("K")) {

                    return false;
                }else{
                    System.out.println("Yanlış bir seçim yaptınız");
                    return false;
                }

            }
        }
        if (this.getObstacle().getHealth()<this.getPlayer().getHealth()){
            System.out.println("Düşmanı yendiniz");
            //Tüm yılanları öldürdüğümüzde bölümü bitirdiğimizi temsilen bir boolean değişkeni oluşturdum.
            this.getPlayer().getInventory().setDiamond(true);
            System.out.println("Bölüm sonu ödülü: Elmas");
            //Bölüm sonunda bir ödül kazanıp kazanılmadığını belirlemek için bir random sayı üretiyoruz.
            //Belirli yüzdelerde belirli ödüller var.
            //Yüzde hesabı yapmak için 1 ve 20 arasında (dahil) sayı üretiyoruz.
            //Sayı 1 ile 9(dahil) arasında çıkarsa hiç bir ödül kazanamıyoruz ve bu oran  %45'e denk geliyor.
            int randomAward = random.nextInt(20) + 1;
            //
            if(randomAward<=9){
                System.out.println("Hiç bir ödül düşmedi.");
            }
            //9 ve 13 arasında çıkarsa Karakterlere özel silahlar düşüyor.
            if(randomAward>9 &&randomAward<13 ){

                if(this.getPlayer().getName().equals("Okçu")){
                    System.out.println("'Arbalet' Kazandınız ");
                    this.getPlayer().getInventory().setWeapon(new Weapon(4,"Arbalet",10));
                }
                else if(this.getPlayer().getName().equals("Samuray")){
                    System.out.println("'Samuray Jack Kılıcı'  kazandınız!");
                    this.getPlayer().getInventory().setWeapon(new Weapon(4,"Samuray Jack Kılıcı",12));
                }
                else if(this.getPlayer().getName().equals("Büyücü")){
                    System.out.println("Albus Dumbledore'un Asasını kazandınız !");
                    this.getPlayer().getInventory().setWeapon(new Weapon(4,"Albus Dumbledore'un Asası",15));
                }


            }
            //12 ile 16 arasında çıkarsa karakterelere özel zırh düşüyor.
            else if(randomAward>12 &&randomAward<16 ){
                if(this.getPlayer().getName().equals("Okçu")) {
                    System.out.println("Demir Zırh kazandınız!");
                    this.getPlayer().getInventory().setArmor(new Armor(4,"Demir Zırh",8));
                }
                else if(this.getPlayer().getName().equals("Samuray")){
                    System.out.println("Buşido Kalkanı kazandınız!");
                     this.getPlayer().getInventory().setArmor(new Armor(4,"Buşido Kalkanı",8));
                }
                else if(this.getPlayer().getName().equals("Büyücü")){
                    System.out.println("Günateşi Kalkanı kazandınız!");
                    this.getPlayer().getInventory().setArmor(new Armor(4,"Günateşi Kalkanı",8));
                }
            }     //15 den büyük çıkarsa para ödülü kazanıyoruz.
                else if (randomAward>15 ) {
                System.out.println("Para Kazandınız");
                //Para ödülü de kendi içinde  olasılıkla verilecek.  1 5 ve 10 para kazanılabilir.
                int randomMoney = random.nextInt(10) + 1;   //Olasılık hesabı için random sayı üretilecek
                int money;
                if(randomMoney<3){
                    money=10;
                } else if(randomMoney>2 && randomMoney<6){
                    money=5;
                }
                else{
                    money=1;
                }
                System.out.println("Kazandığınız Para ödülü: " + money);
                this.getPlayer().setMoney(this.getPlayer().getMoney()+money);
                System.out.println("Güncel paranız : "+ this.getPlayer().getMoney());

            }


        }
        else {
            return false;
        }

        return true;
    }
    public void playerInfo(){
        System.out.println("Kalan canınız: "+ this.getPlayer().getHealth());
        System.out.println("Hasarınız: " + this.getPlayer().getInventory().getWeapon().getWeaponDamage());
        System.out.println("Paranız: " + this.getPlayer().getMoney());
        System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getArmorDefence());
        System.out.println("Silahınız: " + this.getPlayer().getInventory().getWeapon().getWeaponName());
        System.out.println("Zırhınız: " + this.getPlayer().getInventory().getArmor().getArmorName());

    }
    public void afterHit(int obs){
        System.out.println("Canınız: "+ this.getPlayer().getHealth());
        System.out.println(obs+ "."+this.getObstacle().getName()+ " Canı : " + this.getObstacle().getHealth());
        System.out.println("------------");
    }
    public void obstacleInfo(int obs){
        System.out.println(obs+ "."+this.getObstacle().getName()+ " Canı : " + this.getObstacle().getHealth());
        System.out.println(obs+ "."+this.getObstacle().getName()+ " Hasarı: " + this.getObstacle().getDamage());


    }




}
