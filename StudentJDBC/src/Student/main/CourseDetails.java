package Student.main;

import java.util.Scanner;

import Student.DaoImpl.CourseDAOImpl;
import Student.DaoImpl.StudentDaoImpl;

public class CourseDetails {
	static Scanner sc = new Scanner(System.in);
	static CourseDAOImpl cdao = new CourseDAOImpl();

	public static void menu() {

		while (true) {
			System.out.println("|---------------------|");
			System.out.println("| COURSE DETAILS MENU ");
			System.out.println("|---------------------|");
			System.out.println("|  1. ADD COURSE     |");
			System.out.println("|  2. EDIT COURSE     |");
			System.out.println("|  3. VIEW COURSE     |");
			System.out.println("|  4. DELETE COURSE   |");
			System.out.println("|  5. BACK     |");
			System.out.println("------------------------");
			System.out.println("ENTER YOUR CHOICE ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				cdao.addCourse();
				break;

			case 2:
				cdao.editCourse();
				break;
			case 3:
				cdao.viewCourse();

				break;
			case 4:
				cdao.deleteCourse();
				break;

			case 5:
				StudentMang.main(null);
			default:
				System.out.println("Please select choice range 1-5 only");

			}
		}
	}

	
}
