package unir.exa.ventas.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import unir.exa.ventas.modelo.dao.PedidoDao;
import unir.exa.ventas.modelo.entity.Pedido;

@RestController
public class PedidoRestController {
	
	@Autowired
	private PedidoDao pdao;
	
	@GetMapping("/todos")
	public List<Pedido> findAll(){
		return pdao.buscarTodos();
	}
	
	@GetMapping("/pedido/{idCliente}")
	public List<Pedido> pedidoPorCliente(@PathVariable int idCliente) {
		return pdao.buscarPorCliente(idCliente);
	}
	

}
