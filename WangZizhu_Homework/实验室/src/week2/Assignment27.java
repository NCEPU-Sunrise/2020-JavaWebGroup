package week2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
	public void say(String name,int age);
}

class RealSubject implements Subject{

	@Override
	public void say(String name, int age) {
		System.out.println(name + "�����Ѿ�" + age + "���ˡ�");
	}
}
class MyInvocationHandler implements InvocationHandler {
	private Subject subject;
	
	public Object bind(Subject subject) {
		this.subject = subject;
		return Proxy.newProxyInstance(subject.getClass().getClassLoader(), subject.getClass().getInterfaces(), this);
	}
	 public boolean connect() {
	    System.out.println("����Ϣ�������ӳɹ�");
	    return true;
	}
	 public void close() {
        System.out.println("����Ϣ������Ϣͨ���ر�");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("ִ�з�����"+method);
        Object returnData = null;
        if(this.connect()) {
            returnData = method.invoke(this.subject, args);
            this.close();
        }
        return returnData;
	}

}
public class Assignment27 {
	
	public static void main(String[] args) {
		MyInvocationHandler demo = new MyInvocationHandler();
		Subject sub = (Subject) demo.bind(new RealSubject());
		sub.say("Rollen",23);
	}
}
