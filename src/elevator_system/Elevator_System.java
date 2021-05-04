/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator_system;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Tina
 */
public class Elevator_System {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        password();
        menu();
        int press = in.nextInt();
        
        while(press!= 0){
            if(press == 1){
               elevator();
                int enter = in.nextInt();
            while(enter!= 0){
                if(enter == 1){
                   coco();
                    int lif = in.nextInt();
                    System.out.println("");
                    
                   while(lif != 4){
                       if(lif == 1){
            lifLevel();
            int n = in.nextInt();
            
            request lif1 = new request(n);
            lif1.addRequest(n); 
            lif1.insertionSort(lif1.getRequestTime(),  lif1.getID(), lif1.getSourceFloor(), lif1.getDestinationFloor());
            Elevator1 list = new Elevator1(lif1.getCalculation(lif1.getRequestTime(), lif1.getSourceFloor()), lif1.getID(), lif1.getRequestTime(),lif1.getSourceFloor(), lif1.getDestinationFloor());
            list.getLogFile();
            list.getReportFile();}
                       
                    else if(lif == 2)
                    {Elevator1 list = new Elevator1();
                    list.historyLogFile1();}
                    
                    else if(lif == 3)
                        {Elevator1 list = new Elevator1();
                    list.historyReportFile1();}
                    
                    else if(lif <0 || lif>4)
                    {System.out.println("\u001B[37;41m The number you entered is wrong. Please reenter: \u001B[0m\n");}
                    coco();
                    lif = in.nextInt();}
                } 
                if(enter == 2)
                {  matcha();
                    int lif = in.nextInt();
                    System.out.println("");
                   while(lif != 4){
                       if(lif == 1){
            lifLevel();
            int n = in.nextInt();
            
            request lif1 = new request(n);
            lif1.addRequest(n);
            lif1.insertionSort(lif1.getRequestTime(), lif1.getID(), lif1.getSourceFloor(), lif1.getDestinationFloor());
            Elevator2 list = new Elevator2(lif1.getCalculation(lif1.getRequestTime(), lif1.getSourceFloor()), lif1.getID(), lif1.getRequestTime(),lif1.getSourceFloor(), lif1.getDestinationFloor());
            list.getLogFile();
            list.getReportFile();}
                    else if(lif == 2)
                    {Elevator2 list = new Elevator2();
                    list.historyLogFile2();}
                    
                    else if(lif == 3)
                        {Elevator2 list = new Elevator2();
                    list.historyReportFile2();}
                    
                    else if(lif <0 && lif>4)
                  {System.out.println("\u001B[37;41m The number you entered is wrong. Please reenter: \u001B[0m\n");}
                    matcha();
                    lif = in.nextInt();
                                   }
                }  
                else if(enter <0 || enter>2)
                {System.out.println("\u001B[37;41m The number you entered is wrong. Please reenter: \u001B[0m\n");}
                elevator();
                enter = in.nextInt();}
        }
            else if(press == 2)
            {Elevator1 his = new Elevator1();
            his.history();}
            
            else if(press<0 || press>2)
            System.out.println("You entered wrong number. Please reenter");
        menu();
        press = in.nextInt();
    }
}
    
    public static void lifLevel(){  
            System.out.println("\u001B[34m PRESS 0 ---  G  floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 1 --- 1st floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 2 --- 2nd floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 3 --- 3rd floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 4 --- 4th floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 5 --- 5th floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 6 --- 6th floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 7 --- 7th floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 8 --- 8th floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 9 --- 9th floor \u001B[0m");
            System.out.println("\u001B[34m PRESS 10--- 10th floor \u001B[0m");
            System.out.print("\n\u001B[40;30m Enter number of request:\u001B[0m");
}
    
    public static void menu(){
       System.out.println("\u001B[32m ~~~~~~~~~~~~WELCOME TO TEALIVE ELEVATOR SYSTEM~~~~~~~~~~~~~~~ \u001B[0m\n");
        System.out.println("\u001B[35m Main menu \u001B[0m");
        System.out.println("\u001B[35m Please select: \u001B[0m\n");
        System.out.println("\u001B[34;43m Elevator System ---------------- Press 1 \u001B[0m");
        System.out.println("\u001B[34;43m History         ---------------- Press 2 \u001B[0m");
        System.out.println("\u001B[37;41m EXIT            ---------------- press 0 \u001B[0m\n");
        System.out.print("\n\u001B[40;30m Please enter your option: \u001B[0m");
}
    
    public static void elevator(){               
                System.out.println("\n\u001B[35m Please select: \u001B[0m\n");
                System.out.println("\u001B[34;43m Coco elevator\t\t>>>>>>>> press 1 \u001B[0m");
                System.out.println("\u001B[34;43m Matcha elevator\t>>>>>>>> press 2 \u001B[0m");
                System.out.println("\u001B[37;41m EXIT\t\t\t>>>>>>>> press 0 \u001B[0m\n");
                System.out.print("\u001B[40;30m Please enter your option : \u001B[0m");
}
    
    public static void coco(){    
                    System.out.println("\n\u001B[46;34m Coco Input System\t>>>>>>>>> press 1 \u001B[0m");
                    System.out.println("\u001B[46;34m Coco Log File\t\t>>>>>>>>> press 2 \u001B[0m");
                    System.out.println("\u001B[46;34m Coco Report File\t>>>>>>>>> press 3 \u001B[0m");
                    System.out.println("\u001B[37;41m EXIT\t\t\t>>>>>>>>> press 4 \u001B[0m\n");
                    System.out.print("\u001B[40;30m Please enter your option : \u001B[0m");
}
    
    public static void matcha(){
                    System.out.println("\n\u001B[46;34m Matcha Input System     >>>>>>>>> press 1 \u001B[0m");
                    System.out.println("\u001B[46;34m Matcha Log File           >>>>>>>>> press 2 \u001B[0m");
                    System.out.println("\u001B[46;34m Matcha Report File        >>>>>>>>> press 3 \u001B[0m");
                    System.out.println("\u001B[37;41m EXIT                      >>>>>>>>> press 4 \u001B[0m\n");
                    System.out.print("\u001B[40;30m Please enter your option : \u001B[0m");
}
    
    public static void password(){
        Scanner in = new Scanner(System.in);
                  
            System.out.println("Please enter your username: ");
            String username = in.nextLine();
            System.out.println("Please enter your password: ");
            String pass = in.nextLine();
            
            while(!username.equals("Tealive") && !pass.equals("fsktm")){
            System.out.println("Password is wrong please re-enter!! ");
            System.out.println("Please enter your username: ");
            username = in.nextLine();
            System.out.println("Please enter your password: ");
            pass = in.nextLine();
            }

    }

}
