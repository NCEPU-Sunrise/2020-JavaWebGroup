//作业6:构造银行类
package week1;

public class bankAccount {
    private float balance;      //余额
    private String name;        //用户名

    //开户:初始化对象
    public bankAccount(){}

    public bankAccount(float balance,String name){
        this.balance = balance;
        this.name = name;
    }

    //存钱
    public float saveMoney(float money){
        balance += money;
        return balance;
    }

    //取钱
    public float getMoney(float money){
        if(balance >= money){
            balance -= money;
            return balance;
        }else {
            return 0;
        }
    }

    //查询余额
    public float getBalance(){
        return balance;
    }
}
