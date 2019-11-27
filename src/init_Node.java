import org.jetbrains.annotations.Contract;

import java.util.ArrayList;

public class init_Node {
    private int num_Node;
    ArrayList<String> lable_node;

    public init_Node(int num_Node, ArrayList<String> lable_node) {
        this.num_Node = num_Node;
        this.lable_node = lable_node;
    }

    public init_Node(int num_Node) {
        this.num_Node = num_Node;
    }

    public int getNum_Node() {
        return num_Node;
    }
    public void setNum_Node(int num_Node) {
        this.num_Node = num_Node;
    }

    public ArrayList<String> getLable_node() {
        return lable_node;
    }

    public void setLable_node(ArrayList<String> lable_node) {
        this.lable_node = lable_node;
    }
    public void node_init(){
        for(int i=0;i<num_Node;i++){
            lable_node.add(i,"unused");
        }
    }
    public void node_state_update(int node, String lable){
        this.lable_node.set(node,lable);
    }
}
