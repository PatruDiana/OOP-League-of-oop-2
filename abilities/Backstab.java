package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Backstab extends Abilities implements Visitor {
    private int nrRounds;
    private float woodsModificator;
    private float backstabRogue;
    private float backstabKnight;
    private float backstabPyromancer;
    private float backstabWizard;
    Backstab() {
        damage = Constants.DAMAGE_BACKSTAB;
        nrRounds = 0;
        woodsModificator = 1;
        backstabRogue = Constants.ROGUE_MODIFICATOR_B;
        backstabKnight = Constants.KNIGHT_MODIFICATOR_B;
        backstabPyromancer = Constants.PYROMANCER_MODIFICATOR_B;
        backstabWizard = Constants.WIZARD_MODIFICATOR_B;
    }

    /**
     * update the base damage of Backstab ability as the hero's level increases.
     */
    public void setDamage() {
        damage += Constants.EXTRA_DAMAGE_BACKSTAB;
    }

    /**
     * set the race modifiers if the player chooses the offensive strategy.
     * @param percent - a percentage that will increase race coefficients.
     */
    public void setCoefOffensive(final float percent) {
        // the race modifiers change if initially they are different from 1
       if (backstabKnight != 1) {
           backstabKnight += percent;
       }
       if (backstabPyromancer != 1) {
           backstabPyromancer += percent;
       }
       if (backstabRogue != 1) {
           backstabRogue += percent;
       }
       if (backstabWizard != 1) {
           backstabWizard += percent;
       }

    }

    /**
     * set the race modifiers if the player chooses the defensive strategy.
     * @param percent - a percentage that will reduce race coefficients.
     */
    public void setCoefDefensive(final float percent) {
        // the race modifiers change if initially they are different from 1
        if (backstabKnight != 1) {
            backstabKnight -= percent;
        }
        if (backstabPyromancer != 1) {
            backstabPyromancer -= percent;
        }
        if (backstabRogue != 1) {
            backstabRogue -= percent;
        }
        if (backstabWizard != 1) {
            backstabWizard -= percent;
        }
    }

    /**
     * applying the Backstab ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol())
                    == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the land type bonus
        if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol())
                == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * backstabPyromancer;
        int dmglandrace = Math.round(damagelandrace);
        // applying the land bonus for ability
        float damagerace = woods * dmglandrace;
        int result = Math.round(damagerace);
        // decrease of the final damage from the opponent's hp
        p.setHpCurrent(result);
    }

    /**
     * applying the Backstab ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol())
                    == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the land type bonus
        if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol())
                == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * backstabKnight;
        int dmglandrace = Math.round(damagelandrace);
        // applying the land bonus for ability
        float damagerace = woods * dmglandrace;
        int result = Math.round(damagerace);
        // decrease of the final damage from the opponent's hp
        k.setHpCurrent(result);

    }

    /**
     * applying the Backstab ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol())
                    == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol())
                == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the race modifier
        float damagelandrace = damageland * backstabRogue;
        int dmglandrace = Math.round(damagelandrace);
        // applying the land bonus for ability
        float damagerace = woods * dmglandrace;
        int result = Math.round(damagerace);
        // decrease of the final damage from the opponent's hp
        r.setHpCurrent(result);

    }

    /**
     * applying the Backstab ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float woods = woodsModificator;
        float dmg = damage;
        float landBonus = landModificator;
        // the possibility of a critical hit
        if ((nrRounds % Constants.NR_ROUNDS_BACKSTAB) == 0) {
            if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol())
                    == Constants.WOODS_TYPE) {
                woods += Constants.HIT_WOODS;
            }
        }
        nrRounds++;
        // applying the lang type bonus
        if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol())
                == Constants.WOODS_TYPE) {
            landBonus += Constants.WOODS_BONUS;
        }
        dmg = dmg * landBonus;
        int damageland = Math.round(dmg);
        // applying the land bonus for ability
        float damagewood = woods * damageland;
        int dmgwood = Math.round(damagewood);
        // setting the damage received without the race modifier for the wizard hero
        w.setDamageRec(dmgwood);
        // applying the race modifier
        float damagelandrace = dmgwood * backstabWizard;
        int result = Math.round(damagelandrace);
        // decrease of the final damage from the opponent's hp
        w.setHpCurrent(result);

    }
}
