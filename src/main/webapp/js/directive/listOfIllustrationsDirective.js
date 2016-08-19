/**
 * author : Prashant Mali
 */

// Directive to display illustrations
App.directive('listOfIllustrations', function () {

    return {
        // restrict : 'AE',
        templateUrl: "directive/listOfIllustrations.html",
        replace: true,

        scope: {
            illustrations: '='

        }
    };

});


