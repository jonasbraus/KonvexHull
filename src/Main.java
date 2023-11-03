
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        new Main();
    }

    private UI ui;
    private Point[] points;

    public Main()
    {
        ui = new UI(this);
    }

    public void newRandomHull()
    {
        points = Point.getRandomPoints(100);
        ui.setPoints(points);
        quickSort(0, points.length - 1);
        calculateHull();
    }

    public void calculateHull()
    {
        List<Point> hull = new ArrayList<>();

        for (Point p : points)
        {
            while (hull.size() >= 2 && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0)
            {
                hull.remove(hull.size() - 1);
            }
            hull.add(p);
        }

        int t = hull.size() + 1;
        for (int i = points.length - 2; i >= 0; i--)
        {
            Point p = points[i];
            while (hull.size() >= t && orientation(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0)
            {
                hull.remove(hull.size() - 1);
            }
            hull.add(p);
        }


        hull.remove(hull.size() - 1);



        for (Point p : hull)
        {
            p.highlight = true;
        }
    }

    private float orientation(Point p, Point q, Point r)
    {
        return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
    }

    public void quickSort(int low, int high)
    {
        if (low < high)
        {
            int pivot = partition(low, high);
            quickSort(low, pivot - 1);
            quickSort(pivot + 1, high);
        }
    }

    private int partition(int low, int high)
    {
        float pivot = points[high].x;
        int i = low - 1;
        for (int j = low; j < high; j++)
        {
            if (points[j].x < pivot)
            {
                i++;
                Point temp = points[i];
                points[i] = points[j];
                points[j] = temp;
            }
        }
        Point temp = points[i + 1];
        points[i + 1] = points[high];
        points[high] = temp;
        return i + 1;
    }
}
