package xyz.ronissolutions.financesapi.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.ronissolutions.financesapi.dto.APIResponseDTO;
import xyz.ronissolutions.financesapi.dto.request.RevenueRequestDTO;
import xyz.ronissolutions.financesapi.dto.response.RevenueResponseDTO;
import xyz.ronissolutions.financesapi.service.RevenueService;

import java.util.List;

@RestController
@RequestMapping("/api/revenues")
public class RevenueController {
    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @GetMapping
    public ResponseEntity<APIResponseDTO<List<RevenueResponseDTO>>> getAllRevenues() {
        List<RevenueResponseDTO> revenuesDTO = revenueService.getAllRevenues();
        return ResponseEntity.ok(APIResponseDTO.success(HttpStatus.OK, "Receitas encontradas", revenuesDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDTO<RevenueResponseDTO>> getRevenueById(@PathVariable Long id) {
        RevenueResponseDTO responseDTO = revenueService.findById(id);
        return ResponseEntity.ok(APIResponseDTO.success(HttpStatus.OK, "Receita encontrada!", responseDTO));
    }

    @PostMapping
    public ResponseEntity<APIResponseDTO<RevenueResponseDTO>> create(@RequestBody @Valid RevenueRequestDTO revenueRequestDTO) {
        RevenueResponseDTO responseDTO = revenueService.create(revenueRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(APIResponseDTO.success(HttpStatus.CREATED, "Receita criada", responseDTO));

    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponseDTO<RevenueResponseDTO>> update(@PathVariable Long id,  @RequestBody RevenueRequestDTO revenueRequestDTO) {
        RevenueResponseDTO responseDTO = revenueService.update(id, revenueRequestDTO);
        return ResponseEntity.ok(APIResponseDTO.success(HttpStatus.OK, "Receita atualizada", responseDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO<Long>> delete(@PathVariable Long id) {
        revenueService.delete(id);
        return ResponseEntity.ok(APIResponseDTO.success(HttpStatus.OK, "Receita deletada", id));
    }

}
