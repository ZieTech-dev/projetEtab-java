import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.util.List;

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
            boolean section = true;
            switch (choix) {
                case 1:
                    System.out.println("\nGestion des élèves");
                    while (section) {
                        System.out.println("""
                        ******************************************************
                        *                    GESTION DES ELEVES              *
                        ******************************************************
    
                            Menu :
                                1: Ajouter un élève
                                2: Supprimer un élève
                                3: Modifier les informations de l'élève
                                4: Lister les élèves
                                5: Obtenir le dernier élève ajouté
                                6: Retour
                                0: Quitter
                        """);

                        choix = validEntrerInt(scanner, choix, 6);

                        switch (choix) {
                            case 1 -> ajouterEleve(scanner);
                            case 2 -> supprimerEleve(scanner);
                            case 3 -> modifierEleve(scanner);
                            case 4 -> Eleve.lister();
                            case 5 -> obtenirDernierEleve();
                            case 6 -> section = false;
                            case 0 -> {
                                System.out.println("🚪 Fermeture du programme...");
                                section = false;
                                running = false;

                            }
                            default -> System.out.println("❌ Choix invalide.");
                        }
                    }



                    break;
                case 2:
                    System.out.println("\nGestion des professeur");
                    while (section) {
                        System.out.println("""
                        ******************************************************
                        *                    GESTION DES professeur              *
                        ******************************************************
    
                            Menu :
                                1: Ajouter un professeur
                                2: Supprimer un professeur
                                3: Modifier les informations du professeur
                                4: Lister les professeur
                                5: Obtenir le dernier élève professeur
                                6: Retour
                                0: Quitter
                        """);

                        choix = validEntrerInt(scanner, choix, 6);

                        switch (choix) {
                            case 1 -> ajouterProfeseur(scanner);
                            case 2 -> supprimerProfesseur(scanner);
                            case 3 -> modifierProfesseur(scanner);
                            case 4 -> Professeur.lister();
                            case 5 -> obtenirDernierProfesseur();
                            case 6 -> section = false;
                            case 0 -> {
                                System.out.println("🚪 Fermeture du programme...");
                                section = false;
                                running = false;

                            }
                            default -> System.out.println("❌ Choix invalide.");
                        }
                    }

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

    // 🔹 Fonction pour ajouter un élève
    public static void ajouterEleve(Scanner scanner) {
        System.out.println("🔹 Ajout d'un élève");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nom: ");
        String nom = scanner.nextLine();

        System.out.print("Ville: ");
        String ville = scanner.nextLine();

        System.out.print("Date de naissance (dd/MM/yyyy): ");
        Date dateNaissance = saisirDate(scanner);

        System.out.print("Classe: ");
        String classe = scanner.nextLine();

        Eleve eleve = new Eleve(id, nom, ville, dateNaissance, classe);
        Eleve.ajouter(eleve);
    }

    // 🔹 Fonction pour supprimer un élève
    public static void supprimerEleve(Scanner scanner) {
        System.out.print("ID de l'élève à supprimer : ");
        int id = scanner.nextInt();
        Eleve.supprimer(id);
    }

    // 🔹 Fonction pour modifier un élève
    public static void modifierEleve(Scanner scanner) {
        Eleve.lister();
        System.out.print("ID de l'élève à modifier : ");

        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nouveau nom : ");
        String nom = scanner.nextLine();

        System.out.print("Nouvelle ville : ");
        String ville = scanner.nextLine();

        System.out.print("Nouvelle date de naissance (dd/MM/yyyy): ");
        Date dateNaissance = saisirDate(scanner);

        System.out.print("Nouvelle classe : ");
        String classe = scanner.nextLine();

        Eleve eleve = new Eleve(id, nom, ville, dateNaissance, classe);
        Eleve.mettreAJour(eleve);
    }

    // 🔹 Fonction pour obtenir le dernier élève ajouté
    public static void obtenirDernierEleve() {
        List<Eleve> eleves = Eleve.getListeEleves();
        if (!eleves.isEmpty()) {
            Eleve dernierEleve = eleves.get(eleves.size() - 1);
            System.out.println("Dernier élève ajouté : " + dernierEleve);
        } else {
            System.out.println("❌ Aucun élève enregistré.");
        }
    }


    // 🔹 Fonction utilitaire pour saisir une date
    public static Date saisirDate(Scanner scanner) {
        while (true) {
            try {
                String dateString = scanner.nextLine();
                return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
            } catch (ParseException e) {
                System.out.println("❌ Format de date invalide. Veuillez entrer la date au format jj/MM/yyyy.");
            }
        }
    }

    // Fonction pour ajouter un professeur
    public static void ajouterProfeseur(Scanner scanner) {
        System.out.println("📝 Entrez les informations du professeur :");
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Ville : ");
        String ville = scanner.nextLine();

        System.out.print("Date de naissance (dd/MM/yyyy) : ");
        String dateStr = scanner.nextLine();
        Date dateNaissance = null;
        try {
            dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("❌ Format de date invalide.");
            return;
        }

        System.out.print("Vacant (true/false) : ");
        boolean vacant = scanner.nextBoolean();

        Professeur professeur = new Professeur(id, nom, ville, dateNaissance, vacant);
        Professeur.ajouterProf(professeur);
    }

    // Fonction pour supprimer un professeur
    public static void supprimerProfesseur(Scanner scanner) {
        System.out.print("🔍 Entrez l'ID du professeur à supprimer : ");
        int id = scanner.nextInt();
        if (!Professeur.supprimer(id)) {
            System.out.println("❌ Échec de la suppression.");
        }
    }

    // Fonction pour modifier les informations d'un professeur
    public static void modifierProfesseur(Scanner scanner) {
        System.out.print("🔍 Entrez l'ID du professeur à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nom : ");
        String nom = scanner.nextLine();

        System.out.print("Ville : ");
        String ville = scanner.nextLine();

        System.out.print("Date de naissance (dd/MM/yyyy) : ");
        String dateStr = scanner.nextLine();
        Date dateNaissance = null;
        try {
            dateNaissance = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("❌ Format de date invalide.");
            return;
        }

        System.out.print("Vacant (true/false) : ");
        boolean vacant = scanner.nextBoolean();

        Professeur professeur = new Professeur(id, nom, ville, dateNaissance, vacant);
        if (!Professeur.mettreAJour(professeur)) {
            System.out.println("❌ Échec de la mise à jour.");
        }
    }


    // Fonction pour obtenir le dernier professeur ajouté
    public static void obtenirDernierProfesseur() {
        Professeur dernier = Professeur.obtenirDernierProfesseur();
        if (dernier == null) {
            System.out.println("❌ Aucun professeur enregistré.");
        } else {
            System.out.println("🆕 Dernier professeur ajouté : " + dernier.nom);
        }
    }


}