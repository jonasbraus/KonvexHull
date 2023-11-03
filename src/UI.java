import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI
{
    private JFrame frame;
    private Canvas canvas;

    public UI(Main main)
    {
        frame = new JFrame("Konvexe Hülle");
        frame.getContentPane().setPreferredSize(new Dimension(500, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        canvas = new Canvas();
        canvas.setBounds(50, 50, 400, 400);

        frame.add(canvas);

        JButton button = new JButton("Neu");
        button.setBounds(0, 500, 500, 100);
        button.setBackground(Color.gray);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                main.newRandomHull();
            }
        });

        frame.add(button);
        frame.setVisible(true);
    }

    public void setPoints(Point[] points)
    {
        canvas.setPoints(points);
    }
}
