package dummy;

public class DummyExamples {

	public static void main(String[] args) {

	//	simpleArr();

		complexArr();
	}

	
	public static void complexArr(){
		
		int fila = 3;
		int ind = 5;
		int matrix[][] = new int[fila][ind];
		
		//cada fila
		for (int f = 0; f < matrix.length; f++) {
			//System.out.println("Fila:" + f + " \n------------------------------------------------------");
			
			// cada columna
			for(int c = 0; c < ind; c++){
				matrix[f][c] += c;
				System.out.print("Columna:"+ c + " | ");
			}
			System.out.println(" \n-----------------------------------------------------------");
			
		}
		
//		for (int i = 0; i < 5; i++) {
//			System.out.println("I:"+i);
//			matrix[i][i] += i;
//			System.out.println("1er: "+matrix[i][i]);
//		}
		
		
	}
	
	
	
	private static void simpleArr() {
		int result = 0;
		int arr[] = new int[3];

		for (int i = 0; i < 5; i++) {
			System.out.println("I:"+i);
			if (i == 3) {
				result += 10;
			} else {
				result += i;
				System.out.println("res" + result);
			}
		
		}
		System.out.println(result);
	}

	/**
	 * int arr[] = new int[3];
	 * 
	 * for(int i=0; i < 3; i++){ arr[i] = i; System.out.println(arr[i]); }
	 * 
	 * int res = arr[0] + arr[2]; System.out.println(res); }
	 * 
	 */

}
