
App.config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider
        .state('/', {
            url: '/',
            templateUrl: 'home.html',
            controller: 'loginController'
        })
        
         $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'login.html',
            controller: 'loginController'
        })
        
        $stateProvider
        .state('signUp', {
            url: '/signUp',
            templateUrl: 'signup.html',
            controller: 'loginController'
        })
        
         $stateProvider
        .state('home', {
            url: '/home',
            templateUrl: 'home.html',
            controller: 'loginController'
        })
        
});