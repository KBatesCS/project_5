import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Delta implements Airline {

    @Override
    public String getAirlineIntro() {
        return "Delta Airlines is proud to be one of the five premier Airlines at Purdue University. \n " +
                "We are extremely offer exceptional services, with free limited WiFi for all customers. \n" +
                "Passengers who use T-Mobile as a cell phone carrier get additional benefits. \n" +
                "We are also happy to offer power outlets in each seat for passenger use. \n" +
                "We hope you choose to fly Delta as your next Airline \n";
    }

    @Override
    public String getAirLineName() {
        return "Delta";
    }

    @Override
    public String getAirLineNameWithAirLine() {
        return "Delta Airlines";
    }

    @Override
    public int getStartLocationInFile() throws IOException {
        int locationLine = 0;
        ArrayList<String> reservationsFile = getReservationsFile();
        for(int i = 0; i < reservationsFile.size(); i++){
            if(reservationsFile.get(i).contains("DELTA")){
                locationLine = i;
                break;
            }
        }
        return locationLine;
    }

    @Override
    public int getEndLocationInFile() throws IOException {
        int locationLine = 0;
        ArrayList<String> reservationsFile = getReservationsFile();
        for(int i = 0; i < reservationsFile.size(); i++){
            if(reservationsFile.get(i).contains("SOUTHWEST")){
                locationLine = i - 2;
                break;
            }
        }
        return locationLine;
    }

    @Override
    public boolean getFull() throws IOException {
        return getPassengers() >= getSpace();
    }

    @Override
    public int getPassengers() throws IOException {
        int lineStart = getStartLocationInFile();
        ArrayList<String> reservationsFile = getReservationsFile();
        String theLine = reservationsFile.get(lineStart + 1);
        String[] splitLine = theLine.split("/");
        return Integer.parseInt(splitLine[0]);
    }

    @Override
    public int getSpace() throws IOException {
        int lineStart = getStartLocationInFile();
        ArrayList<String> reservationsFile = getReservationsFile();
        String theLine = reservationsFile.get(lineStart + 1);
        String[] splitLine = theLine.split("/");
        return Integer.parseInt(splitLine[1]);
    }

    @Override
    public String getPassengersList() throws IOException {
        String passengersList = "";
        ArrayList<String> reservationsFile = getReservationsFile();
        for(int i = getStartLocationInFile() + 3; i < getEndLocationInFile(); i = i + 2){
            passengersList += reservationsFile.get(i);
        }
        return passengersList;
    }

    @Override
    public ArrayList<String> getReservationsFile() throws IOException {
        FileReader fr = new FileReader(new File("reservations.txt"));
        BufferedReader bfr = new BufferedReader(fr);
        String line = "";
        ArrayList<String> lines = new ArrayList<String>();
        while(line != null){
            lines.add(line);
            line = bfr.readLine();
        }
        return lines;
    }

}
