package assign2;

/**
 * This class contains the following methods: - convertGallonsToCups(int) -
 * convertFahrenheitToCelsius(int) - convertLengthToInches(int, int, int) -
 * describeSign(int) - isAMultiple(int, int) - isGameOver(int, int, int) -
 * quadraticFormula(int, int, int)
 * 
 * date: 1/28/2016
 * 
 * @author Orenda Williams
 *
 */
public class MethodLibrary {

	/**
	 * Calculates the number of cups that has the equivalent volume for the
	 * given number of gallons.
	 * 
	 * @param gallons
	 *            - the number of gallons to convert
	 * @return the number of cups converted
	 */
	public static int convertGallonsToCups(int gallons) {
		// using a conversion rate of 16 cups / gallon

		return gallons * 16;
	}

	/**
	 * This method calculates the temperature in Celcius when given the
	 * temperature in Fahrenheit
	 * 
	 * @param tempFahrenheit
	 *            - degrees in Fahrenheit
	 * @return returns degrees in Celcius as a double
	 */
	public static double convertFahrenheitToCelsius(int tempFahrenheit) {
		// using conversion formula Tc = (Tf - 32)* (5/9)
		return (tempFahrenheit - 32) * (5. / 9.);
	}

	/**
	 * This methods takes in a total length consisting of miles, yards, feet,
	 * and inches and converts it all to inches.
	 * 
	 * @param miles
	 *            - miles to be converted
	 * @param yards
	 *            - yards to be converted
	 * @param feet
	 *            - feet to be converted
	 * @param inches
	 *            - inches to be converted
	 * @return returns the total length after it has been converted to inches.
	 */
	public static int convertLengthToInches(int miles, int yards, int feet, int inches) {
		yards = yards + miles * 1760;
		feet = feet + yards * 3;
		return inches + feet * 12;
	}

	/**
	 * This is a method that returns true if number1 is a multiple of number2
	 * and false otherwise.
	 * 
	 * @param number1
	 *            - number to be divided
	 * @param number2
	 *            - number to divide by
	 * @return - boolean that will be true if number1 is divisible by number2
	 *         with no remainders.
	 */
	public static boolean isAMultiple(int number1, int number2) {

		boolean result = (number1 % number2 == 0);
		return result;
	}

	/**
	 * This method takes in 3 parameters related to possible game scenarios. The
	 * method should return true if the game is over and false otherwise,
	 * according to the following game rules. The game continues only when the
	 * player has at least one life remaining and one of these conditions is
	 * met: --The player is on level 1 and his/her score at least 1000. --The
	 * player is on level 2 and his/her score at least 2000. --The player is on
	 * any level and his/her score at least 3000.
	 * 
	 * @param score
	 * @param lives
	 * @param level
	 * @return
	 */
	public static boolean isGameOver(int score, int lives, int level) {
		boolean result = (lives == 0 || (level == 1 && score < 1000) || (level == 2 && score < 2000)
				|| (level >= 3 && score < 3000));
		return result;
	}

	/**
	 * This methods takes in an integer value (number) and returns a string
	 * describing the sign of the number (postive/negative/zero).
	 * 
	 * @param number
	 *            to be examined for sign.
	 * @return possible return values : "positive", "negative", "zero"
	 */
	public static String describeSign(int number) {
		if (number > 0)
			return "positive";
		else if (number < 0)
			return "negative";
		else
			return "zero";
	}

	/**
	 * This method takes in coefficients for the quadratic formula a*x^2 + b*x +
	 * c = 0 and calculates the two values of x.
	 * 
	 * @param a
	 *            - the x^2 coefficient
	 * @param b
	 *            - the x coefficient
	 * @param c
	 *            - the constant
	 * @return a string that contains the two values of x.
	 */

	public static String quadraticFormula(int a, int b, int c) {
		double firstRoot = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		double secondRoot = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		return "The first root is " + firstRoot + ". The second root is " + secondRoot + ".";
	}

	public static void main(String[] args) {

		// Uncomment each of the method calls below as you finish their method
		// definitions.

		System.out.println(convertGallonsToCups(1));
		// should be 16

		System.out.println(convertFahrenheitToCelsius(40));
		// should be 4.4444444...

		System.out.println(convertLengthToInches(2, 13, 6, 2));
		// should be 127262

		System.out.println(isAMultiple(9, 5));
		// should be false

		System.out.println(isGameOver(1500, 1, 2));
		// should be true

		System.out.println(describeSign(7));
		// should be positive

		System.out.println(quadraticFormula(1, 3, -4));
		// should be The first root is -4.0. The second root is 1.0.

		// Add more code to test your methods here -- at least three additional
		// tests per method, covering a variety of possible scenarios.

		System.out.println(convertGallonsToCups(2));
		// 32
		System.out.println(convertGallonsToCups(4));
		// 64
		System.out.println(convertGallonsToCups(8));
		// 128

		System.out.println(convertFahrenheitToCelsius(37));
		// 2. 7777777...
		System.out.println(convertFahrenheitToCelsius(55));
		// 12.777....
		System.out.println(convertFahrenheitToCelsius(-5));
		// -20.555

		System.out.println(convertLengthToInches(0, 0, 0, 2));
		// 2
		System.out.println(convertLengthToInches(0, 0, 6, 0));
		// 72
		System.out.println(convertLengthToInches(1, 1, 1, 1));
		// 63409

		System.out.println(isAMultiple(9, 3));
		// true
		System.out.println(isAMultiple(-45, 5));
		// true
		System.out.println(isAMultiple(-45, 2));
		// false

		System.out.println(isGameOver(2500, 1, 2));
		// false
		System.out.println(isGameOver(2500, 0, 2));
		// true
		System.out.println(isGameOver(5000, 1, 4));
		// false

		System.out.println(describeSign(90));
		// postive
		System.out.println(describeSign(0));
		// zero
		System.out.println(describeSign(-7));
		// negative

		System.out.println(quadraticFormula(5, -2, 5));
		// roots are imaginary
		System.out.println(quadraticFormula(2, 6, 1));
		// -.17712.... & -2.8228....
		System.out.println(quadraticFormula(3, -10, 1));
		// 2.2301... & .10319...
	}
}