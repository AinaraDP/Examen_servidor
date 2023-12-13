package unir.exa.ventas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import unir.exa.ventas.modelo.dao.ClienteDao;
import unir.exa.ventas.modelo.dao.ComercialDao;
import unir.exa.ventas.modelo.dao.PedidoDao;
import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.modelo.entity.Pedido;
import unir.exa.ventas.repository.ClienteRepository;
import unir.exa.ventas.repository.ComercialRepository;
import unir.exa.ventas.repository.PedidoRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteDao clidao;
	
	@Autowired
	private ClienteRepository clirepo;
	
	@Autowired
	private ComercialRepository comrepo;
	
	@Autowired
	private ComercialDao comdao;
	
	@Autowired
	private PedidoRepository prepo;
	
	@Autowired
	private PedidoDao pdao;

	@GetMapping({"/clientes/todos"})
	public String buscarTodos(Model model) {
		List<Cliente> clientes = clirepo.findAll();
		model.addAttribute("clientes", clientes);
		return "clientesTodos";
	}
	
	@GetMapping({"/clientes/detalle/{id}"})
	public String buscarPorId(@PathVariable ("id") int idCliente, Model model) {
		Cliente clientes = clidao.buscarUno(idCliente);
		model.addAttribute("clientes", clientes);
		return "clientesDetalle";
	}
	
	@GetMapping({"/clientes/eliminar/{id}"})
	public String eliminarCliente(@PathVariable("id") int idCliente, Model model) {
		List<Cliente> clientes = clirepo.findAll();
		if(clidao.eliminar(idCliente) == 1) {
			model.addAttribute("mensaje", "Cliente eliminado");
			model.addAttribute("clientes", clientes);
		}else {
			model.addAttribute("clientes", clientes);
			model.addAttribute("mensaje", "Cliente no eliminado");
		}
		;
		return "ClientesLista";
	}
	
}
