package dattran.dk.web.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import dattran.dk.domain.entities.EntityInterface;
import dattran.dk.ejb.interfaces.Service;

public abstract class ItemsController<ItemEntity extends EntityInterface, ItemService extends Service> {
	public static enum PersistAction {
		CREATE, DELETE, UPDATE
	}

	public abstract ItemService getService();

	public abstract ItemEntity getSelected();

	public abstract void setSelected(ItemEntity selected);

	public abstract List<ItemEntity> getItems();

	public void prepareCreate() {
		setSelected((ItemEntity) getService().getNew());
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
			getService().delete(getSelected());
			getItems().remove(getSelected());
			setSelected(null);
			break;
		}
		case UPDATE: {
			getService().update(getSelected());
			break;
		}
		case CREATE: {
			getService().save(getSelected());
			getItems().add(getSelected());
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
}
