package ar.com.mytrips.auth

import grails.gorm.DetachedCriteria
import groovy.transform.ToString
import org.apache.commons.lang.builder.HashCodeBuilder

@ToString(cache=true, includeNames=true, includePackage=false)
class UserRole implements Serializable {

    User user
    Role role

    @Override
    boolean equals(other) {
        if (other instanceof UserRole) {
            other.userId == user?.id && other.roleId == role?.id
        }
    }

    @Override
    int hashCode() {
        def builder = new HashCodeBuilder()
        if (user) builder.append(user.id)
        if (role) builder.append(role.id)
        builder.toHashCode()
    }

    static UserRole create(User user, Role role, boolean flush = false) {
        def instance = new UserRole(user: user, role: role)
        instance.save(flush: flush)
        instance
    }

    static constraints = {
        role validator: { Role r, UserRole ur ->
            if (ur.user?.id) {
                withNewSession {
                    if (exists(ur.user.id, r.id)) {
                        return ['userRole.exists']
                    }
                }
            }
        }
    }

    static boolean exists(String userId, Long roleId) {
        criteriaFor(userId, roleId).count()
    }

    private static DetachedCriteria criteriaFor(String userId, Long roleId) {
        where {
            user == User.load(userId) &&
                    role == Role.load(roleId)
        }
    }

    static mapping = {
        id composite: ['user', 'role']
        version false
    }
}