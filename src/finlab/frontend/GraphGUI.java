package finlab.frontend;

import finlab.backend.Graph;
import finlab.backend.GraphUtility;
import finlab.backend.Vertex;
import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This class, GraphGUI represents a graphical user interface for a program focused on graph traversal
 * and finding the shortest path in a graph.
 * The GUI consists of a main frame containing a central panel, a sidebar, and multiple
 * card panels for different functionalities like home, import, visualize, traverse, and path.
 */
public class GraphGUI extends JFrame {

    /** The resources object for managing external resources. */
    private final Resources resources = new Resources();

    /** The utility class for handling graph-related operations. */
    private GraphUtility graphUtility = new GraphUtility();

    /** The main panel containing the entire GUI components. */
    private JPanel panelMain;

    /** The central panel within the main panel. */
    private JPanel panelCenter;

    /** The sidebar panel containing navigation options. */
    private JPanel panelSidebar;

    /** The home panel for the default view. */
    private JPanel panelHome;

    /** The panel for visualizing the graph. */
    private JPanel panelVisualize;

    /** The panel for importing data. */
    private JPanel panelImport;

    /** The panel for graph traversal. */
    private JPanel panelTraverse;

    /** The panel for finding the shortest path. */
    private JPanel panelPath;

    /** The card layout panel to switch between different functionalities. */
    private JPanel panelCard;

    /** Button for navigating to the home panel. */
    private JButton btnHome;

    /** Button for navigating to the import panel. */
    private JButton btnImport;

    /** Button for navigating to the visualize panel. */
    private JButton btnVisualize;

    /** Button for navigating to the traverse panel. */
    private JButton btnTraverse;

    /** Button for navigating to the path panel. */
    private JButton btnPath;

    /** Button for exiting the application. */
    private JButton btnExit;

    /** Text area for displaying output or information. */
    private JTextArea txtAreaOutput = new JTextArea();

    /** The card layout manager for switching between different card panels. */
    private final CardLayout cardLayout = new CardLayout(10, 20);

    /**
     * It Constructs a new instance of the GraphGUI class.
     * Initializes the main frame with a title, sets up the layout, and populates
     * various panels for different functionalities. Finally, sets the frame properties
     * such as size, visibility, and default close operation.
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

        panelImport = populatePanelImport();
        panelImport.setPreferredSize(new Dimension(700,500));
        panelCard.add(panelImport, "import");

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

    /**
     * It populates the sidebar panel with navigation buttons for different functionalities.
     * Each button triggers a card layout switch to the corresponding panel and updates
     * the button colors for visual feedback.
     * @return The populated sidebar panel with navigation buttons.
     */
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
        btnHome = createButtonSidebar("Home");
        btnHome.setForeground(resources.ultravioletBlue);
        panelButtons.add(btnHome, gbc);

        gbc.gridy = 1;
        btnImport = createButtonSidebar("Import File");
        btnImport.setForeground(resources.white);
        panelButtons.add(btnImport, gbc);

        gbc.gridy = 2;
        btnVisualize = createButtonSidebar("Graph Visualization");
        btnVisualize.setForeground(resources.white);
        panelButtons.add(btnVisualize, gbc);

        gbc.gridy = 3;
        btnTraverse = createButtonSidebar("Traverse Graph");
        btnTraverse.setForeground(resources.white);
        panelButtons.add(btnTraverse, gbc);

        gbc.gridy = 4;
        btnPath = createButtonSidebar("Find Shortest Path");
        btnPath.setForeground(resources.white);
        panelButtons.add(btnPath, gbc);

        gbc.gridy = 5;
        btnExit = createButtonSidebar("Exit");
        btnExit.setForeground(resources.white);
        panelButtons.add(btnExit, gbc);

        btnHome.addActionListener(e-> {
            cardLayout.show(panelCard, "home");
            btnColorChangeSidebar(btnHome, btnImport, btnVisualize, btnTraverse, btnPath);
        });

        btnImport.addActionListener(e -> {
            cardLayout.show(panelCard, "import");
            btnColorChangeSidebar(btnImport, btnHome, btnPath, btnTraverse, btnVisualize);
        });

        btnVisualize.addActionListener(e -> {
            cardLayout.show(panelCard, "visualize");
            btnColorChangeSidebar(btnVisualize, btnHome, btnTraverse, btnPath, btnImport);
        });

        btnTraverse.addActionListener(e -> {
            cardLayout.show(panelCard, "traverse");
            btnColorChangeSidebar(btnTraverse, btnHome, btnVisualize, btnPath, btnImport);
        });

