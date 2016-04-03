package dattran.dk.web.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dattran.dk.domain.entities.RoleEntity;
import dattran.dk.ejb.filters.RoleFilter;
import dattran.dk.ejb.interfaces.RoleServiceLocal;

@ManagedBean
@ViewScoped
public class RoleListView {

	@EJB
	private RoleServiceLocal service;

	private RoleFilter filter;

	private List<RoleEntity> entities;

	private RoleEntity entity;

	@PostConstruct
	public void init() {
		filter = new RoleFilter();
		search();
	}

	public RoleFilter getFilter() {
		return filter;
	}

	public void setFilter(RoleFilter filter) {
		this.filter = filter;
	}

	public List<RoleEntity> getEntities() {
		return entities;
	}

	public void search() {
		entities = service.find(filter);
	}

	public void delete(RoleEntity entity) {
		service.delete(entity);
		search();
	}

	public RoleEntity getEntity() {
		return entity;
	}

	public void setEntity(RoleEntity entity) {
		this.entity = entity;
	}

	public void changeEntity(RoleEntity entity) {
		this.entity = entity;
	}

	public void updateEntity() {
		service.update(entity);
	}
}
