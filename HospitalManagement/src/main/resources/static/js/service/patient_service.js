'use strict';
 
angular.module('onlineexam').factory('PatientService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = '/patient';
 
    var factory = {
        fetchAllUsers: fetchAllUsers,
        createUser: createUser,
        updateUser:updateUser,
        deleteUser:deleteUser
    };
 
    return factory;
 
    function fetchAllUsers() {
        var deferred = $q.defer();
        $http.get("/patient/getPatientAll")
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Users');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createUser(user) {alert("createuser22");
        var deferred = $q.defer();
        
        $http.post("/patient/patientRegistration", user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateUser(user, id) {
        var REST_SERVICE_URI = '/patient/updatePatient/'+id;
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI, user)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while updating User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteUser(id) {alert("removepatient22");
    	//$http.delete(REST_SERVICE_URI+id)
    	var REST_SERVICE_URI = '/patient/removePatient/'+id;
        var deferred = $q.defer();
        alert("removePatient");
        $http.delete(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting User');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);