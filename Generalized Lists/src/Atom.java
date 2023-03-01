public class Atom extends Node{
    private String info;

    public Atom(String info){
        setTerminal(true);
        setInfo(info);
        setNode(this);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}
