package proje_ds;

import java.util.Scanner;

public class Proje_DS {

    private static Scanner input = new Scanner(System.in);
    private static String forExit;
    private static BinarySearchTree<String> bst = new BinarySearchTree<String>();
    private static MyLinkedList<String> myList = new MyLinkedList<String>();

    public static void main(String[] args) {
        int choise;
        do{
            System.out.println("0. Exit\n" + "1. Add student\n" + "2. Delete student\n" + "3. Find student\n" + "4. List all students\n" + "5. List distinct names\n" + "6. List name counts\n" + "7. About\n" + "Enter your selection : ");

            try{
                choise=input.nextInt();
            }catch (Exception e) {
                System.out.println("Sorry you entered string .....program is terminated...");
                break;
            }

            switch(choise){
                case 0:
                    case0();
                    break;
                case 1:
                    case1();
                    break;
                case 2:
                    case2();
                    break;
                case 3:
                    case3();
                    break;
                case 4:
                    case4();
                    break;
                case 5:
                    case5();
                    break;
                case 6:
                    case6();
                    break;
                case 7:
                    case7();
                    break;
                default:
                    caseDefault();
                    break;
            }
        }while(forExit.equalsIgnoreCase("cıkma"));
    }

    public static void case0() {
        System.out.println("Are you sure? Y or N");
        String sure;
        sure = input.next();
        if(sure.equals("Y")|| sure.equals("y")){
            forExit="cık";}
        else if(sure.equals("N")|| sure.equals("n")){
            forExit="cıkma";}
        else{
            System.out.println("Please enter Y for -YES- or N for -NO-");
            forExit="cıkma";}
    }
    public static void case1(){
        int studentID;
        String surname, name;

        System.out.println("Enter the information of person");
        System.out.print("Student ID : ");	studentID=input.nextInt();
        System.out.print("Name : ");        name = input.next();
        System.out.print("Surname : ");	    surname=input.next();

        for (int i = 0; i<myList.size(); i++) {
            String[] id = myList.get(i).split("-");
            if(id[0].equals(""+studentID)){
                do {
                    System.out.println("Student ID already exist please enter new student ID");
                    studentID = input.nextInt();
                }while (id[0].equals(""+studentID));

            }
        }
        String str = studentID + "-" + name + "-" + surname;
        myList.add(str);
        bst.insert(str);
        System.out.println("Student added successfully!");

        forExit="cıkma";
    }
    public static void case2(){
        String id;
        int counter = 0, size;
        size = myList.size();
        System.out.println("Enter the student id for deleting the student");
        id = input.next();
        for(int i = 0; i<myList.size(); i++) {
            String[] studentID = myList.get(i).split("-");
            if (studentID[0].equals(id)){
                bst.remove(myList.get(i));
                myList.remove(i);
                System.out.println("Student deleted successfully!");
            }else
                counter++;

        }

        if(counter == size)
            System.out.println("Student ID not found!");


        forExit="cıkma";
    }
    public static void case3(){
        String id;
        int counter = 0, size;
        size = myList.size();
        System.out.println("Enter the student id for finding the student");
        id = input.next();
        for(int i = 0; i<myList.size(); i++) {
            String[] studentID = myList.get(i).split("-");
            if (studentID[0].equals(id)){
                System.out.println("Student ID found!");
                System.out.println("Name: "+studentID[1]+" "+"Surname: "+studentID[2]);
            }else
                counter++;

        }

        if(counter == size)
            System.out.println("Student ID not found!");

        forExit="cıkma";
    }
    public static void case4(){
        String opinion;
        System.out.println("Which Data Structure You Want to Operate List Or Tree");
        System.out.println("Please write List or Tree");
        opinion = input.next();
        if(opinion.equalsIgnoreCase("List"))
        {
            System.out.println(myList.toString());
        }else if(opinion.equalsIgnoreCase("Tree")){
            System.out.println("Preorder traversal");  bst.printPreorder();
            System.out.println("Postorder traversal"); bst.printPostorder();
            System.out.println("Inorder traversal");   bst.printInorder();
            System.out.println();
        }else{
            System.out.println("Please write List or Tree");
        }
        forExit="cıkma";
    }
    public static void case5(){
        String[] nameArray = new String[myList.size()];
        int count;
        for(int i = 0; i<myList.size(); i++) {
            String[] studentID = myList.get(i).split("-");
            count = countStudentName(studentID[1]);
                if(count == 1)
                {
                    nameArray[i] = studentID[1] + " ";
                }
                else
                    nameArray[i] = "";

            }

        bubbleSort(nameArray);
        printDistinctElements(nameArray);
        System.out.println("");

        forExit="cıkma";

    }
    public static void case6(){
        String[] nameArray = new String[myList.size()];
        int count;
        for(int i = 0; i<myList.size(); i++) {
            String[] studentID = myList.get(i).split("-");

            count = countStudentName(studentID[1]);

            nameArray[i] =studentID[1]+": "+count;
        }

        bubbleSort(nameArray);
        printDistinctElements(nameArray);
        System.out.println();

        forExit="cıkma";
    }
    public static void bubbleSort(String[] nameArray)
    {
        String temp;
        for(int j = 0; j<nameArray.length-1; j++)
        {
            for(int k = 0; k<nameArray.length-j-1; k++)
            {
                if(nameArray[k].compareTo(nameArray[k+1]) > 0 )
                {
                    temp = nameArray[k];
                    nameArray[k] = nameArray[k+1];
                    nameArray[k+1] = temp;
                }
            }
        }
    }
    public static void printDistinctElements(String[] arr){

        for(int i=0;i<arr.length;i++){
            boolean isDistinct = false;
                for(int j=0;j<i;j++){
                    if(arr[i].equals(arr[j])){
                        isDistinct = true;
                        break;
                    }
                }
            if(!isDistinct){
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static int countStudentName(String name) {
        int count = 0;
        for (int i = 0; i < myList.size(); i++) {
            String[] studentID = myList.get(i).split("-");
            if (studentID[1].equals(name)) {
                count++;
            }

        }
        forExit = "cıkma";
        return count;
    }
    public static void case7(){
         System.out.println("Cansu Tosun - 130315021 - Computer Engineer");
         System.out.println("Şadiye Meltem Engin - 130315023 - Computer Engineer");
        forExit="cıkma";
    }
    public static void caseDefault(){
        System.out.println("Please enter a number between 0-7");
        forExit="cıkma";
    }



}
