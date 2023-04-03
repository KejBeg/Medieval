package medieval;

public class Helpers{
    /**
     * Prints out a beautiful style message.
     * If message is larger than the inner ammountOfLines, then ammountOfLines equals message+1
     * @param message String type message
     */
    public static void announce(String message){

        int amountOfLines = 40;
        if (message.length()>=amountOfLines){
            amountOfLines=message.length()+1;
        }

        System.out.println();
        for (int i = 0; i<=amountOfLines; i++){
            System.out.print("-");
        }

        System.out.println();

        System.out.print("|");
        for (int i = 0; i<=amountOfLines-2; i++){
            System.out.print(" ");
        }
        System.out.print("|");

        System.out.println();

        System.out.print("|");

        for (int i = 0; i<amountOfLines/2-message.length()/2-1; i++){
            System.out.print(" ");
        }
        System.out.print(message);
        for (int i = 0; i<amountOfLines/2-message.length()/2-1; i++){
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();

        System.out.print("|");
        for (int i = 0; i<=amountOfLines-2; i++){
            System.out.print(" ");
        }
        System.out.print("|");

        System.out.println();
        for (int i = 0; i<=amountOfLines; i++){
            System.out.print("-");
        }
    }
}