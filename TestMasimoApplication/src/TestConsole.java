import java.util.Scanner;


public class TestConsole {

	/**
	 * Runs the Matrix Calculation program via Console.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Program continues to run until user types exit.
		while (true)
		{
			System.out.println("Type path to input file, or type \"exit\" to quit");
			String path = scanner.nextLine();
			if (path.equalsIgnoreCase("exit"))
			{
				System.out.println("Program terminated.");
				System.exit(0);
			}
			System.out.println("Type c value.");
			String cValue = scanner.nextLine();
			if (cValue.equalsIgnoreCase("exit"))
			{
				System.out.println("Program terminated.");
				System.exit(0);
			}
			System.out.println("Type N value");
			String nValue = scanner.nextLine();
			if (nValue.equalsIgnoreCase("exit"))
			{
				System.out.println("Program terminated.");
				System.exit(0);
			}
			System.out.println(MatrixCalculator.CalculateMatrix(nValue, cValue, path));
		}
		
	}

}
