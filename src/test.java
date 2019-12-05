import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {
    public static void main(String[] args) {
        mainIntegration m = new mainIntegration();
        m.initDisMatrix(m.DistanceMatrix);//connectionmatrix
        m.initNodeSTResource();
        m.initSpectrumResource();
        m.initLightPathResource();
        m.initServiceList();
        m.updateServiceList();
        m.autoStopServivice(10);
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        path.add(1);
        m.addLightPath(0,1,10,true,path);
    }
}
