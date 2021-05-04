/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator_system;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Tina
 */
public abstract class files extends comment{
     public void addDate(String fileName){
        FileWriter m = null;
        try {
            GregorianCalendar gcalendar = new GregorianCalendar();
            String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep","Oct", "Nov", "Dec"};
                        
            File n = new File(fileName);
            m  = new FileWriter(n, true);
            BufferedWriter wr = new BufferedWriter(m);           
            
            wr.write("Date: "+months[gcalendar.get(Calendar.MONTH)]+" " + gcalendar.get(Calendar.DATE) + " "+gcalendar.get(Calendar.YEAR));
            wr.newLine();
            wr.write("Time: "+gcalendar.get(Calendar.HOUR) + ":"+gcalendar.get(Calendar.MINUTE) + ":"+gcalendar.get(Calendar.SECOND));
            wr.newLine();
                        
            wr.close();
            m.close();
        } catch (IOException ex) {
            System.out.println("File not found");
        }       } 
    
     public void printDate(){
     GregorianCalendar gcalendar = new GregorianCalendar();
            String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep","Oct", "Nov", "Dec"};
            System.out.println("\nDate: "+months[gcalendar.get(Calendar.MONTH)]+" " + gcalendar.get(Calendar.DATE) + " "+gcalendar.get(Calendar.YEAR));
            System.out.println("Time: "+gcalendar.get(Calendar.HOUR) + ":"+gcalendar.get(Calendar.MINUTE) + ":"+gcalendar.get(Calendar.SECOND));
     }
     
    public void getHistory(String fileName){
    FileInputStream readHistory = null;
        try {
            System.out.println(fileName);
            readHistory = new FileInputStream(fileName);
            Scanner in = new Scanner(readHistory);
            while(in.hasNextLine())
            {System.out.println(in.nextLine());}
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } 
}
    
    void addLogFile(String name){
        FileWriter q = null;
        try {
            insertionSort(this.countTime, this.msg);
            File f = new File(name);
            q = new FileWriter(f,true);            
            BufferedWriter bw = new BufferedWriter(q);
            
            bw.write("\n\n~~~~~~~~LOG FILE~~~~~~~~~~");
            addDate(name);
            bw.newLine();
            for(int i = 0; i<=this.count; i++)
            {bw.write(this.countTime[i]+" : "+this.msg[i]);bw.newLine();}
            
            bw.close();
            q.close();
        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }
    
    void printLogFile(){       
    System.out.println("\n\u001B[31m~~~~~~~~LOG FILE~~~~~~~~~~~\u001B[0m");
     printDate();
            for(int i = 0; i<=this.count; i++)
            {System.out.print("\u001B[31m"+this.countTime[i]+"\u001B[0m");
                System.out.print("\u001B[30m : \u001B[0m");
                System.out.println("\u001B[34m"+this.msg[i]+" \u001B[0m");
            }
    }
    
    void printReportFile(){
    System.out.println("\n\n\u001B[46m *************************************\u001B[0m");
            System.out.println("\u001B[45m ******** ELEVATOR STATISTIC**********\u001B[0m");
            System.out.println("\u001B[46m *************************************\u001B[0m");
             printDate();
            System.out.println("\n\u001B[36m Service request processed: "+id.length+" \u001B[0m");
            System.out.println("\u001B[36m Passenger served: "+id.length+"\u001B[0m");
            System.out.println("\u001B[36m Total floors travelled: "+this.totalFloor+"\u001B[0m");
            System.out.println("\u001B[36m Total time taken: "+this.timeTaken+"\u001B[0m");
            
            for(int i = 0; i<id.length; i++)
            {
                System.out.println("\n\u001B[31m -------Request ID "+this.id[i]+"--------\u001B[0m");
                System.out.println("\u001B[30m Total time utilized: "+this.totalTimeperID[i]+" \u001B[0m");}
                System.out.println("\n");
    }
    
    void addReportFile(String name){
        FileWriter q = null;
        try {
            File f = new File(name);
            q = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(q);
           
            bw.write("*************************************");
            bw.newLine();
            bw.write("******** ELEVATOR STATISTIC**********");
            bw.newLine();
            bw.write("*************************************");
            bw.newLine();
            bw.write("\nService request processed: "+id.length);
            bw.newLine();
            bw.write("Passenger served: "+id.length);
            bw.newLine();
            bw.write("Total floors travelled: "+this.totalFloor);
            bw.newLine();
            bw.write("Total time taken: "+this.timeTaken);
            bw.newLine();
                        
            for(int i = 0; i<id.length; i++)
            {
                bw.write("-------Request ID "+this.id[i]+"--------");
                bw.newLine();
                bw.write("Total time utilized: "+this.totalTimeperID[i]);
                bw.newLine();
            }
              
                bw.close();
        } catch (IOException ex) {
            System.out.println("File not found");
        }
    }
}
