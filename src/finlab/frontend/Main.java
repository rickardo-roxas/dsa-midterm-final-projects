package finlab.frontend;

import javax.swing.*;

public class Main {
    Resources resources = new Resources();
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
        SwingUtilities.invokeLater(() -> new GraphGUI());
    }

    private void run() {
        resources.loadFonts();
    }
}
