import java.util.*;

public class mainIntegration {

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
    private int fiberCapacity = 4;
    private boolean spectrumSearchBooleanReturn;
    private ArrayList<Integer> spectrumSearchArrayListReturn;
    private String SR = "SRLP";
    private int substChannel = 4;
    private boolean spectrumReserveBooleanReturn;
    private int spectrumReserveIntReturn;
    public int st_perNode = 15;
    public int sliceable = 3;
    public int slCapacity = 400;
    public int subcCapacity = 40;
    public int FS = 25;
    public int guardband = 25;
    public int stCapacity = 400;
    public int channelCapacity = 40;
    public int stChannel = 10;
    public int[][] ConnectionMatrix;
    public HashMap<Integer, ArrayList<ArrayList<Object>>> lightPathRes;
    public ArrayList<ArrayList<Object>> servList;
    public int activeService;

    private double dis_ShortestPath;
    private ArrayList<Integer> pathij_ShortestPath;
    private ArrayList<Double> returnDistanceList_KshortestPath;
    private ArrayList<ArrayList<Integer>> returnPathList_KshortestPath;
    private double ELP_edgeWeight;
    private double PLP_edgeWeight;
    private double PSubLP_edgeWeight;

    GroomingPolicy groomingPolicy = new GroomingPolicy();


    public int NodeNum;

