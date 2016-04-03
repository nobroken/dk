package dattran.dk.web.bean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dattran.dk.domain.entities.RoleEntity;
import dattran.dk.ejb.filters.RoleFilter;
import dattran.dk.ejb.interfaces.RoleServiceLocal;

@ManagedBean
@SessionScoped
public class RoleController {
	@EJB
	private RoleServiceLocal service;

	private RoleFilter filter;

	private List<RoleEntity> entities;

	private RoleEntity selectedEntity;

}
