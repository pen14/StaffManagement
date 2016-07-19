/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement.server;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import staffmanagement.EmployeeController;
import staffmanagement.GUI.AdminView;
import staffmanagement.GUI.EmployeeView;

/**
 *
 * @author penpen
 */
public class Server extends UnicastRemoteObject implements RemoteServer {

    EmployeeController control = new EmployeeController();

    public Server() throws RemoteException {

    }

    @Override
    public String login(String username, String password) throws RemoteException {
        return authenticate(username, password);

    }

    @Override
    public String updatePassword(Integer employeeID, String newPassword) throws RemoteException {
        return control.updatePassword(employeeID, newPassword);
    }

    @Override
    public String updateContactNo(Integer employeeID, String newTelNumber) throws RemoteException {
        return control.setContact(employeeID, newTelNumber);
    }

    @Override
    public String updateAddress(Integer employeeID, String newAddress) throws RemoteException {
        return control.setNewAddress(employeeID, newAddress);

    }

    @Override
    public String getProfile(Integer employeeID) throws RemoteException {
        return control.viewProfie(employeeID);
    }

    @Override
    public String viewMyShifts(Integer employeeID) throws RemoteException {

        return control.viewShifts(employeeID);

    }

    private String authenticate(String user, String password) throws RemoteException {
        try {
            Connection conn = getDBConnection();
            String authenticate = "SELECT * FROM STAFF WHERE username=? AND password=?";
            PreparedStatement pstmt = conn.prepareStatement(authenticate);
            pstmt.setString(1, user);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                if (user.equals("admin")) {
                    AdminView admin = new AdminView();
                    admin.setVisible(true);
                } else {
                    EmployeeView menu = new EmployeeView();
                    menu.setVisible(true);
                    pstmt.close();
                    conn.close();
                }
                return "success login";

            }

        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "The username or password you entered is incorrect";
    }

    private Connection getDBConnection() {
        Connection conn = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/Staff Management";
            Properties info = new Properties();
            info.put("user", "penilop");
            info.put("password", "sunday1985");
            conn = DriverManager.getConnection(url, info);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);

        }
        return conn;
    }

    public static void main(String[] args) {
        try {

            RemoteServer server;
            Registry reg = LocateRegistry.createRegistry(1099);

            server = new Server();
            Naming.rebind("StaffServer", server);
            System.out.println("Server Started");
        } catch (IOException e) {
        }
    }

}
