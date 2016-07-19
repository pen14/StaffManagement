/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author penpen
 */
public interface RemoteServer extends Remote {
    
    public String login(String username, String pasword)throws RemoteException;
    public String updatePassword (Integer id, String newPassword)throws RemoteException;
    public String getProfile(Integer id)throws RemoteException;
    public String updateContactNo(Integer id,String newNumber)throws RemoteException;
    public String updateAddress(Integer id, String newAddress)throws RemoteException;
    public String viewMyShifts(Integer id)throws RemoteException;
    
}
