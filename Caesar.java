import java.util.*; 
public class Caesar {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		String s1 = sc.next().toUpperCase();
		char b = s1.charAt(0);
		int cint= b+(k%26);
		while (cint>90) {
			cint = cint-26;
		
		}
		while (cint<65) {
			cint = cint + 26;
		}
		char c = (char) cint;
				
		sc.close();
		System.out.println(c);
		
	}
}

