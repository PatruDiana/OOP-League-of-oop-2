package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XpAngel extends Angel implements VisitAngel {
    public XpAngel(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the XpAngel angel to the Pyromancer hero type.
     * @param p- a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        p.increaseXp(Constants.PYROMANCER_XPANGEL_XP);
    }

    /**
     * applying the XpAngel angel to the Knight hero type.
     * @param k- a Knight-type hero.
     */
    public void visit(final Knight k) {
        k.increaseXp(Constants.KNIGHT_XPANGEL_XP);
    }

    /**
     * applying the XpAngel angel to the Rogue hero type.
     * @param r- a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        r.increaseXp(Constants.ROGUE_XPANGEL_XP);
    }

    /**
     * applying the XpAngel angel to the Wizard hero type.
     * @param w- a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        w.increaseXp(Constants.WIZARD_XPANGEL_XP);
    }

    /**
     * @return  the name of the angel.
     */
    public String getName() {
        return "XPAngel";
    }

    /**
     *  @param hero - the current hero the angel helps.
     *  @return the String for output file with the appropiate message when an angel helps a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return getName() + " helped " + hero.getName() + " " + hero.getIndex();
    }
}
