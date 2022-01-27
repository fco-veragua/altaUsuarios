package altaUsuario;

import java.util.ArrayList;
import java.util.List;

public class ServicioTipoUsuario {

	static TipoUsuario administrador = new TipoUsuario(1, "Administrador");
	static TipoUsuario usuarioConsulta = new TipoUsuario(2, "Usuario Consulta");
	static TipoUsuario usuarioInsercion = new TipoUsuario(1, "Usuario Inserción");

	public List<TipoUsuario> getTodos() {
		List<TipoUsuario> listaTipos = new ArrayList<TipoUsuario>();
		listaTipos.add(administrador);
		listaTipos.add(usuarioConsulta);
		listaTipos.add(usuarioInsercion);

		return listaTipos;
	}

	public TipoUsuario getTipoPorId(int id) {
		return this.getTodos().stream().filter(usu -> usu.getId() == id).findFirst().orElse(null);
	}

}