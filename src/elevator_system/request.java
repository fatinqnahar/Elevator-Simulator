/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elevator_system;

import java.util.Scanner;

/**
 *
 * @author Tina
 */
public class request<E> {
    Scanner in = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    String id[] ;
    Integer rt[], srcFloor[],dstFloor[], size;
    
    request(int n){
    this.id =  new String[n];
    this.rt = new Integer[n];
    this.srcFloor = new Integer [n];
    this.dstFloor = new Integer[n];
    size = n;}
    
    public void addRequest(int n){
    for(int i = 0; i<n; i++)
        {
            System.out.print("\n\u001B[46;35m Enter id :\u001B[0m");
            id[i] = input.nextLine();
            System.out.print("\u001B[46;35m Enter request time:\u001B[0m");
            rt[i] = in.nextInt();
            System.out.print("\u001B[46;35m Enter source floor:\u001B[0m");
            srcFloor[i] = in.nextInt();
            while(srcFloor[i]>10 || srcFloor[i]<0)
            {System.out.println("\u001B[37;41m The floor cannot exceed 10 and less than G. Please reenter: \u001B[0m");
            srcFloor[i] = in.nextInt();}
            System.out.print("\u001B[46;35m Enter destination floor:\u001B[0m");
            dstFloor[i] = in.nextInt();
            while(dstFloor[i]>10 || dstFloor[i]<0)
            {System.out.println("\u001B[37;41m The floor cannot exceed 10 and less than G. Please reenter: \u001B[0m");
            dstFloor[i] = in.nextInt();}
        }        
    }
    public String[] getID(){
    return this.id; }
    
    public Integer[] getRequestTime(){
    return this.rt;}
    
    public Integer[] getSourceFloor(){
    return this.srcFloor;}
    
    public Integer[] getDestinationFloor(){
    return this.dstFloor;}
     
    public int getCurrentSize(){
    return size;}
  
     protected <T extends Comparable <? super T>> void insertionSort(T[] rt, T[] id, T[]src, T[]dst){
    for(int index = 1; index<rt.length; index++)
    {
   T temp = rt[index];
   T tempID = id[index];
   T tempSRC = src[index];
   T tempDST = dst[index];
   int position = index; 
    
    while(position>0 && rt[position-1].compareTo(temp)>0)
    {    rt[position] = rt[position - 1];
         id[position] = id [position - 1];
         src[position] = src [position - 1];
         dst[position] = dst [position - 1];
         position--;}
    
   rt[position] = temp;
        id[position] = tempID;
        src[position] = tempSRC;
        dst[position] = tempDST;}
    }
    
    public boolean[] getCalculation(Integer[] sourceTime, Integer[] srcFloor){        
    int[] result = new int[sourceTime.length - 1];
    boolean check[] = new boolean[sourceTime.length - 1];
    int currentTime = 14;
    if(srcFloor[0]>0)
    {currentTime+= srcFloor[0];}
    
        for(int i = 0; i<result.length; i++)
    {result[i] = Math.abs(sourceTime[i+1] - currentTime);
    if(result[i]>srcFloor[i+1] && srcFloor[i+1]<srcFloor[i])
        check[i] = false;
    else if(result[i]<=srcFloor[i+1])
        check[i] = true;
    else if(srcFloor[i+1]>srcFloor[i] && sourceTime[i+1]<currentTime)
        check[i] = true;
    else if(sourceTime[0] == sourceTime[i+1] && srcFloor[0]== srcFloor[i+1])
        check[i] = true;
    }
    return check;}
}

