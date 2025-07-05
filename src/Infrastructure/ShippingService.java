package Infrastructure;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import domain.interfaces.IShippable;
import domain.interfaces.services.IShippingService;

public class ShippingService implements IShippingService {
    private static final double BASE_FEE = 5.0;
    private static final double PER_KG_RATE = 2.0;

    @Override
    public double calculateShippingFee(List<IShippable> items) {
        double totalWeight = items.stream()
                .mapToDouble(IShippable::getWeight)
                .sum();
        return Math.ceil((BASE_FEE + (totalWeight * PER_KG_RATE)) / 10) * 10; // Round to nearest 10
    }

    @Override
    public void ship(List<IShippable> items) {
        double totalWeight = 0;
        System.out.println("\n** Shipment notice **");
        totalWeight = printShipmentItems(items);
        System.out.printf("Total package weight: %.1fkg%n", totalWeight);
    }

    private double printShipmentItems(List<IShippable> items) {
        double totalWeight = 0;

        Map<String, Integer> itemCount = new LinkedHashMap<>();
        Map<String, Double> itemWeight = new LinkedHashMap<>();

        for (IShippable item : items) {
            String name = item.getName();
            itemCount.put(name, itemCount.getOrDefault(name, 0) + 1);
            itemWeight.put(name, item.getWeight());
            totalWeight += item.getWeight();
        }

        for (String name : itemCount.keySet()) {
            int count = itemCount.get(name);
            double singleWeightKg = itemWeight.get(name);
            double totalWeightG = count * singleWeightKg * 1000;
            System.out.printf("%dx %s %.0fg%n", count, name, totalWeightG);
        }

        return totalWeight;
    }
}
