public class ListGen extends Node {
    private Node head;  
    private Node tail;

    public ListGen(){
        setTerminal(false);
        setHead(null);
        setTail(null);
        setNode(this);
    }
    public ListGen(Node head, Node tail){
        setTerminal(false);
        setHead(head);
        setTail(tail);
        setNode(this);
    }

    public Node getHead() {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    
    public Node getTail() {
        return tail;
    }
    public void setTail(Node tail) {
        this.tail = tail;
    }
}
