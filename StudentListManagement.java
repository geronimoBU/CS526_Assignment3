package hw3;

import hw3.SinglyLinkedList.Node;
import java.util.Scanner;


/**
 * Contains: Main, checkMenuInput,userEnterString 
 * @author alexgeronimo
 */
public class StudentListManagement {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SinglyLinkedList<Student> studentLinkedList = new SinglyLinkedList<>();
        
        // Create Menu, handle input  
        boolean menu = true; 
        while (menu == true){
            Scanner in = new Scanner(System.in);
            System.out.println("Choose an Option:\n"+ "1. Add a student\n"
            + "2. Remove a student\n"+ "3. Update student GPA\n"+ "4. Display student information\n"
            + "5. Display all students\n" + "6. Exit");
            int menu_option = checkMenuInput(in);

        // Handle menu options 
        
        // Menu 1
            if (menu_option == 1){
                String name = userEnterString("full name");
                String sID = userEnterString("student ID");
                String email = userEnterString("email");
                String major = userEnterString("major");
                int age = userEnterInt("age");
                double gpa = userEnterDouble("gpa");
                System.out.println("");
                
                Student s = new Student(name, email, age, sID, major, gpa);
                boolean checkList = true;
                
                if (studentLinkedList.isEmpty() == true){
                    studentLinkedList.addFirst(s);
                    System.out.println("New Student file for " + s.getName() + " created.\n");
                    checkList = false; 
                }
                
                while (checkList == true){
                   
                    if (studentLinkedList.size == 1){
                        Student head = studentLinkedList.first();

                        if (head.getStudentID().equals(sID)){
                            System.out.println("Error: Student " + head.getName() + " already exists"
                                    + "\nRetruning to main menu...\n");
                            break;
                        }
                        else{
                            studentLinkedList.addLast(s);
                            studentLinkedList.head.setNext(studentLinkedList.tail);
                            System.out.println("New Student file for " + s.getName() + " created.\n");
                            break; 
                        }
                    }
                    
                    else{
                        checkList = check_sID(studentLinkedList, s, sID); 
                        if (checkList == true){
                            studentLinkedList.addLast(s);
                            System.out.println("New Student file for " + s.getName() + " created.\n");
                            break;
                        }
                        else{break;}
                    }
                }     
                        
            }       
    
        // Menu 2    
             else if ( menu_option == 2){
                 if (studentLinkedList.isEmpty() == true){
                     System.out.println("Error: Student List is empty.\n"
                             + "Returning to main menu...\n");
                 }
                 else{
                    boolean checkList = true;
                    String sID = userEnterString("student ID");

                    if (studentLinkedList.size == 1){
                        if (studentLinkedList.head.getElement().getStudentID().equals(sID)){
                            System.out.println("Student " + studentLinkedList.head.getElement().getName() + 
                                    " has been removed.\nReturning to main menu...\n");
                            studentLinkedList.removeFirst();
                        }
                        else{
                            System.out.println("Error: Student ID " + sID + "not found.\n"
                                    + "Returning to main menu...\n");
                        }

                    }

                    else if (studentLinkedList.size == 2){
                        if (studentLinkedList.head.getElement().getStudentID().equals(sID)){
                            System.out.println("Student " + studentLinkedList.head.getElement().getName() + 
                                    " has been removed.\nReturning to main menu...\n");
                            studentLinkedList.removeFirst();
                        }
                        else{
                           if (studentLinkedList.tail.getElement().getStudentID().equals(sID)){
                               Student head_s = studentLinkedList.head.getElement();
                               Student tail_s = studentLinkedList.tail.getElement();

                               studentLinkedList = new SinglyLinkedList<>();
                               studentLinkedList.addFirst(head_s);

                               System.out.println("Student " + tail_s.getName() + 
                                   " has been removed.\nReturning to main menu...\n");

                           }
                           else {
                              System.out.println("Error: Student ID " + sID + "not found.\n"
                                    + "Returning to main menu...\n"); 
                           }
                       }
                    }

                    else if (studentLinkedList.size > 2){
                        Node<Student> previous = studentLinkedList.head;
                        Node<Student> current = studentLinkedList.head.getNext();

                        if (previous.getElement().getStudentID().equals(sID)){
                            studentLinkedList.removeFirst();
                        }

                        else if (current.getElement().getStudentID().equals(sID)) {
                            previous.setNext(current.getNext());

                        }
                        else {
                            boolean found = false;
                            while (current.getNext() != null){

                                if (current.getElement().getStudentID().equals(sID)){
                                    previous.setNext(current.getNext());
                                    studentLinkedList.setSize(studentLinkedList.size - 1);
                                    found = true;
                                }
                                if (found == true){break;}
                                current = current.getNext();
                                previous = previous.getNext();
                            }
                            if (found == false){
                                System.out.println("Error: Student ID " + sID + "not found.\n"
                                    + "Returning to main menu...\n");
                            }
                            else{
                                System.out.println("Student ID " + sID + "has been removed.\n"
                                    + "Returning to main menu...\n");
                            }
                        }
                    }
                 }
            }
        // Menu 3     
             else if (menu_option == 3){
                 String sID = userEnterString("student ID");
                 double gpa = userEnterDouble("new gpa");
                 boolean bool = false;
                 Node<Student> node = studentLinkedList.head;
                 if (node.getElement().getStudentID().equals(sID)){
                     node.getElement().setGpa(gpa);
                     bool = true; 
                     System.out.println("GPA for " + node.getElement().getName() + " has been updated."
                             + "\nReturning to main menu\n");
                 }
                 else{
                    while (node.getNext() != null){
                       node = node.getNext();
                       Student s_node = node.getElement();
                       if (s_node.getStudentID().equals(sID)){
                           node.getElement().setGpa(gpa);
                           bool = true;
                           System.out.println("GPA for " + node.getElement().getName() + " has been updated."
                             + "\nReturning to main menu\n");
                       }
                             
                    }
                    if (bool == false){
                        System.out.println("Error: Student with ID" + sID + " does not exist."
                        + "\nRetruning to main menu...\n");
                    }
                    
                }
            }
        // Menu 4    
             else if (menu_option == 4){
                 String sID = userEnterString("student ID");
                 boolean bool = false;
                 Node<Student> node = studentLinkedList.head;
                 if (node.getElement().getStudentID().equals(sID)){
                     node.getElement().printStudent();
                     bool = true;      
                 }
                 else {
                    while (node.getNext() != null){
                       node = node.getNext();
                       Student s_node = node.getElement();
                       if (s_node.getStudentID().equals(sID)) {
                            node.getElement().printStudent();
                            bool = true;
                       }   
                    }  
                }
                if (bool == false){
                    System.out.println("Error: Student with ID" + sID + " does not exist."
                    + "\nRetruning to main menu...\n");
                    
                }
            }
        // Menu 5    
            else if (menu_option == 5){
                System.out.println("Number of students currently in the list: " + studentLinkedList.size);
                Node<Student> node = studentLinkedList.head;
                node.getElement().printStudent();
                System.out.println("");
                 
                while (node.getNext() != null){
                   node = node.getNext();
                   node.getElement().printStudent();       
                }   
            }
        // Menu 6    
            else if (menu_option == 6){
                System.out.println("Bye!");
                menu = false;
            }
          
        }
    }

    //************** End Main **********************************
    
    /**
     * Check if input is integer, catch exception, wait for correct input before returning to main
     * @param in
     * @return 
     */
    public static int checkMenuInput(Scanner in){
        String menu_in = in.next();
        try {
            int menu_int = Integer.parseInt(menu_in);
            return menu_int;
        }
        
        catch (NumberFormatException ex) {
            System.out.println("Please enter '1', '2', '3', '4', '5', or '6' to exit." + "\n");}
            System.out.println("Choose an Option:\n"+ "1. Add a student\n"
            + "2. Remove a student\n"+ "3. Update student GPA\n"+ "4. Display student information\n"
            + "5. Display all students\n" + "6. Exit");
            int menu_int_again = checkMenuInput(in);
            return menu_int_again; 
    }
    
    /**
     * Check if input is integer, catch exception, wait for correct input before returning to main
     * @param in
     * @return integer
     */
    public static int userEnterInt(String in){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter " + in + ":");
            String string_in = input.nextLine().trim();
            int check_int = Integer.parseInt(string_in);
            return check_int;
        }
        
        catch (NumberFormatException ex) {
            System.out.println("Please enter an integer" + "\n");
            int check_int_again = userEnterInt(in);
            return check_int_again;
        }
    }
    
    /**
     * Prompt user to enter full name
     * @return String user input 
     */
    public static String userEnterString(String string){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter " + string + ":");
        String string_in = in.nextLine().trim();
        return string_in;
    }
    
    /**
     * Check if input is double, catch exception, wait for correct input before returning to main
     * @param in
     * @return double
     */
    public static double userEnterDouble (String in){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter " + in + ":");
            String string_in = input.nextLine().trim();
            double check_double = Double.parseDouble(string_in);
            return check_double;
        }
        
        catch (NumberFormatException ex) {
            System.out.println("Please enter an double (ie. 3.14):\n");
            double check_double_again = userEnterDouble(in);
            return check_double_again;
        }
    }
    
    /**
     * 
     * @param list
     * @param s
     * @param sID
     * @return False if student ID found
     */
    public static boolean check_sID (SinglyLinkedList<Student> list, Student s, String sID){
        boolean bool = true; 
        Node<Student> node = list.head;
        while (node.getNext() != null){
            node = node.getNext();
            Student s_node = node.getElement();
            if (s_node.getStudentID().equals(sID)){
                System.out.println("Error: Student " + s.getName() + " already exists"
                + "\nRetruning to main menu...\n");
                bool = false;
                break;
            }
        }
        return bool;
    }
    
}
