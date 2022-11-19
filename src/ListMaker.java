import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        final String menu = "A - Add D - Delete P - Print Q - quit";
        boolean done = false;
        String cmd ="";

        do
        {
            //display the list
            displayList();
            //display the menu
            // get a menu choice
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            // execute the choice
            switch(cmd)
            {
                case "A":
                    //prompt the user for a list item
                    String item = SafeInput.getNonZeroLength(console,"Enter the item");

                    // make sure that it is not an empty string
                    //add it to the list
                    list.add(item);
                    break;
                case "D":
                    // prompt the user for the number of the item to delete
                    int delete = SafeInput.getInt(console,"Enter the the item number you want to delete");
                    // Translate the number to an index by subtracting 1
                    int delete1 = delete-1;
                    //remove the item from the list
                    list.remove(delete1);
                    break;
                case "P":
                    break;
                case "Q":
                    System.exit(0);
                    break;
            }
            System.out.println("cmd is "+cmd);


        }while(!done);
    }
    private static void displayList()
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if(list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%3d%35s", i + 1, list.get(i));
            }
        }
        else
            System.out.println("+++                     List is empty                     +++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

}
