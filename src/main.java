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
	private ArrayList<Integer> edgeSet;
	private ArrayList<ArrayList<Integer>> edgeSpectrumRes;
	private ArrayList<Integer> channel;
	private HashMap<Integer,ArrayList<Object>> spectrumRes;
	public int st_perNode = 15;
	public int sliceable = 3;
	public int slCapacity = 400;
	public int subcCapacity = 40;
	public int FS = 25;
	public int guardband = 25;
	public int fiberCapacity = 100;
	public int stCapacity = 400;
	public int channelCapacity = 40;
	public int substChannel = 4;
	public int stChannel= 10;

	public int NodeNum;

	public int[][] DistanceMatrix = {
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

	public main(boolean transponderSearchFound,int transponder,
			boolean subtransponderSearchFound,int subtransponder, 
			ArrayList<ArrayList<String>> node_st_list, ArrayList<ArrayList<ArrayList<String>>> node_subst_list,
			HashMap<Integer, ArrayList<Integer>> pathCoded
			){		
	}
/*
* yao tianjia
* */
	public void initDisMatrix(int[][] dm){
		int[][] ConnectionMatrix = new int[dm.length][dm[0].length];
		for(int i=0;i<ConnectionMatrix.length;i++){
			for(int j=0;j<ConnectionMatrix[0].length;j++){
				if(ConnectionMatrix[i][j]!=0){
					ConnectionMatrix[i][j]=1;
				}else{
					ConnectionMatrix[i][j]=0;
				}
			}
		}
		NodeNum = ConnectionMatrix.length;
	}

	public void initNodeSTResource(){
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("Unused");
		temp.add("Unused");
		temp.add("Unused");
		for(int i=0;i<NodeNum;i++){
			ArrayList<String> nodestres = new ArrayList<>();
			ArrayList<ArrayList<String>> nodesubstres = new ArrayList<>();
			for(int j=0;j<NodeNum;j++){
				nodestres.add("Unused");
				nodesubstres.add(temp);
			}
			node_st_list.add(nodestres);
			node_subst_list.add(nodesubstres);
		}
	}

	public void initSpectrumResource(){
		for(int i=0;i<NodeNum;i++){
			for(int j=0;j<NodeNum;j++){
				spectrumRes.put(i*100+j,)
			}
		}
	}





/*
* lianmeng tianjia
* */
	public void transponderSearch(int node){
		transponderSearchFound = false;
		transponder = -1;
		//node_list.get(node).getnode_st_list.size()
		for (int i = 0; i < node_st_list.size(); i++){
			if(node_st_list.get(i).equals("unused")){
				transponderSearchFound = true;
				transponder = i;
				break;
			}
		}
	}

	
	public void subTransponderSearch(int node){
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
		if (path == null)
			path = pathCoded.get(nodei*100 + nodej);	
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
		if (path == null)
			path = pathCoded.get(nodei*100 + nodej);
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
}
