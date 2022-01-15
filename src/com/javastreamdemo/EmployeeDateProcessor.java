package com.javastreamdemo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.javastreamdemo.properties.Employee;
public class EmployeeDateProcessor {
 public static void main(String args[]) {
	 List<Employee> employeeList = createDemoData();
	 printDepartmentWiseGender(employeeList);
	 printAllDepartmentNames(employeeList);
	 printGenderwiseAgeOfEmp(employeeList);
	 printHighestPaidEmployeeDetails(employeeList);
	 getEmpWhoJoinedAfter2015(employeeList);
	 getEmpWhoJoinedAfter2015(employeeList);
	 printDepartmentwiseNumberOfEmp(employeeList);
	 getDepartmentwiseAverageSalary(employeeList);
	 getYoungestMaleEmployee(employeeList);
	 getGenderwiseEmployeesInSalesAndMark(employeeList);
	 getGenderwiseAverageSalary(employeeList);
	 getDepartmentwiseEmpNames(employeeList);
	 getAverageSalary(employeeList);
 }
 
 public static List<Employee> createDemoData(){
	 List<Employee> employeeList = new ArrayList<Employee>();
     
	 employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
	 employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
	 employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
	 employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
	 employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
	 employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
	 employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
	 employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
	 employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
	 employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
	 employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
	 employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
	 employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
	 employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
	 employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
	 employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
	 employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));
	 return employeeList;
 }
 
 public static void printDepartmentWiseGender(List<Employee> employees) {
		 Map<String, Long> genderwiseCountOfEmployees=employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		 System.out.println("Printing Genderwise count of employees:" + genderwiseCountOfEmployees);
	 }
 public static void printAllDepartmentNames(List<Employee> employees) {
	 System.out.println("Printing Distinct departments of employees:");
	 employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

 }
 
 public static void printGenderwiseAgeOfEmp(List<Employee> employees) {
	 Map<String, Double> genderwiseAgeOfEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
	 System.out.println("Printing Genderwise count of employees:"+genderwiseAgeOfEmployees);
 }

	public static void printHighestPaidEmployeeDetails(List<Employee> employees) {
		Optional<Employee> highestPaidEmployee = employees.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));
		System.out.println("Printing Highest Paid Employee details:" + highestPaidEmployee.get());
	}
	
	public static void getEmpWhoJoinedAfter2015(List<Employee> employees) {
		employees.stream().filter(emp -> emp.getYearOfJoining() > 2015).map(Employee::getName)
				.forEach(System.out::println);
	}

	public static void printDepartmentwiseNumberOfEmp(List<Employee> employees) {
		Map<String, Long> departmentWiseNumberOfEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println("Department wise Number Of Employees:" + departmentWiseNumberOfEmployees);
	}
	
	public static void getDepartmentwiseAverageSalary(List<Employee> employees) {
		Map<String, Double> departmentwiseAverageSalary = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Department wise Avg. Salary Of Employees:" + departmentwiseAverageSalary);
	}

	public static void getYoungestMaleEmployee(List<Employee> employees) {
		Optional<Employee> employee = employees.stream()
				.filter(emp -> emp.getGender().equals("Male") && emp.getDepartment().equals("Product Development"))
				.min(Comparator.comparingInt(Employee::getAge));
		System.out.println("Printing the youngest male employee in Product Development Dept:" + employee.get());
	}
	
	public static void getMostExperiencedEmployee(List<Employee> employees) {
		employees.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
	}

	public static void getGenderwiseEmployeesInSalesAndMark(List<Employee> employee) {
		Map<String, Long> genderwiseEmployeesInSalesAndMark = employee.stream().filter(emp -> emp.getDepartment().equals("Sales And Marketing"))
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println("Printing Genderwise employees in Sales and Marketing:"+genderwiseEmployeesInSalesAndMark);
	}
	
	public static void getGenderwiseAverageSalary(List<Employee> employee) {
		Map<String, Double> genderwiseEmployeeSalary = employee.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Printing Genderwise salary of employees:"+genderwiseEmployeeSalary);
	}

	public static void getDepartmentwiseEmpNames(List<Employee> employees) {
		Map<String, List<Employee>> departmentwiseEmpNames = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		Set<Entry<String, List<Employee>>> entrySet = departmentwiseEmpNames.entrySet();
		for(Entry<String, List<Employee>> entry:entrySet) {
			List<Employee> list = entry.getValue();
			for(Employee e:list) {
				System.out.println(e.getName());;
			}
		}
	}
	public static void getAverageSalary(List<Employee> employees) {
		Double averageSalary = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
	}
}