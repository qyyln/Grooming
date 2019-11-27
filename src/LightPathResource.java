import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LightPathResource {
    HashMap<String, List<Object>> LightPathRes;

    public LightPathResource(HashMap<String, List<Object>> lightPathRes) {
        LightPathRes = lightPathRes;
    }

    public LightPathResource() {
    }

    public HashMap<String, List<Object>> getLightPathRes() {
        return LightPathRes;
    }

    public void setLightPathRes(HashMap<String, List<Object>> lightPathRes) {
        LightPathRes = lightPathRes;
    }
    public void init_LightPathRes(int[][] ConnectionMatrix){
        for(int i=0;i<ConnectionMatrix.length;i++){
            for(int j=i;j<ConnectionMatrix[0].length;j++){
                List<Object> list = new ArrayList<>();
                LightPathRes.put(String.valueOf(i)+','+String.valueOf(j),list);
            }
        }
    }
    public void modifyLightPathRes(String s_t, String path, int stChannel, int channel_num_used, int channelSet,String lorSub){
        List<Object> list = new ArrayList<>();
        list.add(path);
        list.add(stChannel);
        list.add(channel_num_used);
        list.add(channelSet);
        list.add(lorSub);
    }
}
