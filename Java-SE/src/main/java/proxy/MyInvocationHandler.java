package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler  implements InvocationHandler{
	
	private Object realObect;//真实对象
	
	public MyInvocationHandler(Object realObect) {
		super();
		this.realObect = realObect;
	}


	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		System.out.println("before");
		
		Object result = method.invoke(realObect, args);//调用真实对象的方法
		
		System.out.println("after");
		
		return result;
	}

	//获取代理类
	public Object getProxy() {
		Object instance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), realObect.getClass().getInterfaces(),this);
		return instance;
	}
}
