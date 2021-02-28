package homework_two;
import java.util.ArrayList;
import java.util.Scanner;
public class homework3 {
    public static void main(String[] args){
        ArrayList<Laptop> array = new ArrayList<Laptop>();
        add(array);

        while(true){
            int choose = chooseFunction();
            switch(choose){
                case 1:
                    printArrayList(array);
                    break;

                case 2:
                    changeCount(array);
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Sorry,暂时不提供此功能");
                    break;
            }
        }
    }
    public static void changeCount(ArrayList<Laptop> array){
        for(int i = 0;i < array.size(); i++){
            Laptop b = array.get(i);
            Scanner s = new Scanner(System.in);
            System.out.print("要修改商品"+b.brand+"的库存是：");
            b.count = s.nextInt();
        }
    }

    public static void printArrayList( ArrayList<Laptop> array){
        int totalCount = 0;
        double totalMoney = 0;

        for(int i = 0;i < array.size() ; i++){
            Laptop b = array.get(i);
            System.out.println(b.brand+"   "+b.size+"   "+b.price+"   "+b.count);
            totalCount += b.count;
            totalMoney += b.price*b.count;
        }
        System.out.println("库存总数："+totalCount);
        System.out.println("库存商品总金额："+totalMoney);
    }

    public static void add(ArrayList<Laptop> array){
        Laptop b1 = new Laptop();
        Laptop b2 = new Laptop();
        Laptop b3 = new Laptop();

        b1.brand = "MacBookAir";
        b1.size  = 13.3 ;
        b1.price = 6988.88;
        b1.count = 5;

        b2.brand = "Thinkpad T450";
        b2.size  = 14.0 ;
        b2.price = 5999.99;
        b2.count = 10;

        b3.brand = "Asus-FL5800";
        b3.size  = 15.6 ;
        b3.price = 4999.5;
        b3.count = 18;

        array.add(b1);
        array.add(b2);
        array.add(b3);

    }

    public static int chooseFunction(){
        System.out.println("-------------库存管理------------");
        System.out.println("1.查看库存清单");
        System.out.println("2.修改商品库存数量");
        System.out.println("3.退出");
        System.out.println("请选择您要使用的功能：");
        Scanner ran = new Scanner(System.in);
        int number = ran.nextInt();
        return number;
    }
}
