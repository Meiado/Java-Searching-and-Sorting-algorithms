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
            aux.setAnt(node);
            node.setProx(aux);
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
            aux.setProx(node);
            node.setAnt(aux);
        }
    }

    public void show(){
        Node aux = this.getBegin();
        while(aux != null)
        {
            System.out.print(aux.getInfo() + "\n");
            aux = aux.getProx();
        }
    }

    public Node exhaustiveSearch(int key){
        Node node = this.getBegin();
        while(node!=null && node.getInfo()!=key)
            node = node.getProx();
        return node;
    }

    public void remove(int key){
        Node node = this.exhaustiveSearch(key);
        if(node!=null)
        {
            Node ant = node.getAnt(), prox = node.getProx();
            if(ant==prox) //Nó encontrado é o único da lista -> ant e prox apontam para null => ant==prox
            {
                this.setBegin(null);
                this.setEnd(null);
            }
            else if(prox==null) //Nó no fim da lista
            {
                ant.setProx(prox);
                this.setEnd(ant);
            }
            else if(ant==null)  //Nó no começo da lista
            {
                prox.setAnt(ant);
                this.setBegin(prox);
            }
            else    //Nó no meio da lista
            {
                prox.setAnt(ant);
                ant.setProx(prox);
            }
        }
    }
}