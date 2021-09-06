package Java.c01_coding;

import java.util.Scanner;

public class coding10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("데이터의 수를 입력하세요");
		int inNum = sc.nextInt();
		
		System.out.println("기준이 되는 x값을 입력하세요");
		int xnum = sc.nextInt();
			
		int inDatas[] = new int[inNum];
		
		if(inNum >= 1 && 10000 >= xnum) {
			System.out.println("데이터 " + inNum + "개의 수를 입력하세요");
			for(int cnt=0; cnt<inNum; cnt++) {
				inDatas[cnt] = sc.nextInt();
				
			}
			
			for(int cnt=0; cnt<inNum; cnt++) {
				if(inDatas[cnt] < xnum) {
					System.out.print(inDatas[cnt] + " ");
				}
			}
		}
	}
}




