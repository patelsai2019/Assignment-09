import java.util.Scanner;

public class Main {

    public static Scanner scan;
    public static int movesLeft = 30;
    public static String output = "You find yourself in a large foyer. There is a door to the north. To the west is a bench against the wall. To the east is a chest on the floor. In the center of the room is a large candle. The candle is unlit.";

    public static boolean Foyer = true;
    public static boolean Library = false;
    public static boolean Conservatory = false;

    public static boolean Trumpet = false;
    public static boolean Piano = false;
    public static boolean Drum = false;

    public static boolean getPen = false;
    public static boolean writeBook = false;
    public static boolean door2Locked = true;
    public static boolean door2open = false;

    public static boolean chestOpen = false;
    public static boolean hasMatches = false;
    public static boolean candleLit = false;
    public static boolean door1Locked = true;
    public static boolean door1open = false;

    public static void main(String[] args) {

        System.out.printf("Welcome to Sai's Escape Room Adventure. There are certain words you can use to indicate direction and tell your character what to do. (north, south, east, west).\n\n");
        for (int i = 1; i < 31; i++) {
            gameUsage();
            movesLeft--;
            if (Trumpet && Piano && Drum) {
                break;
            }
        }
        if (Trumpet && Piano && Drum) {
            System.out.printf("\nCongratulations! You have completed Sai's escape room challenge successfully in with %d moves to spare.", movesLeft);
        }
        else {
            System.out.printf("\nYou have failed Sai's escape room challenge. Try again!");
        }
    }

    public static void gameUsage() {
        if (Foyer) {
            foyer();
        }
        else if (Library) {
            library();
        }
        else if (Conservatory) {
            conservatory();
        }
    }

    public static void foyer() {
        System.out.printf("%s You have %d moves left.\n>>", output, movesLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bench":
                output = "There's a note on the bench.";
                break;

            case "read note":
                output = "May my light show you the way.";
                break;

            case "look chest":
                output = "the chest is closed.";
                break;

            case "open chest":
                chestOpen = true;
                output = "There are matches in the chest.";
                break;

            case "get matches":
                hasMatches = true;
                output = "You now have a box of matches.";
                break;

            case "light candle":
                if (hasMatches) {
                    candleLit = true;
                    door1Locked = false;
                    output = "The candle is lit. You just heard a metal grinding sound coming from the north.";
                }
                else {
                    output = "You don't have any matches left.";
                }
                break;

            case "look door":
                if (!door1Locked) {
                    if (door1open) {
                        output = "The door is unlocked and open.";
                    }
                    else {
                        output = "The door is unlocked, but closed.";
                    }
                }
                else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!door1Locked) {
                    door1open = true;
                    output = "The north door is open.";
                }
                break;

            case "north":
                if (door1open) {
                    Foyer = false;
                    Library = true;
                    output = "You have left the foyer. On your way out, the door slammed and locked. You are now in the library and cannot return to the foyer. In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
                }
                break;
        }
    }

    public static void library() {
        System.out.printf("%s You have %d moves left.\n>>", output, movesLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {

            case "look bookshelf":
                output = "There is a book titled 'The Autobiography of ...' with the rest of the title empty.";
                break;

            case "get pen":
                getPen = true;
                output = "You have acquired the pen.";
                break;

            case "read scroll":
                output = "the scroll says, 'Share your story.'";
                break;

            case "write book":
            case "write name":
                writeBook = true;
                door2Locked = false;
                output = "You have completed the autobiography You heard a metal grinding sound coming from the north.";
                break;

            case "look door":
                if (!door2Locked) {
                    if (door2open) {
                        output = "The door is unlocked and open.";
                    }
                    else {
                        output = "The door is unlocked, but closed.";
                    }
                }
                else {
                    output = "The door is locked.";
                }
                break;

            case "open door":
                if (!door2Locked) {
                    door2open = true;
                    output = "The north door is open.";
                }
                break;

            case "north":
                if (door1open) {
                    Library = false;
                    Conservatory = true;
                    output = " You have left the library. On your way out, the door slammed and locked. You are now in the conservatory and cannot return to the library. In the conservatory there are there are three instruments: a trumpet, a piano, and a drum. There is a sheet of music on a stand.";
                }
                break;

            default:
                output = "In the library there are stacks of books lining the shelves, a desk, a pen, and a scroll. There is another locked door to the north.";
        }
    }

    public static void conservatory() {
        System.out.printf("%s You have %d moves left.\n>>", output, movesLeft);
        scan = new Scanner(System.in);
        String test = scan.nextLine();

        switch (test) {
            case "read music":
                output = "Timbre, Tone, Time";
                break;

            case "play trumpet":
                if (!Piano && !Drum) {
                    Trumpet = true;
                    output = "*trumpet noise*";
                }
                else {
                    output = "Something is wrong with the trumpet, it isn't playing properly.";
                }
                break;

            case "play piano":
                if (Trumpet && !Drum) {
                    Piano = true;
                    output = "*piano noise*";
                }
                else {
                    output = "Something is wrong with the piano, it isn't playing properly.";
                }
                break;

            case "play drum":
                if (Trumpet && Piano) {
                    Drum = true;
                    output = "*drum noise*";
                }
                else {
                    output = "Something is wrong with the drum, it isn't playing properly.";
                }
                break;

            default:
                output = "In the conservatory, there is a large door to the north that is locked. There are three instruments here, a trumpet, drum, and a piano. There is a piece of sheet music on a stand in the center of the room.";
        }
    }
}
