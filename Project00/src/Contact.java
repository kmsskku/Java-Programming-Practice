
import java.util.*;

public class Contact {

	static HashMap<String, String> list = new HashMap<String, String>();

	public static void add(String name, String num) {
		List<String> arr = new ArrayList<>(list.keySet());
		int flag = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(name)) {
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			list.put(name, num);
		else
			System.out.println("error");
	}

	public static void delete(String name) {
		ArrayList<String> arr = new ArrayList<>(list.keySet());
		int flag = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).equals(name)) {
				flag = 1;
				break;
			}
		}
		if (flag == 1)
			list.remove(name);
		else
			System.out.println("error");
	}

	public static void show() {
		ArrayList<String> arr = new ArrayList<>(list.keySet());
		Collections.sort(arr);
		for (String str : arr) {
			System.out.println(str + " " + list.get(str));
		}
	}

	public static void find(String name) {
		System.out.println(list.get(name));
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (true) {
			String str;
			str = scan.nextLine();
			String[] res = new String[str.split(" ").length];

			for (int i = 0; i < str.split(" ").length; i++) {
				res[i] = str.split(" ")[i];
			}
			switch (res[0]) {
			case "add":
				add(res[1], res[2]);
				break;
			case "delete":
				delete(res[1]);
				break;
			case "show":
				show();
				break;
			case "find":
				find(res[1]);
				break;
			}
		}
	}
}
