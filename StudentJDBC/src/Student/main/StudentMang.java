package Student.main;

import java.util.Scanner;


public class StudentMang {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;
		System.out.println("-------------------------");
			System.out.println("|    STUDENT MANAGEMENT    |");
			System.out.println("----------------------------");
			System.out.println("|   1.STUDENT Details      |");
			System.out.println("|   2.Course  Details      |");
			System.out.println("|   3.Fee Details          |");
			System.out.println("|   4.Exit                 |");
			System.out.println("|--------------------------|");
			System.out.println("Enter your choice ");
			choice= sc.nextInt();
			switch(choice){
			case 1: StudentDetails.menu();
			        break;
			case 2 : CourseDetails.menu();
		
			break;
			case 3: System.out.println("fee details");
			break;
			case 4 : System.exit(0);
			default: System.out.println("please select choice range 1-4 only");
			}
			
			

	}

}
