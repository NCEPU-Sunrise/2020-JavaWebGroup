package ʵ����;

//��֪2000.1.1��������������������������ڣ�2000���Ժ�ģ������̼�������������ڼ���
import java.util.*;

class Assignment1 {

  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("������������ڣ��Կո������");
      int year=sc.nextInt();                  
      int month=sc.nextInt();                 
      int day=sc.nextInt();                   
      int year0=2000;                         
      int month0=1;                           
      int day0=1;                             
      int monthday[][]={{0,31,28,31,30,31,30,31,31,30,31,30,31},{0,31,29,31,30,31,30,31,31,30,31,30,31}};           
      String [] weekday={"��","��","һ","��","��","��","��"};
      int days=0;                             
      if(year>year0)                          
      {
          for(int i=year0;i<year;i++)
          {
              if(leapYear(i)==1)
                  days+=366;
              else
                  days+=365;  
          }

      }
      if(month>month0)                       
      {
          for(int j=month0;j<month;j++)
        	  days+=monthday[leapYear(year)][j];
      }
      days=days+day-day0;                     
      System.out.println(year+"��"+month+"��"+day+"�� �� ����"+weekday[days%7]);    
      sc.close();
  }
  public static int leapYear(int year) {
      int leap=0;
      if(year%4==0)
      {
          if(year%100==0)
          {
              if(year%400==0)
            	  leap=1;
              else
                 leap=0;
          }
          else
        	  leap=1;
      }
      else
          leap=0;
      return leap;

  }
}