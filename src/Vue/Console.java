/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.*;
import Controleur.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Sylvain
 */
public class Console {

    public static void console(){
        //Test de fond

        int choix;
        Scanner sc = new Scanner(System.in);
        System.out.println("<-----GESTION Ecole----->\n");

        do {
            System.out.println("        MENU");
            System.out.println("1.  Ajouter un élève");
            System.out.println("2.  Ajouter un professeur");
            System.out.println("3.  Ajouter une note");
            System.out.println("4.  Ajouter discipline");
            System.out.println("5.  Ajouter un niveau");
            System.out.println("6.  Ajouter une annee");
            System.out.println("7.  Ajouter une classe");
            System.out.println("8.  Ajouter un trimestre");
            System.out.println("9. Ajouter un  bulletin");
            System.out.println("10. Ajouter un  detail bulletin");

            System.out.println("11. Supprimer discipline");
            System.out.println("12. Supprimer un élève");
            System.out.println("13. Supprimer un professeur");
            System.out.println("14. Supprimer une note");

            System.out.println("15. Modifier un profil élève");
            System.out.println("16. Modifier un profil professeur");
            System.out.println("17. Modifier une note");
            System.out.println("18. Modifier une classe");
            System.out.println("19. Modifier un bulletin");
            System.out.println("20. Modifier un détail bulletin");

            System.out.println("22. Recherche un eleve");
            System.out.println("23. Recherche une personne");
            System.out.println("24. Recherche un enseignant");
            System.out.println("25. Rechercher une discipline");

            System.out.println("31. Afficher toutes les discipline");
            System.out.println("32. Afficher toutes les années");
            System.out.println("33. Afficher tous les bulletins");
            System.out.println("34. Afficher toutes les classes");
            System.out.println("35. Afficher tous les détails bulletin");
            System.out.println("36. Afficher tous les eleves");
            System.out.println("37. Afficher tous les enseignants");
            System.out.println("38. Afficher tous les niveaux");
            System.out.println("39. Afficher toutes les notes");
            System.out.println("40. Afficher toutes les peronnes");
            System.out.println("41. Afficher tous les trimestres");
            System.out.println("50. Quitter");

            System.out.println("\n  Rentrez un choix : ");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                // <-----Ajout d'élève----->
                case 1:
                    String nom_eleve;
                    String prenom_eleve;
                    int class_eleve;
                    System.out.println("Prenom de l'élève:");
                    prenom_eleve = sc.nextLine();
                    System.out.println("Nom de l'élève:");
                    nom_eleve = sc.nextLine();
                    System.out.println("Classe de l'élève:");
                    class_eleve = sc.nextInt();
                    Eleve eleve_add = new Eleve(1, nom_eleve, prenom_eleve, 1, 1, class_eleve);
                    DAO<Personne> el = DAO_Factory.getEleveDAO();

                    if (el.create(eleve_add)) {
                        System.out.println("Eleve ajouté!");
                    }
                    break;

                //<----Ajout de professeur---->
                case 2:
                    // de type 2
                    String nom_prof;
                    String prenom_prof;
                    int id_disc_prof;
                    int id_class_prof;
                    System.out.println("Prenom de l'enseignant:");
                    prenom_prof = sc.nextLine();
                    System.out.println("Nom de l'enseignant:");
                    nom_prof = sc.nextLine();
                    System.out.println("ID de la matière qu'il va enseigner:");
                    id_disc_prof = sc.nextInt();
                    System.out.println("ID de la classe dans laquelle il va enseigner:");
                    id_class_prof = sc.nextInt();
                    //Enseignant(int id_personne,String nom, String prenom, int type, int id_enseignant, int id_classe, int id_discipline)
                    Enseignant enseignant = new Enseignant(1, nom_prof, prenom_prof, 2, 0, id_class_prof, id_disc_prof);
                    DAO<Enseignant> ens = DAO_Factory.getEnseignantDAO();

                    if (ens.create(enseignant)) {
                        System.out.println("Enseignant ajouté!");
                    }
                    break;

                //<----Ajout de note---->
                case 3:
                    double note_add;
                    int id_detail_bul_add;
                    String note_appre_add;
                    System.out.println("ID detail bulletin:");
                    id_detail_bul_add = sc.nextInt();
                    System.out.println("La note:");
                    note_add = sc.nextDouble();
                    System.out.println("Appreciation:");
                    note_appre_add = sc.nextLine();
                    Note note = new Note(1, id_detail_bul_add, note_appre_add, note_add);
                    DAO<Note> no = DAO_Factory.getNoteDAO();

                    if (no.create(note)) {
                        System.out.println("Note creer");

                    }
                    break;

                //<----Ajout de discipline---->  
                case 4:
                    String nom_discipline;
                    System.out.println("Nom de la discipline:");
                    nom_discipline = sc.nextLine();
                    Discipline dscp = new Discipline(1, nom_discipline);
                    DAO<Discipline> discipline = DAO_Factory.getDisciplineDAO();
                    if (discipline.create(dscp)) {
                        System.out.println("Discipline ajoutée!");
                    }
                    break;

                //<----Ajout de Niveau---->
                case 5:
                    String niv;
                    System.out.println("Niveau:");
                    niv = sc.nextLine();
                    Niveau niveau = new Niveau(1, niv);
                    DAO<Niveau> n = DAO_Factory.getNiveauDAO();

                    if (n.create(niveau)) {
                        System.out.println("Niveau creer");

                    }
                    break;

                //<----Ajout d'année scolaire---->
                case 6:

                    Annee_scolaire annee = new Annee_scolaire(1);
                    DAO<Annee_scolaire> a = DAO_Factory.getAnneescolaireDAO();

                    if (a.create(annee)) {
                        System.out.println("Annee créée!");
                    }

                    break;

                //<----Ajout de classe---->   
                case 7:

                    String nom_classe;
                    int id_niveau_classe;
                    int id_annee_classe;
                    System.out.println("Nom de la classe:");
                    nom_classe = sc.nextLine();
                    System.out.println("ID du niveau de la classe:");
                    id_niveau_classe = sc.nextInt();
                    System.out.println("ID de l'année d'existance de la classe:");
                    id_annee_classe = sc.nextInt();
                    Classe classe = new Classe(1, id_niveau_classe, nom_classe, id_annee_classe);
                    DAO<Classe> c = DAO_Factory.getClasseDAO();

                    if (c.create(classe)) {
                        System.out.println("Classe créée!");

                    }

                    break;

                //<----Ajout de trimestre---->
                case 8:
                    int deb_trimestre;
                    int fin_trimestre;
                    int numero_trimestre;
                    int id_annee_trim;
                    System.out.println("Numero du trimestre:");
                    numero_trimestre = sc.nextInt();
                    System.out.println("ID de l'année de ce trimestre:");
                    id_annee_trim = sc.nextInt();
                    System.out.println("Mois de debut du trimestre:");
                    deb_trimestre = sc.nextInt();
                    System.out.println("Mois de fin du trimestre:");
                    fin_trimestre = sc.nextInt();
                    Trimestre trimestre = new Trimestre(1, numero_trimestre, deb_trimestre, fin_trimestre, id_annee_trim);
                    DAO<Trimestre> t = DAO_Factory.getTrimestreDAO();

                    if (t.create(trimestre)) {
                        System.out.println("Trimestre créé");

                    }
                    break;

                //<----Ajout de bulletin---->
                case 9:
                    int id_trimestre;
                    int id_eleve_bul;
                    String appreciation_bul;
                    System.out.println("ID de l'élève:");
                    id_eleve_bul = sc.nextInt();
                    System.out.println("ID du trimestre de ce bulletin:");
                    id_trimestre = sc.nextInt();
                    System.out.println("Appreciation:");
                    appreciation_bul = sc.nextLine();
                    Bulletin bulletin = new Bulletin(1, id_trimestre, id_eleve_bul, appreciation_bul);
                    DAO<Bulletin> bu = DAO_Factory.getBulletinDAO();

                    if (bu.create(bulletin)) {
                        System.out.println("Bulletin creer");

                    }
                    break;

                //<----Ajout de détail bulletin---->
                case 10:
                    int id_enseignant;
                    int id_bul;
                    String appreciation_dbul;
                    System.out.println("ID de l'enseignant:");
                    id_enseignant = sc.nextInt();
                    System.out.println("ID du bulletin:");
                    id_bul = sc.nextInt();
                    System.out.println("Appreciation:");
                    appreciation_dbul = sc.nextLine();

                    Detail_bulletin detail_bulletin = new Detail_bulletin(0, id_bul, id_enseignant, appreciation_dbul);
                    DAO<Detail_bulletin> det_bu = DAO_Factory.getDetailbulletinDAO();

                    if (det_bu.create(detail_bulletin)) {
                        System.out.println("Detil bulletin creer");

                    }
                    break;

                //<----Suppression de discipline---->  
                case 11:
                    int id_disc_suppr;
                    String nom_disc_suppr;
                    System.out.println("Entrez l'id de la discipline à supprimer:");
                    id_disc_suppr = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Entrez le nom de la discipline à supprimer:");
                    nom_disc_suppr = sc.nextLine();
                    Discipline dscp_suppr = new Discipline(id_disc_suppr, nom_disc_suppr);
                    DAO<Discipline> discipline_suppr = DAO_Factory.getDisciplineDAO();
                    if (discipline_suppr.delete(dscp_suppr)) {
                        System.out.println("Discipline supprimée!");
                    }

                    break;

                //<----Suppression d'élève----->
                case 12:
                    System.out.println("La suppression d'élève est indisponible pour l'instant");
                    break;

                //<----Suppression de prof----->
                case 13:
                    System.out.println("La suppression de professeur est indisponible pour l'instant");
                    break;

                // <----Suppresion de note---->
                case 14:
                    System.out.println("La suppression de note est indisponible pour l'instant");
                    break;

                //<----Modification d'élève---->
                // a modifier
                 case 15:
                    int modif_id_eleve;
                    String modif_nom_eleve;
                    String modif_prenom_eleve;
                    int modif_id_classe_eleve;
                    int id_personne_eleve=0;

                    System.out.println("Selectionner l'ID de l'éleve a modifier:");
                    modif_id_eleve = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nom de l'eleve: ");
                    modif_nom_eleve = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Prenom de l'éleve  ");
                    modif_prenom_eleve = sc.nextLine();

                    System.out.println("Id classe :");
                    modif_id_classe_eleve = sc.nextInt();

                    Eleve eleve_modif = new Eleve(id_personne_eleve, modif_nom_eleve, modif_prenom_eleve, 1, modif_id_eleve, modif_id_classe_eleve);
                    DAO<Eleve> e_modif = DAO_Factory.getEleveDAO();

                    if (e_modif.update(eleve_modif)) {
                        System.out.println("Eleve modifiée!");
                    }

                    break;

                //<----Modification de prof----> 
                case 16:
                   int modif_id_ens;
                    String modif_nom_ens;
                    String modif_prenom_ens;
                    int modif_id_classe_ens;
                    int modif_id_disc;
                    int id_personne_ens=0;

                    System.out.println("Selectionner l'ID de l'enseignant a modifier:");
                    modif_id_ens = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nom de l'enseignant: ");
                    modif_nom_ens = sc.nextLine();
                    sc.nextLine();

                    System.out.println("Prenom de l'enseignant  ");
                    modif_prenom_ens = sc.nextLine();

                    System.out.println("Id classe :");
                    modif_id_classe_ens = sc.nextInt();
                    
                    System.out.println("Id discipline :");
                    modif_id_disc = sc.nextInt();

                    Enseignant ens_modif = new Enseignant(id_personne_ens, modif_nom_ens, modif_prenom_ens, 2, modif_id_ens, modif_id_classe_ens, modif_id_disc);
                    DAO<Enseignant> ensei_modif = DAO_Factory.getEnseignantDAO();

                    if (ensei_modif.update(ens_modif)) {
                        System.out.println("Enseignant modifiée!");
                    }
                    break;
                //<----Modification de note---->      
                case 17:
                    int modif_id_note;
                    int modif_id_bulletin_detail_note;
                    String modif_appreciation_note;
                    double modif_note_note;

                    System.out.println("Selectionner l'ID de la note modifier:");
                    modif_id_note = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Id du detail bulletin lie a la note:");
                    modif_id_bulletin_detail_note = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Appreciation de la note ");
                    modif_appreciation_note = sc.nextLine();

                    System.out.println("Note :");
                    modif_note_note = sc.nextDouble();

                    Note note_modif = new Note(modif_id_note, modif_id_bulletin_detail_note, modif_appreciation_note, modif_note_note);
                    DAO<Note> n_modift = DAO_Factory.getNoteDAO();

                    if (n_modift.update(note_modif)) {
                        System.out.println("Note modifiée!");
                    }
                    break;

                //<---Mise a jour de la classe--->
                case 18:
                    int modif_id_classe;
                    int modif_id_niveau_classe;
                    String modif_nom_classe;
                    int modif_id_annee_classe;

                    System.out.println("Selectionner l'ID de la classe que vous voulez modifier:");
                    modif_id_classe = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Id Niveau:");
                    modif_id_niveau_classe = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Nom de la classe:");
                    modif_nom_classe = sc.nextLine();

                    System.out.println("Id Annee:");
                    modif_id_annee_classe = sc.nextInt();

                    Classe classe_modif = new Classe(modif_id_classe, modif_id_niveau_classe, modif_nom_classe, modif_id_annee_classe);
                    DAO<Classe> cla = DAO_Factory.getClasseDAO();

                    if (cla.update(classe_modif)) {
                        System.out.println("Classe modifiée!");
                    }

                    break;
                //<---Mise ajout du bulletin--->
                case 19:
                    int modif_id_bulletin;
                    int modif_id_trimestre_bulletin;
                    int modif_id_eleve_bulletin;
                    String modif_appreciation_bulletin;

                    System.out.println("Selectionner l'ID du bulletin que vous voulez modifier:");
                    modif_id_bulletin = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Id trimestre du bulletin:");
                    modif_id_trimestre_bulletin = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Id eleve de l'éleve a qui apartient le bulletin:");
                    modif_id_eleve_bulletin = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Appreiation :");
                    modif_appreciation_bulletin = sc.nextLine();

                    Bulletin bulletin_modif = new Bulletin(modif_id_bulletin, modif_id_trimestre_bulletin, modif_id_eleve_bulletin, modif_appreciation_bulletin);
                    DAO<Bulletin> bult = DAO_Factory.getBulletinDAO();

                    if (bult.update(bulletin_modif)) {
                        System.out.println("Bulletin modifié!");
                    }

                    break;

                //<---Mise ajout du detail_bulletin--->
                case 20:
                    int modif_id_detail_bulletin;
                    int modif_id_bulletin_detail_bulletin;
                    int modif_id_enseignant_detail_bulletin;
                    String modif_appreciation_detail_bulletin;

                    System.out.println("Selectionner l'ID du detail bulletin que vous voulez modifier:");
                    modif_id_detail_bulletin = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Id du bulletin du detail bulletin:");
                    modif_id_bulletin_detail_bulletin = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Id enseignant detail bulletin");
                    modif_id_enseignant_detail_bulletin = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Appreiation detail bulletin:");
                    modif_appreciation_detail_bulletin = sc.nextLine();

                    Detail_bulletin detail_bulletin_modif = new Detail_bulletin(modif_id_detail_bulletin, modif_id_bulletin_detail_bulletin, modif_id_enseignant_detail_bulletin, modif_appreciation_detail_bulletin);
                    DAO<Detail_bulletin> detail_bult = DAO_Factory.getDetailbulletinDAO();

                    if (detail_bult.update(detail_bulletin_modif)) {
                        System.out.println("Detail bulletin modifié!");
                    }

                    break;

                //<---Mise a jour d une personne--->
                case 21:
                    int modif_id_personne;
                    String modif_nom_personne;
                    String modif_prenom_personne;
                    int type_personne;
                    HashMap<Integer, Personne> h_pers_modif = new HashMap<Integer, Personne>();
                    DAO<Personne> personne_modif_all = DAO_Factory.getPersonneDAO();
                    h_pers_modif = personne_modif_all.show_all();

                    System.out.println("Selectionner l'ID de la personne que vous voulez modifier:");
                    modif_id_personne = sc.nextInt();
                    sc.nextLine();
                    type_personne = h_pers_modif.get(modif_id_personne).getType();
                    System.out.println("Prenom de la personne:");
                    modif_prenom_personne = sc.nextLine();

                    System.out.println("Nom de la personne:");
                    modif_nom_personne = sc.nextLine();

                    Personne personne_modif = new Personne(modif_id_personne, modif_nom_personne, modif_prenom_personne, type_personne);
                    DAO<Personne> pers = DAO_Factory.getPersonneDAO();

                    if (pers.update(personne_modif)) {
                        System.out.println("Personne modifiée!");
                    }

                    break;

                //<---- Recherche d'un éleve--->
                case 22:

                    int id_eleve_search;
                    System.out.println("ID de l'élève recherché:");
                    id_eleve_search = sc.nextInt();

                    DAO<Eleve> eleve_search = DAO_Factory.getEleveDAO();
                    if (eleve_search.find(id_eleve_search).getId_eleve() != 0) {
                        System.out.println("Eleve trouvé!");
                        //System.out.println("Id de l'éleve:");
                        //System.out.println(eleve_search.find(id_eleve_search).getId_eleve());

                    } else {
                        System.out.println("L'éleve n'a pas été trouvé");
                    }

                    break;

                //<---- Recherche d une personne--->
                case 23:

                    int id_personne_search;
                    System.out.println("ID de la personne recherchée :");
                    id_personne_search = sc.nextInt();

                    DAO<Personne> personne_search = DAO_Factory.getPersonneDAO();
                    if (personne_search.find(id_personne_search).getId_personne() != 0) {
                        System.out.println("Personne trouvé!");
                        System.out.println("Id de la personne:");
                        System.out.println(personne_search.find(id_personne_search).getId_personne());

                    }
                    break;

                //<---- Recherche d'un enseignant--->
                case 24:
                    int id_enseignant_search;
                    System.out.println("ID de l'enseignant recherché:");
                    id_enseignant_search = sc.nextInt();

                    DAO<Enseignant> enseignant_search = DAO_Factory.getEnseignantDAO();
                    if (enseignant_search.find(id_enseignant_search).getId_enseignant() != 0) {
                        System.out.println("Enseignant trouvé!");

                    } else {
                        System.out.println("L'enseignant n'a pas été trouvé");
                    }
                    break;

                //<----Recherche de discipline---->  
                case 25:

                    int id_disc_search;
                    System.out.println("ID de la discipline cherché:");
                    id_disc_search = sc.nextInt();
                    //Discipline dscp_search = new Discipline(id_disc_search, "");
                    DAO<Discipline> discipline_search = DAO_Factory.getDisciplineDAO();
                    if (discipline_search.find(id_disc_search).getNom_discipline() != "") {
                        System.out.println("Discipline trouvée!");
                        System.out.println("Nom de la matière:");
                        System.out.println(discipline_search.find(id_disc_search).getNom_discipline());
                        System.out.println("Id de la matière:");
                        System.out.println(discipline_search.find(id_disc_search).getId_discipline());
                    }
                    break;

                //<----Affichage des disciplines---->  
                case 31:

                    HashMap<Integer, Discipline> h_dscp_all = new HashMap<Integer, Discipline>();
                    DAO<Discipline> discipline_all = DAO_Factory.getDisciplineDAO();
                    if (discipline_all.show_all().size() != 0) {
                        h_dscp_all = discipline_all.show_all();
                        for (int i : h_dscp_all.keySet()) {
                            System.out.println("Nom de la matière:" + h_dscp_all.get(i).getNom_discipline());
                            System.out.println("Id de la matière: " + h_dscp_all.get(i).getId_discipline());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage des année scolaire---->  
                case 32:

                    HashMap<Integer, Annee_scolaire> h_annee_all = new HashMap<Integer, Annee_scolaire>();
                    DAO<Annee_scolaire> annee_all = DAO_Factory.getAnneescolaireDAO();
                    if (annee_all.show_all().size() != 0) {
                        h_annee_all = annee_all.show_all();
                        for (int i : h_annee_all.keySet()) {
                            System.out.println("Id de l'annee:" + h_annee_all.get(i).getId_annee_scolaire());
                            System.out.println("Annee Scolaire:" + (h_annee_all.get(i).getId_annee_scolaire() + 2018));
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage des bulletins---->  
                case 33:

                    HashMap<Integer, Bulletin> h_bulletin_all = new HashMap<Integer, Bulletin>();
                    DAO<Bulletin> bulletin_all = DAO_Factory.getBulletinDAO();
                    if (bulletin_all.show_all().size() != 0) {
                        h_bulletin_all = bulletin_all.show_all();
                        for (int i : h_bulletin_all.keySet()) {
                            System.out.println("Id du bulletin:" + h_bulletin_all.get(i).getId_bulletin());
                            System.out.println("Id du trimestre: " + h_bulletin_all.get(i).getId_trimestre());
                            System.out.println("Id de l'élève: " + h_bulletin_all.get(i).getId_eleve());
                            System.out.println("Appreciation: " + h_bulletin_all.get(i).getAppreciation());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage des classes---->  
                case 34:

                    HashMap<Integer, Classe> h_classe_all = new HashMap<Integer, Classe>();
                    DAO<Classe> classe_all = DAO_Factory.getClasseDAO();
                    if (classe_all.show_all().size() != 0) {
                        h_classe_all = classe_all.show_all();
                        for (int i : h_classe_all.keySet()) {
                            System.out.println("Id de la classe:" + h_classe_all.get(i).getId_classe());
                            System.out.println("Id du niveau: " + h_classe_all.get(i).getId_niveau());
                            System.out.println("Annee de la classe: " + (h_classe_all.get(i).getId_Annee() + 2018));
                            System.out.println("Nom: " + h_classe_all.get(i).getNom());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage des details bulletins---->  
                case 35:

                    HashMap<Integer, Detail_bulletin> h_db_all = new HashMap<Integer, Detail_bulletin>();
                    DAO<Detail_bulletin> detail_bull_all = DAO_Factory.getDetailbulletinDAO();
                    if (detail_bull_all.show_all().size() != 0) {
                        h_db_all = detail_bull_all.show_all();
                        for (int i : h_db_all.keySet()) {
                            System.out.println("Id du détail bulletin:" + h_db_all.get(i).getId_detail_bulletin());
                            System.out.println("Id du bulletin correspondant: " + h_db_all.get(i).getId_bulletin());
                            System.out.println("Id de l'enseignant: " + h_db_all.get(i).getId_enseignant());
                            System.out.println("Appreciation: " + h_db_all.get(i).getAppreciation());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage les eleves---->
                case 36:
                    HashMap<Integer, Eleve> h_eleve_all = new HashMap<Integer, Eleve>();
                    DAO<Eleve> eleve_all = DAO_Factory.getEleveDAO();
                    if (eleve_all.show_all().size() != 0) {
                        h_eleve_all = eleve_all.show_all();
                        for (int i : h_eleve_all.keySet()) {
                            System.out.println("Id de l'élève:" + h_eleve_all.get(i).getId_eleve());
                            System.out.println("Nom de l'élève:" + h_eleve_all.get(i).getNom());
                            System.out.println("Prenom de l'élève:" + h_eleve_all.get(i).getPrenom());
                            System.out.println("Id de la classe de l'élève:" + h_eleve_all.get(i).getId_classe());
                            System.out.println("Id personne de l'élève:" + h_eleve_all.get(i).getId_personne());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage les enseignants---->
                case 37:
                    HashMap<Integer, Enseignant> h_ens_all = new HashMap<Integer, Enseignant>();
                    DAO<Enseignant> enseignant_all = DAO_Factory.getEnseignantDAO();
                    if (enseignant_all.show_all().size() != 0) {
                        h_ens_all = enseignant_all.show_all();
                        for (int i : h_ens_all.keySet()) {
                            System.out.println("Id de l'enseignant:" + h_ens_all.get(i).getId_enseignant());
                            System.out.println("Nom de l'enseignant:" + h_ens_all.get(i).getNom());
                            System.out.println("Prenom de l'enseignant:" + h_ens_all.get(i).getPrenom());
                            System.out.println("Id de la classe de l'enseignant:" + h_ens_all.get(i).getId_classe());
                            System.out.println("Id de la discipline de l'enseignant:" + h_ens_all.get(i).getId_discipline());
                            System.out.println("Id personne de l'enseignant:" + h_ens_all.get(i).getId_personne());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage les niveaux---->
                case 38:
                    HashMap<Integer, Niveau> h_niv_all = new HashMap<Integer, Niveau>();
                    DAO<Niveau> niveau_all = DAO_Factory.getNiveauDAO();
                    if (niveau_all.show_all().size() != 0) {
                        h_niv_all = niveau_all.show_all();
                        for (int i : h_niv_all.keySet()) {
                            System.out.println("Id du niveau:" + h_niv_all.get(i).getId_niveau());
                            System.out.println("Nom du niveau:" + h_niv_all.get(i).getNom());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage les notes---->
                case 39:
                    HashMap<Integer, Note> h_note_all = new HashMap<Integer, Note>();
                    DAO<Note> note_all = DAO_Factory.getNoteDAO();
                    if (note_all.show_all().size() != 0) {
                        h_note_all = note_all.show_all();
                        for (int i : h_note_all.keySet()) {
                            System.out.println("Id de la note:" + h_note_all.get(i).getId_note());
                            System.out.println("Id du détail bulletin:" + h_note_all.get(i).getId_detail_bulletin());
                            System.out.println("Appreciation:" + h_note_all.get(i).getAppreciation());
                            System.out.println("Note:" + h_note_all.get(i).getNote());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage les personnes---->
                case 40:
                    HashMap<Integer, Personne> h_pers_all = new HashMap<Integer, Personne>();
                    DAO<Personne> personne_all = DAO_Factory.getPersonneDAO();
                    if (personne_all.show_all().size() != 0) {
                        h_pers_all = personne_all.show_all();
                        for (int i : h_pers_all.keySet()) {
                            System.out.println("Id de la personne:" + h_pers_all.get(i).getId_personne());
                            System.out.println("Nom de la personne:" + h_pers_all.get(i).getNom());
                            System.out.println("Prenom de la personne:" + h_pers_all.get(i).getPrenom());
                            System.out.println("Type de la personne:" + h_pers_all.get(i).getType());
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;

                //<----Affichage les trimestres---->
                case 41:
                    HashMap<Integer, Trimestre> h_trim_all = new HashMap<Integer, Trimestre>();
                    DAO<Trimestre> trimestre_all = DAO_Factory.getTrimestreDAO();
                    if (trimestre_all.show_all().size() != 0) {
                        h_trim_all = trimestre_all.show_all();
                        for (int i : h_trim_all.keySet()) {
                            System.out.println("Numero du trimestre:" + h_trim_all.get(i).getNumero());
                            System.out.println("Id du trimestre:" + h_trim_all.get(i).getId_trimestre());
                            System.out.println("Mois de début du trimestre:" + h_trim_all.get(i).getDebut());
                            System.out.println("Mois de fin du trimestre:" + h_trim_all.get(i).getFin());
                            System.out.println("Année du trimestre:" + (h_trim_all.get(i).getId_annee() + 2018));
                            System.out.println("------------------------------------");
                        }
                    } else {
                        System.out.println("Table vide...");
                    }
                    break;
            }

        } while (choix != 50);

    }

}

