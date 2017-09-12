import oracle.jvm.hotspot.jfr.JFR;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by hughferguson on 6/4/17.
 */
public class Education_Renovation extends JFrame implements ActionListener {

    static String name;

    static JTextPane nameText = new JTextPane();

    static int SimonScore = 0;
    static int DictatorScore = 0;
    static int PuzzleScore = 0;

    Education_Renovation() {

        super("Education Renovation");

        setSize(600, 600);

        Dimension dem = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) ((dem.getWidth() / 2) - 300), (int) ((dem.getHeight() / 2) - 300));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JLabel title = new JLabel("            Education Renovation");
        title.setFont(new Font("Serif", Font.PLAIN, 20));
        title.setVisible(true);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 1;
        c.gridy = 0;
        add(title, c);

        nameText.setText("Enter your name: ");
        nameText.setSize(100, 100);
        nameText.setLocation(250, 300);
        c.gridx = 1;
        c.gridy = 1;
        add(nameText, c);

        JButton play = new JButton("Click to play game 1!");
        play.addActionListener(this);
        play.setActionCommand("s");
        c.gridx = 2;
        c.gridy = 0;
        add(play, c);

        JButton play2 = new JButton("Click to play game 2!");
        play2.addActionListener(this);
        play2.setActionCommand("d");
        c.gridx = 2;
        c.gridy = 1;
        add(play2, c);


        JButton play3 = new JButton("Click to play game 3!");
        play3.addActionListener(this);
        play3.setActionCommand("p");
        c.gridx = 2;
        c.gridy = 2;
        add(play3, c);

        setVisible(true);
    }

    public static void main (String[] args){

        new Education_Renovation();

    }

    public void actionPerformed(ActionEvent e){

        if (e.getActionCommand().equals("s")){

            name = nameText.getText();

            Simon simon = new Simon();
        }

        if(e.getActionCommand().equals("d")){
            new DictatorGame();
            DictatorGame.start();
        }

        if (e.getActionCommand().equals("p")){
            PicPuzzle2 pic = new PicPuzzle2();
        }

    }
}




