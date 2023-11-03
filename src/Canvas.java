import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JPanel
{
    private Graphics2D g2d;
    private Point[] points = new Point[]{};

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(int i = 0; i < points.length; i++)
        {
            Point current = points[i];
            g2d.setColor(current.highlight ? Color.red : Color.black);
            g2d.fillOval(Math.round(current.x), Math.round(current.y), 8, 8);
        }

        repaint();
    }

    public void setPoints(Point[] points)
    {
        this.points = points;
    }
}
