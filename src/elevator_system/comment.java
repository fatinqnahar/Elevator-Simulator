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
public class comment <E> {
    boolean check[];
    E id[];
    Integer requestTime[], srcFloor[], dstFloor[];
    Integer totalTimeperID[], totalTime, timePerID[];
    Integer timeTaken ,countTime[], tempDST[], tempSrc[];
    Integer count, currentFloor, tempCount, c, totalFloor, newLength;
    String msg[];
        
    protected final void filter(){
    this.tempDST[++tempCount] = dstFloor[0];    
    this.timeTaken = requestTime[0];
    currentFloor = 0;
    this.tempSrc[tempCount] = srcFloor[0];
    request(id[0],srcFloor[0],dstFloor[0], requestTime[0]);
    if(srcFloor[0]>0)
    {direction(srcFloor[0]);
    currentFloor = srcFloor[0];}    
    start();
    this.totalTimeperID[++c] = this.timeTaken - this.requestTime[c];
    
        for(int i = 0; i<id.length - 1; i++)
        {
            if(check[i] == true){
        if(requestTime[i+1]<this.timeTaken && srcFloor[0]!= srcFloor[i+1])
        {request(id[i+1],srcFloor[i+1], dstFloor[i+1], requestTime[i+1]);
        direction(srcFloor[i+1]);
        currentFloor = srcFloor[i+1];
        start();
        this.totalTimeperID[++c] = this.timeTaken - this.requestTime[c];}
        
        else if(requestTime[i+1]>=this.timeTaken)
        {   countTime[++count] = timeTaken;
            msg[count] = "Heading to "+dstFloor[i];
            //currentFloor = dstFloor[i];
            request(id[i+1],srcFloor[i+1], dstFloor[i+1], requestTime[i+1]);
            direction(srcFloor[i+1], requestTime[i+1]);
            currentFloor = srcFloor[i+1];
            start();
            this.totalTimeperID[++c] = this.timeTaken - this.requestTime[c];}
        
        else if(srcFloor[0].equals(srcFloor[i+1]) && requestTime[0].equals(requestTime[i+1]))
        {request(id[i+1],srcFloor[i+1], dstFloor[i+1], requestTime[i+1]);
         this.totalTimeperID[++c] = this.timeTaken - this.requestTime[c];}
            
        
        tempDST[++tempCount] = dstFloor[i+1];
        tempSrc[tempCount] = srcFloor[i+1];}
        }  
        
        Sorting(tempDST, tempSrc);
        
        for(int j = 0; j<=c; j++)
            {                
                if(tempDST[j] != tempDST[j+1])
                {direction(tempDST[j]);
                currentFloor = tempDST[j];
                end();
                this.totalTimeperID[j] = this.timeTaken - this.requestTime[j];
                }
                else{
            direction(tempDST[j]);
            currentFloor = tempDST[j];
            end();
            this.totalTimeperID[j] = this.timeTaken - this.requestTime[j];
            j++;
            this.totalTimeperID[j] = this.timeTaken - this.requestTime[j];}                
            } 
        
        for(int i = 0; i<id.length - 1; i++)
        {   if(check[i] == false)
            {   request(id[i+1],srcFloor[i+1], dstFloor[i+1], requestTime[i+1]);
                currentFloor = dstFloor[i];
                direction(srcFloor[i+1]);
                start();
                currentFloor = srcFloor[i+1];
                direction(dstFloor[i+1]);
                currentFloor = dstFloor[i+1];
                end();
                this.totalTimeperID[++c] = this.timeTaken - this.requestTime[c];} 
        }        
    }
    
    private void request(E id,int src, int dst, int requestTime){
    countTime[++count] = requestTime;
    msg[count] = "received request ID ["+id+"] from floor "+src+" to floor "+dst;}
     
    private void start(){
    countTime[++count] = timeTaken;
    msg[count] = "Door opening";
    timeTaken+=5;
    countTime[++count] = timeTaken;
    msg[count] = "Door opened";
    timeTaken+=4;
    countTime[++count] = timeTaken;
    msg[count] = "Passenger(s) entered";
    countTime[++count] = timeTaken;
    msg[count] = "Door closing";
    timeTaken+=5;
    countTime[++count] = timeTaken;
    msg[count] = "Door closed";}
    
    private void end(){
    countTime[++count] = timeTaken;
    msg[count] = "Door opening";
    timeTaken+=5;
    countTime[++count] = timeTaken;
    msg[count] = "Door opened";
    timeTaken+=4;
    countTime[++count] = timeTaken;
    msg[count] = "Passenger(s) left";
    countTime[++count] = timeTaken;
    msg[count] = "Door closing";
    timeTaken+=5;
    countTime[++count] = timeTaken;
    msg[count] = "Door closed";}
    
       
    private void direction(int floor){
    countTime[++count] = timeTaken;
    msg[count] = "Heading to floor "+floor;
    timeTaken+=Math.abs(floor - currentFloor);
    totalFloor+=Math.abs(floor - currentFloor);
    countTime[++count] = timeTaken;
    msg[count] = "Reached floor "+floor;}
    
    private void direction(int floor, int time){
    countTime[++count] = time;
    msg[count] = "Heading to floor "+floor;
    timeTaken+=Math.abs(floor - currentFloor);
    totalFloor+=Math.abs(floor - currentFloor);
    countTime[++count] = timeTaken;
    msg[count] = "Reached floor "+floor;}
    
   protected <E extends Comparable <? super E>> void Sorting(Integer[] dst, Integer[] src){
        
        for(int index = 1; index<=this.tempCount; index++)
        {Integer temp =  dst[index];
        int position = index;
       
        while(position >0 && dst[position - 1].compareTo(temp)>0 && src[tempCount].compareTo(dst[position - 1])<0)
        {dst[position] = dst[position - 1];
         position--;}
        
        dst[position] = temp;}
    }
    
    protected <T extends Comparable <? super T>> void insertionSort(T[] data, T[] message){
    for(int index = 1; index<this.count; index++)
    {
    T key = data[index];
    int p = index;
    T key2 = message[index];
    
    while(p>0 && data[p-1].compareTo(key)>0)
    {data[p] = data[p-1];
    message[p] = message[p-1];
    p--;}
    
    data[p] = key;
    message[p] = key2;}                                                                    }
    
    }

