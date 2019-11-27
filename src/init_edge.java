import java.util.HashMap;

public class init_edge {
    private int st_perNode;  //count of sliceable transponder per node;
    HashMap<String, Float> resource = new HashMap<>();
    private int[][] ConnectionMatrix;

    public init_edge(int st_perNode, int[][] connectionMatrix) {
        this.st_perNode = st_perNode;
        this.ConnectionMatrix = connectionMatrix;
    }

    public init_edge() {
    }

    public init_edge(int st_perNode, HashMap<String, Float> resource) {
        this.st_perNode = st_perNode;
        this.resource = resource;
    }

    public int getSt_perNode() {
        return st_perNode;
    }

    public void setSt_perNode(int st_perNode) {
        this.st_perNode = st_perNode;
    }

    public HashMap<String, Float> getResource() {
        return resource;
    }

    public void setConnectionMatrix(int[][] connectionMatrix) {
        ConnectionMatrix = connectionMatrix;
    }

    /*
        修改边的权值（资源）
         */
    public void modifyResource(String s,float r){
        String[] s_d = s.split(",");
        int source_node = Integer.valueOf(s_d[0]);
        int destination_node = Integer.valueOf(s_d[1]);
        if(ConnectionMatrix[source_node][destination_node]==1){
            this.resource.put(s,r);
        }else{
            System.out.println(s+"没有连接");
        }

    }
}
