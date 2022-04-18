import java.io.IOException;

import java.util.InputMismatchException;

import java.util.ArrayList;

import java.util.Scanner;

//User made exception to check ID.

class IdException extends Exception

{

    public IdException(String exStr) throws Exception

    {

        super(exStr);

    }

}

abstract class Person

{

    private String fullName;

    private String ID;

   

    //Constructors.

    public Person()

    {

        fullName = "";

        ID = "";

    }

    public Person(String stuFullName, String stu_id)

    {

        fullName = stuFullName;

        ID = stu_id;

    }

   

    //Getters and setters.

    public String getFullName()

    {

        return fullName;

    }

    public void setFullName(String stuFullName)

    {

        fullName = stuFullName;

    }

   

    public String getID()

    {

        return ID;

    }

    public void setID(String stu_id) throws Exception

    {

        //If the input id matches with the given

        //regular expression.

        if(stu_id.matches("[a-zA-Z]{2}[0-9]{4}"))

        {

            ID = stu_id;

        }

        else

        {

            //Throw the required exception.

            throw new IdException("");

        }

    }

    public abstract void printinfo();

}

class Student extends Person

{

    private double gpa;

    private int numberOfCreditHours;

    public double discount = 0;

   

    //Constructors.

    public Student()

    {

        super();

        gpa = 0.0;

        numberOfCreditHours = 0;

    }

    public Student(String stuFullName, String stu_id,

    double stu_gpa, int num_credit_hrs)

    {

        super(stuFullName, stu_id);

        gpa = stu_gpa;

        numberOfCreditHours = num_credit_hrs;

    }

   

    //Getters and setters.

    public void setGpa(double stu_gpa)

    {

        gpa = stu_gpa;

    }

    public double getGpa()

    {

        return gpa;

    }

   

    public void setNumCreditHours(int num_credit_hrs)

    {

        numberOfCreditHours = num_credit_hrs;

    }

    public int getNumCreditHours()

    {

        return numberOfCreditHours;

    }

   

    public double calculateTutionInvoice()

    {

        double tutionFee = 0.0;

        tutionFee = (236.45 * numberOfCreditHours)

        + 52.00;

        return tutionFee;

    }

   

    public double getDiscount()

    {

        if(gpa >= 3.85)

        {

            return (0.25 * calculateTutionInvoice());

        }

        else

        {

            return 0;

        }

    }

  

    //Display the required information of the student

    //and the tution fee.

    public void printinfo()

    {

        System.out.println("\t\tHere is the tution "

        + "invoice for " + getFullName());

        System.out.println("\t\t-------------------"

        + "----------------------------------------"

        + "----------------");

        System.out.println("\t\t" + getFullName()

        + "\t" + getID());

        System.out.println("\t\tCredit Hours:"

        + numberOfCreditHours

        + " ($236.45/credit hour)");

        System.out.println("\t\tFees: $52");

        double totalPayment = calculateTutionInvoice();

        double dicountValue = getDiscount();

        if(dicountValue != 0)

        {

            System.out.print("Total payment: ");

            System.out.printf("$%.2f \t ", totalPayment);

            System.out.printf("($%.2f ", totalPayment -

            dicountValue);

            System.out.println(" discount applied)");

        }

        else

        {

            System.out.print("Total payment: ");

            System.out.printf("$%.2f \t ", totalPayment);

            System.out.println("($0 discount applied)");

        }

    }

}

class Faculty extends Person

{

    private String department;

    private String rank;

   

    //Constructors.

    public Faculty()

    {

        super();

        department = "";

        rank = "";

    }

    

    public Faculty(String stuFullName, String stu_id,

    String dept, String title)

    {

        super(stuFullName, stu_id);

        department = dept;

        rank = title;

    }

   

    //Getters and setters.

    public void setDepartment(String dept)

    {

        department = dept;

    }

    public String getDepartment()

    {

        return department;

    }

   

    public void setRank(String title)

    {

        rank = title;

    }

    public String getRank()

    {

        return rank;

    }

   

    //Display the information of the faculty.

    public void printinfo()

    {

        System.out.println("\t\t--------------------"

        + "-----------------------------------------"

        + "--------------");

        System.out.println("\t\t" + getFullName());

        System.out.println();

        System.out.println("\t\t"

        + department.substring(0, 1).toUpperCase()

        + department.substring(1).toLowerCase()

        + " Department, "

        + rank.substring(0, 1).toUpperCase()

      + rank.substring(1).toLowerCase());

        System.out.println();

        System.out.println("\t\t----------------------"

        + "-------------------------------------------"

        + "----------");

    }

}

public class men

{

    //Display the menu of choices.

    public static int menu(Scanner sc)

    {

        int choice = 0;

        System.out.println("\tChoose one of the "

        + "options:");

        System.out.println("1. Add a new Faculty "

        + "member");

        System.out.println("2. Add a new Student");

        System.out.println("3. Print tuition invoice "

        + "for a student");

        System.out.println("4. Print information of a "

        + "faculty");

        System.out.println("5. Exit Program");

        System.out.print("\t\tEnter your selection: ");

        choice = sc.nextInt();

        return choice;

    }

   

     public static void main(String[] args)

