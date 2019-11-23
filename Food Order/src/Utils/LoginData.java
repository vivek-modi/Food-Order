package Utils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DataBase.DbConnector;
import Interface.DatabaseInterface;

public class LoginData  implements DatabaseInterface {

	public LoginData() throws RemoteException {

	}

	@Override
	public boolean checkLogin(String user, String pass) throws RemoteException, SQLException {
		Connection connection = DbConnector.getConnection();

		PreparedStatement statement = connection
				.prepareStatement("SELECT * FROM logintable WHERE Username=? AND Password=?");
		statement.setString(1, user);
		statement.setString(2, pass);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			if (rs.getString("Username").equals(user) && rs.getString("Password").equals(pass)) {
				return true;
			}
		}
		return false;
	}

	

}
