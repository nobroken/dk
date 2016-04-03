package dattran.dk.ejb.beans;

import java.util.List;

import javax.ejb.Stateless;

import com.querydsl.jpa.impl.JPAQuery;

import dattran.dk.domain.entities.QRoleEntity;
import dattran.dk.domain.entities.RoleEntity;
import dattran.dk.ejb.filters.Filter;
import dattran.dk.ejb.filters.RoleFilter;
import dattran.dk.ejb.interfaces.RoleServiceLocal;
import dattran.dk.ejb.interfaces.RoleServiceRemote;

/**
 * Session Bean implementation class RoleServiceBean
 */
@Stateless(name = "RoleService", mappedName = "RoleService")
public class RoleServiceBean extends AbstractServiceBean<String, RoleEntity> implements RoleServiceRemote,
		RoleServiceLocal {

	@Override
	public Class<RoleEntity> getEntityClass() {
		return RoleEntity.class;
	}

	@Override
	public List<RoleEntity> find(Filter filter) {
		RoleFilter roleFilter = (RoleFilter) filter;
		QRoleEntity role = QRoleEntity.roleEntity;
		JPAQuery<RoleEntity> query = new JPAQuery<RoleEntity>(em);
		query.from(role);
		if (roleFilter != null) {
			if (roleFilter.getName() != null) {
				query.where(role.name.toUpperCase().startsWith(roleFilter.getName().toUpperCase()));
			}
			if (roleFilter.getDescription() != null) {
				query.where(role.description.toUpperCase().contains(roleFilter.getDescription().toUpperCase()));
			}
		}
		return query.fetch();
	}

}
