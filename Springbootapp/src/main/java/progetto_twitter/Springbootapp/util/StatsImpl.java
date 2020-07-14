package progetto_twitter.Springbootapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

import progetto_twitter.Springbootapp.model.StandardDeviation;
import progetto_twitter.Springbootapp.model.StatsModel;
import progetto_twitter.Springbootapp.exceptions.EmptyArgumentsException;
import progetto_twitter.Springbootapp.model.HashModel;
import progetto_twitter.Springbootapp.model.ImageModel;
import progetto_twitter.Springbootapp.model.JSONModel;
import progetto_twitter.Springbootapp.model.WordModel;

public class StatsImpl implements Stats {

	@Override
	public ArrayList<HashModel> HashStats(ArrayList<JSONModel> objp) throws EmptyArgumentsException {
		if(objp.size()==0) throw new EmptyArgumentsException();
		Iterator<?> t = objp.iterator();
		ArrayList<HashModel> HashList = new ArrayList<HashModel>();
		while (t.hasNext()) {
			JSONModel p1 = new JSONModel();
			p1 = (JSONModel) t.next();
			ArrayList<String> hash = p1.getHashtags();
			boolean found = false;
			int index = 0;

			/* Scorro HashList per constatare se l'hashtag è già stata utilizzata o meno */

			for (int j = 0; j < hash.size(); j++) {
				if (HashList.size() > 0) {
					for (int i = 0; i < HashList.size() && !found; i++) {
						if (HashList.get(i).getText().equals((hash.get(j)).toLowerCase())) {
							index = i;
							found = true;
						}
					}

					if (found) {
						HashList.get(index).setOccurrences(HashList.get(index).getOccurrences() + 1);
						found = false;
					} else {
						HashModel NewHash = new HashModel(hash.get(j).toLowerCase());
						HashList.add(NewHash);
					}
				} else {
					HashModel NewHash = new HashModel(hash.get(j).toLowerCase());
					HashList.add(NewHash);
				}
			}

		}

		return HashList;

	}

	@Override
	public ArrayList<WordModel> WordStats(ArrayList<JSONModel> objp) throws EmptyArgumentsException {
		if(objp.size()==0) throw new EmptyArgumentsException();
		Iterator<?> t = objp.iterator();
		ArrayList<WordModel> WordList = new ArrayList<WordModel>();
		boolean found = false;
		while (t.hasNext()) {
			JSONModel p1 = new JSONModel();
			p1 = (JSONModel) t.next();

			/*
			 * Elimino tutti i caratteri speciali (tranne gli spazi) e divido la stringa
			 * nelle singole parole che la compongono
			 */

			String[] Phrase = p1.getText().replaceAll("[^\\p{L}\\p{Z}]", "").split("\s");
			int index = 0;
			for (int j = 0; j < Phrase.length; j++) {
				String Word = Phrase[j].toLowerCase();

				/* Controllo la parola per ignorare URL e caratteri vuoti */

				if (!(Word.length() > 4 && Word.substring(0, 4).equals("http") || Word.length() == 0)) {
					/* Scorro WordList per constatare se la parola è già stata utilizzata o meno */
					if (WordList.size() > 0) {
						for (int i = 0; i < WordList.size() && !found; i++) {
							if (WordList.get(i).getText().equals(Word)) {
								index = i;
								found = true;
							}

							/*
							 * Incremento Occurrences della parola se questa è già in lista, altrimenti la
							 * inserisco
							 */
						}
						if (found) {
							WordList.get(index).setOccurrences(WordList.get(index).getOccurrences() + 1);
							found = false;
						} else {
							int length = Word.length();
							WordModel NewWord = new WordModel(Word, length);
							WordList.add(NewWord);
						}

					} else {
						int length = Word.length();
						WordModel NewWord = new WordModel(Word, length);
						WordList.add(NewWord);
					}

				}
			}

		}

		Collections.sort(WordList);

		return WordList;
	}

	@Override
	public ArrayList<WordModel> getTopN(ArrayList<WordModel> WordList, int N) throws EmptyArgumentsException {
		if(WordList.size()==0) throw new EmptyArgumentsException();
		int index = 0;
		Iterator<?> t = WordList.iterator();
		ArrayList<WordModel> WordListN = new ArrayList<WordModel>(N - 1);
		while (t.hasNext() && index < N) {
			WordListN.get(index).setText(WordList.get(index).getText());
			WordListN.get(index).setLength(WordList.get(index).getLength());
			WordListN.get(index).setOccurrences(WordList.get(index).getOccurrences());
			index++;
		}
		return WordListN;

	}

