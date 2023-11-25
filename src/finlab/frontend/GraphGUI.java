package finlab.frontend;

import midlab2.frontend.Resources;

import javax.swing.*;
import java.awt.*;

public class GraphGUI extends JFrame {
    private Resources resources;
    private JPanel panelMain;
    private JPanel panelCenter;
    private JPanel panelSidebar;
    private JPanel panelHome;
    private JPanel panelDfs;
    private JPanel panelBfs;
    private JPanel panelShortestPath;
    private final CardLayout cardLayout = new CardLayout(0,0);

    public GraphGUI() {
        super("Graph Traversal and Shortest Path");

        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.setPreferredSize(new Dimension(800,500));
        add(panelMain);

        panelCenter = populatePanelCenter();
        panelCenter.setPreferredSize(new Dimension(600,500));
        panelMain.add(panelCenter, BorderLayout.CENTER);

        panelSidebar = populateSidebar();
        panelSidebar.setPreferredSize(new Dimension(200,500));
        panelSidebar.setBackground(Color.BLACK);
        panelMain.add(panelSidebar, BorderLayout.WEST);

        panelHome = populatePanelHome();
        panelHome.setPreferredSize(new Dimension());
        panelDfs = populatePanelDfs();
        panelBfs = populatePanelBfs();
        panelShortestPath = populatePanelShortestPath();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,500);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    } // end of GraphGUI constructor

    private JPanel populatePanelCenter() {
        JPanel panelCenter = new JPanel();

        return panelCenter;
    }

    private JPanel populateSidebar() {
        JPanel panelSidebar = new JPanel();
        panelSidebar.setLayout(new GridLayout(5,1));

        JButton btnHome = new JButton();
        btnHome.setForeground(Color.WHITE);
        panelSidebar.add(btnHome);

        JButton btnDfs = new JButton();
        btnDfs.setForeground(Color.WHITE);
        panelSidebar.add(btnDfs);

        JButton btnBfs = new JButton();
        panelSidebar.add(btnBfs);

        JButton btnShortestPath = new JButton();
        panelSidebar.add(btnShortestPath);

        JButton btnExit = new JButton();
        panelSidebar.add(btnExit);

        return panelSidebar;
    }

    private JPanel populatePanelHome() {
        JPanel panelHome = new JPanel();

        return panelHome;
    }

    private JPanel populatePanelDfs() {
        JPanel panelDfs = new JPanel();

        return panelDfs;
    }

    private JPanel populatePanelBfs() {
        JPanel panelBfs = new JPanel();

        return panelBfs;
    }

    private JPanel populatePanelShortestPath() {
        JPanel panelShortestPath = new JPanel();

        return panelShortestPath;
    }
}
