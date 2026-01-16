public class Institution {
    private String name;
    private String city;

    public Institution(String name, String city) {
          this.name = name;
          this.city = city;
      }

     public void display() {
         System.out.println("Institution: " + name + ", City: " + city);
     }
}