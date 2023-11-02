package Project2.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;


public class HuffmanCodeGUI extends JFrame {

    private final Resources resources = new Resources();
    private JPanel contentArea;
    private JButton codeButton;
    private JButton tableButton;
    private JButton treeButton;

    public HuffmanCodeGUI() {
        super("Huffman Code Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setResizable(true);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(resources.sage);

        JPanel headerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("Huffman Code Application");
        titleLabel.setFont(new Font("Montserrat", Font.BOLD, 15));
        titleLabel.setForeground(resources.white);
        headerPanel.setBackground(resources.hunterGreen);
        headerPanel.add(titleLabel);

        JPanel sidebar = populateSidebar();
        mainPanel.add(sidebar, BorderLayout.WEST);

        contentArea = new JPanel();
        contentArea.setBackground(Color.WHITE);
        mainPanel.add(contentArea, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(resources.hunterGreen);
        JLabel copyrightLabel = new JLabel("© RAMONSTERS 2023");
        copyrightLabel.setFont(new Font("Arial", Font.BOLD, 12));
        copyrightLabel.setForeground(resources.white);
        footerPanel.add(copyrightLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(footerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private JPanel populateSidebar() {
        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BorderLayout());
        sidebarPanel.setPreferredSize(new Dimension(250, 600));
        sidebarPanel.setBackground(resources.fernGreen);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridBagLayout());
        optionPanel.setPreferredSize(new Dimension(200, 550));
        optionPanel.setBackground(resources.fernGreen);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 0, 0, 0);

        codeButton = createSidebarButton("Code", "icons/code-icon-black.png");
        tableButton = createSidebarButton("Table", "icons/table-icon-black.png");
        treeButton = createSidebarButton("Tree", "icons/tree-icon-black.png");

        // Add action listeners for the buttons
        codeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                populateCodePanel();
            }
        });

        tableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code for the "Table" button here
                setButtonFormat(tableButton, new JButton[]{codeButton, treeButton});
            }
        });

        treeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add code for the "Tree" button here
                setButtonFormat(treeButton, new JButton[]{codeButton, tableButton});
            }
        });

        gbc.gridy = 1;
        optionPanel.add(codeButton, gbc);

        gbc.gridy = 2;
        optionPanel.add(tableButton, gbc);

        gbc.gridy = 3;
        optionPanel.add(treeButton, gbc);

        sidebarPanel.add(optionPanel, BorderLayout.CENTER);
        return sidebarPanel;
    }

    private void populateCodePanel() {

        JPanel codePanel = new JPanel();
        codePanel.setBackground(resources.timberwolf);
        codePanel.setLayout(new BorderLayout());
        codePanel.setPreferredSize(new Dimension(700, 600));
        contentArea.removeAll();
        contentArea.add(codePanel, BorderLayout.EAST);
        contentArea.revalidate();
        contentArea.repaint();

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(resources.fernGreen);
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setPreferredSize(new Dimension(600, 150));
        codePanel.add(inputPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("HUFFMAN CODE");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(resources.white);
        titleLabel.setBackground(resources.fernGreen);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(10, 0, 10, 0);

        inputPanel.add(titleLabel, gbc);

        JTextField phraseTextField = new JTextField();
        phraseTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        phraseTextField.setText("Enter a phrase...");
        phraseTextField.setColumns(40);

        phraseTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                phraseTextField.setText(""); // Clear the label when the text field gains focus
            }
        });

        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.0;

        inputPanel.add(phraseTextField, gbc);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setBackground(resources.fernGreen);
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        inputPanel.add(buttonsPanel, gbc);

        JButton showCodeButton = new JButton("SHOW CODE");
        showCodeButton.setFont(new Font("Arial", Font.BOLD, 16));
        showCodeButton.setForeground(resources.white);
        showCodeButton.setBackground(resources.sage);

        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(resources.white);
        clearButton.setBackground(resources.sage);

        buttonsPanel.add(showCodeButton);
        buttonsPanel.add(clearButton);

        JPanel outputPanel = new JPanel();
        outputPanel.setBackground(Color.WHITE);
        outputPanel.setPreferredSize(new Dimension(600, 450));
        codePanel.add(outputPanel, BorderLayout.SOUTH);

        showCodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle show code button here
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                phraseTextField.setText("Enter a phrase...");
            }
        });

        setButtonFormat(codeButton, new JButton[]{tableButton, treeButton});
    }


    private JButton createSidebarButton(String text, String iconPath) {
        JButton button = new JButton();
        button.setText(text);
        ImageIcon icon = new ImageIcon(iconPath);
        button.setIcon(icon);
        button.setForeground(Color.WHITE);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBorderPainted(false);
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setFocusPainted(false);
        return button;
    }

    private void setButtonFormat(JButton selectedButton, JButton[] allButtons) {
        for (JButton button : allButtons) {
            if (button == selectedButton) {
                button.setForeground(resources.eggshellWhite);
            } else {
                button.setForeground(resources.sage);
            }
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HuffmanCodeGUI();
        });
    }
}
