public class Node {
    private Node prev;
    private Node next;
    private int info;

    public void setPrev(Node prev){
        this.prev = prev;
    }
    public Node getPrev(){
        return this.prev;
    }
    public void setNext(Node next){
        this.next = next;
    }
    public Node getNext(){
        return this.next;
    }
    public void setInfo(int info){
        this.info = info;
    }
    public int getInfo(){
        return this.info;
    }
    public Node(Node prev, Node next, int info){
        setPrev(prev);
        setNext(next);
        setInfo(info);
    }
}
