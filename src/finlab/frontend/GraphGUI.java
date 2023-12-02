package finlab.frontend;

import finlab.backend.GraphUtility;
import javax.swing.*;
import java.awt.*;

public class GraphGUI extends JFrame {
    private final Resources resources = new Resources();
    private GraphUtility graphUtility = new GraphUtility();
    private JPanel panelMain;
    private JPanel panelCenter;
    private JPanel panelSidebar;
    private JPanel panelHome;
    private JPanel panelVisualize;
    private JPanel panelTraverse;
    private JPanel panelPath;
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

        panelVisualize = populatePanelVisualize();
        panelVisualize.setPreferredSize(new Dimension(700,500));
        panelCard.add(panelVisualize,"visualize");

        panelTraverse = populatePanelTraverse();
        panelTraverse.setPreferredSize(new Dimension(700,500));
        panelCard.add(panelTraverse, "traverse");

        panelPath = populatePanelPath();
        panelPath.setPreferredSize(new Dimension(700,500));
        panelCard.add(panelPath, "path");

        revalidate();
        repaint();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,500);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    } // end of GraphGUI constructor

    private JPanel populateSidebar() {
        JPanel panelSidebar = new JPanel();
        panelSidebar.setBackground(resources.richBlack);
        panelSidebar.setLayout(new BorderLayout());

        JPanel panelButtons = new JPanel();
        panelButtons.setBackground(resources.richBlack);
        panelButtons.setPreferredSize(new Dimension(200, 300));
        panelButtons.setLayout(new GridBagLayout());
        panelSidebar.add(panelButtons, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.weightx = 50;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy = 0;
        JButton btnHome = createButtonSidebar("Home");
        btnHome.setForeground(resources.ultravioletBlue);
        panelButtons.add(btnHome, gbc);

        gbc.gridy = 1;
        JButton btnDfs = createButtonSidebar("Graph Visualization");
        btnDfs.setForeground(resources.white);
        panelButtons.add(btnDfs, gbc);

        gbc.gridy = 2;
        JButton btnBfs = createButtonSidebar("Traverse Graph");
        btnBfs.setForeground(resources.white);
        panelButtons.add(btnBfs, gbc);

        gbc.gridy = 3;
        JButton btnShortestPath = createButtonSidebar("Find Shortest Path");
        btnShortestPath.setForeground(resources.white);
        panelButtons.add(btnShortestPath, gbc);

        gbc.gridy = 4;
        JButton btnExit = createButtonSidebar("Exit");
        btnExit.setForeground(resources.white);
        panelButtons.add(btnExit, gbc);

        btnHome.addActionListener(e-> {
            cardLayout.show(panelCard, "home");
            btnColorChangeSidebar(btnHome, btnBfs, btnDfs, btnShortestPath);
        });

        btnDfs.addActionListener(e -> {
            cardLayout.show(panelCard, "visualize");
            btnColorChangeSidebar(btnDfs, btnHome, btnBfs, btnShortestPath);
        });


        btnBfs.addActionListener(e -> {
            cardLayout.show(panelCard, "traverse");
            btnColorChangeSidebar(btnBfs, btnHome, btnDfs, btnShortestPath);
        });

        btnShortestPath.addActionListener(e -> {
            cardLayout.show(panelCard, "path");
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

            try {
                graphUtility.readFile(fileChooser.getSelectedFile());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        JButton buttonNext = createButtonHome("Next");
        panelImport.add(buttonNext);

        panelHome.repaint();
        panelHome.revalidate();
        return panelHome;
    }

    private JPanel populatePanelVisualize() {
        JPanel panelVisualization = new JPanel();



        return panelVisualization;
    }

    private JPanel populatePanelTraverse() {
        JPanel panelContainer = new JPanel();
        panelContainer.setLayout(new BorderLayout());

        // Input Panel
        JPanel panelInput = new JPanel();
        panelInput.setPreferredSize(new Dimension(700,120));
        panelInput.setLayout(new GridLayout(3,1));
        panelContainer.add(panelInput, BorderLayout.NORTH);

        // ! Input Panel Components
        JPanel panelText = new JPanel();
        panelText.setPreferredSize(new Dimension(700, 40));
        panelText.setLayout(new FlowLayout());
        panelInput.add(panelText);

        // !! Text Panel Components
        JLabel lblStartNode = createLabel("Starting Node:", resources.richBlack);
        panelText.add(lblStartNode);

        JTextField txtFieldStartNode = new JTextField();
        txtFieldStartNode.setColumns(10);
        panelText.add(txtFieldStartNode);

        JLabel lblEndNode = createLabel("End Node:", resources.richBlack);
        panelText.add(lblEndNode);

        JTextField txtFieldEndNode = new JTextField();
        txtFieldEndNode.setColumns(10);
        panelText.add(txtFieldEndNode);

        // ! Input Panel Components
        JPanel panelRadio = new JPanel();
        panelRadio.setPreferredSize(new Dimension(700,40));
        panelRadio.setLayout(new FlowLayout());
        panelInput.add(panelRadio);

        // !! Radio Panel
        JLabel labelAlgo = createLabel("Search Algorithm:" , resources.richBlack);
        panelRadio.add(labelAlgo);

        JRadioButton radioBtnBfs = new JRadioButton();
        radioBtnBfs.setText("Breadth-first Search");
        radioBtnBfs.setForeground(resources.ultravioletBlue);
        panelRadio.add(radioBtnBfs);

        JRadioButton radioBtnDfs = new JRadioButton();
        radioBtnDfs.setText("Depth-first Search");
        radioBtnDfs.setForeground(resources.ultravioletBlue);
        panelRadio.add(radioBtnDfs);

        ButtonGroup btnGrpRadio = new ButtonGroup();
        btnGrpRadio.add(radioBtnBfs);
        btnGrpRadio.add(radioBtnDfs);

        // ! Buttons Panel
        JPanel panelButtons = new JPanel();
        panelButtons.setPreferredSize(new Dimension(700,40));
        panelButtons.setLayout(new FlowLayout());
        panelInput.add(panelButtons);

        // !! Buttons Panel Components
        JButton btnClear = createButtonTraverse("Clear");
        panelButtons.add(btnClear);

        JButton btnTraverse = createButtonTraverse("Traverse");
        panelButtons.add(btnTraverse);

        // Output Panel
        JPanel panelOutput = new JPanel();
        panelOutput.setPreferredSize(new Dimension(700,380));
        panelContainer.add(panelOutput, BorderLayout.SOUTH);

        return panelContainer;
    }

    private JPanel populatePanelPath() {
        JPanel panelBfs = new JPanel();

        return panelBfs;
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

    private JButton createButtonTraverse(String text) {
        JButton button = new JButton(text);
        button.setFont(resources.montserratBold);
        button.setForeground(resources.white);
        button.setBackground(resources.ultravioletBlue);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setContentAreaFilled(true);
        button.setFocusable(false);
        return button;
    }

    private void btnColorChangeSidebar(JButton button1, JButton button2, JButton button3, JButton button4) {
        button1.setForeground(resources.ultravioletBlue);
        button2.setForeground(resources.white);
        button3.setForeground(resources.white);
        button4.setForeground(resources.white);
    }

    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }
}
