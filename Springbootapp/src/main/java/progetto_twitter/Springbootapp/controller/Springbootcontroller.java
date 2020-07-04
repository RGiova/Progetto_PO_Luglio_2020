package progetto_twitter.Springbootapp.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import progetto_twitter.Springbootapp.GETJson.GETJson;
import progetto_twitter.Springbootapp.GETJson.JSONParse;

@RestController
public class Springbootcontroller {
   
@GetMapping("/Entities")
	public ResponseEntity<Object> prova() {
  return new ResponseEntity<Object>(GETJson.GETData(),HttpStatus.OK);
  }
@PostMapping("/pippo")
public ResponseEntity<Object> prova1( @RequestBody String pippo){
	return null;
}
}