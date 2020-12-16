package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Event;

public class CountdownEventAction<T extends Event> extends EventAction<T> {
    int count;
    int current;

    public CountdownEventAction(Class<? extends T> cls, int i) {
        super(cls);
        this.count = i;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.actions.EventAction
    public boolean handle(T t) {
        this.current++;
        if (this.current >= this.count) {
            return true;
        }
        return false;
    }
}
