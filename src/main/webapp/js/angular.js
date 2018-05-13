var app = angular.module('app', []);

app.controller('postEmployeeController', function($scope, $http, $location) {
	$scope.submitForm = function(){
		var url = $location.absUrl() + "api/employee";
		
		var config = {
                headers : {
                    'Content-Type': 'application/json;charset=utf-8;'
                }
        }
		
		var data = {
            firstName: $scope.firstname,
            lastName: $scope.lastname,
            personalNumber: $scope.personalNumber,
            employeeType: $scope.employeeType
        };
		
		
		$http.post(url, data, config).then(function (response) {
			$scope.postResultMessage = "Sucessful!";
		}, function (response) {
			$scope.postResultMessage = "Fail!";
		});
		
		$scope.firstname = "";
		$scope.lastname = "";
		$scope.personalNumber="";
		$scope.employeeType = "";
	}
});

app.controller('getallemployeeController', function($scope, $http, $location) {
	
	$scope.showAllEmployees = true;

	$scope.getAllEmployees = function() {
		var url = $location.absUrl() + "api/employee";

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {


				$scope.allemployees = response.data;
				$scope.showAllEmployees = true;



		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});

app.controller('employeesCtrl', function($scope, $http) {
    $http.get("api/employee").then(function (response) {
        $scope.myData = response.data.records;
    });
});

app.controller('getcustomerController', function($scope, $http, $location) {
	
	$scope.showCustomer = false;
	
	$scope.getCustomer = function() {
		var url = $location.absUrl() + "customer/" + $scope.customerId;

		var config = {
			headers : {
				'Content-Type' : 'application/json;charset=utf-8;'
			}
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.customer = response.data;
				$scope.showCustomer = true;

			} else {
				$scope.getResultMessage = "Customer Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});

app.controller('getcustomersbylastnameController', function($scope, $http, $location) {
	
	$scope.showCustomersByLastName = false;
	
	$scope.getCustomersByLastName = function() {
		var url = $location.absUrl() + "findbylastname";

		var config = {
			headers : {	'Content-Type' : 'application/json;charset=utf-8;' },
		
			params: { 'lastName' : $scope.customerLastName }
		}

		$http.get(url, config).then(function(response) {

			if (response.data.status == "Done") {
				$scope.allcustomersbylastname = response.data;
				$scope.showCustomersByLastName = true;

			} else {
				$scope.getResultMessage = "Customer Data Error!";
			}

		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});
