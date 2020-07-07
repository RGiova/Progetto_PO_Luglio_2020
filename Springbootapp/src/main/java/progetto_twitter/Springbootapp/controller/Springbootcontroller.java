package progetto_twitter.Springbootapp.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import progetto_twitter.Springbootapp.GETJson.GETJson;
import progetto_twitter.Springbootapp.GETJson.JSONParse;
import progetto_twitter.Springbootapp.filter.ReadFilter;
import progetto_twitter.Springbootapp.model.*;
import progetto_twitter.Springbootapp.service.ServiceImpl;
import progetto_twitter.Springbootapp.util.Metadata;

@RestController
public class Springbootcontroller {

	@GetMapping("/Entities")
	public ResponseEntity<Object> GETJ() {
		return new ResponseEntity<Object>(GETJson.GETJ(), HttpStatus.OK);
	}

	@GetMapping("/metadata")
	public ResponseEntity<Object> GETMetaData() {
		return new ResponseEntity<Object>(ServiceImpl.GETMetaData(), HttpStatus.OK);
	}

	@GetMapping("/data")
	public ResponseEntity<Object> GETData() {
		return new ResponseEntity<Object>(ServiceImpl.GETData(), HttpStatus.OK);
	}
	@PostMapping("/filter")
	public ResponseEntity<Object> GETFilter(@RequestBody JSONObject body){
		ServiceImpl.GETFilter(body);
		return null;

	}
	

}