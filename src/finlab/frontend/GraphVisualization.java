package finlab.frontend;

import finlab.backend.Edge;
import finlab.backend.Graph;
import finlab.backend.GraphUtility;
import finlab.backend.Vertex;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/**
 * The GraphVisualization class is an unused class that extends JPanel and is used for visualizing graphs.
 */
public class GraphVisualization extends JPanel {
    // Resources for color settings
    private final Resources resources = new Resources();
    // GraphUtility for handling graph-related operations
    private GraphUtility graphUtility;
    // Variables for handling mouse events and panning
    private Point clickPoint;
    private Point offset = new Point(0, 0);
    // Slider for zoom control
    private JSlider zoomSlider;
    // Zoom level for the graph visualization
    private double zoomLevel = 1.0;

    /**
     * Constructs a GraphVisualization object with the specified GraphUtility.
     *
     * @param graphUtility The GraphUtility to be visualized.
     */
    public GraphVisualization(GraphUtility graphUtility) {
        this.graphUtility = graphUtility;

        clickPoint = null;
        // Zoom slider setup
        zoomSlider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);

        zoomSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                zoomLevel = zoomSlider.getValue() / 100.0;
                repaint();
            }
        });

        // Mouse event listeners for panning
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                clickPoint = e.getPoint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                clickPoint = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (clickPoint != null) {
                    Point newPoint = e.getPoint();
                    int dx = newPoint.x - clickPoint.x;
                    int dy = newPoint.y - clickPoint.y;
                    // Adjust the current view's position based on the mouse drag
                    scroll(dx, dy);
                    clickPoint = newPoint;
                }
            }
        });

        // Set up layout and add zoom slider
        setLayout(new BorderLayout());
        add(zoomSlider, BorderLayout.SOUTH);
    }

    /**
     * Draws the graph on the specified Graphics object.
     *
     * @param g     The Graphics object on which to draw the graph.
     * @param graph The Graph object to be visualized.
     */
    void drawGraph(Graphics g, Graph graph) {
        List<Vertex> vertices = graph.getNodes();
        List<Edge> edges = graph.getEdges();

        int baseY = getHeight() / 2;

        for (Vertex vertex : vertices) {
            int x = vertices.indexOf(vertex) * 50 + 50;
            int y = (int) (baseY * zoomLevel);

            g.setColor(resources.ultravioletBlue);
            g.fillOval(x - 10 + offset.x, y - 10 + offset.y, 20, 20);

            g.setColor(resources.richBlack);
            g.drawString(vertex.getLabel(), x - 5 + offset.x, y + 5 + offset.y);
        }

        for (Edge edge : edges) {
            Vertex start = edge.getStart();
            Vertex end = edge.getEnd();

            int startX = vertices.indexOf(start) * 50 + 50 + offset.x;
            int startY = (int) (baseY * zoomLevel) + offset.y;
            int endX = vertices.indexOf(end) * 50 + 50 + offset.x;
            int endY = (int) (baseY * zoomLevel) + offset.y;

            // Draw edge line
            g.setColor(resources.richBlack);
            g.drawLine(startX, startY, endX, endY);

            // Draw edge weight
            g.setColor(resources.lipstickRed);
            g.drawString(String.valueOf(edge.getWeight()), (startX + endX) / 2, (startY + endY) / 2);
        }
    }

    /**
     * Handles the scrolling of the graph view based on the specified deltas.
     *
     * @param dx The change in the x-coordinate.
     * @param dy The change in the y-coordinate.
     */
    private void scroll(int dx, int dy) {
        offset.x = Math.max(Math.min(offset.x + dx, getWidth()), 0);
        offset.y = Math.max(Math.min(offset.y + dy, getHeight()), 0);
        repaint();
    }

    /**
     * Overrides the paintComponent method to draw the graph on the panel.
     *
     * @param g The Graphics object on which to paint the component.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraph(g, graphUtility.getGraph());
    }
} // End of GraphVisualization class
