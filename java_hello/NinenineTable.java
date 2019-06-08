public class NinenineTable{
	public static void print(){
		for(int i=1;i<10;i++){
			for(int j=1;j<=i;j++){
				System.out.print(i+"x"+j+"="+(i*j)+",");
			}
			System.out.print("\n");
		}
	}
	public static void main(String args[]){
		print();
	}
}
