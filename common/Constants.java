package common;

public final class Constants {
    private Constants() {
        //for checkstyle
    }
    public static final int LAND_TYPE = 0;
    public static final int VOLCANIC_TYPE = 1;
    public static final int DESERT_TYPE = 2;
    public static final int WOODS_TYPE = 3;
    // land bonuses
    public static final float LAND_BONUS = 0.15f;
    public static final float VOLCANIC_BONUS = 0.25f;
    public static final float DESERT_BONUS = 0.1f;
    public static final float WOODS_BONUS = 0.15f;
    // Pyromancer
    public static final int HP_PYROMANCER = 500;
    public static final int EXTRA_HP_PYROMANCER = 50;
    // Fireblast
    public static final int DAMAGE_FIREBLAST = 350;
    public static final int EXTRA_DAMAGE_FIREBLAST = 50;
    public static final float ROGUE_MODIFICATOR_F = 0.8f;
    public static final float KNIGHT_MODIFICATOR_F = 1.2f;
    public static final float PYROMANCER_MODIFICATOR_F = 0.9f;
    public static final float WIZARD_MODIFICATOR_F = 1.05f;
    // Ignite
    public static final int DAMAGE_IGNITE = 150;
    public static final int EXTRA_DAMAGE_IGNITE = 20;
    public static final int DAMAGE_OVERTIME_IGNITE = 50;
    public static final int EXTRA_DAMAGE_OVERTIME_IGNITE = 30;
    public static final int NR_ROUNDS_OVERTIME_I = 2;
    public static final float ROGUE_MODIFICATOR_I = 0.8f;
    public static final float KNIGHT_MODIFICATOR_I = 1.2f;
    public static final float PYROMANCER_MODIFICATOR_I = 0.9f;
    public static final float WIZARD_MODIFICATOR_I = 1.05f;
    // Knight
    public static final int HP_KNIGHT = 900;
    public static final int EXTRA_HP_KNIGHT = 80;
    // Execute
    public static final int DAMAGE_EXECUTE = 200;
    public static final int EXTRA_DAMAGE_EXECUTE = 30;
    public static final float HP_LIMIT = 0.2f;
    public static final float EXTRA_HP_LIMIT = 0.01f;
    public static final float HP_MAX_LIMIT = 0.4f;
    public static final float ROGUE_MODIFICATOR_E = 1.15f;
    public static final float KNIGHT_MODIFICATOR_E = 1f;
    public static final float PYROMANCER_MODIFICATOR_E = 1.1f;
    public static final float WIZARD_MODIFICATOR_E = 0.8f;
    // Slam
    public static final int DAMAGE_SLAM = 100;
    public static final int EXTRA_DAMAGE_SLAM = 40;
    public static final int NR_ROUNDS_OVERTIME_S = 1;
    public static final float ROGUE_MODIFICATOR_S = 0.8f;
    public static final float KNIGHT_MODIFICATOR_S = 1.2f;
    public static final float PYROMANCER_MODIFICATOR_S = 0.9f;
    public static final float WIZARD_MODIFICATOR_S = 1.05f;
    // Wizard
    public static final int HP_WIZARD = 400;
    public static final int EXTRA_HP_WIZARD = 30;
    // Drain
    public static final float PERCENT_DRAIN = 0.2f;
    public static final float EXTRA_PERCENT_DRAIN = 0.05f;
    public static final float HP_MIN_DRAIN = 0.3f;
    public static final float ROGUE_MODIFICATOR_DR = 0.8f;
    public static final float KNIGHT_MODIFICATOR_DR = 1.2f;
    public static final float PYROMANCER_MODIFICATOR_DR = 0.9f;
    public static final float WIZARD_MODIFICATOR_DR = 1.05f;
    // Deflect
    public static final float PERCENT_DEFLECT = 0.35f;
    public static final float EXTRA_PERCENT_DEFLECT = 0.02f;
    public static final float MAXIM_PERCENT_DEFLECT = 0.7f;
    public static final float ROQUE_MODIFICATOR_DE = 1.2f;
    public static final float KNIGHT_MODIFICATOR_DE = 1.4f;
    public static final float PYROMANCER_MODIFICATOR_DE = 1.3f;
    // Rogue
    public static final int HP_ROQUE = 600;
    public static final int EXTRA_HP_ROGUE = 40;
    //Backstab
    public static final int DAMAGE_BACKSTAB = 200;
    public static final int EXTRA_DAMAGE_BACKSTAB = 20;
    public static final int NR_ROUNDS_BACKSTAB = 3;
    public static final float HIT_WOODS = 0.5f;
    public static final float ROGUE_MODIFICATOR_B = 1.2f;
    public static final float KNIGHT_MODIFICATOR_B = 0.9f;
    public static final float PYROMANCER_MODIFICATOR_B = 1.25f;
    public static final float WIZARD_MODIFICATOR_B = 1.25f;
    // Paralysis
    public static final int DAMAGE_PARALYSIS = 40;
    public static final int EXTRA_DAMAGE_PARAYSIS = 10;
    public static final int NR_ROUNDS_OVERTIME_MIN = 3;
    public static final int NR_ROUNDS_OVERTIME_MAX = 6;
    public static final float PYROMANCER_MODIFICATOR_P = 1.2f;
    public static final float KNIGHT_MODIFICATOR_P = 0.8f;
    public static final float ROGUE_MODIFICATOR_P = 0.9f;
    public static final float WIZARD_MODIFICATOR_P = 1.25f;
    // XP update
    public static final int MAX_XP = 200;
    public static final int MULTIPLIER_XP = 40;
    public static final int XP_MIN_LEVEL = 250;
    public static final int XP_UPDATE_LEVEL = 50;
    // Damage Angel
    public static final float PYROMANCER_DAMAGEANGEL_DEF = 0.2f;
    public static final float KNIGHT_DAMAGEANGEL_DEF = 0.15f;
    public static final float ROGUE_DAMAGEANGEL_DEF = 0.3f;
    public static final float WIZARD_DAMAGEANGEL_DEF = 0.4f;
    // Dark Angel
    public static final int PYROMANCER_DARKANGEL_HP = 30;
    public static final int KNIGHT_DARKANGEL_HP = 40;
    public static final int ROGUE_DARKANGEL_HP = 10;
    public static final int WIZARD_DARKANGEL_HP = 20;
    // Dracula
    public static final float PYROMANCER_DRACULA_DEF = 0.3f;
    public static final int PYROMANCER_DRACULA_HP = 40;
    public static final float KNIGHT_DRACULA_DEF = 0.2f;
    public static final int KNIGHT_DRACULA_HP = 60;
    public static final float ROGUE_DRACULA_DEF = 0.1f;
    public static final int ROGUE_DRACULA_HP = 35;
    public static final float WIZARD_DRACULA_DEF = 0.4f;
    public static final int WIZARD_DRACULA_HP = 20;
    // GoodBoy
    public static final float PYROMANCER_GOODBOY_OFF = 0.5f;
    public static final int PYROMANCER_GOODBOY_HP = 30;
    public static final float KNIGHT_GOODBOY_OFF = 0.4f;
    public static final int KNIGHT_GOODBOY_HP = 20;
    public static final float ROGUE_GOODBOY_OFF = 0.4f;
    public static final int ROGUE_GOODBOY_HP = 40;
    public static final float WIZARD_GOODBOY_OFF = 0.3f;
    public static final int WIZARD_GOODBOY_HP = 50;
    // LevelUp Angel
    public static final float PYROMANCER_LEVELUPANGEL_OFF = 0.2f;
    public static final float KNIGHT_LEVELUPANGEL_OFF = 0.1f;
    public static final float ROGUE_LEVELUPANGEL_OFF = 0.15f;
    public static final float WIZARD_LEVELUPANGEL_OFF = 0.25f;
    // LiveGiver Angel
    public static final int PYROMANCER_LIFEGIVER_HP = 80;
    public static final int KNIGHT_LIVERGIVER_HP = 100;
    public static final int ROGUE_LIVERGIVER_HP = 90;
    public static final int WIZARD_LIVERGIVER_HP = 120;
    // SmallAngel Angel
    public static final float PYROMANCER_SMALLANGEL_OFF = 0.15f;
    public static final int PYROMANCER_SMALLANGEL_HP = 15;
    public static final float KNIGHT_SMALLANGEL_OFF = 0.1f;
    public static final int KNIGHT_SMALLANGEL_HP = 10;
    public static final float ROGUE_SMALLANGEL_OFF = 0.05f;
    public static final int ROGUE_SMALLANGEL_HP = 20;
    public static final float WIZARD_SMALLANGEL_OFF = 0.1f;
    public static final int WIZARD_SMALLANGEL_HP = 25;
    // Spawner Angel
    public static final int PYROMANCER_SPAWNER_HP = 150;
    public static final int KNIGHT_SPAWNER_HP = 200;
    public static final int ROGUE_SPAWNER_HP = 180;
    public static final int WIZARD_SPAWNER_HP = 120;
    // XpAngel Angel
    public static final int PYROMANCER_XPANGEL_XP = 50;
    public static final int KNIGHT_XPANGEL_XP = 45;
    public static final int ROGUE_XPANGEL_XP = 40;
    public static final int WIZARD_XPANGEL_XP = 60;
    // Hero
    public static final int OBSERVER_ALIVEBYANGEL = 3;
    public static final int OBSERVER_LEVELUP = 4;
    // Knight
    public static final float KNIGHT_STRATEGY1 = 1f / 3;
    public static final float KNIGHT_STRATEGY2 = 1f / 2;
    public static final float KNIGHT_DEF = 0.2f;
    public static final float KNIGHT_LIFE_DEF = 1f / 4;
    public static final float KNIGHT_OFF = 0.5f;
    public static final float KNIGHT_LIFE_OFF = 1f / 5;
    // PYROMANCER
    public static final float PYROMANCER_STRATEGY1 = 1f / 4;
    public static final float PYROMANCER_STRATEGY2 = 1f / 3;
    public static final float PYROMANCER_DEF = 0.3f;
    public static final float PYROMANCER_LIFE_DEF = 1f / 3;
    public static final float PYROMANCER_OFF = 0.7f;
    public static final float PYROMANCER_LIFE_OFF = 1f / 4;
    // ROGUE
    public static final float ROGUE_STRATEGY1 = 1f / 7;
    public static final float ROGUE_STRATEGY2 = 1f / 5;
    public static final float ROGUE_DEF = 0.1f;
    public static final float ROGUE_LIFE_DEF = 1f / 2;
    public static final float ROGUE_OFF = 0.4f;
    public static final float ROGUE_LIFE_OFF = 1f / 7;
    // WIZARD
    public static final float WIZARD_STRATEGY1 = 1f / 4;
    public static final float WIZARD_STRATEGY2 = 1f / 2;
    public static final float WIZARD_DEF = 0.2f;
    public static final float WIZARD_LIFE_DEF = 1f / 5;
    public static final float WIZARD_OFF = 0.6f;
    public static final float WIZARD_LIFE_OFF = 1f / 10;
}
