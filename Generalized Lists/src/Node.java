public class Node {
    private boolean terminal;
    private Node node;
    
    public boolean isTerminal() {
        return terminal;
    }
    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }
    
    public Node getNode() {
        return node;
    }
    public void setNode(Node node) {
        this.node = node;
    }
}
