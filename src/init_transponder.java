public class init_transponder {
    private int st_perNode;  //count of sliceable transponder per node;
    private int sliceable;   //count of sub transponder which one transponder can slice;
    private int slCapacity;  //Capacity of sliceable transponder per node;
    private int subcCapacity;
    private int stCapacity;    //sliceable_tansponder_Capacity;
    private int channelCapacity;
    private int substCapacity; //sub-sliceable_tansponder_Capacity;
    private int stChannel;     //sliceable_tansponder_Channel;

    public init_transponder(int st_perNode, int sliceable, int slCapacity, int subcCapacity, int stCapacity, int channelCapacity, int substCapacity, int stChannel) {
        this.st_perNode = st_perNode;
        this.sliceable = sliceable;
        this.slCapacity = slCapacity;
        this.subcCapacity = subcCapacity;
        this.stCapacity = stCapacity;
        this.channelCapacity = channelCapacity;
        this.substCapacity = substCapacity;
        this.stChannel = stChannel;
    }

    public int getSt_perNode() {
        return st_perNode;
    }

    public void setSt_perNode(int st_perNode) {
        this.st_perNode = st_perNode;
    }

    public int getSliceable() {
        return sliceable;
    }

    public void setSliceable(int sliceable) {
        this.sliceable = sliceable;
    }

    public int getSlCapacity() {
        return slCapacity;
    }

    public void setSlCapacity(int slCapacity) {
        this.slCapacity = slCapacity;
    }

    public int getSubcCapacity() {
        return subcCapacity;
    }

    public void setSubcCapacity(int subcCapacity) {
        this.subcCapacity = subcCapacity;
    }

    public int getStCapacity() {
        return stCapacity;
    }

    public void setStCapacity(int stCapacity) {
        this.stCapacity = stCapacity;
    }

    public int getChannelCapacity() {
        return channelCapacity;
    }

    public void setChannelCapacity(int channelCapacity) {
        this.channelCapacity = channelCapacity;
    }

    public int getSubstCapacity() {
        return substCapacity;
    }

    public void setSubstCapacity(int substCapacity) {
        this.substCapacity = substCapacity;
    }

    public int getStChannel() {
        return stChannel;
    }

    public void setStChannel(int stChannel) {
        this.stChannel = stChannel;
    }
}
