package dattran.dk.web.bean.role;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import dattran.dk.domain.entities.RoleEntity;
import dattran.dk.ejb.interfaces.RoleServiceLocal;

@ManagedBean
@ApplicationScoped
public class RoleCombo {
	@EJB
	private RoleServiceLocal service;
	private List<RoleEntity> items;

	@PostConstruct
	public void init() {
		items = service.find(null);
	}

	public List<RoleEntity> getItems() {
		return items;
	}

}
