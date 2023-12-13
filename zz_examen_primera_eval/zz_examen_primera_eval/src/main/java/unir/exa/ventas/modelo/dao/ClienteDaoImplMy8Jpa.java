package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Cliente;
import unir.exa.ventas.repository.ClienteRepository;

@Repository
public class ClienteDaoImplMy8Jpa implements ClienteDao {

	@Autowired
	private ClienteRepository clirepo;
	
	@Override
	public Cliente buscarUno(int idCliente) {
		return clirepo.findById(idCliente).orElse(null);
	}

	@Override
	public Cliente modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cliente> buscarTodos() {
		return clirepo.findAll();
	}

	@Override
	public Cliente insertar(Cliente cliente) {
		try {
			return clirepo.save(cliente);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
		
	}

	@Override
	public int eliminar(int idCliente) {
	    try {
	        clirepo.deleteById(idCliente);
	        return 1; // Se eliminó exitosamente
	    } catch (Exception e) {
	        return 0; // No se encontró un cliente con el ID proporcionado
	    }
	}



}
