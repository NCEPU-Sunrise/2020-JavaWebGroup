package 实验室;

//运用对象数组完成课程管理每学期都要开设多门课程，每门课程的信息包括课程名称（String）、是否是必修课(boolean)、授课教师（String）、学时(int)、学分(float)；编程实现对课程信息进行创建、添加、删除、修改和查询操作；可以按课程名、是否是必修课、授课教师来进行查询；修改或删除之前要先查询；
import java.util.*;

public class Assignment2 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			subject[] stus=new subject[50];
			System.out.println("请输入要选择的功能：");
		    System.out.println("1.创建课程");
	        System.out.println("2.添加课程"); 
	        System.out.println("3.删除课程"); 
	        System.out.println("4.修改课程"); 
	        System.out.println("5.查询课程");
	        System.out.println("6.输出全部课程信息");
	        System.out.println("7.退出程序");
	        int n=sc.nextInt();
	        all_subject x=new all_subject();
	        while(true)
	        {
	             switch(n)
	            {
	               case 1:x.create(stus);break;
	    	       case 2:x.add(stus);break;
	    	       case 3:x.delete(stus);break;
	    	       case 4:x.correct(stus);break;
	    	       case 5:
	    	    	   {
	    	    		   System.out.println("请输入需要查询的条件：");
	    	    		   System.out.println("1.按课程名");
	    	    		   System.out.println("2.按课程性质");
	    	    		   System.out.println("3.授课教师查询");
	    	    		   int a=sc.nextInt();
	    	    		   x.search(a,stus);break;
	    	    	   }
	    	       case 6:x.prints(stus);break;
	    	       case 7:return;
	    	       default:System.out.println("输入错误，请重新输入");
	            }
	             System.out.println("请输入要选择的功能：");
			     System.out.println("1.创建课程");
	             System.out.println("2.添加课程"); 
	             System.out.println("3.删除课程"); 
	             System.out.println("4.修改课程"); 
	             System.out.println("5.查询课程");
	             System.out.println("6.输出全部课程信息");
		         System.out.println("7.退出程序");
	             n=sc.nextInt();
	        sc.close();
	        }
		}
	}
	class subject
	{
		String name;
		int period;
		int credit;
		String teacher;
		boolean e_c_course;
		subject(String name,boolean e_c_course,String teacher,int period,int credit)
		{
			this.name=name;
			this.period=period;
			this.teacher=teacher;
			this.e_c_course=e_c_course;
			this.credit=credit;
		}
		public String toString()
		{
	        return "Course [课程名称：" + name + "，课程性质："+e_c_course+"，授课教师："+teacher+"，学时："+period+"，学分："+credit+"]";
		}
	}
	class all_subject
	{
		Scanner sc = new Scanner(System.in);
		int c_num;
		void create(subject stus[])
		{
			System.out.println("创建课程表：");
	        System.out.print("请输入课程门数：");
			c_num=sc.nextInt();
			for(int i=0;i<c_num;i++)
			{
				System.out.println("请输入课程"+(i+1)+"的名称：");
				String name=sc.next();
				System.out.println("请输入课程"+(i+1)+"的课程性质（请输入true/false）：");
				Boolean e_c=sc.nextBoolean();
				System.out.println("请输入课程"+(i+1)+"的授课教师：");
				String t_name=sc.next();
				System.out.println("请输入课程"+(i+1)+"的学时：");
				int period=sc.nextInt();
				System.out.println("请输入课程"+(i+1)+"的学分：");
				int credit=sc.nextInt();
				subject c=new subject(name,e_c,t_name,period,credit);
				stus[i]=c;
			}
			System.out.println("创建完成！");
		}
		void add(subject stus[])
		{
			System.out.print("请输入添加课程门数：");
			int n=sc.nextInt();
			
			for(int i=0;i<n;i++)
			{
				System.out.print("请输入课程"+(i+1)+"的名称：");
				String name=sc.next();
				System.out.print("请输入课程"+(i+1)+"的课程性质（请输入true/false）：");
				Boolean elect=sc.nextBoolean();
				System.out.print("请输入课程"+(i+1)+"的授课教师：");
				String t_name=sc.next();
				System.out.print("请输入课程"+(i+1)+"的学时：");
				int period=sc.nextInt();
				System.out.print("请输入课程"+(i+1)+"的学分：");
				int credit=sc.nextInt();
				subject c=new subject(name,elect,t_name,period,credit);
				stus[c_num++]=c;
			}
			System.out.println("添加完成！");
		}
		int search(int n,subject stus[])
		{
			while(true)
			{
				if(n==1)
				{	 
					System.out.println("请输入课程名称：");
					String c_name=sc.next();
					for(int i=0;i<c_num;i++)
						if((stus[i].name).equals(c_name))
						{
							System.out.println(stus[i]);
							System.out.println("查询完成！");
		 	                return 1;
						}
					System.out.println("查询失败，重新查询！");        
		 	    }
				else if(n==2)
				{
					System.out.println("请输入课程性质（请输入true/false）：");
					Boolean e_c=sc.nextBoolean();
					for(int i=0;i<c_num;i++)
						if(stus[i].e_c_course==e_c)
							System.out.println(stus[i]);
					System.out.println("查询完成！");
				 	return 1;
		 	    }
				else if(n==3)
				{
					System.out.println("请输入授课教师：");
					String t_name=sc.next();
					for(int i=0;i<c_num;i++)
						if((stus[i].teacher).equals(t_name))
							System.out.println(stus[i]);  
					System.out.println("查询完成！");
			        return 1;
		 	    }
				else if(n==4)
				{
					String c_name=sc.next();
					for(int i=0;i<c_num;i++)
						if((stus[i].name).equals(c_name))
					         return i;
					System.out.println("查询失败，重新查询！");    
				}
				else
					System.out.println("输入错误，请重新输入");
			   System.out.println("请输入需要查询的条件：");
	 		   System.out.println("1.按课程名");
	 		   System.out.println("2.按课程性质");
	 		   System.out.println("3.授课教师查询");
	 		   int a=sc.nextInt();
			}
		}
		void delete(subject stus[])
		{
			System.out.println("请输入删除课程的名称：");
		    int a=search(4,stus);
		    for(int i=a;i<c_num-1;i++)
		         stus[i]=stus[i+1];
		    c_num--;
		    System.out.println("删除完成！");
		}
		void correct(subject stus[])
		{
			System.out.println("请输入修改课程的名称：");
		    int a=search(4,stus);
		    System.out.println("请输入修改的条件：");
		    System.out.println("1.修改名称");
		    System.out.println("2.修改课程性质");
		    System.out.println("3.修改授课教师");
		    System.out.println("4.修改学时");
		    System.out.println("5.修改学分");
		    int n=sc.nextInt();
		    switch(n)
	        {
	           case 1:{
	        	   System.out.println("请输入修改后的名称：");
	        	   String c_name=sc.next();
	        	   stus[a].name=c_name;
	        	   break;
	           }
		       case 2:
		    	   {
		    		   System.out.println("请输入修改后的课程性质（请输入true/false）：");
		        	   Boolean e_c=sc.nextBoolean();
		        	   stus[a].e_c_course=e_c;
		    		   break;
		    	   }
		       case 3:
		    	   {
		    		   System.out.println("请输入修改后的授课教师：");
		        	   String t_name=sc.next();
		        	   stus[a].teacher=t_name;
		    		   break;
		    	   }
		       case 4:
		    	   {
		    		   System.out.println("请输入修改后的学时：");
		        	   int period=sc.nextInt();
		        	   stus[a].period=period;
		    		   break;
		    	   }
		       case 5:
		    	   {
		    		   System.out.println("请输入修改后的学分：");
		        	   int credit=sc.nextInt();
		        	   stus[a].credit=credit;
		    		   break;
		    	   }
		       default:System.out.println("输入错误，请重新输入");
	        }
		    System.out.println("修改完成！");
		}
		void prints(subject stus[])
		{
			System.out.println("输出全部课程信息：");
			for(int i=0;i<c_num;i++)
					System.out.println(stus[i]);  
			System.out.println("输出完成！");
		}

}
