package progetto_twitter.Springbootapp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import progetto_twitter.Springbootapp.GETJson.GETJson;
import progetto_twitter.Springbootapp.GETJson.JSONParse;
import progetto_twitter.Springbootapp.model.*;
import progetto_twitter.Springbootapp.util.Metadata;
@RestController
public class Springbootcontroller {

@GetMapping("/Entities")
	public ResponseEntity<Object> GETData() {
  return new ResponseEntity<Object>(GETJson.GETData(),HttpStatus.OK);
  }
@GetMapping("/metadata")
public ResponseEntity<Object> MetaData(){
	return new ResponseEntity<Object>(Metadata.MetaData(),HttpStatus.OK);
}
}