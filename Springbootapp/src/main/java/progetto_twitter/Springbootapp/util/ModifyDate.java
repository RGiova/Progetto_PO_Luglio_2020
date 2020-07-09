package progetto_twitter.Springbootapp.util;

public class ModifyDate {
public static String Date(String date) {
	String [] app = date.split(" ");
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
	return giorno+"/"+mese+"/"+anno;
	
	
}
}
