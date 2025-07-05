package domain.interfaces;

import java.time.LocalDate;

public interface IExpirable {
    LocalDate getExpiryDate();
    boolean isExpired();
}
