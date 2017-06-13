package SepPersisAndBusineLogic;

import java.util.Iterator;

import java.util.List;

import org.springframework.jdbc.core.*;


public class EmpDaoImpl implements EmployeeDao {

	private JdbcTemplate jt;
	

	

	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int insertEmployee(Employee e) {
		int eId = e.getId();
		String ename = e.getName();
		int esalary = e.getSalary();

		Object[] parameters = { eId, ename, esalary };

		int i =jt.update("INSERT INTO Employee (id, name, salary) VALUES (?, ?, ?)", parameters);
		
		return i;

	}

	@Override
	public void SelectAllEmployee() {

		List l = jt.query ("select * from employee",new EmpMapper());

		Iterator it = l.iterator();
		while (it.hasNext()) {
Employee e=(Employee) it.next();

		System.out.println(e.getId()+" "+ e.getName()+" " +e.getSalary());
		}
	}

	@Override
	public int updateEmployee(int Salary, int id) {

		Object[] parameters = { id, Salary };

		int i = jt.update("update employee set salary=? where id=?", parameters);

		return i;
	}

}
