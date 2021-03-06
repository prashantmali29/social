App.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/');

	$stateProvider.state('/', {
		url : '/',
		templateUrl : 'home.html',

	})

	$stateProvider.state('login', {
		url : '/login',
		templateUrl : 'Public/login/login.html',
		controller : 'loginController'
	})

	$stateProvider.state('signUp', {
		url : '/signUp',
		templateUrl : 'Public/signup/signup.html',
		controller : 'signupController'
	})

	$stateProvider.state('userManagement', {
		url : '/userManagement',
		templateUrl : 'Public/userManagement/userManagement.html',
		controller : 'userManagementController'
	})
	
	$stateProvider.state('chart', {
		url : '/chart',
		templateUrl : 'Public/chart/chart.html',
		controller : 'chartController'
	})
	
	$stateProvider.state('googleMap', {
		url : '/googleMap',
		templateUrl : 'Public/googleMap/googleMap.html',
		controller : 'googleMapController'
	})

	
	
	$stateProvider.state('home', {
		url : '/home',
		templateUrl : 'home.html',
		controller : 'loginController'
	})

});