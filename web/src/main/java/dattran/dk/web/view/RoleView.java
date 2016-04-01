package dattran.dk.web.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dattran.dk.domain.entities.RoleEntity;
import dattran.dk.ejb.interfaces.RoleService.RoleFilter;
import dattran.dk.ejb.interfaces.RoleServiceLocal;

@ManagedBean
@ViewScoped
public class RoleView {
	@EJB
	private RoleServiceLocal roleService;
	private RoleEntity currentRole;
	private List<RoleEntity> roles;
	private RoleFilter filter;

	@PostConstruct
	public void init() {
		currentRole = new RoleEntity();
		filter = new RoleFilter();
		roles = roleService.find(filter);
	}

	public RoleEntity getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(RoleEntity currentRole) {
		this.currentRole = currentRole;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public RoleFilter getFilter() {
		return filter;
	}

	public void setFilter(RoleFilter filter) {
		this.filter = filter;
	}

}
