package cure4j.girls;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import test.util.MessageTester;

public class GirlTestBase {

    protected static MessageTester messageTester = MessageTester.INSTANCE;

    @BeforeAll
    public static void 初期化(){
        Girl.sleepSec = 0;
        Girl.messagePrinter = messageTester;
    }

    @BeforeEach
    public void テストメソッド前処理(){
        messageTester.messages.clear();
    }

    @AfterAll
    public static void 後処理(){
        Girl.sleepSec = 1;
        Girl.messagePrinter = new Girl.MessagePrinter();
    }
}
