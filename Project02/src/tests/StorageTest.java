/**
 *
 * Project 02: Group 1
 * ilya, elias, nicholas, hyelin
 */
package tests;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Weather.Storage;

/**
 * @author Elias Salmo
 *
 */
class StorageTest {
	
	Scanner scanner;
	int total = 0;
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
	int max;
	int min;
	int avg;
	Storage storage;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		storage = new Storage();
		storage.addTemp(300);
		storage.addHum(68);
		storage.addPres(30299);
		storage.addWindSpeed(49);
		storage.addRain(55);
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
	}

	@Test
	void getTempMax() throws FileNotFoundException {
		scanner = new Scanner(new File("tempFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			tempList.add(temp);
			total += temp;
		}
		max = Collections.max(tempList);
		assertEquals("Testing the maximum temperature", Storage.tempMax, max);
	}
	
	@Test
	void getTempMin() throws FileNotFoundException {
		scanner = new Scanner(new File("tempFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			tempList.add(temp);
			total += temp;
		}
		min = Collections.min(tempList);
		assertEquals("Testing the minimum temperature", Storage.tempMin, min);
	}
	
	@Test
	void getTempAvg() throws FileNotFoundException {
		scanner = new Scanner(new File("tempFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			tempList.add(temp);
			total += temp;
		}
		avg = total / tempList.size();;
		assertEquals("Testing the average temperature", Storage.tempAvg, avg);
	}
	
	@Test
	void getHumMax() throws FileNotFoundException {
		scanner = new Scanner(new File("humFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			humList.add(temp);
			total += temp;
		}
		max = Collections.max(humList);
		assertEquals("Testing the maximum humidity", Storage.humMax, max);
	}
	
	@Test
	void getHumMin() throws FileNotFoundException {
		scanner = new Scanner(new File("humFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			humList.add(temp);
			total += temp;
		}
		min = Collections.min(humList);
		assertEquals("Testing the minimum humidity", Storage.humMin, min);
	}
	
	@Test
	void getHumAvg() throws FileNotFoundException {
		scanner = new Scanner(new File("humFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			humList.add(temp);
			total += temp;
		}
		avg = total / humList.size();;
		assertEquals("Testing the average humidity", Storage.humAvg, avg);
	}
	
	@Test
	void getPresMax() throws FileNotFoundException {
		scanner = new Scanner(new File("presFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			presList.add(temp);
			total += temp;
		}
		max = Collections.max(presList);
		assertEquals("Testing the maximum pressure", Storage.presMax, max);
	}
	
	@Test
	void getPresMin() throws FileNotFoundException {
		scanner = new Scanner(new File("presFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			presList.add(temp);
			total += temp;
		}
		min = Collections.min(presList);
		assertEquals("Testing the minimum pressure", Storage.presMin, min);
	}
	
	@Test
	void getPresAvg() throws FileNotFoundException {
		scanner = new Scanner(new File("presFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			presList.add(temp);
			total += temp;
		}
		avg = total / presList.size();;
		assertEquals("Testing the average pressure", Storage.presAvg, avg);
	}
	
	@Test
	void getRainMax() throws FileNotFoundException {
		scanner = new Scanner(new File("rainFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			rainList.add(temp);
			total += temp;
		}
		max = Collections.max(rainList);
		assertEquals("Testing the maximum Rain", Storage.rainMax, max);
	}
	
	@Test
	void getRainMin() throws FileNotFoundException {
		scanner = new Scanner(new File("rainFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			rainList.add(temp);
			total += temp;
		}
		min = Collections.min(rainList);
		assertEquals("Testing the minimum rain", Storage.rainMin, min);
	}
	
	@Test
	void getRainAvg() throws FileNotFoundException {
		scanner = new Scanner(new File("rainFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			rainList.add(temp);
			total += temp;
		}
		avg = total / rainList.size();;
		assertEquals("Testing the Average rain", Storage.rainAvg, avg);
	}
	
	@Test
	void getSpeedMax() throws FileNotFoundException {
		scanner = new Scanner(new File("speedFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			speedList.add(temp);
			total += temp;
		}
		max = Collections.max(speedList);
		assertEquals("Testing the maximum Wind speed", Storage.speedMax, max);
	}
	
	@Test
	void getSpeedMin() throws FileNotFoundException {
		scanner = new Scanner(new File("speedFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			speedList.add(temp);
			total += temp;
		}
		min = Collections.min(speedList);
		assertEquals("Testing the Minimum wind speed", Storage.speedMin, min);
	}
	
	@Test
	void getSpeedAvg() throws FileNotFoundException {
		scanner = new Scanner(new File("speedFile.txt"));
		total = 0;
		while(scanner.hasNextInt()) {
			int temp = scanner.nextInt();
			speedList.add(temp);
			total += temp;
		}
		avg = total / speedList.size();;
		assertEquals("Testing the average wind speed", Storage.speedAvg, avg);
	}
}
