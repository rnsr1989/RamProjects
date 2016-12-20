'use strict';

angular.module('onlineexam').controller('UserController', ['$scope', 'UserService', function($scope, UserService) {
    var self = this;
    self.user={firstName:'',lastName:'',username:'',gender:'',mobileNo:'',password:''};
    self.users=[];

    self.submit = submit;
    self.login = login;
       /* function fetchAllUsers(){
        UserService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }*/

    function createUser(user){
        UserService.createUser(user)
            .then(
            		 console.log('Saving New User saved successfully', self.user),
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }

    
    function loginUser(user){
        UserService.login(user)
            .then(
            		 console.log('Saving New User saved successfully', self.user),
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
    function submit() {
     
            console.log('Saving New User', self.user);
            createUser(self.user);
       
    }
    function login() {
    	
        console.log('Saving New User', self.user);
        loginUser(self.user);
   
}
    
    
   

}]);
