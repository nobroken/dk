package dattran.dk.web.bean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dattran.dk.domain.entities.RoleEntity;
import dattran.dk.ejb.interfaces.RoleServiceLocal;

@ManagedBean
@RequestScoped
public class RoleEditView {
	@EJB
	private RoleServiceLocal service;
	private RoleEntity entity;

	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String id = fc.getExternalContext().getRequestParameterMap().get("id");
		entity = service.get(id);
	}

	public RoleEntity getEntity() {
		return entity;
	}

	public void setEntity(RoleEntity entity) {
		this.entity = entity;
	}

	public void edit() {
		System.out.println("Edit");
		service.update(entity);
	}
}
