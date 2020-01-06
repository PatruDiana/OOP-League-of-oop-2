package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Dracula extends Angel implements VisitAngel {
    public Dracula(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the Dracula angel to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        for (int i = 0; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefDefensive(Constants.PYROMANCER_DRACULA_DEF);
        }
        p.setHpCurrent(Constants.PYROMANCER_DRACULA_HP);
    }

    /**
     * applying the Dracula angel to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        for (int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefDefensive(Constants.KNIGHT_DRACULA_DEF);
        }
        k.setHpCurrent(Constants.KNIGHT_DRACULA_HP);
    }

    /**
     * applying the Dracula angel to the Rogue hero type.
     * @param r- a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        for (int i = 0; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefDefensive(Constants.ROGUE_DRACULA_DEF);
        }
        r.setHpCurrent(Constants.ROGUE_DRACULA_HP);
    }

    /**
     * applying the Dracula angel to the Wizard hero type.
     * @param w- a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefDefensive(Constants.WIZARD_DRACULA_DEF);
        }
        w.setHpCurrent(Constants.WIZARD_DRACULA_HP);
    }

    /**
     * @return the name of the angel.
     */
    public String getName() {
        return "Dracula";
    }

    /**
     * @param hero - the current hero the angel hits.
     * @return the String for output file with the appropiate message when an angel hits a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return getName() + " hit " + hero.getName() + " " + hero.getIndex();
    }
}
