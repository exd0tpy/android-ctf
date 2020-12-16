package com.badlogic.gdx.scenes.scene2d.actions;

public class MoveByAction extends RelativeTemporalAction {
    private float amountX;
    private float amountY;

    /* access modifiers changed from: protected */
    @Override // com.badlogic.gdx.scenes.scene2d.actions.RelativeTemporalAction
    public void updateRelative(float f) {
        this.target.moveBy(this.amountX * f, this.amountY * f);
    }

    public void setAmount(float f, float f2) {
        this.amountX = f;
        this.amountY = f2;
    }

    public float getAmountX() {
        return this.amountX;
    }

    public void setAmountX(float f) {
        this.amountX = f;
    }

    public float getAmountY() {
        return this.amountY;
    }

    public void setAmountY(float f) {
        this.amountY = f;
    }
}
