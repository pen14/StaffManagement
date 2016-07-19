/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author penpen
 */
public class EmployeeController {

    private EntityManagerFactory emf;
    EntityManager em = getEntityManager();

    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("StaffManagementPU");
        }
        return emf.createEntityManager();
    }

    public void addEmployee(Staff e) {
        em.merge(e);
    }

//    public Staff login(String id, String username, String password) {
//
//        if (username != null && password != null) {
//            Staff staff = em.find(Staff.class, id);
//           staff.setUsername(username);
//           staff.setPassword(password);
//            return staff;
//        } else {
//            return null;
//        }
//
//    }

    public Staff addEmployee(String firstName, String lastName,
            String telNo, String address, String username, String password, String position) {

        Staff empl = new Staff();

        em.getTransaction().begin();
        empl.setFirstname(firstName);
        empl.setLastname(lastName);
        empl.setTelno(telNo);
        empl.setAddress(address);
        Date date = new Date();
        empl.setStartOfEmployement(date);
        empl.setPosition(position);
        empl.setUsername(username);
        empl.setPassword(password);
        em.persist(empl); //em.merge(u); for updates
        em.getTransaction().commit();
        em.close();
        emf.close();

        return empl;

    }

    public String deleteEmployee(Integer employeeID) {
        if (employeeID != null) {
            Staff s = em.find(Staff.class, employeeID);
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
            return "Record Deleted";
        } else {
            return "Unable to delete record";
        }
    }

    public String setContact(Integer employeeID, String newTelNumber) {
        if (employeeID != null) {
            Staff staff = em.find(Staff.class, employeeID);
            em.getTransaction().begin();
            staff.setTelno(newTelNumber);
            em.getTransaction().commit();
            return "Contact number updated";
        } else {
            return "Could not update contact number";
        }
    }

    public String setNewAddress(Integer employeeID, String newAddress) {

        if (employeeID != null) {
            Staff empl = em.find(Staff.class, employeeID);
            em.getTransaction().begin();
            empl.setAddress(newAddress);
            em.getTransaction().commit();
            return "Address updated";
        } else {
            return "Could not update address";
        }

    }

    public String updatePassword(Integer employeeID, String newPassword) {

        if (employeeID != null) {
            Staff empl = em.find(Staff.class, employeeID);
            em.getTransaction().begin();
            empl.setPassword(newPassword);
            em.getTransaction().commit();
            return "Password updated";
        }
        return "Password could not be updated";
    }

    public String viewProfie(Integer employeeID) {

        if (employeeID != null) {
            Staff empl = em.find(Staff.class, employeeID);
            em.getTransaction().begin();
            String details = empl.toString();
            em.getTransaction().commit();
            return details;
        } else {
            return "Could not retrieve profile";
        }
    }
      public String setStaffLeave(Integer employeeID, String firstname, String lastname) {
        Staffleave sl = new Staffleave();
        em.getTransaction().begin();
        sl.setEmployeeid(employeeID);
        sl.setFirstname(firstname);
        sl.setLastname(lastname);
        em.persist(sl);
        em.getTransaction().commit();
        deleteEmployee(employeeID);
        em.close();
        emf.close();
        return "Staff successfully booked on leave";
    }

    public String viewShifts(Integer employeeID) {

        String myShifts = "";
        Staff empl = em.find(Staff.class, employeeID);
        Query q = em.createNamedQuery("Staffbooking.findByEmployeeid");

        List<Staffbooking> shifts = q.getResultList();
        for (Staffbooking s : shifts) {
            //if (empl.getEmployeeid().equals(employeeID)) {
                myShifts = myShifts + s.toString();
            //}
        }
        return myShifts;

    }

    public List<Staff> getEmployees() {

        try {
            Query q = em.createNamedQuery("Staff.findAll");
            return (List<Staff>) q.getResultList();
        } finally {
            em.close();
        }
    }

}
