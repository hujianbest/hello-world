package dailyPrg0712;

public class Student extends Person{

    private String school;

	public Student(String name, String age, String school) {
        super(name, age);
        System.out.println("running Person Constructor...");
		this.school = school;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
    }
    
    @Override
    public void speak(){
        super.speak();
        System.out.println("Hi, my name is "+super.getName()+
            ", I'm "+super.getAge()+" years old, I study in "+school+".");
    }
}

