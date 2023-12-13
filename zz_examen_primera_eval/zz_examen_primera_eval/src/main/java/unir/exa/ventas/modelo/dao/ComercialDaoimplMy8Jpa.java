package unir.exa.ventas.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import unir.exa.ventas.modelo.entity.Comercial;
import unir.exa.ventas.repository.ComercialRepository;

@Repository
public class ComercialDaoimplMy8Jpa implements ComercialDao {
	
	@Autowired
	private ComercialRepository comrepo;

	@Override
	public Comercial buscarUno(int idComercial) {
		return comrepo.findById(idComercial).orElse(null);
	}

	@Override
	public int modificar(Comercial comercial) {
		if(buscarUno(comercial.getIdComercial()) != null) {
			comrepo.save(comercial);
			return 1;
		}else
		return 0;
	}

	@Override
	public Comercial insertar(Comercial comercial) {
		try {
			return comrepo.save(comercial);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public int eliminar(int idComercial) {
		if(buscarUno(idComercial) != null){
			comrepo.deleteById(idComercial);
			return 1;
		}else
		return 0;
	}

	@Override
	public List<Comercial> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
