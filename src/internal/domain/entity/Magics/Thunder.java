package internal.domain.entity.Magics;

import java.util.Random;

import internal.domain.entity.Magic;
import internal.domain.implement.IPlayer;
import internal.domain.vo.MagicType;
import internal.presentation.Messages;

public class Thunder extends Magic {
    private static final Random RANDOM = new Random();

    private static final String MAGIC_NAME = "サンダー";
    private static final int NEED_MP = 20;
    private static final int MIN_DAMAGE = 10;
    private static final int MAX_DAMAGE = 30;

    public Thunder() {
        super();
        initMagic(MAGIC_NAME, MagicType.ATTACK, NEED_MP);
    }

    @Override
    public void giveEffect(IPlayer user, IPlayer target) {
        int damage = RANDOM.nextInt(MAX_DAMAGE) % (MAX_DAMAGE - MIN_DAMAGE) + MIN_DAMAGE;
        user.removeMagicPoint(needMagicPoint);
        target.removeHitPoint(damage);
        Messages.showFormattedMessage(Messages.USE_MAGIC, needMagicPoint, MAGIC_NAME);
        Messages.showFormattedMessage(Messages.DAMAGE, target.getName(), damage);
    }
}
