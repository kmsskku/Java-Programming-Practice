package HelloWorld;


public class ImplementSimpleCalculator {}
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		String[] res;
//		try {
//			String str = scan.next();
//			if (str.contains("+"))
//				res = str.split("\\+");
//			else
//				res = str.split("-");
//
//			int a = Integer.parseInt(res[0]);
//			int b = Integer.parseInt(res[1]);
//
//			if ((a == 0 || b == 0) && str.contains("+")) {
//				throw new AddZeroException();
//			} else if ((a == 0 || b == 0) && str.contains("-")) {
//				throw new SubtractZeroException();
//			}
//			int rres;
//			if(str.contains("+"))
//				rres = a+b;
//			else
//				rres = a-b;
//
//			if (a > 1000 || a < 0 || b > 1000 || b < 0||rres>1000) {
//				throw new OutOfRangeException();
//			}
//			
//			System.out.println(rres);
//
//
//		} catch (AddZeroException e1) {
//			System.out.println("AddZeroException");
//		} catch (SubtractZeroException e2) {
//			System.out.println("SubtractZeroException");
//		} catch (OutOfRangeException e3) {
//			System.out.println("utOfRangeException");
//		}
//	}
//}
//
//class OutOfRangeException extends Exception {}
//
//class AddZeroException extends Exception {}
//
//class SubtractZeroException extends Exception {}
