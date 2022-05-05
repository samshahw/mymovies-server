package it.ss.mymoviesserver.model;

public enum UserRole {

    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String userRole;

    UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String get() {
        return this.userRole;
    }

    public static UserRole getRoleByName(String roleName) {
        if (roleName.equals("ROLE_ADMIN")) {
            return UserRole.ROLE_ADMIN;
        } else if (roleName.equals("ROLE_USER")) {
            return UserRole.ROLE_USER;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
