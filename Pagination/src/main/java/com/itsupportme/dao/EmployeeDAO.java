/**
 * 
 */
package com.itsupportme.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.itsupportme.model.beans.Employee;
import com.itsupportme.model.db.ConnectionFactory;

/**
 * @author Andrei
 *
 */
public class EmployeeDAO {
	Connection connection;
	Statement stmt;
	private int noOfRecords;
	
	public EmployeeDAO() {
	}

	private static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = ConnectionFactory.getInstance().getConnection();
		return con;
	}

	public void addEmployee(Employee employee) {

		String querry = "INSERT INTO employee (emp_name, salary, dept_name) VALUES (?,?,?)";
		PreparedStatement insertEmployee = null;
		try {
			connection = getConnection();
			insertEmployee = connection.prepareStatement(querry);
			String name = employee.getEmployeeName();
			Double salary = employee.getSalary();
			String dept = employee.getDeptName();
			insertEmployee.setString(1, name);
			insertEmployee.setDouble(2, salary);
			insertEmployee.setString(3, dept);
			insertEmployee.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (insertEmployee != null)
					insertEmployee.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Employee> viewAllEmployees(int offset, int noOfRecords) {
		String query = "select SQL_CALC_FOUND_ROWS * from employee limit " + offset + ", " + noOfRecords;
		List<Employee> list = new ArrayList<Employee>();
		Employee employee = null;
		try {
			connection = getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt("emp_id"));
				employee.setEmployeeName(rs.getString("emp_name"));
				employee.setSalary(rs.getDouble("salary"));
				employee.setDeptName(rs.getString("dept_name"));
				list.add(employee);
			}
			rs.close();

			rs = stmt.executeQuery("SELECT FOUND_ROWS()");
			if (rs.next())
				this.noOfRecords = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int getNoOfRecords() {
		return noOfRecords;
	}
}
