package com.arolla.legacy.testing.quotebot;

public enum Speed {
    SLOW(2),
    MEDIUM(4),
    FAST(8),
    ULTRAFAST(13);

    private double timeFactor;

    Speed(double timeFactor) {
        this.timeFactor = timeFactor;
    }

    double getTimeFactor() {
        return timeFactor;
    }

    static double getTimeFactor(String mode) {
        return mode.isEmpty() ? 1 : Speed.valueOf(mode).getTimeFactor();
    }

}
