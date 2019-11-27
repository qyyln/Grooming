public class init_topology {
    int[][] DistanceMatrix;
    int[][] ConnectionMatrix;

    public init_topology(int[][] distanceMatrix, int[][] connectionMatrix) {
        DistanceMatrix = distanceMatrix;
        ConnectionMatrix = connectionMatrix;
    }

    public init_topology() {
    }

    public int[][] getDistanceMatrix() {
        return DistanceMatrix;
    }

    public void setDistanceMatrix(int[][] distanceMatrix) {
        DistanceMatrix = distanceMatrix;
    }

    public int[][] getConnectionMatrix() {
        return ConnectionMatrix;
    }

    public void setConnectionMatrix(int[][] connectionMatrix) {
        ConnectionMatrix=connectionMatrix;
        for(int i=0;i<connectionMatrix.length;i++){
            for(int j=0;j<connectionMatrix[0].length;j++){
                if(connectionMatrix[i][j]!=0){
                    ConnectionMatrix[i][j]=1;
                }else{
                    ConnectionMatrix[i][j]=0;
                }
            }
        }
    }
    public void topologyConnectionShow(){
        System.out.println("临界矩阵展示");
        System.out.println("-------------------------------------------------");
        for(int i=0;i<ConnectionMatrix.length;i++){
            for(int j=0;j<ConnectionMatrix[0].length;j++){
                System.out.print(ConnectionMatrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("第"+i+"行");
        }
    }
    public void topologyDistanceShow(){
        System.out.println("距离矩阵展示");
        System.out.println("-------------------------------------------------");
        for(int i=0;i<DistanceMatrix.length;i++){
            for(int j=0;j<DistanceMatrix[0].length;j++){
                System.out.print(DistanceMatrix[i][j]);
                System.out.print(" ");
            }
            System.out.println("第"+i+"行");
        }
    }
}
