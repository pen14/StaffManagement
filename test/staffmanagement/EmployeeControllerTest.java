/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author penpen
 */
public class EmployeeControllerTest {
    
    public EmployeeControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addEmployee method, of class EmployeeController.
     */
    @Test
    public void testAddEmployee_7args() {
        System.out.println("addEmployee");
        String firstName = "Kelly";
        String lastName = "Grayson";
        String telNo = "02084437744";
        String address = "90 tall street";
        String username = "";
        String password = "";
        String position = "nurse";
        EmployeeController instance = new EmployeeController();
        Staff expResult = null;
        Staff result = instance.addEmployee(firstName, lastName, telNo, address, username, password, position);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteEmployee method, of class EmployeeController.
     */
    @Test
    public void testDeleteEmployee() {
        System.out.println("deleteEmployee");
        Integer employeeID = 12;
        EmployeeController instance = new EmployeeController();
        String expResult = "Record Deleted";
        String result = instance.deleteEmployee(employeeID);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of setContact method, of class EmployeeController.
     */
    @Test
    public void testSetContact() {
        System.out.println("setContact");
        Integer employeeID = 8;
        String newTelNumber = "12345";
        EmployeeController instance = new EmployeeController();
        String expResult = "Contact number updated";
        String result = instance.setContact(employeeID, newTelNumber);
        assertEquals(expResult, result);
 
        
    }

    /**
     * Test of setNewAddress method, of class EmployeeController.
     */
    @Test
    public void testSetNewAddress() {
        System.out.println("setNewAddress");
        Integer employeeID = 3;
        String newAddress = "67 fix red";
        EmployeeController instance = new EmployeeController();
        String expResult = "Address updated";
        String result = instance.setNewAddress(employeeID, newAddress);
        assertEquals(expResult, result);
    }

    /**
     * Test of updatePassword method, of class EmployeeController.
     */
    @Test
    public void testUpdatePassword() {
        System.out.println("updatePassword");
        Integer employeeID = 8;
        String newPassword = "hello";
        EmployeeController instance = new EmployeeController();
        String expResult = "Password updated";
        String result = instance.updatePassword(employeeID, newPassword);
        assertEquals(expResult, result);
    }


    /**
     * Test of setStaffLeave method, of class EmployeeController.
     */
    @Test
    public void testSetStaffLeave() {
        System.out.println("setStaffLeave");
        Integer employeeID = 15;
        String firstname = "Jade";
        String lastname = "Green";
        EmployeeController instance = new EmployeeController();
        String expResult = "Staff successfully booked on leave";
        String result = instance.setStaffLeave(employeeID, firstname, lastname);
        assertEquals(expResult, result);
    
    }


    /**
     * Test of getEmployees method, of class EmployeeController.
     */
    @Test
    public void testGetEmployees() {
        System.out.println("getEmployees");
        EmployeeController instance = new EmployeeController();
        List<Staff> expResult = null;
        List<Staff> result = instance.getEmployees();
        assertEquals(expResult, result);
    }
    
}
