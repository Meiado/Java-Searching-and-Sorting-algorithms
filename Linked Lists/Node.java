public class Node {
    private Node ant;
    private Node prox;
    private int info;

    public void setAnt(Node ant){
        this.ant = ant;
    }
    public Node getAnt(){
        return this.ant;
    }
    public void setProx(Node prox){
        this.prox = prox;
    }
    public Node getProx(){
        return this.prox;
    }
    public void setInfo(int info){
        this.info = info;
    }
    public int getInfo(){
        return this.info;
    }
    public Node(Node ant, Node prox, int info){
        setAnt(ant);
        setProx(prox);
        setInfo(info);
    }
}
