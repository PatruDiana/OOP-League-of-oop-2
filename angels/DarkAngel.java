package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DarkAngel extends Angel implements VisitAngel {
    public DarkAngel(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the DarkAngel angel to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        p.setHpCurrent(Constants.PYROMANCER_DARKANGEL_HP);
    }

    /**
     * applying the DarkAngel angel to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        k.setHpCurrent(Constants.KNIGHT_DARKANGEL_HP);
    }

    /**
     * applying the DarkAngel angel to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        r.setHpCurrent(Constants.ROGUE_DARKANGEL_HP);
    }

    /**
     * applying the DarkAngel angel to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        w.setHpCurrent(Constants.WIZARD_DARKANGEL_HP);
    }

    /**
     * @return the name of the angel.
     */
    public String getName() {
        return "DarkAngel";
    }

    /**
     * @param hero - the current hero the angel hits.
     * @return the String for output file with the appropiate message when an angel hits a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return  getName() + " hit " + hero.getName() + " " + hero.getIndex();
    }
}
