'use strict';

/**
 * ApplicationController
 * @constructor
 */
var ApplicationController = function($scope, $http) {
	var actionUrl = 'appController/indexdata.htm';
	$scope.load = function(){
		alert(1);
	};
    $scope.datagrid = function() {
    	var defaults = {};
    	defaults.url = actionUrl;
    	$.codingol.datagrid(defaults);
    };

    $scope.addNewCar = function(newCar) {
        $http.post('cars/addCar/' + newCar).success(function() {
            $scope.fetchCarsList();
        });
        $scope.carName = '';
    };

    $scope.removeCar = function(car) {
        $http.delete('cars/removeCar/' + car).success(function() {
            $scope.fetchCarsList();
        });
    };

    $scope.removeAllCars = function() {
        $http.delete('cars/removeAllCars').success(function() {
            $scope.fetchCarsList();
        });

    };

    $scope.load();
};
 