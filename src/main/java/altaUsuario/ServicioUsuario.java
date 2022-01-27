package altaUsuario;

import java.util.ArrayList;
import java.util.List;

public class ServicioUsuario {

	public List<Usuario> getTodos() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("Juan Antonio", "González", "11111111A", ServicioTipoUsuario.administrador,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Popi", "Chico", "11111111B", ServicioTipoUsuario.usuarioConsulta,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Pepe", "Josejita", "11111111C", ServicioTipoUsuario.usuarioInsercion,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Juan Antonio", "González", "11111111A", ServicioTipoUsuario.administrador,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Popi", "Chico", "11111111D", ServicioTipoUsuario.usuarioConsulta,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Pepe", "Josejita", "11111111E", ServicioTipoUsuario.usuarioInsercion,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Juan Antonio", "González", "11111111F", ServicioTipoUsuario.administrador,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Popi", "Chico", "11111111G", ServicioTipoUsuario.usuarioConsulta,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Pepe", "Josejita", "11111111H", ServicioTipoUsuario.usuarioInsercion,
				UtilidadesFechas.transformarAFecha("09/10/1997")));
		listaUsuarios.add(new Usuario("Pepe", "Josejita", "11111111I", ServicioTipoUsuario.usuarioInsercion,
				UtilidadesFechas.transformarAFecha("09/10/1998")));

		return listaUsuarios;
	}

	public Usuario getTipoPorNif(String nif) {
		return this.getTodos().stream().filter(usu -> nif.equals(usu.getNif())).findFirst().orElse(null);
	}

}