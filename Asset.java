package legacy;
public class Asset {
    public String assetId;
    public String name;
    public String type;
    public double value;
    public Asset(String assetId, String name, String type, double value) {
        this.assetId = assetId;
        this.name = name;
        this.type = type;
        this.value = value;
    }
    @Override
    public String toString() {
        return assetId + "," + name + "," + type + "," + value;
    }
}