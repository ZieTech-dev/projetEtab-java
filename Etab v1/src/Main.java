import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.ParseException;
import java.util.List;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Commande> commandes = new ArrayList<>();
    private static List<Boisson> boissons = new ArrayList<>();
    private static List<Repas> repas = new ArrayList<>();
    private static List<Supplement> supplements = new ArrayList<>();

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
                                 4: Gestion des restaurations
                                 0: Quitter
                    """);
            System.out.printf("Date système : %s \n", formattedTime);

            choix = validEntrerInt(scanner, choix, 4);

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
                        *                GESTION DES professeur              *
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
                case 4:
                    System.out.println("\nGestion des Restauration");
                    while (section) {
                        System.out.println("""
                            **************************************
                            *         GESTION DU RESTAURANT        *
                            **************************************
            
                            Menu :
                            1: Gérer les Boissons
                            2: Gérer les Repas
                            3: Gérer les Suppléments
                            4: Gérer les Commandes
                            5: Retour
                            0: Quitter
                        """);

                        choix = validEntrerInt(scanner, choix, 5);

                        switch (choix) {
                            case 1 -> gererBoissons();
                            case 2 -> gererRepas();
                            case 3 -> gererSupplements();
                            case 4 -> gererCommandes();
                            case 5 -> section = false;
                            case 0 -> {
                                System.out.println("🚪 Fermeture du programme...");
                                section = false;
                                running = false;

                            }
                            default -> System.out.println("❌ Choix invalide.");
                        }
                    }

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

    // Gestion des Boissons
    private static void gererBoissons() {
        System.out.println("1: Ajouter\n2: Supprimer\n3: Modifier\n4: Lister\n5: Obtenir le dernier");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 -> ajouterBoisson();
            case 2 -> supprimerBoisson();
            case 3 -> modifierBoisson();
            case 4 -> listerBoissons();
            case 5 -> obtenirDerniereBoisson();
            default -> System.out.println("❌ Choix invalide.");
        }
    }

    // Gestion des Boissons
    private static void gererRepas() {
        System.out.println("1: Ajouter\n2: Supprimer\n3: Modifier\n4: Lister\n5: Obtenir le dernier");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 -> ajouterRepas();
            case 2 -> supprimerRepas();
            case 3 -> modifierRepas();
            case 4 -> listerRepas();
            case 5 -> obtenirDerniereRepas();
            default -> System.out.println("❌ Choix invalide.");
        }
    }

    private static void ajouterBoisson() {
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prix : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Taille (petit/moyen/grand) : ");
        String taille = scanner.nextLine();
        System.out.print("Stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        boissons.add(new Boisson(id, nom, prix, taille, stock));
        System.out.println("✅ Boisson ajoutée : " + nom);
    }

    private static void ajouterRepas() {
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Description : ");
        String description = scanner.nextLine();
        System.out.print("Prix : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        repas.add(new Repas(id, nom,description, prix, stock));
        System.out.println("✅ Repas ajoutée : " + nom);
    }

    private static void listerBoissons() {
        if (boissons.isEmpty()) {
            System.out.println("❌ Aucune boisson enregistrée.");
            return;
        }
        System.out.println("📚 Liste des boissons :");
        for (Boisson boisson : boissons) {
            System.out.println("ID: " + boisson.getId() + ", Nom: " + boisson.getNom() + ", Prix: " + boisson.getPrix() + ", Stock: " + boisson.getStock());
        }
    }
    private static void listerRepas() {
        if (repas.isEmpty()) {
            System.out.println("❌ Aucun repas enregistrée.");
            return;
        }
        System.out.println("📚 Liste des repas :");
        for (Repas repas1 : repas) {
            System.out.println("ID: " + repas1.getId() + ", Nom: " + repas1.getNom() + ", Prix: " + repas1.getPrix() + ", Stock: " + repas1.getStock());
        }
    }

    private static void obtenirDerniereBoisson() {
        if (boissons.isEmpty()) {
            System.out.println("❌ Aucune boisson enregistrée.");
            return;
        }
        Boisson derniere = boissons.get(boissons.size() - 1);
        System.out.println("🆕 Dernière boisson ajoutée : " + derniere.getNom());
    }
    private static void obtenirDerniereRepas() {
        if (repas.isEmpty()) {
            System.out.println("❌ Aucune repas enregistrée.");
            return;
        }
        Repas derniere = repas.get(repas.size() - 1);
        System.out.println("🆕 Dernière repas ajoutée : " + derniere.getNom());
    }

    private static void supprimerBoisson() {
        System.out.print("ID de la boisson à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Boisson boisson : boissons) {
            if (boisson.getId() == id) {
                boissons.remove(boisson);
                System.out.println("🗑️ Boisson supprimée : " + boisson.getNom());
                return;
            }
        }
        System.out.println("❌ Boisson non trouvée.");
    }

    private static void supprimerRepas() {
        System.out.print("ID de la repas à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Repas repas1 : repas) {
            if (repas1.getId() == id) {
                boissons.remove(repas1);
                System.out.println("🗑️ repas supprimée : " + repas1.getNom());
                return;
            }
        }
        System.out.println("❌ repas non trouvée.");
    }

    private static void modifierBoisson() {
        System.out.print("ID de la boisson à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Boisson boisson : boissons) {
            if (boisson.getId() == id) {
                System.out.print("Nouveau nom : ");
                String nom = scanner.nextLine();
                System.out.print("Nouveau prix : ");
                double prix = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Nouvelle taille (petit/moyen/grand) : ");
                String taille = scanner.nextLine();
                System.out.print("Nouveau stock : ");
                int stock = scanner.nextInt();
                scanner.nextLine();

                boisson.setNom(nom);
                boisson.setPrix(prix);
                boisson.setTaille(taille);
                boisson.setStock(stock);
                System.out.println("✅ Boisson mise à jour : " + nom);
                return;
            }
        }
        System.out.println("❌ Boisson non trouvée.");
    }

    private static void modifierRepas() {
        System.out.print("ID de la repas à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Repas repas1 : repas) {
            if (repas1.getId() == id) {
                System.out.print("Nouveau nom : ");
                String nom = scanner.nextLine();
                System.out.print("Nouveau description : ");
                String description = scanner.nextLine();
                System.out.print("Nouveau prix : ");
                double prix = scanner.nextDouble();
                scanner.nextLine();

                System.out.print("Nouveau stock : ");
                int stock = scanner.nextInt();
                scanner.nextLine();

                repas1.setNom(nom);
                repas1.setPrix(prix);
                repas1.setDescription(description);
                repas1.setStock(stock);
                System.out.println("✅ Repas mise à jour : " + nom);
                return;
            }
        }
        System.out.println("❌ repas non trouvée.");
    }
    private static void gererSupplements() {
        System.out.println("1: Ajouter\n2: Supprimer\n3: Modifier\n4: Lister\n5: Obtenir le dernier");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 -> ajouterSupplement();
            case 2 -> supprimerSupplement();
            case 3 -> modifierSupplement();
            case 4 -> listerSupplements();
            case 5 -> obtenirDernierSupplement();
            default -> System.out.println("❌ Choix invalide.");
        }
    }

    private static void ajouterSupplement() {
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prix : ");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        supplements.add(new Supplement(id, nom, prix, stock));
        System.out.println("✅ Supplément ajouté : " + nom);
    }

    private static void supprimerSupplement() {
        System.out.print("ID du supplément à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Supplement supplement : supplements) {
            if (supplement.getId() == id) {
                supplements.remove(supplement);
                System.out.println("🗑️ Supplément supprimé : " + supplement.getNom());
                return;
            }
        }
        System.out.println("❌ Supplément non trouvé.");
    }

    private static void modifierSupplement() {
        System.out.print("ID du supplément à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Supplement supplement : supplements) {
            if (supplement.getId() == id) {
                System.out.print("Nouveau nom : ");
                String nom = scanner.nextLine();
                System.out.print("Nouveau prix : ");
                double prix = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Nouveau stock : ");
                int stock = scanner.nextInt();
                scanner.nextLine();

                supplement.setNom(nom);
                supplement.setPrix(prix);
                supplement.mettreAJourStock(stock);
                System.out.println("✅ Supplément mis à jour : " + nom);
                return;
            }
        }
        System.out.println("❌ Supplément non trouvé.");
    }

    private static void listerSupplements() {
        if (supplements.isEmpty()) {
            System.out.println("❌ Aucun supplément enregistré.");
            return;
        }
        System.out.println("📚 Liste des suppléments :");
        for (Supplement supplement : supplements) {
            System.out.println("ID: " + supplement.getId() + ", Nom: " + supplement.getNom() + ", Prix: " + supplement.getPrix() + ", Stock: " + supplement.getStock());
        }
    }

    private static void obtenirDernierSupplement() {
        if (supplements.isEmpty()) {
            System.out.println("❌ Aucun supplément enregistré.");
            return;
        }
        Supplement dernier = supplements.get(supplements.size() - 1);
        System.out.println("🆕 Dernier supplément ajouté : " + dernier.getNom());
    }

    // Gestion des Commandes
    private static void gererCommandes() {
        System.out.println("1: Ajouter\n2: Supprimer\n3: Modifier\n4: Lister\n5: Obtenir la dernière");
        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 -> ajouterCommande();
            case 2 -> supprimerCommande();
            case 3 -> modifierCommande();
            case 4 -> listerCommandes();
            case 5 -> obtenirDerniereCommande();
            default -> System.out.println("❌ Choix invalide.");
        }
    }

    private static void ajouterCommande() {
        System.out.print("ID : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Date dateCommande = new Date();
        System.out.print("Statut (En attente/Confirmée/Préparation/Prête/Livrée) : ");
        String statut = scanner.nextLine();

        commandes.add(new Commande(id, dateCommande, statut));
        System.out.println("✅ Commande ajoutée avec ID : " + id);
    }

    private static void supprimerCommande() {
        System.out.print("ID de la commande à supprimer : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Commande commande : commandes) {
            if (commande.getId() == id) {
                commandes.remove(commande);
                System.out.println("🗑️ Commande supprimée avec ID : " + id);
                return;
            }
        }
        System.out.println("❌ Commande non trouvée.");
    }

    private static void modifierCommande() {
        System.out.print("ID de la commande à modifier : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Commande commande : commandes) {
            if (commande.getId() == id) {
                System.out.print("Nouveau statut : ");
                String statut = scanner.nextLine();
                commande.changerStatut(statut);
                System.out.println("✅ Commande mise à jour avec ID : " + id);
                return;
            }
        }
        System.out.println("❌ Commande non trouvée.");
    }

    private static void listerCommandes() {
        if (commandes.isEmpty()) {
            System.out.println("❌ Aucune commande enregistrée.");
            return;
        }
        System.out.println("📚 Liste des commandes :");
        for (Commande commande : commandes) {
            System.out.println("ID: " + commande.getId() + ", Date: " + commande.getDateCommande() + ", Statut: " + commande.getStatut() + ", Total: " + commande.calculerTotal());
        }
    }

    private static void obtenirDerniereCommande() {
        if (commandes.isEmpty()) {
            System.out.println("❌ Aucune commande enregistrée.");
            return;
        }
        Commande derniere = commandes.get(commandes.size() - 1);
        System.out.println("🆕 Dernière commande ajoutée avec ID : " + derniere.getId());
    }




}