public class init_topology {
    private static int[][] ConnectMatrix; //存储拓扑连接；

    public int[][] getConnectMatrix() {
        return ConnectMatrix;
    }

    public static void setConnectMatrix(int[][] connectMatrix) {
        ConnectMatrix = connectMatrix;
    }

    public init_topology() {
    }

    public static void topologyShow(){
        for(int i=0;i<ConnectMatrix.length;i++){
            for(int j=0;j<ConnectMatrix[0].length;j++){
                System.out.print(ConnectMatrix[i][j]);
                System.out.print(',');
            }
            System.out.println();
        }
    }
}
