package ru.otus;

import ru.otus.proxy.ProxyTestLogging;

public class MainApp {
    public static void main(String[] args) {
        TestLoggingInterface app = ProxyTestLogging.createMyClass(new TestLoggingImplemantation());

        app.calculation(1);
        app.calculation(2, 3);
        app.calculation(4, 5, "six");
        app.print("parameter to print");
    }
}
