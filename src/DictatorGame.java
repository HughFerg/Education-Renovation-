/**
 * Created by hughferguson on 6/4/17.
 */
import javax.swing.JOptionPane;

public class DictatorGame

{

    public static void main (String[] args)

    {

        JOptionPane.showMessageDialog( null," DICTATOR SAYS GAME");

        String name = JOptionPane.showInputDialog(null,"Type in your name");

        String name1 = JOptionPane.showInputDialog(name, "Are you Ready ?");

        String name2= JOptionPane.showInputDialog(name1, "Are you sure?");


        if(!name2.equals("yes") && name1.equals("yes"))

        {

            JOptionPane.showMessageDialog(null,"Whatever, Good Bye!");

            return;

        }

        else{

            JOptionPane.showMessageDialog(null, "Let's see what you've got" );

            DictatorGame gamer = new DictatorGame();

            gamer.go();

        }

    }

    public void go()

    {

        String[] dictators = { "Ingrid ", "Victor ", "Randy ", "Steven ", "John ", "Dora ", "Allen ", "Elaine "};

        String[] feedback ={"GOOD JOB","BRAVO ","WELL DONE","YOU GOT IT!","YOU'RE GOOD","OK, THAT WAS EASY",

                "BETTER BE CAREFUL,YOU'RE GETTING SLOWER!!!","YOU'RE SLOW",

                "YOU ALMOST RAN OUT OF TIME","YOU'RE GOOD!!!","I BET YOU WON'T GET THIS NEXT ONE"};

        String[] feedback1 = { "YOU'RE NOT BAD!!" , "YOU'RE GOOD" , "THAT WAS OBVIOUS" , "NEXT ONE WON'T BE AS EASY",

                "CHECK THIS COMING ONE","YOU'RE MY FAVORITE PLAYER"};

        String[] words = { "aardvark", "addax", "alderaan", "alligator", "alpaca", "anteater", "antelope", "aoudad", "ape",
                "argali", "armadillo", "baboon", "badger", "basilisk", "bat", "bear", "beaver", "bespin", "bighorn", "bird",
                "bison", "black hole", "boar", "budgerigar", "buffalo", "bull", "bunny", "burro", "buzzard", "camel", "canary",
                "capybara", "cat", "chameleon", "chamois", "cheetah", "chimpanzee", "chinchilla", "chipmunk", "civet", "coati",
                "colt", "cony", "coruscant", "cougar", "cow", "coyote", "crocodile", "crow", "dagobah", "darth vader", "death star",
                "deer", "dingo", "doe", "dog", "dolphin", "donkey", "dormouse", "dromedary", "duckbill", "dugong", "eland", "elephant",
                "elk", "endor", "ermine", "ewe", "fawn", "ferret", "finch", "fish", "fox", "frog", "gazelle", "gemsbok", "geonosis",
                "gila monster", "giraffe", "gnu", "goat", "gopher", "gorilla", "grizzly bear", "ground hog", "guanaco", "guinea pig",
                "hamster", "hare", "hartebeest", "hedgehog", "hippopotamus", "hog", "horse", "hoth", "hyena", "ibex", "iguana", "impala",
                "jackal", "jaguar", "jerboa", "jupiter", "kamino", "kangaroo", "kashyyyk", "kid", "kinkajou", "kitten", "koala", "koodoo",
                "lamb", "lemur", "leopard", "lightsaber", "lion", "lizard", "llama", "lovebird", "lynx", "manatee", "mandrill", "mare",
                "marmoset", "mars", "marten", "mercury", "mink", "mole", "mongoose", "monkey", "moose", "mosquito", "mountain goat", "mouse",
                "mule", "musk deer", "musk-ox", "muskrat", "mustafar", "mustang", "mynah bird", "naboo", "nebula", "neptune", "neutron star",
                "newt", "ocelot", "okapi", "opossum", "orangutan", "oryx", "otter", "ox", "panda", "panther", "parakeet", "parrot", "peccary",
                "penguin", "pig", "platypus", "polar bear", "pony", "porcupine", "porpoise", "prairie dog", "pronghorn", "pulsar", "puma", "puppy",
                "quagga", "quasar", "rabbit", "raccoon", "ram", "rat", "reindeer", "reptile", "rhinoceros", "roebuck", "salamander", "seal", "sheep",
                "shrew", "silver fox", "skunk", "sloth", "snake", "springbok", "squirrel", "stallion", "star trek", "steer", "tapir", "tatooine",
                "tiberius", "tiger", "toad", "turtle", "uranus", "venus", "vicuna", "voyager", "walrus", "warthog", "waterbuck", "weasel", "whale",
                "white dwarf", "wildcat", "wolf", "wolverine", "wombat", "woodchuck", "yak", "yavin", "zebra", "zebu" };



        int d = (int)(Math.random()*dictators.length);

        JOptionPane.showMessageDialog(null,dictators[d]+ " is today's dictator" );

        int x;

        int score = 0;

        for(x=0;x< 200; x++)

        {

            int a = (int)(Math.random()* words.length);

            int b = (int)(Math.random()*feedback.length);

            int c = (int)(Math.random()*feedback1.length);

            int e = (int)(Math.random()*dictators.length);

            String X = JOptionPane.showInputDialog(null,dictators[e]+"says type " + words[a]);

            if(dictators[d].equals(dictators[e]))

            {

                if(X.equals(words[a]))

                {

                    JOptionPane.showMessageDialog(null,feedback[b]);

                    score++;

                }

                if(!X.equals(words[a]))

                {

                    JOptionPane.showMessageDialog(null,"You LOST !!" );

                    JOptionPane.showMessageDialog(null,"Your Score is " +score);

                    String p = JOptionPane.showInputDialog(null,"Press Enter to Play again or Q to quit");

                    if(p.equals(""))

                    {

                        JOptionPane.showMessageDialog(null,"Better be ready!!!");

                        go();

                    }

                    else

                    {

                        JOptionPane.showMessageDialog(
                                null,"Good Bye!");

                        break;

                    }

                }

            }

            if (!dictators[d].equals(dictators[e]))

            {

                if(X.equals(words[a]))

                {

                    JOptionPane.showMessageDialog(null," you LOST !!! GAME OVER" );

                    JOptionPane.showMessageDialog(null,"your score is " +score);

                    String P = JOptionPane.showInputDialog(null,"Press Enter to play again or Q to quit");

                    if(P.equals(""))

                    {

                        JOptionPane.showMessageDialog(null,"Better be ready!!!");

                        go();

                    }

                    else

                    {

                        JOptionPane.showMessageDialog(null,"Good Bye!");

                        break;

                    }

                    return;

                }

                if (X.equals(""))

                {

                    JOptionPane.showMessageDialog(null,feedback1[c]);

                    score++;

                }

                else{

                    JOptionPane.showMessageDialog(null,"you LOST !!! GAME OVER" );

                    JOptionPane.showMessageDialog(null,"your score is " +score);

                    String O = JOptionPane.showInputDialog(null,"Press Enter to play again or Q to quit");

                    if(O.equals(""))

                    {

                        JOptionPane.showMessageDialog(
                                null,"Better be ready!!!");

                        go();

                    }

                    else

                    {

                        JOptionPane.showMessageDialog(
                                null,"Good Bye!");

                        break;

                    }

                }

            }

        }}}