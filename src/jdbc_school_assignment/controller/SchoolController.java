package jdbc_school_assignment.controller;

import java.util.List;
import java.util.Scanner;

import jdbc_school_assignment.dto.School;
import jdbc_school_assignment.service.SchoolService;

public class SchoolController {
	public static void main(String[] args) {
		School school = new School();
		SchoolService schoolservice = new SchoolService();
		Scanner sc = new Scanner (System.in);
		while(true) {
		System.out.println("Select the task to perform : \n1. Insert \n2. Select by id \n3. Select by Name \n4. Select by pattern  \n5. DisplayAll \n6. Delete \n7. Update name");
		int ch = sc.nextInt();
		switch(ch){
		case 1:{
			System.out.println("Enter id");
			int id = sc.nextInt();
			school.setId(id);
			
			System.out.println("Enter school name");
			String name = sc.next();
			name = name+sc.nextLine();
			school.setName(name);
			
			System.out.println("Enter school address");
			String address = sc.nextLine();
			school.setAddress(address);
			
			System.out.println("Enter school fees");
			int fees = sc.nextInt();
			school.setAdmission_fee(fees);
			
			System.out.println("Enter school pattern");
			String pattern = sc.next();
			pattern = pattern + sc.nextLine();
			school.setPattern(pattern);
			
			schoolservice.insertValuesService(school);
			System.out.println("Data stored");
			
		};
		break;
		case 2:{
			System.out.println("Enter id to view info");
			int id = sc.nextInt();
			schoolservice.selectByIdService(id);
			
		};
		break;
		case 3:{
			System.out.println("Enter school name to diplay details");
			String schoolname = sc.next();
			schoolname = schoolname + sc.nextLine();
			schoolservice.selectByNameService(schoolname);
		};
		break;
		case 4:{
			System.out.println("Enter the pattern to see the list");
			String pattern = sc.next();
			schoolservice.selectByPattern(pattern);
		};
		break;
		case 5:{
			List<School> schCon = schoolservice.displayAllService();
			
			for (School school2 : schCon) {
				System.out.println(school2);
			}
		};
		break;
		case 6:{
			System.out.println("Enter id to delete");
			int id= sc.nextInt();
			schoolservice.deleteById(id);
			System.out.println("Id deleted successfully");
		};
		break;
		case 7:{
			System.out.println("Enter New Name to Update");
			String name = sc.next();
			name= name+sc.nextLine();
			System.out.println("Enter existing id");
			int id = sc.nextInt();
			schoolservice.updateNameService(name, id);
			System.out.println("Name updated successfully");
		};
		break;
		}
		}
	}
	
	

}
