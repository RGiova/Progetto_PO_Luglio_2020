package progetto_twitter.Springbootapp.controller;

import org.json.simple.JSONObject;
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



/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco
 * Controllore del progetto: usato per gestire tutti le roots dell'applicazione
 *
 */



@RestController
public class Springbootcontroller {
	/**
	 * Creazione di un oggetto delle classe ServiceImpl che gestisce le roots
	 */
	
	private ServiceImpl Service = new ServiceImpl();
	/**
	 * Root che gestisce i metadati
	 * @return la classe che restituisce i metadata
	 */

	@GetMapping("/metadata")
	public ResponseEntity<Object> GETMetaData() {
		return new ResponseEntity<Object>(Service.GETMetaData(), HttpStatus.OK);
	}
	/**
	 * Root che gestisce i dati
	 * @return La classe che restituisce i dati
	 */

	@GetMapping("/data")
	public ResponseEntity<Object> GETData() {
		return new ResponseEntity<Object>(Service.GETData(), HttpStatus.OK);
	}
	/**
	 * Root che gestisce il filtraggio dei dati
	 * @param body
	 * @return La classe che restituisce i dati filtrati
	 * @throws WrongOperatorException
	 * @throws WrongFormatExceptions
	 * @throws WrongFieldException
	 * @throws WrongValueException
	 * @throws WrongDateFormatException
	 */

	@PostMapping("/filter")
	public ResponseEntity<Object> GETFilter(@RequestBody JSONObject body) throws WrongOperatorException,
			WrongFormatExceptions, WrongFieldException, WrongValueException, WrongDateFormatException {
		ListsCreate.Lists.getToPushList().clear();
		ListsCreate.Lists.ListCopy(ListsCreate.Lists.getMList(), ListsCreate.Lists.getToPushList());
		Service.GETFilter(body);
		return new ResponseEntity<Object>(Service.GETDataFiltered(), HttpStatus.OK);
	}
	/**
	 * Root che gestisce le statistiche
	 * @param Stat
	 * @return La classe che restituisce le statistiche
	 * @throws WrongStatisticException
	 */

	@GetMapping("/statistics")
	public ResponseEntity<Object> GETStatistics(@RequestParam String Stat) throws WrongStatisticException {
		return new ResponseEntity<Object>(Service.GETStatistics(Stat, ListsCreate.Lists.getMList()), HttpStatus.OK);
	}
	/**
	 * Root che gestisce la lista delle parole e ne fa la TOP N se richiesto
	 * @param N
	 * @return La classe restituisce la classifica delle parole 
	 */

	@GetMapping("/wordlist")
	public ResponseEntity<Object> GETWordlist(@RequestParam(defaultValue = "0") String N) {
		return new ResponseEntity<Object>(Service.GETWordList(N), HttpStatus.OK);
	}
	/**
	 * Root che gestisce la lista degli hashtags utilizzati
	 * @return La classe che restituisce la lista degli hastags
	 */

	@GetMapping("/hashlist")
	public ResponseEntity<Object> GETHashlist() {
		return new ResponseEntity<Object>(Service.GETHashList(), HttpStatus.OK);
	}
	/**
	 * Root che gestisce le statistiche su un isieme di dati filtrati
	 * @param Stat
	 * @param body
	 * @return La classe che restituisce le statistiche su un insieme di dati filtrati
	 * @throws WrongOperatorException
	 * @throws WrongFormatExceptions
	 * @throws WrongFieldException
	 * @throws WrongValueException
	 * @throws WrongDateFormatException
	 * @throws WrongStatisticException
	 */

	@PostMapping("/filteredstats")
	public ResponseEntity<Object> GETStatsFiltered(@RequestParam String Stat, @RequestBody JSONObject body)
			throws WrongOperatorException, WrongFormatExceptions, WrongFieldException, WrongValueException,
			WrongDateFormatException, WrongStatisticException {
		ListsCreate.Lists.getToPushList().clear();
		ListsCreate.Lists.ListCopy(ListsCreate.Lists.getMList(), ListsCreate.Lists.getToPushList());
		return new ResponseEntity<Object>(Service.GETStatsFiltered(Stat, body), HttpStatus.OK);
	}

}