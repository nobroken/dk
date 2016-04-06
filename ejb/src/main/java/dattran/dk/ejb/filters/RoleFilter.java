package dattran.dk.ejb.filters;

import dattran.dk.domain.enums.RoleType;

public class RoleFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private RoleType roleType;
	private String description;

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
