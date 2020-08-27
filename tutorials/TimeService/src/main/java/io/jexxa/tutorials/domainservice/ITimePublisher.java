package io.jexxa.tutorials.domainservice;

import java.time.LocalTime;

public interface ITimePublisher
{
    void publish(LocalTime localTime);
}
