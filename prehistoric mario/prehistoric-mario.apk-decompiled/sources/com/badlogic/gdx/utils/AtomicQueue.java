package com.badlogic.gdx.utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicQueue<T> {
    private final AtomicReferenceArray<T> queue;
    private final AtomicInteger readIndex = new AtomicInteger();
    private final AtomicInteger writeIndex = new AtomicInteger();

    public AtomicQueue(int i) {
        this.queue = new AtomicReferenceArray<>(i);
    }

    private int next(int i) {
        return (i + 1) % this.queue.length();
    }

    public boolean put(T t) {
        int i = this.writeIndex.get();
        int i2 = this.readIndex.get();
        int next = next(i);
        if (next == i2) {
            return false;
        }
        this.queue.set(i, t);
        this.writeIndex.set(next);
        return true;
    }

    public T poll() {
        int i = this.readIndex.get();
        if (i == this.writeIndex.get()) {
            return null;
        }
        T t = this.queue.get(i);
        this.readIndex.set(next(i));
        return t;
    }
}
