package Linked_List;

class Node{
    int data;
    Node next = null;

    Node(int d){
        this.data =d;
    }

    void append(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null){
            n = n.next;
        }
        n.next = end;
    }
    void print() {
    	Node n = this;
    	while(n.next != null) {
    		System.out.println(n.data);
    		n = n.next;
    	}
    	System.out.println(n.data);
    }
}