import java.util.ArrayList;
import java.util.HashMap;

public class main_test {
    public static void main(String[] args) {
    	ArrayList<ArrayList<String>> node_st_list = new ArrayList<>();
    	ArrayList<String> node0 = new ArrayList<>();
    	ArrayList<String> node1 = new ArrayList<>();
    	node0.add("unused");
    	node1.add("unused");
    	node_st_list.add(node0);
    	node_st_list.add(node1);
    	ArrayList<ArrayList<ArrayList<String>>> node_subst_list = new ArrayList<>();
    	ArrayList<ArrayList<String>> node2 = new ArrayList<>();
    	ArrayList<String> tran2 = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			tran2.add("unused");
		}
		node2.add(tran2);
		
    	ArrayList<ArrayList<String>> node3 = new ArrayList<>();
    	ArrayList<String> tran3 = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			tran3.add("unused");
		}
		node3.add(tran3);
		
		node_subst_list.add(node2);
		node_subst_list.add(node3);

		HashMap<Integer, ArrayList<Integer>> pathCoded = new HashMap<>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(0);
		path.add(4);
		path.add(1);
		pathCoded.put(1, path);
		main m = new main(false,-1,false,-1,node_st_list, node_subst_list, pathCoded);
		
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		tmp.set(2, 3);

		
		
    }
}
