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
    
    public ListGen createList(String string){
        int i=1;
        ListGen list, newList= new ListGen();
        Node aux;
        list = newList;
        String info = new String("");
        while(i<string.length()){
            if(string.charAt(i)=='['){
                aux = newList.getHead();
                i++;
            }
            else if(string.charAt(i)==']'){
                newList.setTail(null);
                i++;
            }
            else if(string.charAt(i)==','){
                aux = newList.getTail();
                i++;
            }
            else if(string.charAt(i)>64){
                while(string.charAt(i)>64&&string.charAt(i)<91){
                    info = info + string.charAt(i);
                    i++;
                }
                Atom atom = new Atom(info);
                aux = newList.getHead();
            }
            else if(string.charAt(i)>96){
                while(string.charAt(i)>96&&string.charAt(i)<123){
                    info = info + string.charAt(i);
                    i++;
                }
            }
            else
                i++;
        }

    }
    
}
