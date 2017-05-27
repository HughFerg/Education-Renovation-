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

    private ArrayList<Integer> intsToBeRandomized = new ArrayList<>();

    private int[] startPos = new int[8];        //the order in which images will be displayed

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


        b1.addActionListener(this); b2.addActionListener(this);
        b3.addActionListener(this); b4.addActionListener(this);
        b5.addActionListener(this); b6.addActionListener(this);
        b7.addActionListener(this); b8.addActionListener(this);
        b9.addActionListener(this);

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

        /*

        if(e.getSource()==b1){
            Icon s1=b1.getIcon();
            if(b2.getIcon()==star){
                b2.setIcon(s1);
                b1.setIcon(star);
            } else if(b4.getIcon()==star){
                b4.setIcon(s1);
                b1.setIcon(star);
            }
        }//end of if

        if(e.getSource()==b2){
            Icon s1=b2.getIcon();
            if(b1.getIcon()==star){
                b1.setIcon(s1);
                b2.setIcon(star);
            } else if(b5.getIcon()==star){
                b5.setIcon(s1);
                b2.setIcon(star);
            }
            else if(b3.getIcon()==star){
                b3.setIcon(s1);
                b2.setIcon(star);
            }
        }//end of if

        if(e.getSource()==b3){
            Icon s1=b3.getIcon();
            if(b2.getIcon()==star){
                b2.setIcon(s1);
                b3.setIcon(star);
            } else if(b6.getIcon()==star){
                b6.setIcon(s1);
                b3.setIcon(star);
            }
        }//end of if

        if(e.getSource()==b4){
            Icon s1=b4.getIcon();
            if(b1.getIcon()==star){
                b1.setIcon(s1);
                b4.setIcon(star);
            } else if(b5.getIcon()==star){
                b5.setIcon(s1);
                b4.setIcon(star);
            }
            else if(b7.getIcon()==star){
                b7.setIcon(s1);
                b4.setIcon(star);
            }
        }//end of if

        if(e.getSource()==b5){
            Icon s1=b5.getIcon();
            if(b2.getIcon()==star){
                b2.setIcon(s1);
                b5.setIcon(star);
            } else if(b4.getIcon()==star){
                b4.setIcon(s1);
                b5.setIcon(star);
            }
            else if(b6.getIcon()==star){
                b6.setIcon(s1);
                b5.setIcon(star);
            }
            else if(b8.getIcon()==star){
                b8.setIcon(s1);
                b5.setIcon(star);
            }
        }//end of if

        if(e.getSource()==b6){
            Icon s1=b6.getIcon();
            if(b3.getIcon()==star){
                b3.setIcon(s1);
                b6.setIcon(star);
            } else if(b5.getIcon()==star){
                b5.setIcon(s1);
                b6.setIcon(star);
            }
            else if(b9.getIcon()==star){
                b9.setIcon(s1);
                b6.setIcon(star);
            }
        }//end of if

        if(e.getSource()==b7){
            Icon s1=b7.getIcon();
            if(b4.getIcon()==star){
                b4.setIcon(s1);
                b7.setIcon(star);
            } else if(b8.getIcon()==star){
                b8.setIcon(s1);
                b7.setIcon(star);
            }
        }//end of if

        if(e.getSource()==b8){
            Icon s1=b8.getIcon();
            if(b7.getIcon()==star){
                b7.setIcon(s1);
                b8.setIcon(star);
            } else if(b5.getIcon()==star){
                b5.setIcon(s1);
                b8.setIcon(star);
            }
            else if(b9.getIcon()==star){
                b9.setIcon(s1);
                b8.setIcon(star);
            }

        }//end of if

        if(e.getSource()==b9){
            Icon s1=b9.getIcon();
            if(b8.getIcon()==star){
                b8.setIcon(s1);
                b9.setIcon(star);
            } else if(b6.getIcon()==star){
                b6.setIcon(s1);
                b9.setIcon(star);
            }
        }//end of if

        if(e.getSource()==sample){
            Icon s1=sample.getIcon();
            if(s1==samicon3){
                sample.setIcon(samicon1);
                b1.setIcon(ic1);
                b2.setIcon(ic2);
                b3.setIcon(ic3);
                b4.setIcon(ic4);
                b5.setIcon(ic5);
                b6.setIcon(ic6);
                b7.setIcon(ic7);
                b8.setIcon(ic8);
                b9.setIcon(ic9);
                star=b9.getIcon();
                starB.setIcon(ic0);
            }//end of if
 /*
else if(s1==samicon1){
sample.setIcon(samicon2);

b1.setIcon(ic11);
b2.setIcon(ic12);
b3.setIcon(ic13);
b4.setIcon(ic14);
b5.setIcon(ic15);
b6.setIcon(ic16);
b7.setIcon(ic17);
b8.setIcon(ic18);
b9.setIcon(ic19);
star=b6.getIcon();
starB.setIcon(ic10);
}//if else

else{
sample.setIcon(samicon3);
b1.setIcon(ic21);
b2.setIcon(ic22);
b3.setIcon(ic23);
b4.setIcon(ic24);
b5.setIcon(ic25);
b6.setIcon(ic26);
b7.setIcon(ic27);
b8.setIcon(ic28);
b9.setIcon(ic29);
star=b6.getIcon();
starB.setIcon(ic20);
}//if else


        }
        */
    }//end of actionPerformed

    public boolean gameWon(HashMap a){
return true;
    }

    public static void main(String args[]){
        new PicPuzzle2();
    }//end of main
}//end of class
