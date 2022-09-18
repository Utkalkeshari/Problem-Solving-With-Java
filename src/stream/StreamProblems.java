package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamProblems {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Student student1 = new Student("Jayesh", 20, new Address("99999"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("5678")));

		Student student2 = new Student("Khyati", 20, new Address("55555"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Student student3 = new Student("Jason", 20, new Address("99999"),
				Arrays.asList(new MobileNumber("1234"), new MobileNumber("3333")));

		List<Student> students = Arrays.asList(student1, student2, student3);

		// Get the Student where name = Jayesh

		/*
		 * Optional<Student> stud= students.stream().filter(student ->
		 * student.getName().equalsIgnoreCase("Jayesh")).findFirst(); stud.ifPresent(v->
		 * System.out.println(v.getName()));
		 */

		// Get student with matching address "Cuttack"
		List<Student> studentWithSameAddress = students.stream()
				.filter(student -> student.getAddress().getZipcode().equalsIgnoreCase("99999"))
				.collect(Collectors.toList());
		System.out.println(studentWithSameAddress.size() != 0 ? studentWithSameAddress.size() : "No Student Found");

		// Get all student having mobile numbers 3333.
		List<String> studentWithSameNumber = students.stream()
				.filter(student -> student.getMobileNumbers().stream()
						.anyMatch(number -> number.getNumber().equalsIgnoreCase("3333")))
				.map(student -> student.getName()).collect(Collectors.toList());
		System.out.println(studentWithSameNumber.size() != 0 ? studentWithSameNumber.toString() : "No Student Found");

		// Get all student having mobile number 1233 and 1234
		List<String> studentWithSameNumber2 = students.stream()
				.filter(student -> student.getMobileNumbers().stream()
						.anyMatch(number -> number.getNumber().equalsIgnoreCase("3333")
								|| number.getNumber().equalsIgnoreCase("1233")))
				.map(student -> student.getName()).collect(Collectors.toList());
		System.out.println(studentWithSameNumber2.size() != 0 ? studentWithSameNumber2.toString() : "No Student Found");

		// Convert List<Student> to List<String> of student name
		// List<String> allNames = students.stream().map(student ->
		// student.getName()).collect(Collectors.toList());
		String allNames = students.stream().map(student -> student.getName())
				.collect(Collectors.joining(",", "[", "]"));
		System.out.println(allNames);
		
		//sort the Students based on name
		/*
		 * List<Student> sortedStudents = students.stream().sorted((s1, s2)->
		 * s1.getName().compareTo(s2.getName())).collect(Collectors.toList());
		 * sortedStudents.forEach(s -> System.out.println(s));
		 */
		
	}

}
