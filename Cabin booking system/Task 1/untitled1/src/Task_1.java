import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Task_1 {
    private static boolean menu = true;


    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        String[] cabins = new String[13];


        initialise(cabins);


        while (menu) {

            //SELECT THE OPTION FROM MENU
            System.out.println("Menu");
            System.out.println("Enter an ‘A’ to add a customer to a cabin");
            System.out.println("Enter a ‘V’ to view all cabins");
            System.out.println("Enter 'E' to Display Empty cabins");
            System.out.println("Enter 'D' to Delete customer from cabin");
            System.out.println("Enter 'F' to Find cabin from customer name");
            System.out.println("Enter 'S' to Store program data into file");
            System.out.println("Enter 'L' to Load program data from file");
            System.out.println("Enter 'O' to View passengersOrdered alphabetically by name");

            String select = input.next();


            // CALLING METHODS

            switch (select) {
                case "A":
                    add_passenger(cabins);
                    break;

                case "V":
                    view_cabins(cabins);
                    break;

                case "E":
                    null_cabins(cabins);
                    break;

                case "D":
                    remove_passenger(cabins);
                    break;

                case "F":
                    find_passenger(cabins);
                    break;

                case "S":
                    store_data(cabins);
                    break;

                case "L":
                    load_data(cabins);
                    break;

                case "O":
                    order(cabins);
                    break;

                default:
                    System.out.println("Your input is invalid");
                    break;

            }
            boolean selection = true;





            //CONTINUE PROGRAM OR END

            while (selection) {




                System.out.println("Enter 1 to Continue or 2 to Exit: ");
                int in = input.nextInt();

                if (in == 1) {
                    menu = true;
                    selection = false;
                } else if (in == 2) {
                    System.out.println("Thank you ");

                    menu = false;
                    selection = false;

                } else {
                    System.out.println("Your input is invalid");
                }


            }










        }


    }
    //INITILISE PROGRAM
    private static void initialise(String cabinRef[]) {
        for (int x = 0; x < 13; x++) cabinRef[x] = "e";
        System.out.println("initilise ");
    }
    //ADD PASENGER TO CABINS
    private static void add_passenger(String[] newcabin) {
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a Cabin Number 1 to 12 : ");
            int CabinNum = input.nextInt();

            if(CabinNum <=12 && CabinNum >=1) {

                System.out.println("Enter passenger  Name for Cabin Number  " + CabinNum + ": ");
                String cabinName = input.next();
                newcabin[CabinNum] = cabinName;//mathaka na
            }
            else{
                System.out.println("Enter a valid cabin number");
            }
        }
        catch (Exception e) {
            System.out.println("enter a valid input");
        }




    }
    //VIEW CABINS BY NAMES
    private static void view_cabins(String[] newcabin){
        for (int x=1; x< newcabin.length; x++){
            if(newcabin[x].equals("e")){
                System.out.println("cabin  " + x + " is empty");
            }else{

                System.out.println("cabin " + x +" Occupied by " + newcabin[x]);




            }

        }
    }
    //VIEW EMPTY CABINS
    private static void null_cabins(String[] newcabin){
        try{
            for (int x=1; x<newcabin.length; x++){
                if (newcabin[x].equals("e")){
                    System.out.println("cabin " + x + " is empty");
                }
            }
        }
        catch (Exception e) {
            System.out.println();
        }


    }
    //REMOVE PASSENGERS
    private static void remove_passenger(String[] newcabin){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the cabin number to remove customer: ");
            int roomNumber=input.nextInt();
            newcabin[roomNumber] = "e";
            System.out.println("Passenger Removed ");
        }
        catch (Exception e) {
            System.out.println();
        }


    }
    //FIND PASSENGERS
    private static void find_passenger(String[] newcabin){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the passenger Name: ");
            String passenger_name = input.next();

            for(int i=0; i<newcabin.length; i++){
                if(newcabin[i].equals(passenger_name)){
                    System.out.println(passenger_name + " is in cabin " + i);
                }
            }
        }
        catch (Exception e) {
            System.out.println();
        }


    }
    //STORE DATA
    private static void store_data(String[] cabins)throws FileNotFoundException {

        File info_file = new File("Customer_Info.txt");
        PrintStream writer = new PrintStream(info_file);

        for (String temp : cabins) {
            writer.println(temp);
        }


        System.out.println(" Saved");
        writer.close();


    }
    //LOADING DATA
    private static void load_data(String[] cabins) throws IOException {
        int i=1;
        try {
            File inputFile = new File("Task1file.txt");
            Scanner rf = new Scanner(inputFile);
            String fileLine;
            while (rf.hasNext()){
                fileLine = rf.nextLine();

                System.out.println( fileLine);

            }rf.close();
        }catch(IOException e){
            System.out.println("xx");
        }
    }
    //ORDERING THE NAMES
    private static void order(String[] newcabin){
        String []pasenger = new String[newcabin.length];
        for(int i = 0; i < newcabin.length; i++){
            pasenger[i] = newcabin[i];
        }


        int n = pasenger.length;
        for (int x = 0; x < n - 1; x++)
        {
            for(int y = 0; y <= n - 2; y++)
            {
                if (pasenger[y].compareToIgnoreCase(pasenger[y + 1]) > 0)
                {
                    String temp = pasenger[y];
                    pasenger[y] = pasenger[y + 1];
                    pasenger[y + 1] = temp;
                }
            }
        }

        for(String temp:pasenger){
            if(!temp.equals("e")) {
                System.out.println(temp);
            }
        }




    }

}