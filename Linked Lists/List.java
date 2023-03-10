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

    public void directInsertion(){
        Node node = getBegin().getNext(), aux;
        int info;
        while(node!=getEnd()){
            info = node.getInfo();
            aux = node;
            while(aux!=getBegin()&& aux.getInfo()<node.getPrev().getInfo()){
                aux.setInfo(aux.getPrev().getInfo());
                aux = aux.getPrev();
            }
            aux.setInfo(info);
            node = node.getNext();
        }
    }


    public int getNumberNodes(Node begin,Node end){
        int count=0;
        Node aux = end;
        while(aux!=begin){
            aux = aux.getPrev();
            count++;
        }
        
        return count;
    }

    public Node setMid(Node begin, int midPos)
    {
        Node aux = begin;
        while(midPos>0){
            aux = aux.getNext();
            midPos--;
        }
        return aux;
    }

    public Node binarySearch(Node begin, Node end, int key){
        Node mid;
        int endPos = getNumberNodes(begin, end)-1, beginPos = 0, midPos = endPos/2;
        mid = setMid(begin, midPos);
        while(end.getInfo()>begin.getInfo() && key!=mid.getInfo()){
            if(key>mid.getInfo()){
                begin = mid.getNext();
                beginPos = midPos+1;
            }
            else{
                end = mid.getPrev();
                endPos = midPos-1;
            }
            midPos = (endPos+beginPos)/2;
            mid = setMid(begin, midPos);
        }
        if(key>mid.getInfo())
            return mid.getNext();
        return mid;
    }

    public void binaryInsertion(){
        int info;
        Node endPoint, change, insert;
        for(endPoint = getBegin().getNext(); endPoint!=getEnd(); endPoint = endPoint.getNext()){
            info = endPoint.getInfo();
            insert = binarySearch(getBegin(), endPoint, info);
            for(change=endPoint;change!=insert;change=change.getNext())
                change.setInfo(change.getPrev().getInfo());
            insert.setInfo(info);
        }
    }

    public void bubbleSort(){
        boolean flag = false;
        int info;
        Node endPoint = getEnd(), node;
        while(endPoint!=getBegin().getNext()&&!flag){
            for(node = getBegin(); node!=endPoint; node = node.getNext()){
                flag = true;
                if(node.getInfo()>node.getNext().getInfo()){
                    info = node.getInfo();
                    node.setInfo(node.getNext().getInfo());
                    node.getNext().setInfo(info);
                    flag = false;
                }
            }
            endPoint = endPoint.getPrev();
        }
    }

    public void shakeSort(){
        int info;
        Node startPoint = getBegin(), endPoint = getEnd(), node;
        while(startPoint!=endPoint){
            for(node=startPoint;node!=endPoint;node=node.getNext())
            {
                if(node.getInfo()>node.getNext().getInfo()){
                    info = node.getInfo();
                    node.setInfo(node.getNext().getInfo());
                    node.getNext().setInfo(info);
                }
            }
            endPoint = endPoint.getPrev();
            for(node=endPoint;node!=startPoint;node = node.getPrev()){
                if(node.getInfo()<node.getPrev().getInfo()){
                    info = node.getInfo();
                    node.setInfo(node.getPrev().getInfo());
                    node.getPrev().setInfo(info);
                }
            }
            startPoint = startPoint.getNext();
        }
    }

    public void heapSort(){

    }
    public Node setNextPosition(Node start, int n){
        Node pos = start;
        while(pos!=null&&n>0){
            pos=pos.getNext();
            n--;
        }
        return pos;
    }
    public Node setPrevPosition(Node start, int n){
        Node pos = start;
        while(pos!=null&&n>0){
            pos=pos.getPrev();
            n--;
        }
        return pos;
    }
    public void shellSort(int dist){
        int info,j,k;
        Node nodeI=getBegin(), nodeJ, nodeK, next, prev;
        while(dist>0){
            for(int i=0;i<dist;i++){
                for(nodeJ=nodeI,j=i;setNextPosition(nodeJ,dist)!=null;j+=dist){
                    next = setNextPosition(nodeJ, dist);
                    info = nodeJ.getInfo();
                    nodeJ.setInfo(next.getInfo());
                    next.setInfo(info);
                    for(nodeK=nodeJ,k=j,prev=setPrevPosition(nodeK, dist);k-dist>=0&&nodeK.getInfo()<prev.getInfo();k-=dist){
                        info = prev.getInfo();
                        prev.setInfo(nodeK.getInfo());
                        nodeK.setInfo(info);
                        nodeK = prev;
                        prev = setPrevPosition(nodeK, dist);
                    }
                    nodeJ = next;
                }
                nodeI=nodeI.getNext();
            }
            dist/=2;
        }
    }
}