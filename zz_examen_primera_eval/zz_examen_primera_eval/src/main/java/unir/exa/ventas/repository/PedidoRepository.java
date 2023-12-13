package unir.exa.ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	@Query("select p from Pedido p where p.cliente.idCliente =?1")
	public List<Pedido> findPedidoByCliente(int idCliente);
	
	@Query("select p from Pedido p where p.comercial.idComercial =?1")
	public List<Pedido> findPedidoByComercial(int idComercial);
	
	@Query("select p from Pedido p where p.idPedido =?1")
	public Pedido findPedidoById(int idPedido);
	
	@Query("SELECT p from Pedido p join p.comercial where p.comercial.idComercial=?1")
	public List<Pedido> buscarClientePorComercialAsociado(int idComercial);
}
