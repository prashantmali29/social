googleMapModule.controller("googleMapController", [
		'$scope',
		'$rootScope',
		function($scope, $rootScope) {
			var cities = [
			              {
			                  city : 'Kothrud',
			                  desc : 'This is the best city in the world!',
			                  lat : 18.5087,
			                  long : 73.8125
			              },
			              {
			                  city : 'Sangli',
			                  desc : 'This city is aiiiiite!',
			                  lat : 16.8524,
			                  long : 74.5815
			              },
			              {
			                  city : 'Mumbai',
			                  desc : 'This is the second best city in the world!',
			                  lat : 19.0760,
			                  long : 72.8777
			              },
			              {
			                  city : 'Chennai',
			                  desc : 'This city is live!',
			                  lat : 13.0827,
			                  long : 80.2707
			              },
			              {
			                  city : 'Delhi',
			                  desc : 'Sin City...\'nuff said!',
			                  lat : 28.7041,
			                  long : 77.1025
			              }
			          ];
			
			
			
			
			
			var mapOptions = {
				zoom : 6,
				center : new google.maps.LatLng(16.8524, 74.5815),
				mapTypeId : google.maps.MapTypeId.hybrid
			}

			$scope.map = new google.maps.Map(document.getElementById('map'),
					mapOptions);

			$scope.markers = [];

			var infoWindow = new google.maps.InfoWindow();

			var createMarker = function(info) {

				var marker = new google.maps.Marker({
					map : $scope.map,
					position : new google.maps.LatLng(info.lat, info.long),
					title : info.city
				});
				marker.content = '<div class="infoWindowContent">' + info.desc
						+ '</div>';

				google.maps.event.addListener(marker, 'click', function() {
					infoWindow.setContent('<h2>' + marker.title + '</h2>'
							+ marker.content);
					infoWindow.open($scope.map, marker);
				});

				$scope.markers.push(marker);

			}

			for (i = 0; i < cities.length; i++) {
				createMarker(cities[i]);
			}

			$scope.openInfoWindow = function(e, selectedMarker) {
				e.preventDefault();
				google.maps.event.trigger(selectedMarker, 'click');
			}

		} ])