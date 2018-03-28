package inc.troll.mnemeprocess.rest.networks.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import inc.troll.mnemeprocess.rest.networks.dto.NetworkDto;

@RestController
@RequestMapping("/network")
public class NetworkController {

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void add(@RequestBody List<NetworkDto> networks) {
		for(NetworkDto network : networks) {
			System.out.println(network.getMacAddress() + " - " + network.getSsid());
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void update(@RequestBody List<NetworkDto> networks) {
		for(NetworkDto network : networks) {
			System.out.println(network.getMacAddress() + " - " + network.getSsid());
		}
	}
}
