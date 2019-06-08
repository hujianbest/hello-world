package dailyPrg0712;

public class Person {

    private String name;
    private String age;
    
    public Person(){
        System.out.println("running Person no param Constructor...");
    }

	public Person(String name, String age) {
        System.out.println("running Person Constructor...");
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
    }

    public void speak(){
        System.out.println("Hi, my name is "+name+", I'm "+age+" years old.");
    }
}




