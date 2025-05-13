public class Stack{ 
    private int top; //top of the stack
    private int size; //size of the stack
    private final int capacity; //capacity of the stack
    private final String[] elements; //array to store the elements of the stack

    public Stack(int capacity){ // constructor to initialize the stack
        this.top = -1; //top of the stack
        this.size = 0; //size of the stack
        this.capacity = capacity; //capacity of the stack
        this.elements = new String[capacity]; //array to store the elements of the stack
    }

    public void push(String element){ // method to add an element to the stack
        if (size == capacity){ //if the stack is full
            System.out.println("Stack is full");
            return;
        }
        elements[++top] = element; //add the element to the top of the stack
        size++; //increment the size of the stack  
    }

    public String pop(){ // method to remove an element from the stack
        if (size == 0){ //if the stack is empty
            System.out.println("Stack is empty");
            return null;
        }
        String element = elements[top--]; //get and remove the element at the top of the stack
        size--; //decrement the size of the stack
        return element; //return the element at the top of the stack
    }

    public String peek(){ // method to get the element at the top of the stack
        if (size == 0){ //if the stack is empty
            System.out.println("Stack is empty");
            return null;
        }
        return elements[top]; //return the element at the top of the stack
    }

    public boolean isEmpty(){ // method to check if the stack is empty
        return size == 0; //return true if the stack is empty
    }

    public boolean isFull(){ // method to check if the stack is full
        return size == capacity; //return true if the stack is full
    }

    public int getSize(){ // method to get the size of the stack
        return size; //return the size of the stack
    }

    public int getCapacity(){ // method to get the capacity of the stack
        return capacity; //return the capacity of the stack
    }
}