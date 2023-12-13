package unir.exa.ventas.modelo.dao;

import java.util.List;
import unir.exa.ventas.modelo.entity.Cliente;

public interface ClienteDao {

	Cliente buscarUno (int idCliente);
	Cliente modificar (Cliente cliente);
	Cliente insertar (Cliente cliente);
	List<Cliente> buscarTodos();
	int eliminar (int idCliente);
}
