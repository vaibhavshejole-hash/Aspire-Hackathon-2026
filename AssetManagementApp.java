package legacy;
public class AssetManagementApp {
    public static void main(String[] args) {
        AssetService service = new AssetService();
        System.out.println("Generating 1000 random assets...");
        service.generateRandomAssets(1000);
        System.out.println("\nTotal number of assets:");
        System.out.println(service.getAssetCount());
        System.out.println("\nSample assets (first 10):");
        service.printSampleAssets(10);
        System.out.println("\nTotal Portfolio Value:");
        System.out.println(service.calculateTotalValue());
    }
}
