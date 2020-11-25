package com.example.examenad;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AgendaApplication {

    private static final int NUMERO_DE_HILOS = Runtime.getRuntime().availableProcessors();

    public static final ExecutorService EjecutorDeHilos =
            Executors.newFixedThreadPool(NUMERO_DE_HILOS);
}
