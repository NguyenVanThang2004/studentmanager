package DatabaseAcessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Database.JDBCUtil;
import Model.Student;

public class DAOStudent implements DAOInterface<Student> {

	public static DAOStudent getInstance() {
		return new DAOStudent();
	}

	@Override
	public void insert(Student t) {

		try {

			// 1. connect database
			Connection connect = JDBCUtil.getConnection();

			// 2. create SQL command
			String sql = "INSERT INTO student(id,name,gender,score)" + "VALUES (?,?,?,?)";

			// 3. create preparedStatement
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1, t.getId());
			pst.setString(2, t.getName());
			pst.setInt(3, t.getGender());
			pst.setFloat(4, t.getScore());

			// 4. execute and test
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println(sql);
			}

			// 5. close database
			JDBCUtil.closeConnection(connect);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Student t) {

		try {

			// 1. connect database
			Connection connect = JDBCUtil.getConnection();

			// 2. create SQL command
			String sql = "UPDATE student SET name=?, gender=?, score=? WHERE id=?";

			// 3. create preparedStatement
			PreparedStatement pst = connect.prepareStatement(sql);

			// 4. execute and test
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println(sql);
			}

			// 5. close database
			JDBCUtil.closeConnection(connect);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Student t) {

		try {

			// 1. connect database
			Connection connect = JDBCUtil.getConnection();

			// 2. create SQL command
			String sql = "DELETE FROM student WHERE id LIKE ?";

			// 3. create preparedStatement
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1, t.getId());

			// 4. execute and test
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println(sql);
			}

			// 5. close database
			JDBCUtil.closeConnection(connect);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<Student> selectAll() {

		ArrayList<Student> listStudent = new ArrayList<>();
		try {

			// 1. connect database
			Connection connect = JDBCUtil.getConnection();

			// 2. create SQL command
			String sql = "SELECT * FROM student";

			// 3. create preparedStatement
			PreparedStatement pst = connect.prepareStatement(sql);

			// 4. execute and test
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int  gender = rs.getInt("gender");
				float score = rs.getFloat("score");

				Student student = new Student(id, name, gender, score);
				listStudent.add(student);
			}

			// 5. close database
			JDBCUtil.closeConnection(connect);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listStudent;
	}

	@Override
	public Student selectById(Student t) {

		Student student = null;

		try {

			// 1. connect database
			Connection connect = JDBCUtil.getConnection();

			// 2. create SQL command
			String sql = "SELECT * FROM student WHERE id LIKE ?";

			// 3. create preparedStatement
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1, t.getId());

			// 4. execute and test
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int  gender = rs.getInt("gender");
				float score = rs.getFloat("score");

				student = new Student(id, name, gender, score);

			}

			// 5. close database
			JDBCUtil.closeConnection(connect);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return student;

	}

}
