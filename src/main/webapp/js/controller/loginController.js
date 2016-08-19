// controller used for login page
App.controller("loginController", ['$scope', '$location', 'loginService', function ($scope, $location, loginService) {

    $scope.login = function () {
       loginService.performLogin($scope.username, $scope.password, function(){
            $location.path('/')
        });
    }
    
    $scope.signUp = function () {
        loginService.performSignUp($scope.userDto, function(){
             $location.path('/')
         });
     }

}]);

