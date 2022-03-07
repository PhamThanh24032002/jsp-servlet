package implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dao.IBaseDao;
import connection.SQLConnection;
import entities.Student;

public class StudentImp implements IBaseDao<Integer, Student> {
	private static Connection connect = SQLConnection.getConnection();
	String sqlQuery;

	@Override
	public List<Student> getAll() {
		ResultSet result = null;
		sqlQuery = "select * from student";
		try {
			List<Student> studentLst = new ArrayList<>();
			PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);
			result = preparedStatement.executeQuery();
			result.next();
			int id = result.getInt("id");
			String name = result.getString("name");
			String address = result.getString("address");
			String email = result.getString("email");
			String phone = result.getString("phone");
			boolean status = result.getBoolean("status");
			Student newStu = new Student(id, name, address, email, phone, status);
			studentLst.add(newStu);
			return studentLst;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addNew(Student o) {
		sqlQuery = "insert into student values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);
			preparedStatement.setString(1, o.getName());
			preparedStatement.setString(2, o.getAddress());
			preparedStatement.setString(3, o.getEmail());
			preparedStatement.setString(4, o.getPhone());
			preparedStatement.setBoolean(5, o.isStatus());
			
			int check = preparedStatement.executeUpdate();
			if(check>0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student find_by_id(Integer id) {
			ResultSet result = null;
			sqlQuery = "select * from student where id = ?";
			try {
				PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);
				preparedStatement.setInt(1, id);
				result = preparedStatement.executeQuery();
				result.next();
				String name = result.getString("name");
				String address = result.getString("address");
				String email = result.getString("email");
				String phone = result.getString("phone");
				boolean status = result.getBoolean("status");
				Student newStu = new Student(id, name, address, email, phone, status);
				return newStu;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public boolean update(Student o) {
		sqlQuery = "update student set name = ?, address = ?, email = ?, phone = ?, status = ? where id = ?";
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);
			preparedStatement.setString(1, o.getName());
			preparedStatement.setString(2, o.getAddress());
			preparedStatement.setString(3, o.getEmail());
			preparedStatement.setString(4, o.getPhone());
			preparedStatement.setBoolean(5, o.isStatus());
			preparedStatement.setInt(6, o.getId());
			int check = preparedStatement.executeUpdate();
			if(check>0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(Integer id) {
		sqlQuery = "delete student where id = ?";
		try {
			PreparedStatement preparedStatement = connect.prepareStatement(sqlQuery);
			preparedStatement.setInt(1, id);
			int check = preparedStatement.executeUpdate();
			if(check>0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
