public class Student extends Person {
    private int age;
    private double gpa;

    public Student(String name, int age, double gpa) {
        super(name);
        this.age = age;
        this.gpa = gpa;
    }
    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public void display() {
        System.out.println("Student: " + getName() + ", Age: " + age + ", GPA: " + gpa);
    }

    @Override
    public String toString() {
        return "Student{name='" + getName() + "', gpa=" + gpa + "}";
    }
}