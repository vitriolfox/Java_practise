package LinkedList;

import java.util.List;

public class LinkedList {

    private class Node{
        private Node previous;
        private Node next;
        private int value;

        public Node(LinkedList.Node previous, LinkedList.Node next, int value) {
            this.previous = previous;
            this.next = next;
            this.value = value;
        }
    }

    private Node head = null;
    private Node tail = null;
    private Node actualNode = null;

    public LinkedList(LinkedList.Node head, LinkedList.Node tail, LinkedList.Node actualNode) {
        this.head = head;
        this.tail = tail;
        this.actualNode = actualNode;
    }

    public boolean isEmpty(){ return (head == null); }

    public boolean isFirst(){ return (actualNode == head); }

    public boolean isLast(){ return (actualNode == tail); }

    public int getActualValue() {
        if (isEmpty()){
            System.out.println("Nincs elem a listában!");
            return -1;
        } else {
            return actualNode.value;
        }
    }
    public void setActualValue(int newValue){
        if (!isEmpty()){
            actualNode.value = newValue;
        } else {
            System.out.println("Nincs elem a listában!");
        }
    }

    public void stepForward(){
        if (!isEmpty() && !isLast()) {
            actualNode = actualNode.next;
        }
    }

    public void stepBackward(){
        if (!isEmpty() && !isFirst()) {
            actualNode = actualNode.previous;
        }
    }

    public void stepLast(){
        this.actualNode = this.tail;
    }

    public void stepFirst(){
        this.actualNode = this.head;
    }

    public void insertFirst(int value) {
        Node newNode = new Node(null, this.head, value);
        this.actualNode = newNode;
        if (isEmpty()) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            head.previous = newNode;
            head = newNode;
        }
    }

    public void insertLast(int value) {
        if (isEmpty()) {
            insertFirst(value);
        } else {
            Node newNode = new Node(this.tail, null, value);
            this.actualNode = newNode;
            tail.previous = newNode;
            tail = newNode;
        }
    }


    public void insertBefore(int value){
        if (isEmpty() && isFirst()) {
            insertFirst(value);
        } else {
            Node newNode = new Node(actualNode.previous, actualNode, value);
            this.actualNode.previous.next = newNode;
            this.actualNode.previous = newNode;
            this.actualNode = newNode;
        }
    }

    public void insertAfter(int value){
        if (isEmpty() && isLast()) {
            insertLast(value);
        } else {
            stepForward();
            insertBefore(value);
        }
    }

    public void removeFirst(){
        if (!isEmpty()){
            stepFirst();
            stepForward();
            this.head = this.actualNode;
            this.actualNode.previous = null;
        } else {
            System.out.println("List is empty.");
        }

    }

    public void removeLast(){
        this.tail = this.tail.previous;
        this.actualNode = this.tail;

        if (!isEmpty()){
            stepLast();
            stepBackward();
            this.actualNode.next = null;
            this.tail = this.actualNode;
        } else {
            System.out.println("List is empty.");
        }
    }

    public void removeBefore(){
        if (!isEmpty()) {
            this.actualNode.previous.previous.next = this.actualNode;
            this.actualNode.previous = this.actualNode.previous.previous;
        } else {
            System.out.println("List is empty.");
        }
    }

    public void removeAfter(){
        if (!isEmpty()) {
            stepForward();
            stepForward();
            removeBefore();
        } else {
            System.out.println("List is empty.");
        }
    }


    public boolean contains(int value){
        stepFirst();
        if (!isEmpty()) {
            while (this.actualNode.next != null) {
                if (actualNode.value != value) {
                    this.stepForward();

                } else if (this.actualNode.value == value) {
                    return true;

                } else if (this.actualNode.next == null) {
                    return false;
                }
            }
        } else {
            System.out.println("List is empty.");
        }
        return false;
    }

    /*@Override
    public String toString() {
        List<String> result = null;
        stepFirst();
        while (this.actualNode.next != null) {
            result.add(String.valueOf(actualNode.value) + ", ");
            stepForward();
        }
            return result.toString();
    }*/


}
