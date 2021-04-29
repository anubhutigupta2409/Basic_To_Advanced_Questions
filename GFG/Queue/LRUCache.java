/*
The task is to design and implement methods of an LRU cache. The class has two methods get() and set() which are defined as
follows.
get(x)   : Returns the value of the key x if the key exists in the cache otherwise returns -1.
set(x,y) : inserts the value if the key x is not already present. If the cache reaches its capacity it should invalidate the
least recently used item before inserting the new item.
In the constructor of the class the size of the cache should be intitialized.

Example 1:

Input:
N = 2
Q = 2
Queries = SET 1 2 GET 1
Output: 2
Explanation: Cache Size = 2
SET 1 2 GET 1
SET 1 2 : 1 -> 2
GET 1 : Print the value corresponding
to Key 1, ie 2.
Example 2:

Input:
N = 2
Q = 7
Queries = SET 1 2 SET 2 3 SET 1 5
SET 4 5 SET 6 7 GET 4 SET 1 2 GET 3
Output: 5 -1
Explanation: Cache Size = 2
SET 1 2 SET 2 3 SET 1 5 SET 4 5
SET 6 7 GET 4 SET 1 2 GET 1
SET 1 2 : 1 -> 2
SET 2 3 : 1 -> 2, 2 -> 3 (the most
recently used one is kept at the
rightmost position)
SET 1 5 : 2 -> 3, 1 -> 5
SET 4 5 : 1 -> 5, 4 -> 5 (Cache size
is 2, hence we delete the least
recently used key-value pair)
SET 6 7 : 4 -> 5, 6 -> 7
GET 4 : Prints 5
(The cache now looks like
6 -> 7, 4->5)
SET 1 2 : 4 -> 5, 1 -> 2
(Cache size is 2, hence we delete
the least recently used key-value
pair)
GET 1 : No key value pair having
key = 3. Hence, -1 is printed.

Your Task:
You only need to complete the provided functions get() and set().

Expected Time Complexity: O(1) for both get() and set().
Expected Auxiliary Space: O(1) for both get() and set(). (though, you may use extra space for cache storage and implementation
purposes).

Constraints:
1 <= N <= 1000
1 <= Q <= 100000
1 <= x, y <= 1000


*/
// design the class in the most optimal way

class Node
{
    int key;
    int value;

    Node pre;
    Node next;

    public Node(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}
//LRU Cache works on the fact that the most recent least used key value pair
//should be deleted if we reach the maximum capacity
class LRUCache
{
    private HashMap<Integer,Node> map;
    private int capacity,count;
    private Node head, tail;

    //Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap)
    {
        //code here
        capacity = cap;
        map= new HashMap<>();
        head = new Node(0,0);
        tail=new Node(0,0);

        /*the very first element of the list will be next to head and the
        last element of the list will be previous to tail, so basically
        head and tail, just mark the beginning and end of the list, but are
        empty themselves*/
        head.next=tail;
        tail.pre= head;
        head.pre= null;
        tail.next=null;

        count=0;
    }

    //helper methods
    public void deleteNode(Node node)
    {
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    public void addToHead(Node node)
    {
        node.next=head.next;
        node.next.pre=node;
        node.pre=head;
        head.next=node;
    }
    //Function to return value corresponding to the key.
    public  int get(int key)
    {
        // your code here
        if(map.get(key) != null)
        {
            Node node = map.get(key);
            int result= node.value;

            //delete from end
            deleteNode(node);
            //add to front since it was most recently used
            addToHead(node);

            return result;
        }

        return -1;
    }

    //Function for storing key-value pair.
    public void set(int key, int value)
    {
        // your code here
        if(map.get(key) !=null)
        {
            Node node = map.get(key);
            node.value=value;
            deleteNode(node);
            addToHead(node);
        }
        else
        {
            Node node = new Node(key,value);
            map.put(key,node);
            if(count<capacity)
            {
                count++;
                addToHead(node);
            }
            else
            {
                //if capacity is full we need to delete the most recently least
                //used key value pair
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(node);
            }
        }
    }
}
