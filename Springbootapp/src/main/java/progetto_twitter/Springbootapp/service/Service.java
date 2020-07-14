package progetto_twitter.Springbootapp.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;

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

public interface Service {

	void GETFilter(JSONObject obj) throws WrongOperatorException, WrongFormatExceptions, WrongFieldException,
			WrongValueException, WrongDateFormatException;

	ArrayList<JSONModel> GETData();

	ArrayList<JSONModel> GETDataFiltered();

	ArrayList<MetaDataModel> GETMetaData();

	ArrayList<StatsModel> GETStatistics(String stat, ArrayList<JSONModel> List) throws WrongStatisticException;

	ArrayList<WordModel> GETWordList(String N) throws NumberFormatException;

	ArrayList<HashModel> GETHashList();

	ArrayList<StatsModel> GETStatsFiltered(String stat, JSONObject obj)
			throws WrongOperatorException, WrongFormatExceptions, WrongFieldException, WrongValueException,
			WrongDateFormatException, WrongStatisticException;

}
