package dattran.dk.web.bean.role;

import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dattran.dk.domain.entities.RoleEntity;
import dattran.dk.domain.enums.RoleType;
import dattran.dk.ejb.interfaces.RoleService;
import dattran.dk.ejb.interfaces.RoleServiceLocal;
import dattran.dk.web.bean.ItemsController;

@ManagedBean
@ViewScoped
public class RoleController extends ItemsController<RoleEntity, RoleService> {
	@EJB
	private RoleServiceLocal service;
	private List<RoleEntity> items;
	private RoleEntity selected;

	@Override
	public RoleService getService() {
		return service;
	}

	@Override
	public RoleEntity getSelected() {
		return selected;
	}

	@Override
	public void setSelected(RoleEntity selected) {
		this.selected = selected;

	}

	@Override
	public List<RoleEntity> getItems() {
		if (items == null)
			items = service.find(null);
		return items;
	}

	public List<RoleType> getRoleTypes() {
		return Arrays.asList(RoleType.values());
	}

}
