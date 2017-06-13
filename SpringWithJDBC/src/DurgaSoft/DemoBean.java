package DurgaSoft;

import javax.activation.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class DemoBean {

	
	JdbcTemplate template;
	DataSource source;
	
	public DemoBean(JdbcTemplate template){
		this.template=template;
	}
	
public void DemoCreate(){
	template.execute("create table employeeDurga( eid number(10),ename varchar2(10),esalary number(10,2) )");
	
	System.out.println("table reated succesfully");
}

public int DemoUpdate()
{
int i=	template.update("Insert into employeeDurga values(101,'emp2',13000)");

System.out.println("records updated "+i);
return i;

}
	
	
	
	
	
	
	
	
	
	
	
	
}
