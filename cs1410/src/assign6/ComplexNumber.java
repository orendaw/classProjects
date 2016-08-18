package assign6;

/**
 * This class is developed to represent Complex Numbers (imaginary numbers). 
 * @author Orenda Williams
 *
 */
public class ComplexNumber {
	
	private double a;  
	private double b;  
	
	/**
	 * This will create an object representing a ComplexNumber a + bi.
	 * 
	 * @param _a
	 * @param _b
	 */
	public ComplexNumber(double _a, double _b) {
		a = _a;
		b = _b;
	}
	
	/**
	 * This will create an object representing a ComplexNumber a + bi, but 
	 * b will be defaulted to equal zero.
	 * 
	 * @param _a
	 */
	public ComplexNumber(double _a){
		a = _a;
		b = 0;
	}

	/**
	 * Returns the real value portion (a) of the imaginary number (a + bi)
	 */
	public double getRealPart() {
		return a;
	}
	
	/**
	 * Returns the imaginary value portion (b) of the imaginary number (a + bi).
	 */
	public double getImaginaryPart() {
		return b;
	}
	
	/**
	 * This method returns a boolean describing if the imaginary number is only a 
	 * real number (i.e, b = 0 for a + bi)
	 * @return boolean
	 */
	public boolean isARealNumber() {
		return b == 0;
	}
	
	/**
	 * This method returns a boolean describing if the imaginary number is only
	 * an imaginary number (i.e, a = 0 for a + bi)
	 * @return boolean
	 */
	public boolean isAnImaginaryNumber(){
		return a == 0;
	}

	/**
	 * This method returns a new ComplexNumber object that is the conjugate of
	 * this ComplexNumber (this = a + bi, conjugate = a - bi)
	 * @return ComplexNumber that is the conjugate
	 */
	public ComplexNumber conjugate() {
		
		ComplexNumber result = new ComplexNumber(a, -b);
		
		return result;
	}
	
	/**
	 * This method adds a ComplexNumber to this ComplexNumber.
	 * (a + bi) + (c + di) = (a + c) + (b + d)i
	 * @param other - another ComplexNumber to add to this one
	 * @return a new ComplexNumber that is the result of adding the two
	 */
	public ComplexNumber add(ComplexNumber other) {
		
		ComplexNumber result = new ComplexNumber(a + other.getRealPart(), b + other.getImaginaryPart());
		
		return result;
	}
	
	/**
	 * This method subtracts the other ComplexNumber from this ComplexNumber.
	 * (a + bi) - (c + di) = (a - c) + (b - d)i
	 * @param other - the ComplexNumber to subtract
	 * @return the difference of the two ComplexNumbers
	 */
	
	public ComplexNumber subtract(ComplexNumber other){
		
		ComplexNumber result = new ComplexNumber(a - other.getRealPart(), b - other.getImaginaryPart());
		
		return result;
	}
	/**
	 * This method multiplies two ComplexNumbers together and returns the product.
	 * 
	 * (a + bi) * (c + di) = (a*c - b*d) + (b*c - a*d)i
	 * 
	 * @param other - ComplexNumber to multiply by
	 * @return product of the two ComplexNumber objects
	 */
	
	public ComplexNumber multiply(ComplexNumber other){
		
		ComplexNumber result = new ComplexNumber((a*other.getRealPart() - b*other.getImaginaryPart()), (b*other.getRealPart() - a*other.getImaginaryPart()));
		
		return result;
	}

	/**
	 * This method divides this ComplexNumber by the other ComplexNumber. 
	 * 
	 * The other ComplexNumber cannot be only 0.
	 * 
	 * (a + bi) / (c + di) = (( a*c + b*d ) / ( c^2 + d^2 )) + (( b*c - a*d ) / ( c^2 + d^2 ))i
	 * @param other - the denominator
	 * @return the quotient of this ComplexNumber divided by the other
	 */
	
	public ComplexNumber divide(ComplexNumber other){
		if (other.getRealPart() == 0 && other.getImaginaryPart() == 0){
			throw new RuntimeException("The real and imaginary part of the other ComplexNumber cannot both be zero.");
		}
		
		double denominator = (other.getRealPart()*other.getRealPart() + other.getImaginaryPart()*other.getImaginaryPart());
		ComplexNumber result = new ComplexNumber((a*other.getRealPart() + b*other.getImaginaryPart())/denominator, 
				(b*other.getRealPart() - a*other.getImaginaryPart())/denominator);
		
		return result;
	}
	
	/**
	 * toString method that returns this ComplexNumber as a legible String in
	 * the format of "a + bi" or "a - bi" with a and b representing 
	 * doubles.
	 */
	public String toString() {
		
		if (b < 0){
			return a + " - " + -b + "i";
		}
		
		return a + " + " + b + "i";
	}

	/**
	 * This method compares this ComplexNumber to another object and will return true
	 * if and only if the other object is a ComplexNumber with the same a and
	 * b values.
	 * 
	 * @return boolean describing if this ComplexNumber is equal to the other object.
	 */
	public boolean equals(Object other) {
		if(!(other instanceof ComplexNumber)) {
			return false;
		}
		
		ComplexNumber rhs = (ComplexNumber)other;
		

		return a == rhs.getRealPart() && b == rhs.getImaginaryPart();
	}
}
