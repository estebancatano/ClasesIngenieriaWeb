var app = angular.module('clientes',['ngRoute']);
var servicioLista = 'http://localhost:8080/WebServicesIngWeb/rest/Cliente';
var insertaCliente = 'http://localhost:8080/WebServicesIngWeb/rest/Cliente/nuevoCliente';

app.config(['$routeProvider', function($routeProvider){
	$routeProvider.when('/',{
		templateUrl: 'tablaClientes.html',
		controller: 'listaClientes'
	});
	$routeProvider.when('/Cliente',{
		templateUrl: 'cliente.html',
		controller: 'cliente'
	});
}]);

app.controller('cliente',function($scope, Clientes, $location){
	$scope.cliente = {
		cedula : '',
		nombres : '',
		apellidos: '',
		correo : ''
	};
	$scope.guardar = function(){
		console.log('Cliente insertar');
		console.log($scope.cliente);
		Clientes.clientes($scope.cliente).success(function(data){
			console.log("Inserté el cliente");
			$location.url('/');
		});
	};
});

app.controller('listaClientes',function($scope, Clientes, $location){
	Clientes.listaClientes().success(function(data){
		var lista = data.clienteDTOWS;
		var l = lista.length;
		console.log(lista);
		console.log(l);
		console.log(typeof(lista));
		if(lista.length > 1){
			$scope.clientes = lista;
		}else{
			var arr = [];
			arr.push(lista);
			console.log(arr);
			$scope.clientes = arr;
			//$scope.clientes = '[' + lista + ']';
		}
		
	});
	$scope.agregar = function(){
		$location.url('/Cliente');
	};
});

app.service('Clientes',function($http){
	this.listaClientes = function(){
		return $http({
			method: 'GET',
			url: servicioLista
		});
	};
	this.clientes = function(cliente){
		console.log(cliente);
		return $http({
			method: 'POST',
			url: insertaCliente,
			params: {
				cedula: cliente.cedula,
				nombres: cliente.nombres,
				apellidos: cliente.apellidos,
				correo: cliente.correo
			}
		});
	};
});
