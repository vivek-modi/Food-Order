package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DataBase.DbConnector;

public class CheckInsertData {

	protected String username, password, email;

	public CheckInsertData(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;

	}

	public boolean checklength() {

		if (password.length() > 4)
			return true;
		else
			return false;
	}

}
