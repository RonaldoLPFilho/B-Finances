package xyz.ronissolutions.financesapi.mapper;

import xyz.ronissolutions.financesapi.domain.Revenue;
import xyz.ronissolutions.financesapi.dto.request.RevenueRequestDTO;
import xyz.ronissolutions.financesapi.dto.response.RevenueResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class RevenueMapper {

    public static RevenueResponseDTO toResponseDTO(Revenue revenue) {
        RevenueResponseDTO revenueResponseDTO = RevenueResponseDTO.builder()
                .id(revenue.getId())
                .description(revenue.getDescription())
                .amount(revenue.getAmount())
                .data(revenue.getData())
                .categories(revenue.getCategories())
                .build();

        return revenueResponseDTO;
    }

    public static Revenue toEntity(RevenueRequestDTO revenueRequestDTO) {
        Revenue revenue = new Revenue();

        revenue.setDescription(revenueRequestDTO.getDescription());
        revenue.setAmount(revenueRequestDTO.getAmount());
        revenue.setData(revenueRequestDTO.getData());
        revenue.setCategories(revenueRequestDTO.getCategories());

        return revenue;
    }

    public static List<RevenueResponseDTO> toResponseList(List<Revenue> revenues) {
        return revenues.stream()
                .map(RevenueMapper::toResponseDTO)
                .toList();

    }
}
