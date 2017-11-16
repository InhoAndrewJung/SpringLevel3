package 셀프넘버;

import java.util.ArrayList;
import java.util.List;

/*
 * arr
 * [0] r
 * [1] r
 * [2] r
 * [3] .. 
 * ...
 * [100000]
 */


public class selfnumber {

	public static void main(String[] args) {

		int[] num = new int[10000];
		int[] selfNum = new int[10000];
		int[] finalCut = new int[10000];
		for(int i=0;i<10000;i++) {
			selfNum[i]=d(i+1);
			num[i]= i+1;
			for(int j=0; j<selfNum.length; j++) {
				if(num[i] != selfNum[i]) {
					finalCut[i] = num[i];
					System.out.println(finalCt[i]);
				}
			}
		}

		
		
	}
	
	public static int d(int num) {
		int rnum, rlt=0;
		String tmp1, tmp2, tmp3, tmp4;
		String inum = num+"";
		if(inum.length()<2) {
			rnum = Integer.parseInt(inum);
			rlt= rnum + rnum;			
		}else if(inum.length()<3) {
			tmp1 = inum.substring(0, 1);
			tmp2 = inum.substring(1, 2);
			rlt = Integer.parseInt(inum)+Integer.parseInt(tmp1)+Integer.parseInt(tmp2);
			
		}else if(inum.length()<4) {
			tmp1 = inum.substring(0, 1);
			tmp2 = inum.substring(1, 2);
			tmp3 = inum.substring(2, 3);
			rlt = Integer.parseInt(inum)+Integer.parseInt(tmp1)+Integer.parseInt(tmp2)+Integer.parseInt(tmp3);
		}else if(inum.length()<5) {
			tmp1 = inum.substring(0, 1);
			tmp2 = inum.substring(1, 2);
			tmp3 = inum.substring(2, 3);
			tmp4 = inum.substring(3, 4);
			rlt = Integer.parseInt(inum)+Integer.parseInt(tmp1)+Integer.parseInt(tmp2)+Integer.parseInt(tmp3)+Integer.parseInt(tmp4);
		}
		return rlt;
	}

}
