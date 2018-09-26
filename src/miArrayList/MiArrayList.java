package miArrayList;

import java.util.ArrayList;

public class MiArrayList {
	
	public static void main(String[] args){
		
		ArrayList<String> miArray = new ArrayList<String>();
		
		int size = miArray.size();
		
		System.out.println(size);
		
		for(int i = 0; i <= size; i++){
			miArray.add("num. " + i);
			
			System.out.println(miArray.get(i));
		}
		
	}
	

}
