/**
 * Classe pour les docteurs. 
 * 
 * Ls département peuvent être : 	 Clinique.CHIRURGIE, 
 * Clinique.UROLOGIE ou Clinique.URGENCE
 * 
 * Dans le cadre du cours inf111, travail pratique numéro 3
 * (voir énoncé INF111 A17 tp3 partie 1 fourni).
 * 
 * @author Pierre Bélisle
 * @version Copyright A2017
 */
package clinique;

import java.io.Serializable;

public class Docteur extends Participant implements Serializable{

    private static final long serialVersionUID = 1L;

    private int               numDepartement;


    /**
     * Crée un docteur avec l'identification et le numéro de
     * département fournis à l'appel.
     * 
     * @param identification
     *        Doit être non null (aucune validation).
     * @param numDepartement
     *        Le numéro qui peut être Clinique.UROLOGIE...
     * 
     */
    public Docteur(Identification unIdentification, int numDepartement) {
        
        super(unIdentification);
        this.numDepartement = numDepartement;
        
    }


    /**
     * @return Le numéro de departement.
     */
    public int getNumDepartement() {
        return numDepartement;
    }


    /**
     * @param numDepartement
     *        Le numéro de departement à utiliser.
     */
    public void setNumDepartement(int numDepartement) {
        this.numDepartement = numDepartement;
    }

    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Docteur other = (Docteur) obj;
        if (this.getIdentification() == null)
            if (other.getIdentification() != null)
                return false;
            
        if (!this.getIdentification().equals(other.getIdentification()))
            return false;
        
        if(this.numDepartement != other.numDepartement)
            return false;
            
        return true;
    }


    @Override
    public String toString() {

        // La partie identification laissée au parent.
        return "Nom : " + this.getIdentification().getNom() + "    " + "Prénom : " + this.getIdentification().getPrenom() + "   " + "Departement   :   " + Clinique.getNumDepartement2String(numDepartement);
    }
}
