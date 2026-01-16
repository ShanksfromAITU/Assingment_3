public class Teacher extends Person {
    private String subject;
    private int experience;

    public Teacher(String name, String subject, int experience) {
        super(name);
        this.subject = subject;
        this.experience = experience;
    }

    @Override
    public void display() {
        System.out.println("Teacher: " + getName() + ", Subject: " + subject + ", Experience: " + experience + " years");
    }

    @Override
    public String toString() {
        return "Teacher{name='" + getName() + "', subject='" + subject + "'}";
    }
}
