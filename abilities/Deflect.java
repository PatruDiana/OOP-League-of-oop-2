package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Deflect extends Abilities implements Visitor {
    private float deflectRogue;
    private float deflectKnight;
    private float deflectPyromancer;
    Deflect() {
      damageprocent = Constants.PERCENT_DEFLECT;
      deflectKnight = Constants.KNIGHT_MODIFICATOR_DE;
      deflectRogue = Constants.ROQUE_MODIFICATOR_DE;
      deflectPyromancer = Constants.PYROMANCER_MODIFICATOR_DE;
    }

    /**
     * update the base damage of Deflect ability as the hero's level increases.
     */
    public void setDamage() {
        if (damageprocent < Constants.MAXIM_PERCENT_DEFLECT) {
            damageprocent += Constants.EXTRA_PERCENT_DEFLECT;
        }
        System.out.println("Noul damage procent: " + damageprocent);
    }

    /**
     * set the damage received by the Wizard for Deflect ability.
     * @param damagereceived - damage received by the Wizard.
     */
    public void setDamagereceived(final int damagereceived) {
        damage = damagereceived;
    }

    /**
     * set the race modifiers if the player chooses the offensive strategy.
     * @param percent - a percentage that will increase race coefficients.
     */
    public void setCoefOffensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (deflectRogue != 1) {
            deflectRogue += percent;
        }
        if (deflectKnight != 1) {
            deflectKnight += percent;
        }
        if (deflectPyromancer != 1) {
            deflectPyromancer += percent;
        }

    }

    /**
     * set the race modifiers if the player chooses the defensive strategy.
     * @param percent - a percentage that will reduce race coefficients.
     */
    public void setCoefDefensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (deflectRogue != 1) {
            deflectRogue -= percent;

        }
        if (deflectKnight != 1) {
            deflectKnight -= percent;

        }
        if (deflectPyromancer != 1) {
            deflectPyromancer -= percent;
        }
    }

    /**
     * applying the Deflect ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol())
                == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        float damagelandrace = dmgpercent * deflectPyromancer;
        float dmg = damagelandrace * damage;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Deflect ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol())
                == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        float damagelandrace = dmgpercent * deflectKnight;
        float dmg = damagelandrace * damage;
        int result = Math.round(dmg);
        System.out.println("Deflect :"  + result);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);
    }

    /**
     * applying the Deflect ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float dmgpercent = damageprocent;
        float landBonus = landModificator;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol())
                == Constants.DESERT_TYPE) {
            landBonus += Constants.DESERT_BONUS;
        }
        dmgpercent = dmgpercent * landBonus;
        // applying the race modifier
        float damagelandrace = dmgpercent * deflectRogue;
        float dmg =  damagelandrace * damage;
        int result = Math.round(dmg);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);
    }

    /**
     * The Deflect ability has no effect on a Wizard hero.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) { }
}
