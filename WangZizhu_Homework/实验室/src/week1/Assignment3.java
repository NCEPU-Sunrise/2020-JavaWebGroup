package week1;

//利用Vector完成课程管理每学期都要开设多门课程，每门课程的信息包括课程名称（String）、是否是必修课(boolean)、授课教师（String）、学时(int)、学分(float)；编程实现对课程信息进行创建、添加、删除、修改和查询操作；可以按课程名、是否是必修课、授课教师来进行查询；修改或删除之前要先查询；
import java.util.*;
import java.io.*;
public class Assignment3 {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			Vector<subject_1> s=new Vector<subject_1>();
			System.out.println("请输入要选择的功能：");
		    System.out.println("1.创建课程");
	        System.out.println("2.添加课程"); 
	        System.out.println("3.删除课程"); 
	        System.out.println("4.修改课程"); 
	        System.out.println("5.查询课程");
	        System.out.println("6.输出全部课程信息");
	        System.out.println("7.退出程序");
	        int n=sc.nextInt();
	        sc.close();
	        all_subject_1 x=new all_subject_1();
	        while(true)
	        {
	             switch(n)
	            {
	               case 1:x.create(s);break;
	    	       case 2:x.add(s);break;
	    	       case 3:x.delete(s);break;
	    	       case 4:x.correct(s);break;
	    	       case 5:
	    	    	   {
	    	    		   System.out.println("请输入需要查询的条件：");
	    	    		   System.out.println("1.按课程名");
	    	    		   System.out.println("2.按课程性质");
	    	    		   System.out.println("3.授课教师查询");
	    	    		   int a=sc.nextInt();
	    	    		   x.search(a,s);break;
	    	    	   }
	    	       case 6:x.prints(s);break;
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
	        }
		}

	}
	class subject_1
	{
		String name;
		int period;
		int credit;
		String teacher;
		boolean e_c_course;
		subject_1(String name,boolean e_c_course,String teacher,int period,int credit)
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
	class all_subject_1
	{
		Scanner sc = new Scanner(System.in);
		void create(Vector<subject_1> s) throws IOException
		{
			System.out.println("创建课程表：");
			for(int i=0;i<s.capacity();i++)
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
				subject_1 c=new subject_1(name,e_c,t_name,period,credit);
				s.addElement(c);
				System.out.println("是否继续输入？（Y/N）");
				char a=(char)System.in.read();
				if(a=='N')
					return;
			}
			System.out.println("创建完成！");
		}
		void add(Vector<subject_1> s)throws IOException
		{		
			for(int i=0;i<s.capacity();i++)
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
				subject_1 c=new subject_1(name,elect,t_name,period,credit);
				s.addElement(c);
				System.out.println("是否继续输入？（Y/N）");
				char a=(char)System.in.read();
				if(a=='N')
					return;
			}
			System.out.println("添加完成！");
		}
		int search(int n,Vector<subject_1> s)
		{
			while(true)
			{
				if(n==1)
				{	 
					System.out.println("请输入课程名称：");
					String c_name=sc.next();
					for(int i=0;i<s.size();i++)
						if(((subject_1)s.elementAt(i)).name.equals(c_name))
						{
							System.out.println(s.elementAt(i));
							System.out.println("查询完成！");
		 	                return 1;
						}
					System.out.println("查询失败，重新查询！");        
		 	    }
				else if(n==2)
				{
					System.out.println("请输入课程性质（请输入true/false）：");
					Boolean e_c=sc.nextBoolean();
					for(int i=0;i<s.size();i++)
						if(((subject_1)s.elementAt(i)).e_c_course==e_c)
							System.out.println(s.elementAt(i));
					System.out.println("查询完成！");
				 	return 1;
		 	    }
				else if(n==3)
				{
					System.out.println("请输入授课教师：");
					String t_name=sc.next();
					for(int i=0;i<s.size();i++)
						if(((subject_1)s.elementAt(i)).teacher.equals(t_name))
							System.out.println(s.elementAt(i));  
					System.out.println("查询完成！");
			        return 1;
		 	    }
				else if(n==4)
				{
					String c_name=sc.next();
					for(int i=0;i<s.size();i++)
						if(((subject_1)s.elementAt(i)).name.equals(c_name))
					         return i;
					System.out.println("查询失败，重新查询！");    
				}
				else
					System.out.println("输入错误，请重新输入");
			   System.out.println("请输入需要查询的条件：");
	 		   System.out.println("1.按课程名");
	 		   System.out.println("2.按课程性质");
	 		   System.out.println("3.授课教师查询");
	 		   @SuppressWarnings("unused")
			int a=sc.nextInt();
			}
		}
		void delete(Vector<subject_1> s)
		{
			System.out.println("请输入删除课程的名称：");
		    int a=search(4,s);
		    s.removeElementAt(a);
		    System.out.println("删除完成！");
		}
		void correct(Vector<subject_1> s)
		{
			System.out.println("请输入修改课程的名称：");
		    int a=search(4,s);
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
	        	   ((subject_1)s.elementAt(a)).name=c_name;
	        	   break;
	           }
		       case 2:
		    	   {
		    		   System.out.println("请输入修改后的课程性质（请输入true/false）：");
		        	   Boolean e_c=sc.nextBoolean();
		        	   ((subject_1)s.elementAt(a)).e_c_course=e_c;
		    		   break;
		    	   }
		       case 3:
		    	   {
		    		   System.out.println("请输入修改后的授课教师：");
		        	   String t_name=sc.next();
		        	   ((subject_1)s.elementAt(a)).teacher=t_name;
		    		   break;
		    	   }
		       case 4:
		    	   {
		    		   System.out.println("请输入修改后的学时：");
		        	   int period=sc.nextInt();
		        	   ((subject_1)s.elementAt(a)).period=period;
		    		   break;
		    	   }
		       case 5:
		    	   {
		    		   System.out.println("请输入修改后的学分：");
		        	   int credit=sc.nextInt();
		        	   ((subject_1)s.elementAt(a)).credit=credit;
		    		   break;
		    	   }
		       default:System.out.println("输入错误，请重新输入");
	        }
		    System.out.println("修改完成！");
		}
		void prints(Vector<subject_1> s)
		{
			System.out.println("输出全部课程信息：");
			for(int i=0;i<s.size();i++)
					System.out.println(s.elementAt(i));  
			System.out.println("输出完成！");
		}
	}