package progetto_twitter.Springbootapp.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongFieldException;
import progetto_twitter.Springbootapp.exceptions.WrongFormatExceptions;
import progetto_twitter.Springbootapp.exceptions.WrongOperatorException;
import progetto_twitter.Springbootapp.exceptions.WrongStatisticException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.service.ServiceImpl;
import progetto_twitter.Springbootapp.util.ListsCreate;
import progetto_twitter.Springbootapp.util.StatsImpl;

@RestController
public class Springbootcontroller {
	private ServiceImpl Service = new ServiceImpl();

	@GetMapping("/metadata")
	public ResponseEntity<Object> GETMetaData() {
		return new ResponseEntity<Object>(Service.GETMetaData(), HttpStatus.OK);
	}

	@GetMapping("/data")
	public ResponseEntity<Object> GETData() {
		return new ResponseEntity<Object>(Service.GETData(), HttpStatus.OK);
	}

	@PostMapping("/filter")
	public ResponseEntity<Object> GETFilter(@RequestBody JSONObject body) throws WrongOperatorException,
			WrongFormatExceptions, WrongFieldException, WrongValueException, WrongDateFormatException {
		ListsCreate.Lists.getToPushList().clear();
		ListsCreate.Lists.ListCopy(ListsCreate.Lists.getMList(), ListsCreate.Lists.getToPushList());
		Service.GETFilter(body);
		return new ResponseEntity<Object>(Service.GETDataFiltered(), HttpStatus.OK);
	}

	@GetMapping("/statistics")
	public ResponseEntity<Object> GETStatistics(@RequestParam String Stat) throws WrongStatisticException {
		return new ResponseEntity<Object>(Service.GETStatistics(Stat, ListsCreate.Lists.getMList()), HttpStatus.OK);
	}

	@GetMapping("/wordlist")
	public ResponseEntity<Object> GETWordlist(@RequestParam(defaultValue = "0") String N) {
		return new ResponseEntity<Object>(Service.GETWordList(N), HttpStatus.OK);
	}

	@GetMapping("/hashlist")
	public ResponseEntity<Object> GETHashlist() {
		return new ResponseEntity<Object>(Service.GETHashList(), HttpStatus.OK);
	}

	@PostMapping("/filteredstats")
	public ResponseEntity<Object> GETStatsFiltered(@RequestParam String Stat, @RequestBody JSONObject body)
			throws WrongOperatorException, WrongFormatExceptions, WrongFieldException, WrongValueException,
			WrongDateFormatException, WrongStatisticException {
		ListsCreate.Lists.getToPushList().clear();
		ListsCreate.Lists.ListCopy(ListsCreate.Lists.getMList(), ListsCreate.Lists.getToPushList());
		return new ResponseEntity<Object>(Service.GETStatsFiltered(Stat, body), HttpStatus.OK);
	}

}