'use strict';

angular.module('project', ['ngRoute','ngResource',
                           'project.services',
                           'project.controllers']).
config(['$routeProvider',function($routeProvider) {
    $routeProvider.
        when('/', 		 {templateUrl: 'app/partials/login.html',		  controller:'addLoginCtrl'}).
    	when('/clntreg', {templateUrl: 'app/partials/clientRegister.html',controller: 'addClientCtrl'}).
    	when('/userreg', {templateUrl: 'app/partials/userRegister.html',  controller: 'addUserCtrl'}).
    	when('/regusr',  {templateUrl: 'app/partials/showUsers.html',     controller: 'addShowUserCtrl'}).
    	when('/regcnlts',{templateUrl: 'app/partials/showClients.html',   controller: 'addShowClientCtrl'}).
    	when('/updtcnlt',{templateUrl: 'app/partials/clientRegister.html',controller: 'addClientCtrl'}).    	
    	when('/reggrps', {templateUrl: 'app/partials/showGroups.html',    controller: 'addShowGroupCtrl'}).    	
    	when('/regroles',{templateUrl: 'app/partials/showRoles.html',     controller: 'addShowRoleCtrl'}).
    	when('/grp', 	 {templateUrl: 'app/partials/group.html',         controller:'addGroupCtrl'}).
    	when('/role',    {templateUrl: 'app/partials/role.html',		  controller:'addRoleCtrl'}).    	
    	when('/admin',   {templateUrl: 'app/partials/admin.html'}).
		when('/client/:id',{templateUrl: 'app/partials/clientRegister.html',controller:'editClntCtrl'});
    	
}]);