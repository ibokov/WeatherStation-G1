package Weather;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;



// TEsting Hyelin

// Testing Ilya

// Testing Elias
/**
 * The main GUI for the weather console.
 * 
 * @author Group 1, Ilya Bokov, Elias Salmo, Nicholas Babcock
 * @version 13 February, 2020
 */
public class WeatherGUI extends JFrame {
    /**
     * The unique ID for the Serializable interface
     */
    private static final long serialVersionUID = 562997229458227901L;

    /**
     * The title for the application window.
     */
    private static final String TITLE = "Weather Station";

    /**
     * The number of moon phase images there are, will be used to create the
     * ImageIcon array.
     */
    private static final int NUM_MOON_IMAGES = 8;

    /**
     * The number of weather icons there will be. Will be used to create an
     * ImageIcon array for weather icons.
     */
    private static final int NUM_WEATHER_ICONS = 8;

    /**
     * Shows the temperature
     */
    private JLabel tempReadout;
    /**
     * Shows the humidity
     */
    private JLabel humidReadout;
    /**
     * Shows the pressure
     */
    private JLabel pressureReadout;
    /**
     * Shows the graph
     */
    private GraphPanel graphPanel;
    /**
     * Shows the wind data
     */
    private WindPanel windPanel;
    /**
     * Shows the moon phase
     */
    private JLabel moonReadout;
    /**
     * Shows the moon phase text
     */
    private JLabel moonLabel;
    /**
     * holds the images for each moon phase
     */
    private ImageIcon[] moonImages = new ImageIcon[NUM_MOON_IMAGES];

    private ImageIcon[] weatherIcon = new ImageIcon[NUM_WEATHER_ICONS];

    /**
     * Shows the rainfall
     */
    private JLabel rainReadout;
    /**
     * Shows the date
     */
    private JLabel dateReadout;
    /**
     * Shows the time
     */
    private JLabel timeReadout;
    /**
     * Shows the time of sunrise
     */
    private JLabel sunriseReadout;
    /**
     * Shows the time of sunset
     */
    private JLabel sunsetReadout;

    /**
     * Shows the weatherIcon.
     */
    private JLabel weatherLabel;

    /**
     * The about window that provides information about the Weather Vantage Vue.
     */
    private About AboutInfo;

    /**
     * Instantiates the alert window in the GUI.
     */
    private Alerts alertAlarm;

    /**
     * Constructor for weather gui.
     * @param theAlert
     */
    public WeatherGUI(Alerts theAlert) {
        alertAlarm = theAlert;
        start();
    }

    public WeatherGUI() {
		// TODO Auto-generated constructor stub
	}

