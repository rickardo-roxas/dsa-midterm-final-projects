package finlab.frontend;

import javax.swing.*;

public class Main extends Thread {
    Resources resources = new Resources();

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void run() {
        resources.loadFonts();
        SwingUtilities.invokeLater(() -> new GraphGUI());
    }
}
