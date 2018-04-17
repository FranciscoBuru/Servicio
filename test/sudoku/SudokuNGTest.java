/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author edi
 */
public class SudokuNGTest {
    
    public SudokuNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
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
        assertEquals(result, expResult);
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
        boolean expResult = false;
        boolean result = instance.resuelve();
        assertEquals(result, expResult);
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
        boolean expResult = false;
        boolean result = instance.revisionInicial();
        assertEquals(result, expResult);
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
        boolean expResult = false;
        boolean result = instance.revisionNumerosValidos();
        assertEquals(result, expResult);
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
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
