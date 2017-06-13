package SepPersisAndBusineLogic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Client {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("Sep.xml");
		DemoBean db = (DemoBean) ctx.getBean("Demo");
		Employee e = new Employee();
		e.setId(102);
		e.setName("emp2");
		e.setSalary(10000);

		db.insert(e);
db.modify(101, 30000);
db.selectAll();
	}

}
