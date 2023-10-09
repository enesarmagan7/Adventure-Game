package Game;

import java.util.Scanner;

public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {

        super(player,"Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya hoşgeldiniz.");
        System.out.println("Aşağıdaki eşyalardan birini satın alabilirsin.");
        return true;
    }
    // Satın alma metodu karaktere ait sınıfdan satın alma metodunu çağırır.
@Override
    public void buy(){
        System.out.println("1-Silahlar\n2-Zırhlar\n3-Envanter geliştirme\n4-Can Potu(+5 Can Yeniler)\nÇıkış Yapmak için herhangi bir tuşa bas");
    System.out.println();

        Scanner sc=new Scanner(System.in);
        int secim = sc.nextInt();
        switch (secim) {

            case 1:
                super.getPlayer().buyItem();     //1 ise Silah satın alma metodunu çağırır.
                break;
            case 2: super.getPlayer().buyArmor(); // 2 ise Zırh satın alma metodunu çağırır.
            break;
            case 3:super.getPlayer().developItem(); // 3 ise Eşya geliştirme metodunu çağırır.
                break;
            case 4:this.getPlayer().buyHealth(); //4 ise Can satın alma metodunu çağırır.
                break;
            default:  System.out.println("Doğru değer girmediniz");
            break;
        }
    }

}
