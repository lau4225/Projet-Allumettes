import java.util.Scanner;

/**
 * Created by BonLa1731834 on 2018-01-15.
 */
public class Jeu_Allumettes {

    public static void main(String[] args) {

        System.out.println("Jeu des allumettes");
        System.out.println("Chaque joueur doit retirer entre 1 et 3 allumettes d’un paquet d’allumettes. " +
                "Celui qui retire la dernière allumette perd la partie.");
        System.out.println();
        System.out.println();


        Joueur joueur1 = new Joueur();
        Joueur joueur2 = new Joueur();

        int nbAllum = (int) (Math.random() * 20) + 5;
        System.out.println("Il y a présentement " + nbAllum + " allumettes");
        System.out.println();
        System.out.println();

        String reponse = "";

        boolean finPartie = false;

        Scanner sc = new Scanner(System.in);

        System.out.println("Entrez le nom du joueur1 : ");
        reponse = sc.next();
        joueur1.setNom(reponse);

        System.out.println();
        System.out.println("Entrez le nom du joueur2 : ");
        reponse = sc.next();
        joueur2.setNom(reponse);

        //Jeu
        int nbTour = 0;
        int repAllu = 0;
        boolean repValide1 = false;
        boolean repValide2 = false;
        boolean rejouer = false;
        String repRejouer = "";

        while (rejouer == false) {
            while (finPartie == false) {
                while (repValide1 == false) {
                    System.out.println(joueur1.getNom() + ", combien d'allumettes voulez-vous retirer?");
                    repAllu = sc.nextInt();
                    if (repAllu < 1 || repAllu > 3) {
                        System.out.println("Entrez un nombre valide (1,2 ou 3)");
                    } else {
                        joueur1.getTabAllu()[nbTour] = repAllu;
                        nbAllum = nbAllum - repAllu;
                        repValide1 = true;

                        if (nbAllum <= 0) {
                            System.out.println(joueur1.getNom() + " a perdu :(");
                            System.out.println(joueur2.getNom() + " a gagné :)");

                            finPartie = true;

                        }
                    }
                }


                if (nbAllum < 0) {
                    nbAllum = 0;
                }

                System.out.println();
                System.out.println("-------------------------------------");
                System.out.println("Il reste " + nbAllum + " allumettes");
                System.out.println("-------------------------------------");
                System.out.println();

                if (finPartie == false) {
                    while (repValide2 == false) {
                        System.out.println(joueur2.getNom() + ", combien d'allumettes voulez-vous retirer?");
                        repAllu = sc.nextInt();
                        if (repAllu < 1 || repAllu > 3) {
                            System.out.println("Entrez un nombre valide (1,2 ou 3)");
                        } else {
                            joueur2.getTabAllu()[nbTour] = repAllu;
                            nbAllum = nbAllum - repAllu;
                            repValide2 = true;

                            if (nbAllum <= 0) {
                                System.out.println(joueur2.getNom() + " a perdu :(");
                                System.out.println(joueur1.getNom() + " a gagné :)");

                                finPartie = true;

                            }
                        }
                    }

                    if (nbAllum < 0) {
                        nbAllum = 0;
                    }

                    System.out.println();
                    System.out.println("-------------------------------------");
                    System.out.println("Il reste " + nbAllum + " allumettes");
                    System.out.println("-------------------------------------");
                }


                System.out.println();

                repValide1 = false;
                repValide2 = false;

                if (finPartie == false) {
                    nbTour++;
                }
            }

            //Affichage fin de la partie
            System.out.println("Résultats de la partie :");
            System.out.println();

            System.out.print(joueur1.getNom() + " : ");
            for (int i = 0; i <= nbTour; i++) {
                System.out.print(joueur1.getTabAllu()[i]);
                if (i != nbTour)
                    System.out.print('-');
            }


            System.out.println();
            System.out.println();

            System.out.print(joueur2.getNom() + " : ");
            for (int i = 0; i <= nbTour; i++) {
                System.out.print(joueur2.getTabAllu()[i]);
                if (i != nbTour)
                    System.out.print('-');
            }

            System.out.println();
            System.out.println("Voulez-vous rejouer? o/n");
            repRejouer = sc.next().toLowerCase();
            if (repRejouer=="o")
            {
                rejouer = true;
                finPartie = false;
                repValide1 = false;
                repValide2 = false;
            }
            else if (repRejouer == "n")
            {
                rejouer = true;
                System.out.println("Merci d’avoir joué au jeu des allumettes, bonne journée !");
            }
            else
            {
                System.out.println("Voulez-vous rejouer? o/n");
            }
        }

    }
}
