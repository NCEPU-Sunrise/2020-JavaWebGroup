import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Goods{
    String ID;
    String name;
    int count;
    int price;
    Goods(String ID,String name,int count,int price)
    {
        this.ID=ID;
        this.name=name;
        this.count=count;
        this.price=price;
    }
    void setCount(int count){
        this.count=count;
    }

}
public class Homework_3 {
    public Map<String,Goods> goods;
    Homework_3(){
        this.goods=new HashMap<String,Goods>();
    }
    public void put(){
        Scanner sc=new Scanner(System.in);
        int i=0;
        while(i<2)
        {
            System.out.println("请输入商品id：");
            String ID=sc.next();
            //Goods good=goods.get(ID);


                System.out.println("输入商品名称：");
                String name=sc.next();
                System.out.println("输入商品数量：");
                int count=sc.nextInt();
                System.out.println("输入商品价格：");
                int price=sc.nextInt();
                Goods goods2=new Goods(ID,name,count,price);
                goods.put(ID,goods2);
                System.out.println("goods存储成功！");
                i++;


        }

    }
    public void search()
    {
        int allcount[]=new int[10];
        int allprice[]=new int[10];
        int i=0;
        if(goods!=null) {
            for (Map.Entry<String, Goods> entry : goods.entrySet()) {
                allcount[i] = entry.getValue().count;
                allprice[i] = entry.getValue().price;
                System.out.println("ID为" + entry.getValue().ID + "名称为" + entry.getValue().name + "库存数量为" + entry.getValue().count + "单价为" + entry.getValue().price);
                i++;
            }
            int allc = 0;
            int allp = 0;
            for (int j = 0; j < allcount.length; j++) {
                allc += allcount[j];
            }
            for (int j = 0; j < allprice.length; j++) {
                allp += allcount[j] * allprice[j];
            }
            System.out.println("总库存为" + allc);
            System.out.println("总金额为" + allp);
        }
        else {
            System.out.println("库存为空！");

        }
    }

    public void change(){

        if(goods!=null) {
            for (Map.Entry<String, Goods> entry : goods.entrySet()) {
                System.out.println("ID为" + entry.getValue().ID + "名称为" + entry.getValue().name + "库存数量为" + entry.getValue().count + "单价为" + entry.getValue().price);

            }
            System.out.println("请选择要修改库存的商品ID");
            Scanner sc=new Scanner(System.in);
            String ID=sc.next();
            for(Map.Entry<String,Goods>entry:goods.entrySet()){
                if(entry.getKey().equals(ID))
                {
                    System.out.println("输入库存数量：");
                    int count=sc.nextInt();
                    Goods goods3= entry.getValue();
                    goods3.setCount(count);
                    goods.put(ID,goods3);
                }
            }
    }
    }
    public static void main(String[] args) {
        Homework_3 map=new Homework_3();
        map.put();
        map.search();
        map.change();
        map.search();
    }


}