     {

         ArrayList<Person> listOfPersons = new

         ArrayList<Person>();

         int choice = 0;

         Scanner sc = new Scanner(System.in);

          System.out.println("\t\t\t\tWelcome to my "

          + "Personal Management Program");

          while(true)

          {

              //Try/catch block for the input mismatch

              //exception.

              try

              {

                  choice = menu(sc);

              }

              catch(InputMismatchException exe)

              {

                  System.out.println("Invalid entry- "

                  + "please try again");

                System.out.println();

                choice = 0;

              }

              sc.nextLine();

             

              if(choice == 1)

              {

                  Faculty fact = new Faculty();

                  String facultyName, ID, title, dept;

                  System.out.println();

                  System.out.println();

                  System.out.println("Enter the "

                  + "faculty's info:");

                  System.out.print("\tName of the "

                  + "faculty: ");

                  facultyName = sc.nextLine();

                  fact.setFullName(facultyName);

                  System.out.print("\tID: ");

                  ID = sc.nextLine();

                 

                  //try/catch block for the ID and

                  //display the error message in the

                  //catch block.

                  try

                  {

                      fact.setID(ID);

                  }

                  catch(Exception exe)

                  {

                      System.out.println("\tSorry Invalid "

                      + "id format-It has to be "

                      + "LetterLetterDigitDigitDigitDigit");

                      System.out.println();

                      continue;

                  }

                  System.out.print("\t\tRank: ");

                  title = sc.nextLine();

                 

                  //Keep promoting the user to enter the

                  //rank until the correct rank is not

                  //entered.

                  while(!title.equalsIgnoreCase

                  ("professor") &&

                  !title.equalsIgnoreCase("adjunct"))

                  {

                      System.out.println("\tSorry "

                      + "entered rank (" + title + ") "

                      + "is invalid");

                      System.out.print("\tRank: ");

                      title = sc.nextLine();

                  }

                  fact.setRank(title);

                  System.out.print("\tDepartment: ");

                  dept = sc.nextLine();

                 

                  //Keep promoting the user to enter the

                  //department until the correct

                  //department is not entered.

                  while(!dept.equalsIgnoreCase

                  ("mathematics") &&

                  !dept.equalsIgnoreCase("engineering")

                  && !dept.equalsIgnoreCase("arts") &&

                 !dept.equalsIgnoreCase("science"))

                  {

                      System.out.println("\tSorry "

                      + "entered department (" + dept

                      + ") is invalid");

                      System.out.print("\tDepartment: ");

                      dept = sc.nextLine();

                  }

                  fact.setDepartment(dept);

                  listOfPersons.add(fact);

                  System.out.println("Thanks!");

              }

              else if(choice == 2)

              {

                  Student stu = new Student();

                  String studentName, ID;

                  double gpa;

                  int num_credit_hrs;

                  System.out.println("Enter the "

                  + "student's info:");

                  System.out.print("\tName of Student: ");

                  studentName = sc.nextLine();

                  stu.setFullName(studentName);

                  System.out.print("\tID: ");

                 

                  //try/catch block for the ID and

                  //display the error message in the

                  //catch block.

                  ID = sc.nextLine();

                  try

                  {

                      stu.setID(ID);

                  }

                  catch(Exception exe)

                  {

                      System.out.println("Sorry Invalid "

                      + "id format-It has to be "

                      + "LetterLetterDigitDigitDigitDigit");

                      System.out.println();

                      continue;

                  }

                  System.out.print("\tGpa: ");

                  gpa = sc.nextDouble();

                  stu.setGpa(gpa);

                  System.out.print("\tCredit hours: ");

                  num_credit_hrs = sc.nextInt();

                  stu.setNumCreditHours(num_credit_hrs);

                  listOfPersons.add(stu);

                  System.out.println("Thanks!");

              }

              else if(choice == 3)

              {

                  String findID = "";

                int isStudentFound = 0;

                  System.out.print("\t\tEnter the "

                  + "student's id: ");

                  findID = sc.nextLine();

                  for(int index = 0; index <

                  listOfPersons.size(); index++)

                  {

                      //Check if the current object is

                      //instance of Student and its

                      //id matches with the given id.

                      if(listOfPersons.get(index)

                      instanceof Student &&

                      listOfPersons.get(index).getID().

                      equalsIgnoreCase(findID))

                      {

                          isStudentFound = 1;

                          listOfPersons.get(index).

                          printinfo();

                          break;

                      }

                  }

                 

                  //Display the error message, if the

                  //student is not found.

                  if(isStudentFound == 0)

                  {

                      System.out.println("Sorry-student "

                      + "not found!");

                  }

              }

              else if(choice == 4)

              {

                  System.out.println();

                  String findID = "";

                  int isFacultyFound = 0;

                  System.out.print("\t\tEnter the "

                  + "faculty's id: ");

                  findID = sc.nextLine();

                  for(int index = 0; index <

                  listOfPersons.size(); index++)

                  {

                      //Check if the current object is

                      //instance of Faculty and its id

                      //matches with the given id.

                      if(listOfPersons.get(index)

                      instanceof Faculty &&

                      listOfPersons.get(index).getID().

                      equalsIgnoreCase(findID))

                      {

                          isFacultyFound = 1;

                          System.out.println("Faculty "

                          + "found:");

                          listOfPersons.get(index).

                          printinfo();

                          break;

                      }

                  }

                 

                  //Display the error message, if the

                  //faculty is not found.

                  if(isFacultyFound == 0)

                  {

                      System.out.println("\t\tSorry "

                      + findID + " doesn't exist");

                  }

              }

              else if(choice == 5)

              {

                  System.out.println("\t\tGoodbye!");

                  break;

              }

          }

     }

}