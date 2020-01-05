package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel extends Angel implements VisitAngel {
    public DamageAngel(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the DamageAngel angel to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        for (int i = 0; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefOffensive(Constants.PYROMANCER_DAMAGEANGEL_DEF);
        }
    }

    /**
     * applying the DamageAngel angel to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        for (int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefOffensive(Constants.KNIGHT_DAMAGEANGEL_DEF);
        }
    }

    /**
     * applying the DamageAngel angel to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        for (int i = 0; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefOffensive(Constants.ROGUE_DAMAGEANGEL_DEF);
        }
    }

    /**
     * applying the DamageAngel angel to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefOffensive(Constants.WIZARD_DAMAGEANGEL_DEF);
        }
    }

    /**
     * @return the name of the angel.
     */
    public String getName() {
        return "DamageAngel";
    }

    /**
     * @param hero - the current hero the angel helps.
     * @return the String for output file with the appropiate message when an angel helps a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return getName() + " helped " + hero.getName() + " " +  hero.getIndex();
    }
}
