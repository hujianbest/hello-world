import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		List<Integer> data = new LinkedList<>();
		for(int i=0;i<n;i++){
			data.add(in.nextInt());
		}

		List<Integer> result = new LinkedList<>();
		result.add(data.get(0));
		for(int i=1;i<data.size();i++){
			if(data.get(i)>result.peekLast​()){
				
			}
		}
		

	}

}
