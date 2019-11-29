import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class main {
	private static boolean transponderSearchFound;
	private static int transponder;
	private boolean subtransponderSearchFound;
	private int subtransponder;		
	private  ArrayList<ArrayList<String>> node_st_list;
	private ArrayList<ArrayList<ArrayList<String>>> node_subst_list;
	private HashMap<Integer, ArrayList<Integer>> pathCoded;
	private ArrayList<ArrayList<Integer>> edgeSpectrumRes;
	private ArrayList<Integer> channel;
	private ArrayList<ArrayList<ArrayList<Object>>> spectrumRes;

	public main(boolean transponderSearchFound,int transponder,
			boolean subtransponderSearchFound,int subtransponder, 
			ArrayList<ArrayList<String>> node_st_list, ArrayList<ArrayList<ArrayList<String>>> node_subst_list,
			HashMap<Integer, ArrayList<Integer>> pathCoded
			){		
	}

	public void transponderSearch(int node){
		//Each node has a transponder. The node_st_list stores whether the transponder is used.
		transponderSearchFound = false;
		transponder = -1;
		for (int i = 0; i < node_st_list.size(); i++){
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
		for(int i = 0; i < node_subst_list.size(); i++){
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
		for(int i = 0; i < channelSet.size(); i++){
			for(int j = 0; j < edgeSet.size(); j ++){
				edgeSpectrumRes.get(j).set(channelSet.get(i), 0);
			}
		}
		int channelCount = channelSet.size();
		ArrayList<Integer> popSRList = new ArrayList<>();
		while(channelCount > 0 && spectrumRes.get(nodei *100 + nodej).size() > 0){
			for(int i = 0; i < spectrumRes.get(nodei *100 + nodej).size(); i++){
				
				ArrayList<Integer> res0 = (ArrayList<Integer>) spectrumRes.get(nodei *100 + nodej).get(i).get(0);
				int res2 = Integer.parseInt(String.valueOf(spectrumRes.get(nodei *100 + nodej).get(i).get(2)));
				
				if(path == res0 && res2 > 0){
					if(res2 >= channelCount){
						spectrumRes.get(nodei *100 + nodej).get(i).set(2, (Object)(res2 - channelCount));
						channelCount = 0;
						if(res2 == 0)
							popSRList.add(i);
						break;
					}
					else{
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
	
	
	public void spectrumSearch(int nodei, int nodej, int channelNeeded, ArrayList<Integer> path){
		if(path == null)
			path = pathCoded.get(nodei*100 + nodej);
		ArrayList<Integer> edgeSet = new ArrayList<>();

	}
	
}
