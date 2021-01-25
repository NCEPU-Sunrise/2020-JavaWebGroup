package week1;

public class player {
    String name;    //选手姓名
    String id;      //选手编号

    public player() {}

    public player(String name,String id){
        this.name = name;
        this.id = id;
    }

    public void setName(String name){this.name = name;}

    public void setId(String id){this.id = id;}
}
