package inc.troll.mnemeprocess.rest.coordinates.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import inc.troll.mnemeprocess.rest.coordinates.dto.CoordinatesDto;

@RestController
@RequestMapping("/coordinates")
public class CoordinatesController {

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody List<CoordinatesDto> coordinatesList) {
		for(CoordinatesDto coordinates : coordinatesList) {
			System.out.println(coordinates.getMacAddress() + " - " + coordinates.getLatitude() + " - " + coordinates.getLongitude());
		}
	}
}
