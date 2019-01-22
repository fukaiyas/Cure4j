package test.util;

import cure4j.girls.Girl;

import java.util.ArrayList;
import java.util.List;

public class MessageTester extends Girl.MessagePrinter {

    public static final MessageTester INSTANCE = new MessageTester();

    public final List<String> messages = new ArrayList<>();

    @Override
    public void sleepAndPrintln(double sec, String message){
        messages.add(message);
    }
}
