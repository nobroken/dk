package dattran.dk.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "location")
@SessionScoped
public class LocationBean implements Serializable {
	private static final Locale vnLocale = new Locale("vie");
	private static final long serialVersionUID = 1L;
	private Locale currentLocale = vnLocale;
	private final List<Locale> locales = new ArrayList<Locale>();

	@PostConstruct
	public void init() {
		locales.add(vnLocale);
		locales.add(Locale.ENGLISH);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(vnLocale);
	}

	public Locale getCurrentLocale() {
		return currentLocale;
	}

	public void setCurrentLocale(Locale currentLocale) {
		this.currentLocale = currentLocale;
	}

	public List<Locale> getLocales() {
		return locales;
	}

	public void changeLocale() {
		FacesContext.getCurrentInstance().getViewRoot().setLocale(this.currentLocale);
	}

}
