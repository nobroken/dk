package dattran.dk.ejb.beans;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dattran.dk.domain.entities.EntityInterface;
import dattran.dk.ejb.interfaces.ServiceInterface;

public abstract class AbstractServiceBean<ID extends Serializable, Entity extends EntityInterface<ID>> implements
		ServiceInterface<ID, Entity> {
	@PersistenceContext(unitName = "dk-ejb")
	protected EntityManager em;

	protected abstract Class<Entity> getEntityClass();

	@Override
	public void delete(Entity entity) {
		Entity toDeleteEntity = get(entity.getId());
		em.remove(toDeleteEntity);
	}

	@Override
	public void save(Entity entity) {
		em.persist(entity);
	}

	@Override
	public void update(Entity entity) {
		em.merge(entity);
	}

	@Override
	public Entity get(ID id) {
		return em.find(getEntityClass(), id);
	}
}
