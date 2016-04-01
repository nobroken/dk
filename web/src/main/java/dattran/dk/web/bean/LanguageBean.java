package dattran.dk.web.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String VN = "Tiếng Việt";
	private static Map<String, Locale> languages;
	private String language;

	@PostConstruct
	public void init() {
		languages = new LinkedHashMap<String, Locale>();
		languages.put(VN, new Locale("vie"));
		languages.put("English", Locale.ENGLISH);
		language = VN;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<String> getLanguages() {
		return languages.keySet();
	}

	public void handleChange() {
		System.out.println("Lang: " + this.language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(languages.get(this.language));
	}

}
