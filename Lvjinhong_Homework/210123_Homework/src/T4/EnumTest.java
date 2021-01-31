package T4;
import java.util.Scanner;

enum Appetizer implements Menu{
    SALAD(),
    SOUP(),
    SPRING_ROLLS();


    private float Price;
    private String desc;

    Appetizer() {}

    Appetizer(float Price,String desc) {
        this.Price = Price;
        this.desc = desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public void setPrice(float Price) {
        this.Price = Price;
    }

    public float getPrice() {
        return Price;
    }
}

enum Entrees implements Menu{
    LASAGNE(),
    BURRITO(),
    PAD_THAI(),
    LENTILS();


    private float Price;
    private String desc;

    Entrees() {}

    Entrees(float Price,String desc) {
        this.Price = Price;
        this.desc = desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


    @Override
    public void setPrice(float Price) {
        this.Price = Price;
    }

    public float getPrice() {
        return Price;
    }
}

enum Dessert implements Menu{
    BLACK_FOREST_CAKE(),
    FRUIT();


    private float Price;
    private String desc;

    Dessert() {}

    Dessert(float Price,String desc) {
        this.Price = Price;
        this.desc = desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }


    @Override
    public void setPrice(float Price) {
        this.Price = Price;
    }

    public float getPrice() {
        return Price;
    }
}
public class EnumTest  {
    public static void main(String[] args) {
        //设置菜价与描述信息
        Appetizer.SALAD.setPrice(35.0f);Appetizer.SALAD.setDesc("沙拉");
        Appetizer.SOUP.setPrice(40.0f);Appetizer.SOUP.setDesc("汤");
        Appetizer.SPRING_ROLLS.setPrice(45.0f);Appetizer.SPRING_ROLLS.setDesc("春卷");

        Entrees.LASAGNE.setPrice(35.0f);Entrees.LASAGNE.setDesc("千层面");
        Entrees.BURRITO.setPrice(40.0f);Entrees.BURRITO.setDesc("玉米煎饼");
        Entrees.PAD_THAI.setPrice(45.0f);Entrees.PAD_THAI.setDesc("泰国饼");
        Entrees.LENTILS.setPrice(50.0f);Entrees.LENTILS.setDesc("扁豆");

        Dessert.BLACK_FOREST_CAKE.setPrice(35.0f);Dessert.BLACK_FOREST_CAKE.setDesc("黑森林蛋糕");
        Dessert.FRUIT.setPrice(40.0f);Dessert.FRUIT.setDesc("水果");

        //点菜
        Scanner sc = new Scanner(System.in);
        String s;
        float bill = 0;
        System.out.println("请点一份前菜：");
        for (Appetizer a:Appetizer.values()
             ) {
            System.out.println(a.getDesc() + "--" +a.getPrice());
        }
        s = sc.nextLine();
        for (Appetizer a:Appetizer.values()
        ) {
            if(s.equals(a.getDesc())) {
                bill += a.getPrice();
                break;
            }
        }
        System.out.println("请点一份主菜：");
        for (Entrees e:Entrees.values()
        ) {
            System.out.println(e.getDesc() + "--" + e.getPrice());
        }
        s = sc.nextLine();
        for (Entrees e:Entrees.values()
        ) {
            if(s.equals(e.getDesc())) {
                bill += e.getPrice();
                break;
            }
        }
        System.out.println("请点一份甜点：");
        for (Dessert d:Dessert.values()
        ) {
            System.out.println(d.getDesc() + "--" + d.getPrice());
        }
        s = sc.nextLine();
        for (Dessert d:Dessert.values()
        ) {
            if(s.equals(d.getDesc())) {
                bill += d.getPrice();
                break;
            }
        }
        System.out.println("点餐完毕，总消费为:"+bill);
    }
}
