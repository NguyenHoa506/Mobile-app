<?php
	if (!empty($_POST['lat']) && !empty($_POST['long'])) {
		$url = 'http://maps.googleapis.com/maps/api/geocode/json?latlng='.trim($_POST['lat']).','.trim($_POST['long']).'&sensor=false';
		$json = @file_get_contents($url);
		$data = json_decode($json);
		$status = $data->status;
		if ($status=="OK") {
			$location = $data->results[0]->formatted_address;
		}
		else {
			$location = '';
		}
		document.getElementById("output").innerHTLM = $location;
	}
?>