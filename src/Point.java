import java.util.ArrayList;
import java.util.List;

public class Point
{
    public float x = 0;
    public float y = 0;
    public boolean highlight = false;

    public Point(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return x + " " + y;
    }

    public static Point[] getRandomPoints(int count)
    {
        List<Point> points = new ArrayList<>();

        for(int i = 0; i < count; i++)
        {
            float randX = (float)(Math.random() * 360 + 20);
            float randY = (float)(Math.random() * 360 + 20);
            points.add(new Point(randX, randY));
        }

        return points.toArray(new Point[0]);
    }
}
