var coffeApp = angular.module('coffeApp', ['ngResource','ui.bootstrap']);

coffeApp.controller('OrderController', function ($scope, $resource) {
    $scope.types = [
        {
            name: 'Americano', family: 'Coffe'
        },
        {
            name: 'Latte', family: 'Coffe'
        },
        {
            name: 'Green Tea', family: 'Tea'
        },
        {
            name: 'Capuccino', family: 'Coffe'
        }
    ];

    $scope.messages = [];
    $scope.sizes = ['Small','Medium','Large'];

    $scope.availableOptions = [];

    var ExtrasResource = $resource('api/extras');
    ExtrasResource.query('', function(extras) {
        $scope.availableOptions = extras;
    });

    $scope.orderCoffee = function() {
        $scope.drink.coffeeShopId = 1;
        var CoffeeOrder = $resource('api/coffeeshop/order/');
        CoffeeOrder.save($scope.drink, function(order) {
            $scope.messages.push({type: 'success', msg: 'Order sent!'});
        });
    };

    $scope.closeAlert = function (index) {
        $scope.messages.splice(index,1);
    }
    
    $scope.addOption = function () {
        if ($scope.drink.selectedOptions === undefined) {
            $scope.drink.selectedOptions = [];
        }
        $scope.drink.selectedOptions.push($scope.newOption);
    }
})