	/**
     * The method that will initialize the GUI to its default starting state.
     */
    public void start() {

        this.setTitle(TITLE);
        // this.setLayout(new FlowLayout());
        this.setLayout(new BorderLayout());

        // Sets the initial size and position of the application window
        setSize(1100, 530);
        
        setLocationRelativeTo(null);

        JFrame frame = new JFrame();
        JPanel tempPanel = new JPanel();
        tempPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        tempReadout = new JLabel("Temp: -- �F");
        tempPanel.add(tempReadout);

        JPanel humidPanel = new JPanel();
        humidPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        humidReadout = new JLabel("Humid: -- %");
       
        humidPanel.add(humidReadout);

        JPanel pressurePanel = new JPanel();
        pressurePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        pressureReadout = new JLabel("Pressure: -- in");
        pressurePanel.add(pressureReadout);

        graphPanel = new GraphPanel(getWidth() / 2, getHeight() / 2);
        windPanel = new WindPanel(getHeight() / 9);
        windPanel.setPreferredSize(new Dimension(150, 150));

        JPanel moonPanel = new JPanel();
        moonReadout = new JLabel();
        moonReadout.setPreferredSize(new Dimension(110, 25));
        moonLabel = new JLabel();
        moonPanel.add(moonLabel);
        moonPanel.add(moonReadout);
        moonPanel.setPreferredSize(new Dimension(190, 25));

        JPanel weatherPanel = new JPanel();
        weatherLabel = new JLabel();
        weatherPanel.add(weatherLabel);
        weatherPanel.setPreferredSize(new Dimension(50, 20));

        JPanel rainPanel = new JPanel();
        rainPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        rainReadout = new JLabel("Rain: -- in./hr.");
        rainPanel.add(rainReadout);

        JPanel datePanel = new JPanel();
        datePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        dateReadout = new JLabel("Date: ---, --- --, ----");
        datePanel.add(dateReadout);

        JPanel timePanel = new JPanel();
        timePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        timeReadout = new JLabel("Time: --:--:-- a.m.");
        timePanel.add(timeReadout);

        JPanel sunrisePanel = new JPanel();
        sunrisePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        sunriseReadout = new JLabel("Sunrise: --:-- a.m.");
        sunrisePanel.add(sunriseReadout);

        JPanel sunsetPanel = new JPanel();
        sunsetPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        sunsetReadout = new JLabel("Sunset: --:-- p.m.");
        sunsetPanel.add(sunsetReadout);


        AboutInfo = new About();
        JButton aboutButton = new JButton("About Info");

        aboutButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                AboutInfo.setVisible(true);
                

            }
        });

        
        JButton alertButton1 = new JButton("Alert");

        alertButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                alertAlarm.setVisible(true);
                

            }
        });
        JPanel northLayoutPanel = new JPanel();
        northLayoutPanel.setLayout(new BorderLayout());

        JPanel eastLayoutPanel = new JPanel();
        eastLayoutPanel.setLayout(new BoxLayout(eastLayoutPanel, BoxLayout.Y_AXIS));

        JPanel westLayoutPanel = new JPanel();

        
        JPanel westLayoutSubPanel = new JPanel();
        westLayoutSubPanel.setLayout(new GridLayout(0, 1, 70, 50));
        westLayoutSubPanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        
        JPanel dataNorth = new JPanel();
        dataNorth.setLayout(new FlowLayout());

        JPanel buttonNorth = new JPanel();
        buttonNorth.setLayout(new FlowLayout());
        
        
        // Example Button addition into the South Panel Layout
        // ADD BUTTONS TO WEST PANEL.
        JButton tempButton = new JButton(new GraphButtonAction(GraphPanel.TEMP_SENSOR, "Graph Temperature"));
        JButton pressureButton = new JButton(new GraphButtonAction(GraphPanel.PRESSURE_SENSOR, "Graph Pressure"));
        JButton humidityButton = new JButton(new GraphButtonAction(GraphPanel.HUMIDITY_SENSOR, "Graph Humidity"));
        JButton rainfallButton = new JButton(new GraphButtonAction(GraphPanel.RAINFALL_SENSOR, "Graph Rainfall"));
        JButton windspeedButton = new JButton(new GraphButtonAction(GraphPanel.WIND_SENSOR, "Graph Wind Speed"));
        JButton close = new JButton("System shut down");
        close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Storage.tempWriter.close();
					Storage.humWriter.close();
					Storage.presWriter.close();
					Storage.speedWriter.close();
					Storage.dirWriter.close();
					Storage.phaseWriter.close();
					Storage.rainWriter.close();
					Storage.sunRiseWriter.close();
					Storage.sunSetWriter.close();
					Storage.wIconWriter.close();
					System.exit(0);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
	    
        
        

        JLabel previousLabel = new JLabel("Please select one.");
        JPanel centerPanel = new JPanel(new FlowLayout());
        JPanel previousPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        previousPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());

        JButton temp = new JButton("Get Temp");
        JButton humid = new JButton("Get Humid");
        JButton pressure = new JButton("Get Pressure");
        JButton rain = new JButton("Get Rain");
        JButton wind = new JButton("Get Windspeed");

        // Button for previous data
        JButton previousDataButton = new JButton("Get Snapshot");
        previousDataButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JDialog dis = new JDialog(frame, "Get Snapshot", true);
                
                temp.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        JDialog tempDialog = new JDialog(frame, "Previous Temp", true);
                        JPanel tempPanelPrevious = new JPanel();
                        tempPanelPrevious.setLayout(new GridLayout(3,1,30,30));
                        tempPanelPrevious.setBorder(BorderFactory.createEmptyBorder(25,100,20,20));
                        JLabel tempmaxLabel = new JLabel("Max: " + Storage.tempMax / 10 + " °F");
                        JLabel tempavgLabel = new JLabel("Average: " + Storage.tempAvg / 10 + " °F");
                        JLabel tempminLabel = new JLabel("Min: " + Storage.tempMin / 10 + " °F");
                        tempPanelPrevious.add(tempmaxLabel);
                        tempPanelPrevious.add(tempavgLabel);
                        tempPanelPrevious.add(tempminLabel);
                        tempDialog.add(tempPanelPrevious);
                        tempDialog.setSize(300, 200);
                        tempDialog.setResizable(false);
                        tempDialog.setLocationRelativeTo(frame);
                        tempDialog.setVisible(true);
                        dis.dispose();
                        tempDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
                     
                    }
                });
               
                humid.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        JDialog humidDialog = new JDialog(frame, "Previous Humid", true);
                        JPanel humidPanelPrevious = new JPanel();
                        humidPanelPrevious.setLayout(new GridLayout(3,1,30,30));
                        humidPanelPrevious.setBorder(BorderFactory.createEmptyBorder(25,100,20,20));
                        JLabel maxLabel = new JLabel("Max: " + Storage.humMax + " %");
                        JLabel avgLabel = new JLabel("Average: " + Storage.humAvg + " %");
                        JLabel minLabel = new JLabel("Min: " + Storage.humMin + " %");
                        humidPanelPrevious.add(maxLabel);
                        humidPanelPrevious.add(avgLabel);
                        humidPanelPrevious.add(minLabel);
                        humidDialog.add(humidPanelPrevious);
                        humidDialog.setSize(300, 200);
                        humidDialog.setResizable(false);
                        humidDialog.setLocationRelativeTo(frame);
                        humidDialog.setVisible(true);
                        dis.dispose();
                        humidDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
                    }
                });
                
                pressure.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        JDialog pressureDialog = new JDialog(frame, "Previous Pressure", true);
                        JPanel pressurePanelPrevious = new JPanel();
                        pressurePanelPrevious.setLayout(new GridLayout(3,1,30,30));
                        pressurePanelPrevious.setBorder(BorderFactory.createEmptyBorder(25,100,20,20));
                        JLabel maxLabel = new JLabel("Max: " + Storage.presMax / 1000.0 + " in.");
                        JLabel avgLabel = new JLabel("Average: " + Storage.presAvg / 1000.0 + " in.");
                        JLabel minLabel = new JLabel("Min: " + Storage.presMin / 1000.0 + " in.");
                        pressurePanelPrevious.add(maxLabel);
                        pressurePanelPrevious.add(avgLabel);
                        pressurePanelPrevious.add(minLabel);
                        pressureDialog.add(pressurePanelPrevious);
                        pressureDialog.setSize(300, 200);
                        pressureDialog.setResizable(false);
                        pressureDialog.setLocationRelativeTo(frame);
                        pressureDialog.setVisible(true);
                        dis.dispose();
                        pressureDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
                        
                    }
                    
                });
                
                rain.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        JDialog rainDialog = new JDialog(frame, "Previous Rain", true);
                        JPanel rainPanelPrevious = new JPanel();
                        rainPanelPrevious.setLayout(new GridLayout(3,1,30,30));
                        rainPanelPrevious.setBorder(BorderFactory.createEmptyBorder(25,100,20,20));
                        JLabel maxLabel = new JLabel("Max: " + Storage.rainMax / 10.0 + " in./hr.");
                        JLabel avgLabel = new JLabel("Average: " + Storage.rainAvg / 10.0 + " in./hr.");
                        JLabel minLabel = new JLabel("Min: " + Storage.rainMin / 10.0 + " in./hr.");
                        rainPanelPrevious.add(maxLabel);
                        rainPanelPrevious.add(avgLabel);
                        rainPanelPrevious.add(minLabel);
                        rainDialog.add(rainPanelPrevious);
                        rainDialog.setSize(300, 200);
                        rainDialog.setResizable(false);
                        rainDialog.setLocationRelativeTo(frame);
                        rainDialog.setVisible(true);
                        dis.dispose();
                        rainDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
                    }
                    
                });
              
                wind.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        JDialog windDialog = new JDialog(frame, "Previous Windspeed", true);
                        JPanel windPanelPrevious = new JPanel();
                        windPanelPrevious.setLayout(new GridLayout(3,1,30,30));
                        windPanelPrevious.setBorder(BorderFactory.createEmptyBorder(25,100,20,20));
                        JLabel maxLabel = new JLabel("Max: " + Storage.speedMax + " miles/hr.");
                        JLabel avgLabel = new JLabel("Average: " + Storage.speedAvg + " miles/hr.");
                        JLabel minLabel = new JLabel("Min: " + Storage.speedMin + " miles/hr.");
                        windPanelPrevious.add(maxLabel);
                        windPanelPrevious.add(avgLabel);
                        windPanelPrevious.add(minLabel);
                        windDialog.add(windPanelPrevious);
                        windDialog.setSize(300, 200);
                        windDialog.setResizable(false);
                        windDialog.setLocationRelativeTo(frame);
                        windDialog.setVisible(true);
                        dis.dispose();
                        windDialog.setDefaultCloseOperation(EXIT_ON_CLOSE);
                        
                    }
                    
                });
                buttonPanel.add(temp);
                buttonPanel.add(humid);
                buttonPanel.add(pressure);
                buttonPanel.add(rain);
                buttonPanel.add(wind);
                
                centerPanel.add(previousLabel);
                previousPanel.add(centerPanel, BorderLayout.CENTER);
                previousPanel.add(buttonPanel, BorderLayout.SOUTH);
                dis.add(previousPanel);

                dis.setSize(500, 100);
                dis.setResizable(false);
                dis.setLocationRelativeTo(frame);
                dis.setVisible(true);
            }
        });
        
        
