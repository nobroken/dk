package dattran.dk.domain.entities;

import java.io.Serializable;

public interface EntityInterface<ID extends Serializable> extends Serializable {
	public ID getId();
}