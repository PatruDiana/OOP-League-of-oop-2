package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class GoodBoy extends Angel implements VisitAngel {
    public GoodBoy(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        for(int i = 0; i < p.getAbilities().size(); i++) {
            p.getAbilities().get(i).setCoefOffensive(0.5f);
        }
        p.setHpCurrentStrategy(p.getHpCurrent() + 30);
    }

    @Override
    public void visit(Knight k) {
        for(int i = 0; i < k.getAbilities().size(); i++) {
            k.getAbilities().get(i).setCoefOffensive(0.4f);
        }
        k.setHpCurrentStrategy(k.getHpCurrent() + 20);
    }

    @Override
    public void visit(Rogue r) {
        for (int i = 0; i < r.getAbilities().size(); i++) {
            r.getAbilities().get(i).setCoefOffensive(0.4f);
        }
        r.setHpCurrentStrategy(r.getHpCurrent() + 40);
    }

    @Override
    public void visit(Wizard w) {
        for (int i = 0; i < w.getAbilities().size(); i++) {
            w.getAbilities().get(i).setCoefOffensive(0.3f);
        }
        w.setHpCurrentStrategy(w.getHpCurrent() + 50);
    }

    @Override
    public String toString() {
        return "GoodBoy: " + coodx + ", " + coordy;
    }
    public String getName() {
        return "GoodBoy";
    }
}
