package altaUsuario;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import lombok.Data;

@ManagedBean
@SessionScoped
@Data
public class RejillaVista {

	public ServicioUsuario servicio = new ServicioUsuario();

	private Usuario userSelected;

	private List<Usuario> usuarios = servicio.getTodos();

	public ServicioUsuario getServicio() {
		return servicio;
	}

	public void setServicio(ServicioUsuario servicio) {
		this.servicio = servicio;
	}

	public Usuario getUserSelected() {
		return userSelected;
	}

	public void setUserSelected(Usuario userSelected) {
		this.userSelected = userSelected;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	/*
	 * public boolean globalFilterFunction(Object value, Object filter, Locale
	 * locale) { String filterText = (filter == null) ? null :
	 * filter.toString().trim().toLowerCase(); if
	 * (LangUtils.isValueBlank(filterText)) { return true; }
	 * 
	 * Usuario usuario = (Usuario) value; return
	 * usuario.getNif().toLowerCase().contains(filterText) ||
	 * usuario.getNombre().toLowerCase().contains(filterText) ||
	 * usuario.getApellido().toLowerCase().contains(filterText) ||
	 * usuario.getTipoUsuario().toString().toLowerCase().contains(filterText) ||
	 * usuario.getFechaNacimiento(); }
	 */
	public void delete() {
		userSelected.eliminar();
		if (!(userSelected.getTipoUsuario().equals(ServicioTipoUsuario.administrador))) {
			usuarios.remove(userSelected);
			userSelected = null;
		}

	}

}