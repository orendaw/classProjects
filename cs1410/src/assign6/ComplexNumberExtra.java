package assign6;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * This class is developed to represent Complex Numbers (imaginary numbers) and has a more
 * thorough toString method than the ComplexNumber class.
 * @author Orenda Williams
 *
 */

public class ComplexNumberExtra {

		
		private double a;  
		private double b;  
		
		/**
		 * This will create an object representing a ComplexNumberExtra a + bi.
		 * 
		 * @param _a
		 * @param _b
		 */
		public ComplexNumberExtra(double _a, double _b) {
			a = _a;
			b = _b;
		}
		
		/**
		 * This will create an object representing a ComplexNumberExtra a + bi, but 
		 * b will be defaulted to equal zero.
		 * 
		 * @param _a
		 */
		public ComplexNumberExtra(double _a){
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
		 * This method returns a new ComplexNumberExtra object that is the conjugate of
		 * this ComplexNumberExtra (this = a + bi, conjugate = a - bi)
		 * @return ComplexNumberExtra that is the conjugate
		 */
		public ComplexNumberExtra conjugate() {
			
			ComplexNumberExtra result = new ComplexNumberExtra(a, -b);
			
			return result;
		}
		
		/**
		 * This method adds a ComplexNumberExtra to this ComplexNumberExtra.
		 * (a + bi) + (c + di) = (a + c) + (b + d)i
		 * @param other - another ComplexNumberExtra to add to this one
		 * @return a new ComplexNumberExtra that is the result of adding the two
		 */
		public ComplexNumberExtra add(ComplexNumberExtra other) {
			
			ComplexNumberExtra result = new ComplexNumberExtra(a + other.getRealPart(), b + other.getImaginaryPart());
			
			return result;
		}
		
		/**
		 * This method subtracts the other ComplexNumberExtra from this ComplexNumberExtra.
		 * (a + bi) - (c + di) = (a - c) + (b - d)i
		 * @param other - the ComplexNumberExtra to subtract
		 * @return the difference of the two ComplexNumberExtra
		 */
		
		public ComplexNumberExtra subtract(ComplexNumberExtra other){
			
			ComplexNumberExtra result = new ComplexNumberExtra(a - other.getRealPart(), b - other.getImaginaryPart());
			
			return result;
		}
		/**
		 * This method multiplies two ComplexNumberExtra together and returns the product.
		 * 
		 * (a + bi) * (c + di) = (a*c - b*d) + (b*c - a*d)i
		 * 
		 * @param other - ComplexNumberExtra to multiply by
		 * @return product of the two ComplexNumberExtra objects
		 */
		
		public ComplexNumberExtra multiply(ComplexNumberExtra other){
			
			ComplexNumberExtra result = new ComplexNumberExtra((a*other.getRealPart() - b*other.getImaginaryPart()), (b*other.getRealPart() - a*other.getImaginaryPart()));
			
			return result;
		}

		/**
		 * This method divides this ComplexNumberExtra by the other ComplexNumberExtra. 
		 * 
		 * The other ComplexNumberExtra cannot be only 0.
		 * 
		 * (a + bi) / (c + di) = (( a*c + b*d ) / ( c^2 + d^2 )) + (( b*c - a*d ) / ( c^2 + d^2 ))i
		 * @param other - the denominator
		 * @return the quotient of this ComplexNumberExtra divided by the other
		 */
		
		public ComplexNumberExtra divide(ComplexNumberExtra other){
			if (other.getRealPart() == 0 && other.getImaginaryPart() == 0){
				throw new RuntimeException("The real and imaginary part of the other ComplexNumberExtra cannot both be zero.");
			}
			
			double denominator = (other.getRealPart()*other.getRealPart() + other.getImaginaryPart()*other.getImaginaryPart());
			ComplexNumberExtra result = new ComplexNumberExtra((a*other.getRealPart() + b*other.getImaginaryPart())/denominator, 
					(b*other.getRealPart() - a*other.getImaginaryPart())/denominator);
			
			return result;
		}
		
		/**
		 * toString method that returns this ComplexNumberExtra as a legible String in
		 * the format of "a + bi" or "a - bi" with a and b representing 
		 * doubles.
		 */
		public String toString() {
			
			DecimalFormat df = new DecimalFormat("#.####");
			df.setRoundingMode(RoundingMode.UP);
			
			// if a and b are whole numbers
			
			if (a % 1 == 0 && b % 1 == 0){
				
				if (this.isARealNumber()){
					return "" + (int)a;
				}
				
				if (this.isAnImaginaryNumber()){
					if (b == 1){
						return "+i";
					}
					
					if (b == -1){
						return "-i";
					}
					return (int)b + "i";
				}
				
				if (b == 1){
					return (int)a + " + i";
				}
				
				if (b == -1){
					return (int)a + " - i";
				}
				if (b < 0){
					 return (int)a + " - " + (int)-b + "i";
				}
				
				return (int)a + " + " + (int)b + "i";
			}

			// if only a is a whole number
			
			if (a % 1 == 0){
				
				if (this.isARealNumber()){
					return "" + (int)a;
				}
				
				if (this.isAnImaginaryNumber()){
					if (b == 1){
						return "+i";
					}
					
					if (b == -1){
						return "-i";
					}
					return df.format(b) + "i";
				}
				
				if (b == 1){
					return (int)a + " + i";
				}
				
				if (b == -1){
					return (int)a + " - i";
				}
				if (b < 0){
					 return (int)a + " - " + df.format(-b) + "i";
				}
				
				return (int)a + " + " + df.format(b) + "i";
			}
			
			// if only b is a whole number
			if (b % 1 == 0){
				
				if (this.isARealNumber()){
					return "" + df.format(a);
				}
				
				if (this.isAnImaginaryNumber()){
					if (b == 1){
						return "+i";
					}
					
					if (b == -1){
						return "-i";
					}
					return (int)b + "i";
				}
				
				if (b == 1){
					return df.format(a) + " + i";
				}
				
				if (b == -1){
					return df.format(a) + " - i";
				}
				if (b < 0){
					 return df.format(a) + " - " + (int)-b + "i";
				}
				
				return df.format(a) + " + " + (int)b + "i";
			}
			
			// rest of cases
			
			if (this.isARealNumber()){
				return "" + df.format(a);
			}
			
			if (this.isAnImaginaryNumber()){
				if (b == 1){
					return "i";
				}
				
				if (b == -1){
					return "-i";
				}
				return df.format(b) + "i";
			}
			
			if (b == 1){
				return df.format(a) + " + i";
			}
			
			if (b == -1){
				return df.format(a) + " - i";
			}
			
			if (b < 0){
				return df.format(a) + " - " + df.format(-b) + "i";
			}
			
			return df.format(a) + " + " + df.format(b) + "i";
		}

		/**
		 * This method compares this ComplexNumberExtra to another object and will return true
		 * if and only if the other object is a ComplexNumberExtra with the same a and
		 * b values.
		 * 
		 * @return boolean describing if this ComplexNumberExtra is equal to the other object.
		 */
		public boolean equals(Object other) {
			if(!(other instanceof ComplexNumberExtra)) {
				return false;
			}
			
			ComplexNumberExtra rhs = (ComplexNumberExtra)other;
			

			return a == rhs.getRealPart() && b == rhs.getImaginaryPart();
		}

}
