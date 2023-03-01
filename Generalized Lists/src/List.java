public class List {
    private ListGen list;

    public List(){
        setList(null);
    }

    public ListGen getList() {
        return list;
    }

    public void setList(ListGen list) {
        this.list = list;
    }

    public boolean isNull(Node list){
        return list == null;
    }

    public boolean isAtom(Node node){
        return !isNull(node) && node.isTerminal();
    }

    public void show(Node list){
        if(isAtom(list))
            System.out.print(((Atom)list).getInfo());
        else{
            System.out.print("[");
            while(!isNull(list)){
                show(((ListGen)list).getHead());
                list = ((ListGen)list).getTail();
                if(!isNull(list))
                    System.out.print(", ");
            }
            System.out.print("]");
        }
    }
        
    
}
