//作业2,3共有
package week1;

public class course {
    private String Cname;        //课程名称
    private boolean compulsory; //是否必修
    private String Tname;       //授课教师名称
    private int hours;          //学时
    private float credit;         //学分

    public course(){

    }

    public course(String Cname,boolean compulsory,String Tname,int hours,float credit){
        this.Cname = Cname;
        this.compulsory = compulsory;
        this.Tname = Tname;
        this.hours = hours;
        this.credit = credit;
    }

    public void setCname(String Cname){
        this.Cname = Cname;
    }

    public void setCompulsory(boolean compulsory){
        this.compulsory = compulsory;
    }

    public void setTname(String Tname){
        this.Tname = Tname;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public void setCredit(float credit){
        this.credit = credit;
    }

    public String getCname(){return Cname;}

    public boolean getCompulsory(){return compulsory;}

    public String getTname(){return Tname;}

    public int getHours(){return hours;}

    public float getCredit(){return credit;}

    public String infoPrint(){
        String s = "";
        s += this.Cname;s+="|";
        if(this.compulsory)s += "必修";else s+="选修";s+="|";
        s += this.Tname;s += "|";
        s += this.hours;s += "|";
        s += this.credit;s += "|";
        return s;
    }
}
