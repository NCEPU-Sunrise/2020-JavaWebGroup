import java.util.Scanner;
    class bankAccount{
         String name="";
        int money=0;
         void setName(String name){
            this.name=name;
        }
         void setMoney(int money){
            this.money=money;
        }
         int getMoney() {
            return this.money;
        }
         void order(){
             int t=0;
             String name1="";
             System.out.print("请选择相应操作\n1.开户\n2.存取钱\n3.查询余额\n4.退出:");
             Scanner scan = new Scanner(System.in);
             if (scan.hasNextInt()) {
                 t = scan.nextInt();
             }
             if (scan.hasNextLine())  name1 = scan.nextLine();
             switch(t){
                 case 1:{
                     System.out.println("输入户名");
                     if (scan.hasNextLine())  name1 = scan.nextLine();
                     this.setName(name1);
                     this.order();
                     break;
                 }
                 case 2:{
                     System.out.println("输入存取钱的金额:");
                     int money1=0;
                     if (scan.hasNextInt())  money1 = scan.nextInt();
                     if(!this.name.equals("")) this.setMoney(money1);
                     else System.out.print("请先开户\n");
                     this.order();
                     break;
                 }
                 case 3:{
                     if(!this.name.equals("")) System.out.println(this.getMoney());
                     else System.out.print("请先开户\n");
                     this.order();
                     break;
                 }
                 default:break;
             }
         }
        public static void main(String[] args) {
            bankAccount name2=new bankAccount();
            name2.order();
    }
}