package cure4j.girls;

import cure4j.util.Listream;
import cure4j.util.PrecureColor;

import java.security.SecureRandom;
import java.util.*;

public class CurePeace extends Girl.StandardGirl<CurePeace> {

    private static final Random RND = new SecureRandom();

    private static final String PIKARIN_JANKEN_MESSAGE =
                    "ピカピカピカリン\n" +
                    "ジャンケンポン！\n" +
                    "（%s）\n";

    @SuppressWarnings("unchecked")
    private static final List<String> HANDS = new Listream<>(
            Collections.nCopies(13, "グー"),
            Collections.nCopies(14, "チョキ"),
            Collections.nCopies(15, "パー"),
            Collections.nCopies(1, "グッチョッパー")
    );

    public CurePeace(Map<String, Object> config) {
        super(config);
    }

    public CurePeace smileCharge(){
        return transform();
    }

    public void pikarinJanken(){
        String message = String.format(
                PIKARIN_JANKEN_MESSAGE,
                HANDS.get(RND.nextInt(HANDS.size())));
        printByLine(message);
    }
}
