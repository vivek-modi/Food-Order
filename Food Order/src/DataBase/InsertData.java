package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Data.CheckInsertData;

public class InsertData extends CheckInsertData {

	public InsertData(String username, String password, String email) {
		super(username, password, email);
	}

	public int insertdata() {
		Connection connection = DbConnector.getConnection();
		int data = 0;

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection
					.prepareStatement("insert into logintable(Username,Password,Email) values(?,?,?)");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, email);
			data = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
