package hw3;


/**
 * @author alexgeronimo
 */
public class Person {
    
    /**
     * Class Parameters  
     */
    private String name, email;
    private int age; 
    
    /** Constructor 
     * @param name
     * @param email
     * @param age 
     */
    public Person(String name, String email, int age){
        this.name = name; 
        this.email = email; 
        this.setAge(age);
    }
    /**
     * @return name 
     */
    public String getName(){return name;}
    
    /**
     * @return email 
     */
    public String getEmail(){return email;}
    
    /**
     * @return age
     */
    public int getAge(){return age;}
    
    /**
     * @param name - set name 
     */
    public void setName(String name){this.name= name;}
    
    /**
     * @param email - set email 
     */
    public void setEmail(String email){this.email = email;}
    
    /**
     * @param age- set age
     * @see Precondition = age is positive int
     */
    public void setAge(int age){
        this.age = age; 
        if (this.age < 0){this.age *= -1;}
        }
    
    public void getInfo(){
        System.out.println("Name: " + this.name);
        System.out.println("Email: " + this.email);
        System.out.println("Age: " + this.age);
    }
}
