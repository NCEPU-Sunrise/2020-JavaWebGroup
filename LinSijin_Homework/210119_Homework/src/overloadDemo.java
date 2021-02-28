public class overloadDemo {
    public static void main(String[] args) {
        int a=1;
        int b=3;
        boolean q=compare(a ,b);
        System.out.println(q);

        long a1=1L;
        long b1=1L;
        boolean w=compare(a1 ,b1);
        System.out.println(w);

        double a2=2.3;
        double b2= 3.2;
        boolean e=compare(a2 ,b2);
        System.out.println(e);
    }

    public static boolean compare(int a ,int b){
        return a == b ;
    }
    public static boolean compare(long a ,long b){
        return a == b ;
    }

    public static boolean compare(double a ,double b){
        return a == b ;
    }
}

