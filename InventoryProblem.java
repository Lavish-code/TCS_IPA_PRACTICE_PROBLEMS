import java.util.*;

class Inventory {
    String inventoryId;
    int maximumQuantity;
    int currentQuantity;
    int threshold;

    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }
}

public class InventoryProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory[] arr = new Inventory[4];

        // Reading 4 inventory objects
        for (int i = 0; i < arr.length; i++) {
            String inventoryId = sc.nextLine();
            int maxQty = sc.nextInt();
            int currQty = sc.nextInt();
            int threshold = sc.nextInt();
            sc.nextLine(); // Consume the leftover newline
            arr[i] = new Inventory(inventoryId, maxQty, currQty, threshold);
        }

        int limit = sc.nextInt();

        Inventory[] res = Replenish(arr, limit);

        // Print result with status
        for (int i = 0; i < res.length; i++) {
            Inventory inv = res[i];
            int threshold = inv.threshold;
            String status;

            if (threshold > 75) {
                status = "Critical Filling";
            } else if (threshold >= 50) {
                status = "Moderate Filling";
            } else {
                status = "Non-Critical Filling";
            }

            System.out.println(inv.inventoryId + " " + status);
        }
    }

    public static Inventory[] Replenish(Inventory[] arr, int limit) {
        ArrayList<Inventory> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (limit >= arr[i].threshold) {
                list.add(arr[i]);
            }
        }

        return list.toArray(new Inventory[0]);
    }
}
