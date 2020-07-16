package progetto_twitter.Springbootapp.util;

import progetto_twitter.Springbootapp.exceptions.WrongDateFormatException;
/**
 * 
 *  @author Lorenzo Sopranzetti, Giovanni Recchi, Francesco Pigliapoco 
 *  Classe che gestisce le principali operazioni che vengono fatte sulle date
 *
 */
public class ModifyDate {
	/**
	 * Metodo che converte i mesi da stringhe a numeri
	 * @param date
	 * @return la data nel formato giusto
	 */
	public static String Date(String date) {
		String[] app = date.split(" ");
		String giorno = app[2];
		String anno = app[5];
		String mese = new String();
		switch (app[1]) {
		case "Jan":
			mese = "01";
			break;
		case "Feb":
			mese = "02";
			break;
		case "Mar":
			mese = "03";
			break;
		case "Apr":
			mese = "04";
			break;
		case "May":
			mese = "05";
			break;
		case "Jun":
			mese = "06";
			break;
		case "Jul":
			mese = "07";
			break;
		case "Aug":
			mese = "08";
			break;
		case "Sept":
			mese = "09";
			break;
		case "Oct":
			mese = "10";
			break;
		case "Nov":
			mese = "11";
			break;
		case "Dec":
			mese = "12";
			break;
		}
		return giorno + "/" + mese + "/" + anno;
	}
/**
 * Metodo che controlla se il formato della data sia corretto
 * @param Date
 * @throws WrongDateFormatException
 */
	public static void DateVerify(String Date) throws WrongDateFormatException {
		String[] DateParsed = Date.split("/");
		if (DateParsed.length < 3)
			throw new WrongDateFormatException(
					"Error : wrong date format. Date format is expected to be like: (\" 01/01/2020 \") ");
		DateVerify2(DateParsed[0], DateParsed[1], DateParsed[2]);

	} 
	/**
	 * Metodo che controllo che il formato della data sia corretto
	 * @param Day
	 * @param Month
	 * @param Year
	 * @throws WrongDateFormatException
	 */

	public static void DateVerify2(String Day, String Month, String Year) throws WrongDateFormatException {

		int DayInt;
		int MonthInt;
		int YearInt;
		try {
			DayInt = Integer.parseInt(Day);
			MonthInt = Integer.parseInt(Month);
			YearInt = Integer.parseInt(Year);
		} catch (NumberFormatException e) {
			throw new WrongDateFormatException(
					"Error : day, month, year must be numeric String such has: ( \"01/01/2020\" )");
		}
		if (DayInt < 0 || DayInt > 31)
			throw new WrongDateFormatException("Error : day's value must be between 0 and 31");
		if (YearInt < 2000 || YearInt > 2020)
			throw new WrongDateFormatException("Error : year's value must be between 2000 and 2020");
		if (MonthInt > 12 || MonthInt < 1)
			throw new WrongDateFormatException("Error : month's value must be between 01 and 12");
		else {
			if ((Month.equals("01") || Month.equals("03") || Month.equals("05") || Month.equals("07")
					|| Month.equals("08") || Month.equals("10") || Month.equals("12")) && DayInt > 31) {
				throw new WrongDateFormatException("Error : day's value exceeds this month's day count ");
			} else if ((Month.equals("04") || Month.equals("06") || Month.equals("09") || Month.equals("11"))
					&& DayInt > 30)
				throw new WrongDateFormatException("Error : day's value exceeds this month's day count ");
			else if (Month.equals("02") && DayInt > 29)
				throw new WrongDateFormatException("Error : day's value exceeds this month's day count ");
		}

	}
}
