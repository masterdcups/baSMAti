package Physical;

import java.util.ArrayList;

import static Enumerations.Constantes.*;

public class ListeCommande {
    private static ArrayList<Commande> listeOrdre;

    public ListeCommande(){
        listeOrdre = new ArrayList<Commande>();
    }

    public static void ajouterOrdre(Commande ordre){
        listeOrdre.add(ordre);
    }

    public static Commande getPremierOrdre(){
        return listeOrdre.get(0);
    }

    public static void supprimerPremierOrdre(){
        listeOrdre.remove(0);
    }

    public static boolean possedeOrdre(){
        return !listeOrdre.isEmpty();
    }

    public static String getPayloadString(String dest, String order){
        return "{\"dest\":\""+dest+"\",\"order\":\""+order+"\"}";
    }

    public static String getTopicString(String metrique){
        return "u4/302/"+metrique+"/command";
    }


    // Commandes MQTT

    // Volets

    /**
    * Envoie une demande de status des volets
     */
    public static void statusVolets(){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_STATUS));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour lever tous les volets
     */
    public static void leverTousLesVolets(){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_UP));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour baisser tous les volets
     */
    public static void baisserTousLesVolets(){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(COMMANDE_ALL, COMMANDE_VOLETS_DOWN));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour lever un volet
     * @param id nom du volet
     */
    public static void leverVolet(String id){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(id, COMMANDE_VOLETS_UP));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour baisser un volet
     * @param id nom du volet
     */
    public static void baisserVolet(String id){
        Commande comm = new Commande(getTopicString(TOPIC_VOLETS),
                getPayloadString(id, COMMANDE_VOLETS_DOWN));
        listeOrdre.add(comm);
    }

    // Lumières
    /**
     * Envoie une demande de status des lampes
     */
    public static void statusLumieres(){
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_STATUS));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour allumer les lampes
     */
    public static void allumerLumieres(){
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_ON));
        listeOrdre.add(comm);
    }

    /**
     * Envoie un ordre pour éteindre les lampes
     */
    public static void eteindreLumieres(){
        Commande comm = new Commande(getTopicString(TOPIC_LUMIERES),
                getPayloadString(COMMANDE_ALL, COMMANDE_LUMIERE_OFF));
        listeOrdre.add(comm);
    }
}
