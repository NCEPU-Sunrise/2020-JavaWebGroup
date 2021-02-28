import java.util.stream.StreamSupport;

public class Assignment11 {
    public static void main(String[] args) {
        robot a = new robot();
        human b = new human();
        pig c = new pig();
    }
}
class robot{
    robot(){
        System.out.println("机器人不休息，只知道补充能量和工作");
    }
        }
class human{
    human(){
        System.out.println("人需要休息、需要吃饭以及努力的工作");
    }
        }
class pig{
    pig(){
        System.out.println("猪需要休息、不需要工作只需要吃饭");
    }
        }