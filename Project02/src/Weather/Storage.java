package Weather;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Elias Salmo
 *
 */
public class Storage {
	
	/**
	 * map that stores all of the data while the program is running
	 */
	Map<String, List<Integer>> infoMap;
	/**
	 * A list to store all of the temp data 
	 */
	List<Integer> tempList;
	/**
	 * A list to store all of the Humidity data 
	 */
	List<Integer> humList;
	/**
	 * A list to store all of the Pressure data 
	 */
	List<Integer> presList;
	/**
	 * A list to store all of the Wind Speed data 
	 */
	List<Integer> speedList;
	/**
	 * A list to store all of the Wind Dir data 
	 */
	List<Integer> dirList;
	/**
	 * A list to store all of the Phase data 
	 */
	List<Integer> phaseList;
	/**
	 * A list to store all of the Rain data 
	 */
	List<Integer> rainList;
	/**
	 * A list to store all of the Sun rise data 
	 */
	List<Integer> riseList;
	/**
	 * A list to store all of the Sun set data 
	 */
	List<Integer> setList;
	/**
	 * A list to store all of the Weather Icon data 
	 */
	List<Integer> wIconList;
	
	/**
	 * file to store temperature 
	 */
	File tempFile; 
	
	/**
	 * file to store humidity 
	 */
	File humFile; 
	
	/**
	 * file to store pressure 
	 */
	File presFile; 
	
	/**
	 * file to store wind speed 
	 */
	File speedFile; 
	
	/**
	 * file to store direction speed 
	 */
	File dirFile; 
	
	/**
	 * file to store moon phase 
	 */
	File phaseFile; 
	
	/**
	 * file to store rain 
	 */
	File rainFile; 
	
	/**
	 * file to store sun rise 
	 */
	File sunRiseFile; 
	
	/**
	 * file to store sun set 
	 */
	File sunSetFile; 
	
	/**
	 * file to store weather icon 
	 */
	File wIconFile; 
	
	/**
	 * File to write to temperature 
	 */
	static BufferedWriter tempWriter;
	
	/**
	 * File to write to humidity 
	 */
	static BufferedWriter humWriter;
	
	/**
	 * File to write to pressure 
	 */
	static BufferedWriter presWriter;
	
	/**
	 * File to write to wind speed 
	 */
	static BufferedWriter speedWriter;
	
	/**
	 * File to write to wind direction 
	 */
	static BufferedWriter dirWriter;
	
	/**
	 * File to write to moon phase 
	 */
	static BufferedWriter phaseWriter;
	
	/**
	 * File to write to rain 
	 */
	static BufferedWriter rainWriter;
	
	/**
	 * File to write to sun rise 
	 */
	static BufferedWriter sunRiseWriter;
	
	/**
	 * File to write to sun set 
	 */
	static BufferedWriter sunSetWriter;
	
	/**
	 * File to write to weather icon 
	 */
	static BufferedWriter wIconWriter;
	
	public static int tempMax;
	public static int tempAvg;
	public static int tempMin;
	
	public static int humMax;
	public static int humAvg;
	public static int humMin;
	
	public static int presMax;
	public static int presAvg;
	public static int presMin;
	
	public static int speedMax;
	public static int speedAvg;
	public static int speedMin;
	
	public static int dirMax;
	public static int dirAvg;
	public static int dirMin;
	
	public static int phaseMax;
	public static int phaseAvg;
	public static int phaseMin;
	
	public static int rainMax;
	public static int rainAvg;
	public static int rainMin;
	
	public static int riseMax;
	public static int riseAvg;
	public static int riseMin;
	
	public static int setMax;
	public static int setAvg;
	public static int setMin;
	
