public class init_fiber {
    private int FS;         // frequency slot;
    private int guardband;
    private int fiberCapacity; // in FS

    public init_fiber(int FS, int guardband, int fiberCapacity) {
        this.FS = FS;
        this.guardband = guardband;
        this.fiberCapacity = fiberCapacity;
    }

    public int getFS() {
        return FS;
    }

    public void setFS(int FS) {
        this.FS = FS;
    }

    public int getGuardband() {
        return guardband;
    }

    public void setGuardband(int guardband) {
        this.guardband = guardband;
    }

    public int getFiberCapacity() {
        return fiberCapacity;
    }

    public void setFiberCapacity(int fiberCapacity) {
        this.fiberCapacity = fiberCapacity;
    }
}
