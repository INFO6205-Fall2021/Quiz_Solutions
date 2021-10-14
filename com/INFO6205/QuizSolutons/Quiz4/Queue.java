package com.INFO6205.QuizSolutons.Quiz4;

/*
       Queue Implementation:
       
        For this Quiz, we'll be implementing Queue with Elements which is essentially a Linked List with a tail. You have to implement enqueue and dequeue logic. You should use the Elements Class to create nodes.
        Example initialization of Elements:

        Element<Item> element = new Element<>(item);
*/
public class Queue<Item> {
    //Construct a new (empty) queue.
    public Queue() {
        oldest = null;
        newest = null;
    }

    //Enqueue the given item in the linkedlist referenced by oldest
    public void enqueue(Item item) {
        Element<Item> element = new Element<>(item);
        Element<Item> secondNewest = newest;
        if (isEmpty()) oldest = element;
        else {
            assert secondNewest != null; // Redundant Check
            secondNewest.next = element;
        }
        this.newest = element;
    }


    //Dequeue an element from the oldest list and return the item.
    public Item dequeue() {
        if (isEmpty()) return null;
        else {
            assert oldest != null; // Redundant assertion
            Item result = oldest.item;
            oldest = oldest.next;
            if (isEmpty()) newest = null;
            return result;

        }
    }

    public boolean isEmpty() {
        return oldest == null;
    }


    private Element<Item> oldest;

    private Element<Item> newest;


    public void clear() {
        while (!isEmpty()) dequeue();
    }


    public class Element<Item> {
        Element(Item x, Element<Item> n) {
            item = x;
            next = n;
        }

        Element(Item x) {
            this(x, null);
        }

        final Item item;
        Element<Item> next;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

}
