package dattran.dk.ejb.interfaces;

import java.io.Serializable;

import dattran.dk.domain.entities.EntityInterface;

public interface ServiceInterface<ID extends Serializable, Entity extends EntityInterface<ID>> {
	void delete(Entity entity);

	void save(Entity entity);

	void update(Entity entity);

	Entity get(ID id);

}
