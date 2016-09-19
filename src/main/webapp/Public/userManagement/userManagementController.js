// controller used for login page
userManagementModule.controller("userManagementController", [ '$scope',
		'$rootScope', '$location', 'userManagementService',
		
		function($scope, $rootScope, $location, userManagementService) {
			userManagementService.getAllUser(function(users) {
				console.log(" in userManagementController" + users);
				$scope.usersDetails = users;
			});

			$scope.edit = function (id) {
			      console.log("inside edit" +id);
			      userManagementService.edit(id,function (editUser){
			    	  console.log(" in edit success" +editUser)
			    	  $rootScope.userDto = editUser;
			      })
			}
		} ]);