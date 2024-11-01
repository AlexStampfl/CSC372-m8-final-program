package m8_final_project;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Student {
	// #1 - student data in private fields in a student class
	private String name;
	private String address;
	private Double GPA;
	
	// Student Class Constructor
	public Student(String name, String address, Double GPA) {
		this.name = name;
		this.address = address;
		this.GPA = GPA;
	}

	// Display Object data in appealing way
	public String toString() {
		return "Student{name= '" + name + "', address= '" + address + "', GPA= '" + GPA + "'}";
	}
	
	public static LinkedList<Student> studentList() {
		// #2 - Each student object is stored in a linked list
		LinkedList<Student> students = new LinkedList<>();
		
		// Scanner object
		Scanner scr = new Scanner(System.in);
		
		// Loop to keep adding more students
		boolean addMore = true;
		while (addMore) {
			String name, address;
			Double gpa = null;

			// #3 - A loop that prompts user for student data
			System.out.println("Enter student name:");
			name = scr.nextLine();
			
			System.out.print("Enter student address: ");
			address = scr.nextLine();
			
			// #4 - Validate numeric data for GPA
			while (gpa == null) {
				System.out.print("Enter a student GPA(number): ");
				String gpaInput = scr.nextLine();
				
				try {
					gpa = Double.parseDouble(gpaInput); // convert input to double
				} catch (NumberFormatException e) { // if it's not a number, catch the value
					System.out.println("Invalid GPA. Please enter a numeric value.");
				}
			}
			
			// #2 - Add/Store student object to linkedlist
			students.add(new Student(name, address, gpa));
			
			// ask user if they want to add another student
			System.out.println("Do you want to add another student? (yes/no)");
			String response = scr.nextLine();
			
			// if user says no, break the loop and exit
			if (response.equalsIgnoreCase("no")) {
				addMore = false;
			}	
		}
		
	// Display all student in list
	System.out.println("Student list: ");
	for (Student student : students) {
		System.out.println(student);
	}
	return students; // return populated list
}
	
	// Export contents to text file
	public static void exportList(LinkedList<Student> students, String filePath) { 
		try (FileWriter writer = new FileWriter(filePath)){ // Creates new file or Overwrites Existing File
			for (Student student : students) {
				writer.write(student.toString() + "\n");
			}
			System.out.println("Student list exported successfully to 'student.txt'");
		} catch (IOException e) {
			System.out.println("An error occurred while writing to this file.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// Call or Invoke other methods
		LinkedList<Student> students = studentList();
		
		// Sort students by name
		students.sort(Comparator.comparing(student -> student.name)); // Sorts alphabetically by name
		
		String filePath = "C:\\Users\\alexs\\OneDrive\\Documents\\CSU Global\\term5_fallc\\CSC372_programmingII\\m8\\m8_final_project\\m8_final_project\\src\\m8_final_project\\student.txt";
		exportList(students, filePath);
	}
}







