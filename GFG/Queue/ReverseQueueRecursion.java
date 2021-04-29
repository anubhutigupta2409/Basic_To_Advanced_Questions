/*
Reverse Queue using recursion and without using anuother data structure
*/

class ReverseQueueRecursion{
    //Function to reverse the queue.
   
    public Queue<Integer> rev(Queue<Integer> q){
        //add code here.
        if(!q.isEmpty())
        {
            int data = q.poll();
            
            q= rev(q);
            
            q.add(data);
        }
            
        return q;
    }
}