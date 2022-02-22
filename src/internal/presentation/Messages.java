package internal.presentation;

public class Messages {

    public static final String WAITING_INPUT_NAME = "名前を入力してください： ";
    public static final String WAITING_INPUT_JOB = "職業を選択してください";
    public static final String SELECT_JOB = "%d.%s%n";
    public static final String GENERATE_PLAYER = "プレイヤー%dを生成します%n";
    public static final String BATTLE_START = "=== バトル開始 ===";
    public static final String TURN_END = "- TURN END -";
    public static final String LINE = "---";
    public static final String INITIAL_INFO = "%s: 職業[%s], HP(%d), MP(%d), STR(%d), DEF(%d), LUCK(%d), AGI(%d)%n";
    public static final String OUT_OF_POWER = "%sは力尽きた...%n";
    public static final String WIN = "%sの勝利！！%n";
    public static final String PLAYER_INFO = "%s： HP(%d), MP(%d), 状態(%s)%n";
    public static final String ATTACK = "%sの攻撃！%n";
    public static final String CRITICAL_ATTACK = "会心の一撃！";
    public static final String DAMAGE = "%sに %d のダメージ！%n";
    public static final String NO_DAMAGE = "攻撃がミス";
    public static final String USE_MAGIC = "%dMP使って%sを唱えた！%n";
    public static final String HEAL = "%sのHPが%d回復%n";
    public static final String GIVE_AILMENT = "%sは%s状態になった！%n";
    public static final String POISON = "%sに毒のダメージ(%d)！%n";
    public static final String PARISE = "%sは体がしびれて動けない！%n";

    public static final String INPUT_WARN = "入力が不正です";

    public static final String GENERATE_PLAYER_ERROR = "プレイヤーの生成に失敗しました";

    public static void showWithNewLine(String message) {
        System.out.println(message);
    }

    public static void showWithoutNewLine(String message) {
        System.out.printf(message);
    }

    public static void showNewLine() {
        System.out.println();
    }

    public static void showFormattedMessage(String message) {
        System.out.format(message);
    }

    public static void showFormattedMessage(String message, int a) {
        System.out.format(message, a);
    }

    public static void showFormattedMessage(String message, int a, String b) {
        System.out.format(message, a, b);
    }

    public static void showFormattedMessage(String message, String a) {
        System.out.format(message, a);
    }

    public static void showFormattedMessage(String message, String a, String b) {
        System.out.format(message, a, b);
    }

    public static void showFormattedMessage(String message, String a, int b) {
        System.out.format(message, a, b);
    }

    public static void showFormattedMessage(String message, String a, int b, int c, String d) {
        System.out.format(message, a, b, c, d);
    }

    public static void showFormattedMessage(String message, String a, String b, int c, int d, int e, int f, int g,
            int h) {
        System.out.format(message, a, b, c, d, e, f, g, h);
    }
}
