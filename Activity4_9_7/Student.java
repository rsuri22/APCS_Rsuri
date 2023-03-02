/*
 * Activity 4.9.7
 */ 
public class Student 
{ 
  private String name = "";
  private int id;  
  private String schoolYear;

  // Constructor 
  Student(String inputName, int inputId, String inputYear) 
  { 
    name = inputName;
    id = inputId;
    schoolYear = inputYear;
  } 

  public String toString(){
    return "Information regarding student" + name + ":\n\tID: " + id + "\n\tSchool Year: " + schoolYear;
  }
  

  public int getId(){
    return id;
  }

  public boolean isEqual(Student s1){
    boolean isEqual = false;
    if (id == s1.getId()){
      isEqual = true;
    } 
    return isEqual;
  }



} 