package ar.com.mytrips.auth

import ar.com.mytrips.Trip


class User {

    String id
    String firstName
    String lastName
    String email
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany = [trips: Trip]

    static constraints = {
        password blank: false, password: true
        email blank: false, unique: true
        firstName nullable: true
        lastName nullable: true
    }

    static mapping = {
        id generator: 'uuid'
        password column: '`password`'
    }

    static mappedBy = [trips: 'owner']

    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

}