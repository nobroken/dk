package dattran.dk.web.converter;

import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("LocaleConverter")
public class LocaleConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return new Locale(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Locale locale = (Locale) value;
		return locale.toString();
	}
}
