
/*
 * Activity 4.9.7
 */ 
public class StudentRunner
{ 
  public static void main(String args[]) 
  { 
    Student s = new Student("chiken", 1, "Assdf"); 
    Student t = new Student("asdf", 3, "nuget");
    Student r = new Student("wseser Name", 1, "poopoo");

    // Below two statements are equivalent 
    System.out.println(s.equals(t)); 
    System.out.println(s.equals(r)); 
  } 
}