	@Override
	public ArrayList<StatsModel> IMGminAvgMAX(ArrayList<JSONModel> objp) throws EmptyArgumentsException {
		if(objp.size()==0) throw new EmptyArgumentsException();
		long minW = 10000;
		long MAXW = 0;
		double AvgW = 0;
		StandardDeviation sd1 = new StandardDeviation();
		double SDW = 0;
		long minH = 10000;
		long MAXH = 0;
		double AvgH = 0;
		StandardDeviation sd2 = new StandardDeviation();
		double SDH = 0;
		long minD = 10000;
		long MAXD = 0;
		double AvgD = 0;
		StandardDeviation sd3 = new StandardDeviation();
		double SDD = 0;
		double index = 0;
		double pics = 0;
		Iterator<?> t = objp.iterator();
		while (t.hasNext()) {
			JSONModel ImgObj = (JSONModel) t.next();
			if (ImgObj.getImg() != null) {
				Iterator<?> i = ImgObj.getImg().iterator();
				while (i.hasNext()) {
					ImageModel Img = (ImageModel) i.next();
					MAXW = Math.max(MAXW, Img.getW());
					minW = Math.min(minW, Img.getW());
					AvgW += Img.getW();
					SDW = sd1.SD(Img.getW());
					MAXH = Math.max(MAXH, Img.getH());
					minH = Math.min(minH, Img.getH());
					AvgH += Img.getH();
					SDH = sd2.SD(Img.getH());
					MAXD = Math.max(MAXD, Img.getDimension());
					minD = Math.min(minD, Img.getDimension());
					AvgD += Img.getDimension();
					SDD = sd3.SD(Img.getDimension());
					pics++;
				}
				index += pics;
				pics = 0;
			}
		}
		if (index==0) index++;
		ArrayList<StatsModel> IMGStats = new ArrayList<StatsModel>();
		StatsModel WStats = new StatsModel("Image Width", (int) minW, (int) MAXW, AvgW / index, SDW);
		StatsModel HStats = new StatsModel("Image Height", (int) minH, (int) MAXH, AvgH / index, SDH);
		StatsModel DStats = new StatsModel("Image Dimension", (int) minD, (int) MAXD, AvgD / index, SDD);
		IMGStats.add(WStats);
		IMGStats.add(HStats);
		IMGStats.add(DStats);
		return IMGStats;
	}

