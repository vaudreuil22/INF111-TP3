package clinique;



import java.io.Serializable;



/**
 * Cette classe mère permet de gérer l'identification d'un participant.
 * 
 * @author nicolas
 *
 */
public class Participant implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    // Identification du participant.
    private Identification participant;


    // ===== Constructeur ===== //

    /**
     * Constructeur par copie.
     * 
     * @param unIdentification
     *            L'identifiant du participant à copier.
     *
     * @return Copie d'un participant dans l'autre objet.
     */
    public Participant(Identification unIdentification) {

        // Copie de l'objet participant avec l'identifiant du premier.
        this.clone(unIdentification);
    }


    // ===== Get ===== //

    /**
     * La méthode retourne l'identifiant du participant.
     * 
     * @return L'identifiant du participant.
     */
    public Identification getIdentification() {

        return this.participant;
    }


    // ===== Set ===== //

    /**
     * La méthode retourne l'identifiant du participant.
     * 
     * @return L'identifiant du participant.
     */
    public void setIdentification(Identification unIdentification) {

        this.participant = unIdentification;
    }


    // ===== Méthodes ===== //

    /**
     * La méthode retourne uen chaine de caractère avec l'identification du
     * particiant qui indique son nom et son prénom.
     * 
     * @return La chaine de caractère de l'identifiant du participant.
     */
    public String toString() {

        return ("Nom :" + this.participant.getNom() + " " + "Prénom :" + this.participant.getPrenom());
    }


    /**
     * La méthode compare 2 identifiants d'un participant et retourne si ils sont égaux.
     * 
     * @param unIdentification
     *            L'identifiant du participant à comparer.
     * 
     * @return La valeur de la comparaison (True/False)
     * 
     */
    public boolean equals(Identification unIdentification) {

        // Hypothèse que la comparaison n'est pas vrai.
        boolean est_possible = false;

        if (this.participant == unIdentification) {

            est_possible = true;
        }
        else if (this.participant == null || unIdentification == null) {

            est_possible = false;
        }
        else if (this.participant.getNom() == null || unIdentification.getNom() == null) {

            est_possible = false;
        }

        else if (!this.participant.getNom().equals(unIdentification.getNom())) {

            est_possible = false;
        }
        else if (this.participant.getPrenom() == null || unIdentification.getPrenom() == null) {

            est_possible = false;
        }

        else if (!this.participant.getPrenom().equals(unIdentification.getPrenom())) {

            est_possible = false;
        }
        else {
            est_possible = true;
        }


        return est_possible;

    }
    
    public String getCategorieParticipant() {
        
        return "Participant";
    }


    /**
     * La procédure copie l'objet participant dans le second objet.
     * 
     * @param unIdentification
     *            L'identification à copier dans le participant.
     * 
     * @return Aucun
     */
    public void clone(Identification unIdentification) {

        // Copie de l'identifiant dans le participant.
        this.participant = unIdentification;

    }

}
