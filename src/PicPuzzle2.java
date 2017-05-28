/**
 * Created by hughferguson on 5/27/17.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class PicPuzzle2 extends JFrame implements ActionListener{

    HashMap<JButton, Icon> map = new HashMap<>(); //hashmap for buttons and corresponding icons

    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,sample;

    Icon samicon1=new ImageIcon("images/Wiki Picture.jpeg");
    Icon samicon2=new ImageIcon("pic/main2.jpg");
    Icon samicon3=new ImageIcon("pic/main3.jpg");


    Icon ic1=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-0-0.jpeg");
    Icon ic2=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-0-1.jpeg");
    Icon ic3=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-0-2.jpeg");
    Icon ic4=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-1-0.jpeg");
    Icon ic5=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-1-1.jpeg");
    Icon ic6=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-1-2.jpeg");
    Icon ic7=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-2-0.jpeg");
    Icon ic8=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-2-1.jpeg");
    Icon ic9=new ImageIcon("images/Wiki Picture [www.imagesplitter.net]-2-2.jpeg");

   private Icon[] iconList = {ic1,ic2,ic3,ic4,ic5,ic6,ic7,ic8,ic9};        //creating array of icons to be randomized

    private ArrayList<Integer> intsToBeRandomized = new ArrayList<>();      //list of all ints 0-8 to be shuffled

    private int[] startPos = new int[8];        //the order in which images will be displayed at game start

    boolean firstClick = true;       //value of true if no previous clicks, false if second click(swapping 2 images)

    private ArrayList<JButton> buttonList = new ArrayList<>();      //list of all buttons in order

    Icon tempIcon = new ImageIcon();        //temp Icon to be swapped

    String tempButton = "";         //temp String to hold which button has been clicked

    PicPuzzle2(){

        super("Pic Puzzle");

        for (int a = 0; a < 9; a ++){
            intsToBeRandomized.add(a);
        }

        Collections.shuffle(intsToBeRandomized);            //creates random order of pictures to be assigned to buttons

        b1=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b1.setBounds(10,80,100,100);
        b1.putClientProperty("Position", new Point(0,0));

        b2=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b2.setBounds(110,80,100,100);

        b3=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b3.setBounds(210,80,100,100);

        b4=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b4.setBounds(10,180,100,100);

        b5=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b5.setBounds(110,180,100,100);

        b6=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b6.setBounds(210,180,100,100);

        b7=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b7.setBounds(10,280,100,100);

        b8=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b8.setBounds(110,280,100,100);

        b9=new JButton(iconList[intsToBeRandomized.get(0)]);        //assigns first number picture to first button then removes it to avoid repeats
        intsToBeRandomized.remove(0);
        b9.setBounds(210,280,100,100);

        sample=new JButton(samicon1);
        sample.setBounds(380,100,200,200);

        map.put(b1,ic1);                    //instantiating hashmap with Buttons and corresponding Icons
        map.put(b2,ic2);
        map.put(b3,ic3);
        map.put(b4,ic4);
        map.put(b5,ic5);
        map.put(b6,ic6);
        map.put(b7,ic7);
        map.put(b8,ic8);
        map.put(b9,ic9);


        JLabel l1=new JLabel("Original: ");			//creates label for original picture
        l1.setBounds(330,200,70,20);

        JLabel l3=new JLabel("Click for next picture");		//creates label under original picture
        l3.setBounds(380,320,200,20);
        l3.setForeground(Color.red);

        add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);
        add(b9);add(sample);add(l1);add(l3);

        buttonList.add(b1);buttonList.add(b2);buttonList.add(b3);buttonList.add(b4);buttonList.add(b5);buttonList.add(b6);buttonList.add(b7);buttonList.add(b8);
        buttonList.add(b9);      //adds all buttons to list of buttons


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

    }

//-------------------------GAME OPERATIONS------------------------\\


    public void actionPerformed(ActionEvent e){
        if (firstClick){

            tempButton = e.getActionCommand();          //sets tempButton to string representation of button clicked

            tempIcon = buttonList.get(Integer.valueOf(e.getActionCommand())).getIcon();         //sets tempIcon as icon of clicked button

            firstClick = false;

        }
        else{               //on second click- has to swap the 2 images

            buttonList.get(Integer.valueOf(tempButton)).setIcon(buttonList.get(Integer.valueOf(e.getActionCommand())).getIcon());        //changes first button's icon into second button's icon

            buttonList.get(Integer.valueOf(e.getActionCommand())).setIcon(tempIcon);            //changes second button's icon into temp icon (first button's icon)

            firstClick = true;
        }

    }//end of actionPerformed

    public boolean gameWon(HashMap a){
return true;
    }

    public static void main(String args[]){
        new PicPuzzle2();
    }//end of main
}//end of class
