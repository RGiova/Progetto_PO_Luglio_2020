package progetto_twitter.Springbootapp.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import progetto_twitter.Springbootapp.exceptions.EmptyArgumentsException;
import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
import progetto_twitter.Springbootapp.exceptions.WrongFieldException;
import progetto_twitter.Springbootapp.exceptions.WrongFormatExceptions;
import progetto_twitter.Springbootapp.exceptions.WrongOperatorException;
import progetto_twitter.Springbootapp.exceptions.WrongStatisticException;
import progetto_twitter.Springbootapp.exceptions.WrongValueException;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.MetaDataModel;
import progetto_twitter.Springbootapp.model.StatsModel;
import progetto_twitter.Springbootapp.model.WordModel;
/**
 * Interfaccia
 * @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 *
 */
public interface Service {
	/**
	 * Metodo che gestisce la richiesta di filtraggio dei dati
	 */
	void GETFilter(JSONObject obj) throws WrongOperatorException, WrongFormatExceptions, WrongFieldException,
			WrongValueException, WrongDateFormatException;
	/**
	 * Metodo che restituisce i dati
	 */
	ArrayList<JSONModel> GETData();
	/**
	 * Metodo che restituisce i dati filtrati
	 */
	ArrayList<JSONModel> GETDataFiltered();
	/**
	 * Metodo che restituisce i metadati
	 * 
	 */
	ArrayList<MetaDataModel> GETMetaData();
	/**
	 * Metodo che gestisce la richiesta delle statistiche 
	 * @throws EmptyArgumentsException 
	 */
	ArrayList<StatsModel> GETStatistics(String stat, ArrayList<JSONModel> List) throws WrongStatisticException, EmptyArgumentsException;
	/**
	 * Metodo che gestisce la richiesta della classifica di parole più utilizzate
	 * @throws EmptyArgumentsException 
	 */
	ArrayList<WordModel> GETWordList(String N) throws NumberFormatException, EmptyArgumentsException;
    /**
     * Metodo che gestisce la richiesta della lista di hashtags
     * @throws EmptyArgumentsException 
     */
	ArrayList<HashModel> GETHashList() throws EmptyArgumentsException;
    /**
     * Metodo che gestisce la richiesta di statistiche su un insieme di dati filtrati
     * @throws EmptyArgumentsException 
     */
	ArrayList<StatsModel> GETStatsFiltered(String stat, JSONObject obj)
			throws WrongOperatorException, WrongFormatExceptions, WrongFieldException, WrongValueException,
			WrongDateFormatException, WrongStatisticException, EmptyArgumentsException;

}
