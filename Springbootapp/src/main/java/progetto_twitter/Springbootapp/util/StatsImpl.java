package progetto_twitter.Springbootapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import progetto_twitter.Springbootapp.model.StandardDeviation;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.ImageModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.WordModel;

public class StatsImpl implements Stats {

	@Override
	public ArrayList<HashModel> HashStats(ArrayList<JSONModel> objp) {
		Iterator<?> t = objp.iterator();
		ArrayList<HashModel> HashList = new ArrayList<HashModel>(objp.size());
		while (t.hasNext()) {
			JSONModel p1 = new JSONModel();
			p1 = (JSONModel) t.next();
			ArrayList<String> hash = p1.getHashtags();
			boolean found = false;
			int index = 0;

			/* Scorro HashList per constatare se l'hashtag è già stata utilizzata o meno */

			for (int j = 0; j < hash.size(); j++) {
				for (int i = 0; i < HashList.size(); i++) {
					if (HashList.get(i).getText().equals(hash.get(j))) {
						index = i;
						found = true;
						break;
					}
				}
			}

			/*
			 * Incremento Occorrenze dell'Hashtag se questa è già in lista, altrimenti la
			 * inserisco
			 */

			if (found) {
				HashList.get(index).setOccorrenze(HashList.get(index).getOccorrenze() + 1);
			} else {
				HashModel NewHash = new HashModel(hash.get(index));
				HashList.add(NewHash);
			}
		}
		return HashList;

	}

	@Override
	public ArrayList<WordModel> WordStats(ArrayList<JSONModel> objp) {

		Iterator<?> t = objp.iterator();
		ArrayList<WordModel> WordList = new ArrayList<WordModel>(objp.size());
		while (t.hasNext()) {
			JSONModel p1 = new JSONModel();
			p1 = (JSONModel) t.next();

			/*
			 * Elimino tutti i caratteri speciali (tranne gli spazi) e divido la stringa
			 * nelle singole parole che la compongono
			 */

			String Phrase = p1.getText().replaceAll("[^\\p{L}\\p{Z}]", "");
			ArrayList<String> Words = (ArrayList<String>) Arrays.asList(Phrase.split("\s"));
			boolean found = false;
			int index = 0;
			for (int j = 0; j < Words.size(); j++) {
				String Word = Words.get(j).toLowerCase();

				/* Controllo la parola per ignorare Tag, Hashtag e URL */

				if (Word.charAt(0) == '#' || Word.charAt(0) == '@')
					break;
				if (Word.substring(0, 4).equals("http"))
					break;

				/* Scorro WordList per constatare se la parola è già stata utilizzata o meno */

				for (int i = 0; i < WordList.size(); i++) {
					if (WordList.get(i).getText().equals(Word)) {
						index = i;
						found = true;
						break;
					}

					/*
					 * Incremento Occorrenze della parola se questa è già in lista, altrimenti la
					 * inserisco
					 */

					if (found) {
						WordList.get(index).setOccorrenze(WordList.get(index).getOccorrenze() + 1);
					} else {
						Integer length = Words.get(j).length();
						WordModel NewWord = new WordModel(Words.get(index), length);
						WordList.add(NewWord);
					}

				}

			}

		}

		Collections.sort(WordList);

		return WordList;
	}

	@Override
	public ArrayList<WordModel> getTopN(ArrayList<WordModel> WordList, int N) {
		int index = 0;
		Iterator<?> t = WordList.iterator();
		ArrayList<WordModel> WordListN = new ArrayList<WordModel>(N - 1);
		while (t.hasNext() && index < N) {
			WordListN.get(index).setText(WordList.get(index).getText());
			WordListN.get(index).setLength(WordList.get(index).getLength());
			WordListN.get(index).setOccorrenze(WordList.get(index).getOccorrenze());
			index++;
		}
		return WordListN;

	}

