package Student.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import Student.main.CourseDetails;
import StudentDB.ConnectionManager;
import StudentDao.CourseDAO;

public class CourseDAOImpl implements CourseDAO {
	static CourseDetails cd = new CourseDetails();
	static Scanner sc = new Scanner(System.in);
	Connection con = null;

	@Override
	public void addCourse() {
		System.out.println("Enter Course Id");
		int cno = sc.nextInt();
		System.out.println("Enter Course name");
		String cname = sc.next();
		System.out.println("Enter the fee");
		int fees = sc.nextInt();
		try {
			con = ConnectionManager.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into CourseDetails values(?,?,?)");
			ps.setInt(1, cno);
			ps.setString(2, cname);
			ps.setInt(3, fees);
			int n = ps.executeUpdate();
			if (n != 0) {
				System.out.println("Course added");
			} else
				System.out.println("Course not added");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
cd.menu();
	}

	@Override
	public void editCourse() {
		// TODO Auto-generated method stub
		System.out.println("Enter Course Id");
		int cno = sc.nextInt();
		System.out.println("Enter Course name");
		String cname = sc.next();
		System.out.println("Enter the fee");
		int fees = sc.nextInt();
		try {
			con=ConnectionManager.getConnection();
			PreparedStatement ps= con.prepareStatement("update CourseDetails set cname=?,fees=? where cno=?");
			ps.setString(1, cname);
			ps.setInt(2, fees);
			ps.setInt(3, cno);
			int n= ps.executeUpdate();
			if (n != 0) {
				System.out.println("Course edited");
			} else
				System.out.println("Course not edited");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCourse() {
		System.out.println("Enter Course Id");
		int cno= sc.nextInt();
		try {
			con=ConnectionManager.getConnection();
			PreparedStatement ps= con.prepareStatement("delete from CourseDetails where cno=?");
			ps.setInt(1, cno);
			int n= ps.executeUpdate();
			if (n != 0) {
				System.out.println("Course deleted");
			} else
				System.out.println("Course not deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void viewCourse() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Course Id");
			int cno= sc.nextInt();
			con = ConnectionManager.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from CourseDetails where cno=?");
			ps.setInt(1, cno);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnName(1) + "\t" + rsmd.getColumnName(2) + "\t" + rsmd.getColumnName(3));
			System.out.println("--------------------------------------------------------------------------");
			while (rs.next()) {
				System.out.println(rs.getString(1)+"\t" + rs.getString(2)+"\t" + rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
