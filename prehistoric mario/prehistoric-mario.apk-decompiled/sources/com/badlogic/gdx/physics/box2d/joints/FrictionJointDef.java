package com.badlogic.gdx.physics.box2d.joints;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.JointDef;

public class FrictionJointDef extends JointDef {
    public final Vector2 localAnchorA = new Vector2();
    public final Vector2 localAnchorB = new Vector2();
    public float maxForce = 0.0f;
    public float maxTorque = 0.0f;

    public FrictionJointDef() {
        this.type = JointDef.JointType.FrictionJoint;
    }

    public void initialize(Body body, Body body2, Vector2 vector2) {
        this.bodyA = body;
        this.bodyB = body2;
        this.localAnchorA.set(body.getLocalPoint(vector2));
        this.localAnchorB.set(body2.getLocalPoint(vector2));
    }
}
