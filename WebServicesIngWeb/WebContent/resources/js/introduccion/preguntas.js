/**
 * 
 */
var appPreguntas = angular.module('appPreguntas', []);
appPreguntas.controller('ControllerPreguntas',['$scope', function($scope) {
	$scope respuestasValidas = 0;
	$scope.preguntas=[
	  {
		  id: 1,
       	  texto: 'Pregunta 1',
       	  respuestaValida: 1,
       	  respuesta: null,
       	  estado: '',
       	  respuestas: [
            {id:1,
             texto:'Opcion 1'},
            {id:2,
        	 texto:'Opcion 2'},
            {id:3,
         	 texto:'Opcion 3'},
            {id:4,
         	 texto:'Opcion 4'}]
      },
      {
		  id: 2,
       	  texto: 'Pregunta 2',
       	  respuestaValida: 1,
       	  respuesta: null,
       	  estado: '',
       	  respuestas: [
            {id:1,
             texto:'Opcion 1'},
            {id:2,
        	 texto:'Opcion 2'},
            {id:3,
         	 texto:'Opcion 3'},
            {id:4,
         	 texto:'Opcion 4'}]
      },
      {
		  id: 3,
       	  texto: 'Pregunta 3',
       	  respuestaValida: 1,
       	  respuesta: null,
       	  estado: '',
       	  respuestas: [
            {id:1,
             texto:'Opcion 1'},
            {id:2,
        	 texto:'Opcion 2'},
            {id:3,
         	 texto:'Opcion 3'},
            {id:4,
         	 texto:'Opcion 4'}]
      }
	];
	$scope.validar = function(pregunta){
		if(pregunta.respuesta == pregunta.respuestaValida){
			$scope.respuestasValidas++;
			pregunta.estado = 'OK';
		}else{
			if(pregunta.estado == 'OK' && $scope.respuestasValidas > 0){
				$scope.respuestasValidas--;
			}
			pregunta.estado = 'ERROR';
		}
	};
}]);