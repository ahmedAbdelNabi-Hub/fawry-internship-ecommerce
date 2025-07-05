package domain.interfaces.services;

import java.util.List;
import domain.interfaces.IShippable;

public interface IShippingService {
    void ship(List<IShippable> items);
    double calculateShippingFee(List<IShippable> items);
}
