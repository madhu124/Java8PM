package JDBC;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {  
	    ApplicationContext ctx=new ClassPathXmlApplicationContext("Spring.xml");  
	      
	    EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");  
	    int status=dao.saveEmployee(new Employee(102,"Amit",35000));  
	    System.out.println(status);  
	}
}
