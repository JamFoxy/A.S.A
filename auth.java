package sample;

import java.util.*;

public class auth {

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("\n\t\tWelcome");
        ArrayList<ArrayList<String>> accounts = registration.data();
        int a = 0;
        while (true) {
            System.out.print("\nChoose account ('Director(d)','Seller(s)','Mechanic(m)'), ('Registration(r)') to sign up, ('E') to exit >>> ");
            String type = scan.nextLine();
            if (type.equalsIgnoreCase("d") || type.equalsIgnoreCase("s") || type.equalsIgnoreCase("m")) {
                while (a < 3) {
                    System.out.print("Enter username >>> ");
                    String username = scan.nextLine();
                    for (int i = 0; i < accounts.size(); i++) {
                        if (accounts.get(i).get(2).equals(type) && accounts.get(i).get(0).equals(username)) {
                            for (int j = 0; j < 3; j++) {
                                System.out.print("Enter password >>> ");
                                String password = scan.nextLine();
                                if (accounts.get(i).get(1).equals(password)) {
                                    a += 3;
                                    if (type.equals("d")) {
                                        director.main(args);
                                    } else if (type.equals("s")) {
                                        seller.main(args);
                                    } else if (type.equals("m")) {
                                        mechanic.main(args);
                                    }
                                    break;
                                } else {
                                    a++;
                                    System.out.println("\nWrong password !!!\n");
                                }
                            }
                        }
                    }
                    if (a < 3) {
                        System.out.println("\nWrong username !!!\n");
                    }
                    a++;
                }
                break;
            } else if (type.equalsIgnoreCase("e")) {
                System.out.println("\nWe look forward !!!");
                System.exit(0);
            } else if (type.equalsIgnoreCase("r")) {
                registration.main(args);
            } else {
                System.out.println("\nWrong input !!!\n");
            }
        }
    }

}
