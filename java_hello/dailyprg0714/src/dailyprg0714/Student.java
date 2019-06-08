package dailyprg0714;

public class Student {
    private String name;

    public Student(String name) {
		super();
		this.name = name;
	}

	public void say(){
        System.out.println("Hello, I'm "+name+" !");
    }
}
