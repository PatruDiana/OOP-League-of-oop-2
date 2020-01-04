package angels;

import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class Spawner extends Angel implements VisitAngel {
    public Spawner(int coodx, int coordy) {
        super(coodx, coordy);
    }

    @Override
    public void visit(Pyromancer p) {
        System.out.println("Intra in Pyromancer");
        p.setAlive();
        p.setHpCurrentStrategy(150);
    }

    @Override
    public void visit(Knight k) {
        k.setAlive();
        k.setHpCurrentStrategy(200);
    }

    @Override
    public void visit(Rogue r) {
        r.setAlive();
        r.setHpCurrentStrategy(180);
    }

    @Override
    public void visit(Wizard w) {
        w.setAlive();
        w.setHpCurrentStrategy(120);
    }

    public String getName() {
        return "Spawner";
    }

    @Override
    public String actionangel(heroes.Hero hero) {
        return getName()+" helped " + hero.getName() + " "+  hero.getIndex();
    }
}
