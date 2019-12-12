import java.util.ArrayList;

class test{
    public static void main(String[] args) {
        mainIntegration ma = new mainIntegration();
        ma.init();
        ma.genService(1,2);
        ArrayList<Integer[]> serviceSet_genService = new ArrayList<>();    //业务集合，interger为1*2数组，起始点与终点
        ArrayList<Integer> demandSet_genService = new ArrayList<>();        //业务带宽需求记录集合
        ArrayList<Double> durationSet_genService = new ArrayList<>();      //业务持续时间记录结合
        ArrayList<Double> toleranceSet_genService = new ArrayList<>();     //业务（时延？）容忍度
        serviceSet_genService=ma.getServiceSet_genService();
        System.out.println(serviceSet_genService.get(0)[0]);
        System.out.println(serviceSet_genService.get(0)[1]);
        durationSet_genService=ma.getDurationSet_genService();
        System.out.println("durationSet_genService"+durationSet_genService);
        demandSet_genService=ma.getDemandSet_genService();
        System.out.println("demandSet_genService"+demandSet_genService);
        toleranceSet_genService=ma.getToleranceSet_genService();
        System.out.println("toleranceSet_genService"+toleranceSet_genService);
        ma.Dijkstra(serviceSet_genService.get(0)[0], serviceSet_genService.get(0)[1], demandSet_genService.get(0));
        ArrayList<ArrayList<Object>> pathij = ma.getPathij_Dijkstra();
        System.out.println("路径是："+pathij);
        ma.addService(serviceSet_genService.get(0)[0],serviceSet_genService.get(0)[1],demandSet_genService.get(0),pathij,1,15);
        //ma.addConnection(13,12,10,1,13,false,true);
    }
}
