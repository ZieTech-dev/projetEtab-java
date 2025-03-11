import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Date timeNow = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String formattedTime = timeFormat.format(timeNow);

        pageConnexion(scanner);

        boolean running = true;

        while (running) {
            int choix;
            choix = 0;

            System.out.println("""
                    \n\n\n\n\n
                    #########################################
                    # BIENVENU DANS L’APPLICATION ETAB v1.1 #
                    #########################################
                    
                         MENU:
                                 1: Gestion des élèves
                                 2: Gestion des professeurs
                                 3: Gestion des utilisateurs
                                 0: Quitter
                    """);
            System.out.printf("Date système : %s \n", formattedTime);

            choix = validEntrerInt(scanner, choix, 3);

            System.out.printf("vous avez choisi la reponse \"%d\"", choix);
            switch (choix) {
                case 1:
                    System.out.println("\nGestion des élèves");
                    break;
                case 2:
                    System.out.println("\nGestion des professeurs");
                    break;
                case 3:
                    System.out.println("\nGestion des utilisateurs");
                    break;
                case 0:
                    System.out.println("\nFin 🖖\n");
                    running = false;
                    break;
            }
        }




        scanner.close();
    }


    public static int validEntrerInt(Scanner scanner, int entrer, int plusGrandNombre) {
        do {
            System.out.print("Choix: ");
            if (scanner.hasNextInt()) {
                entrer = scanner.nextInt();

                if (entrer >= 0 && entrer <= plusGrandNombre) {
                    scanner.nextLine();
                    break;
                } else {
                    System.out.println("Pas de réponse valide 🤦! (Entrez un nombre entre 0 et " + plusGrandNombre + ")");
                }
            } else {
                System.out.println("Entre un NOMBRE chef 🤦!!!");
                scanner.next();
            }
            scanner.nextLine();
        } while (true);

        return entrer;
    }


    public static void pageConnexion(Scanner scanner){

        boolean connect = false;

        System.out.println("""
                #########################################
                # BIENVENU DANS L’APPLICATION ETAB v1.1 #
                #########################################
                
                             CONNEXION
                """);

        do{
            System.out.print("Indentifiant :");
            String identifiant = scanner.nextLine().trim();
            System.out.print("Mot de passe :");
            String mdp = scanner.nextLine().trim();

//        System.out.println("DEBUG - Identifiant saisi : " + identifiant);
//        System.out.println("DEBUG - Mot de passe saisi : " + mdp);


            if (identifiant.equals("admin") && mdp.equals("admin")) {
                System.out.println("Bienvenue dans le menu");
                connect = true;
            } else if (identifiant.equals("admin") && !mdp.equals("admin")) {
                System.out.println("Mot de passe incorrect !");
            } else if (!identifiant.equals("admin") && mdp.equals("admin")) {
                System.out.println("Identifiant incorrect !");
            } else {
                System.out.println("Les données sont erronées");
            }
            if (!connect) {
                System.out.println("\n Veillez ressayer !🤦\n");
            }
        }while (connect == false);


    }
}