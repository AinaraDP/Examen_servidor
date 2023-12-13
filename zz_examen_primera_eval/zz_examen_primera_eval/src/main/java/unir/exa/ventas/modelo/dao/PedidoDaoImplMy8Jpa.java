package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import unir.exa.ventas.modelo.entity.Pedido;
import unir.exa.ventas.repository.PedidoRepository;

@Repository
public class PedidoDaoImplMy8Jpa implements PedidoDao {

	@Autowired
	private PedidoRepository prepo;
	
	@Override
	public Pedido buscarUno(int idPedido) {
		return prepo.findPedidoById(idPedido);
	}

	@Override
	public Pedido insertar(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido modificar(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int eliminar(int idPedido) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Pedido> buscarTodos() {
		
		return prepo.findAll() ;
	}

	@Override
	public List<Pedido> buscarPorCliente(@PathVariable int idCliente) {
		
		return prepo.findPedidoByCliente(idCliente);
	}

	@Override
	public List<Pedido> buscarPorComercial(int idComercial) {
		return prepo.findPedidoByComercial(idComercial);
	}

	@Override
	public List<Pedido> buscarClientePorComercial(int idComercial) {
		return prepo.buscarClientePorComercialAsociado(idComercial);
	}

}
