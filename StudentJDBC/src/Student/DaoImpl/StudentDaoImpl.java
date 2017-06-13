package Student.DaoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

import Student.main.StudentDetails;
import StudentDB.ConnectionManager;
import StudentDao.StudentDAO;

public class StudentDaoImpl implements StudentDAO {
	static StudentDetails sd = new StudentDetails();
	static Scanner sc = new Scanner(System.in);
	static Connection con = null;

	@Override
	public void addStudent() {

		System.out.println("Enter student number");
		int sno = sc.nextInt();

		System.out.println("Enter student name");
		String sname = sc.next();

		
		System.out.println("Enter student marks");
		int smarks = sc.nextInt();

		con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into StudentNew values(?,?,?)");
			ps.setInt(1, sno);
			ps.setString(2, sname);
			ps.setInt(3, smarks);
			int n = ps.executeUpdate();
			if (n!= 0) {
				System.out.println("one record Inserted");
			} else
				System.out.println("record not inserted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sd.menu();

	}

	@Override
	public void editStudent() {
		System.out.println("Enter student number");
		int sno = sc.nextInt();

		System.out.println("Enter student name");
		String sname = sc.next();

		System.out.println("Enter student marks");
		int smarks = sc.nextInt();
		
		con = ConnectionManager.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update StudentNew set sname=?,marks=? where sno=?");
			ps.setString(1, sname);
			ps.setInt(2, smarks);
			ps.setInt(3, sno);
			// ps.setInt(4, smarks);
			int n = ps.executeUpdate();
			if (n != 0) {
				System.out.println("one record edited");
			} else
				System.out.println("record not edited");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteStudent() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Student Number");
			int n = sc.nextInt();

			con = ConnectionManager.getConnection();

			PreparedStatement ps = con.prepareStatement("delete from StudentNew where sno=?");
			ps.setInt(1, n);
			int p = ps.executeUpdate();
			if (p != 0) {
				System.out.println("one record deleted");
			} else
				System.out.println("record not deleted");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void viewStudent() {
		// TODO Auto-generated method stub
		try {
			System.out.println("Enter Student Number");
			int n = sc.nextInt();

			con = ConnectionManager.getConnection();

			PreparedStatement ps = con.prepareStatement("select * from StudentNew where sno=?");
			ps.setInt(1, n);
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
