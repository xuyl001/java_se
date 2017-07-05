package lang.proxy;

import org.junit.Test;

public class TestProxy {

	@Test
	public void test1() {
		UserServe user = new UserServeImpl();
		
		//创建调度器
		MyInvocationHandler m = new MyInvocationHandler(user);
		
		//生成代理对象
		UserServe proxy =(UserServe) m.getProxy();
		
		proxy.add();
		
	}
}
