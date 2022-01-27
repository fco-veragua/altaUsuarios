package altaUsuario;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("conversorTipo")
public class ConversorTipoUsuario implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			ServicioTipoUsuario servicio = new ServicioTipoUsuario();
			try {
				return servicio.getTipoPorId(Integer.parseInt(value));
			} catch (NumberFormatException e) {
				throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión",
						"Introduzca un id válido."));
			}
		} else {
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			TipoUsuario tipo = (TipoUsuario) value;
			return String.valueOf(tipo.getId());
		} else {
			return null;
		}
	}

}