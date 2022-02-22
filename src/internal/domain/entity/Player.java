package internal.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import internal.domain.implement.IMagic;
import internal.domain.implement.IPlayer;
import internal.domain.logic.GenerateHashDigest;
import internal.domain.vo.AilmentType;
import internal.domain.vo.JobType;
import internal.domain.vo.MagicType;
import internal.presentation.Messages;

public abstract class Player implements IPlayer {
    private static final GenerateHashDigest generateHashDigest = new GenerateHashDigest();
    private static final Random RANDOM = new Random();

    private static final int DEFAULT_BOUND = 100;
    private static final int CRITICAL_RANGE_START = 0;
    private static final int HALF = 50;
    private static final int MIN_HIT_POINT = 0;
    private static final int MIN_MAGIC_POINT = 0;
    private static final int MIN_DAMAGE = 0;
    private static final int START_MAGIC_INDEX = 0;

    private static final int HP_BIAS = 0;
    private static final int MP_BIAS = 1;
    private static final int STR_BIAS = 2;
    private static final int DEF_BIAS = 3;
    private static final int AGI_BIAS = 4;
    private static final int LUCK_BIAS = 5;

    private String name;
    protected JobType job;
    protected AilmentType ailment;
    protected int maxHitPoint;
    protected int hitPoint;
    protected int maxMagicPoint;
    protected int magicPoint;
    protected int strength;
    protected int defence;
    protected int agility;
    protected int luck;
    protected boolean canUseMagic;
    protected List<IMagic> magics;

    public Player(String name) {
        magics = new ArrayList<>();
        this.name = name;
        this.ailment = AilmentType.NOTHING;
    }

    @Override
    public void initStaus(JobType job) {
        setJob(job);
        this.maxHitPoint = cretateStatus(job.minHitPoint(), job.maxHitPoint(), HP_BIAS);
        this.hitPoint = maxHitPoint;
        this.maxMagicPoint = cretateStatus(job.minMagicPoint(), job.maxMagicPoint(), MP_BIAS);
        this.magicPoint = maxMagicPoint;
        this.strength = cretateStatus(job.minStrength(), job.maxStrength(), STR_BIAS);
        this.defence = cretateStatus(job.minDefence(), job.maxDefence(), DEF_BIAS);
        this.agility = cretateStatus(job.minAgility(), job.maxAgility(), AGI_BIAS);
        this.luck = cretateStatus(job.minLuck(), job.maxLuck(), LUCK_BIAS);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setJob(JobType job) {
        this.job = job;
    }

    @Override
    public JobType getJob() {
        return job;
    }

    @Override
    public int getHitPoint() {
        return hitPoint;
    }

    @Override
    public void addHitPoint(int hitPoint) {
        int result = this.hitPoint + hitPoint;
        this.hitPoint = Math.min(result, maxHitPoint);
    }

    @Override
    public void removeHitPoint(int hitPoint) {
        int result = this.hitPoint - hitPoint;
        this.hitPoint = Math.max(result, MIN_HIT_POINT);
    }

    @Override
    public int getMagicPoint() {
        return this.magicPoint;
    }

    @Override
    public void addMagicPoint(int magicPoint) {
        int result = this.magicPoint + magicPoint;
        this.magicPoint = Math.min(result, maxMagicPoint);
    }

    @Override
    public void removeMagicPoint(int magicPoint) {
        int result = this.magicPoint - magicPoint;
        this.magicPoint = Math.max(result, MIN_MAGIC_POINT);
    }

    @Override
    public void attack(IPlayer defender) {
        useMagic(defender);
    }

    @Override
    public int calculateDamageTaken(int strength, int luck) {
        int damage = strength - this.defence;
        if (isCritical(luck)) {
            damage = strength;
            Messages.showWithNewLine(Messages.CRITICAL_ATTACK);
        }

        return Math.max(damage, MIN_DAMAGE);
    }

    @Override
    public void setAilment(AilmentType ailmentType) {
        this.ailment = ailmentType;
    }

    @Override
    public AilmentType getAilment() {
        return this.ailment;
    }

    @Override
    public int getAgility() {
        return agility;
    }

    @Override
    public void showStatus() {
        Messages.showFormattedMessage(
                Messages.INITIAL_INFO,
                name,
                job.name(),
                hitPoint,
                magicPoint,
                strength,
                defence,
                luck,
                agility);
    }

    @Override
    public boolean isLive() {
        if (MIN_HIT_POINT < hitPoint) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isMaxHitPoint() {
        if (hitPoint == maxHitPoint) {
            return true;
        }
        return false;
    }

    private void useMagic(IPlayer defender) {
        Messages.showFormattedMessage(Messages.ATTACK, this.name);

        IMagic magic = selectMagic();
        if (magic != null) {
            if (magic.getMagicType() == MagicType.HEAL) {
                magic.giveEffect(this, this);
                return;
            }
            magic.giveEffect(this, defender);
            return;
        }

        int damage = defender.calculateDamageTaken(this.strength, this.luck);

        if (0 < damage) {
            defender.removeHitPoint(damage);
            Messages.showFormattedMessage(Messages.DAMAGE, defender.getName(), damage);
            return;
        }
        Messages.showWithNewLine(Messages.NO_DAMAGE);
    }

    private int cretateStatus(int minStatus, int maxStatus, int bias) {
        int status = 0;
        if (0 < minStatus && 0 < maxStatus) {
            status = generateHashDigest.generateNumber(name, bias) % (maxStatus - minStatus) + minStatus;
        }
        return status;
    }

    private IMagic selectMagic() {
        if (magics.isEmpty()) {
            return null;
        }

        Collections.shuffle(magics);
        IMagic magic = magics.get(START_MAGIC_INDEX);

        if (magic.canUseMagic(this.magicPoint)) {
            if (magic.getMagicType() == MagicType.HEAL && this.isMaxHitPoint()) {
                return null;
            }
            return magic;
        }
        return null;
    }

    private boolean isCritical(int luck) {
        int random = RANDOM.nextInt(Math.max(DEFAULT_BOUND, 0));
        if (CRITICAL_RANGE_START <= random && random < luck % HALF) {
            return true;
        }
        return false;
    }
}