	@Override
	public String IMGminAvgMAX(ArrayList<JSONModel> objp) {
		long minW = 10000;
		long MAXW = 0;
		long AvgW = 0;
		StandardDeviation sd1 = new StandardDeviation();
		double SDW = 0;
		long minH = 10000;
		long MAXH = 0;
		long AvgH = 0;
		StandardDeviation sd2 = new StandardDeviation();
		double SDH = 0;
		long minD = 10000;
		long MAXD = 0;
		long AvgD = 0;
		StandardDeviation sd3 = new StandardDeviation();
		double SDD = 0;
		int index = 0;
		int pics = 0;
		Iterator<?> t = objp.iterator();
		while (t.hasNext()) {
			JSONModel ImgObj = (JSONModel) t.next();
			Iterator<?> i = ImgObj.getImg().iterator();
			while (i.hasNext()) {
				ImageModel Img = (ImageModel) i.next();
				if (Img.getW() > MAXW)
					MAXW = Img.getW();
				if (Img.getW() < minW)
					minW = Img.getW();
				AvgW += Img.getW();
				SDW = sd1.SD(Img.getW());
				if (Img.getH() > MAXH)
					MAXH = Img.getH();
				if (Img.getH() < minH)
					minH = Img.getH();
				AvgH += Img.getH();
				SDH = sd2.SD(Img.getH());
				if (Img.getDimension() > MAXD)
					MAXD = Img.getDimension();
				if (Img.getDimension() < minD)
					minD = Img.getDimension();
				AvgD += Img.getDimension();
				SDD = sd3.SD(Img.getDimension());
				pics++;
			}
			index += pics;
		}
		return "minW =" + minW + " MAXW = " + MAXW + " AvgW = " + AvgW + " SDW = " + SDW + ";\nminH = " + minH
				+ " MAXH = " + MAXH + " AvgH = " + (AvgH / index) + " SDH = " + SDH + ";\nminD = " + minD + " MAXD = "
				+ MAXD + " AvgD = " + AvgD + " SDD = " + SDD + ";";
	}

	@Override
	public String URLminAvgMAX(ArrayList<JSONModel> objp) {
		int min = 10000;
		int MAX = 0;
		int Avg = 0;
		StandardDeviation sd = new StandardDeviation();
		double SD = 0;
		int index = 0;
		int urls = 0;
		Iterator<?> t = objp.iterator();
		while (t.hasNext()) {
			JSONModel URLObj = (JSONModel) t.next();
			urls = URLObj.getURL().size();
			SD = sd.SD(urls);
			index += urls;
		}
		return "minURLS =" + min + " MAXURLS = " + MAX + " AvgURLS = " + Avg/index + " SDURLS = " + SD + ";";
	}

