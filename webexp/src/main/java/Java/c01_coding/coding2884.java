package Java.c01_coding;

import java.util.Scanner;

public class coding2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		int hourVal = 0, minVal = 0;
		
		System.out.println("시간");
		int hour = sc.nextInt();
		
		System.out.println("분");
		int min = sc.nextInt();
		
		// 입력값 확인
		if(23 >= hour && hour >= 0 && 59 >= min && min >= 0) {
			if(min >= 45) {
				minVal = min - 45;
				hourVal = hour;
			} else {
				minVal = (min+60) - 45;
				
				if(hour == 0) {
					hourVal = 23;
				} else {
					hourVal = hour - 1;
				}
			}
			
			System.out.println(hourVal);
			System.out.println(minVal);
		}
	}

}
