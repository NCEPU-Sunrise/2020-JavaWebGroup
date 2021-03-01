public class Assignment13 {
    public static void main(String[] args) {
        BankAccount a = new BankAccount();
        a.getmessage("2021.04.02");
        a.in(500);
        a.out(20);
        a.check();
        BankAccount b = new BankAccount();
        b.getmessage("2025.04.03");
        b.in(20);
        b.check();
        BankAccount c = new BankAccount();
        c.getmessage("2020.06.02");

    }
}
class BankAccount{
    static int BankAccountId = 0;
    double Rest = 1000.0;
    public void in(int add){
        Rest = Rest + add;
        System.out.println("你存了"+add+"元");
    }
    public void out(int out){
        if(Rest >= out) {
            Rest = Rest - out;
            System.out.println("你取了" + out + "元");
        }
        else
            System.out.println("余额不足");
    }
    public void check() {

        System.out.println("你现在的余额是"+Rest);
    }
    public void getmessage(String Date){
        System.out.println("你的账户编号为：" + BankAccountId + "  日期为：" + Date);
        BankAccountId++;
    }

}
