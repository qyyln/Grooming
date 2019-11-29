import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LightPathResource {
    HashMap<Integer, List<Object>> LightPathRes;
    HashMap<Integer, List<Object>> spectrumRes;


    public LightPathResource(HashMap<Integer, List<Object>> lightPathRes) {
        LightPathRes = lightPathRes;
    }

    public LightPathResource() {
    }

    public HashMap<Integer, List<Object>> getLightPathRes() {
        return LightPathRes;
    }

    public void setLightPathRes(HashMap<Integer, List<Object>> lightPathRes) {
        LightPathRes = lightPathRes;
    }
    public void init_LightPathRes(int[][] ConnectionMatrix){
        for(int i=0;i<ConnectionMatrix.length;i++){
            for(int j=0;j<ConnectionMatrix[0].length;j++){
                List<Object> list_light = new ArrayList<>();
                List<Object> list_spectrumRes = new ArrayList<>();
                if(i==j){
                    continue;
                }
                else{
                    LightPathRes.put(i*100+j,list_light);
                    spectrumRes.put(i*100+j,list_spectrumRes);
                }
            }
        }
    }
    public void modifyLightPathRes(int s_d, ArrayList<Integer> path, String s, int stChannel, int channel_num_used, int channelSet){
        List<Object> list = new ArrayList<>();
        list.add(path);
        list.add(stChannel);
        list.add(channel_num_used);
        list.add(channelSet);
        list.add(s);
        LightPathRes.put(s_d,list);
    }
    public void useSpectrumResource(int source_node, int destination_node, ArrayList<Integer> channelSet, ArrayList<Integer> path,int useNum){
        List<Integer> edgeSet = new ArrayList<>();
        for(Integer i:path){
            edgeSet.add(i*100+i+1);
            edgeSet.add((i+1)*100+i);
        }
        for(Integer channel:channelSet){
            for(Integer edge:edgeSet){
                spectrumRes.get(edge).set(channel,useNum);
            }
        }
    }
    public void releaseSpectrumResource(int source_node, int destination_node, ArrayList<Integer> channelSet, ArrayList<Integer> path,int useNum){

    }
}
