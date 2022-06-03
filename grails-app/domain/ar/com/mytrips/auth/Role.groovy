package ar.com.mytrips.auth

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role {

    String id
    String authority

    static constraints = {
        authority blank: false, unique: true
    }

    static mapping = {
        cache true
    }

    static Role getDefaultRole() {
        findByAuthority("ROLE_USER")
    }
}