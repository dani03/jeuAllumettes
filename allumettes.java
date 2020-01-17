public class Tp4ancienneV {
    public static int[] allumettes( int tailleTab){

        int[] nbTotalAl;
         nbTotalAl = new int[tailleTab];
        int numJoueur = 1;
         int coup = -1;
         int sommeTab;
        boolean jeuTermine = false;
        for (int i = 0; i < nbTotalAl.length; i++){
            nbTotalAl[i] = i+1;
        }
        //Terminal.ecrireStringln(" "+java.util.Arrays.toString(nbTotalAl));
        while(!jeuTermine){
            if(numJoueur != 0){
                for (int i = 0 ; i< nbTotalAl.length; i++){
                    if (nbTotalAl[i] != 0){
                            Terminal.ecrireStringln("vous pouvez jouer soit "+nbTotalAl[i]+" allumette(s) ");
                    }
                }
                Terminal.ecrireString("joueur "+numJoueur+": combien d'allumettes voulez vous retirez?: ");
                coup = Terminal.lireInt();
                Terminal.ecrireStringln("");
                //controle si l'utilisateur entre les bonnes valeur
                while(coup <=0 || coup > tailleTab){
                    Terminal.ecrireString("joueur "+numJoueur+": entrez un nbres d'allumettes entre 1 et "+tailleTab+": ");
                    coup = Terminal.lireInt();
                }
                // verifier si l'allumettes est bien presente
                for (int i = 0; i< nbTotalAl.length; i++){
                    while (coup != 0 && nbTotalAl[coup-1] == 0){
                        Terminal.ecrireString("retapez allumette(s) deja prise(s): ");
                        coup = Terminal.lireInt();
                        while(coup <=0 || coup > tailleTab){
                            Terminal.ecrireString("joueur "+numJoueur+": entrez un nbres d'allumettes entre 1 et "+tailleTab+": ");
                            coup = Terminal.lireInt();
                        }
                    }
                }
            }

            if(coup <= nbTotalAl.length){
                numJoueur = (numJoueur == 1 ? 2 : 1);
                for (int i = 0 ; i < nbTotalAl.length; i++){
                    if(coup == nbTotalAl[i]){
                        nbTotalAl[i] = 0;
                    }
                }
            }
            sommeTab = 0;
            for (int i = 0; i < nbTotalAl.length; i++){
                sommeTab += nbTotalAl[i];
            }

            if (sommeTab == 0){
                jeuTermine = true;
            }


        }
        Terminal.ecrireStringln("terminé le joueur "+numJoueur+" a perdu car il ne peut plus jouer");
        return nbTotalAl;
    }
    public static void main(String[] args) {

        Terminal.ecrireString("avec combien d'allumettes souhaitez vous jouez?: ");
        int nbAllumettes = Terminal.lireInt();
          int [] tab = allumettes(nbAllumettes);
        Terminal.ecrireStringln("notre tableau : "+java.util.Arrays.toString(tab));
    }

}
