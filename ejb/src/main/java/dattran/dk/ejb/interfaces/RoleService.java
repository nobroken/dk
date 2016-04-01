package dattran.dk.ejb.interfaces;

import java.io.Serializable;
import java.util.List;

import dattran.dk.domain.entities.RoleEntity;

public interface RoleService extends ServiceInterface<String, RoleEntity> {
	List<RoleEntity> find(RoleFilter filter);

	public static class RoleFilter implements Serializable {
		private static final long serialVersionUID = 1L;
		private String name;
		private String description;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	}
}
