package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
import java.io.Serializable;
import java.util.List;

public class BoundingBox implements Serializable {
    private static final long serialVersionUID = -1286036817192127343L;
    private static final Vector3 tmpVector = new Vector3();
    private final Vector3 cnt = new Vector3();
    private final Vector3 dim = new Vector3();
    public final Vector3 max = new Vector3();
    public final Vector3 min = new Vector3();

    static final float max(float f, float f2) {
        return f > f2 ? f : f2;
    }

    static final float min(float f, float f2) {
        return f > f2 ? f2 : f;
    }

    public Vector3 getCenter(Vector3 vector3) {
        return vector3.set(this.cnt);
    }

    public float getCenterX() {
        return this.cnt.x;
    }

    public float getCenterY() {
        return this.cnt.y;
    }

    public float getCenterZ() {
        return this.cnt.z;
    }

    public Vector3 getCorner000(Vector3 vector3) {
        return vector3.set(this.min.x, this.min.y, this.min.z);
    }

    public Vector3 getCorner001(Vector3 vector3) {
        return vector3.set(this.min.x, this.min.y, this.max.z);
    }

    public Vector3 getCorner010(Vector3 vector3) {
        return vector3.set(this.min.x, this.max.y, this.min.z);
    }

    public Vector3 getCorner011(Vector3 vector3) {
        return vector3.set(this.min.x, this.max.y, this.max.z);
    }

    public Vector3 getCorner100(Vector3 vector3) {
        return vector3.set(this.max.x, this.min.y, this.min.z);
    }

    public Vector3 getCorner101(Vector3 vector3) {
        return vector3.set(this.max.x, this.min.y, this.max.z);
    }

    public Vector3 getCorner110(Vector3 vector3) {
        return vector3.set(this.max.x, this.max.y, this.min.z);
    }

    public Vector3 getCorner111(Vector3 vector3) {
        return vector3.set(this.max.x, this.max.y, this.max.z);
    }

    public Vector3 getDimensions(Vector3 vector3) {
        return vector3.set(this.dim);
    }

    public float getWidth() {
        return this.dim.x;
    }

    public float getHeight() {
        return this.dim.y;
    }

    public float getDepth() {
        return this.dim.z;
    }

    public Vector3 getMin(Vector3 vector3) {
        return vector3.set(this.min);
    }

    public Vector3 getMax(Vector3 vector3) {
        return vector3.set(this.max);
    }

    public BoundingBox() {
        clr();
    }

    public BoundingBox(BoundingBox boundingBox) {
        set(boundingBox);
    }

    public BoundingBox(Vector3 vector3, Vector3 vector32) {
        set(vector3, vector32);
    }

    public BoundingBox set(BoundingBox boundingBox) {
        return set(boundingBox.min, boundingBox.max);
    }

    public BoundingBox set(Vector3 vector3, Vector3 vector32) {
        this.min.set(vector3.x < vector32.x ? vector3.x : vector32.x, vector3.y < vector32.y ? vector3.y : vector32.y, vector3.z < vector32.z ? vector3.z : vector32.z);
        this.max.set(vector3.x > vector32.x ? vector3.x : vector32.x, vector3.y > vector32.y ? vector3.y : vector32.y, vector3.z > vector32.z ? vector3.z : vector32.z);
        this.cnt.set(this.min).add(this.max).scl(0.5f);
        this.dim.set(this.max).sub(this.min);
        return this;
    }

    public BoundingBox set(Vector3[] vector3Arr) {
        inf();
        for (Vector3 vector3 : vector3Arr) {
            ext(vector3);
        }
        return this;
    }

    public BoundingBox set(List<Vector3> list) {
        inf();
        for (Vector3 vector3 : list) {
            ext(vector3);
        }
        return this;
    }

    public BoundingBox inf() {
        this.min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
        this.max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
        this.cnt.set(0.0f, 0.0f, 0.0f);
        this.dim.set(0.0f, 0.0f, 0.0f);
        return this;
    }

    public BoundingBox ext(Vector3 vector3) {
        Vector3 vector32 = this.min;
        Vector3 vector33 = vector32.set(min(vector32.x, vector3.x), min(this.min.y, vector3.y), min(this.min.z, vector3.z));
        Vector3 vector34 = this.max;
        return set(vector33, vector34.set(Math.max(vector34.x, vector3.x), Math.max(this.max.y, vector3.y), Math.max(this.max.z, vector3.z)));
    }

    public BoundingBox clr() {
        return set(this.min.set(0.0f, 0.0f, 0.0f), this.max.set(0.0f, 0.0f, 0.0f));
    }

    public boolean isValid() {
        return this.min.x <= this.max.x && this.min.y <= this.max.y && this.min.z <= this.max.z;
    }

