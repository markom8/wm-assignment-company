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
	}
});

app.controller('postTeamController', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "api/team";

        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            teamName: $scope.teamName,
            developerPersonalNumber: $scope.developerPersonalNumber,
            teamLeadPersonalNumber: $scope.teamLeadPersonalNumber
        };


        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });
    }
});

app.controller('postProjectController', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "api/project";

        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            projectName: $scope.projectName,
            clientName: $scope.clientName,
            teamName: $scope.teamName,
            projectManagerPersonalNumber: $scope.projectManagerPersonalNumber
        };


        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });
    }
});

app.controller('postTaskController', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "api/task";

        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            taskName: $scope.taskName,
            taskDescription: $scope.taskDescription
        };


        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });
    }
});

app.controller('postTimeSheetController', function($scope, $http, $location) {
    $scope.submitForm = function(){
        var url = $location.absUrl() + "api/timesheet";

        var config = {
            headers : {
                'Content-Type': 'application/json;charset=utf-8;'
            }
        }

        var data = {
            projectName: $scope.projectName,
            employeePersonalNumber: $scope.employeePersonalNumber,
            date: $scope.date,
            workedHours: $scope.workedHours,
            team: $scope.team,
            taskName: $scope.taskName
        };


        $http.post(url, data, config).then(function (response) {
            $scope.postResultMessage = "Sucessful!";
        }, function (response) {
            $scope.postResultMessage = "Fail!";
        });
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

app.controller('getallteamController', function($scope, $http, $location) {

    $scope.showAllTeams = true;

    $scope.getAllTeams = function() {
        var url = $location.absUrl() + "api/team";

        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }

        $http.get(url, config).then(function(response) {


            $scope.allteams = response.data;
            $scope.showAllTeams = true;



        }, function(response) {
            $scope.getResultMessage = "Fail!";
        });

    }
});

app.controller('getallprojectController', function($scope, $http, $location) {

    $scope.showAllProjects = true;

    $scope.getAllProjects = function() {
        var url = $location.absUrl() + "api/project";

        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }

        $http.get(url, config).then(function(response) {


            $scope.allprojects = response.data;
            $scope.showAllProjects = true;



        }, function(response) {
            $scope.getResultMessage = "Fail!";
        });

    }
});

app.controller('getalltaskController', function($scope, $http, $location) {

    $scope.showAllTasks = true;

    $scope.getAllTasks = function() {
        var url = $location.absUrl() + "api/task";

        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }

        $http.get(url, config).then(function(response) {


            $scope.alltasks = response.data;
            $scope.showAllTasks = true;



        }, function(response) {
            $scope.getResultMessage = "Fail!";
        });

    }
});

app.controller('getalltimeSheetsController', function($scope, $http, $location) {

    $scope.showAllTimeSheets = true;

    $scope.getAllTimeSheets = function() {
        var url = $location.absUrl() + "api/timesheet";

        var config = {
            headers : {
                'Content-Type' : 'application/json;charset=utf-8;'
            }
        }

        $http.get(url, config).then(function(response) {


            $scope.alltimeSheets = response.data;
            $scope.showAllTimeSheets = true;

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

app.controller('gettimesheetsbyprsonalnumberandprojectnameController', function($scope, $http, $location) {
	
	$scope.showTimeSheetsByPresonalNumberAndProject = false;
	
	$scope.getTimeSheetsByPresonalNumberAndProject = function() {
		var url = $location.absUrl() + "api/timesheet/employee/" + $scope.personalNumber + "/project/" + $scope.projectName;

		var config = {
			headers : {	'Content-Type' : 'application/json;charset=utf-8;' }//,
		
			//params: { 'lastName' : $scope.customerLastName }
		}

		$http.get(url, config).then(function(response) {


				$scope.workLog = response.data;
				$scope.showTimeSheetsByPresonalNumberAndProject = true;



		}, function(response) {
			$scope.getResultMessage = "Fail!";
		});

	}
});
