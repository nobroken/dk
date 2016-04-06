package dattran.dk.web.bean.role;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import dattran.dk.domain.entities.RoleEntity;
import dattran.dk.domain.enums.RoleType;
import dattran.dk.ejb.interfaces.RoleServiceLocal;

@ManagedBean
@ViewScoped
public class RolesController {
	@EJB
	private RoleServiceLocal service;
	private List<RoleEntity> items;
	private RoleEntity selected;

	public static enum PersistAction {
		CREATE, DELETE, UPDATE
	}

	@PostConstruct
	public void init() {
		items = service.find(null);
	}

	public RoleEntity getSelected() {
		return selected;
	}

	public void setSelected(RoleEntity selected) {
		this.selected = selected;
	}

	public List<RoleEntity> getItems() {
		return items;
	}

	public void prepareCreate() {
		selected = new RoleEntity();
	}

	public void destroy() {
		persist(PersistAction.DELETE, "Role deleted sucessfully");
	}

	public void create() {
		persist(PersistAction.CREATE, "Role created sucessfully");
	}

	public void edit() {
		persist(PersistAction.UPDATE, "Role updated sucessfully");
	}

	private void persist(PersistAction persistAction, String msg) {
		switch (persistAction) {
		case DELETE: {
			service.delete(selected);
			items.remove(selected);
			selected = null;
			break;
		}
		case UPDATE: {
			service.update(selected);
			break;
		}
		case CREATE: {
			service.save(selected);
			items.add(selected);
			break;
		}

		default:
			break;
		}
		addSuccessMessage(msg);
	}

	private void addSuccessMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
		FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
	}

	public List<RoleType> getRoleTypes() {
		return Arrays.asList(RoleType.values());
	}
}
