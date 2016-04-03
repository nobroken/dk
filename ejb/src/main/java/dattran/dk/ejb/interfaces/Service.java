package dattran.dk.ejb.interfaces;

import java.io.Serializable;
import java.util.List;

import dattran.dk.domain.entities.EntityInterface;
import dattran.dk.ejb.filters.Filter;

public interface Service<ID extends Serializable, Entity extends EntityInterface<ID>> {
	void delete(Entity entity);

	void save(Entity entity);

	void update(Entity entity);

	Entity get(ID id);

	Class<Entity> getEntityClass();

	List<Entity> find(Filter filter);
}
