package altaMovil;

import java.time.LocalDate;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("fechaventavalidator")
public class FechaVentaValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		int anyoActual = LocalDate.now().getYear();

		if (!(value instanceof LocalDate)) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fecha NO permitida",
					"Inserte una fecha correcta");

			throw new ValidatorException(message);
		}

		LocalDate dateValue = (LocalDate) value;
		int anyoValue = dateValue.getYear();

		if (anyoValue > anyoActual || anyoValue < 2010) {
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fecha NO permitida",
					"El año ha de ser mayor de 2010 y menor del actual");

			throw new ValidatorException(message);
		}
	}
}