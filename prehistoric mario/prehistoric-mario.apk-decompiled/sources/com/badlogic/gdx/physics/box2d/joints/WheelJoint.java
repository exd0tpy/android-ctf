package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.World;

public class WheelJoint extends Joint {
    private final Vector2 localAnchorA = new Vector2();
    private final Vector2 localAnchorB = new Vector2();
    private final Vector2 localAxisA = new Vector2();
    private final float[] tmp = new float[2];

    private native void jniEnableMotor(long j, boolean z);

    private native float jniGetJointSpeed(long j);

    private native float jniGetJointTranslation(long j);

    private native void jniGetLocalAnchorA(long j, float[] fArr);

    private native void jniGetLocalAnchorB(long j, float[] fArr);

    private native void jniGetLocalAxisA(long j, float[] fArr);

    private native float jniGetMaxMotorTorque(long j);

    private native float jniGetMotorSpeed(long j);

    private native float jniGetMotorTorque(long j, float f);

    private native float jniGetSpringDampingRatio(long j);

    private native float jniGetSpringFrequencyHz(long j);

    private native boolean jniIsMotorEnabled(long j);

    private native void jniSetMaxMotorTorque(long j, float f);

    private native void jniSetMotorSpeed(long j, float f);

    private native void jniSetSpringDampingRatio(long j, float f);

    private native void jniSetSpringFrequencyHz(long j, float f);

    public WheelJoint(World world, long j) {
        super(world, j);
    }

    public Vector2 getLocalAnchorA() {
        jniGetLocalAnchorA(this.addr, this.tmp);
        Vector2 vector2 = this.localAnchorA;
        float[] fArr = this.tmp;
        vector2.set(fArr[0], fArr[1]);
        return this.localAnchorA;
    }

    public Vector2 getLocalAnchorB() {
        jniGetLocalAnchorB(this.addr, this.tmp);
        Vector2 vector2 = this.localAnchorB;
        float[] fArr = this.tmp;
        vector2.set(fArr[0], fArr[1]);
        return this.localAnchorB;
    }

    public Vector2 getLocalAxisA() {
        jniGetLocalAxisA(this.addr, this.tmp);
        Vector2 vector2 = this.localAxisA;
        float[] fArr = this.tmp;
        vector2.set(fArr[0], fArr[1]);
        return this.localAxisA;
    }

    public float getJointTranslation() {
        return jniGetJointTranslation(this.addr);
    }

    public float getJointSpeed() {
        return jniGetJointSpeed(this.addr);
    }

    public boolean isMotorEnabled() {
        return jniIsMotorEnabled(this.addr);
    }

    public void enableMotor(boolean z) {
        jniEnableMotor(this.addr, z);
    }

    public void setMotorSpeed(float f) {
        jniSetMotorSpeed(this.addr, f);
    }

    public float getMotorSpeed() {
        return jniGetMotorSpeed(this.addr);
    }

    public void setMaxMotorTorque(float f) {
        jniSetMaxMotorTorque(this.addr, f);
    }

    public float getMaxMotorTorque() {
        return jniGetMaxMotorTorque(this.addr);
    }

    public float getMotorTorque(float f) {
        return jniGetMotorTorque(this.addr, f);
    }

    public void setSpringFrequencyHz(float f) {
        jniSetSpringFrequencyHz(this.addr, f);
    }

    public float getSpringFrequencyHz() {
        return jniGetSpringFrequencyHz(this.addr);
    }

    public void setSpringDampingRatio(float f) {
        jniSetSpringDampingRatio(this.addr, f);
    }

    public float getSpringDampingRatio() {
        return jniGetSpringDampingRatio(this.addr);
    }
}
