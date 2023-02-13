public class List {

    private State begin;

    public List(){}

    public State getList() {
        return begin;
    }

    public void setList(State list) {
        this.begin = list;
    }

    public void initialize(){
        setList(null);
    }

    public void orderedStateInsertion(State state){
        if(this.getList()!=null)
        {
            State aux = this.getList(), prev = null;
            while(aux!=null && aux.getName().compareTo(state.getName())<0){
                prev = aux;
                aux = aux.getNext();
            } 
            if(aux!=null){
                if(prev==null)
                    setList(state);
                else
                    prev.setNext(state);
                state.setNext(aux);
            }
            else
                prev.setNext(state);
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

    public void showStates (List list){
        State aux = list.getList();
        while(aux!=null){
            System.out.println(aux.getName());
            aux = aux.getNext();
        }
    }

    public void showCities(String stateName){
        State aux = searchState(stateName);
        if(aux!=null){
            City auxCity = aux.getCities();
            while(auxCity!=null)
            {
                System.out.println(auxCity.getName());
                auxCity = auxCity.getNext();
            }
        }
        else
            System.out.println("State not found D:");
    }

    public void cityStateInsertion(String cityName, String stateName){
        if(cityStateSearch(stateName, cityName))
            System.out.println("Pair is already registered.");
        
        else if(searchState(stateName)!=null){
            System.out.println("State is already registered, recording new city...");
            City city = new City(cityName, null);
            State state = searchState(stateName);
            state.orderedCityInsertion(city);
            System.out.println("City succesfully registered!");
        }
        else
        {
            State state = new State(stateName, null, null);
            City city = new City(cityName, null);
            state.orderedCityInsertion(city);
            this.orderedStateInsertion(state);
            System.out.println("Pair succesfully registered!");
        }
    }
}
