import java.util.HashMap;

public class init_edge {
    private int st_perNode;  //count of sliceable transponder per node;
    HashMap<Integer, Double> resource = new HashMap<>();
    private int[][] ConnectionMatrix;

    public init_edge(int st_perNode, int[][] connectionMatrix) {
        this.st_perNode = st_perNode;
        this.ConnectionMatrix = connectionMatrix;
    }

    public init_edge() {
    }

    public init_edge(int st_perNode, HashMap<Integer, Double> resource) {
        this.st_perNode = st_perNode;
        this.resource = resource;
    }

    public int getSt_perNode() {
        return st_perNode;
    }

    public void setSt_perNode(int st_perNode) {
        this.st_perNode = st_perNode;
    }

    public HashMap<Integer, Double> getResource() {
        return resource;
    }

    public void setConnectionMatrix(int[][] connectionMatrix) {
        ConnectionMatrix = connectionMatrix;
    }
    /*
        修改边的权值（资源）
         */
    public void modifyResource(int s,int FS, double FSCapacity){
        int source_node = s/100;
        int destination_node = s%100;
        if(ConnectionMatrix[source_node][destination_node]==1){
            double used_capacity = FS*FSCapacity;
            this.resource.put(s,used_capacity);
        }else{
            System.out.println(s+"没有连接");
        }
    }
}
