import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Southwest implements Airline {

    @Override
    public String getAirlineIntro() {
        return "Southwest airlines is proud to offer flightsto Purdue University. \n " +
                "We are happy to offer free in fliht wifi, as well as our amazing snacks \n" +
                "In addition, we offer flights for much cheaper than other airlines, and offer two free checked bags. \n" +
                "We hope you choose Southwest for your next flight \n";
    }

    @Override
    public String getAirLineName() {
        return "Southwest";
    }

    @Override
    public String getAirLineNameWithAirLine() {
        return "Southwest Airlines";
    }

    @Override
    public int getStartLocationInFile() throws IOException {
        int locationLine = 0;
        ArrayList<String> reservationsFile = getReservationsFile();
        for(int i = 0; i < reservationsFile.size(); i++){
            if(reservationsFile.get(i).contains("Southwest")){
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
            if(reservationsFile.get(i).contains("EOF")){
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
