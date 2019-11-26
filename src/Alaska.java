import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Alaska implements Airline {

    @Override
    public String getAirlineIntro() {
        return "Alaska Airlines is proud to serve the strong and knowledgable Boilermakers from Purdue University. \n " +
                "We primarily fly westward, and often have stops in Alaska and California. \n" +
                "We have first class amenities, even in coach class. \n" +
                "We provide fun snacks, such as pretzels and goldfish. \n" +
                "We also have comfortable seats and free WiFi. \n" +
                "We hope you choose Alaska Airlines for your next Itinerary!";
    }

    @Override
    public String getAirLineName() {
        return "Alaska";
    }

    @Override
    public String getAirLineNameWithAirLine() {
        return "Alaska Airlines";
    }

    @Override
    public int getStartLocationInFile() throws IOException {
        int locationLine = 0;
        ArrayList<String> reservationsFile = getReservationsFile();
        for(int i = 0; i < reservationsFile.size(); i++){
            if(reservationsFile.get(i).contains("ALASKA")){
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
            if(reservationsFile.get(i).contains("DELTA")){
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
        for(int i = getStartLocationInFile() + 4; i < getEndLocationInFile(); i = i + 2){
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
