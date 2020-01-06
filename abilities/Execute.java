package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Execute extends  Abilities implements Visitor {
    private float executeRogue;
    private float executeKnight;
    private float executePyromancer;
    private float executeWizard;
    public Execute() {
        damage = Constants.DAMAGE_EXECUTE;
        damageprocent = Constants.HP_LIMIT;
        executeRogue = Constants.ROGUE_MODIFICATOR_E;
        executeKnight = Constants.KNIGHT_MODIFICATOR_E;
        executePyromancer = Constants.PYROMANCER_MODIFICATOR_E;
        executeWizard = Constants.WIZARD_MODIFICATOR_E;
    }

    /**
     * update the base damage of Execute ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_EXECUTE;
        if (damageprocent < Constants.HP_MAX_LIMIT) {
            damageprocent += Constants.EXTRA_HP_LIMIT;
        }
    }

    /**
     * set the race modifiers if the player chooses the offensive strategy.
     * @param percent - a percentage that will increase race coefficients.
     */
    public void setCoefOffensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (executeKnight != 1) {
            executeKnight += percent;
        }
        if (executePyromancer != 1) {
            executePyromancer += percent;
        }
        if (executeRogue != 1) {
            executeRogue += percent;
        }
        if (executeWizard != 1) {
            executeWizard += percent;
        }
    }

    /**
     * set the race modifiers if the player chooses the defensive strategy.
     * @param percent - a percentage that will reduce race coefficients.
     */
    public void setCoefDefensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (executeKnight != 1) {
            executeKnight -= percent;
        }
        if (executePyromancer != 1) {
            executePyromancer -= percent;
        }
        if (executeRogue != 1) {
            executeRogue -= percent;
        }
        if (executeWizard != 1) {
            executeWizard -= percent;
        }

    }

    /**
     * applying the Execute ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol())
                == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * executePyromancer;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);

    }

    /**
     * applying the Execute ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol())
                == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * executeKnight;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
    }

    /**
     * applying the Execute ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol())
                == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * executeRogue;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
    }

    /**
     * applying the Execute ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol())
                == Constants.LAND_TYPE) {
            landBonus += Constants.LAND_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(damageland);
        // applying the race modifier
        float damagelandrace = executeWizard * damageland;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
    }
}
