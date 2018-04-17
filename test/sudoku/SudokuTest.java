/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author edi
 */
public class SudokuTest {
    
    public SudokuTest() {
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
     * Test of valida method, of class Sudoku.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        int fila = 0;
        int columna = 0;
        int num = 0;
        Sudoku instance = new Sudoku();
        boolean expResult = false;
        boolean result = instance.valida(fila, columna, num);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resuelve method, of class Sudoku.
     */
    @Test
    public void testResuelve() {
        System.out.println("resuelve");
        Sudoku instance = new Sudoku();
        boolean expResult = true;
        boolean result = instance.resuelve();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisionInicial method, of class Sudoku.
     */
    @Test
    public void testRevisionInicial() {
        System.out.println("revisionInicial");
        Sudoku instance = new Sudoku();
        boolean expResult = true;
        boolean result = instance.revisionInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revisionNumerosValidos method, of class Sudoku.
     */
    @Test
    public void testRevisionNumerosValidos() {
        System.out.println("revisionNumerosValidos");
        Sudoku instance = new Sudoku();
        boolean expResult = true;
        boolean result = instance.revisionNumerosValidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimeSudoku method, of class Sudoku.
     */
    @Test
    public void testImprimeSudoku() {
        System.out.println("imprimeSudoku");
        Sudoku instance = new Sudoku();
        instance.imprimeSudoku();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of regresaSudoku method, of class Sudoku.
     */
    @Test
    public void testRegresaSudoku() {
        System.out.println("regresaSudoku");
        Sudoku instance = new Sudoku();
        int[][] expResult = null;
        int[][] result = instance.regresaSudoku();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
