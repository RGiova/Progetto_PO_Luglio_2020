package progetto_twitter.Springbootapp.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongFieldException;
import progetto_twitter.Springbootapp.exceptions.WrongFormatExceptions;
import progetto_twitter.Springbootapp.exceptions.WrongOperatorException;
import progetto_twitter.Springbootapp.exceptions.WrongStatisticException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.filter.ReadFilter;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.MetaDataModel;
import progetto_twitter.Springbootapp.model.StatsModel;
import progetto_twitter.Springbootapp.model.WordModel;
import progetto_twitter.Springbootapp.util.*;
/**
 * 
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 * Classe che gestisce le funzioni del programma
 */
public class ServiceImpl implements Service {
	/**
	 * Oggetto che contiene al suo interno i metodi per le statistiche
	 */
	private StatsImpl StatObj = new StatsImpl();
/**
 * Metodo che restituisce i metadati
 * 
 */
	@Override
	public ArrayList<MetaDataModel> GETMetaData() {
		Metadata.CMetaData();
		return Metadata.getMDArray();
	}
/**
 * Metodo che restituisce i dati
 */
	@Override
	public ArrayList<JSONModel> GETData() {
		return ListsCreate.Lists.getMList();
	}
/**
 * Metodo che gestisce la richiesta di filtraggio dei dati
 */
	@Override
	public void GETFilter(JSONObject obj) throws WrongOperatorException, WrongFormatExceptions, WrongFieldException,
			WrongValueException, WrongDateFormatException {
		ReadFilter Prova = new ReadFilter();
		try {
			Prova.FirstFilter(obj);
		} catch (WrongOperatorException | WrongFormatExceptions | WrongFieldException | WrongValueException
				| WrongDateFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}
	/**
	 * Metodo che restituisce i dati filtrati
	 */

	@Override
	public ArrayList<JSONModel> GETDataFiltered() {
		if (ListsCreate.Lists.getToFilterList() != null)
			ListsCreate.Lists.getToFilterList().clear();
		if (ListsCreate.Lists.getToFilterList2() != null)
			ListsCreate.Lists.getToFilterList2().clear();
		return ListsCreate.Lists.getToPushList();
	}
/**
 * Metodo che gestisce la richiesta delle statistiche 
 */
	@Override
	public ArrayList<StatsModel> GETStatistics(String stat, ArrayList<JSONModel> List) throws WrongStatisticException {
		if (stat.equals("date") || stat.equals("url") || stat.equals("hashtags") || stat.equals("text")
				|| stat.equals("image")) {
				return Choice.Stats(stat, StatObj, List,
						StatObj.HashStats(List),
						StatObj.WordStats(List));
			} else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unrecognized param");

	}
	/**
	 * Metodo che gestisce la richiesta della classifica di parole più utilizzate
	 */
    @Override
	public ArrayList<WordModel> GETWordList(String N) throws NumberFormatException {
		int n;
		try {
			n = Integer.parseInt(N);
		} catch (NumberFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error : number of words must be a number");
		}
		if (n != 0)
			return StatObj.getTopN(StatObj.WordStats(ListsCreate.Lists.getMList()), n);
		else
			return StatObj.WordStats(ListsCreate.Lists.getMList());
	}
    /**
     * Metodo che gestisce la richiesta della lista di hashtags
     */
    @Override
	public ArrayList<HashModel> GETHashList() {
		return StatObj.HashStats(ListsCreate.Lists.getMList());
	}
    @Override
    /**
     * Metodo che gestisce la richiesta di statistiche su un insieme di dati filtrati
     */
	public ArrayList<StatsModel> GETStatsFiltered(String stat, JSONObject obj) throws WrongOperatorException, WrongFormatExceptions, WrongFieldException, WrongValueException, WrongDateFormatException, WrongStatisticException{
		GETFilter(obj);
		return GETStatistics(stat, GETDataFiltered());
	}
}
