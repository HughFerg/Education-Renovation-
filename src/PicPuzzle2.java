/**
 * Created by hughferguson on 5/27/17.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

class PicPuzzle2 extends JFrame implements ActionListener{

    static HashMap<Integer, Icon> correctMap = new HashMap<>(); //hashmap for buttons and corresponding icons
    static HashMap<JButton, Icon> userMap = new HashMap<>(); //hashmap for user's screen

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,sample;

    static int gameCt = 0;  //counts to see how many correct images user has placed - if 9, user wins

    Icon samicon1=new ImageIcon("images/Wiki Picture.jpeg");

    Icon ic1=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-0-0.jpeg");
    Icon ic2=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-0-1.jpeg");
    Icon ic3=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-0-2.jpeg");
    Icon ic4=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-1-0.jpeg");
    Icon ic5=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-1-1.jpeg");
    Icon ic6=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-1-2.jpeg");
    Icon ic7=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-2-0.jpeg");
    Icon ic8=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-2-1.jpeg");
    Icon ic9=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-2-2.jpeg");

    static JLabel countdown = new JLabel();

    private Icon[] iconList = {ic1,ic2,ic3,ic4,ic5,ic6,ic7,ic8,ic9};        //creating array of icons to be randomized

    private ArrayList<Integer> intsToBeRandomized = new ArrayList<>();      //list of the order in which icons will be displayed

    boolean firstClick = true;       //value of true if no previous clicks, false if second click(swapping 2 images)

    private static ArrayList<JButton> buttonList = new ArrayList<>();      //list of all buttons in order

    Icon tempIcon = new ImageIcon();        //temp Icon to be swapped

    String tempButton = "";         //temp String to hold which button has been clicked

    static String timeLeft = "";           //string to represent number of seconds left

    static JFrame win = new JFrame("Good Win!"); //widow that appears when user wins game

    static JFrame lose = new JFrame("Nice try!"); //widow that appears when user loses game


    PicPuzzle2(){

        super("Pic Puzzle");

        for (int a = 0; a < 9; a ++){           //puts ints in order in array "intsToBeRandomized"
            intsToBeRandomized.add(a);
        }

        correctMap.put(1,ic1);                    //instantiating hashmap with Buttons and corresponding Icons
        correctMap.put(2,ic2);
        correctMap.put(3,ic3);
        correctMap.put(4,ic4);
        correctMap.put(5,ic5);
        correctMap.put(6,ic6);
        correctMap.put(7,ic7);
        correctMap.put(8,ic8);
        correctMap.put(9,ic9);


        b1=new JButton();
        b1.setBounds(10,80,100,100);

        b2=new JButton();
        b2.setBounds(110,80,100,100);

        b3=new JButton();
        b3.setBounds(210,80,100,100);

        b4=new JButton();
        b4.setBounds(10,180,100,100);

        b5=new JButton();
        b5.setBounds(110,180,100,100);

        b6=new JButton();
        b6.setBounds(210,180,100,100);

        b7=new JButton();
        b7.setBounds(10,280,100,100);

        b8=new JButton();
        b8.setBounds(110,280,100,100);

        b9=new JButton();
        b9.setBounds(210,280,100,100);

        sample=new JButton(samicon1);
        sample.setBounds(380,100,200,200);

//----------------------TIMER ATTRIBUTES----------------------\\

        countdown.setSize(100, 50);
        countdown.setLocation(380, 30);
        countdown.setText(String.valueOf(timeLeft));
        add(countdown);
        countdown.setVisible(true);
        countdown.setBackground(Color.black);

        Collections.shuffle(intsToBeRandomized);  //shuffles ints to determine order of icons

//---------------------SETTING BUTTON ICONS AND HASHMAP-------------\\

        b1.setIcon(iconList[intsToBeRandomized.get(0)]);
        userMap.put(b1, iconList[intsToBeRandomized.get(0)]);
        //intsToBeRandomized.remove(0);

        b2.setIcon(iconList[intsToBeRandomized.get(1)]);
        userMap.put(b2, iconList[intsToBeRandomized.get(1)]);
        //intsToBeRandomized.remove(0);

        b3.setIcon(iconList[intsToBeRandomized.get(2)]);
        userMap.put(b3, iconList[intsToBeRandomized.get(2)]);
        //intsToBeRandomized.remove(0);

        b4.setIcon(iconList[intsToBeRandomized.get(3)]);
        userMap.put(b4, iconList[intsToBeRandomized.get(3)]);
        //intsToBeRandomized.remove(0);

        b5.setIcon(iconList[intsToBeRandomized.get(4)]);
        userMap.put(b5, iconList[intsToBeRandomized.get(4)]);
        //intsToBeRandomized.remove(0);

        b6.setIcon(iconList[intsToBeRandomized.get(5)]);
        userMap.put(b6, iconList[intsToBeRandomized.get(5)]);
        //intsToBeRandomized.remove(0);

        b7.setIcon(iconList[intsToBeRandomized.get(6)]);
        userMap.put(b7, iconList[intsToBeRandomized.get(6)]);
        //intsToBeRandomized.remove(0);

        b8.setIcon(iconList[intsToBeRandomized.get(7)]);
        userMap.put(b8, iconList[intsToBeRandomized.get(7)]);
        //intsToBeRandomized.remove(0);

        b9.setIcon(iconList[intsToBeRandomized.get(8)]);
        userMap.put(b9, iconList[intsToBeRandomized.get(8)]);
        //intsToBeRandomized.remove(0);

        buttonList.add(b1);buttonList.add(b2);buttonList.add(b3);buttonList.add(b4);buttonList.add(b5);buttonList.add(b6);buttonList.add(b7);buttonList.add(b8);
        buttonList.add(b9);      //adds all buttons to list of buttons


        JLabel l1=new JLabel("Original: ");			//creates label for original picture
        l1.setBounds(330,200,70,20);

        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);
        add(b9);add(sample);add(l1);


        b1.addActionListener(this); b1.setActionCommand("0");
        b2.addActionListener(this); b2.setActionCommand("1");
        b3.addActionListener(this); b3.setActionCommand("2");
        b4.addActionListener(this); b4.setActionCommand("3");
        b5.addActionListener(this); b5.setActionCommand("4");
        b6.addActionListener(this); b6.setActionCommand("5");
        b7.addActionListener(this); b7.setActionCommand("6");
        b8.addActionListener(this); b8.setActionCommand("7");
        b9.addActionListener(this); b9.setActionCommand("8");

        sample.addActionListener(this);
        setLayout(null);
        setSize(600,500);
        setVisible(true);

        Dimension dem = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((((int) dem.getWidth())/2 - 300), (((int) dem.getHeight())/2 - 250));       //sets frame location to middle of screen

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //------------------------WINDOW THAT APPEARS WHEN USER WINS GAME----------------------\\

        win.setVisible(true);
        win.setSize(300,300);
        win.setLocation((((int) dem.getWidth())/2 - 150), (((int) dem.getHeight())/2 - 150));        //sets size and orientation of victory JFrame
        win.setBackground(Color.GREEN);

        JLabel winText = new JLabel("WOOOOO");
        winText.setBackground(Color.GREEN);
        winText.setSize(150,150);
        win.add(winText);
        winText.setHorizontalAlignment(SwingConstants.CENTER);


        win.toFront();
        win.setAlwaysOnTop(true);

        //------------------------WINDOW THAT APPEARS WHEN USER LOSES GAME----------------------\\

        lose.setVisible(true);
        lose.setSize(300,300);
        lose.setLocation((((int) dem.getWidth())/2 - 150), (((int) dem.getHeight())/2 - 150));        //sets size and orientation of victory JFrame

        JLabel loseText = new JLabel("Sorry! You didn't finish in time.");
        loseText.setBackground(Color.red);
        winText.setSize(150,150);
        lose.add(loseText);
        loseText.setHorizontalAlignment(SwingConstants.CENTER);


        lose.toFront();
        lose.setAlwaysOnTop(true);

    }

//-------------------------GAME OPERATIONS------------------------\\

    public void actionPerformed(ActionEvent e){

        if (firstClick){

            tempButton = e.getActionCommand();          //sets tempButton to string representation of button clicked

            tempIcon = buttonList.get(Integer.valueOf(e.getActionCommand())).getIcon();         //sets tempIcon as icon of clicked button

            firstClick = false;

        }
        else {               //on second click- has to swap the 2 images

            buttonList.get(Integer.valueOf(tempButton)).setIcon(buttonList.get(Integer.valueOf(e.getActionCommand())).getIcon());        //changes first button's icon into second button's icon

            buttonList.get(Integer.valueOf(e.getActionCommand())).setIcon(tempIcon);            //changes second button's icon into temp icon (first button's icon)

            userMap.replace(buttonList.get(Integer.valueOf(e.getActionCommand())), buttonList.get(Integer.valueOf(e.getActionCommand())).getIcon());        //updates user hashmap with swapped icon

            userMap.replace(buttonList.get(Integer.valueOf(tempButton)), buttonList.get(Integer.valueOf(tempButton)).getIcon());          //updates user hashmap with original image

            firstClick = true;  //resets click

        }

    }//end of actionPerformed

    public static boolean gameWon(ArrayList<JButton> b){            //if user has finished puzzle correctly

        gameCt = 0;


        if ((userMap.get(b.get(0)).toString()).equals(correctMap.get(1).toString()) && //checks each icon to see if correct - messy but it works (doesn't work as of now)

        (userMap.get(b.get(1)).toString()).equals(correctMap.get(2).toString()) &&

        (userMap.get(b.get(2)).toString()).equals(correctMap.get(3).toString())) gameCt++;


        if ((userMap.get(b.get(3)).toString()).equals(correctMap.get(4).toString()) &&

        (userMap.get(b.get(4)).toString()).equals(correctMap.get(5).toString()) &&

        (userMap.get(b.get(5)).toString()).equals(correctMap.get(6).toString())) gameCt ++;



        if ((userMap.get(b.get(6)).toString()).equals(correctMap.get(7).toString()) &&

        (userMap.get(b.get(7)).toString()).equals(correctMap.get(8).toString()) &&

        (userMap.get(b.get(8)).toString()).equals(correctMap.get(9).toString())) gameCt ++;


        if (gameCt == 3) return true;

        else return false;

    }

    public static void main(String args[]){

        final long START_TIME = System.currentTimeMillis();

        new PicPuzzle2();

        win.setVisible(false);
        lose.setVisible(false);

//----------------------TIMER FUNCTIONALITY---------------------\\

        while (System.currentTimeMillis() - START_TIME < 20000) {

            if (gameWon(buttonList)) win.setVisible(true);

            timeLeft = (Integer.toString((int) (System.currentTimeMillis() - START_TIME) / 1000));

        }

        if ((!win.isVisible())) lose.setVisible(true);

    }//end of main

}//end of class
