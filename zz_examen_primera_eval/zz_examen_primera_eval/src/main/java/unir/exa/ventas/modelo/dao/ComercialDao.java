package unir.exa.ventas.modelo.dao;

import java.util.List;

import unir.exa.ventas.modelo.entity.Comercial;

public interface ComercialDao {

	Comercial buscarUno (int idComercial);
	int modificar (Comercial comercial);
	Comercial insertar (Comercial comercial);
	int eliminar (int idComercial);
	List<Comercial> buscarTodos();
}
