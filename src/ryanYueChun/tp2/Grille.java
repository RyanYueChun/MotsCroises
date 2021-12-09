package ryanYueChun.tp2;

import static java.lang.String.format;
/**
 * Représente une Grille (tableau à deux dimensions) qu'on peut remplir avec des éléments de type <b>TypeCase</b>.
 * @author ryuechun
 *
 * @param <TypeCase> le type des éléments que contiendra la Grille 
 */
public class Grille<TypeCase> {
	private final int lignes;
	private final int colonnes;
	private final TypeCase[][] tableau;
	
	/**
	 * Construire une Grille d'une <i>hauteur</i> de <b>lignes</b> et de <i>largeur</i> <b>colonnes</b>. 
	 * @param lignes hauteur de la grille
	 * @param colonnes largeur de la grille
	 */
	@SuppressWarnings("unchecked")
	public Grille (int lignes, int colonnes) {
		assert (lignes >= 0) && (colonnes >= 0);
		
		this.lignes = lignes;
		this.colonnes = colonnes;
		tableau = (TypeCase[][]) new Object[lignes][colonnes];
	}

	/**
	 * Retourner le nombre de colonnes de cette Grille.
	 * @return nombre de colonnes
	 */
	public int getLargeur() {
		return colonnes;
	}

	/**
	 * Retourner le nombre de lignes de cette Grille.
	 * @return nombre de lignes
	 */
	public int getHauteur() {
		return lignes;
	}
	
	/**
	 * Prend des coordonnées en entré et retourne : 
	 * <ul>
	 * 	<li><b>true</b> si les coordonnées se trouvent dans cette Grille,</li>
	 * 	<li><b>false</b> sinon</li>
	 * </ul>
	 * @param ligne position verticale
	 * @param colonne position horizontale
	 * @return 
	 * <ul>
	 * 	<li><b>true</b> si les coordonnées se trouvent dans cette Grille,</li>
	 * 	<li><b>false</b> sinon</li>
	 * </ul>
	 */
	public boolean coordonneesEstDansGrille(int ligne, int colonne) {
		return (1 <= ligne && ligne <= lignes) && (1 <= colonne && colonne <= colonnes);
	}
	
	/**
	 * Retourne la case qui correspond aux coordonnées fournies.
	 * @param ligne position verticale
	 * @param colonne position horizontale
	 * @return la case correspondant aux coordonnées
	 * @throws AssertionError si les coordonnées se trouvent en-dehors la Grille
	 */
	public TypeCase getCellule(int ligne, int colonne) {
		TypeCase cellule = null;
		
		if (coordonneesEstDansGrille(ligne, colonne)) {
			cellule = tableau[ligne - 1][colonne - 1];
		} else {
			throw new AssertionError(format("Les coordonnees (%s, %s) ne sont pas correctes", ligne, colonne));
		}
		
		return cellule; 
	}
	
	/**
	 * Insère l'élément <b>contenuCase</b> passé en paramètre aux coordonnées fournies.
	 * @param ligne position verticale
	 * @param colonne position horizontale
	 * @param contenuCase élément à insérer dans la Grille
	 */
	public void setCellule(int ligne, int colonne, TypeCase contenuCase) {
		if (coordonneesEstDansGrille(ligne, colonne)) {
			this.tableau[ligne - 1][colonne - 1] = contenuCase;
		} else {
			throw new AssertionError(format("Les coordonnees (%s, %s) ne sont pas correctes", ligne, colonne));
		}
	}
	
	@Override
	public String toString() {
		String sortie = "";
		
		for (int ligne = 1; ligne <= lignes; ligne++) {
			for (int colonne = 1; colonne <= colonnes; colonne++) {
				TypeCase cellule = getCellule(ligne, colonne); 
				
				sortie += (cellule == null || cellule.toString().isEmpty()) ? "??" : cellule;
				
				if (colonne != colonnes) {
					sortie += "|";
				}
			}
			
			sortie += System.lineSeparator();
		}
		
		return sortie;
	}

}
