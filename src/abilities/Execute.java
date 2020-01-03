package abilities;

import common.Constants;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Execute extends  Abilities implements Visitor {
    private float ExecuteRogue = 1.15f;
    private float ExecuteKnight = 1f;
    private float ExecutePyromancer = 1.1f;
    private float ExecuteWizard = 0.8f;
    public Execute() {
        damage = Constants.DAMAGE_EXECUTE;
        damageprocent = Constants.HP_LIMIT;
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

    @Override
    public void setCoefOffensive(float coef) {
        if (ExecuteKnight != 1 ) {
            ExecuteKnight += coef;
        }
        if (ExecutePyromancer != 1) {
            ExecutePyromancer += coef;
        }
        if (ExecuteRogue != 1 ) {
            ExecuteRogue += coef;
        }
        if (ExecuteWizard != 1) {
            ExecuteWizard += coef;
        }
    }

    @Override
    public void setCoefDefensive(float coef) {
        if (ExecuteKnight != 1) {
            ExecuteKnight -= coef;
        }
        if (ExecutePyromancer != 1) {
            ExecutePyromancer -= coef;
        }
        if (ExecuteRogue != 1) {
            ExecuteRogue -= coef;
        }
        if (ExecuteWizard != 1) {
            ExecuteWizard -= coef;
        }

    }

    /**
     * applying the Execute ability to the Pyromancer hero type.
     * @param p - a Pyromancer-type hero.
     */
    public void visit(final Pyromancer p) {
        float hpLimit = damageprocent * p.getHpMax();
        int limit = Math.round(hpLimit);
        // checking the minimum life for fighting
        if (p.getHp() < limit) {
            p.setHpCurrent(p.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            // applying the lang type bonus
            if (map.Mapworld.getInstance().getlocation(p.getRow(), p.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            int damageland = Math.round(dmg);
            // applying the race modifier
            float damagelandrace = damageland * ExecutePyromancer;
            int result = Math.round(damagelandrace);
            System.out.println("Execute :"  + result);
            // decrease of the final damage from the opponent's hp
            p.setHpCurrent(result);
        }
    }

    /**
     * applying the Execute ability to the Knight hero type.
     * @param k - a Knight-type hero.
     */
    public void visit(final Knight k) {
        float hpLimit = damageprocent * k.getHpMax();
        int limit = Math.round(hpLimit);
        // checking the minimum life for fighting
        if (k.getHp() < limit) {
            k.setHpCurrent(k.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            // applying the lang type bonus
            if (map.Mapworld.getInstance().getlocation(k.getRow(), k.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            int damageland = Math.round(dmg);
            // applying the race modifier
            float damagelandrace = damageland * ExecuteKnight;
            int result = Math.round(damagelandrace);
            System.out.println("Execute :"  + result);
            // decrease of the final damage from the opponent's hp
            k.setHpCurrent(result);
        }
    }

    /**
     * applying the Execute ability to the Rogue hero type.
     * @param r - a Rogue-type hero.
     */
    public void visit(final Rogue r) {
        float hpLimit = damageprocent * r.getHpMax();
        int limit = Math.round(hpLimit);
        // checking the minimum life for fighting
        if (r.getHp() < limit) {
            r.setHpCurrent(r.getHp());
        } else {
            float dmg = damage;
            float landBonus = landModificator;
            // applying the lang type bonus
            if (map.Mapworld.getInstance().getlocation(r.getRow(), r.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            int damageland = Math.round(dmg);
            // applying the race modifier
            float damagelandrace = damageland * ExecuteRogue;
            int result = Math.round(damagelandrace);
            System.out.println("Execute :"  + result);
            // decrease of the final damage from the opponent's hp
            r.setHpCurrent(result);
        }
    }

    /**
     * applying the Execute ability to the Wizard hero type.
     * @param w - a Wizard-type hero.
     */
    public void visit(final Wizard w) {
        float hpLimit = damageprocent * w.getHpMax();
        int limit = Math.round(hpLimit);
        // checking the minimum life for fighting
//        if (w.getHp() < limit) {
//            w.setHpCurrent(w.getHp());
//        } else {
            float dmg = damage;
            float landBonus = landModificator;
            // applying the lang type bonus
            if (map.Mapworld.getInstance().getlocation(w.getRow(), w.getCol()) == Constants.LAND_TYPE) {
                landBonus += Constants.LAND_BONUS;
            }
            dmg = dmg * landBonus;
            int damageland = Math.round(dmg);
            // setting the damage received without the race modifier for the wizard hero
            w.setDamageRec(damageland);
            // applying the race modifier
            float damagelandrace = ExecuteWizard * damageland;
            int result = Math.round(damagelandrace);
            System.out.println("Execute :"  + result);
            // decrease of the final damage from the opponent's hp
            w.setHpCurrent(result);
//        }
    }
}
