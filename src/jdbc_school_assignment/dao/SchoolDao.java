package jdbc_school_assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import jdbc_school_assignment.connection.SchoolConnection;
import jdbc_school_assignment.dto.School;

public class SchoolDao {
Connection con = SchoolConnection.getConnectionSchool();
	
	public void insertValues(School school) {
		String insertQuery = "Insert into school values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(insertQuery);
			pstmt.setInt(1, school.getId());
			pstmt.setString(2, school.getName());
			pstmt.setString(3, school.getAddress());
			pstmt.setInt(4, school.getAdmission_fee());
			pstmt.setString(5, school.getPattern());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int getById(int id) {
		String getId = "select * from school where schoolid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(getId);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id1 = rs.getInt("schoolid");
				return id1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	public School selectById(int id) {
		String idQuery = "Select * from school where schoolid =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(idQuery);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				School school = new School();
				school.setId(rs.getInt(1));
				school.setName(rs.getString(2));
				school.setAddress(rs.getString(3));
				school.setAdmission_fee(rs.getInt(4));
				school.setPattern(rs.getString(5));
				
				System.out.println(school);
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getByName(String name) {
		String getName = "select * from school where schoolname =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(getName);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String name1= rs.getNString(2);
				return name1;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public School selectByName(String name) {
		String nameQuery = "select * from school where schoolname =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(nameQuery);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				School school = new School();
				school.setId(rs.getInt(1));
				school.setName(rs.getString(2));
				school.setAddress(rs.getString(3));
				school.setAdmission_fee(rs.getInt(4));
				school.setPattern(rs.getString(5));
				
				System.out.println(school);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	public String getByPattern(String pattern) {
		String getPattern = "select * from school where schoolpattern =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(getPattern);
			pstmt.setString(1, pattern);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pattern1 = rs.getString(5);
				return pattern1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public School selectByPattern(String pattern) {
		String selectPattern = "select * from school where schoolpattern = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(selectPattern);
			pstmt.setString(1, pattern);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				School school= new School();
				school.setId(rs.getInt(1));
				school.setName(rs.getString(2));
				school.setAddress(rs.getString(3));
				school.setAdmission_fee(rs.getInt(4));
				school.setPattern(rs.getString(5));
				
				System.out.println(school);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<School> displayAll(){
		String Disp = "select * from school";
		try {
			PreparedStatement pstmt = con.prepareStatement(Disp);
			ResultSet rs = pstmt.executeQuery();
			List<School> schools = new ArrayList<School>();
			
			while(rs.next()) {
				School school = new School();
				school.setId(rs.getInt(1));
				school.setName(rs.getString(2));
				school.setAddress(rs.getString(3));
				school.setAdmission_fee(rs.getInt(4));
				school.setPattern(rs.getString(5));
				
				schools.add(school);
			}
			return schools;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public void deleteById(int id) {
		String deleteById = "delete from school where schoolid = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(deleteById);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateName(String name, int id) {
		String updateNameQuery = "Update school set schoolname =? where schoolid =?";
		try {
			PreparedStatement pstmt = con.prepareStatement(updateNameQuery);
			pstmt.setString(1, name);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
