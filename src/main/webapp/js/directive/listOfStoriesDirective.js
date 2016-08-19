/**
 * author : raj botre
 */

// Directive to display stories
App.directive('listOfStories', function () {

    return {
        // restrict : 'AE',
        templateUrl: "directive/listOfStories.html",
        replace: true,
        controller: ['$scope', '$rootScope', '$state', 'storyRatingService', function ($scope, $rootScope, $state, storyRatingService) {
            init();

            function init() {
                $scope.user = $rootScope.user;
                $scope.state = $state;
            }
        }],
        scope: {
            stories: '=',
            genreName: '@',
            genreLabel: '@'
        }
    };

});

