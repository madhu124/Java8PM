package DurgaSoft;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {

	public static void main(String[] args){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Durga.xml");
		DemoBean bean=(DemoBean)ctx.getBean("Ds");
		//bean.DemoCreate();
		bean.DemoUpdate();
	}
	
	
	
}
