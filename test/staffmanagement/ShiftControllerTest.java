/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staffmanagement;

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
public class ShiftControllerTest {
    
    public ShiftControllerTest() {
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
     * Test of bookEmployee method, of class ShiftController.
     */
    @Test
    public void testBookEmployee() {
        System.out.println("bookEmployee");
        Integer employeeID = 1;
        Integer shiftRef = 2;
        String firstName = "Jenny";
        String lastName = "Rikhotso";
        ShiftController instance = new ShiftController();
        String expResult = "Staff has been successfuly booked";
        String result = instance.bookEmployee(employeeID, shiftRef, firstName, lastName);
        assertEquals(expResult, result);
    }

    /**
     * Test of cancelEmployee method, of class ShiftController.
     */
    @Test
    public void testCancelEmployee() {
        System.out.println("cancelEmployee");
        Integer bookingID = 1;
        ShiftController instance = new ShiftController();
        String expResult = "Staff shift has been cancelled";
        String result = instance.cancelEmployee(bookingID);
        assertEquals(expResult, result);
        
        
    }
    
}
