package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class ParallelAction extends Action {
    Array<Action> actions = new Array<>(4);
    private boolean complete;

    public ParallelAction() {
    }

    public ParallelAction(Action action) {
        addAction(action);
    }

    public ParallelAction(Action action, Action action2) {
        addAction(action);
        addAction(action2);
    }

    public ParallelAction(Action action, Action action2, Action action3) {
        addAction(action);
        addAction(action2);
        addAction(action3);
    }

    public ParallelAction(Action action, Action action2, Action action3, Action action4) {
        addAction(action);
        addAction(action2);
        addAction(action3);
        addAction(action4);
    }

    public ParallelAction(Action action, Action action2, Action action3, Action action4, Action action5) {
        addAction(action);
        addAction(action2);
        addAction(action3);
        addAction(action4);
        addAction(action5);
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Action
    public boolean act(float f) {
        if (this.complete) {
            return true;
        }
        this.complete = true;
        Pool pool = getPool();
        setPool(null);
        try {
            Array<Action> array = this.actions;
            int i = array.size;
            for (int i2 = 0; i2 < i && this.actor != null; i2++) {
                Action action = array.get(i2);
                if (action.getActor() != null && !action.act(f)) {
                    this.complete = false;
                }
                if (this.actor == null) {
                    return true;
                }
            }
            boolean z = this.complete;
            setPool(pool);
            return z;
        } finally {
            setPool(pool);
        }
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Action
    public void restart() {
        this.complete = false;
        Array<Action> array = this.actions;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            array.get(i2).restart();
        }
    }

    @Override // com.badlogic.gdx.utils.Pool.Poolable, com.badlogic.gdx.scenes.scene2d.Action
    public void reset() {
        super.reset();
        this.actions.clear();
    }

    public void addAction(Action action) {
        this.actions.add(action);
        if (this.actor != null) {
            action.setActor(this.actor);
        }
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Action
    public void setActor(Actor actor) {
        Array<Action> array = this.actions;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            array.get(i2).setActor(actor);
        }
        super.setActor(actor);
    }

    public Array<Action> getActions() {
        return this.actions;
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Action
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(super.toString());
        sb.append('(');
        Array<Action> array = this.actions;
        int i = array.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(array.get(i2));
        }
        sb.append(')');
        return sb.toString();
    }
}
