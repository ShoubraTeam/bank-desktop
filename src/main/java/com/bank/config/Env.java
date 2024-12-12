package com.bank.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {
    private static Dotenv dotenv;

    public static Dotenv getEnv() {
        return dotenv;
    }

    public static void load() {
        dotenv = Dotenv.configure().load();
    }
}
