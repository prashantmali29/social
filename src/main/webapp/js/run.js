/*//run at startup to check user is logged in or not
wordchiselApp.run(['$rootScope', '$location', 'dataStorageService', 'messageService', '$state', '$timeout', function ($rootScope, $location, dataStorageService, messageService, $state, $timeout) {

    $rootScope.user = {};

    if (typeof(Storage) !== "undefined") {
        // keep user logged in after page refresh hence copy the data from session
        $rootScope.user = dataStorageService.getUser();
    }

    $rootScope.$on('$locationChangeStart', function (event, next, current) {
        //On each location change this check is required - check if user is authorized to access the requested page.
        //var restrictedPage = $.inArray($location.path(), ['/', '/error']) === -1; // all pages are restricted except login, error etc.
        //var publicPages = ['', '/', '/error','/home','userNotAuthorized']; // These pages do not need login
        var restrictedPagesForLoggedInUser = ['/bookshelf','/logout']
        var isThisPageRestrictedForLoggedInUser = restrictedPagesForLoggedInUser.indexOf($location.path()) != -1;

        var isUserLoggedIn = dataStorageService.getUser() != null;

        if (isThisPageRestrictedForLoggedInUser && !isUserLoggedIn) {
            $location.path('/userNotAuthorized'); //send user to User Not Authorized page
            messageService.error("Sorry, the page you are trying to access is restricted only for Logged in Users. Log in to continue to wordchisel.");
        }
    });

    // wait for loading the data
    $rootScope.layout = {};
    $rootScope.layout.loading = false;

    $rootScope.$on('$stateChangeStart', function () {
        //show loading gif
        $rootScope.layout.loading = true;
    });

    $rootScope.$on('$stateChangeSuccess', function () {
        //hide loading gif
        $rootScope.layout.loading = false;
    });

    $rootScope.$on('$stateChangeError', function () {
        //hide loading gif
        $rootScope.layout.loading = false;
    });

}]);*/