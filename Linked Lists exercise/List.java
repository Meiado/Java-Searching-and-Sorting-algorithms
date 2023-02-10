public class List {

    private State list;

    public List(){}

    public State getList() {
        return list;
    }

    public void setList(State list) {
        this.list = list;
    }

    public void initialize(List list){
        setList(null);
    }

    public void orderedStateInsertion(State state){
        if(this.getList()!=null)
        {
            State aux = this.getList();
            while(aux.getNext()!=null && aux.getName().compareToIgnoreCase(state.getName())>0)
                aux = aux.getNext();
            if(aux.getNext()!=null)
                state.setNext(aux.getNext());
            aux.setNext(state);
        }
        else
            setList(state);
    }

    public State searchState(String name){
        State state = this.getList();
        while(state!=null && state.getName()!=name)
            state = state.getNext();
        return state;
    }

    public boolean cityStateSearch(String state, String city){
        State aux = searchState(state);
        if(aux!=null)
        {
            City auxCity = aux.searchCity(city);
            if(auxCity!=null)
                return true;
        }
        return false;
    }
}
