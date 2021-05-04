/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator_system;

/**
 *
 * @author Tina
 */
public class Elevator2<E> extends files{
    
    Elevator2(){}
    
    Elevator2(boolean check[],E id[], Integer requestTime[], Integer srcFloor[], Integer dstFloor[]){
    this.check = check;
    this.id = id;
    this.requestTime = requestTime;
    this.srcFloor = srcFloor;
    this.dstFloor = dstFloor;    
    this.totalTimeperID = new Integer[id.length];
    this.totalTime = 0;
    this.count = -1;
    this.countTime = new Integer[1000];
    this.msg = new String[1000];
    this.tempCount = -1;
    this.tempDST = new Integer [50];
    this.tempSrc = new Integer[50];
    this.timePerID = new Integer[50];
    this.c = -1;
    this.totalFloor = 0;
    filter();
    }
    void getLogFile(){
        addLogFile("LogFile2.txt");
        addLogFile("History.txt");
        printLogFile();
    }
    
    void getReportFile(){
        addReportFile("History.txt");
        addReportFile("ReportFile2.txt");
        printReportFile();
    }
    
    public void history(){
    getHistory("History.txt");
}
    
    public void historyLogFile2(){
    System.out.println("\nLOG FILE ELEVATOR COCO\n");
    getHistory("LogFile2.txt");
 }
    
    public void historyReportFile2(){
    System.out.println("\nREPORT FILE ELEVATOR COCO\n");
    getHistory("ReportFile2.txt");
}
}
