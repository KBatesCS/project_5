import java.io.Serializable;
import java.util.Random;

public class Gate implements Serializable {
    private char terminal;
    private int gateNum;

    public Gate() {
        Random random = new Random();
        int letterNum = random.nextInt(3);
        if (letterNum == 0) {
            this.terminal = 'A';
        } else if (letterNum == 1) {
            this.terminal = 'B';
        } else {
            this.terminal = 'C';
        }
        int letterGate = random.nextInt(18);
        this.gateNum = letterGate + 1;
    }

    public String toString(){
        return terminal + String.valueOf(gateNum);
    }
}