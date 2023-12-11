package helper;

import java.util.*;
import java.util.regex.*;

public class Valid {
	public static String checkNumRegex(String Regex, String Message) {
		try (var sc = new Scanner(System.in)) {
			System.out.println(Message);
			while(true) {
				String str = sc.nextLine();
				Pattern pt = Pattern.compile(Regex);
				Matcher mc = pt.matcher(str);
				if(mc.matches()) {
					return str;
				} else {
					System.out.println("Error: You have to enter number");
				}
			}
		}
	}
}