//        alertAlarm = new Alerts();

        westLayoutSubPanel.add(tempButton);
        westLayoutSubPanel.add(pressureButton);
        westLayoutSubPanel.add(humidityButton);
        westLayoutSubPanel.add(rainfallButton);
        westLayoutSubPanel.add(windspeedButton);
        //westLayoutSubPanel.add(aboutButton);


        westLayoutPanel.add(westLayoutSubPanel);

        buttonNorth.add(aboutButton);
        buttonNorth.add(previousDataButton);

        buttonNorth.add(alertButton1);
        buttonNorth.add(close);
        //buttonNorth.add(alertAlarm.getAlarmButton());
        
        
       
	    
        dataNorth.add(tempPanel);
        dataNorth.add(humidPanel);
        dataNorth.add(pressurePanel);
        dataNorth.add(rainPanel);
        dataNorth.add(datePanel);
        dataNorth.add(timePanel);
        dataNorth.add(sunrisePanel);
        dataNorth.add(sunsetPanel);

        northLayoutPanel.add(buttonNorth, BorderLayout.WEST);
//         northLayoutPanel.add(alertAlarm.getAlarmButton(), BorderLayout.CENTER);
        //northLayoutPanel.add(close, BorderLayout.EAST);
        northLayoutPanel.add(dataNorth, BorderLayout.SOUTH);

        eastLayoutPanel.add(windPanel);
        eastLayoutPanel.add(moonPanel);
        eastLayoutPanel.add(weatherPanel);
        
        add(northLayoutPanel, BorderLayout.NORTH);
        add(eastLayoutPanel, BorderLayout.EAST);
        add(westLayoutPanel, BorderLayout.WEST);
        add(graphPanel, BorderLayout.CENTER);

       
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
       
    }
    

    /**
     * Sets the temperature
     * 
     * @param temp the temperature to set
     */
    public void setTemp(int temp) {
        String raw = Integer.toString(temp);
        tempReadout
                .setText("Temp: " + raw.substring(0, raw.length() - 1) + "." + raw.substring(raw.length() - 1) + " Â°F");
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.TEMP_SENSOR, temp);
        }
    }

    /**
     * Sets the humidity
     * 
     * @param humid the humidity to set
     */
    public void setHumid(int humid) {
        humidReadout.setText("Humid: " + Integer.toString(humid) + " %");
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.HUMIDITY_SENSOR, humid);
        }
    }

    /**
     * Sets the pressure
     * 
     * @param pressure to set
     */
    public void setPressure(int pressure) {
        String raw = Integer.toString(pressure);
        pressureReadout.setText(
                "Pressure:" + raw.substring(0, raw.length() - 3) + "." + raw.substring(raw.length() - 3) + " in.");
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.PRESSURE_SENSOR, pressure);
        }
    }

    /**
     * Sets the wind velocity
     * 
     * @param windspd the speed of the wind
     * @param winddir the direction of the wind
     */
    public void setWind(int windspd, int winddir) {
        windPanel.updateWind(windspd, winddir);
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.WIND_SENSOR, windspd);
        }
    }

    /**
     * Method creates the 8 moon phase icons and all the moon phase names.
     * 
     * @param moon the integer value indicating which moon to show. Comes from
     *             WeatherController.java
     */
    public void setMoonPhase(int moon) {
        // Create array of lunar choices lunar phase choices.
        String[] phases = { "New", "Waxing Crescent", "First Quarter", "Waxing Gibbous", "Full", "Waning Gibbous",
                "Third Quarter", "Waning Crescent" };

        // Retrieves the images and places them into an ImageIcon array.
        for (int i = 0; i < NUM_MOON_IMAGES; i++) {
            String imageName = "image" + i + ".png";
            URL url = getClass().getResource(String.format("/Lunar_Phases/%s", imageName));

            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(newImg);
            moonImages[i] = resizedIcon;
        }

        moonReadout.setText(phases[moon]);
        moonLabel.setIcon(moonImages[moon]);
    }

    /**
     * Based on the weather data received from the weather controller, the
     * setWeatherIcon will assign a weather icon. Example: Rain is high and its 32
     * degrees outside. The weather Icon will be snowing.
     * 
     * @param weatherData -> an integer value that will tell us which weather icon
     *                    to use.
     */
    public void setWeatherIcon(int weatherData) {

        // Retrieves the weather images and places them into an ImageIcon array.
        for (int i = 0; i < NUM_WEATHER_ICONS; i++) {
            String imageName = "image" + i + ".png";
            URL url = getClass().getResource(String.format("/Weather_Icons/%s", imageName));

            ImageIcon icon = new ImageIcon(url);
            Image image = icon.getImage();
            Image newImg = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            ImageIcon resizedIcon = new ImageIcon(newImg);
            weatherIcon[i] = resizedIcon;
        }
        weatherLabel.setIcon(weatherIcon[weatherData]);
    }

    /**
     * Set the current rainfall rate
     * 
     * @param rain rainfall to set
     */
    public void setRain(int rain) {
        String raw = Integer.toString(rain);
        rainReadout.setText(
                "Rain: " + raw.substring(0, raw.length() - 1) + "." + raw.substring(raw.length() - 1) + " in./hr.");
        if (graphPanel != null) {
            graphPanel.updateSensorValue(GraphPanel.RAINFALL_SENSOR, rain);
        }
    }

    /**
     * Set the current date
     * 
     * @param date The current date
     */
    public void setDate(Date date) {
        String raw = date.toString();
        dateReadout.setText("Date: " + raw.substring(0, 3) + ", " + raw.substring(4, 7) + " " + raw.substring(8, 10)
                + ", " + raw.substring(raw.length() - 4));

    }

    /**
     * Set the current time
     * 
     * @param time The current time of day
     */
    public void setTime(Date time) {
        String raw = time.toString();
        int timePeriod = Integer.valueOf(raw.substring(11, 13));
        if (timePeriod < 12) {
            if (timePeriod == 0) {
                timeReadout.setText("Time: 12" + raw.substring(13, 19) + " AM");
            } else {
                timeReadout.setText("Time: " + raw.substring(11, 19) + " AM");
            }
        } else {
            if (timePeriod == 12) {
                timeReadout.setText("Time: 12" + raw.substring(13, 19) + " PM");
            } else {
                timeReadout.setText("Time: " + Integer.toString((timePeriod - 12)) + raw.substring(13, 19) + " PM");
            }
        }
    }

    /**
     * Sets the time of sunrise
     * 
     * @param sunrise the time of sunrise to set
     */
    public void setSunrise(int sunrise) {
        sunriseReadout.setText(
                "Sunrise: 0" + Integer.toString(sunrise / 100) + ":" + String.format("%02d", sunrise % 100) + " AM");
    }

    /**
     * Sets the time of sunset
     * 
     * @param sunset the time of sunset to set
     */
    public void setSunset(int sunset) {
        sunsetReadout.setText(
                "Sunset: 0" + Integer.toString(sunset / 100) + ":" + String.format("%02d", sunset % 100) + " PM");
    }

    /**
     * Return the current date
     * 
     * @return current date
     */
    public String getDate() {
        return dateReadout.getText();
    }

    /**
     * Return the current time
     * 
     * @return current time
     */
    public String getTime() {
        return timeReadout.getText();
    }

    /**
     * Return the estimated time of sunrise
     * 
     * @return sunrise time
     */
    public String getSunrise() {
        return sunriseReadout.getText();
    }

    /**
     * Return the estimate time of sunset
     * 
     * @return sunset time
     */
    public String getSunset() {
        return sunsetReadout.getText();
    }

    public void graphTick() {
        if (graphPanel != null) {
            graphPanel.updateDisplay();
        }
    }

    /**
     * The action for each of the graph buttons that will change what the graph
     * graphs.
     * 
     * @author Group 6
     */
    private class GraphButtonAction extends AbstractAction {
        /**
         * The ID for the Serializable interface
         */
        private static final long serialVersionUID = 3612147189752191515L;
        /**
         * The sensor type to have the graph start showing
         */
        private int type;

        /**
         * The constructor for the Action
         * 
         * @param type       the sensor type that the button will cause the graph to
         *                   start showing
         * @param buttonName the name of the button
         */
        public GraphButtonAction(int type, String buttonName) {
            super(buttonName);
            this.type = type;
        }

        /**
         * Performs the actual setting of the graph sensor type
         * 
         * @param e the action event for the button pressed, will be not be used
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            graphPanel.setSensorType(type);
        }
    }
}
