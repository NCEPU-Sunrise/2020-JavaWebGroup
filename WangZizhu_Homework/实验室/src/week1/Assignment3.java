package week1;

//����Vector��ɿγ̹���ÿѧ�ڶ�Ҫ������ſγ̣�ÿ�ſγ̵���Ϣ�����γ����ƣ�String�����Ƿ��Ǳ��޿�(boolean)���ڿν�ʦ��String����ѧʱ(int)��ѧ��(float)�����ʵ�ֶԿγ���Ϣ���д�������ӡ�ɾ�����޸ĺͲ�ѯ���������԰��γ������Ƿ��Ǳ��޿Ρ��ڿν�ʦ�����в�ѯ���޸Ļ�ɾ��֮ǰҪ�Ȳ�ѯ��
import java.util.*;
import java.io.*;
public class Assignment3 {

		public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			Vector<subject_1> s=new Vector<subject_1>();
			System.out.println("������Ҫѡ��Ĺ��ܣ�");
		    System.out.println("1.�����γ�");
	        System.out.println("2.��ӿγ�"); 
	        System.out.println("3.ɾ���γ�"); 
	        System.out.println("4.�޸Ŀγ�"); 
	        System.out.println("5.��ѯ�γ�");
	        System.out.println("6.���ȫ���γ���Ϣ");
	        System.out.println("7.�˳�����");
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
	    	    		   System.out.println("��������Ҫ��ѯ��������");
	    	    		   System.out.println("1.���γ���");
	    	    		   System.out.println("2.���γ�����");
	    	    		   System.out.println("3.�ڿν�ʦ��ѯ");
	    	    		   int a=sc.nextInt();
	    	    		   x.search(a,s);break;
	    	    	   }
	    	       case 6:x.prints(s);break;
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
	        return "Course [�γ����ƣ�" + name + "���γ����ʣ�"+e_c_course+"���ڿν�ʦ��"+teacher+"��ѧʱ��"+period+"��ѧ�֣�"+credit+"]";
		}
	}
	class all_subject_1
	{
		Scanner sc = new Scanner(System.in);
		void create(Vector<subject_1> s) throws IOException
		{
			System.out.println("�����γ̱�");
			for(int i=0;i<s.capacity();i++)
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
				subject_1 c=new subject_1(name,e_c,t_name,period,credit);
				s.addElement(c);
				System.out.println("�Ƿ�������룿��Y/N��");
				char a=(char)System.in.read();
				if(a=='N')
					return;
			}
			System.out.println("������ɣ�");
		}
		void add(Vector<subject_1> s)throws IOException
		{		
			for(int i=0;i<s.capacity();i++)
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
				subject_1 c=new subject_1(name,elect,t_name,period,credit);
				s.addElement(c);
				System.out.println("�Ƿ�������룿��Y/N��");
				char a=(char)System.in.read();
				if(a=='N')
					return;
			}
			System.out.println("�����ɣ�");
		}
		int search(int n,Vector<subject_1> s)
		{
			while(true)
			{
				if(n==1)
				{	 
					System.out.println("������γ����ƣ�");
					String c_name=sc.next();
					for(int i=0;i<s.size();i++)
						if(((subject_1)s.elementAt(i)).name.equals(c_name))
						{
							System.out.println(s.elementAt(i));
							System.out.println("��ѯ��ɣ�");
		 	                return 1;
						}
					System.out.println("��ѯʧ�ܣ����²�ѯ��");        
		 	    }
				else if(n==2)
				{
					System.out.println("������γ����ʣ�������true/false����");
					Boolean e_c=sc.nextBoolean();
					for(int i=0;i<s.size();i++)
						if(((subject_1)s.elementAt(i)).e_c_course==e_c)
							System.out.println(s.elementAt(i));
					System.out.println("��ѯ��ɣ�");
				 	return 1;
		 	    }
				else if(n==3)
				{
					System.out.println("�������ڿν�ʦ��");
					String t_name=sc.next();
					for(int i=0;i<s.size();i++)
						if(((subject_1)s.elementAt(i)).teacher.equals(t_name))
							System.out.println(s.elementAt(i));  
					System.out.println("��ѯ��ɣ�");
			        return 1;
		 	    }
				else if(n==4)
				{
					String c_name=sc.next();
					for(int i=0;i<s.size();i++)
						if(((subject_1)s.elementAt(i)).name.equals(c_name))
					         return i;
					System.out.println("��ѯʧ�ܣ����²�ѯ��");    
				}
				else
					System.out.println("�����������������");
			   System.out.println("��������Ҫ��ѯ��������");
	 		   System.out.println("1.���γ���");
	 		   System.out.println("2.���γ�����");
	 		   System.out.println("3.�ڿν�ʦ��ѯ");
	 		   @SuppressWarnings("unused")
			int a=sc.nextInt();
			}
		}
		void delete(Vector<subject_1> s)
		{
			System.out.println("������ɾ���γ̵����ƣ�");
		    int a=search(4,s);
		    s.removeElementAt(a);
		    System.out.println("ɾ����ɣ�");
		}
		void correct(Vector<subject_1> s)
		{
			System.out.println("�������޸Ŀγ̵����ƣ�");
		    int a=search(4,s);
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
	        	   ((subject_1)s.elementAt(a)).name=c_name;
	        	   break;
	           }
		       case 2:
		    	   {
		    		   System.out.println("�������޸ĺ�Ŀγ����ʣ�������true/false����");
		        	   Boolean e_c=sc.nextBoolean();
		        	   ((subject_1)s.elementAt(a)).e_c_course=e_c;
		    		   break;
		    	   }
		       case 3:
		    	   {
		    		   System.out.println("�������޸ĺ���ڿν�ʦ��");
		        	   String t_name=sc.next();
		        	   ((subject_1)s.elementAt(a)).teacher=t_name;
		    		   break;
		    	   }
		       case 4:
		    	   {
		    		   System.out.println("�������޸ĺ��ѧʱ��");
		        	   int period=sc.nextInt();
		        	   ((subject_1)s.elementAt(a)).period=period;
		    		   break;
		    	   }
		       case 5:
		    	   {
		    		   System.out.println("�������޸ĺ��ѧ�֣�");
		        	   int credit=sc.nextInt();
		        	   ((subject_1)s.elementAt(a)).credit=credit;
		    		   break;
		    	   }
		       default:System.out.println("�����������������");
	        }
		    System.out.println("�޸���ɣ�");
		}
		void prints(Vector<subject_1> s)
		{
			System.out.println("���ȫ���γ���Ϣ��");
			for(int i=0;i<s.size();i++)
					System.out.println(s.elementAt(i));  
			System.out.println("�����ɣ�");
		}
	}