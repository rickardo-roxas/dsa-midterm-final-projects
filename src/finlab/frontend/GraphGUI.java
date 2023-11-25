package finlab.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphGUI extends JFrame {
    private Resources resources = new Resources();
    private JPanel panelMain;
    private JPanel panelCenter;
    private JPanel panelSidebar;
    private JPanel panelHome;
    private JPanel panelDfs;
    private JPanel panelBfs;
    private JPanel panelShortestPath;
    private JPanel panelCard;
    private final CardLayout cardLayout = new CardLayout(10,20);
    private final CardLayout cardLayout2 = new CardLayout(10,20);

    /**
     * TODO: Documentation
     */
    public GraphGUI() {
        super("Graph Traversal and Shortest Path");

        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.setPreferredSize(new Dimension(900,500));
        add(panelMain);

        panelCenter = new JPanel();
        panelCenter.setPreferredSize(new Dimension(700,500));
        panelMain.add(panelCenter, BorderLayout.CENTER);

        panelCard = new JPanel();
        panelCard.setLayout(cardLayout);
        panelCenter.add(panelCard);

        panelSidebar = populateSidebar();
        panelSidebar.setPreferredSize(new Dimension(200,500));
        panelSidebar.setBackground(Color.BLACK);
        panelMain.add(panelSidebar, BorderLayout.WEST);

        panelHome = populatePanelHome();
        panelHome.setPreferredSize(new Dimension(700,500));
        panelCard.add(panelHome, "home");

        panelDfs = populatePanelDfs();
        panelDfs.setPreferredSize(new Dimension(700,500));
        panelCard.add(panelDfs,"dfs");

        panelBfs = populatePanelBfs();
        panelDfs.setPreferredSize(new Dimension(700,500));
        panelCard.add(panelBfs, "bfs");

        panelShortestPath = populatePanelShortestPath();
        panelShortestPath.setPreferredSize(new Dimension(700,500));
        panelCard.add(panelShortestPath, "shortestPath");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,500);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    } // end of GraphGUI constructor

    private JPanel populateSidebar() {
        JPanel panelSidebar = new JPanel();
        panelSidebar.setLayout(new GridLayout(5,1,0,-300));

        JButton btnHome = createButtonSidebar("Home");
        btnHome.setHorizontalTextPosition(SwingConstants.LEFT);
        btnHome.setForeground(resources.white);
        panelSidebar.add(btnHome);

        JButton btnDfs = createButtonSidebar("Depth-First Search");
        btnDfs.setForeground(resources.white);
        panelSidebar.add(btnDfs);

        JButton btnBfs = createButtonSidebar("Breadth-First Search");
        btnBfs.setForeground(resources.white);
        panelSidebar.add(btnBfs);

        JButton btnShortestPath = createButtonSidebar("Find Shortest Path");
        btnShortestPath.setForeground(resources.white);
        panelSidebar.add(btnShortestPath);

        JButton btnExit = createButtonSidebar("Exit");
        btnExit.setForeground(resources.white);
        panelSidebar.add(btnExit);

        btnHome.addActionListener(e-> {
            cardLayout.show(panelCard, "home");
            btnColorChangeSidebar(btnHome, btnBfs, btnDfs, btnShortestPath);
        });

        btnDfs.addActionListener(e -> {
            cardLayout.show(panelCard, "dfs");
            btnColorChangeSidebar(btnDfs, btnHome, btnBfs, btnShortestPath);
        });


        btnBfs.addActionListener(e -> {
            cardLayout.show(panelCard, "bfs");
            btnColorChangeSidebar(btnBfs, btnHome, btnDfs, btnShortestPath);
        });

        btnShortestPath.addActionListener(e -> {
            cardLayout.show(panelCard, "shortestPath");
            btnColorChangeSidebar(btnShortestPath, btnDfs, btnHome, btnBfs);
        });

        btnExit.addActionListener(e-> System.exit(0));

        return panelSidebar;
    }

    private JPanel populatePanelHome() {
        JPanel panelHome = new JPanel();
        panelHome.setLayout(new BorderLayout());

        JPanel panelInstructions = new JPanel();
        panelHome.setPreferredSize(new Dimension(700, 250));
        panelHome.add(panelInstructions, BorderLayout.NORTH);

        JLabel labelInstructions = new JLabel("Instructions here.");
        panelInstructions.add(labelInstructions);

        JPanel panelImport = new JPanel();
        panelImport.setLayout(new FlowLayout());
        panelImport.setPreferredSize(new Dimension(700, 250));
        panelHome.add(panelImport, BorderLayout.SOUTH);

        JButton buttonImport = createButtonHome("Import File");
        panelImport.add(buttonImport);

        buttonImport.addActionListener(e-> {
            JFileChooser fileChooser = new JFileChooser("graphs");
            fileChooser.showOpenDialog(null);
        });

        JButton buttonNext = createButtonHome("Next");
        panelImport.add(buttonNext);

        return panelHome;
    }

    private JPanel populatePanelVisual() {
        JPanel panelVisualization = new JPanel();



        return panelVisualization;
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

    private JButton createButtonSidebar(String text) {
        JButton button = new JButton(text);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        return button;
    }

    private JButton createButtonHome(String text) {
        JButton button = new JButton(text);
        button.setFont(resources.montserratBold);
        button.setForeground(resources.white);
        button.setBackground(resources.ultravioletBlue);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusable(false);
        return button;
    }

    private void btnColorChangeSidebar(JButton button1, JButton button2, JButton button3, JButton button4) {
        button1.setForeground(resources.ultravioletBlue);
        button2.setForeground(resources.white);
        button3.setForeground(resources.white);
        button4.setForeground(resources.white);
    }
}
