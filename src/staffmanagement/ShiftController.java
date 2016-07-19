/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author penpen
 */
public class ShiftController {

    private EntityManagerFactory emf;
    EntityManager em = getEntityManager();

    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("StaffManagementPU");
        }
        return emf.createEntityManager();
    }

    public String bookEmployee(Integer employeeID,Integer shiftRef, String firstName, String lastName) {

        Staffbooking booking = new Staffbooking();
   
        em.getTransaction().begin();
        booking.setShiftreference(shiftRef);
        booking.setFirstname(firstName);
        booking.setLastname(lastName);
        booking.setEmployeeid(employeeID);
        em.persist(booking);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return "Staff has been successfuly booked";
    }

    public String cancelEmployee(Integer bookingID) {
        Staffbooking booking = em.find(Staffbooking.class,bookingID);
        em.getTransaction().begin();
        em.remove(booking);
        em.getTransaction().commit();
        return "Staff shift has been cancelled";
    }

  

}
