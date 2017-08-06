var coffeApp = angular.module('coffeApp', ['ngResource']);

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

    $scope.sizes = ['Small','Medium','Large'];

    $scope.orderCoffee = function() {
        $scope.drink.coffeeShopId = 1;
        var CoffeeOrder = $resource('api/coffeeshop/order/');
        CoffeeOrder.save($scope.drink);
    };
})
