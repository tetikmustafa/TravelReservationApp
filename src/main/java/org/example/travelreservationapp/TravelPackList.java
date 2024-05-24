package org.example.travelreservationapp;

class Node {
    TravelPack data;
    Node next;
    Node prev;

    Node(TravelPack data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
public class TravelPackList {
    private Node head;
    private Node tail;

    private String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public TravelPackList() {
        this.head = null;
        this.tail = null;
    }

    public void add(TravelPack data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public int size(){
        Node current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public TravelPack get(int index){
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.data;
            }
            count++;
            current = current.next;
        }
        return null;
    }
    public TravelPack getNext(TravelPack current){
        Node temp = head;
        while(temp != null){
            if(temp.data.equals(current)){
                if(temp.next != null){
                    return temp.next.data;
                }
                return head.data;
            }
            temp = temp.next;
        }
        return null;
    }
    public TravelPack getPrevious(TravelPack current){
        Node temp = head;
        while(temp != null){
            if(temp.data.equals(current)){
                if(temp.prev != null){
                    return temp.prev.data;
                }
                return tail.data;
            }
            temp = temp.next;
        }
        return null;
    }

}