    public int[][] DistanceMatrix = {
            {0, 2100, 3000, 0, 0, 0, 0, 4800, 0, 0, 0, 0, 0, 0},
            {2100, 0, 1200, 1500, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {3000, 1200, 0, 0, 0, 3600, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1500, 0, 0, 1200, 0, 0, 0, 0, 0, 3900, 0, 0, 0},
            {0, 0, 0, 1200, 0, 2400, 1200, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 3600, 0, 2400, 0, 0, 0, 0, 2100, 0, 0, 0, 3600},
            {0, 0, 0, 0, 1200, 0, 0, 1500, 0, 2700, 0, 0, 0, 0},
            {4800, 0, 0, 0, 0, 0, 1500, 0, 1500, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1500, 0, 1500, 0, 600, 600, 0},
            {0, 0, 0, 0, 0, 2100, 2700, 0, 1500, 0, 0, 0, 0, 0},
            {0, 0, 0, 3900, 0, 0, 0, 0, 0, 0, 0, 1200, 1500, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 600, 0, 1200, 0, 0, 600},
            {0, 0, 0, 0, 0, 0, 0, 0, 600, 0, 1500, 0, 0, 300},
            {0, 0, 0, 0, 0, 3600, 0, 0, 0, 0, 0, 600, 300, 0},
    };

    public mainIntegration(){

    }

    public static boolean isTransponderSearchFound() {
        return transponderSearchFound;
    }

    public static void setTransponderSearchFound(boolean transponderSearchFound) {
        mainIntegration.transponderSearchFound = transponderSearchFound;
    }

    public static int getTransponder() {
        return transponder;
    }

    public static void setTransponder(int transponder) {
        mainIntegration.transponder = transponder;
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



    public boolean isSpectrumSearchBooleanReturn() {
        return spectrumSearchBooleanReturn;
    }

    public void setSpectrumSearchBooleanReturn(boolean spectrumSearchBooleanReturn) {
        this.spectrumSearchBooleanReturn = spectrumSearchBooleanReturn;
    }

    public ArrayList<Integer> getSpectrumSearchArrayListReturn() {
        return spectrumSearchArrayListReturn;
    }

    public void setSpectrumSearchArrayListReturn(ArrayList<Integer> spectrumSearchArrayListReturn) {
        this.spectrumSearchArrayListReturn = spectrumSearchArrayListReturn;
    }

    public String getSR() {
        return SR;
    }


    public int getSubstChannel() {
        return substChannel;
    }

    public void setSubstChannel(int substChannel) {
        this.substChannel = substChannel;
    }

    public boolean isSpectrumReserveBooleanReturn() {
        return spectrumReserveBooleanReturn;
    }

    public void setSpectrumReserveBooleanReturn(boolean spectrumReserveBooleanReturn) {
        this.spectrumReserveBooleanReturn = spectrumReserveBooleanReturn;
    }

    public int getSpectrumReserveIntReturn() {
        return spectrumReserveIntReturn;
    }

    public void setSpectrumReserveIntReturn(int spectrumReserveIntReturn) {
        this.spectrumReserveIntReturn = spectrumReserveIntReturn;
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
        //spectrumRes = [1:   [[[0,4,1],4,8]]   ]
        //Start and end node, path, substChannel, used light resources
        ArrayList<ArrayList<Object>> spectrum = new ArrayList<ArrayList<Object>>();
        ArrayList<Object> node = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        p.add(0);
        p.add(4);
        p.add(1);
        node.add(p);
        node.add(4);
        node.add(8);
        spectrum.add(node);
        spectrumRes.put(1, spectrum);
        this.spectrumRes = spectrumRes;
        //System.out.print(spectrumRes);
    }
    /*
    * yao tianjia
    *
    * */
    public void initDisMatrix(int[][] dm) {
        ConnectionMatrix=new int[dm.length][dm[0].length];
        for (int i = 0; i < dm.length; i++) {
            for (int j = 0; j < dm[0].length; j++) {
                if (dm[i][j] != 0) {
                    ConnectionMatrix[i][j] = 1;
                } else {
                    ConnectionMatrix[i][j] = 0;
                }
                System.out.print(ConnectionMatrix[i][j]);
            }
            System.out.println();
        }
        NodeNum = ConnectionMatrix.length;
    }

    public void initNodeSTResource() {
        node_st_list = new ArrayList<>();
        node_subst_list = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<String>();
        temp.add("Unused");
        temp.add("Unused");
        temp.add("Unused");
        for (int i = 0; i < NodeNum; i++) {
            ArrayList<String> nodestres = new ArrayList<>();
            ArrayList<ArrayList<String>> nodesubstres = new ArrayList<>();
            for (int j = 0; j < NodeNum; j++) {
                nodestres.add("Unused");
                nodesubstres.add(temp);
            }
            node_st_list.add(nodestres);
            node_subst_list.add(nodesubstres);
        }
        System.out.println(node_st_list);
        System.out.println(node_subst_list);
    }

    public void initSpectrumResource() {
        edgeSpectrumRes = new HashMap<>();
        spectrumRes = new HashMap<>();
        for (int i = 0; i < NodeNum; i++) {
            for (int j = 0; j < NodeNum; j++) {
                ArrayList<ArrayList<Object>> list = new ArrayList<>();
                spectrumRes.put(i * 100 + j, list);
                if (i != j) {
                    if (ConnectionMatrix[i][j] == 1) {
                        ArrayList<Integer> list1 = new ArrayList<>();
                        edgeSpectrumRes.put(i * 100 + j, list1);
                    }
                }
            }
        }
        System.out.println(spectrumRes);
        System.out.println(edgeSpectrumRes);
    }

    public void initLightPathResource() {
        lightPathRes = new HashMap<>();
        for (int i = 0; i < NodeNum; i++) {
            for (int j = 0; j < NodeNum; j++) {
                ArrayList<ArrayList<Object>> list = new ArrayList<>();
                lightPathRes.put(i * 100 + j, list);
            }
        }
        System.out.println(lightPathRes);
    }

    public void initServiceList() {
        servList = new ArrayList<>();
    }

    public void setSR(String s) {
        SR = s;
    }

    public void updateServiceList() {
        for (int i = 0; i < servList.size() - 1; i++) {
            ArrayList<Object> temp = new ArrayList<>();
            for (int j = 1; j < servList.size(); j++) {
                if ((int)servList.get(j).get(6) > (int)servList.get(i).get(6)) {
                    temp = servList.get(j);
                    servList.set(j, servList.get(i));
                    servList.set(i, temp);
                }
            }
        }
    }

    public void autoStopServivice(int currClock) {
        updateServiceList();
        int stopCount = 0;
        for (int i = 0; i < servList.size(); i++) {
            if ((int)servList.get(i).get(6) < currClock) {
                stopCount++;
                stopService((int)servList.get(i).get(0), (int)servList.get(i).get(1), (int)servList.get(i).get(3), (ArrayList<ArrayList<Object>>)servList.get(i).get(2), (int)servList.get(i).get(5));
            }
        }
        System.out.println("  " + stopCount + "services have been stopped in this second");
    }

    /*
    * yao tianjia end
    * */


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
        // there may be many paths between ij, so we set i
        if (path == null)
            path = pathCoded.get(nodei*100 + nodej);
        ArrayList<Integer> edgeSet = new ArrayList<>();
        for(int i = 0; i < path.size() - 1; i++){
            edgeSet.add(path.get(i)*100 + path.get(i + 1));
            edgeSet.add(path.get(i + 1)*100 + path.get(i));
        }
        for(int i = 0; i < channelSet.size(); i++){
            for(int j = 0; j < edgeSet.size(); j ++){
                edgeSpectrumRes.get(edgeSet.get(j)).set(channelSet.get(i), 0);
            }
        }
        int channelCount = channelSet.size();
        ArrayList<Integer> popSRList = new ArrayList<>();
        while(channelCount > 0 && spectrumRes.get(nodei *100 + nodej).size() > 0){
            for(int i = 0; i < spectrumRes.get(nodei *100 + nodej).size(); i++){
                ArrayList<Integer> res0 = (ArrayList<Integer>) spectrumRes.get(nodei *100 + nodej).get(i).get(0);
                int res2 = Integer.parseInt(String.valueOf(spectrumRes.get(nodei *100 + nodej).get(i).get(2)));
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
            for(int edge : edgeSet){//				System.out.println("edgeSpectrumRes:" + edgeSpectrumRes);
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
            this.spectrumSearchBooleanReturn = true;
            this.spectrumSearchArrayListReturn = channelSet;
            System.out.println("spectrumAvailable");
        }
        else{
            this.spectrumSearchBooleanReturn = false;
            this.spectrumSearchArrayListReturn = null;
            System.out.println("spectrumUnavailable");
        }
    }


    public void spectrumReserve(int nodei, int nodej, int channelNeeded, ArrayList<Integer> path, String LorSub){
        if(path == null)
            path = pathCoded.get(nodei*100 + nodej);
        if(SR.equals("SRLP")){
            if(LorSub.equals("sub")){
                ArrayList<Object> tmp = new ArrayList<>();
                tmp.add(path);
                tmp.add(substChannel);
                tmp.add(0);
                spectrumRes.get(nodei *100 + nodej).add(tmp);
                spectrumReserveBooleanReturn = true;
                spectrumReserveIntReturn = 1;
                return;
            }
            if(LorSub.equals("1")){
                ArrayList<Object> tmp = new ArrayList<>();
                tmp.add(path);
                tmp.add(substChannel);
                tmp.add(0);
                spectrumRes.get(nodei *100 + nodej).add(tmp);
                spectrumRes.get(nodei *100 + nodej).add(tmp);
                spectrumRes.get(nodei *100 + nodej).add(tmp);
                spectrumReserveBooleanReturn = true;
                spectrumReserveIntReturn = 3;
                return;
            }
        }
        if(SR.equals("SRNP")){
            boolean usedUp = false;
            int leftChannel = 0;
            for(ArrayList<Object> specRes : spectrumRes.get(nodei * 100 + nodej)){
                if((Integer)specRes.get(1) - (Integer)specRes.get(2) > 0){
                    leftChannel = leftChannel + (Integer)specRes.get(1) - (Integer)specRes.get(2);
                }
            }
            if(leftChannel < channelNeeded ){
                usedUp = true;
            }
            if(usedUp == true){
                int moreNeeded = channelNeeded - leftChannel;
                int moreCount = 0;
                while(moreNeeded > 0){
                    ArrayList<Object> tmp = new ArrayList<>();
                    tmp.add(path);
                    tmp.add(substChannel);
                    tmp.add(0);
                    spectrumRes.get(nodei *100 + nodej).add(tmp);
                    moreNeeded = moreNeeded - substChannel;
                    moreCount = moreCount + 1;
                }
                spectrumReserveBooleanReturn = true;
                spectrumReserveIntReturn = moreCount;
                return;
            }
            else{
                spectrumReserveBooleanReturn = false;
                spectrumReserveIntReturn = 0;
                return;
            }
        }
    }

    public boolean addLightPath(int nodei, int nodej, int capacity, boolean takeTransponder, ArrayList<Integer> path) {
        if (path.size() == 0) {
            path = pathCoded.get(nodei*100+nodej);
        }
        System.out.println(path);
        int channelNeeded = (((capacity+80-1)/80+10-1)/10)*10;   //QPSK 40*2=80;
        while(channelNeeded>0){
            int currentChannelNeeded = 10;
            channelNeeded = channelNeeded - currentChannelNeeded;
            spectrumSearch(nodei,nodej,currentChannelNeeded,path); //you liang ge fanhuizhi
            if(!spectrumSearchBooleanReturn) return false;
            spectrumTake(nodei,nodej,spectrumSearchArrayListReturn,path);
            spectrumReserve(nodei,nodej,currentChannelNeeded,path,"l");//you liang ge fanhuizhi
            ArrayList<Object> list = new ArrayList<>();
            list.add(path);
            list.add(stChannel*channelCapacity);
            list.add(0);
            list.add(spectrumReserveIntReturn);
            list.add("l");
            lightPathRes.get(nodei*100+nodej).add(list);
            if(spectrumReserveBooleanReturn){
                while(spectrumReserveBooleanReturn && spectrumReserveIntReturn>0){
                    System.out.println("newlyreserve"+spectrumReserveIntReturn);
                    if(currentChannelNeeded>substChannel){
                        boolean subtxFound = false;
                        int transpondertx = 0;
                        int subtx = 0;
                        boolean subrxFound = false;
                        int transponderrx =0;
                        int subrx = 0;
                        if(takeTransponder){
                            subTransponderSearch(nodei);
                            if(!subtxFound)return false;
                            subTransponderSearch(nodej);
                            if(!subrxFound) return false;
                            subtransponderTake(nodei,transpondertx,subtx);
                            subtransponderTake(nodej,transponderrx,subrx);
                        }
                        System.out.println("partOnel"+currentChannelNeeded);
                        Object x = spectrumRes.get(nodei*100+nodej).get(spectrumRes.get(nodei*100+nodej).size()-spectrumReserveIntReturn).get(2);
                        int y = (int) x + substChannel;
                        spectrumRes.get(nodei*100+nodej).get(spectrumRes.get(nodei*100+nodej).size()-spectrumReserveIntReturn).set(2,y);
                        spectrumReserveIntReturn = spectrumReserveIntReturn-1;
                        currentChannelNeeded -= substChannel;
                        list.add("subtx");
                        ArrayList<Integer> tx = new ArrayList<>();
                        tx.add(nodei);
                        tx.add(transpondertx);
                        tx.add(subtx);
                        list.add(tx);
                        list.add("subrx");
                        ArrayList<Integer> rx = new ArrayList<>();
                        rx.add(nodei);
                        rx.add(transponderrx);
                        rx.add(subrx);
                        list.add(rx);
                        lightPathRes.get(nodei*100+nodej).set(lightPathRes.size()-1,list);
                    }
                    else{
                        boolean subtxFound = false;
                        int transpondertx = 0;
                        int subtx = 0;
                        boolean subrxFound = false;
                        int transponderrx =0;
                        int subrx = 0;
                        if(takeTransponder){
                            subTransponderSearch(nodei);
                            if(!subtxFound)return false;
                            subTransponderSearch(nodej);
                            if(!subrxFound) return false;
                            subtransponderTake(nodei,transpondertx,subtx);
                            subtransponderTake(nodej,transponderrx,subrx);
                        }
                        System.out.println("partOne2"+currentChannelNeeded);
                        Object x = spectrumRes.get(nodei*100+nodej).get(spectrumRes.get(nodei*100+nodej).size()-spectrumReserveIntReturn).get(2);
                        int y = (int) x + substChannel;
                        spectrumRes.get(nodei*100+nodej).get(spectrumRes.get(nodei*100+nodej).size()-spectrumReserveIntReturn).set(2,y);
                        spectrumReserveIntReturn = spectrumReserveIntReturn-1;
                        currentChannelNeeded = 0;
                        list.add("subtx");
                        ArrayList<Integer> tx = new ArrayList<>();
                        tx.add(nodei);
                        tx.add(transpondertx);
                        tx.add(subtx);
                        list.add(tx);
                        list.add("subrx");
                        ArrayList<Integer> rx = new ArrayList<>();
                        rx.add(nodei);
                        rx.add(transponderrx);
                        rx.add(subrx);
                        list.add(rx);
                        lightPathRes.get(nodei*100+nodej).set(lightPathRes.size()-1,list);
                    }
                }
            }
            for(int i=0;i<spectrumRes.get(nodei*100+nodej).size();i++){
                Object x = spectrumRes.get(nodei*100+nodej).get(i).get(1);
                Object y = spectrumRes.get(nodei*100+nodej).get(i).get(2);
                if((int)x-(int)y>0){
                    if(currentChannelNeeded>((int)x-(int)y)){
                        currentChannelNeeded -= ((int)x-(int)y);
                        spectrumRes.get(nodei*100+nodej).get(i).set(2,(int)x);
                    }
                    else{
                        spectrumRes.get(nodei*100+nodej).get(i).set(2,(int)y+currentChannelNeeded);
                    }
                }
            }
        }
        return true;
    }

    public boolean addSubLightPath(int nodei,int nodej,int capacity, boolean takeTransponder, ArrayList<Integer> path){
        if(path==null){
            path = pathCoded.get(nodei*100+nodej);
        }
        int channelNeeded = (((capacity+80-1)/80+4-1)/4)*4;
        spectrumSearch(nodei,nodej,channelNeeded,path);
        if(!spectrumSearchBooleanReturn)return false;
        spectrumTake(nodei,nodej,spectrumSearchArrayListReturn,path);
        while(channelNeeded>0){
            spectrumReserve(nodei,nodej,4,path,"sub");
            if(spectrumReserveBooleanReturn){
                if(channelNeeded>substChannel){
                    boolean subtxFound=false;
                    int transpondertx=0;
                    int subtx = 0;
                    boolean subrxFound=false;
                    int transponderrx=0;
                    int subrx=0;
                    if(takeTransponder){
                        subTransponderSearch(nodei);
                        subtxFound=subtransponderSearchFound;
                        transpondertx=transponder;
                        subtx = subtransponder;
                        if(!subtxFound)return false;
                        subTransponderSearch(nodej);
                        subrxFound=subtransponderSearchFound;
                        transponderrx=transponder;
                        subrx = subtransponder;
                        if(!subrxFound)return false;
                        subtransponderTake(nodei,transpondertx,subtx);
                        subtransponderTake(nodej,transponderrx,subrx);
                    }
                    ArrayList<Object> list = new ArrayList<>();
                    list.add(path);
                    list.add(substChannel*channelCapacity);
                    ArrayList<Integer> chan = new ArrayList<>();
                    for(int i=0;i<substChannel;i++){
                        chan.add(spectrumSearchArrayListReturn.get(i));
                        spectrumSearchArrayListReturn.remove(0);
                    }
                    list.add(chan);
                    list.add("sublp");
                    list.add("subtx");
                    ArrayList<Integer> subtx_info = new ArrayList<>();
                    subtx_info.add(nodei);
                    subtx_info.add(transpondertx);
                    subtx_info.add(subtx);
                    list.add(subtx_info);
                    list.add("subrx");
                    ArrayList<Integer> subrx_info = new ArrayList<>();
                    subrx_info.add(nodej);
                    subrx_info.add(transponderrx);
                    subrx_info.add(subrx);
                    list.add(subrx_info);
                    lightPathRes.get(nodei*100+nodej).add(list);
                    Object x = spectrumRes.get(nodei*100+nodej).get(spectrumRes.size()-1).get(2);
                    spectrumRes.get(nodei*100+nodej).get(spectrumRes.size()-1).set(2,substChannel+(int)x);
                    channelNeeded -= substChannel;
                }
                else{
                    for(int i=0;i<spectrumRes.get(nodei*100+nodej).size();i++){
                        ArrayList<Object> specRes = spectrumRes.get(nodei*100+nodej).get(i);
                        if((int)specRes.get(1)-(int)specRes.get(2)>0){
                            if(channelNeeded>((int)specRes.get(1)-(int)specRes.get(2))){
                                if(takeTransponder){
                                    boolean subtxFound=false;
                                    int transpondertx=0;
                                    int subtx = 0;
                                    boolean subrxFound=false;
                                    int transponderrx=0;
                                    int subrx=0;
                                    subTransponderSearch(nodei);
                                    subtxFound=subtransponderSearchFound;
                                    transpondertx=transponder;
                                    subtx = subtransponder;
                                    if(!subtxFound)return false;
                                    subTransponderSearch(nodej);
                                    subrxFound=subtransponderSearchFound;
                                    transponderrx=transponder;
                                    subrx = subtransponder;
                                    if(!subrxFound)return false;
                                    subtransponderTake(nodei,transpondertx,subtx);
                                    subtransponderTake(nodej,transponderrx,subrx);
                                }
                                spectrumRes.get(nodei*100+nodej).get(i).set(2,specRes.get(1));
                                channelNeeded -= ((int)specRes.get(1)-(int)specRes.get(2));
                                ArrayList<Object> list = new ArrayList<>();
                                list.add(path);
                                list.add(((int)specRes.get(1)-(int)specRes.get(2))*channelCapacity);
                                list.add(0);
                                lightPathRes.get(nodei*100+nodej).add(list);
                            }
                        }
                        else{
                            if(takeTransponder){
                                boolean subtxFound=false;
                                int transpondertx=0;
                                int subtx = 0;
                                boolean subrxFound=false;
                                int transponderrx=0;
                                int subrx=0;
                                subTransponderSearch(nodei);
                                subtxFound=subtransponderSearchFound;
                                transpondertx=transponder;
                                subtx = subtransponder;
                                if(!subtxFound)return false;
                                subTransponderSearch(nodej);
                                subrxFound=subtransponderSearchFound;
                                transponderrx=transponder;
                                subrx = subtransponder;
                                if(!subrxFound)return false;
                                subtransponderTake(nodei,transpondertx,subtx);
                                subtransponderTake(nodej,transponderrx,subrx);
                            }
                            spectrumRes.get(nodei*100+nodej).get(i).set(2,(int)specRes.get(2)+channelNeeded);
                            ArrayList<Object> list = new ArrayList<>();
                            list.add(path);
                            list.add(channelNeeded*channelCapacity);
                            list.add(0);
                            lightPathRes.get(nodei*100+nodej).add(list);
                        }
                    }
                }
            }
        }
        return true;
    }

    public void releaseLightPath(int nodei, int nodej, int demand){
        ArrayList<Object> popLightPath = new ArrayList<>();
        if(demand>0&&(lightPathRes.get(nodei*100+nodej).size()>0)){
            for(int i=0;i<lightPathRes.get(nodei*100+nodej).size();i++){
                ArrayList<Object> lp = lightPathRes.get(nodei*100+nodej).get(i);
                if((int)lp.get(2)>0){
                    if((int)lp.get(2)>demand){
                        lightPathRes.get(nodei*100+nodej).get(i).set(2,(int)lp.get(2)-demand);
                        demand = 0;
                        break;
                    }
                    else{
                        demand=demand-(int)lp.get(2);
                        lightPathRes.get(nodei*100+nodej).get(i).set(2,0);
                        popLightPath.add(i);
                        while(lightPathRes.get(nodei*100+nodej).get(i).size()>5){
                            ArrayList<Integer> transp = (ArrayList<Integer>) lightPathRes.get(nodei*100+nodej).get(i).get(lightPathRes.get(nodei*100+nodej).get(i).size()-1);
                            if(transp.get(0)==null||transp.get(1)==null||transp.get(2)==null){
                                break;
                            }
                            subtransponderRelease(transp.get(0),transp.get(1),transp.get(2));
                            lightPathRes.get(nodei*100+nodej).get(i).remove(lightPathRes.get(nodei*100+nodej).get(i).size()-1);
                            lightPathRes.get(nodei*100+nodej).get(i).remove(lightPathRes.get(nodei*100+nodej).get(i).size()-1);
                        }
                        if(!(demand>0)){
                            break;
                        }
                    }
                }
            }
        }
        for(int i=popLightPath.size();i>=0;i--){
            spectrumRelease(nodei,nodej,(ArrayList<Integer>) lightPathRes.get(nodei*100+nodej).get(i).get(3),(ArrayList<Integer>) lightPathRes.get(nodei*100+nodej).get(i).get(0));
            lightPathRes.get(nodei*100+nodej).remove(i);
        }
    }

//    public boolean virtualAddSubLightPath(int nodei, int nodej, int Freq){
//        int cN0 = (Freq+80-1)/80;
//        int cN = 4*((cN0+4-1)/4);
//        ArrayList<Integer> path = KshortestPath(nodei,nodej).get(0).get(1);
//        spectrumSearch(nodei,nodej,cN,path);
//        boolean spectrumFound = isSpectrumSearchBooleanReturn();
//        transponderSearch(nodei);
//        boolean txFound = transponderSearchFound;
//        transponderSearch(nodej);
//        boolean rxFound = transponderSearchFound;
//        if(spectrumFound&&txFound&&rxFound)return true;
//        return false;
//    }

    public void showLightPathResource(){
        System.out.println("LightPath Resource LightPath Allocated:");
        for(int key: lightPathRes.keySet()){
            if(lightPathRes.get(key).size() > 0){
                System.out.println(key + " " + lightPathRes.get(key));
            }
        }
    }

    public void showSpectrumResource(){
        System.out.println("Spectrum Resource Allocated:");
        for(int key: spectrumRes.keySet()){
            if(spectrumRes.get(key).size() > 0){
                System.out.println(key + " " + lightPathRes.get(key));
            }
        }
    }

    public void showServiceList(){
        System.out.println("Service Added:");
        for(ArrayList<Object> serv: servList){
            System.out.println(serv);
        }
    }


    public void consumeLightPath(int nodei, int nodej,int demand){
        for(int i = 0; i < lightPathRes.get(nodei*100 + nodej).size(); i++){
            ArrayList<Object> lp = lightPathRes.get(nodei*100 + nodej).get(i);
            int dis = (int)lp.get(1) - (int)lp.get(2);
            if(dis > 0){
                if(demand >= dis){
                    //Insufficient light resources
                    demand = demand - dis;
                    lightPathRes.get(nodei*100 + nodej).get(i).set(2, (int)lp.get(1));
                }
                else{
                    //Sufficient light resources
                    lightPathRes.get(nodei*100 + nodej).get(i).set(2, (int)lp.get(2) + demand);
                    demand = 0;
                }
            }
        }
    }

    public void stopService(int nodei, int nodej, int demand, ArrayList<ArrayList<Object>> pathij, int serviceID){
        serviceID = (Integer) null;
        int popServCount = -1;
        for(int i = 0 ; i < servList.size(); i++){
            if(serviceID == (int)servList.get(i).get(5)){
                popServCount = i;
                ArrayList<Object> tmp = new ArrayList<>();
                tmp.add(nodej);
                pathij.add(tmp);
                int currNode = nodei;
                for(int j = 0; j < pathij.size()-1; j++){
                    releaseLightPath(currNode, pathij.get(j+1).get(0), demand);
                    currNode = (int)pathij.get(j+1).get(0);
                }

            }
        }
        if(popServCount != -1)
            servList.remove(popServCount);
        activeService = -1;
    }
    private void releaseLightPath(int currNode, Object object, int demand) {
        // TODO Auto-generated method stub

    }
    public void addService(int nodei, int nodej, int demand, ArrayList<ArrayList<Object>> pathij, int serviceID, int stoptime){
        int physicalLength = 0;
        int transTake = 0;
        int virtualLength = pathij.size();
        int pathDelay = 0;
        ArrayList<Object> tmp = new ArrayList<>();
        tmp.add(nodej);
        pathij.add(tmp);
        int currNode = nodei;
        ArrayList<ArrayList<Object>> pathFoundList = new ArrayList<>();

    }



    /**
    ruoxing tianjia
     */
    /**
     * shortestPath
     * 输入：double形的graph（即矩阵） int形源宿端点标号nodei，nodej
     * 输出：double形的最短路径距离dis_ShortestPath，ArrayList<Integer>形的最短路顺序pathij_ShortestPath
     **/
//    TODO：函数的输出一并改成了“函数变量名_函数名”的形式，方便后续分析
//    TODO：一并都没有进行测试，后续需要抽出时间测试
    public void shortestPath(double[][] graph, int nodei, int nodej) {
        dijkstra(graph, nodei);
        double[] dis = getDistance_dijkstra();
        int[] path = getPath_dijkstra();
        ArrayList<Integer> pathij = new ArrayList<>();
        pathij.add(nodei);
        int prev = path[nodej];
        pathij.add(prev);
        while (prev != nodei) {
            prev = path[prev];
            pathij.add(prev);
        }
        Collections.reverse(pathij);
//        dis_ShortestPath是节点i到j之间的最短距离
        dis_ShortestPath = dis[nodej];
        pathij_ShortestPath = pathij;
    }

    public double getDis_ShortestPath() {
        return dis_ShortestPath;
    }

    public ArrayList<Integer> getPathij_ShortestPath() {
        return pathij_ShortestPath;
    }

    /**
     * KshortestPath 计算nodei，nodej之间的K条最短路
     * 目前只做了K=3
     * 输入：double形的graph（即矩阵） int形源宿端点标号nodei，nodej
     * 输出：ArrayList<Double> returnDistanceList_KshortestPath               ——K条路的分别的距离
     * ArrayList<ArrayList<Integer>> returnPathList_KshortestPath       ——K条路分别的经过节点
     **/



    public void KshortestPath(int nodei, int nodej) {
        int K = 3;
        ArrayList<Double> returnDistanceList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> returnPathList = new ArrayList<>();
//        TODO：这里distanceMatrix必须转化为double类型
//        金博这里的K最短路写的有点奇怪
        double[][] distanceMatrix = int2douMatrixConversion(DistanceMatrix);
        shortestPath(distanceMatrix, nodei, nodej);
        double dis0 = getDis_ShortestPath();
        ArrayList<Integer> path0 = getPathij_ShortestPath();
        returnDistanceList.add(dis0);
        returnPathList.add(path0);
        K = K - 1;

        distanceMatrix[path0.get(0)][path0.get(1)] = Double.POSITIVE_INFINITY;
        shortestPath(distanceMatrix, nodei, nodej);
        double dis1 = getDis_ShortestPath();
        ArrayList<Integer> path1 = getPathij_ShortestPath();
        returnDistanceList.add(dis1);
        returnPathList.add(path1);
        K = K - 1;

        distanceMatrix[path0.get(0)][path0.get(1)] = Double.POSITIVE_INFINITY;
        distanceMatrix[path1.get(1)][path1.get(2)] = Double.POSITIVE_INFINITY;
        shortestPath(distanceMatrix, nodei, nodej);
        double dis2 = getDis_ShortestPath();
        ArrayList<Integer> path2 = getPathij_ShortestPath();
        returnDistanceList.add(dis2);
        returnPathList.add(path2);
        K = K - 1;

        returnDistanceList_KshortestPath = returnDistanceList;
        returnPathList_KshortestPath = returnPathList;
    }

    //    K默认是3，但也可以改，视需求吧
    public void KshortestPath(int nodei, int nodej, int K) {
        KshortestPath(nodei, nodej);
    }

    public ArrayList<Double> getReturnDistanceList_KshortestPath() {
        return returnDistanceList_KshortestPath;
    }

    public ArrayList<ArrayList<Integer>> getReturnPathList_KshortestPath() {
        return returnPathList_KshortestPath;
    }

    public double[][] int2douMatrixConversion(int[][] intMatrix) {
        double[][] doubleMatrix = new double[intMatrix.length][intMatrix[0].length];
        for (int i = 0; i < intMatrix.length; i++) {
            for (int j = 0; j < intMatrix[0].length; j++) {
                doubleMatrix[i][j] = (double) intMatrix[i][j];
            }
        }
        return doubleMatrix;
    }

    /**
     * edgeWeight
     * TODO
     **/


    public void edgeWeight(int nodei, int nodej, int demand) {
        /**
         * yao xiugai
         * TODO: 添加 GroomingPolicy 后做整合修改
         * */
        double ELP = Double.POSITIVE_INFINITY;
        double PLP = Double.POSITIVE_INFINITY;
        double PSubLP = Double.POSITIVE_INFINITY;

        if (nodei == nodej) {
//            什么都不做，即return三个正无穷
        } else {
//        # 这里用了LightPathResource中的内容，之后可能需要再调整
            LightPathResource lightPathResource = new LightPathResource();
//        TODO:这里的lpRes还是不知道在哪里
            ArrayList<ArrayList<Object>> lpRes = lightPathRes.get(nodei * 100 + nodej);
//        # kshortestPath，returnDistanceList_KshortestPath & returnPathList_KshortestPath
            KshortestPath(nodei, nodej);
            ArrayList<Double> distanceList = getReturnDistanceList_KshortestPath();
            ArrayList<ArrayList<Integer>> pathList = getReturnPathList_KshortestPath();

//        # Existing LightPath(ELP)
            int totalCapacity = 0;
            for (int i = 0; i < lpRes.size(); i++) {
                if ((Integer) lpRes.get(i).get(1) - (Integer) lpRes.get(i).get(2) > 0) {
                    totalCapacity += ((Integer) lpRes.get(i).get(1) - (Integer) lpRes.get(i).get(2));
                }
            }
            if (totalCapacity > demand) {
//                TODO Grooming Policy 还没有做!这里只是随便先写上了变量
//                TODO 另外，这里的pathLength金博说是一样的，可我感觉还是不大确定
                ELP = groomingPolicy.getWeightELP0() + groomingPolicy.getELPEph() * ((ArrayList<Integer>) lpRes.get(0).get(0)).size();
            }

//             # Potential LP edge
            for (int i = 0; i < pathList.size(); i++) {
                //#TODO find usable resource
                int cN0 = (demand + 80 - 1) / 80;          //  #QPSK
                int cN = 10 * ((cN0 + 10 - 1) / 10);
//                这部分连盟做了，from mainIntegration
//              对应着  spectrumFound, _ = self.spectrumSearch(nodei,nodej,channelNeeded=cN,path=path[1]);
                spectrumSearch(nodei, nodej, cN, pathList.get(i));
                boolean spectrumFound = isSpectrumSearchBooleanReturn();
//              对应着 txFound, _ = self.transponderSearch(nodei)
                transponderSearch(nodei);
                boolean txFound = mainIntegration.isTransponderSearchFound();
//              对应着 rxFound, _ = self.transponderSearch(nodej)
                transponderSearch(nodej);
                boolean rxFound = mainIntegration.isTransponderSearchFound();

                if (spectrumFound && txFound && rxFound) {
                    double temp = 2 * groomingPolicy.getRxTxEdge() + groomingPolicy.getPLPEph() * pathList.get(1).size();
                    if (temp < PLP) {
                        PLP = temp;
//                    #first fit
                        break;
                    }
                }
            }
            ELP_edgeWeight = ELP;
            PLP_edgeWeight = PLP;
            PSubLP_edgeWeight = PSubLP;
        }
    }

    public double getELP_edgeWeight() {
        return ELP_edgeWeight;
    }

    public double getPLP_edgeWeight() {
        return PLP_edgeWeight;
    }

    public double getPSubLP_edgeWeight() {
        return PSubLP_edgeWeight;
    }

    /**
     * getStates
     * 功能：获得对于不同带宽需求，已有光路、潜在光路、潜在副光路的权值？
     * 输入：源宿节点nodei，nodej
     * 输出：returnStates
     **/

    public ArrayList<Double> getStates(int nodei, int nodej) {
        ArrayList<Double> returnStates = new ArrayList<>();
        int[] serviceDemands = {40, 100, 200, 400};
        for (int demand : serviceDemands) {
            edgeWeight(nodei, nodej, demand);
            returnStates.add(1.0 / getELP_edgeWeight());
            returnStates.add(1.0 / getPLP_edgeWeight());
            returnStates.add(1.0 / getPSubLP_edgeWeight());
        }
        return returnStates;
    }

    /**
     * TODO addConnection
     * 功能：尝试加入新的连接，如能加入，则更新网络全局延迟和能耗状态，如不能加入，则记录blockCount
     * 输入：源宿节点nodei，nodej，带宽需求demand，业务编号serviceID，stoptime，zerodelay，是否打印测试isPrint
     * 输出：
     **/


//    public void addConnection(int nodei, int nodej, int demand, int serviceID, double stoptime, boolean zerodelay, boolean isPrint) {
//        Dijkstra(nodei, nodej, demand);
//        ArrayList<String[]> pathij = getPathij_Dijkstra();
//        boolean isAdded = false;
//
//        if (isFound_Dijkstra()) {
//            addService(nodei, nodej, demand, pathij, serviceID, stoptime);
//            if (isAdded) {
//                succCount += 1;
//                totalPhyLen += phyLength;
//                totalVirLen += virLength;
//                totalDelay += pathDelay;
//                activeService += 1;
//                double addedTransEnergy = 1.683 * demand + 91.333;
//                double addedAmplifierEnergy = 30 * (pathDelay - 80) / 80 + 0.0075 * demand;
//                totalEnergyConsumed += (addedTransEnergy + addedAmplifierEnergy);
//                if (zerodelay == "True")
//                    totalZeroDelay += 1;
//                if (isPrint) {
//                    System.out.println("connection added: from " + Integer.toString(nodei) +
//                            " to " + Integer.toString(nodej) + " demanding " + Integer.toString(demand));
////                    #self.showSpectrumResource();
////                    #self.showLightPathResource();
//                }
//                return isAdded,(addedTransEnergy + addedAmplifierEnergy), pathDelay, 1
//            }
////            #else:
////            #self.blockCount += 1
//            blockCount += 1;
//            if (isPrint) {
//                System.out.println("connection blocked: from" + Integer.toString(nodei) +
//                        " to " + Integer.toString(nodej) + " demanding " + Integer.toString(demand));
//            }
//
//            return isAdded,None, None, None
//
//        }
//
//    }

    /**
     * TODO
     * Dijkstra
     * 输入：源宿节点编号nodei、nodej，带宽需求demand
     * 输出：boolean isFount —— 是否找到最短路
     * double[] distance_Dijkstra —— 所有点与nodei之间的距离
     * ArrayList<String[]> pathij_Dijkstra —— 从nodei至nodej的路径，以及中间各链路的创建情况
     **/

    private boolean isFound_Dijkstra;
    private double[] distance_Dijkstra;
    private ArrayList<String[]> pathij_Dijkstra;

    public void Dijkstra(int nodei, int nodej, int demand) {
        int n = DistanceMatrix.length;

        double[][] ELPmat = new double[n][n];
        double[][] PLPmat = new double[n][n];
        double[][] PSubLPmat = new double[n][n];
//        节点总数n
//        获得了图中任意两点之间的ELP、PLP、PSubLP边的权值
        for (int i = 0; i < n; i++) {
//            ELP: existing lightpath
//            PLP: potential lightpath
//            PSubLP: potential sub lightpath 吃透了
            for (int j = 0; j < n; j++) {
                //TODO:这里的edgeWeight的类型可能需要后续重新确定
                edgeWeight(i, j, demand);
                double wELP = getELP_edgeWeight();
                double wPLP = getPLP_edgeWeight();
                double wPSubLP = getPSubLP_edgeWeight();
//                每一行是node的相应LP
                ELPmat[i][j] = wELP;
                PLPmat[i][j] = wPLP;
                PSubLPmat[i][j] = wPSubLP;
            }
        }
//        用于各个节点距离nodei的距离
        double[] distance = new double[n];
        for (int i = 0; i < n; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
        }
        distance[nodei] = 0;
//      path为一个n行两列的String形数组
//      第i行，记录了编号为i的节点的上一个节点，以及这两个节点之间的连接关系？
//      的第一个值的类型，从int转化为了String，之后使用需要转化
        String[][] path = new String[n][2];
        ArrayList<String[]> unvisited = get_edges(PSubLPmat);
        while (!unvisited.isEmpty()) {
//            每次提取一个处理，提取后删除
            int u = Integer.parseInt(unvisited.get(0)[1]);
            unvisited.remove(0);
            for (int v = 0; v < n; v++) {
                double wELP = ELPmat[u][v];
                double wPLP = PLPmat[u][v];
                double wPSubLP = PSubLPmat[u][v];
                if (distance[u] + wELP < distance[v]) {
                    distance[v] = distance[u] + wELP;
//                  path[v] = [u, "PSubLP"];
                    path[v][1] = String.valueOf(u);
                    path[v][2] = "ELP";
                }
                if (distance[u] + wPSubLP < distance[v]) {
                    distance[v] = distance[u] + wPSubLP;
//                  path[v] = [u, "PSubLP"];
                    path[v][1] = String.valueOf(u);
                    path[v][2] = "PSubLP";

                }
                if (distance[u] + wPLP < distance[v]) {
                    distance[v] = distance[u] + wPLP;
//                  path[v] = [u, "PLP"] ;
                    path[v][1] = String.valueOf(u);
                    path[v][2] = "PLP";
                }
            }
        }

        ArrayList<String[]> path_ij = new ArrayList<>();
        String[] prev = path[nodej];
//        这部分是default用的
        if (!(prev instanceof String[])) {
//            这部分是金当时写的，562是行数，“你们以后还是要多做测试，测试代码都不知道”，金博如此说。
            System.out.println("562:prev" + prev.toString());
            System.out.println("562:path" + path);
            System.out.println("562:nodei" + nodei);
            System.out.println("562:nodej" + nodej);
            System.out.println("562:dis" + distance);

            transponderSearch(nodei);
            boolean txFound1 = mainIntegration.isTransponderSearchFound();
            transponderSearch(nodej);
            boolean txFound2 = mainIntegration.isTransponderSearchFound();
//            txFound1, _ =;
//            txFound2, _ = self.transponderSearch(nodej);
            System.out.println("562:tx:" + txFound1 + txFound2);
            isFound_Dijkstra = false;
            distance_Dijkstra = null;
            pathij_Dijkstra = null;
        } else if (distance[nodej] == Double.POSITIVE_INFINITY) {
            isFound_Dijkstra = false;
            distance_Dijkstra = null;
            pathij_Dijkstra = null;
        } else {
            int prevNode = Integer.parseInt(prev[0]);
            path_ij.add(prev);
            while (prevNode != nodei) {
                prev = path[prevNode];
                prevNode = Integer.parseInt(prev[0]);
                path_ij.add(prev);
                Collections.reverse(path_ij);
            }
            isFound_Dijkstra = true;
            distance_Dijkstra = distance;
            pathij_Dijkstra = path_ij;
        }
    }


    public boolean isFound_Dijkstra() {
        return isFound_Dijkstra;
    }

    public double[] getDistance_Dijkstra() {
        return distance_Dijkstra;
    }

    public ArrayList<String[]> getPathij_Dijkstra() {
        return pathij_Dijkstra;
    }

    /**
     * statisticsReset
     * 功能：计数重置
     **/

    //TODO 这部分变量的属性事实上不太清楚，需要后期继续研究
    private int blockCount;
    private int succCount;
    private int totalPhyLen;
    private int totalVirLen;
    private int totalDelay;
    private int totalZeroDelay;
    private int totalStCount;
    private int totalSubstCount;
    private int totalEnergyConsumed;

    public void statisticsReset() {
        this.blockCount = 0;
        this.succCount = 0;
        this.totalPhyLen = 0;
        this.totalVirLen = 0;
        this.totalDelay = 0;
        this.totalZeroDelay = 0;
        this.totalStCount = 0;
        this.totalSubstCount = 0;

        int n = DistanceMatrix.length;
        this.totalEnergyConsumed = 560 * n;
    }

    /**
     * statisticsSummary
     * 功能：计算一些统计上的数据，用于后面的应用
     **/

    //未进行测试
    private double blockRatio;
    private double averagePhyHop;
    private double averageVirHop;
    private double averagePathDelay;
    private double averageTransponderUsed;
    private double averageSubTransponderUsed;
    private double totalEnergyUsed;
    private double averageZeroDelay;

    //未进行测试
    public void statisticsSummary() {
//                #print("Succ:",this.succCount,"Block:",this.blockCount)
        double blockRatio = this.blockCount * 1.0 / (this.blockCount + this.succCount);
        double averagePhyHop = this.totalPhyLen * 1.0 / this.succCount + 1;   //should count for itself
        double averageVirHop = this.totalVirLen * 1.0 / this.succCount;
        double averagePathDelay = this.totalDelay * 1.0 / this.succCount;
        double averageZeroDelay = this.totalZeroDelay * 1.0 / this.succCount;
        this.updateTransponderCount(true);

        double averageTransponderUsed = this.totalStCount * 1.0 / this.activeService / 4;   //should count 4 times
        double averageSubTransponderUsed = this.totalSubstCount * 1.0 / this.activeService / 4; //should count 4 times
        double totalEnergyUsed = this.totalEnergyConsumed;
        System.out.print("blockRatio               :");
        System.out.println(blockRatio);
        System.out.print("averagePhyHop            :");
        System.out.println(averagePhyHop);
        System.out.print("averageVirHop            :");
        System.out.println(averageVirHop);
        System.out.print("averagePathDelay         :");
        System.out.println(averagePathDelay);
        System.out.print("averageZeroDelay         :");
        System.out.println(averageZeroDelay);
        System.out.print("averageTransponderUsed   :");
        System.out.println(averageTransponderUsed);
        System.out.print("averageSubTransponderUsed:");
        System.out.println(averageSubTransponderUsed);
        System.out.print("totalEnergyUsed          :");
        System.out.println(totalEnergyUsed);

        this.blockRatio = blockRatio;
        this.averagePhyHop = averagePhyHop;
        this.averageVirHop = averageVirHop;
        this.averagePathDelay = averagePathDelay;
        this.averageTransponderUsed = averageTransponderUsed;
        this.averageSubTransponderUsed = averageSubTransponderUsed;
        this.totalEnergyUsed = totalEnergyUsed;
        this.averageZeroDelay = averageZeroDelay;
//      输出变量太多，这些只能后续get set了
    }

    //未进行测试
    public void statisticsSummary(boolean isPrint) {
        //                #print("Succ:",this.succCount,"Block:",this.blockCount)
        double blockRatio = this.blockCount * 1.0 / (this.blockCount + this.succCount);
        double averagePhyHop = this.totalPhyLen * 1.0 / this.succCount + 1;   //should count for itself
        double averageVirHop = this.totalVirLen * 1.0 / this.succCount;
        double averagePathDelay = this.totalDelay * 1.0 / this.succCount;
        double averageZeroDelay = this.totalZeroDelay * 1.0 / this.succCount;
        this.updateTransponderCount(isPrint);

        double averageTransponderUsed = this.totalStCount * 1.0 / this.activeService / 4;   //should count 4 times
        double averageSubTransponderUsed = this.totalSubstCount * 1.0 / this.activeService / 4; //should count 4 times
        double totalEnergyUsed = this.totalEnergyConsumed;
        if (isPrint) {
            System.out.print("blockRatio               :");
            System.out.println(blockRatio);
            System.out.print("averagePhyHop            :");
            System.out.println(averagePhyHop);
            System.out.print("averageVirHop            :");
            System.out.println(averageVirHop);
            System.out.print("averagePathDelay         :");
            System.out.println(averagePathDelay);
            System.out.print("averageZeroDelay         :");
            System.out.println(averageZeroDelay);
            System.out.print("averageTransponderUsed   :");
            System.out.println(averageTransponderUsed);
            System.out.print("averageSubTransponderUsed:");
            System.out.println(averageSubTransponderUsed);
            System.out.print("totalEnergyUsed          :");
            System.out.println(totalEnergyUsed);
        }

        this.blockRatio = blockRatio;
        this.averagePhyHop = averagePhyHop;
        this.averageVirHop = averageVirHop;
        this.averagePathDelay = averagePathDelay;
        this.averageTransponderUsed = averageTransponderUsed;
        this.averageSubTransponderUsed = averageSubTransponderUsed;
        this.totalEnergyUsed = totalEnergyUsed;
        this.averageZeroDelay = averageZeroDelay;
    }

    public double getBlockRatio() {
        return blockRatio;
    }

    public double getAveragePhyHop() {
        return averagePhyHop;
    }

    public double getAverageVirHop() {
        return averageVirHop;
    }

    public double getAveragePathDelay() {
        return averagePathDelay;
    }

    public double getAverageTransponderUsed() {
        return averageTransponderUsed;
    }

    public double getAverageSubTransponderUsed() {
        return averageSubTransponderUsed;
    }

    public double getTotalEnergyUsed() {
        return totalEnergyUsed;
    }

    public double getAverageZeroDelay() {
        return averageZeroDelay;
    }

    /**
     * updateTransponderCount
     * 功能：对已经用了的Transponders进行计数
     * 输入：boolean isPrint确定是否打印
     **/

    public void updateTransponderCount(boolean isPrint) {
        //scheme 1
        int totalSubSt = 0;
        for (int i = 0; i < getNode_subst_list().size(); i++) {
            for (int j = 0; j < getNode_subst_list().get(i).size(); j++) {
                for (int k = 0; k < getNode_subst_list().get(i).get(j).size(); k++) {
                    if (getNode_subst_list().get(i).get(j).get(k) == "Used")
                        totalSubSt += 1;
                }
            }
        }
        this.totalSubstCount = totalSubSt;

        //scheme 2
        int totalSt = 0;
        for (int i = 0; i < getNode_st_list().size(); i++) {
            for (int j = 0; j < getNode_st_list().get(i).size(); j++) {
                if (getNode_st_list().get(i).get(j) == "Used")
                    totalSt += 1;
            }
        }
        this.totalStCount = totalSt;

        if (isPrint) {
            System.out.print("transponderUsed:");
            System.out.println(this.totalStCount);
            System.out.print("subTransponderUsed:");
            System.out.println(this.totalSubstCount);
        }
    }

    /**
     * testCM
     * （tested）
     * 功能：确认DistanceMatrix的行数和列数
     * 输入：int DistanceMatrix[][]
     **/
    //
    public void testCM(int DistanceMatrix[][]) {
        for (int[] row : DistanceMatrix) {
            System.out.print(" matrix_len:" + Integer.toString(row.length));
        }
    }

    /**
     * tranCM
     * （tested）
     * 功能： 将DistanceMatrix为联通的部分调整为无穷大，便于后续算法找最短路
     * 输入：int DistanceMatrix[][]
     **/
    public double[][] tranCM(int DistanceMatrix[][]) {
        double[][] trans = new double[DistanceMatrix.length][DistanceMatrix.length];
        for (int i = 0; i < trans.length; i++) {
            for (int j = 0; j < trans[i].length; j++) {
                if (DistanceMatrix[i][j] == 0 && i != j) trans[i][j] = Double.POSITIVE_INFINITY;
                else trans[i][j] = DistanceMatrix[i][j];
            }
        }
        return trans;
    }

    /**
     * get_edges
     * （tested）
     * 功能：找到matrix里的所有边
     * 输入：double[][] graphMatrix，这里没有连接不是Infinity而是0
     * 输出：ArrayList<String[]> edges
     * 为字符串列表的Arraylist，字符串列表中，前两项是边的端点（int），最后一项是权值（double）
     * 需要注意的是这里都变为了String，需要转化回去使用
     **/

    public ArrayList<String[]> get_edges(double[][] graphMatrix) {
        int n = graphMatrix.length;
        ArrayList<String[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String[] tempList = new String[3];
                if (graphMatrix[i][j] != 0.0 && graphMatrix[i][j] != Double.POSITIVE_INFINITY) {
                    tempList[0] = Integer.toString(i);
                    tempList[1] = Integer.toString(j);
                    tempList[2] = Double.toString(graphMatrix[i][j]);
                    System.out.print(tempList[0]);
                    System.out.print(" - ");
                    System.out.print(tempList[1]);
                    System.out.println(" " + tempList[2]);
                    edges.add(tempList);
                }
            }
        }
        return edges;
    }

    /**
     * Floyd
     * （tested）
     * 功能：Floyd最短路算法
     * 输入：double[][] graphMatrix，这里没有连接是距离为Infinity
     * 输出：double[][] distance_Floyd; n*n 各个节点之间最短路的距离
     * int[][] path_Floyd; 节点i到j的第一跳
     * HashMap<Integer, ArrayList<Integer>> pathD_Floyd; 字典，i到j的路径
     **/

    private double[][] distance_Floyd;
    private int[][] path_Floyd;
    private HashMap<Integer, ArrayList<Integer>> pathD_Floyd;

    //    not tested
    public void Floyd(double[][] connectMatrix) {
        double[][] distance = new double[connectMatrix.length][connectMatrix.length];
        int[][] path = new int[connectMatrix.length][connectMatrix.length];
//      这里把pathD设为了HashMap，类似于字典
        HashMap<Integer, ArrayList<Integer>> pathD = new HashMap();

        for (int i = 0; i < connectMatrix.length; i++) {
            for (int j = 0; j < connectMatrix.length; j++) {
                distance[i][j] = connectMatrix[i][j];
                path[i][j] = j;
            }
        }
        for (int k = 0; k < connectMatrix.length; k++) {
            for (int i = 0; i < connectMatrix.length; i++) {
                for (int j = 0; j < connectMatrix.length; j++) {
                    if (distance[i][k] + distance[k][j] < distance[i][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        path[i][j] = path[i][k];
                    }
                }
            }
        }
        for (int i = 0; i < connectMatrix.length; i++) {
            for (int j = 0; j < connectMatrix.length; j++) {
                ArrayList<Integer> pathij = new ArrayList();
                int currentPointer = i;
                pathij.add(currentPointer);
                currentPointer = path[currentPointer][j];
                while (currentPointer != j) {
                    pathij.add(currentPointer);
                    currentPointer = path[currentPointer][j];
                }
                pathij.add(j);
                pathD.put(i * 100 + j, pathij);
            }
        }
        this.distance_Floyd = distance;
        this.path_Floyd = path;
        this.pathD_Floyd = pathD;
    }

    public double[][] getDistance_Floyd() {
        return distance_Floyd;
    }

    public int[][] getPath_Floyd() {
        return path_Floyd;
    }

    public HashMap<Integer, ArrayList<Integer>> getPathD_Floyd() {
        return pathD_Floyd;
    }

    /**
     * dijkstra
     * （tested）
     * 功能：dijkstra 最短路算法，获得v0至所有点的距离，以及下一跳
     * 输入：double[][] graphMatrix，这里没有连接是距离为Infinity
     * int v0，起始点，获得
     * 输出：   double[] distance_dijkstra; v0至目标点的距离
     * int[] path_dijkstra;    v0至目标点的下一跳路由
     **/

    private double[] distance_dijkstra;
    private int[] path_dijkstra;

    public void dijkstra(double[][] graph, int v0) {
        int n = graph.length;
        double[] distance = new double[n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Double.POSITIVE_INFINITY;
        }
        distance[v0] = 0;
        int[] path = new int[n];
        ArrayList<String[]> unvisited = get_edges(graph);

        while (!unvisited.isEmpty()) {
            int u = Integer.parseInt(unvisited.get(0)[1]);
            unvisited.remove(0);
            for (int v = 0; v < graph[u].length; v++) {
                double w = graph[u][v];
                if (distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                    path[v] = u;
                }
            }
        }
        distance_dijkstra = distance;
        path_dijkstra = path;
    }

    public double[] getDistance_dijkstra() {
        return distance_dijkstra;
    }

    public int[] getPath_dijkstra() {
        return path_dijkstra;
    }

    /**
     * genService
     * （tested）
     * 功能：
     * 生成业务信息，用于后续添加
     * 输入：
     * int serNum，业务数量
     * double miu，容忍度与持续时间相关参数
     * 输出：
     * ArrayList<Integer[]> serviceSet: 业务集合，interger为1*2数组，起始点与终点
     * ArrayList<Double> demandSet: 业务带宽需求记录集合
     * ArrayList<Double> durationSet: 业务持续时间记录结合
     * ArrayList<Double> toleranceSet: 业务（时延？）容忍度
     **/
    // 这里的默认值姑且没有写，感觉不是很重要 int serNum,int NodesNum =13, double miu=0.2

    private ArrayList<Integer[]> serviceSet_genService = new ArrayList<>();    //业务集合，interger为1*2数组，起始点与终点
    private ArrayList<Double> demandSet_genService = new ArrayList<>();        //业务带宽需求记录集合
    private ArrayList<Double> durationSet_genService = new ArrayList<>();      //业务持续时间记录结合
    private ArrayList<Double> toleranceSet_genService = new ArrayList<>();     //业务（时延？）容忍度

    public void genService(int serNum, double miu) {
        int NodesNum = DistanceMatrix.length;
        ArrayList<Integer[]> serviceSet = new ArrayList<>();
        ArrayList<Double> demandSet = new ArrayList<>();
//        业务持续时间
        ArrayList<Double> durationSet = new ArrayList<>();
//        业务（时延？）容忍度
        ArrayList<Double> toleranceSet = new ArrayList<>();
        double[] serviceDemand = {40, 100, 200, 400};
        double[] serviceProp = {0.3, 0.5, 0.15, 0.05};
        for (int i = 0; i < serNum; i++) {
            int startNode = (int) (Math.random() * NodesNum);
            int endNode = (int) (Math.random() * NodesNum);

            while (endNode == startNode) {
                endNode = (int) Math.random() * NodesNum;
            }
            Integer[] pairChosen = {startNode, endNode};
            serviceSet.add(pairChosen);
            int[] demand = new int[serviceProp.length];
            for (int j = 0; j < serviceProp.length; j++) {
                demand[j] = (int) (Math.random() * 2);
//                System.out.println("demand"+j+" is "+ Integer.toString(demand[j]));
            }
            if (demand[0] == 1)
                demandSet.add(serviceDemand[0]);
            if (demand[1] == 1)
                demandSet.add(serviceDemand[1]);
            if (demand[2] == 1)
                demandSet.add(serviceDemand[2]);
            if (demand[3] == 1)
                demandSet.add(serviceDemand[3]);
            durationSet.add(-1.0 / miu * Math.log(1 - Math.random()));
            toleranceSet.add(-1.0 / miu * Math.log(1 - Math.random()));
//            toleranceSet.append(-1.0 / miu * math.log(1 - random.random()));
        }
        this.serviceSet_genService = serviceSet;
        this.demandSet_genService = demandSet;
        this.durationSet_genService = durationSet;
        this.toleranceSet_genService = toleranceSet;
    }

    public ArrayList<Integer[]> getServiceSet_genService() {
        return serviceSet_genService;
    }

    public ArrayList<Double> getDemandSet_genService() {
        return demandSet_genService;
    }

    public ArrayList<Double> getDurationSet_genService() {
        return durationSet_genService;
    }

    public ArrayList<Double> getToleranceSet_genService() {
        return toleranceSet_genService;
    }

    /**
     * genService
     * （TODO）
     * 功能：生成业务信息，用于后续添加
     * 输入：
     * ArrayList<Integer[]> serviceSet：
     * HashMap<Integer, ArrayList<Integer>> pathD：
     * 输出：
     * ArrayList<ArrayList<Integer>> servicePath_genServicePath：
     * ArrayList<ArrayList<Integer>> servicePathCoded_genServicePath：
     **/

    private ArrayList<ArrayList<Integer>> servicePath_genServicePath = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> servicePathCoded_genServicePath = new ArrayList<>();

    //    not tested
    public void genServicePath(ArrayList<Integer[]> serviceSet, HashMap<Integer, ArrayList<Integer>> pathD) {
        ArrayList<ArrayList<Integer>> servicePath = new ArrayList<>();
        ArrayList<ArrayList<Integer>> servicePathCoded = new ArrayList<>();
        for (Integer[] service : serviceSet) {
            ArrayList<Integer> pathij = pathD.get(service[0] * 100 + service[1]);
            System.out.println("node"+service[0]+" to node"+service[1]);
            System.out.println("pathij size is "+pathij.size());
            servicePath.add(pathij);
            ArrayList<Integer> pathCoded = new ArrayList<>();
            for (int i = 0; i < pathij.size() - 1; i++) {
                if (pathij.get(i) < pathij.get(i + 1))
                    pathCoded.add(pathij.get(i) * 100 + pathij.get(i + 1));
                else
                    pathCoded.add(pathij.get(i + 1) * 100 + pathij.get(i));
            }
            servicePathCoded.add(pathCoded);
        }
        this.servicePath_genServicePath = servicePath;
        this.servicePathCoded_genServicePath = servicePathCoded;
    }

    public ArrayList<ArrayList<Integer>> getServicePath_genServicePath() {
        return servicePath_genServicePath;
    }

    public ArrayList<ArrayList<Integer>> getServicePathCoded_genServicePath() {
        return servicePathCoded_genServicePath;
    }

}


