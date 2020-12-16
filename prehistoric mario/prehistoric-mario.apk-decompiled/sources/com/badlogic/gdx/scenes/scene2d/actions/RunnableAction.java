package com.badlogic.gdx.scenes.scene2d.actions;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.utils.Pool;

public class RunnableAction extends Action {
    private boolean ran;
    private Runnable runnable;

    @Override // com.badlogic.gdx.scenes.scene2d.Action
    public boolean act(float f) {
        if (!this.ran) {
            this.ran = true;
            run();
        }
        return true;
    }

    public void run() {
        Pool pool = getPool();
        setPool(null);
        try {
            this.runnable.run();
        } finally {
            setPool(pool);
        }
    }

    @Override // com.badlogic.gdx.scenes.scene2d.Action
    public void restart() {
        this.ran = false;
    }

    @Override // com.badlogic.gdx.utils.Pool.Poolable, com.badlogic.gdx.scenes.scene2d.Action
    public void reset() {
        super.reset();
        this.runnable = null;
    }

    public Runnable getRunnable() {
        return this.runnable;
    }

    public void setRunnable(Runnable runnable2) {
        this.runnable = runnable2;
    }
}