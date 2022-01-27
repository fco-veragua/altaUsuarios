package altaMovil;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import lombok.Getter;
import lombok.Setter;

@FacesValidator("sovalidator")
public class SoValidator implements Validator {

	@Getter
	@Setter
	private String marca;

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		String so = (String) value;

		if (!("IOS".equals(so) || ("Android".equals(so)))) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sistema operativo no permitido",
					"El sistema operativo debe ser IOS o Android");

			throw new ValidatorException(message);
		}

		if (("IOS".equals(so) && !("iphone".equals(marca)))) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La marca no es iphone",
					"La marca no es iphone");

			throw new ValidatorException(message);
		}
	}
}
