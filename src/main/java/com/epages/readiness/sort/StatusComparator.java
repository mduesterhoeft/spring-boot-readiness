package com.epages.readiness.sort;

import com.google.common.collect.ImmutableList;

import org.springframework.boot.actuate.health.Status;

import java.util.Comparator;
import java.util.List;

import static org.springframework.boot.actuate.health.Status.DOWN;
import static org.springframework.boot.actuate.health.Status.OUT_OF_SERVICE;
import static org.springframework.boot.actuate.health.Status.UNKNOWN;
import static org.springframework.boot.actuate.health.Status.UP;

public class StatusComparator implements Comparator<Status> {

    private final List<Status> statusOrder = ImmutableList.of(DOWN, OUT_OF_SERVICE, UNKNOWN, UP);

    @Override
    public int compare(Status first, Status second) {
        int firstIndex = this.statusOrder.indexOf(first);
        int secondIndex = this.statusOrder.indexOf(second);
        return (firstIndex < secondIndex ? -1 :
                (firstIndex == secondIndex ? first.getCode().compareTo(second.getCode()) : 1));
    }
}
