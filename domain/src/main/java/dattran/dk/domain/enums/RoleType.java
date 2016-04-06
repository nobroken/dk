package dattran.dk.domain.enums;

public enum RoleType {
	TEACHER, HEAD_TEACHER, ADMIN;
	private String role;
	static {
		TEACHER.role = "Giáo viên";
		HEAD_TEACHER.role = "Hiệu trưởng";
		ADMIN.role = "Quản lý";
	}

	public String getRole() {
		return role;
	}
}
