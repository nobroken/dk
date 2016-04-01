package dattran.dk.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "language")
@SessionScoped
public class LanguageBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String localeCode = "English";
	private List<String> localeCodes = new ArrayList<String>();

	public String getLocaleCode() {
		return localeCode;
	}

	@PostConstruct
	public void init() {
		localeCodes.add(localeCode);
		localeCodes.add("VN");
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	public List<String> getLocaleCodes() {
		return localeCodes;
	}

	public void handleChange() {
		System.out.println("afsdfds:" + localeCode);
	}

}
