package jdbc_school_assignment.service;
import java.util.List;

import jdbc_school_assignment.dao.SchoolDao;
import jdbc_school_assignment.dto.School;

public class SchoolService {
	SchoolDao schooldao = new SchoolDao();
	public void insertValuesService(School school) {
		schooldao.insertValues(school);
		
	}
	
	public School selectByIdService(int id) {
		if(schooldao.getById(id)==id) {
			return schooldao.selectById(id);
		}
		else {
			System.err.println("Id not found idiot");
		}
		return null;
		
	}
	public School selectByNameService(String name) {
		if(schooldao.getByName(name)!=null) {
			return schooldao.selectByName(name);
		}
		
		else {
			System.err.println("Name not found");
		}
		return null;
		
	}
	public School selectByPattern(String pattern) {
		if(schooldao.getByPattern(pattern)!=null) {
			return schooldao.selectByPattern(pattern);
		}
		else {
			System.err.println("Pattern doesn't exist");
		}
		return null;
	}
	public List<School> displayAllService(){
		return schooldao.displayAll();
	}
	public void deleteById(int id) {
		if(schooldao.getById(id)==id) {
			schooldao.deleteById(id);
		}
		else {
			System.out.println("Id not found");
		}
	}
	public void updateNameService(String name, int id) {
		if(schooldao.getById(id)==id) {
			schooldao.updateName(name, id);
		}
		else {
			System.out.println("ID not found");
		}
	}
	
}
