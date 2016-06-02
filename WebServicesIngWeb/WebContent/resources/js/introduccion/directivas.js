/**
 * 
 */
var mod = angular.module('miAplicacion', []);
mod = directive('persona', function() {
	return {
		restrict: 'E',
		scope: {},
		replace: true,
		template: '<h1> {{nombre_completo}} </h1>',
		link: function(scope, elemento, atributos){
			scope.nombre_completo = atributos.nombre + ' ' + atributos.apellido;
			elemento.bind('click', function(){
				alert('Hola, soy ' + scope.nombre_completo);
			});
		}
	};
});