app.controller("authority-ctrl", function ($scope, $http, $location) {
    $scope.roles = [];
    $scope.admins = [];
    $scope.authorities = [];

    $scope.initialize = function () {
        //Load all roles
        $http.get('/rest/roles').then(resp => {
            $scope.roles = resp.data;
        });

        //load staffs and directors
        $http.get('/rest/accounts?admin=true').then(resp => {
            $scope.admins = resp.data;
        });

        //load authorities of staffs and directors
        $http.get('/rest/authorities?admin=true').then(resp => {
            $scope.authorities = resp.data;
        }).catch(error => {
            $location.path('/unauthorized');
        });
    }

    $scope.initialize();

    $scope.authority_of = function (acc, role) {
        // Tìm quyền của người dùng trong mảng authorities
        return $scope.authorities.find(function (auth) {
            return auth.account.username === acc.username && auth.role.id === role.id;
        });

    };

    $scope.authority_change = function (acc, role) {
        var authority = $scope.authority_of(acc, role);
        if (authority) { //đã cấp quyền => thu hồi quyền
            $scope.revoke_authority(authority);
        } else {// chưa đc cấp quyền => cấp quyền
            authority = {account: acc, role: role};
            $scope.grant_authority(authority);
        }
    }

    //Thêm mới authority
    $scope.grant_authority = function (authority) {
        $http.post('/rest/authorities', authority).then(resp => {
            $scope.authorities.push(resp.data);
            console.log(resp.data);
            console.log(authority);
            alert("Cấp quyền sử dụng thành công");
        }).catch(error => {
            alert("Cấp quyền sử dụng thất bại");
            console.log("Error", error);
        })
    }

    //Xóa authority
    $scope.revoke_authority = function (authority) {
        $http.delete(`/rest/authorities/${authority.id}`).then(resp => {
            var index = $scope.authorities.findIndex(a => a.id == authority.id);
            $scope.authorities.splice(index, 1);
            alert("Thu hồi quyền sử dụng thành công");
        }).catch(error => {
            alert("Thu hồi quyền sử dụng thất bại");
            console.log("Error", error);
        })
    }

});