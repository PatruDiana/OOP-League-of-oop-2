package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Ignite extends Abilities implements Visitor {
    private float IgniteRogue = 0.8f;
    private float IgniteKnight = 1.2f;
    private float IgnitePyromancer = 0.9f;
    private float IgniteWizard = 1.05f;
    Ignite() {
        damage = Constants.DAMAGE_IGNITE;
        damageOvertime = Constants.DAMAGE_OVERTIME_IGNITE;
        nrRoundsOvertime = Constants.NR_ROUNDS_OVERTIME_I;
    }

    /**
     * update the base damage of Ignite ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_IGNITE;
        damageOvertime += Constants.EXTRA_DAMAGE_OVERTIME_IGNITE;
    }

    @Override
    public void setCoefOffensive(float coef) {
        IgniteKnight += coef;
        IgnitePyromancer += coef;
        IgniteRogue += coef;
        IgniteWizard += coef;
    }

    @Override
    public void setCoefDefensive(float coef) {
        IgniteKnight -= coef;
        IgnitePyromancer -= coef;
        IgniteRogue -= coef;
        IgniteWizard -= coef;
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
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        int damagewithland = Math.round(dmg);
        int damageovertimewithland = Math.round(dmgOvertime);
        // applying the race modifier
       float damagelandrace = IgnitePyromancer * damagewithland;
        // set the damage overtime
        float damageovertimelandrace = IgnitePyromancer * damageovertimewithland;
        int result = Math.round(damagelandrace);
        System.out.println("Ignite: " + result);
        int resultOvertime = Math.round(damageovertimelandrace);
        System.out.println("Ignite overtime: " + resultOvertime);
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
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        int damagewithland = Math.round(dmg);
        int damageovertimewithland = Math.round(dmgOvertime);
        // applying the race modifier
        float dmglandrace = IgniteKnight * damagewithland;
        // set the damage overtime
        float dmgovertimelandrace = IgniteKnight * damageovertimewithland;
        int result = Math.round(dmglandrace);
        System.out.println("Ignite :"  + result);
        int resultOvertime = Math.round(dmgovertimelandrace);
        System.out.println("Ignite overtime: " + resultOvertime);
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
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        dmgOvertime = dmgOvertime * landBonus;
        int damagewithland = Math.round(dmg);
        int damageovertimewithland = Math.round(dmgOvertime);
        // applying the race modifier
        float damagelandrace = IgniteRogue * damagewithland;
        // set the damage overtime
        float damageovertimelandrace = IgniteRogue * damageovertimewithland;
        int result = Math.round(damagelandrace);
        System.out.println("Ignite :"  + result);
        int resultOvertime = Math.round(damageovertimelandrace);
        System.out.println("Ignite overtime: " + resultOvertime);
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
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.VOLCANIC_TYPE) {
            landBonus += Constants.VOLCANIC_BONUS;
        }
        dmg = dmg * landBonus;
        int damagewithland = Math.round(dmg);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(damagewithland);
        dmgOvertime = dmgOvertime * landBonus;
        int damageovertimewithland = Math.round(dmgOvertime);
        // applying the race modifier
        float damagelandrace = IgniteWizard * damagewithland;
        // set the damage overtime
        float damageovertimelandrace = IgniteWizard * damageovertimewithland;
        int result = Math.round(damagelandrace);
        System.out.println("Ignite: " + result);
        int resultOvertime = Math.round(damageovertimelandrace);
        System.out.println("Ignite overtime: " + resultOvertime);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);
        // setting the damage overtime on the opponent
        w.setDamageOvertime(resultOvertime, nrRoundsOvertime, false);
    }
}
