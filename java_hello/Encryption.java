import java.util.Scanner;

public class Encryption{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input a string you need to encrypt or decrypt");
		String password = scan.nextLine();
		scan.close();
		char[] array = password.toCharArray();
		for(int i=0;i<array.length;i++){
			array[i]=(char)(array[i]^20000);
		}
		System.out.println("the result would be:");
		System.err.println(new String(array));
	}
}