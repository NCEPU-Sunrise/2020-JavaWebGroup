public class Assignment16 {
    public static void main(String[] args) {
        Instrument piano = new Piano();
        Instrument violin = new Violin();
        piano.play();
        violin.play();
    }
}

interface Instrument
{
    public abstract void play();
}
class Piano implements Instrument
{
    public void play(){
        System.out.println("钢琴输出音符：123456");
    }
}
class Violin implements Instrument
{
    public void play(){
        System.out.println("小提琴输出音符：23567");
    }

}