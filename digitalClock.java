import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class digitalClock extends JFrame{

    private JLabel timeLabel;
    private JLabel dataLabel;

    public digitalClock(){
        setTitle("Numeric clock");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        panel.setLayout(new BorderLayout());

        // label to display the time
        timeLabel= new JLabel();
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setVerticalAlignment(SwingConstants.CENTER);
        timeLabel.setForeground(Color.ORANGE);
        timeLabel.setFont(new Font("Magneto", Font.PLAIN, 60));

        dataLabel = new JLabel();
        dataLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dataLabel.setVerticalAlignment(SwingConstants.CENTER);
        dataLabel.setForeground(Color.ORANGE);
        dataLabel.setFont(new Font("Magneto", Font.PLAIN, 60));

        panel.add(timeLabel, BorderLayout.CENTER);
        panel.add(dataLabel, BorderLayout.SOUTH);

        panel.setBackground(new Color(51, 53, 57));
        add(panel);

        Timer timer = new Timer(1000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateDateandTime();
            }
        });
        timer.start();
    }

    private void updateDateandTime(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String time = timeFormat.format(calendar.getTime());

        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE : MM/dd/yyyy");
        String date = dateFormatter.format(calendar.getTime());

        timeLabel.setText(time);
        dataLabel.setText(date);
    }
    public static void main(String[] args) {
        digitalClock dclock = new digitalClock();
        dclock.setVisible(true);


    }
    
}
