import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task_2{
    private static boolean menu = true;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);


        cabin[] cabins = new cabin[13];
        passenger[][] newpassenger = new passenger[13][4];


        for (int x = 0; x <  newpassenger .length; x++) {
            cabins[x] = new cabin();
            for (int i = 0; i <  newpassenger [x].length; i++) {
                newpassenger [x][i] = new passenger();
            }
        }

        initialize(cabins,  newpassenger );


        //SELECT THE OPTION FROM MENU
        while (menu) {
            input = new Scanner(System.in);

            System.out.println("Menu");
            System.out.println("Enter an ‘A’ to add a customer to a cabin");
            System.out.println("Enter a ‘V’ to view all cabins");
            System.out.println("Enter 'E' to Display Empty cabins");
            System.out.println("Enter 'D' to Delete customer from cabin");
            System.out.println("Enter 'F' to Find cabin from customer name");
            System.out.println("Enter 'S' to Store program data into file");
            System.out.println("Enter 'L' to Load program data from file");
            System.out.println("Enter 'O' to View passengersOrdered alphabetically by name");
            System.out.println("Enter 'T' to Total expenses");
            String select = input.nextLine();



            // CALLING METHODS
            switch (select) {
                case "A":
                    add_passenger(cabins,  newpassenger );
                    break;
                case "V":
                    view_cabin(cabins,  newpassenger );
                    break;

                case "E":
                    null_cabins(cabins,  newpassenger );
                    break;
                case "D":
                    remove_passenger(cabins, newpassenger );
                    break;
                case "F":
                    find_passenger(cabins,  newpassenger );
                    break;
                case "S":
                    store_data(cabins,  newpassenger );
                    break;
                case "L":
                    load_data(cabins,  newpassenger );
                    break;
                case "O":
                    ordername(cabins,  newpassenger );
                    break;
                case "T":
                    Total_expenses( newpassenger );
                    break;
                default:
                    System.out.println("Your input is invalid");
                    break;
            }
            boolean selection = true;

            //CONTINUE PROGRAM OR END

            while (selection) {

                System.out.println("Enter 1 to Continue or 2 to Exit: ");
                int com = input.nextInt();

                if (com == 1) {
                    menu = true;
                    selection = false;
                } else if (com == 2) {
                    menu = false;
                    selection = false;

                } else {
                    System.out.println("Your input is invalid");
                }
            }
        }
    }

                        //INITILISE PROGRAM
    public static void initialize(cabin[] newcabin, passenger[][] newpassenger ) {
        for (int i = 0; i < 5; i++) {
            newcabin[i].setCabinNumber(10);
        }
        for (int x = 0; x <  newpassenger .length; x++) {
            for (int y = 0; y <  newpassenger [x].length; y++) {
                newpassenger [x][y].setPassenger_FirstName("e");
                newpassenger [x][y].setPassenger_Surname("e");
                newpassenger [x][y].setExpenses(0);


            }
        }
    }
    //ADD PASENGER TO CABINS
     public static void add_passenger(cabin[] newcabin, passenger[][]  newpassenger) {
        try{
            Scanner input = new Scanner(System.in);
            int CabinNum;
            System.out.println("Enter Cabin Number 1 to 12: ");
            CabinNum = input.nextInt();
            if (CabinNum > 0 && CabinNum < 13) {
                System.out.println("Enter passenger number 1 to 3: ");
                int positiont = input.nextInt();
                input = new Scanner(System.in);
                System.out.println("Enter Passenger no" + positiont + " First name: ");
                newpassenger[CabinNum][positiont].setPassenger_FirstName(input.next());

                System.out.println("Enter Passenger no" + positiont + " Surename: ");
                newpassenger[CabinNum][positiont].setPassenger_Surname(input.next());

                System.out.println("Enter Passenger no" + positiont + " Expences: ");
                newpassenger[CabinNum][positiont].setExpenses(input.nextInt());

            }
            else {
                System.out.println("invalid input");
            }

        }catch (Exception e) {
            System.out.println("Enter a Valid Input");

        }
    }



    //VIEW CABINS BY NAMES
    public static void view_cabin(cabin[] newcabin, passenger[][]  newpassenger ) {
        for (int i = 1; i <  newpassenger .length; i++) {
            System.out.println("\n");
            for (int j = 1; j <  newpassenger [i].length; j++) {
                if ( newpassenger [i][j].getPassenger_FirstName().equals("e")) {
                    System.out.println("Cabin " + i + " Passenger " + j + " is empty");
                } else {
                    System.out.print("Cabin " + i + " Passenger " + j + " :");

                    System.out.println(" \n\nFirst Name: " + newpassenger [i][j].getPassenger_FirstName() + "\n\nSurname: " +  newpassenger [i][j].getPassenger_Surname() + " \n\nExpences: " +  newpassenger [i][j].getExpenses());
                    System.out.println("");
                }
            }
        }
    }

                    //VIEW EMPTY CABINS
    public static void null_cabins(cabin[] newcabin, passenger[][]  newpassenger ) {

        for (int i = 1; i <  newpassenger .length; i++) {
            System.out.println("\n");
            for (int j = 1; j <  newpassenger [i].length; j++) {
                if ( newpassenger [i][j].getPassenger_FirstName().equals("e")) {
                    System.out.println("Cabin " + i + " Passenger number " + j + " is empty.");
                }
            }
        }
    }




                     //REMOVE PASSENGERS
    public static void remove_passenger(cabin[] newcabin, passenger[][]  newpassenger ) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter passenger name: ");
            String rem_name = input.next();
            for (int i = 1; i < newpassenger.length; i++) {
                for (int j = 1; j < newpassenger[i].length; j++) {
                    String findName = newpassenger[i][j].getPassenger_FirstName();
                    if (findName.equalsIgnoreCase(rem_name)) {
                        newpassenger[i][j].setPassenger_FirstName("e");
                        newpassenger[i][j].setPassenger_Surname("e");
                        newpassenger[i][j].setExpenses(0);
                        System.out.println("Passenger Removed");
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println();
        }


    }

                ////FIND PASSENGERS
    public static void find_passenger(cabin[] newcabin, passenger[][]  newpassenger ) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter passenger's first name: ");
            String find_name = input.next();
            for (int i = 1; i < newpassenger.length; i++) {
                for (int j = 1; j < newpassenger[i].length; j++) {
                    String findName = newpassenger[i][j].getPassenger_FirstName();
                    if (findName.equalsIgnoreCase(find_name)) {
                        System.out.println("Cabin is " + i + " Passenger location is " + j + "\n");
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println();
        }


    }
                 //STORE PASSENGER DATA IN A TEXT FILE

           //LOADING DATA
    public static void load_data(cabin[] cabins, passenger[][] newpassenger ) {
        int i=1;
        try {
            File inputFile = new File("filename.txt");
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

          //ORDERING THE PASSENGERS NAMES
    public static void ordername(cabin[] cabins, passenger[][]  newpassenger ) {
        String oder[] = new String[36];

        int place_holder = 0;

        for (int i = 1; i < newpassenger .length; i++) {
            for (int j = 1; j <  newpassenger [i].length; j++) {
                oder[place_holder++] =  newpassenger [i][j].getPassenger_FirstName();

            }
        }

        for (int i = 1; i < oder.length; i++) {
            for (int j = 1; j < oder.length - i - 1; j++) {
                if (oder[j].compareTo(oder[j + 1]) > 0) {
                    String temp =oder[j];
                    oder[j] = oder[j + 1];
                    oder[j + 1] = temp;
                }
            }
        }

        for (int i = 1; i < oder.length; i++) {
            if (oder[i].equals("e")) {
                System.out.println(oder[i]);
            }
        }


    }

              //GETING THE TOTAL EXPENSES OF ALL PASSENGERS
    public static void Total_expenses (passenger[][]  newpassenger ) {
        double Total = 0.0;
        for(int i = 1; i<  newpassenger .length; i++){
            for(int j = 1; j<  newpassenger [i].length; j++){
                Total = Total+ newpassenger [i][j].getExpenses();

            }

        }
        System.out.println("Total expenses -"+Total);
    }

}