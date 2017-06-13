package JDBC;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {

	
	public JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public int saveEmployee(Employee e){
		String query="insert into employee values('"+e.getId()+"','"+e.getName()+"','"+e.getSalary()+"')";
		return template.update(query);
	}

	
	public int updateEmployee(Employee e){  
	    String query="update employee set  name="+e.getName()+"salary = "+e.getSalary()+"id is "+e.getId();  
	    
	    return template.update(query);  
	}  	
	
	
	
	
}
