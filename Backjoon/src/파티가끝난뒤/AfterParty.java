package 파티가끝난뒤;

import java.util.*;

public class AfterParty {

	public static void main(String[] args) {
		int f1, f2;
		int[] input = new int[5];
		int expt=0;
		Scanner sc = new Scanner(System.in);
		f1 = sc.nextInt();
		f2 = sc.nextInt();
		expt= f1*f2;
		for(int i = 0; i< input.length; i++) {
			//input[i]= sc.nextInt()-expt;
			System.out.print(sc.nextInt()-expt + " ");
		}
		

	}

}
