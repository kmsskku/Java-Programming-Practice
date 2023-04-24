package Java_2;

import java.util.ArrayList;
import java.util.Scanner;

public class MinseongKim_2020310698 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int a = scan.nextInt();
		int b = a;
		int c=a;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arro = new ArrayList<Integer>();
		ArrayList<Character> arrh = new ArrayList<Character>();

		while (a >= 1) {
			arr.add(0, a % 2);
			a /= 2;
		}

		System.out.print("b ");
		for (int j : arr)
			System.out.print(j);
		System.out.println();
//
//		if (arr.size() % 3 != 0) {
//			for (int i = 0; i < arr.size() % 3; i++) {
//				arr.add(0, 0);
//			}
//		}
//
//		int a0;
//		int a1;
//		int a2;
//		int res;
//		while (arr.size() > 1) {
//			a0 = arr.get(0);
//			a1 = arr.get(1);
//			a2 = arr.get(2);
//			res = (a0 * 4) + (a1 * 2) + (a2 * 1);
//			arro.add(res);
//			arr.remove(0);
//			arr.remove(0);
//			arr.remove(0);
//		}   2진법을 8진법으로 바꾸는 함수 왜 이렇게 짰는지 모르겠음 
		
		while(c>1)
		{
			arro.add(0,c%8);
			c/=8;
		}

		System.out.print("o ");
		for (int j : arro)
			System.out.print(j);
		System.out.println();

		while (b > 1) {
			int t;
			t = b % 16;
			b /= 16;
			if (t >= 10) {
				arrh.add(0, (char)(t + 87));
			} else
				arrh.add(0, (char)(t + 48));
		}
		System.out.print("h ");
		for (char j : arrh)
			System.out.print(j);
		
		scan.close();

	}
}
