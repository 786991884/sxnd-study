package com.xubh01.factory.abstractFactory;

public interface CarFactory {
    Engine createEngine();

    Seat createSeat();

    Tyre createTyre();
}

