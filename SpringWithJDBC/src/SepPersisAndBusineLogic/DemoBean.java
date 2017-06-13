package SepPersisAndBusineLogic;

public class DemoBean {

	EmployeeDao dao;

	public void setDao(EmployeeDao dao) {
		this.dao = dao;
	}

	public int insert(Employee e) {
		int i = dao.insertEmployee(e);

		System.out.println(i);
		return i;
	}

	public void selectAll() {
		dao.SelectAllEmployee();
	}

	public int modify(int Salary, int id) {
		int j = dao.updateEmployee(Salary, id);

		return j;
	}

}
