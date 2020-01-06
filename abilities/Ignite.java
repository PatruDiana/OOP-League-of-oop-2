package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Ignite extends Abilities implements Visitor {
    private float igniteRogue;
    private float igniteKnight;
    private float ignitePyromancer;
    private float igniteWizard;
    Ignite() {
        damage = Constants.DAMAGE_IGNITE;
        damageOvertime = Constants.DAMAGE_OVERTIME_IGNITE;
        nrRoundsOvertime = Constants.NR_ROUNDS_OVERTIME_I;
        igniteRogue = Constants.ROGUE_MODIFICATOR_I;
        igniteKnight = Constants.KNIGHT_MODIFICATOR_I;
        ignitePyromancer = Constants.PYROMANCER_MODIFICATOR_I;
        igniteWizard = Constants.WIZARD_MODIFICATOR_I;
    }

    /**
     * update the base damage of Ignite ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_IGNITE;
        damageOvertime += Constants.EXTRA_DAMAGE_OVERTIME_IGNITE;
    }

    /**
     * set the race modifiers if the player chooses the offensive strategy.
     * @param percent - a percentage that will increase race coefficients.
     */
    public void setCoefOffensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (igniteKnight != 1) {
            igniteKnight += percent;
        }
        if (ignitePyromancer != 1) {
            ignitePyromancer += percent;
        }
        if (igniteRogue != 1) {
            igniteRogue += percent;
        }
        if (igniteWizard != 1) {
            igniteWizard += percent;
        }
    }

    /**
     * set the race modifiers if the player chooses the defensive strategy.
     * @param percent - a percentage that will reduce race coefficients.
     */
    public void setCoefDefensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (igniteKnight != 1) {
            igniteKnight -= percent;
        }
        if (ignitePyromancer != 1) {
            ignitePyromancer -= percent;
        }
        if (igniteRogue != 1) {
            igniteRogue -= percent;
        }
        if (igniteWizard != 1) {
            igniteWizard -= percent;
        }
    }

    /**
     * applying the Ignite ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol())
                == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        int damagewithland = Math.round(dmg);
        int damageovertimewithland = Math.round(dmgOvertime);
        // applying the race modifier
       float damagelandrace = ignitePyromancer * damagewithland;
        // set the damage overtime
        float damageovertimelandrace = ignitePyromancer * damageovertimewithland;
        int result = Math.round(damagelandrace);
        int resultOvertime = Math.round(damageovertimelandrace);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
        // setting the damage overtime on the opponent
        p.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     * applying the Ignite ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol())
                == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        int damagewithland = Math.round(dmg);
        int damageovertimewithland = Math.round(dmgOvertime);
        // applying the race modifier
        float dmglandrace = igniteKnight * damagewithland;
        // set the damage overtime
        float dmgovertimelandrace = igniteKnight * damageovertimewithland;
        int result = Math.round(dmglandrace);
        int resultOvertime = Math.round(dmgovertimelandrace);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
        // setting the damage overtime on the opponent
        k.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     * applying the Ignite ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol())
                == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        int damagewithland = Math.round(dmg);
        int damageovertimewithland = Math.round(dmgOvertime);
        // applying the race modifier
        float damagelandrace = igniteRogue * damagewithland;
        // set the damage overtime
        float damageovertimelandrace = igniteRogue * damageovertimewithland;
        int result = Math.round(damagelandrace);
        int resultOvertime = Math.round(damageovertimelandrace);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
        r.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }

    /**
     * applying the Ignite ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float dmg = damage;
        float dmgOvertime = damageOvertime;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol())
                == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(damagewithland);
        dmgOvertime = dmgOvertime * landBonus;
        int damageovertimewithland = Math.round(dmgOvertime);
        // applying the race modifier
        float damagelandrace = igniteWizard * damagewithland;
        // set the damage overtime
        float damageovertimelandrace = igniteWizard * damageovertimewithland;
        int result = Math.round(damagelandrace);
        int resultOvertime = Math.round(damageovertimelandrace);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
        // setting the damage overtime on the opponent
        w.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }
}
