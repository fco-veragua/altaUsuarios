package altaUsuario;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class ValidadorEliminacionUsuarios {
	private Usuario usuario;

	public ValidadorEliminacionUsuarios(Usuario model) {
		this.usuario = model;
	}

	public void validar() {
		// boolean errores = false;
		if ("Administrador".equals(usuario.getTipoUsuario().getDescripcion())) {
			// errores = true;
			FacesMessage msg = new FacesMessage("No se puede borrar");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

}