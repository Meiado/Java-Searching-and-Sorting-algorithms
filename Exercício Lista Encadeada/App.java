public class App {
    private List list;

    public App(){}
    public void execute(){
        list.initialize(list);
        State state = new State("São Paulo", null, null);
        list.orderedStateInsertion(state);
        System.out.println(list.getList().getName());
    }
    public static void main(String args[]){
        App app = new App();
        app.execute();
    }
}
