import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;


public class MatrixCalculator {

	public static final double ROUNDING_POSITION = 1000000;
	public static final int DECIMAL_LENGTH = 8;
	/**
	 * Prints to label a resulting matrix using the values in c, n, and listOfValues.
	 * @param nValue
	 * @param label
	 * @param cValue
	 * @param listOfValues
	 */
	public static String CalculateMatrix(String nValue, String cValue, String listOfValues)
	{
		FileReader reader = null;
		Scanner scanner = null;
		try
		{
			// BigInteger is used for extremely large numbers.
			BigInteger n = new BigInteger(nValue);
			BigInteger c = new BigInteger(cValue);
			// Must check to see if c value is an integer.
			if (c.compareTo(BigInteger.ZERO) < 0)
			{
				return "The value, c, is not an integer.";
			}
			
			// Must check to see if n value is an integer.
			if (n.compareTo(BigInteger.ZERO) < 0)
			{
				return "The value, n, is not an integer.";
			}
			
			// Must check to see if c is greater than or equal to n.
			if (c.compareTo(n) >= 0)
			{
				return "The value c is greater than or equal to n.";
			}
			
			// Reads the data in the file. Add to list to calculate.
			reader = new FileReader(new File(listOfValues));
			scanner = new Scanner(reader);
			ArrayList<Double> values = new ArrayList<Double>();
			while(scanner.hasNextLine())
			{
				// Must check to see if a double value exist as well.
				try
				{
					values.add(Double.parseDouble(scanner.nextLine()));
				}
				catch (NumberFormatException e)
				{
					return "A value in the list is not a number.";
				}	
			}
			
			// If N is greater than values, return an error.
			if (n.compareTo(new BigInteger(Integer.toString(values.size()))) > 0)
			{
				return "The value, n, is greater than the list of numbers.";
			}
			
			// If values doesn't exist, return 0.
			if (values.isEmpty())
			{
				return "0";
			}
			else
			{
				// Calculate the matrix and create a formated string.
				String row = "";
				for (int i = 0; new BigInteger(Integer.toString(i)).compareTo(c) <=  0; i++)
				{
					String column = "";
					for (int j = 0; new BigInteger(Integer.toString(j)).compareTo(c) <=  0; j++)
					{
						double sum = 0;
						for (BigInteger k = c; k.compareTo(n.subtract(BigInteger.ONE)) <= 0; k = k.add(BigInteger.ONE))
						{
							sum = sum + values.get(k.subtract(new BigInteger(Integer.toString(j))).intValue()) * values.get(k.subtract(new BigInteger(Integer.toString(i))).intValue());
						}
						String number = Double.toString((Math.round(sum * MatrixCalculator.ROUNDING_POSITION) / MatrixCalculator.ROUNDING_POSITION));
						if (number.length() < MatrixCalculator.DECIMAL_LENGTH)
						{
							for (int l = number.length(); l < MatrixCalculator.DECIMAL_LENGTH; l++)
							{
								number = number.concat(" ");
							}
						}
						column = column.concat(number + "\t");
					}
					row = row.concat(column + "\n");
				}
				return row;
			}
			
		}
		// An extra check to see if c value is an integer.
		catch (NumberFormatException e)
		{
			return "The values c or n are not integers.";
		}
		// Must check to see if file exists.
		catch (FileNotFoundException e)
		{
			return "The file does not exist.";
		}
		finally
		{
			try
			{
				if (scanner != null)
				{
					scanner.close();
				}
				
				if (reader != null)
				{
					reader.close();
				}
			}
			catch (IOException e)
			{
				return "The file contains an error.";
			}
		}
		
	}

}
