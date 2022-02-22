package internal.domain.implement;

import internal.domain.vo.AilmentType;
import internal.domain.vo.JobType;

public interface IPlayer {

    void initStaus(JobType job);

    String getName();

    void setJob(JobType job);

    JobType getJob();

    int getHitPoint();

    void addHitPoint(int hitPoint);

    void removeHitPoint(int hitPoint);

    int getMagicPoint();

    void addMagicPoint(int magicPoint);

    void removeMagicPoint(int magicPoint);

    void attack(IPlayer defender);

    int calculateDamageTaken(int strength, int luck);

    void setAilment(AilmentType ailmentType);

    AilmentType getAilment();

    int getAgility();

    void showStatus();

    boolean isLive();

    boolean isMaxHitPoint();
}
