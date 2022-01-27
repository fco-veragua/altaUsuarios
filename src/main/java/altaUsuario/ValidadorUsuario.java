package altaUsuario;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

public class ValidadorUsuario {
	private Usuario usuario;

	public ValidadorUsuario(Usuario model) {
		this.usuario = model;
	}

	public void validar() {
		boolean errores = false;
		if ("12345678Z".equals(usuario.getNif())) {
			errores = true;
			FacesMessage msg = new FacesMessage("El usuario ya existe");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		if (UtilidadesFechas.esFechaPosterior(usuario.getFechaNacimiento(), new Date())) {
			errores = true;
			FacesMessage msg = new FacesMessage("La Fecha de nacimiento debe ser posterior a la actual");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);

			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

		if (errores) {
			throw new ValidatorException(new FacesMessage("Errores en el formulario de alta"));
		}
	}

}