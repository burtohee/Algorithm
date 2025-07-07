package agents.agent;

import java.lang.instrument.Instrumentation;

public class ObjectSizeAgent {
    private static Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long sizeOf(Object obj) {
        return instrumentation.getObjectSize(obj);
    }
}
