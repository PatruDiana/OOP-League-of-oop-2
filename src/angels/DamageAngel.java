package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel extends Angel implements VisitAngel {
    public DamageAngel(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        for(int i = 0 ; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefOffensive(0.2f);
        }
    }

    @Override
    public void visit(Knight k) {
        for (int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefOffensive(0.15f);
        }
    }

    @Override
    public void visit(Rogue r) {
        for(int i = 0; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefOffensive(0.3f);
        }
    }

    @Override
    public void visit(Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefOffensive(0.4f);
        }
    }

    @Override
    public String toString() {
        return "DamageAngel: " + coodx + ", " + coordy;
    }
    public String getName() {
        return "DamageAngel";
    }
}
