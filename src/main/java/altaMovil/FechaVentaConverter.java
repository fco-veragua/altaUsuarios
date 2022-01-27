package altaMovil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;

@FacesConverter("fechaventaconverter")
public class FechaVentaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {

		LocalDate fecha = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		try {
			fecha = LocalDate.parse("01-01-" + value, formatter);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de conversión de fecha",
					"Error de conversión de fecha");
			throw new ValidatorException(message);
		}

		return fecha;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		LocalDate fecha = (LocalDate) value;

		return fecha.format(DateTimeFormatter.ofPattern("yyyy")).toString();
	}

}