package xyz.ronissolutions.financesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.ronissolutions.financesapi.domain.Revenue;

@Repository
public interface RevenueRepository extends JpaRepository<Revenue, Long> {
}
