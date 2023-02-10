public class List {
    private Node begin;
    private Node end;

    public List(){    }

    private void setBegin(Node begin){
        this.begin = begin;
    }
    public Node getBegin(){
        return this.begin;
    }
    private void setEnd(Node end){
        this.end = end;
    }
    public Node getEnd(){
        return this.end;
    }

    public void initialize(){
        setBegin(null);
        setEnd(null);
    }

    public void beginningInsertion(int info){
        Node node = new Node(null,null,info);
        if(this.getBegin()==null)
        {
            setBegin(node);
            setEnd(node);
        }
        else
        {
            Node aux = this.getBegin();
            aux.setPrev(node);
            node.setNext(aux);
        }
    }

    public void endInsertion(int info){
        Node node = new Node(null, null, info);
        if(this.getBegin()==null)
        {
            setBegin(node);
            setEnd(node);
        }
        else
        {
            Node aux = this.getEnd();
            aux.setNext(node);
            node.setPrev(aux);
        }
    }

    public void show(){
        Node aux = this.getBegin();
        while(aux != null)
        {
            System.out.print(aux.getInfo() + "\n");
            aux = aux.getNext();
        }
    }

    public Node exhaustiveSearch(int key){
        Node node = this.getBegin();
        while(node!=null && node.getInfo()!=key)
            node = node.getNext();
        return node;
    }

    public void remove(int key){
        Node node = this.exhaustiveSearch(key);
        if(node!=null)
        {
            Node prev = node.getPrev(), next = node.getNext();
            if(prev==next) //Nó encontrado é o único da lista -> prev e next apontam para null => prev==next
            {
                this.setBegin(null);
                this.setEnd(null);
            }
            else if(next==null) //Nó no fim da lista
            {
                prev.setNext(next);
                this.setEnd(prev);
            }
            else if(prev==null)  //Nó no começo da lista
            {
                next.setPrev(prev);
                this.setBegin(next);
            }
            else    //Nó no meio da lista
            {
                next.setPrev(prev);
                prev.setNext(next);
            }
        }
    }
}