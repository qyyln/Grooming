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
        for (int i = 0; i < dm.length; i++) {
            for (int j = 0; j < dm[0].length; j++) {
                if (dm[i][j] != 0) {
                    ConnectionMatrix[i][j] = 1;
                } else {
                    ConnectionMatrix[i][j] = 0;
                }
            }
        }
        NodeNum = ConnectionMatrix.length;
    }

    public void initNodeSTResource() {
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
    }

    public void initSpectrumResource() {
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
    }

    public void initLightPathResource() {
        for (int i = 0; i < NodeNum; i++) {
            for (int j = 0; j < NodeNum; j++) {
                ArrayList<ArrayList<Object>> list = new ArrayList<>();
                lightPathRes.put(i * 100 + j, list);
            }
        }
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
                stopService(servList.get(i).get(0), servList.get(i).get(1), servList.get(i).get(3),
                        servList.get(i).get(2), servList.get(i).get(5));
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






}

