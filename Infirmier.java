/**
 * Classe pour les infirmiers.
 * 
 * Dans le cadre du cours inf111, travail pratique numéro 3
 * 
 * @author Pierre Bélisle
 * @version Copyright A2017
 */
package clinique;

import java.io.Serializable;

public class Infirmier extends Participant implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean           disponibilite;


    /**
     * Crée un infirmier avec l'identification et la disponibilite
     * fournies à l'appel.
     *
     * @param identification
     *        Doit être non null (aucune validation).
     * @param disponibilite
     */
    public Infirmier(Identification identification, boolean disponibilite) {

        super(identification);
        this.disponibilite = disponibilite;

    }


    /**
     * @return La disponibilité de l'infirmier.
     */
    public boolean getDisponibilite() {
        return disponibilite;
    }


    /**
     * @param disponibilite
     *        La disponibilite de l'infirmier à utiliser.
     */
    public void setDisponibilitet(boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Infirmier other = (Infirmier) obj;
        if (this.getIdentification() == null)
            if (other.getIdentification() != null)
                return false;
            
        if (!this.getIdentification().equals(other.getIdentification()))
            return false;
        
        if(this.disponibilite != other.disponibilite)
            return false;
            
        return true;
    }


    @Override
    public String toString() {

        // Java n'accepte pas cet opérateur ternaire avec String dans le return.
        String disponibiliteStr = (disponibilite) ? "disponible" : "non disponible";

        // La partie identification laissée au parent.
        return "Nom : " + this.getIdentification().getNom() + "    " + "Prénom : " + this.getIdentification().getPrenom() + "   "  + "Disponibilité :   " + disponibiliteStr;
    }
}
