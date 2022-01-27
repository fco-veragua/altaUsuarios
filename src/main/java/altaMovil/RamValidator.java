package altaMovil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import lombok.Getter;
import lombok.Setter;

@FacesValidator("ramvalidator")
public class RamValidator implements Validator {

	@Getter
	@Setter
	private String marca;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		int ram = (int) value;

		if ("iphone".equals(marca) && ram > 4) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "RAM no permitida",
					"El iPhone no tiene más de 4GB");

			throw new ValidatorException(message);
		}
	}
}