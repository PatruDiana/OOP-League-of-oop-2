package angels;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel implements VisitAngel {
    public LevelUpAngel(final int coodx, final int coordy) {
        super(coodx, coordy);
    }

    /**
     * applying the LeveUpAngel angel to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        for (int i = 0; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefOffensive(Constants.PYROMANCER_LEVELUPANGEL_OFF);
        }
        int levelup = p.getLevel();
        int xpLevelUp = Constants.XP_MIN_LEVEL + levelup * Constants.XP_UPDATE_LEVEL;
        p.increaseXp(xpLevelUp - p.getXp());
    }

    /**
     * applying the LeveUpAngel angel to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        for (int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefOffensive(Constants.KNIGHT_LEVELUPANGEL_OFF);
        }
        int levelup = k.getLevel();
        int xpLevelUp = Constants.XP_MIN_LEVEL + levelup * Constants.XP_UPDATE_LEVEL;
        k.increaseXp(xpLevelUp - k.getXp());
    }

    /**
     * applying the LeveUpAngel angel to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        for (int i = 0; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefOffensive(Constants.ROGUE_LEVELUPANGEL_OFF);
        }
        int levelup = r.getLevel();
        int xpLevelUp = Constants.XP_MIN_LEVEL + levelup * Constants.XP_UPDATE_LEVEL;
        r.increaseXp(xpLevelUp - r.getXp());
    }

    /**
     * applying the LeveUpAngel angel to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefOffensive(Constants.WIZARD_LEVELUPANGEL_OFF);
        }
        int levelup = w.getLevel();
        int xpLevelUp = Constants.XP_MIN_LEVEL + levelup * Constants.XP_UPDATE_LEVEL;
        w.increaseXp(xpLevelUp - w.getXp());
    }

    /**
     * @return the name of the angel.
     */
    public String getName() {
        return "LevelUpAngel";
    }

    /**
     * @param hero - the current hero the angel helps.
     * @return the String for output file with the appropiate message when an angel helps a hero.
     */
    public String actionangel(final heroes.Hero hero) {
        return getName() + " helped " + hero.getName() + " " + hero.getIndex();
    }
}
