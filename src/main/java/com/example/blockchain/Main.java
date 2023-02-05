package com.example.blockchain;

import com.example.blockchain.cli.CLI;

public class Main {
    public static void main(String[] args) {
        CLI cli = new CLI(args);
        cli.run();
    }
}