	@Override
	public ArrayList<StatsModel> URLminAvgMAX(ArrayList<JSONModel> objp) throws EmptyArgumentsException {
		if(objp.size()==0) throw new EmptyArgumentsException();
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
			MAX = Math.max(MAX, urls);
			min = Math.min(min, urls);
			Avg += urls;
			SD = sd.SD(urls);
			index += urls;
		}
		if (index==0) index++;
		ArrayList<StatsModel> URLS = new ArrayList<StatsModel>();
		StatsModel appoggio = new StatsModel("URLs per post", min, MAX, Avg / index, SD);
		URLS.add(appoggio);
		return URLS;
	}

	@Override
	public ArrayList<StatsModel> DateminAvgMAX(ArrayList<JSONModel> objp) throws EmptyArgumentsException {
		if(objp.size()==0) throw new EmptyArgumentsException();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		int minDay = 10000;
		int MAXDay = 0;
		StandardDeviation sd1 = new StandardDeviation();
		double SDDay = 0;
		int minMon = 10000;
		int MAXMon = 0;
		StandardDeviation sd2 = new StandardDeviation();
		double SDMon = 0;
		int minYr = 10000;
		int MAXYr = 0;
		StandardDeviation sd3 = new StandardDeviation();
		double SDYr = 0;
		double DayTotal = 0;
		double MonTotal = 0;
		double YrTotal = 0;
		double TotalTweets = 0;
		int DayTweetCount = 0;
		int MonTweetCount = 0;
		int YrTweetCount = 0;
		Date thisDate = null;
		Calendar thisCal = Calendar.getInstance();
		Calendar lastCal = Calendar.getInstance();
		Calendar firstCal = Calendar.getInstance();
		Calendar Cal = Calendar.getInstance();
		Iterator<?> t = objp.iterator();
		while (t.hasNext()) {
			JSONModel DateObj = (JSONModel) t.next();
			String[] SplitDate = DateObj.getDate().split("/");
			try {
				thisDate = sdformat.parse(SplitDate[2] + "-" + SplitDate[1] + "-" + SplitDate[0]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			thisCal.setTime(thisDate);
			if(!(Cal.getTime().equals(thisCal.getTime()))) {
			if (DayTweetCount == 0) {
				lastCal.setTime(thisDate);
				firstCal.setTime(thisDate);
				}
		
			if (thisCal.get(Calendar.YEAR) == lastCal.get(Calendar.YEAR)) {
				if (thisCal.get(Calendar.MONTH) == lastCal.get(Calendar.MONTH)) {
					if (thisCal.get(Calendar.DAY_OF_MONTH) == lastCal.get(Calendar.DAY_OF_MONTH)) {
						DayTweetCount++;
					} else {
						MAXDay = Math.max(MAXDay, DayTweetCount);
						minDay = Math.min(minDay, DayTweetCount);
						SDDay = sd1.SD(DayTweetCount);
						DayTotal += lastCal.get(Calendar.DAY_OF_YEAR) - thisCal.get(Calendar.DAY_OF_YEAR);
						lastCal.setTime(thisDate);
						MonTweetCount += DayTweetCount;
						TotalTweets += DayTweetCount;
						DayTweetCount = 1;

					}

				} else {
					MAXMon = Math.max(MAXMon, MonTweetCount);
					minMon = Math.min(minMon, MonTweetCount);
					SDMon = sd2.SD(MonTweetCount);
					YrTweetCount += MonTweetCount;
					MonTweetCount = 1;
					TotalTweets += MonTweetCount;
					DayTotal += lastCal.get(Calendar.DAY_OF_YEAR) - thisCal.get(Calendar.DAY_OF_YEAR);
					lastCal.setTime(thisDate);
					MonTotal++;
					Cal.setTime(firstCal.getTime());
				}

			} else {
				MAXYr = Math.max(MAXYr, YrTweetCount);
				minYr = Math.min(minYr, YrTweetCount);
				SDYr = sd3.SD(YrTweetCount);
				YrTweetCount = 1;
				TotalTweets += YrTweetCount;
				DayTotal += lastCal.get(Calendar.DAY_OF_YEAR) - thisCal.get(Calendar.DAY_OF_YEAR);
				lastCal.setTime(thisDate);
				YrTotal++;

			}
		} else break;
		}
		if (MonTotal == 0) {
			MonTotal = 1;
			MAXMon = MAXDay;
			minMon = minDay;
		}
		if (YrTotal == 0) {
			YrTotal = 1;
			MAXYr = MAXMon;
			minYr = minMon;
		}
		ArrayList<StatsModel> DateStats = new ArrayList<StatsModel>();
		StatsModel DayStats = new StatsModel("Tweets per Day", minDay, MAXDay, TotalTweets / DayTotal, SDDay);
		StatsModel MonStats = new StatsModel("Tweets per Month", minMon, MAXMon, TotalTweets / MonTotal, SDMon);
		StatsModel YrStats = new StatsModel("Tweets per Year", minYr, MAXYr, TotalTweets / YrTotal, SDYr);
		DateStats.add(DayStats);
		DateStats.add(MonStats);
		DateStats.add(YrStats);
		return DateStats;
	}

	@Override
	public ArrayList<StatsModel> HminAvgMAX(ArrayList<HashModel> HashList) throws EmptyArgumentsException {
		if(HashList.size()==0) throw new EmptyArgumentsException();
		int min = HashList.get(0).getOccurrences();
		int MAX = HashList.get(0).getOccurrences();
		double Avg = 0;
		StandardDeviation sd = new StandardDeviation();
		double SD = 0;
		double index = 0;
		Iterator<?> t = HashList.iterator();
		while (t.hasNext()) {
			HashModel Hashtag = (HashModel) t.next();
			MAX = Math.max(MAX, Hashtag.getOccurrences());
			min = Math.min(min, Hashtag.getOccurrences());
			Avg += Hashtag.getOccurrences();
			SD = sd.SD(Hashtag.getOccurrences());
			index++;
		}
		if (index==0) index++;
		ArrayList<StatsModel> HashS = new ArrayList<StatsModel>();
		StatsModel appoggio = new StatsModel("Hashtag Occurrences", min, MAX, Avg/index, SD);
		HashS.add(appoggio);
		return HashS;

	}

	@Override
	public ArrayList<StatsModel> WminAvgMAX(ArrayList<WordModel> WordList) throws EmptyArgumentsException {
		if(WordList.size()==0) throw new EmptyArgumentsException();
		int min = 0;
		int MAX = 0;
		double Avg = 0;
		StandardDeviation sd = new StandardDeviation();
		double SD = 0;
		double index = 0;
		Iterator<?> t = WordList.iterator();
		while (t.hasNext()) {
			WordModel Word = (WordModel) t.next();
			if (index==0) min = Word.getLength();
			MAX = Math.max(MAX, Word.getLength());
			min = Math.min(min, Word.getLength());
			Avg += Word.getLength();
			SD = sd.SD(Word.getLength());
			index++;
		}
		if (index==0) index++;
		ArrayList<StatsModel> WordS = new ArrayList<StatsModel>();
		StatsModel appoggio = new StatsModel("Word Length", min, MAX, Avg/index, SD);
		WordS.add(appoggio);
		return WordS;
	}
}