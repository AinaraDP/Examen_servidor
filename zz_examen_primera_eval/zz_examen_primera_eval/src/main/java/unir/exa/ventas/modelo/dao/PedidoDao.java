package unir.exa.ventas.modelo.dao;

import java.util.List;

import unir.exa.ventas.modelo.entity.Pedido;

public interface PedidoDao {

	Pedido buscarUno (int idPedido);
	Pedido insertar (Pedido pedido);
	Pedido modificar (Pedido pedido);
	int eliminar (int idPedido);
	List<Pedido> buscarTodos();
	List<Pedido> buscarPorCliente(int idCliente);
	List<Pedido> buscarPorComercial (int idComercial);
	List<Pedido> buscarClientePorComercial (int idComercial);
	
	
}