	@SuppressWarnings("deprecation")
	@Override
	public String DateminAvgMAX(ArrayList<JSONModel> objp) {
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		int minDay = 10000;
		int MAXDay = 0;
		int AvgDay = 0;
		StandardDeviation sd1 = new StandardDeviation();
		double SDDay = 0;
		int minMon = 10000;
		int MAXMon = 0;
		int AvgMon = 0;
		StandardDeviation sd2 = new StandardDeviation();
		double SDMon = 0;
		int minYr = 10000;
		int MAXYr = 0;
		int AvgYr = 0;
		StandardDeviation sd3 = new StandardDeviation();
		double SDYr = 0;
		int DayTotal = 0;
		int MonTotal = 0;
		int YrTotal = 0;
		int DayTweetCount = 0;
		int MonTweetCount = 0;
		int YrTweetCount = 0;
		Iterator<?> t = objp.iterator();
		while (t.hasNext()) {
			JSONModel DateObj = (JSONModel) t.next();
			String[] SplitDate = DateObj.getDate().split("/");
			Date thisDate = null;
			Date lastDate = null;
			try {
				thisDate = sdformat.parse(SplitDate[2] + "-" + SplitDate[1] + "-" + SplitDate[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (DayTotal==0) lastDate = thisDate;
			if (thisDate.getYear() == lastDate.getYear()) {
				if (thisDate.getMonth() == lastDate.getMonth()) {
					if (thisDate.getDate() == lastDate.getDate())
						DayTweetCount++;
					else {
						 if(DayTweetCount < minDay) minDay = DayTweetCount;
						 if(DayTweetCount > MAXDay) MAXDay = DayTweetCount;
						 AvgDay += DayTweetCount;
						 SDDay = sd1.SD(DayTweetCount);
						DayTotal += thisDate.getDate() - lastDate.getDate();
						lastDate = thisDate;
						MonTweetCount += DayTweetCount;
						DayTweetCount = 1;
						
					}

				} else {
					 if(MonTweetCount < minMon) minMon = MonTweetCount;
					 if(MonTweetCount > MAXMon) MAXMon = MonTweetCount;
					 AvgMon += MonTweetCount;
					 SDMon = sd2.SD(MonTweetCount);
					YrTweetCount += MonTweetCount;
					MonTweetCount = 1;
					DayTotal += thisDate.getDay() + MissingDays(lastDate.getMonth(),lastDate.getDate());
					MonTotal ++;
				}

			} else {
				 if(YrTweetCount < minYr) minDay = YrTweetCount;
				 if(YrTweetCount > MAXYr) MAXDay = YrTweetCount;
				 AvgYr += YrTweetCount;
				SDYr = sd3.SD(YrTweetCount);
				YrTweetCount = 1;
				DayTotal += thisDate.getDay() + MissingDays(lastDate.getMonth(),lastDate.getDate());
				YrTotal++;

			}

		}
		return "minDay =" + minDay + " MAXDay = " + MAXDay + " AvgDay = " + AvgDay / DayTotal + " SDDay = " + SDDay
				+ ";\nminMon = " + minMon + " MAXMon = " + MAXMon + " AvgMon = " + AvgMon/MonTotal + " SDMon = " + SDMon
				+ ";\nminYr = " + minYr + " MAXYr = " + MAXYr + " AvgYr = " + AvgYr/YrTotal + " SDD = " + SDYr + ";";
	}

	@Override
	public String HminAvgMAX(ArrayList<HashModel> HashList) {
		int min = HashList.get(0).getOccorrenze();
		int MAX = HashList.get(0).getOccorrenze();
		int Avg = 0;
		int index = 0;
		Iterator<?> t = HashList.iterator();
		while (t.hasNext()) {
			if (HashList.get(index).getOccorrenze() > MAX)
				MAX = HashList.get(index).getOccorrenze();
			if (HashList.get(index).getOccorrenze() < min)
				min = HashList.get(index).getOccorrenze();
			Avg += HashList.get(index).getOccorrenze();
		}
		return "minH =" + min + " MAXH = " + MAX + " AvgH = " + Avg + ";";

	}

	@Override
	public String WminAvgMAX(ArrayList<WordModel> WordList) {
		int min = WordList.get(WordList.size() - 1).getOccorrenze();
		int MAX = WordList.get(0).getOccorrenze();
		int Avg = 0;
		int index = 0;
		Iterator<?> t = WordList.iterator();
		while (t.hasNext()) {
			if (WordList.get(index).getOccorrenze() > MAX)
				MAX = WordList.get(index).getOccorrenze();
			if (WordList.get(index).getOccorrenze() < min)
				min = WordList.get(index).getOccorrenze();
			Avg += WordList.get(index).getOccorrenze();
		}
		return "minWords =" + min + " MAXWords = " + MAX + " AvgWords = " + Avg + ";";
	}

	public int MissingDays(int Month, int Day) {

		if ((Month==0 || Month==2 || Month==4|| Month==6 || Month==7
				|| Month==9 || Month==11)) {
			return 31 - Day;
		} else if ((Month==3 || Month==5 || Month==8 || Month==10))
			return 30 - Day;
		else
			return 29 - Day;
	}
}