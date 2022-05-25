grails.plugin.springsecurity.filterChain.chainMap = [
        //Stateless chain
        [
                pattern: '/**',
                filters: 'JOINED_FILTERS,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ]


]

grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/',               access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
        [pattern: '/thing/register', access: 'isAuthenticated()', httpMethod: 'PUT'],
        [pattern: '*',               access: ['IS_AUTHENTICATED_ANONYMOUSLY']],
]