        btnPath.addActionListener(e -> {
            cardLayout.show(panelCard, "path");
            btnColorChangeSidebar(btnPath, btnVisualize, btnHome, btnTraverse, btnImport);
        });

        btnExit.addActionListener(e-> System.exit(0));

        return panelSidebar;
    }

    /**
     * This populates the home panel with welcome messages, instructions, and a continue button.
     * The home panel serves as the initial view when the application starts.
     * @return The populated home panel containing welcome messages, instructions, and a continue button.
     */
    private JPanel populatePanelHome() {
        JPanel panelContainer = new JPanel();
        panelContainer.setBorder(resources.normalPadding);
        panelContainer.setLayout(new BorderLayout());

        JPanel panelHeader = new JPanel();
        panelHeader.setPreferredSize(new Dimension(700,100));
        panelContainer.add(panelHeader, BorderLayout.NORTH);

        JLabel lblHeader = new JLabel();
        lblHeader.setText("Welcome to Graph Theory");
        lblHeader.setFont(resources.montserratBold);
        lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeader.setVerticalAlignment(SwingConstants.CENTER);
        panelHeader.add(lblHeader);

        JPanel panelInstructions = new JPanel();
        panelContainer.setPreferredSize(new Dimension(700, 300));
        panelContainer.add(panelInstructions, BorderLayout.CENTER);

        JTextArea txtAreaInstructions = populateTextAreaInstructions();
        panelInstructions.add(txtAreaInstructions);

        JPanel panelButtons = new JPanel();
        panelButtons.setPreferredSize(new Dimension(700, 100));
        panelButtons.setLayout(new FlowLayout());
        panelContainer.add(panelButtons, BorderLayout.SOUTH);

        JButton btnContinue = createButtonHome("Continue");
        panelButtons.add(btnContinue);

        btnContinue.addActionListener(e -> {
            cardLayout.show(panelCard, "import");
            btnColorChangeSidebar(btnImport, btnHome, btnVisualize, btnTraverse, btnPath);
        });

        panelContainer.repaint();
        panelContainer.revalidate();
        return panelContainer;
    }

    /**
     * This populates the import panel with components for importing graph data from a file.
     * The panel includes a button to trigger the file selection dialog, a display area for
     * the adjacency matrix, and buttons for clearing the data or proceeding to visualization.
     */
    private JPanel populatePanelImport() {
        JPanel panelContainer = new JPanel();
        panelContainer.setBorder(resources.normalPadding);
        panelContainer.setLayout(new BorderLayout());

        JPanel panelImport = new JPanel();
        panelImport.setLayout(new FlowLayout());
        panelImport.setPreferredSize(new Dimension(700, 100));
        panelContainer.add(panelImport, BorderLayout.NORTH);

        // Import Panel Components
        JButton btnImport = createButtonHome("Import File");
        panelImport.add(btnImport, BorderLayout.NORTH);

        JPanel panelMatrix = new JPanel();
        panelMatrix.setBackground(resources.white);
        panelMatrix.setLayout(new BorderLayout());
        panelMatrix.setPreferredSize(new Dimension(900,400));

        // Matrix Panel Components

        JTextArea txtAreaMatrix = createTextAreaOutput();
        txtAreaMatrix.setText("Import file first.");
        panelMatrix.add(txtAreaMatrix, BorderLayout.CENTER);

        // Matrix Panel Scroll Pane
        JScrollPane scrollPane = new JScrollPane(panelMatrix);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panelContainer.add(scrollPane, BorderLayout.CENTER);

        JPanel panelButton = new JPanel();
        panelButton.setPreferredSize(new Dimension(700,100));
        panelButton.setLayout(new FlowLayout());
        panelContainer.add(panelButton, BorderLayout.SOUTH);

        // Button Panel Components
        JButton btnClear = createButtonHome("Clear");
        btnClear.setEnabled(false);
        panelButton.add(btnClear);

        JButton btnNext = createButtonHome("Next");
        btnNext.setEnabled(false);
        panelButton.add(btnNext);

        // Action Listeners
        btnImport.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser("graphs");
            fileChooser.showOpenDialog(null);

            try {
                if (fileChooser.getSelectedFile() != null) {
                    graphUtility.readFile(fileChooser.getSelectedFile());
                    btnNext.setEnabled(true);
                    btnClear.setEnabled(true);
                    JOptionPane.showInternalMessageDialog(null,
                            "Successfully Imported Contents of file",
                            "Import Status", JOptionPane.INFORMATION_MESSAGE);

                    Path filePath = Paths.get(fileChooser.getSelectedFile().toURI());
                    String fileContents = new String(Files.readAllBytes(filePath));

                    txtAreaMatrix.setText(graphUtility.getGraph().toString() + "\n\n" +
                            "Adjacency Matrix:" + "\n" + fileContents);

                    txtAreaOutput.setText("Graph:\n\n" + "V={" + graphUtility.getGraph().getNodes().toString() + "}\n" +
                            "E={" + graphUtility.getGraph().getEdges().toString() + "}\n\n" +
                            "Adjacency Matrix:\n" + fileContents);
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        btnClear.addActionListener(e -> {
            graphUtility.setGraph(null);
            btnNext.setEnabled(false);
            btnClear.setEnabled(false);
            txtAreaMatrix.setText("Import file first.");
        });

        btnNext.addActionListener(e -> {
            cardLayout.show(panelCard,"visualize");
            btnImport.setForeground(resources.white);
            btnColorChangeSidebar(btnVisualize, btnHome, btnTraverse, btnPath, btnImport);
        });

        panelContainer.revalidate();
        panelContainer.repaint();
        return panelContainer;
    }

    /**
     * This populates the visualized panel with components for displaying graph information and visualization.
     * The panel includes a text area for graph details and a visualization area using GraphVisualization.
     * @return The populated visualize panel with components for graph details and visualization.
     */
    private JPanel populatePanelVisualize() {
        JPanel panelContainer = new JPanel();
        panelContainer.setBorder(resources.normalPadding);
        panelContainer.setPreferredSize(new Dimension(700,500));
        panelContainer.setLayout(new BorderLayout());

        // Container Panel Components
        JPanel panelText = new JPanel();
        panelText.setPreferredSize(new Dimension(800,500));
        panelText.setLayout(new GridLayout(1,1));
        panelText.setBackground(resources.white);

        // ! Text Panel Components
        txtAreaOutput = createTextAreaOutput();
        txtAreaOutput.setText("Import file first.");
        panelText.add(txtAreaOutput);

        JScrollPane scrollPane = new JScrollPane(panelText);
        scrollPane.setPreferredSize(new Dimension(500,400));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        panelContainer.add(scrollPane, BorderLayout.NORTH);

        panelContainer.revalidate();
        panelContainer.repaint();
        return panelContainer;
    }

    /**
     * This populates the traverse panel with components for specifying traversal parameters,
     * performing graph traversal, and displaying traversal results.
     */
    private JPanel populatePanelTraverse() {
        JPanel panelContainer = new JPanel();
        panelContainer.setBorder(resources.normalPadding);
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
        panelOutput.setPreferredSize(new Dimension(700,300));
        panelOutput.setBackground(resources.white);
        panelContainer.add(panelOutput, BorderLayout.SOUTH);

        // ! Output Panel Components
        JTextArea txtAreaOutput = createTextAreaOutput();
        panelOutput.add(txtAreaOutput);

        btnTraverse.addActionListener(e -> {
            Vertex startNode = new Vertex(txtFieldStartNode.getText());
            List<Vertex> visited = new ArrayList<>();
            if (btnGrpRadio.isSelected(radioBtnBfs.getModel())) {
                if (graphUtility.getGraph().getNodes().contains(startNode)) {
                    visited = graphUtility.breadthFirstSearch(startNode);
                }
            } else if (btnGrpRadio.isSelected(radioBtnDfs.getModel())) {
                if (graphUtility.getGraph().getNodes().contains(startNode)) {
                    visited = graphUtility.depthFirstSearch(startNode, (ArrayList<Vertex>) visited);
                }
            }
            txtAreaOutput.setText("Results:\n" + visited.toString());
        });

        panelContainer.revalidate();
        panelContainer.repaint();
        return panelContainer;
    }

    /**
     * This populates the path panel with components for specifying path parameters,
     * finding paths using Dijkstra's algorithm, and displaying path results.
     * @return The populated path panel with components for finding paths in the graph.
     */
    private JPanel populatePanelPath() {
        JPanel panelContainer = new JPanel();
        panelContainer.setBorder(resources.normalPadding);
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

        JRadioButton radioBtnDijkstra = new JRadioButton();
        radioBtnDijkstra.setText("Dijkstra's Algorithm");
        radioBtnDijkstra.setForeground(resources.ultravioletBlue);
        panelRadio.add(radioBtnDijkstra);

        ButtonGroup btnGrpRadio = new ButtonGroup();
        btnGrpRadio.add(radioBtnDijkstra);

        // ! Buttons Panel
        JPanel panelButtons = new JPanel();
        panelButtons.setPreferredSize(new Dimension(700,40));
        panelButtons.setLayout(new FlowLayout());
        panelInput.add(panelButtons);

        // !! Buttons Panel Components
        JButton btnClear = createButtonTraverse("Clear");
        panelButtons.add(btnClear);

        JButton btnFind = createButtonTraverse("Find Path");
        panelButtons.add(btnFind);

        // Output Panel
        JPanel panelOutput = new JPanel();
        panelOutput.setPreferredSize(new Dimension(700,300));
        panelOutput.setBackground(resources.white);
        panelContainer.add(panelOutput, BorderLayout.SOUTH);

        JTextArea txtAreaOutput = createTextAreaOutput();
        panelOutput.add(txtAreaOutput);

        btnFind.addActionListener(e -> {
            Vertex startNode = new Vertex(txtFieldStartNode.getText());
            Vertex endNode = new Vertex(txtFieldEndNode.getText());
            List<Vertex> visited = new ArrayList<>();
            if (btnGrpRadio.isSelected(radioBtnDijkstra.getModel())) {
                if (graphUtility.getGraph().getNodes().contains(startNode) && graphUtility.getGraph().getNodes().contains(endNode)) {
                    visited = graphUtility.dijkstraShortestPath(graphUtility.getGraph(), startNode, endNode);
                }
            }
            txtAreaOutput.setText("Results:\n" + visited.toString() +"\n\n" + graphUtility.getDijkstraData().toString());
        });

        panelContainer.revalidate();
        panelContainer.repaint();
        return panelContainer;
    }

    /**
     * This populates a JTextArea with instructional text for guiding the user on how to use the graph application.
     * @return The populated JTextArea containing instructions for using the graph application.
     */
    private JTextArea populateTextAreaInstructions() {
        JTextArea textArea = new JTextArea();

        String instructions = "Instructions:\n\n" +
                "1. Import a file in the Import File menu. Files are provided for undirected, directed, weighted, and unweighted graphs.\n" +
                "2. To traverse a graph, input a starting node from the imported file and choose a search algorithm.\n" +
                "3. To find a shortest path, input a start and end node from the imported graph. By default, the Dijkstra Algorithm is to be used.\n\n" +
                "**Note: This program can only visualize a graph when initialized; but not the traversing and shortest path visualization.";

        textArea.setText(instructions);
        textArea.setPreferredSize(new Dimension(500, 260));
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setForeground(resources.richBlack);
        return textArea;
    }

    /**
     * Creates a JButton for the sidebar with the specified text.
     * @param text The text to be displayed on the button.
     * @return The created JButton for the sidebar.
     */
    private JButton createButtonSidebar(String text) {
        JButton button = new JButton(text);
        button.setHorizontalAlignment(SwingConstants.LEFT);
        button.setContentAreaFilled(false);
        button.setOpaque(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        return button;
    }

    /**
     * Creates a JButton for the home panel with the specified text.
     * @param text The text to be displayed on the button.
     * @return The created JButton for the home panel.
     */
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


    /**
     * Creates a JButton for the traverse panel with the specified text.
     * @param text The text to be displayed on the button.
     * @return The created JButton for the traverse panel.
     */
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

    /**
     * Changes the foreground color of specified buttons to highlight the active button.
     * @param button1 The first button to be highlighted.
     * @param button2 The second button.
     * @param button3 The third button.
     * @param button4 The fourth button.
     * @param button5 The fifth button.
     */
    private void btnColorChangeSidebar(JButton button1, JButton button2, JButton button3, JButton button4, JButton button5) {
        button1.setForeground(resources.ultravioletBlue);
        button2.setForeground(resources.white);
        button3.setForeground(resources.white);
        button4.setForeground(resources.white);
        button5.setForeground(resources.white);
    }

    /**
     * Creates a JLabel with the specified text and color.
     * @param text  The text to be displayed on the label.
     * @param color The color of the label text.
     * @return The created JLabel.
     */
    private JLabel createLabel(String text, Color color) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setForeground(color);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        return label;
    }

    /**
     * Creates a JTextArea with specific formatting and properties.
     * @return The created JTextArea.
     */
    private JTextArea createTextAreaOutput() {
        JTextArea textArea = new JTextArea();
        textArea.setMargin(new Insets(10,10,10,10));
        textArea.setColumns(50);
        textArea.setRows(12);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        return textArea;
    }
} // end of GraphGUI class
