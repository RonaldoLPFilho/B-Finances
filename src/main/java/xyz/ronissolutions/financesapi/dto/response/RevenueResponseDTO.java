package xyz.ronissolutions.financesapi.dto.response;

import lombok.Builder;
import lombok.Data;
import xyz.ronissolutions.financesapi.domain.RevenueCategories;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class RevenueResponseDTO {
    private Long id;
    private String description;
    private BigDecimal amount;
    private LocalDateTime data;
    private RevenueCategories categories;
}
