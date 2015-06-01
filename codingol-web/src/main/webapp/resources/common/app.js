'use strict';

var codingolApp = {};

var App = angular.module('codingolApp', ['ngRoute']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/admin/application', {
        templateUrl: 'templates/admin/application/index.jsp',
        controller: ApplicationController
    });
    $routeProvider.when('/admin/application/edit', {
        templateUrl: 'templates/admin/application/edit.jsp',
        controller: ApplicationController
    });

   // $routeProvider.otherwise({redirectTo: '/cars'});
}]);
