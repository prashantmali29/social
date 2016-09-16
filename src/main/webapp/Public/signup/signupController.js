// controller used for sign-up page
signupModule.controller("signupController", ['$scope', '$location', 'signupService', function ($scope, $location, signupService) {

   
    $scope.signUp = function () {
    	
       console.log("in signup controller");
    	signupService.performSignUp($scope.userDto, function(userDto){
    		$scope.user = userDto;
             $location.path('/')
         });
     }

}]);

