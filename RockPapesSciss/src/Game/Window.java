package Game;
import javax.swing.JOptionPane;

public class Window {

//shows message in a Jpane
    public void msg(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
//gives the player an input options
    public String in(String msg) {
        return JOptionPane.showInputDialog(msg);
    }
//creates two buttons to press
    public static int option(String[] options, String msg) {
        return JOptionPane.showOptionDialog(
                null,
                msg, // my message
                "Click a button", // dialog box title
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options, // possible options
                options[0]); // default option
    }
//prints msg on one ln, if other println is used afterwards will print on other line
    public void println(String msg) {
        System.out.println(msg);
    }
//prints out msg 
    public void print(String msg) {
        System.out.print(msg);
    }


}