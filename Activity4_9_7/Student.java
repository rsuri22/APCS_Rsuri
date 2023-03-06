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

  public boolean equals(Student s1){
    if (this.id == s1.getId()){
      return true;
    } 
    return false;
  }



} 