package xyz.ronissolutions.financesapi.service;

import org.springframework.stereotype.Service;
import xyz.ronissolutions.financesapi.domain.Revenue;
import xyz.ronissolutions.financesapi.dto.request.RevenueRequestDTO;
import xyz.ronissolutions.financesapi.dto.response.RevenueResponseDTO;
import xyz.ronissolutions.financesapi.exception.RevenueNotFoundException;
import xyz.ronissolutions.financesapi.mapper.RevenueMapper;
import xyz.ronissolutions.financesapi.repository.RevenueRepository;

import java.util.List;

@Service
public class RevenueService {

    private final RevenueRepository revenueRepository;

    public RevenueService(RevenueRepository revenueRepository) {
        this.revenueRepository = revenueRepository;
    }

    public List<RevenueResponseDTO> getAllRevenues() {
        List<Revenue> revenues = revenueRepository.findAll();

        return RevenueMapper.toResponseList(revenues);
    }

    public RevenueResponseDTO create(RevenueRequestDTO revenueRequestDTO) {
        Revenue revenue = RevenueMapper.toEntity(revenueRequestDTO);
        revenueRepository.save(revenue);

        return RevenueMapper.toResponseDTO(revenue);
    }

    public RevenueResponseDTO findById(Long id) {
        Revenue revenue = revenueRepository.findById(id)
                .orElseThrow(() -> new RevenueNotFoundException(id));

        return RevenueMapper.toResponseDTO(revenue);
    }

    public RevenueResponseDTO update(Long id, RevenueRequestDTO revenueRequestDTO) {

        Revenue revenue = revenueRepository.findById(id)
                .orElseThrow(() -> new RevenueNotFoundException(id));

        revenue.setAmount(revenueRequestDTO.getAmount());
        revenue.setDescription(revenueRequestDTO.getDescription());
        revenue.setDate(revenueRequestDTO.getDate());
        revenue.setCategories(revenueRequestDTO.getCategories());

        revenueRepository.save(revenue);
        return RevenueMapper.toResponseDTO(revenue);
    }

    public RevenueResponseDTO delete(Long id) {
        Revenue revenue = revenueRepository.findById(id)
                .orElseThrow(() -> new RevenueNotFoundException(id));

        revenueRepository.delete(revenue);
        return RevenueMapper.toResponseDTO(revenue);
    }

}
