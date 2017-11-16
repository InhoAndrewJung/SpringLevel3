package no3460;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int no;
		
		int tmp;
		Scanner sc = new Scanner(System.in);
		
		no = sc.nextInt();
		List<Integer> input = new ArrayList<Integer>();
		List<Integer> input2 = null;
		int[] rlt = null;
		
		for(int i =0; i<no;i++) {
			input.add(sc.nextInt());
		}
		
		for(int i=0; i<no; i++) {
			tmp = input.get(i);
			input2 = toBinary(tmp);
			if( i == no -1)	rlt = new int[input2.size()];	
			
			for(int k=0; k<input2.size();k++) {
				//System.err.print(input2.get(i));
				rlt[k] = input2.get(k);
				
				if(rlt[k] == 1)
					System.out.print(k+" ");			
			}
			
			
		}
		

			
		
		
	}
	
	public static List toBinary(int n) {
		List<Integer> array = new ArrayList<Integer>();
		
		while(n > 1) {
			array.add( n%2);
			n = n/2;
		}
		if( n%2 != 0)
		array.add(1);
		return array;
	}

}
