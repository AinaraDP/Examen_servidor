package unir.exa.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import unir.exa.ventas.modelo.dao.PedidoDao;
import unir.exa.ventas.modelo.entity.Pedido;
import unir.exa.ventas.repository.PedidoRepository;

@Controller
public class PedidosController {

	@Autowired
	private PedidoRepository prepo;
	
	@Autowired
	private PedidoDao pdao;
	
	//Buscar todos los pedidos
	@GetMapping({"/pedidos/todos"})
	public String pedidosTodos( Model model) {
		List<Pedido> pedidos = prepo.findAll();
		model.addAttribute("pedidos", pedidos);
		return "pedidosTodos";
		}
	
	//Buscar pedidos por cliente
	@GetMapping({"/pedidos/cliente/{id}"})
	public String pedidosPorCliente(@PathVariable ("id") int idCliente, Model model) {
		List<Pedido> pedidos = pdao.buscarPorCliente(idCliente);
		model.addAttribute("pedidos", pedidos);
		return "pedidosPorCliente";
	}
	
	//Buscar pedidos por comercial 
	@GetMapping({"/pedidos/comercial/{id}"})
	public String pedidosPorComercial(@PathVariable ("id") int idComercial, Model model) {
		List<Pedido> pedidos = pdao.buscarPorComercial(idComercial);
		model.addAttribute("pedidos", pedidos);
		return "pedidosPorComercial";
	}
	
	//Buscar pedidos por idPedido
	@GetMapping({"/pedidos/{id}"})
	public String pedidosPorId(@PathVariable ("id") int idPedido, Model model) {
		Pedido pedidos = pdao.buscarUno(idPedido);
		model.addAttribute("pedidos", pedidos);
		return "pedidosPorId";
	}
	
	@GetMapping({"/clientes/comerciales/{id}"})
	public String buscarPorComercialAsociado(@PathVariable ("id") int idComercial, Model model) {
		List<Pedido> pedidos = pdao.buscarClientePorComercial(idComercial);
		model.addAttribute("pedidos", pedidos);
		return "clientesPorComercial";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

