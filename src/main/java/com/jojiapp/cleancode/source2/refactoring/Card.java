package com.jojiapp.cleancode.source2.refactoring;

public class Card {

    private final ArithmeticCard op;
    private final int id;
    private final int resourceName;

    public Card(final ArithmeticCard op, final int id, final int resourceName) {

        this.op = op;
        this.id = id;
        this.resourceName = resourceName;
    }

    public ArithmeticCard getOp() {

        return op;
    }

    public int getId() {

        return id;
    }

    public int getResourceName() {

        return resourceName;
    }
}
