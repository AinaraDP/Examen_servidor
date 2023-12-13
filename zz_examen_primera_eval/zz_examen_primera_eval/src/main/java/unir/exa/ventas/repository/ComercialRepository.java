package unir.exa.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Comercial;

@Repository
public interface ComercialRepository extends JpaRepository<Comercial, Integer> {

	
}