	public static int wIconMax;
	public static int wIconAvg;
	public static int wIconMin;
	
 	
	public Storage() {
		/**
		 * creates new files if they don't already exist
		 */
		try {
			tempFile = new File("tempFile.txt");
			tempFile.createNewFile();
			humFile = new File("humFile.txt");
			humFile.createNewFile();
			presFile = new File("presFile.txt");
			presFile.createNewFile();
			speedFile = new File("speedFile.txt");
			speedFile.createNewFile();
			dirFile = new File("dirFile.txt");
			dirFile.createNewFile();
			phaseFile = new File("phaseFile.txt");
			phaseFile.createNewFile();
			rainFile = new File("rainFile.txt");
			rainFile.createNewFile();
			sunRiseFile = new File("sunRiseFile.txt");
			sunRiseFile.createNewFile();
			sunSetFile = new File("sunSetFile.txt");
			sunSetFile.createNewFile();
			wIconFile = new File("wIconFile.txt");
			wIconFile.createNewFile();
		} catch (Exception e) { 
            System.err.println(e); 
        } 
		
		/**
		 * writes to a file output
		 */
		try {
		    tempWriter = new BufferedWriter(new FileWriter("tempFile.txt", true));
		    humWriter = new BufferedWriter(new FileWriter("humFile.txt", true));
		    presWriter = new BufferedWriter(new FileWriter("presFile.txt", true));
		    speedWriter = new BufferedWriter(new FileWriter("speedFile.txt", true));
		    dirWriter = new BufferedWriter(new FileWriter("dirFile.txt", true));
		    phaseWriter = new BufferedWriter(new FileWriter("phaseFile.txt", true));
		    rainWriter = new BufferedWriter(new FileWriter("rainFile.txt", true));
		    sunSetWriter = new BufferedWriter(new FileWriter("sunRiseFile.txt", true));
		    sunRiseWriter = new BufferedWriter(new FileWriter("sunSetFile.txt", true));
		    wIconWriter = new BufferedWriter(new FileWriter("wIconFile.txt", true));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * Initializes a Map
		 */
		infoMap = new HashMap<String, List<Integer>>();
		/**
		 * Initializes a the temp list
		 */
		tempList = new ArrayList<Integer>();
		/**
		 * Initializes a the Humidity list
		 */
		humList = new ArrayList<Integer>();
		/**
		 * Initializes a the Pressure list
		 */
		presList = new ArrayList<Integer>();
		/**
		 * Initializes a the Wind speed list
		 */
		speedList = new ArrayList<Integer>();
		/**
		 * Initializes a the wind dir list
		 */
		dirList = new ArrayList<Integer>();
		/**
		 * Initializes a the phase list
		 */
		phaseList = new ArrayList<Integer>();
		/**
		 * Initializes a the rain list
		 */
		rainList = new ArrayList<Integer>();
		/**
		 * Initializes a the sun rise list
		 */
		riseList = new ArrayList<Integer>();
		/**
		 * Initializes a the sun set list
		 */
		setList = new ArrayList<Integer>();
		/**
		 * Initializes a the weather Icon list
		 */
		wIconList = new ArrayList<Integer>();
		
		Scanner scanner;
		int total = 0;
		try {
			scanner = new Scanner(tempFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				tempList.add(temp);
				total += temp;
			}
			tempMax = Collections.max(tempList);
			tempMin = Collections.min(tempList);
			tempAvg = total / tempList.size();
			
			scanner = new Scanner(humFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				humList.add(temp);
				total += temp;
			}
			humMax = Collections.max(humList);
			humMin = Collections.min(humList);
			humAvg = total / humList.size();
			
			scanner = new Scanner(presFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				presList.add(temp);
				total += temp;
			}
			presMax = Collections.max(presList);
			presMin = Collections.min(presList);
			presAvg = total / presList.size();
			
			scanner = new Scanner(speedFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				speedList.add(temp);
				total += temp;
			}
			speedMax = Collections.max(speedList);
			speedMin = Collections.min(speedList);
			speedAvg = total / speedList.size();
			
			scanner = new Scanner(dirFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				dirList.add(temp);
				total += temp;
			}
			dirMax = Collections.max(dirList);
			dirMin = Collections.min(dirList);
			dirAvg = total / dirList.size();
			
			scanner = new Scanner(phaseFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				phaseList.add(temp);
				total += temp;
			}
			phaseMax = Collections.max(phaseList);
			phaseMin = Collections.min(phaseList);
			phaseAvg = total / phaseList.size();
			
			scanner = new Scanner(rainFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				rainList.add(temp);
				total += temp;
			}
			rainMax = Collections.max(rainList);
			rainMin = Collections.min(rainList);
			rainAvg = total / rainList.size();
			
			scanner = new Scanner(sunRiseFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				riseList.add(temp);
				total += temp;
			}
			riseMax = Collections.max(riseList);
			riseMin = Collections.min(riseList);
			riseAvg = total / riseList.size();
			
			scanner = new Scanner(sunSetFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				setList.add(temp);
				total += temp;
			}
			setMax = Collections.max(setList);
			setMin = Collections.min(setList);
			setAvg = total / setList.size();
			
			scanner = new Scanner(wIconFile);
			total = 0;
			while(scanner.hasNextInt()) {
				int temp = scanner.nextInt();
				wIconList.add(temp);
				total += temp;
			}
			wIconMax = Collections.max(wIconList);
			wIconMin = Collections.min(wIconList);
			wIconAvg = total / wIconList.size();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Method to add the temperature data and stores it into a map
	 * @param temp the temperature
	 */
	public void addTemp(int temp) {
		tempList.add(temp);
		
		try {    
			tempWriter.write("" + temp);
			tempWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("Temp", tempList);
	}
	
	/**
	 * Method to add the Humidity data and stores it into a map
	 * @param hum the humidity
	 */
	public void addHum(int hum) {
		humList.add(hum);
		try {    
			humWriter.write("" + hum);
			humWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("Humidity", humList);
	}
	
	/**
	 * Adds the pressure data and stores it into a map
	 * @param pressure
	 */
	public void addPres(int pressure) {
		presList.add(pressure);
		try {    
			presWriter.write("" + pressure);
			presWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("Pressure", presList);
	}
	
	/**
	 * Adds the wind speed data and stores into a map
	 * @param speed
	 */
	public void addWindSpeed(int speed) {
		speedList.add(speed);
		try {    
			speedWriter.write("" + speed);
			speedWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("WindSpeed", speedList);
	}
	
	/**
	 * Adds the wind direction data into a map
	 * @param dir
	 */
	public void addWindDir(int dir) {
		dirList.add(dir);
		try {    
			dirWriter.write("" + dir);
			dirWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("WindDir", dirList);
	}
	
	/**
	 * Adds the moon phase data into a map
	 * @param phase
	 */
	public void addMoonPhase(int phase) {
		phaseList.add(phase);
		try {    
			phaseWriter.write("" + phase);
			phaseWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("MoonPhase", phaseList);
	}
	
	/**
	 * Adds the rain data and stores it into a map
	 * @param rain
	 */
	public void addRain(int rain) {
		rainList.add(rain);
		try {    
			rainWriter.write("" + rain);
			rainWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("Rain", rainList);
	}
	
	/**
	 * Adds the sun rise data and stores into a map
	 * @param sunRise
	 */
	public void addSunRise(int sunRise) {
		riseList.add(sunRise);
		try {    
			sunRiseWriter.write("" + sunRise);
			sunRiseWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("SunRise", riseList);
	}
	
	/**
	 * Adds the sunset data and stores into a map
	 * @param sunSet
	 */
	public void addSunSet(int sunSet) {
		setList.add(sunSet);
		try {    
			sunSetWriter.write("" + sunSet);
			sunSetWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("SunSet", setList);
	}
	
	/**
	 * Adds the weather Icon data and stores it into a map
	 * @param WIcon
	 */
	public void addWIcon(int wIcon) {
		wIconList.add(wIcon);
		try {    
			wIconWriter.write("" + wIcon);
			wIconWriter.write("\n");
			    
		} catch (IOException e) {
			e.printStackTrace();
		}
		infoMap.put("WeatherIcon", wIconList);
	}
}
