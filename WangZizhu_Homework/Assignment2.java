package ʵ����;

//���ö���������ɿγ̹���ÿѧ�ڶ�Ҫ������ſγ̣�ÿ�ſγ̵���Ϣ�����γ����ƣ�String�����Ƿ��Ǳ��޿�(boolean)���ڿν�ʦ��String����ѧʱ(int)��ѧ��(float)�����ʵ�ֶԿγ���Ϣ���д�������ӡ�ɾ�����޸ĺͲ�ѯ���������԰��γ������Ƿ��Ǳ��޿Ρ��ڿν�ʦ�����в�ѯ���޸Ļ�ɾ��֮ǰҪ�Ȳ�ѯ��
import java.util.*;

public class Assignment2 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			subject[] stus=new subject[50];
			System.out.println("������Ҫѡ��Ĺ��ܣ�");
		    System.out.println("1.�����γ�");
	        System.out.println("2.��ӿγ�"); 
	        System.out.println("3.ɾ���γ�"); 
	        System.out.println("4.�޸Ŀγ�"); 
	        System.out.println("5.��ѯ�γ�");
	        System.out.println("6.���ȫ���γ���Ϣ");
	        System.out.println("7.�˳�����");
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
	    	    		   System.out.println("��������Ҫ��ѯ��������");
	    	    		   System.out.println("1.���γ���");
	    	    		   System.out.println("2.���γ�����");
	    	    		   System.out.println("3.�ڿν�ʦ��ѯ");
	    	    		   int a=sc.nextInt();
	    	    		   x.search(a,stus);break;
	    	    	   }
	    	       case 6:x.prints(stus);break;
	    	       case 7:return;
	    	       default:System.out.println("�����������������");
	            }
	             System.out.println("������Ҫѡ��Ĺ��ܣ�");
			     System.out.println("1.�����γ�");
	             System.out.println("2.��ӿγ�"); 
	             System.out.println("3.ɾ���γ�"); 
	             System.out.println("4.�޸Ŀγ�"); 
	             System.out.println("5.��ѯ�γ�");
	             System.out.println("6.���ȫ���γ���Ϣ");
		         System.out.println("7.�˳�����");
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
	        return "Course [�γ����ƣ�" + name + "���γ����ʣ�"+e_c_course+"���ڿν�ʦ��"+teacher+"��ѧʱ��"+period+"��ѧ�֣�"+credit+"]";
		}
	}
	class all_subject
	{
		Scanner sc = new Scanner(System.in);
		int c_num;
		void create(subject stus[])
		{
			System.out.println("�����γ̱�");
	        System.out.print("������γ�������");
			c_num=sc.nextInt();
			for(int i=0;i<c_num;i++)
			{
				System.out.println("������γ�"+(i+1)+"�����ƣ�");
				String name=sc.next();
				System.out.println("������γ�"+(i+1)+"�Ŀγ����ʣ�������true/false����");
				Boolean e_c=sc.nextBoolean();
				System.out.println("������γ�"+(i+1)+"���ڿν�ʦ��");
				String t_name=sc.next();
				System.out.println("������γ�"+(i+1)+"��ѧʱ��");
				int period=sc.nextInt();
				System.out.println("������γ�"+(i+1)+"��ѧ�֣�");
				int credit=sc.nextInt();
				subject c=new subject(name,e_c,t_name,period,credit);
				stus[i]=c;
			}
			System.out.println("������ɣ�");
		}
		void add(subject stus[])
		{
			System.out.print("��������ӿγ�������");
			int n=sc.nextInt();
			
			for(int i=0;i<n;i++)
			{
				System.out.print("������γ�"+(i+1)+"�����ƣ�");
				String name=sc.next();
				System.out.print("������γ�"+(i+1)+"�Ŀγ����ʣ�������true/false����");
				Boolean elect=sc.nextBoolean();
				System.out.print("������γ�"+(i+1)+"���ڿν�ʦ��");
				String t_name=sc.next();
				System.out.print("������γ�"+(i+1)+"��ѧʱ��");
				int period=sc.nextInt();
				System.out.print("������γ�"+(i+1)+"��ѧ�֣�");
				int credit=sc.nextInt();
				subject c=new subject(name,elect,t_name,period,credit);
				stus[c_num++]=c;
			}
			System.out.println("�����ɣ�");
		}
		int search(int n,subject stus[])
		{
			while(true)
			{
				if(n==1)
				{	 
					System.out.println("������γ����ƣ�");
					String c_name=sc.next();
					for(int i=0;i<c_num;i++)
						if((stus[i].name).equals(c_name))
						{
							System.out.println(stus[i]);
							System.out.println("��ѯ��ɣ�");
		 	                return 1;
						}
					System.out.println("��ѯʧ�ܣ����²�ѯ��");        
		 	    }
				else if(n==2)
				{
					System.out.println("������γ����ʣ�������true/false����");
					Boolean e_c=sc.nextBoolean();
					for(int i=0;i<c_num;i++)
						if(stus[i].e_c_course==e_c)
							System.out.println(stus[i]);
					System.out.println("��ѯ��ɣ�");
				 	return 1;
		 	    }
				else if(n==3)
				{
					System.out.println("�������ڿν�ʦ��");
					String t_name=sc.next();
					for(int i=0;i<c_num;i++)
						if((stus[i].teacher).equals(t_name))
							System.out.println(stus[i]);  
					System.out.println("��ѯ��ɣ�");
			        return 1;
		 	    }
				else if(n==4)
				{
					String c_name=sc.next();
					for(int i=0;i<c_num;i++)
						if((stus[i].name).equals(c_name))
					         return i;
					System.out.println("��ѯʧ�ܣ����²�ѯ��");    
				}
				else
					System.out.println("�����������������");
			   System.out.println("��������Ҫ��ѯ��������");
	 		   System.out.println("1.���γ���");
	 		   System.out.println("2.���γ�����");
	 		   System.out.println("3.�ڿν�ʦ��ѯ");
	 		   int a=sc.nextInt();
			}
		}
		void delete(subject stus[])
		{
			System.out.println("������ɾ���γ̵����ƣ�");
		    int a=search(4,stus);
		    for(int i=a;i<c_num-1;i++)
		         stus[i]=stus[i+1];
		    c_num--;
		    System.out.println("ɾ����ɣ�");
		}
		void correct(subject stus[])
		{
			System.out.println("�������޸Ŀγ̵����ƣ�");
		    int a=search(4,stus);
		    System.out.println("�������޸ĵ�������");
		    System.out.println("1.�޸�����");
		    System.out.println("2.�޸Ŀγ�����");
		    System.out.println("3.�޸��ڿν�ʦ");
		    System.out.println("4.�޸�ѧʱ");
		    System.out.println("5.�޸�ѧ��");
		    int n=sc.nextInt();
		    switch(n)
	        {
	           case 1:{
	        	   System.out.println("�������޸ĺ�����ƣ�");
	        	   String c_name=sc.next();
	        	   stus[a].name=c_name;
	        	   break;
	           }
		       case 2:
		    	   {
		    		   System.out.println("�������޸ĺ�Ŀγ����ʣ�������true/false����");
		        	   Boolean e_c=sc.nextBoolean();
		        	   stus[a].e_c_course=e_c;
		    		   break;
		    	   }
		       case 3:
		    	   {
		    		   System.out.println("�������޸ĺ���ڿν�ʦ��");
		        	   String t_name=sc.next();
		        	   stus[a].teacher=t_name;
		    		   break;
		    	   }
		       case 4:
		    	   {
		    		   System.out.println("�������޸ĺ��ѧʱ��");
		        	   int period=sc.nextInt();
		        	   stus[a].period=period;
		    		   break;
		    	   }
		       case 5:
		    	   {
		    		   System.out.println("�������޸ĺ��ѧ�֣�");
		        	   int credit=sc.nextInt();
		        	   stus[a].credit=credit;
		    		   break;
		    	   }
		       default:System.out.println("�����������������");
	        }
		    System.out.println("�޸���ɣ�");
		}
		void prints(subject stus[])
		{
			System.out.println("���ȫ���γ���Ϣ��");
			for(int i=0;i<c_num;i++)
					System.out.println(stus[i]);  
			System.out.println("�����ɣ�");
		}

}
