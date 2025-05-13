public class Queue{
    private int front;//front of the queue
    private int back; //back of the queue
    private int size;  //size of the queue
    private final int capacity; //capacity of the queue 
    private final String[] elements; //array to store the elements of the queue
    
    public Queue(int capacity){ // constructor to initialize the queue
        this.front = 0; //front of the queue
        this.back = -1; //back of the queue
        this.size = 0 ; //size of the queue
        this.capacity = capacity; //capacity of the queue
        this.elements = new String[capacity]; //array to store the elements of the queue
    }

    public void enqueue (String element){ // method to add an element to the queue
        if (size == capacity){ //if the queue is full
            System.out.println("Queue is full");
            return;
        }
        back = (back + 1) % capacity; //increment the back of the queue
        elements[back] = element; //add the element to the back of the queue
        size++; //increment the size of the queue  
    }
    public String dequeue(){ // method to remove an element from the queue
        if (size == 0){ //if the queue is empty
            System.out.println("Queue is empty");
            return null;
        }
        String element = elements[front]; //get the element at the front of the queue
        front = (front + 1) % capacity; //increment the front of the queue
        size--; //decrement the size of the queue
        return element; //return the element at the front of the queue
    }
    public String peek(){ // method to get the element at the front of the queue
        if (size == 0){ //if the queue is empty
            System.out.println("Queue is empty");
            return null;
        }
        return elements[front]; //return the element at the front of the queue
    }
    public boolean isEmpty(){ // method to check if the queue is empty
        return size == 0; //return true if the queue is empty
    }
    public boolean isFull(){ // method to check if the queue is full
        return size == capacity; //return true if the queue is full
    }
    public int getSize(){ // method to get the size of the queue
        return size; //return the size of the queue
    }
    public int getCapacity(){ // method to get the capacity of the queue
        return capacity; //return the capacity of the queue
    }
}