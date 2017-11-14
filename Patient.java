/**
 * Classe pour les patients.
 * 
 * Dans le cadre du cours inf111, travail pratique numéro 3
 * (voir énoncé INF111 A17 tp3 partie 1 fourni).
 * 
 * @author Pierre Bélisle
 * @version Copyright A2017
 */
package clinique;

import java.io.Serializable;

public class Patient extends Participant implements Serializable{

    private static final long serialVersionUID = 1L;

    private String            nas;



    /**
     * Crée un patient avec l'identification et le numéro d'assurance social
     * fournis à l'appel.
     * 
     * @param identificationParticipant
     * @param nas
     */
    public Patient(Identification identification, String nas) {

        super(identification);
        this.nas = nas;

    }


    /**
     * @return Le numéro d'assurance social.
     */
    public String getNas() {
        return nas;
    }

    
    /**
     * @param nas
     *        Le numéro d'assurance social à utiliser.
     */
    public void setNas(String nas) {
        this.nas = nas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Patient other = (Patient) obj;
        if (this.getIdentification() == null)
            if (other.getIdentification() != null)
                return false;
            
        if (!this.getIdentification().equals(other.getIdentification()))
            return false;
        
        if(this.nas != other.nas)
            return false;
            
        return true;
    }


    @Override
    public String toString() {

        // La partie identification laissée au parent.
        return "Nom : " + this.getIdentification().getNom() + "    " + "Prénom : " + this.getIdentification().getPrenom() + "   " + "NAS : " + nas;
    }
}
