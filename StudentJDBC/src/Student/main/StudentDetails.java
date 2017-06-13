package Student.main;

import java.util.Scanner;

import Student.DaoImpl.StudentDaoImpl;

public class StudentDetails {
	static Scanner sc = new Scanner(System.in);
	static StudentDaoImpl sdao = new StudentDaoImpl();

	public static void menu() {

		while (true) {
			System.out.println("|---------------------|");
			System.out.println("| STUDENT DETAILS MENU ");
			System.out.println("|---------------------|");
			System.out.println("|  1. ADD STUDENT     |");
			System.out.println("|  2. EDIT STUDENT     |");
			System.out.println("|  3. VIEW STUDENT     |");
			System.out.println("|  4. DELETE STUDENT   |");
			System.out.println("|  5. BACK     |");
			System.out.println("------------------------");
			System.out.println("ENTER YOUR CHOICE ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				sdao.addStudent();
				break;

			case 2:
				sdao.editStudent();
				break;
			case 3:
				sdao.viewStudent();

				break;
			case 4:
				sdao.deleteStudent();
				break;

			case 5:
				StudentMang.main(null);
			default:
				System.out.println("Please select choice range 1-5 only");

			}
		}
	}
}