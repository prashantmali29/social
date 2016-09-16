// controller used for login page
userManagementModule.controller("userManagementController", ['$scope','$rootScope' ,'$location', 'userManagementService', function ($scope,$rootScope, $location, userManagementService) {

	console.log(" in userManagementController");
	
	userManagementService.getAllUser(function(users){
 	   console.log(" in userManagementController" +users);
 	   $scope.usersDetails = users;
     });

}]);