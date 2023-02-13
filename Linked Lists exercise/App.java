public class App {
    private List list;

    public App(){
        this.list = new List();
    }
    public void execute(){
        list.initialize();
        State state = new State("São Paulo", null, null);
        list.orderedStateInsertion(state);
        State state2 = new State("Paraná", null, null);
        list.orderedStateInsertion(state2);
        list.cityStateInsertion("Joinville", "Santa Catarina");
        list.cityStateInsertion("Blumenau", "Santa Catarina");
        list.showStates(list);
        list.showCities("Santa Catarina");
    }
    public static void main(String args[]){
        App app = new App();
        app.execute();
    }
}
