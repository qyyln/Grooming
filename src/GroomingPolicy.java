public class GroomingPolicy {
    private String name;
    private String policy;
    private double RxTxEdge;

    public double getRxTxEdge() {
        return RxTxEdge;
    }

    public double getSubRxTxEdge() {
        return SubRxTxEdge;
    }

    public double getWeightELP0() {
        return weightELP0;
    }

    public double getELPEph() {
        return ELPEph;
    }

    public double getPLPEph() {
        return PLPEph;
    }

    private double SubRxTxEdge;
    private double weightELP0;
    private double ELPEph;
    private double PLPEph;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolicy() {
        return policy;
    }

    public void setPolicy(String policy) {
        this.policy = policy;
    }

    public void init (String name, String policy){
        this.name=name;
        this.policy=policy;
        choosePolicy(policy);
    }
    public void choosePolicy(String policy){
        switch (policy){
            case "MOG":
                this.policy=policy;
                weightAssign(100,0.001,0.09,0,0.01);
                break;
            case "MEG":
                this.policy=policy;
                weightAssign(100,0.001,0.01,0,0.09);
                break;
            case "MVH":
                this.policy=policy;
                weightAssign(50,50,0.01,100,0.01);
                break;
            case "MPH":
                this.policy=policy;
                weightAssign(0.1,0.01,10,0,10);
                break;
            default:
                System.out.println("No Such Policy");
        }
    }
    public void weightAssign(double RTE, double SubRTE, double ELPE, double ELPE0, double PLPE){
        this.RxTxEdge = RTE;
        this.SubRxTxEdge = SubRTE;
        this.weightELP0 = ELPE0;
        this.ELPEph = ELPE;
        this.PLPEph = PLPE;
    }
    public void printPolicy(){
        System.out.println("Policy Set:"+this.policy);
    }
}
