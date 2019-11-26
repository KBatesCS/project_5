import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public interface Airline extends Serializable {
    String getAirlineIntro();
    String getAirLineName();
    String getAirLineNameWithAirLine();
    int getStartLocationInFile() throws IOException;
    int getEndLocationInFile() throws IOException;
    boolean getFull() throws IOException;
    int getPassengers() throws IOException;
    int getSpace() throws IOException;
    String getPassengersList() throws IOException;
    ArrayList<String> getReservationsFile() throws IOException;

}
