'use strict';

/* Services */

// All Client Services

angular.module('project.services', []).
service('clientService', function($resource) {
    return $resource('', {}, {
      getAllc: {method:'GET', url:'web/clientService/clientDetails'},
      updatec: {method:'PUT', url:'web/clientService/clientUpdate'},
      deleteClient: {method:'DELETE', params: {id: "@id" }, url:'web/clientService/deleteClient/:id' },
      getClient: {method:'GET', params: {id: "@id" }, url:'web/clientService/getClientById/:id' },
      submit: {method:'POST', url:'web/clientService/client'}    
    });    
}).

//All User Services

service('userService', function($resource) {
    return $resource('', {}, {
      getAll: {method:'GET', url:'web/userService/user'},
      submit: {method:'POST', url:'web/userService/adduser'},
      deleteUser: {method:'DELETE', params: {id: "@id" }, url:'web/userService/deleteUser/:id' }
    });
    
}).

//All Role Services

service('roleService', function($resource) {
    return $resource('', {}, {
      getAll: {method:'GET', url:'web/roleService/roleDetails'},      
      submit: {method:'POST', url:'web/roleService/role'}
    });
   
}).

//All Group Services

service('groupService', function($resource) {
    return $resource('', {}, {
      getAll: {method:'GET', url:'web/groupService/groupDetails'},      
      submit: {method:'POST', url:'web/groupService/addgroup'}
    });
   
});