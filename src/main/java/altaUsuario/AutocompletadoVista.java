package altaUsuario;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import lombok.Data;

@ManagedBean
@ViewScoped
@Data
public class AutocompletadoVista {

	public ServicioTipoUsuario servicio = new ServicioTipoUsuario();

	public List<TipoUsuario> obtenerTodosTipos(String query) {
		this.servicio = new ServicioTipoUsuario();
		String queryLowerCase = query.toLowerCase();
		List<TipoUsuario> todosTipos = servicio.getTodos();
		return todosTipos.stream().filter(
				t -> t.getDescripcion().toLowerCase().contains(queryLowerCase) || ("" + t.getId()).contains(query))
				.collect(Collectors.toList());
	}

	public void validar() {
		System.out.println("Válido");
	}
}