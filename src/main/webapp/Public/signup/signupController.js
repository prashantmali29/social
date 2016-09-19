// controller used for sign-up page
signupModule.controller("signupController", [
		'$scope',
		'$rootScope',
		'$location',
		'signupService',
		'userManagementService',
		function($scope, $rootScope, $location, signupService,
				userManagementService) {

			$scope.signUp = function() {
				console.log("in signup controller");
				signupService.performSignUp($scope.userDto, function(userDto) {
					$scope.user = userDto;
					$location.path('/')
				});
			}

			$scope.updateUser = function() {
				console.log("in update controller");
				userManagementService.updateUser($rootScope.userDto, function(
						response) {
					if (response) {
						$location.path('/userManagement')
						$rootScope.userDto = null;
					} else {
						$location.path('/')
					}

				});
			}

		} ]);
