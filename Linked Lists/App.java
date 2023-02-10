public class App {
    private List list;

    public App(){}

    public void execute(){
        list = new List();
        list.initialize();
        list.beginningInsertion(0);
        list.endInsertion(1);
        list.show();
    }
    
    public static void main(String args[]){
        App app = new App();
        app.execute();
    }
}
