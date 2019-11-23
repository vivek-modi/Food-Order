package Interface;

import java.rmi.*;
import java.sql.SQLException;

import Utils.LoginData;

public interface DatabaseInterface extends Remote {
	public boolean checkLogin(String user, String pass) throws RemoteException, SQLException;
}
