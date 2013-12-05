import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class MatrixCalculatorTestProgram {

	private static final String PATH_1 = "TEST1.PRN";
	private static final String PATH_2 = "TEST2.PRN";
	private static final String PATH_3 = "TEST3.PRN";
	private static final String PATH_4 = "TEST4.PRN";
	private static final String PATH_5 = "TEST5.PRN";
	
	
	
	private static final String C_VALUE_1 = "4";
	private static final String C_VALUE_2 = "-6";
	private static final String C_VALUE_3 = "0";
	private static final String C_VALUE_4 = "6";
	private static final String C_VALUE_5 = "a";
	private static final String C_VALUE_6 = "299";
	
	private static final String N_VALUE_1 = "300";
	private static final String N_VALUE_2 = "10";
	private static final String N_VALUE_3 = "-10";	
	private static final String N_VALUE_4 = "0";
	private static final String N_VALUE_5 = "b";
	private static final String N_VALUE_6 = "310";
	
	private static final String EXPECTED_OUTPUT_1 = 
		"0.279525\t0.276682\t0.268098\t0.254212\t0.235722\t\n"	+
		"0.276682\t0.280218\t0.277855\t0.269717\t0.256231\t\n"	+
		"0.268098\t0.277855\t0.281864\t0.279912\t0.272113\t\n"	+
		"0.254212\t0.269717\t0.279912\t0.28427 \t0.282571\t\n"	+
		"0.235722\t0.256231\t0.272113\t0.282571\t0.287076\t\n";
	private static final String EXPECTED_OUTPUT_2 = "The value, c, is not an integer.";
	private static final String EXPECTED_OUTPUT_3 = "The value, n, is not an integer.";
	private static final String EXPECTED_OUTPUT_4 = "The value c is greater than or equal to n.";
	private static final String EXPECTED_OUTPUT_5 = "A value in the list is not a number.";
	private static final String EXPECTED_OUTPUT_6 = "The value, n, is greater than the list of numbers.";
	private static final String EXPECTED_OUTPUT_7 = "0"; //This one can't happen.
	private static final String EXPECTED_OUTPUT_8 = "The values c or n are not integers.";
	private static final String EXPECTED_OUTPUT_9 = "The file does not exist.";
	private static final String EXPECTED_OUTPUT_10 = "The file contains an error.";
	

	// Correct file tests. This will check to see if the numbers are correct.
	@Test
	public void testToSeeIfOutputIsTheSameAsExample()
	{
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_1, C_VALUE_1, PATH_1), EXPECTED_OUTPUT_1);
	}
	
	// This will check to see number errors in CValue if it is not an integer.
	@Test
	public void testToSeeIfOutputPrintsCValueNotInt()
	{
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_1, C_VALUE_5, PATH_1), EXPECTED_OUTPUT_8);
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_1, C_VALUE_2, PATH_1), EXPECTED_OUTPUT_2);
	}
	
	// This will check to see number errors in NValue if it is not an integer.
	@Test
	public void testToSeeIfOutputPrintsNValueNotInt()
	{
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_3, C_VALUE_1, PATH_1), EXPECTED_OUTPUT_3);
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_5, C_VALUE_1, PATH_1), EXPECTED_OUTPUT_8);
	}
	
	// This will check to see if errors will exist if c is greater than n.
	@Test
	public void testToSeeIfOutputPrintsCIsGreaterThanN()
	{
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_2, C_VALUE_6, PATH_1), EXPECTED_OUTPUT_4);
	}
	
	// This will check to see if errors will exist if n is greater than file value.
	@Test
	public void testToSeeIfOutputPrintsNIsGreaterThanList()
	{
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_6, C_VALUE_1, PATH_1), EXPECTED_OUTPUT_6);
	}
	
	// This will check to see if the value in the list isn't a number.
	@Test
	public void testToSeeIfOutputPrintsListIsNotNumber()
	{
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_1, C_VALUE_1, PATH_3), EXPECTED_OUTPUT_5);
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_1, C_VALUE_1, PATH_4), EXPECTED_OUTPUT_5);
	}
	
	// This will check to see if the file is empty.
	@Test
	public void testToSeeIfOutputPrintsFileIsEmpty()
	{
		assertEquals(MatrixCalculator.CalculateMatrix(N_VALUE_1, C_VALUE_1, PATH_5), EXPECTED_OUTPUT_9);
	}
}
