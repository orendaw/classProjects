package assign5;

/**
 * This class contains a method for matrix (2D array) and vector (1D array) multiplication.
 * @author Orenda Williams
 *
 */
public class ArrayLibraryExtra {
	
	public static void main(String[] args){
		
	}
	
	/**
	 * This method takes in a 2D int array and an int vector and performs vector*matrix multiplication to 
	 * return a new vector.
	 * 
	 * The number of columns in the matrix must be the same as the length of the vector.
	 * 
	 * @param matrix
	 * @param vector
	 * @return
	 */
	public  static int[] matrixVectorMultiply(int[][] matrix, int[] vector){
		
		if (vector.length != matrix[0].length){
			throw new RuntimeException("The number of columns in the matrix must be the same as the length of the vector.");
		}
			
		int[] result = new int[matrix.length];
		
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				result[i] += matrix[i][j] * vector[j];
			}
		}
		
		return result;
		
	}

}
