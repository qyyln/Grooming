import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class mainLian {
	
	private static boolean transponderSearchFound;
	private static int transponder;
	private boolean subtransponderSearchFound;
	private int subtransponder;		
	private  ArrayList<ArrayList<String>> node_st_list;
	private ArrayList<ArrayList<ArrayList<String>>> node_subst_list;
	private HashMap<Integer, ArrayList<Integer>> pathCoded;
	private HashMap<Integer, ArrayList<Integer>> edgeSpectrumRes;
//	private ArrayList<Integer> channel;
	private HashMap<Integer, ArrayList<ArrayList<Object>>> spectrumRes;
	private int fiberCapacity = 3;
	private boolean spectrumSearch;
	private ArrayList<Integer> spectrumSearchResule;
	
	public mainLian(){		
	}
	
	public static boolean isTransponderSearchFound() {
		return transponderSearchFound;
	}

	public static void setTransponderSearchFound(boolean transponderSearchFound) {
		mainLian.transponderSearchFound = transponderSearchFound;
	}

	public static int getTransponder() {
		return transponder;
	}

	public static void setTransponder(int transponder) {
		mainLian.transponder = transponder;
	}

	public boolean isSubtransponderSearchFound() {
		return subtransponderSearchFound;
	}

	public void setSubtransponderSearchFound(boolean subtransponderSearchFound) {
		this.subtransponderSearchFound = subtransponderSearchFound;
	}

	public int getSubtransponder() {
		return subtransponder;
	}

	public void setSubtransponder(int subtransponder) {
		this.subtransponder = subtransponder;
	}

	public ArrayList<ArrayList<String>> getNode_st_list() {
		return node_st_list;
	}

	public void setNode_st_list(ArrayList<ArrayList<String>> node_st_list) {
		this.node_st_list = node_st_list;
	}

	public ArrayList<ArrayList<ArrayList<String>>> getNode_subst_list() {
		return node_subst_list;
	}

	public void setNode_subst_list(ArrayList<ArrayList<ArrayList<String>>> node_subst_list) {
		this.node_subst_list = node_subst_list;
	}

	public HashMap<Integer, ArrayList<Integer>> getPathCoded() {
		return pathCoded;
	}

	public void setPathCoded(HashMap<Integer, ArrayList<Integer>> pathCoded) {
		this.pathCoded = pathCoded;
	}

	public HashMap<Integer, ArrayList<Integer>> getEdgeSpectrumRes() {
		return edgeSpectrumRes;
	}

	public void setEdgeSpectrumRes(HashMap<Integer, ArrayList<Integer>> edgeSpectrumRes) {
		this.edgeSpectrumRes = edgeSpectrumRes;
	}

	public HashMap<Integer, ArrayList<ArrayList<Object>>> getSpectrumRes() {
		return spectrumRes;
	}

	public void setSpectrumRes(HashMap<Integer, ArrayList<ArrayList<Object>>> spectrumRes) {
		this.spectrumRes = spectrumRes;
	}

	public int getFiberCapacity() {
		return fiberCapacity;
	}

	public void setFiberCapacity(int fiberCapacity) {
		this.fiberCapacity = fiberCapacity;
	}

	public void init(){
    	ArrayList<ArrayList<String>> node_st_list = new ArrayList<>();
    	//node_st_list = [["unused"],["unused"]]
    	ArrayList<String> node0 = new ArrayList<>();
    	ArrayList<String> node1 = new ArrayList<>();
    	node0.add("unused");
    	node1.add("unused");
    	node_st_list.add(node0);
    	node_st_list.add(node1);
    	this.node_st_list = node_st_list;
    	
    	ArrayList<ArrayList<ArrayList<String>>> node_subst_list = new ArrayList<>();
    	//node_subst_list = [ [["unused", "unused", "unused"]],[["unused"], ["unused"], ["unused"]] ]
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
		this.node_subst_list = node_subst_list;


				
		HashMap<Integer, ArrayList<Integer>> pathCoded = new HashMap<>();
		//pathCoded = [1:[0,4,1]]
		ArrayList<Integer> path = new ArrayList<Integer>();
		path.add(0);
		path.add(4);
		path.add(1);
		pathCoded.put(1, path);
		this.pathCoded = pathCoded;
		
		
		HashMap<Integer, ArrayList<Integer>> edgeSpectrumRes = new HashMap<>();
		//edgeSpectrumRes = [4:[1,1,1,1],400:[1,1,1,1], 401: [1,1,1,1], 104:[1,1,1,1]]
		//channelset.size() is 4
    	ArrayList<Integer> channelset = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			channelset.add(1);
		}
		edgeSpectrumRes.put(4, channelset);
		edgeSpectrumRes.put(400, channelset);
		edgeSpectrumRes.put(401, channelset);
		edgeSpectrumRes.put(104, channelset);
		this .edgeSpectrumRes = edgeSpectrumRes;
		//System.out.println(edgeSpectrumRes);
		
		HashMap<Integer, ArrayList<ArrayList<Object>>> spectrumRes = new HashMap<>();
		//spectrumRes = [1:   [[0,4,1],null,8]   ]
		//Start and end node, path, null, used light resources
		ArrayList<ArrayList<Object>> spectrum = new ArrayList<ArrayList<Object>>();
		ArrayList<Object> node = new ArrayList<>();
		ArrayList<Integer> p = new ArrayList<>();
		p.add(0);
		p.add(4);
		p.add(1);
		node.add(p);
		node.add(null);
		node.add(8);
		spectrum.add(node);
		spectrumRes.put(1, spectrum);
		this.spectrumRes = spectrumRes;
	}
	
	public void transponderSearch(int node){
		//Each node has a transponder. The node_st_list stores whether the transponder is used.
		transponderSearchFound = false;
		transponder = -1;
		for (int i = 0; i < node_st_list.get(node).size(); i++){
			if(node_st_list.get(i).equals("unused")){
				transponderSearchFound = true;
				transponder = i;
				break;
			}
		}
	}

	
	public void subTransponderSearch(int node){
		//Each node has a transponder. A transponder can be divided into three subtransponders. 
		//Node_subst_list stores whether each subtransponder is used.
		subtransponderSearchFound = false;
		transponder = -1;
		subtransponder = -1;
		for(int i = 0; i < node_subst_list.get(node).size(); i++){
			for(int j = 0; j < node_subst_list.get(node).get(i).size(); j++){
				if(node_subst_list.get(node).get(i).get(j).equals("unused")){
					subtransponderSearchFound = true;
					transponder = i;
					subtransponder = j;
					break;
				}
			}
		}	
	}
	
	
	public void transponderTake(int node, int transponder){		
		node_st_list.get(node).set(transponder, "used");
		ArrayList<String> st = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			st.add("used");
		}
		node_subst_list.get(node).set(transponder, st );				
	}
	
	
	public void subtransponderTake(int node, int transponder, int subt){
		node_subst_list.get(node).get(transponder).set(subt, "used");
		node_st_list.get(node).set(transponder, "used");
	}
	
	
	public void transponderRelease(int node, int transponder){
		node_st_list.get(node).set(transponder, "unused");
		ArrayList<String> st = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			st.add("unused");
		}
		node_subst_list.get(node).set(transponder, st);				
	}
	
	
	public void subtransponderRelease(int node, int transponder, int subt){
		ArrayList<String> st = new ArrayList<>();
		for(int i = 0; i < 3; i++){
			st.add("unused");
		}
		node_subst_list.get(node).set(transponder, st);				
		boolean used =false;
		for(int i = 0; i < node_subst_list.get(node).size(); i++){
			if( node_subst_list.get(node).get(transponder).equals("used")){
				used = true;
				break;
			}
		}
		if(used == false)
			node_st_list.get(node).set(transponder, "unused");
	}
	
	
	public void spectrumTake(int nodei, int nodej, ArrayList<Integer> channelSet, ArrayList<Integer> path){
		//All the edges between ij are stored in edgeSet, marked as start * 100 + end
		//edgeSpectrumRes holds the usage of each edge channel
		if (path == null)
			path = pathCoded.get(nodei*100 + nodej);
		ArrayList<Integer> edgeSet = new ArrayList<>();
		for(int i = 0; i < path.size() - 1; i++){
			edgeSet.add(path.get(i)*100 + path.get(i + 1));
			edgeSet.add(path.get(i + 1)*100 + path.get(i));
		}
		for(int i = 0; i < channelSet.size(); i++){
			for(int j = 0; j < edgeSet.size(); j ++){
				edgeSpectrumRes.get(j).set(channelSet.get(i), 1);
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void spectrumRelease(int nodei, int nodej, ArrayList<Integer> channelSet, ArrayList<Integer> path){
		//First set the corresponding resource in edgeSpectrumRes to 0
		//spectrumRes holds the spectrum usage between each node pair ij. 
		//spectrumRes.get (nodei * 100 + nodej) .get (i) .get (0) saves the path before ij, 
		//spectrumRes.get (nodei * 100 + nodej) .get (i) .get (2) saves the amount of spectrum used 
		if (path == null)
			path = pathCoded.get(nodei*100 + nodej);
		ArrayList<Integer> edgeSet = new ArrayList<>();
		for(int i = 0; i < path.size() - 1; i++){
			edgeSet.add(path.get(i)*100 + path.get(i + 1));
			edgeSet.add(path.get(i + 1)*100 + path.get(i));
		}
		//System.out.println("edgeSet:" + edgeSet);
		//System.out.println("channelSet:" + channelSet);
		//System.out.println("edgeSpectrumRes:" + edgeSpectrumRes);
		for(int i = 0; i < channelSet.size(); i++){
			for(int j = 0; j < edgeSet.size(); j ++){
				//System.out.println("edgeSpectrumRes.get(edgeSet.get(j)):" + edgeSpectrumRes.get(edgeSet.get(j)));
				edgeSpectrumRes.get(edgeSet.get(j)).set(channelSet.get(i), 0);
			}
		}
		
		int channelCount = channelSet.size();
		ArrayList<Integer> popSRList = new ArrayList<>();
		while(channelCount > 0 && spectrumRes.get(nodei *100 + nodej).size() > 0){
			for(int i = 0; i < spectrumRes.get(nodei *100 + nodej).size(); i++){
				//System.out.println("channelCount:" +channelCount);
				//System.out.println("spectrumRes.get(nodei *100 + nodej:" +spectrumRes.get(nodei *100 + nodej));
				ArrayList<Integer> res0 = (ArrayList<Integer>) spectrumRes.get(nodei *100 + nodej).get(i).get(0);
				//System.out.println("res0:" +res0);
				//System.out.println("path:" +path);
				//System.out.println("path == res0?:" +(compare(path, res0)));
				int res2 = Integer.parseInt(String.valueOf(spectrumRes.get(nodei *100 + nodej).get(i).get(2)));
				//System.out.println("res2:" +res2);
				
				if((compare(path, res0)) && res2 > 0){
					if(res2 >= channelCount){
						//Only occupy one channel
						spectrumRes.get(nodei *100 + nodej).get(i).set(2, (Object)(res2 - channelCount));
						channelCount = 0;
						if(res2 == 0)
							popSRList.add(i);
						break;
					}
					else{
						//Occupies multiple channels
						channelCount -= res2;
						spectrumRes.get(nodei *100 + nodej).get(i).set(2, (Object)0);
						popSRList.add(i);
					}
					
				}
			}
		}
		Collections.reverse(popSRList);
		for(int i = 0; i < popSRList.size(); i++){
			spectrumRes.remove(popSRList.get(i));
		}
	}
	public static <T extends Comparable<T>> boolean compare(ArrayList<T> a, ArrayList<T> b) {
		//Determine if the lists are equal
		  if(a.size() != b.size())
		    return false;
		  for(int i=0;i<a.size();i++){
		    if(!a.get(i).equals(b.get(i)))
		      return false;
		  }
		  return true;
		}
	
	
	public void spectrumSearch(int nodei, int nodej, int channelNeeded, ArrayList<Integer> path){
		if(path == null)
			path = pathCoded.get(nodei*100 + nodej);
//		System.out.println("path:" + path);
		ArrayList<Integer> edgeSet = new ArrayList<>();
		for(int i = 0; i < path.size() - 1; i++){
			edgeSet.add(path.get(i)*100 + path.get(i + 1));
			edgeSet.add(path.get(i + 1)*100 + path.get(i));
		}
		ArrayList<Integer> channelSet = new ArrayList<Integer>();
		int channelFound = 0;
		for(int channel = 0; channel < fiberCapacity; channel++){
			if(channelFound > channelNeeded - 1)
				break;
			boolean channelFree = true;
			for(int edge : edgeSet){
//				System.out.println("edgeSpectrumRes:" + edgeSpectrumRes);
//				System.out.println("edgeSet:" + edgeSet);
//				System.out.println("edgeSpectrumRes:" + edgeSpectrumRes);
				if(this.edgeSpectrumRes.get(edge).get(channel) == 1){
					channelFree = false;
					break;
				}
			}
			if(channelFree == true){
				channelFound = channelFound + 1;
				channelSet.add(channel);
			}
		}
		if(channelFound == channelNeeded){
			this.spectrumSearch = true;
			this.spectrumSearchResule = channelSet;
			System.out.println("spectrumAvailable");

		}
		else{
			this.spectrumSearch = false;
			this.spectrumSearchResule = null;
			System.out.println("spectrumUnavailable");
		}
		
	}
	
}
