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
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.MetaDataModel;
import progetto_twitter.Springbootapp.util.*;

public class ServiceImpl {

	public static ArrayList<MetaDataModel> GETMetaData() {
		Metadata.CMetaData();
		return Metadata.getMDArray();
	}

	public static ArrayList<JSONModel> GETData() {
		return ListsCreate.Lists.getMList();
	}

	public static void GETFilter(JSONObject obj) throws WrongOperatorException, WrongFormatExceptions,
			WrongFieldException, WrongValueException, WrongDateFormatException {
		ReadFilter Prova = new ReadFilter();
		try {
			Prova.FirstFilter(obj);
		} catch (WrongOperatorException | WrongFormatExceptions | WrongFieldException | WrongValueException
				| WrongDateFormatException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
	}

	public static ArrayList<JSONModel> GETDataFiltered() {
		if (ListsCreate.Lists.getToFilterList() != null)
			ListsCreate.Lists.getToFilterList().clear();
		if (ListsCreate.Lists.getToFilterList2() != null)
			ListsCreate.Lists.getToFilterList2().clear();
		return ListsCreate.Lists.getToPushList();
	}

	public static void GETStatistics(String stat, String N) throws WrongStatisticException {
		if(stat.equals("day")||stat.equals("month")||stat.equals("year")||stat.equals("url")||stat.equals("hashtags")||stat.equals("text") || stat.equals("image")) {
			Choice.Stats(stat, N);
		}
		else
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unrecognized param");
		
	}
}
