public class Homework_4 {
    public static void main(String[] args) {
        System.out.println("请点菜！");
        System.out.println("全部都要！！");
        int price=Menu.Qiancai.SALAD.getprice()+Menu.Qiancai.SOUP.getprice()+
                Menu.Qiancai.SPRINT_ROLLS.getprice()+Menu.Houcai.LASANGNE.getprice()+
                Menu.Houcai.PAD_THAI.getprice()+Menu.Houcai.BURRITO.getprice()+
                Menu.Houcai.LENTILS.getprice()+Menu.Dessert.BLACK_FOREST_CAKE.getprice()+
                Menu.Dessert.FRUIT.getprice();
        System.out.println(price+"元");

    }
}
interface Menu{
enum Qiancai implements Menu{
SALAD(10),SOUP(20),SPRINT_ROLLS(30);

  int nCode;
    Qiancai(int i) {
    this.nCode=i;
    }
    public  String toString(){
        return String.valueOf(this.nCode);
    }
    public int getprice(){
        return nCode;
    }
}
enum Houcai implements Menu{
    LASANGNE(10),BURRITO(20),PAD_THAI(30),LENTILS(40);
    int nCode;
    Houcai(int i){
        this.nCode=i;
    }
    public String toString(){
        return String.valueOf(this.nCode);
    }
    public int getprice(){
        return nCode;
    }
}
enum Dessert implements Menu{
    BLACK_FOREST_CAKE(10),FRUIT(20);
    int nCode;
    Dessert(int i){
        this.nCode=i;
    }
    public String toString(){
        return String.valueOf(this.nCode);
    }
    public int getprice(){
        return nCode;
    }
}
}