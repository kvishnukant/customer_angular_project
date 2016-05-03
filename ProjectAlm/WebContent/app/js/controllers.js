'use strict';

/* Controllers */

/******** clients controller ********/

angular.module('project.controllers',[]).
controller('addClientCtrl',["clientService","$scope", function(clientService,$scope) {
	
	
	console.log("in addClientCtrl");
	
	// save the client data
	
	$scope.saveClient = function() {
		
		clientService.submit($scope.newclient);
		alert("Client Registered Successfully.....");
		console.log("Client Registered Successfully....."+$scope.newclient);
		$scope.newclient={};
		
		
	};	
	
	
	// Capitalise the input data
	
	$('input').keyup(function(){
		
		$(this).val($(this).val().toUpperCase());
		
	});
	
	
	$("#update").hide();
	
}]).

/******** user controller ********/
controller('addUserCtrl',["userService","$scope", function(userService,$scope) {
	
	
	$scope.checkpwd =function()
	{
		var s1=$("#p1").val();
		var s2=$("#p2").val();
		
		if(s1==s2)
		{
			// do nothing.....
		}
		else
		{
			alert("Password fields must match");
			$scope.newuser.confirmpwd="";
			return false;
		}				
	};
	
	$scope.saveUser = function() {
		userService.submit($scope.newuser);
		alert("User Registered Successfully.....");		
		console.log("User Registered Successfully....."+$scope.newuser);
		$scope.newuser={};
	};
	
	$('input').keyup(function(){
		
		$(this).val($(this).val().toUpperCase());
		
	});
	
	
	
}]).

/******** Login controller ********/

controller('addLoginCtrl',["$scope", function($scope) {
	
	$('input').keyup(function(){
		
		$(this).val($(this).val().toUpperCase());
		
	});
	
}]).


/******** showclient controller ********/

controller('addShowUserCtrl',["userService","$scope", function(userService,$scope) {	
	
	// Retrieve The all users data  
	
	userService.getAll(function(result) {
		$scope.newuser = result.user;
	}); 
		
	// delete the perticular user by id
	
      $scope.deleteUser = function(id) 
      {
    	  
    	  alert("User deleted with id :="+id);
    	  console.log("User deleted with id :="+id);
    	  return userService.deleteUser({id : id}).$promise.then(function(value) 
    		    	{
		              for (var idx in $scope.newuser) 
		              {
		                  if ($scope.newuser[idx].id == id) 
		                  {
		                      $scope.newuser.splice(idx, 1);
		                    		                      
		                  }
		              }
		              window.location.reload(true);
      			});  
    	 
      };	
      
}]).

// Show  Client Data

controller('addShowClientCtrl',["clientService","$scope", function(clientService,$scope) {
	
	// Get all client data
	
	$scope.newclient = clientService.getAllc(function(result) {
			$scope.newclient = result.clientData;
			
		});	
		
	
	// Delete Client by id
	
	 $scope.deleteClient = function(id) 
    {
		 
		 alert("Client deleted with id :="+id);
		 console.log("Client deleted with id :="+id);
		 
  		return clientService.deleteClient({id : id}).$promise.then(function(value) 
  		    	{
		              for (var idx in $scope.newclient) 
		              {
		                  if ($scope.newclient[idx].id == id) 
		                  {
		                      $scope.newclient.splice(idx, 1);
		                    
		                      
		                  }
		              }
		              window.location.reload(true);
  		    	
    			});  
  		
    	};	
	
}]).

/******** role controller ********/

controller('addRoleCtrl',["roleService","userService","$scope", function(roleService,userService,$scope) {
		
	// Get all User data
	userService.getAll(function(result) {
		$scope.roles = result.user;
		
	});
	
	// Save the Role 
	
	$scope.saveRole = function() {
		
		$scope.aRole.name = $scope.selectedRole;
		console.log($scope.aRole);
		roleService.submit($scope.aRole);
		
		alert("Role Added to "+$scope.aRole.name);
		console.log("Role Added Successfully to :"+$scope.aRole.name);
		
		$scope.aRole={};
	};
	
	// Capitalise the text 
	
	$('input').keyup(function(){
		
		$(this).val($(this).val().toUpperCase());
		
	});

}]).

/******** Group controller ********/

controller('addGroupCtrl',["groupService","$scope", function(groupService,$scope) {
	
	// save the group data
	
	$scope.saveGroup = function() {
		groupService.submit($scope.group);
		alert("New Group :" + $scope.group.name+" Added Successfully");		
		console.log("Group Added Successfully"+$scope.group.name);
		$scope.group={};
	};
	
	// Capitalise the text
	
	$('input').keyup(function(){
		
		$(this).val($(this).val().toUpperCase());
		
	});

}]).

/******** Show Group controller ********/

controller('addShowGroupCtrl',["groupService","$scope", function(groupService,$scope) {	
	
	// Get All Group Data
	
	groupService.getAll(function(result) {
		$scope.group = result.group;
	}); 
	
}]).

/******** showRole controller ********/

controller('addShowRoleCtrl',["roleService","$scope", function(roleService,$scope) {	
	
	// Get All Roles 
	
	roleService.getAll(function(result) {
		$scope.role = result.role;
		console.log("Retrieving all roles:"+$scope.role);
	}); 
	
}]).

/******** editClntCtrl controller ********/

controller('editClntCtrl',["clientService","$scope","$routeParams", function(clientService,$scope,$routeParams) {	
	
	
	console.log("in editClntCtrl");
	
	$scope.newclient="";
	
	
	// Retrieve Client By Id
	clientService.getClient({id:$routeParams.id},function(result) {
		$scope.newclient = result.clientData;
		console.log($scope.newclient.revenue);
	}); 
		
	// Update the Client Record
	
	$scope.updateClient=function()
	{			
		clientService.updatec($scope.newclient);	
		$scope.newclient={};
	};
	
	$("#submit").hide();
	
	$("#update").click(function()
	{
		alert("Client Data Updated.....");
	});
		
	// 	Capitalise the text
	
	$('input').keyup(function(){
		
		$(this).val($(this).val().toUpperCase());
		
	});
	
}]);


