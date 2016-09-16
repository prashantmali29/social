// controller used for login page
loginModule.controller("loginController", ['$scope','$rootScope' ,'$location', 'loginService', function ($scope,$rootScope, $location, loginService) {

    $scope.login = function () {
       loginService.performLogin($scope.userName, $scope.password, function(loginDetails){
    	   console.log(" in login controller" +loginDetails.userName);
    	   $scope.login = loginDetails;
            $location.path('/')
        });
    }

}]);

