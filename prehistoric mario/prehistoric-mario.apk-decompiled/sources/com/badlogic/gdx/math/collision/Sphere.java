package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Sphere implements Serializable {
    private static final float PI_4_3 = 4.1887903f;
    private static final long serialVersionUID = -6487336868908521596L;
    public final Vector3 center;
    public float radius;

    public Sphere(Vector3 vector3, float f) {
        this.center = new Vector3(vector3);
        this.radius = f;
    }

    public boolean overlaps(Sphere sphere) {
        float dst2 = this.center.dst2(sphere.center);
        float f = this.radius;
        float f2 = sphere.radius;
        return dst2 < (f + f2) * (f + f2);
    }

    public int hashCode() {
        return ((this.center.hashCode() + 71) * 71) + NumberUtils.floatToRawIntBits(this.radius);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Sphere sphere = (Sphere) obj;
        if (this.radius != sphere.radius || !this.center.equals(sphere.center)) {
            return false;
        }
        return true;
    }

    public float volume() {
        float f = this.radius;
        return PI_4_3 * f * f * f;
    }

    public float surfaceArea() {
        float f = this.radius;
        return 12.566371f * f * f;
    }
}
