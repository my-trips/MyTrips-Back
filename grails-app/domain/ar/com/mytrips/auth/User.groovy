package ar.com.mytrips.auth


class User {

    String firstName
    String lastName
    String email
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static constraints = {
        password blank: false, password: true
        email blank: false, unique: true
        firstName nullable: true
        lastName nullable: true
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

}