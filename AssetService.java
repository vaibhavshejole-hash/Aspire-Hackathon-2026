package legacy;
import java.util.*;
public class AssetService {
    private AssetRepository repository = new AssetRepository();
    private List<Asset> assets = repository.loadAssets();
    private static final String[] ASSET_TYPES = {
        "EQUITY", "BOND", "ETF", "MUTUAL_FUND"
    };
    public void generateRandomAssets(int count) {
        Random random = new Random();
        for (int i = 1; i <= count; i++) {
            String assetId = "A" + (1000 + i);
            String name = "Asset-" + i;
            String type = ASSET_TYPES[random.nextInt(ASSET_TYPES.length)];
            // Asset value between 10,000 and 1,000,000
            double value = 10000 + (1000000 - 10000) * random.nextDouble();
            assets.add(new Asset(assetId, name, type, value));
        }
        repository.saveAssets(assets);
    }
    public double calculateTotalValue() {
        double total = 0;
        for (Asset asset : assets) {
            total += asset.value;
        }
        return total;
    }
    public void printSampleAssets(int limit) {
        for (int i = 0; i < Math.min(limit, assets.size()); i++) {
            Asset asset = assets.get(i);
            System.out.println(
                asset.assetId + " | " +
                asset.name + " | " +
                asset.type + " | " +
                asset.value
            );
        }
    }
    public int getAssetCount() {
        return assets.size();
    }
}
