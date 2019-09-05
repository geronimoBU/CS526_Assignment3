package hw3;

/**
 * @author alexgeronimo
 */
public class Student extends Person{
    
    // Class Parameters 
    private String sID, major;
    private double gpa; 
    
    // Constructor
    public Student (String name, String email, int age,
                    String sID, String major, double gpa){
        
        super(name, email, age);
        
         //Pre-conditions
        if (age < 0){
            age *= -1;
        }
        if (gpa < 0 && gpa > 4){
            gpa = 0.0; 
        }
            
        this.gpa = gpa; 
        this.sID = sID; 
        this.major = major; 
    }
    /**
     * @return Student ID  
     */
    public String getStudentID(){return sID;}
    
    /**
     * @return major 
     */
    public String getMajor(){return major;}
    
    /**
     * @return gpa
     */
    public double getGpa(){return gpa;}
    
    /**
     * @param name - set name 
     */
    
    /**
     * Set Student ID 
     * @param sID 
     */
    public void setStudentID(String sID){this.sID = sID;}
    
    /**
     * Set Major
     * @param major 
     */
    public void setMajor(String major){this.major = major;}
    
    /**
     * Set GPA 
     * @param gpa 
     */
    public void setGpa(double gpa){this.gpa = gpa;}
    
    /**
     * Print Info 
     */
    public void printStudent(){
        System.out.println("\nName: "+ this.getName() + 
                            "\nStudent ID: "+ this.getStudentID() + 
                            "\nEmail: "+ this.getEmail() + 
                            "\nAge: "+ this.getAge() + 
                            "\nMajor: "+ this.getMajor() + 
                            "\nGPA: "+ this.getGpa()+ "\n");
    }
}
