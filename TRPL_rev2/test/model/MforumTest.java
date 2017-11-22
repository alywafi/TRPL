/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.swing.table.DefaultTableModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer
 */
public class MforumTest {
    
    public MforumTest() {
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
     * Test of getDataforumwithid method, of class Mforum.
     */
    @Test
    public void testGetDataforumwithid() throws Exception {
        System.out.println("getDataforumwithid");
        String ID = "";
        Mforum instance = new Mforum();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getDataforumwithid(ID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataforum method, of class Mforum.
     */
    @Test
    public void testGetDataforum() throws Exception {
        System.out.println("getDataforum");
        Mforum instance = new Mforum();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getDataforum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataforumselesai method, of class Mforum.
     */
    @Test
    public void testGetDataforumselesai() throws Exception {
        System.out.println("getDataforumselesai");
        Mforum instance = new Mforum();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getDataforumselesai();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataforumbelum method, of class Mforum.
     */
    @Test
    public void testGetDataforumbelum() throws Exception {
        System.out.println("getDataforumbelum");
        Mforum instance = new Mforum();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getDataforumbelum();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataforumselesaiwithid method, of class Mforum.
     */
    @Test
    public void testGetDataforumselesaiwithid() throws Exception {
        System.out.println("getDataforumselesaiwithid");
        String id = "";
        Mforum instance = new Mforum();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getDataforumselesaiwithid(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataforumbelumwithid method, of class Mforum.
     */
    @Test
    public void testGetDataforumbelumwithid() throws Exception {
        System.out.println("getDataforumbelumwithid");
        String id = "";
        Mforum instance = new Mforum();
        DefaultTableModel expResult = null;
        DefaultTableModel result = instance.getDataforumbelumwithid(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertDataforum method, of class Mforum.
     */
    @Test
    public void testInsertDataforum() {
        System.out.println("insertDataforum");
        String[] data = null;
        Mforum instance = new Mforum();
        boolean expResult = false;
        boolean result = instance.insertDataforum(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDataforum method, of class Mforum.
     */
    @Test
    public void testUpdateDataforum() {
        System.out.println("updateDataforum");
        String[] data = null;
        Mforum instance = new Mforum();
        boolean expResult = false;
        boolean result = instance.updateDataforum(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateDataforumadmin method, of class Mforum.
     */
    @Test
    public void testUpdateDataforumadmin() {
        System.out.println("updateDataforumadmin");
        String[] data = null;
        Mforum instance = new Mforum();
        boolean expResult = false;
        boolean result = instance.updateDataforumadmin(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateVerifikasi method, of class Mforum.
     */
    @Test
    public void testUpdateVerifikasi() {
        System.out.println("updateVerifikasi");
        String id = "";
        int index = 0;
        Mforum instance = new Mforum();
        boolean expResult = false;
        boolean result = instance.updateVerifikasi(id, index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataforum method, of class Mforum.
     */
    @Test
    public void testSetDataforum() throws Exception {
        System.out.println("setDataforum");
        String[] data = null;
        Mforum instance = new Mforum();
        boolean expResult = false;
        boolean result = instance.setDataforum(data);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
