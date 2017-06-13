package SepPersisAndBusineLogic;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.*;


public class EmpMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {

		Employee e=new Employee();
		e.setId(rs.getInt(1));
		e.setName(rs.getString(2));
		e.setSalary(rs.getInt(3));
		
		return e;
	}

}