    public BoundingBox ext(BoundingBox boundingBox) {
        Vector3 vector3 = this.min;
        Vector3 vector32 = vector3.set(min(vector3.x, boundingBox.min.x), min(this.min.y, boundingBox.min.y), min(this.min.z, boundingBox.min.z));
        Vector3 vector33 = this.max;
        return set(vector32, vector33.set(max(vector33.x, boundingBox.max.x), max(this.max.y, boundingBox.max.y), max(this.max.z, boundingBox.max.z)));
    }

    public BoundingBox ext(Vector3 vector3, float f) {
        Vector3 vector32 = this.min;
        Vector3 vector33 = vector32.set(min(vector32.x, vector3.x - f), min(this.min.y, vector3.y - f), min(this.min.z, vector3.z - f));
        Vector3 vector34 = this.max;
        return set(vector33, vector34.set(max(vector34.x, vector3.x + f), max(this.max.y, vector3.y + f), max(this.max.z, vector3.z + f)));
    }

    public BoundingBox ext(BoundingBox boundingBox, Matrix4 matrix4) {
        ext(tmpVector.set(boundingBox.min.x, boundingBox.min.y, boundingBox.min.z).mul(matrix4));
        ext(tmpVector.set(boundingBox.min.x, boundingBox.min.y, boundingBox.max.z).mul(matrix4));
        ext(tmpVector.set(boundingBox.min.x, boundingBox.max.y, boundingBox.min.z).mul(matrix4));
        ext(tmpVector.set(boundingBox.min.x, boundingBox.max.y, boundingBox.max.z).mul(matrix4));
        ext(tmpVector.set(boundingBox.max.x, boundingBox.min.y, boundingBox.min.z).mul(matrix4));
        ext(tmpVector.set(boundingBox.max.x, boundingBox.min.y, boundingBox.max.z).mul(matrix4));
        ext(tmpVector.set(boundingBox.max.x, boundingBox.max.y, boundingBox.min.z).mul(matrix4));
        ext(tmpVector.set(boundingBox.max.x, boundingBox.max.y, boundingBox.max.z).mul(matrix4));
        return this;
    }

    public BoundingBox mul(Matrix4 matrix4) {
        float f = this.min.x;
        float f2 = this.min.y;
        float f3 = this.min.z;
        float f4 = this.max.x;
        float f5 = this.max.y;
        float f6 = this.max.z;
        inf();
        ext(tmpVector.set(f, f2, f3).mul(matrix4));
        ext(tmpVector.set(f, f2, f6).mul(matrix4));
        ext(tmpVector.set(f, f5, f3).mul(matrix4));
        ext(tmpVector.set(f, f5, f6).mul(matrix4));
        ext(tmpVector.set(f4, f2, f3).mul(matrix4));
        ext(tmpVector.set(f4, f2, f6).mul(matrix4));
        ext(tmpVector.set(f4, f5, f3).mul(matrix4));
        ext(tmpVector.set(f4, f5, f6).mul(matrix4));
        return this;
    }

    public boolean contains(BoundingBox boundingBox) {
        return !isValid() || (this.min.x <= boundingBox.min.x && this.min.y <= boundingBox.min.y && this.min.z <= boundingBox.min.z && this.max.x >= boundingBox.max.x && this.max.y >= boundingBox.max.y && this.max.z >= boundingBox.max.z);
    }

    public boolean intersects(BoundingBox boundingBox) {
        if (!isValid()) {
            return false;
        }
        float abs = Math.abs(this.cnt.x - boundingBox.cnt.x);
        float f = (this.dim.x / 2.0f) + (boundingBox.dim.x / 2.0f);
        float abs2 = Math.abs(this.cnt.y - boundingBox.cnt.y);
        float f2 = (this.dim.y / 2.0f) + (boundingBox.dim.y / 2.0f);
        float abs3 = Math.abs(this.cnt.z - boundingBox.cnt.z);
        float f3 = (this.dim.z / 2.0f) + (boundingBox.dim.z / 2.0f);
        if (abs > f || abs2 > f2 || abs3 > f3) {
            return false;
        }
        return true;
    }

    public boolean contains(Vector3 vector3) {
        return this.min.x <= vector3.x && this.max.x >= vector3.x && this.min.y <= vector3.y && this.max.y >= vector3.y && this.min.z <= vector3.z && this.max.z >= vector3.z;
    }

    public String toString() {
        return "[" + this.min + "|" + this.max + "]";
    }

    public BoundingBox ext(float f, float f2, float f3) {
        Vector3 vector3 = this.min;
        Vector3 vector32 = vector3.set(min(vector3.x, f), min(this.min.y, f2), min(this.min.z, f3));
        Vector3 vector33 = this.max;
        return set(vector32, vector33.set(max(vector33.x, f), max(this.max.y, f2), max(this.max.z, f3)));
    }
}
