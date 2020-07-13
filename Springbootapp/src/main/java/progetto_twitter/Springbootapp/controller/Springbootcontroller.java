package progetto_twitter.Springbootapp.controller;

import java.util.Collections;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import progetto_twitter.Springbootapp.GETJson.GETJson;
import progetto_twitter.Springbootapp.GETJson.JSONParse;
import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongFieldException;
import progetto_twitter.Springbootapp.exceptions.WrongFormatExceptions;
import progetto_twitter.Springbootapp.exceptions.WrongOperatorException;
import progetto_twitter.Springbootapp.exceptions.WrongStatisticException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.filter.ReadFilter;
import progetto_twitter.Springbootapp.model.*;
import progetto_twitter.Springbootapp.service.ServiceImpl;
import progetto_twitter.Springbootapp.util.ListsCreate;
import progetto_twitter.Springbootapp.util.Metadata;

@RestController
public class Springbootcontroller {
	@GetMapping("/metadata")
	public ResponseEntity<Object> GETMetaData() {
		return new ResponseEntity<Object>(ServiceImpl.GETMetaData(), HttpStatus.OK);
	}

	@GetMapping("/data")
	public ResponseEntity<Object> GETData() {
		return new ResponseEntity<Object>(ServiceImpl.GETData(), HttpStatus.OK);
	}

	@PostMapping("/filter")
	public ResponseEntity<Object> GETFilter(@RequestBody JSONObject body) throws WrongOperatorException,
			WrongFormatExceptions, WrongFieldException, WrongValueException, WrongDateFormatException {
		ListsCreate.Lists.getToPushList().clear();
		ListsCreate.Lists.ListCopy(ListsCreate.Lists.getMList(), ListsCreate.Lists.getToPushList());
		ServiceImpl.GETFilter(body);
		return new ResponseEntity<Object>(ServiceImpl.GETDataFiltered(), HttpStatus.OK);
	}
	public ResponseEntity<Object> GETStatistics(@RequestParam String Stat, @RequestParam(defaultValue = "0") String N ) throws WrongStatisticException{
		ServiceImpl.GETStatistics(Stat,N);
		return null;
		
	}

}