import java.util.ArrayList;
import java.util.HashMap;

public class test {
    public static void main(String[] args) {
        int [][] dm = {
                {0,2100,3000,0,0,0,0,4800,0,0,0,0,0,0},
                {2100,0,1200,1500,0,0,0,0,0,0,0,0,0,0},
                {3000,1200,0,0,0,3600,0,0,0,0,0,0,0,0},
                {0,1500,0,0,1200,0,0,0,0,0,3900,0,0,0},
                {0,0,0,1200,0,2400,1200,0,0,0,0,0,0,0},
                {0,0,3600,0,2400,0,0,0,0,2100,0,0,0,3600},
                {0,0,0,0,1200,0,0,1500,0,2700,0,0,0,0},
                {4800,0,0,0,0,0,1500,0,1500,0,0,0,0,0},
                {0,0,0,0,0,0,0,1500,0,1500,0,600,600,0},
                {0,0,0,0,0,2100,2700,0,1500,0,0,0,0,0},
                {0,0,0,3900,0,0,0,0,0,0,0,1200,1500,0},
                {0,0,0,0,0,0,0,0,600,0,1200,0,0,600},
                {0,0,0,0,0,0,0,0,600,0,1500,0,0,300},
                {0,0,0,0,0,0,0,0,600,0,1500,0,0,300},
                {0,0,0,0,0,3600,0,0,0,0,0,600,300,0},
        };
        int[][] cm = {
                {0,2100,3000,0,0,0,0,4800,0,0,0,0,0,0},
                {2100,0,1200,1500,0,0,0,0,0,0,0,0,0,0},
                {3000,1200,0,0,0,3600,0,0,0,0,0,0,0,0},
                {0,1500,0,0,1200,0,0,0,0,0,3900,0,0,0},
                {0,0,0,1200,0,2400,1200,0,0,0,0,0,0,0},
                {0,0,3600,0,2400,0,0,0,0,2100,0,0,0,3600},
                {0,0,0,0,1200,0,0,1500,0,2700,0,0,0,0},
                {4800,0,0,0,0,0,1500,0,1500,0,0,0,0,0},
                {0,0,0,0,0,0,0,1500,0,1500,0,600,600,0},
                {0,0,0,0,0,2100,2700,0,1500,0,0,0,0,0},
                {0,0,0,3900,0,0,0,0,0,0,0,1200,1500,0},
                {0,0,0,0,0,0,0,0,600,0,1200,0,0,600},
                {0,0,0,0,0,0,0,0,600,0,1500,0,0,300},
                {0,0,0,0,0,3600,0,0,0,0,0,600,300,0},
        };
        init_topology topo = new init_topology();
        init_edge edge = new init_edge(14,cm);
        topo.setConnectionMatrix(cm);
        topo.setDistanceMatrix(dm);
        topo.topologyDistanceShow();
        topo.topologyConnectionShow();
        edge.modifyResource("0,1",10);
        edge.modifyResource("10,3",4);
        edge.modifyResource("10,2",4);
        System.out.println(edge.getResource());
        HashMap<String,Float> map = new HashMap<>();
        map = edge.getResource();
        map.put("10,3",edge.getResource().get("10,3"));
        System.out.println(map);
        ArrayList<String> lable = new ArrayList<>();
        init_Node node = new init_Node(14,lable);
        node.node_init();
        System.out.println(node.getLable_node());
        node.node_state_update(4,"used");
        System.out.println(node.getLable_node());
    }
}
