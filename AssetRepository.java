package legacy;

import java.io.*;
import java.util.*;

public class AssetRepository {

    private static final String FILE_PATH = "data/assets.csv";

    public List<Asset> loadAssets() {
        List<Asset> assets = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                assets.add(new Asset(
                        parts[0],
                        parts[1],
                        parts[2],
                        Double.parseDouble(parts[3])
                ));
            }
        } catch (IOException e) {
            System.out.println("No existing asset file found.");
        }
        return assets;
    }

    public void saveAssets(List<Asset> assets) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Asset asset : assets) {
                bw.write(asset.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}