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

public class GraphVisualization extends JPanel {
    private final Resources resources = new Resources();
    private GraphUtility graphUtility;
    private Point clickPoint;
    private Point offset = new Point(0, 0);
    private JSlider zoomSlider;
    private double zoomLevel = 1.0;

    public GraphVisualization(GraphUtility graphUtility) {
        this.graphUtility = graphUtility;

        clickPoint = null;
        zoomSlider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);

        zoomSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                zoomLevel = zoomSlider.getValue() / 100.0;
                repaint();
            }
        });

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

        setLayout(new BorderLayout());
        add(zoomSlider, BorderLayout.SOUTH);
    }

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

    private void scroll(int dx, int dy) {
        offset.x = Math.max(Math.min(offset.x + dx, getWidth()), 0);
        offset.y = Math.max(Math.min(offset.y + dy, getHeight()), 0);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraph(g, graphUtility.getGraph());
    }
}
