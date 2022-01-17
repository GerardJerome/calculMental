package com.example.calculemental.model;

public enum OperationType {
    add(1 , " + "),
    substract(2," - "),
    multiply(3," x ");

    private Integer index;
    private String symbol;

    OperationType(Integer index, String symbol) {
        this.index = index;
        this.symbol=symbol;
    }


    public static  OperationType getByIndex(Integer index){
        switch (index){
            case 1 :
                return add;
            case 2 :
                return substract;
            case 3 :
                return multiply;
        }
        return null;
    }

    public String getSymbol() {
        return symbol;
    }


}
