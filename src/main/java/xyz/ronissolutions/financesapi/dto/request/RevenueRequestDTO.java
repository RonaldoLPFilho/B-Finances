package xyz.ronissolutions.financesapi.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import xyz.ronissolutions.financesapi.domain.RevenueCategories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RevenueRequestDTO {
    @NotNull
    private String description;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private LocalDateTime data;

    @NotNull
    private RevenueCategories categories;
}
