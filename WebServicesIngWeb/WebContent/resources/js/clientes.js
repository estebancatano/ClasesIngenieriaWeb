var app = angular.module('clientes',[]);
var servicioLista = 'http://localhost:8080/WebServicesIngWeb/rest/Cliente';

app.controller('listaClientes',function($scope, Clientes){
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
});

app.service('Clientes',function($http){
	this.listaClientes = function(){
		return $http({
			method: 'GET',
			url: servicioLista
		});
	};
});
