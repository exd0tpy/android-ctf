package com.badlogic.gdx.graphics.g3d.decals;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.NumberUtils;

public class Decal {
    public static final int C1 = 3;
    public static final int C2 = 9;
    public static final int C3 = 15;
    public static final int C4 = 21;
    public static final int SIZE = 24;
    public static final int U1 = 4;
    public static final int U2 = 10;
    public static final int U3 = 16;
    public static final int U4 = 22;
    public static final int V1 = 5;
    public static final int V2 = 11;
    public static final int V3 = 17;
    public static final int V4 = 23;
    private static final int VERTEX_SIZE = 6;
    public static final int X1 = 0;
    public static final int X2 = 6;
    public static final int X3 = 12;
    public static final int X4 = 18;
    public static final int Y1 = 1;
    public static final int Y2 = 7;
    public static final int Y3 = 13;
    public static final int Y4 = 19;
    public static final int Z1 = 2;
    public static final int Z2 = 8;
    public static final int Z3 = 14;
    public static final int Z4 = 20;
    static final Vector3 dir = new Vector3();
    protected static Quaternion rotator = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    private static Vector3 tmp = new Vector3();
    private static Vector3 tmp2 = new Vector3();
    protected Color color;
    protected Vector2 dimensions;
    protected DecalMaterial material;
    protected Vector3 position;
    protected Quaternion rotation;
    protected Vector2 scale;
    public Vector2 transformationOffset;
    protected boolean updated;
    public int value;
    protected float[] vertices;

    public Decal() {
        this.vertices = new float[24];
        this.position = new Vector3();
        this.rotation = new Quaternion();
        this.scale = new Vector2(1.0f, 1.0f);
        this.color = new Color();
        this.transformationOffset = null;
        this.dimensions = new Vector2();
        this.updated = false;
        this.material = new DecalMaterial();
    }

    public Decal(DecalMaterial decalMaterial) {
        this.vertices = new float[24];
        this.position = new Vector3();
        this.rotation = new Quaternion();
        this.scale = new Vector2(1.0f, 1.0f);
        this.color = new Color();
        this.transformationOffset = null;
        this.dimensions = new Vector2();
        this.updated = false;
        this.material = decalMaterial;
    }

    public void setColor(float f, float f2, float f3, float f4) {
        this.color.set(f, f2, f3, f4);
        int i = ((int) (f2 * 255.0f)) << 8;
        int i2 = (int) (f * 255.0f);
        float intToFloatColor = NumberUtils.intToFloatColor(i2 | i | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 24));
        float[] fArr = this.vertices;
        fArr[3] = intToFloatColor;
        fArr[9] = intToFloatColor;
        fArr[15] = intToFloatColor;
        fArr[21] = intToFloatColor;
    }

    public void setColor(Color color2) {
        this.color.set(color2);
        float floatBits = color2.toFloatBits();
        float[] fArr = this.vertices;
        fArr[3] = floatBits;
        fArr[9] = floatBits;
        fArr[15] = floatBits;
        fArr[21] = floatBits;
    }

    public void setPackedColor(float f) {
        Color.abgr8888ToColor(this.color, f);
        float[] fArr = this.vertices;
        fArr[3] = f;
        fArr[9] = f;
        fArr[15] = f;
        fArr[21] = f;
    }

    public void setRotationX(float f) {
        this.rotation.set(Vector3.X, f);
        this.updated = false;
    }

    public void setRotationY(float f) {
        this.rotation.set(Vector3.Y, f);
        this.updated = false;
    }

    public void setRotationZ(float f) {
        this.rotation.set(Vector3.Z, f);
        this.updated = false;
    }

    public void rotateX(float f) {
        rotator.set(Vector3.X, f);
        this.rotation.mul(rotator);
        this.updated = false;
    }

    public void rotateY(float f) {
        rotator.set(Vector3.Y, f);
        this.rotation.mul(rotator);
        this.updated = false;
    }

    public void rotateZ(float f) {
        rotator.set(Vector3.Z, f);
        this.rotation.mul(rotator);
        this.updated = false;
    }

    public void setRotation(float f, float f2, float f3) {
        this.rotation.setEulerAngles(f, f2, f3);
        this.updated = false;
    }

    public void setRotation(Vector3 vector3, Vector3 vector32) {
        tmp.set(vector32).crs(vector3).nor();
        tmp2.set(vector3).crs(tmp).nor();
        this.rotation.setFromAxes(tmp.x, tmp2.x, vector3.x, tmp.y, tmp2.y, vector3.y, tmp.z, tmp2.z, vector3.z);
        this.updated = false;
    }

    public void setRotation(Quaternion quaternion) {
        this.rotation.set(quaternion);
        this.updated = false;
    }

    public Quaternion getRotation() {
        return this.rotation;
    }

    public void translateX(float f) {
        this.position.x += f;
        this.updated = false;
    }

    public void setX(float f) {
        this.position.x = f;
        this.updated = false;
    }

    public float getX() {
        return this.position.x;
    }

    public void translateY(float f) {
        this.position.y += f;
        this.updated = false;
    }

    public void setY(float f) {
        this.position.y = f;
        this.updated = false;
    }

    public float getY() {
        return this.position.y;
    }

    public void translateZ(float f) {
        this.position.z += f;
        this.updated = false;
    }

    public void setZ(float f) {
        this.position.z = f;
        this.updated = false;
    }

    public float getZ() {
        return this.position.z;
    }

    public void translate(float f, float f2, float f3) {
        this.position.add(f, f2, f3);
        this.updated = false;
    }

    public void translate(Vector3 vector3) {
        this.position.add(vector3);
        this.updated = false;
    }

    public void setPosition(float f, float f2, float f3) {
        this.position.set(f, f2, f3);
        this.updated = false;
    }

    public void setPosition(Vector3 vector3) {
        this.position.set(vector3);
        this.updated = false;
    }

    public Color getColor() {
        return this.color;
    }

    public Vector3 getPosition() {
        return this.position;
    }

    public void setScaleX(float f) {
        this.scale.x = f;
        this.updated = false;
    }

    public float getScaleX() {
        return this.scale.x;
    }

    public void setScaleY(float f) {
        this.scale.y = f;
        this.updated = false;
    }

    public float getScaleY() {
        return this.scale.y;
    }

    public void setScale(float f, float f2) {
        this.scale.set(f, f2);
        this.updated = false;
    }

    public void setScale(float f) {
        this.scale.set(f, f);
        this.updated = false;
    }

    public void setWidth(float f) {
        this.dimensions.x = f;
        this.updated = false;
    }

    public float getWidth() {
        return this.dimensions.x;
    }

    public void setHeight(float f) {
        this.dimensions.y = f;
        this.updated = false;
    }

    public float getHeight() {
        return this.dimensions.y;
    }

    public void setDimensions(float f, float f2) {
        this.dimensions.set(f, f2);
        this.updated = false;
    }

    public float[] getVertices() {
        return this.vertices;
    }

    /* access modifiers changed from: protected */
    public void update() {
        if (!this.updated) {
            resetVertices();
            transformVertices();
        }
    }

    /* access modifiers changed from: protected */
    public void transformVertices() {
        float f;
        float f2;
        Vector2 vector2 = this.transformationOffset;
        if (vector2 != null) {
            f2 = -vector2.x;
            f = -this.transformationOffset.y;
        } else {
            f2 = 0.0f;
            f = 0.0f;
        }
        float f3 = (this.vertices[0] + f2) * this.scale.x;
        float f4 = (this.vertices[1] + f) * this.scale.y;
        float[] fArr = this.vertices;
        float f5 = fArr[2];
        fArr[0] = ((this.rotation.w * f3) + (this.rotation.y * f5)) - (this.rotation.z * f4);
        this.vertices[1] = ((this.rotation.w * f4) + (this.rotation.z * f3)) - (this.rotation.x * f5);
        this.vertices[2] = ((this.rotation.w * f5) + (this.rotation.x * f4)) - (this.rotation.y * f3);
        float f6 = (((-this.rotation.x) * f3) - (this.rotation.y * f4)) - (this.rotation.z * f5);
        this.rotation.conjugate();
        float[] fArr2 = this.vertices;
        float f7 = fArr2[0];
        float f8 = fArr2[1];
        float f9 = fArr2[2];
        fArr2[0] = (((this.rotation.x * f6) + (this.rotation.w * f7)) + (this.rotation.z * f8)) - (this.rotation.y * f9);
        this.vertices[1] = (((this.rotation.y * f6) + (this.rotation.w * f8)) + (this.rotation.x * f9)) - (this.rotation.z * f7);
        this.vertices[2] = (((f6 * this.rotation.z) + (f9 * this.rotation.w)) + (f7 * this.rotation.y)) - (f8 * this.rotation.x);
        this.rotation.conjugate();
        float[] fArr3 = this.vertices;
        fArr3[0] = fArr3[0] + (this.position.x - f2);
        float[] fArr4 = this.vertices;
        fArr4[1] = fArr4[1] + (this.position.y - f);
        float[] fArr5 = this.vertices;
        fArr5[2] = fArr5[2] + this.position.z;
        float f10 = (this.vertices[6] + f2) * this.scale.x;
        float f11 = (this.vertices[7] + f) * this.scale.y;
        float[] fArr6 = this.vertices;
        float f12 = fArr6[8];
        fArr6[6] = ((this.rotation.w * f10) + (this.rotation.y * f12)) - (this.rotation.z * f11);
        this.vertices[7] = ((this.rotation.w * f11) + (this.rotation.z * f10)) - (this.rotation.x * f12);
        this.vertices[8] = ((this.rotation.w * f12) + (this.rotation.x * f11)) - (this.rotation.y * f10);
        float f13 = (((-this.rotation.x) * f10) - (this.rotation.y * f11)) - (this.rotation.z * f12);
        this.rotation.conjugate();
        float[] fArr7 = this.vertices;
        float f14 = fArr7[6];
        float f15 = fArr7[7];
        float f16 = fArr7[8];
        fArr7[6] = (((this.rotation.x * f13) + (this.rotation.w * f14)) + (this.rotation.z * f15)) - (this.rotation.y * f16);
        this.vertices[7] = (((this.rotation.y * f13) + (this.rotation.w * f15)) + (this.rotation.x * f16)) - (this.rotation.z * f14);
        this.vertices[8] = (((f13 * this.rotation.z) + (f16 * this.rotation.w)) + (f14 * this.rotation.y)) - (f15 * this.rotation.x);
        this.rotation.conjugate();
        float[] fArr8 = this.vertices;
        fArr8[6] = fArr8[6] + (this.position.x - f2);
        float[] fArr9 = this.vertices;
        fArr9[7] = fArr9[7] + (this.position.y - f);
        float[] fArr10 = this.vertices;
        fArr10[8] = fArr10[8] + this.position.z;
        float f17 = (this.vertices[12] + f2) * this.scale.x;
        float f18 = (this.vertices[13] + f) * this.scale.y;
        float[] fArr11 = this.vertices;
        float f19 = fArr11[14];
        fArr11[12] = ((this.rotation.w * f17) + (this.rotation.y * f19)) - (this.rotation.z * f18);
        this.vertices[13] = ((this.rotation.w * f18) + (this.rotation.z * f17)) - (this.rotation.x * f19);
        this.vertices[14] = ((this.rotation.w * f19) + (this.rotation.x * f18)) - (this.rotation.y * f17);
        float f20 = (((-this.rotation.x) * f17) - (this.rotation.y * f18)) - (this.rotation.z * f19);
        this.rotation.conjugate();
        float[] fArr12 = this.vertices;
        float f21 = fArr12[12];
        float f22 = fArr12[13];
        float f23 = fArr12[14];
        fArr12[12] = (((this.rotation.x * f20) + (this.rotation.w * f21)) + (this.rotation.z * f22)) - (this.rotation.y * f23);
        this.vertices[13] = (((this.rotation.y * f20) + (this.rotation.w * f22)) + (this.rotation.x * f23)) - (this.rotation.z * f21);
        this.vertices[14] = (((f20 * this.rotation.z) + (f23 * this.rotation.w)) + (f21 * this.rotation.y)) - (f22 * this.rotation.x);
        this.rotation.conjugate();
        float[] fArr13 = this.vertices;
        fArr13[12] = fArr13[12] + (this.position.x - f2);
        float[] fArr14 = this.vertices;
        fArr14[13] = fArr14[13] + (this.position.y - f);
        float[] fArr15 = this.vertices;
        fArr15[14] = fArr15[14] + this.position.z;
        float f24 = (this.vertices[18] + f2) * this.scale.x;
        float f25 = (this.vertices[19] + f) * this.scale.y;
        float[] fArr16 = this.vertices;
        float f26 = fArr16[20];
        fArr16[18] = ((this.rotation.w * f24) + (this.rotation.y * f26)) - (this.rotation.z * f25);
        this.vertices[19] = ((this.rotation.w * f25) + (this.rotation.z * f24)) - (this.rotation.x * f26);
        this.vertices[20] = ((this.rotation.w * f26) + (this.rotation.x * f25)) - (this.rotation.y * f24);
        float f27 = (((-this.rotation.x) * f24) - (this.rotation.y * f25)) - (this.rotation.z * f26);
        this.rotation.conjugate();
        float[] fArr17 = this.vertices;
        float f28 = fArr17[18];
        float f29 = fArr17[19];
        float f30 = fArr17[20];
        fArr17[18] = (((this.rotation.x * f27) + (this.rotation.w * f28)) + (this.rotation.z * f29)) - (this.rotation.y * f30);
        this.vertices[19] = (((this.rotation.y * f27) + (this.rotation.w * f29)) + (this.rotation.x * f30)) - (this.rotation.z * f28);
        this.vertices[20] = (((f27 * this.rotation.z) + (f30 * this.rotation.w)) + (f28 * this.rotation.y)) - (f29 * this.rotation.x);
        this.rotation.conjugate();
        float[] fArr18 = this.vertices;
        fArr18[18] = fArr18[18] + (this.position.x - f2);
        float[] fArr19 = this.vertices;
        fArr19[19] = fArr19[19] + (this.position.y - f);
        float[] fArr20 = this.vertices;
        fArr20[20] = fArr20[20] + this.position.z;
        this.updated = true;
    }

    /* access modifiers changed from: protected */
    public void resetVertices() {
        float f = (-this.dimensions.x) / 2.0f;
        float f2 = this.dimensions.x + f;
        float f3 = this.dimensions.y / 2.0f;
        float f4 = f3 - this.dimensions.y;
        float[] fArr = this.vertices;
        fArr[0] = f;
        fArr[1] = f3;
        fArr[2] = 0.0f;
        fArr[6] = f2;
        fArr[7] = f3;
        fArr[8] = 0.0f;
        fArr[12] = f;
        fArr[13] = f4;
        fArr[14] = 0.0f;
        fArr[18] = f2;
        fArr[19] = f4;
        fArr[20] = 0.0f;
        this.updated = false;
    }

    /* access modifiers changed from: protected */
    public void updateUVs() {
        TextureRegion textureRegion = this.material.textureRegion;
        this.vertices[4] = textureRegion.getU();
        this.vertices[5] = textureRegion.getV();
        this.vertices[10] = textureRegion.getU2();
        this.vertices[11] = textureRegion.getV();
        this.vertices[16] = textureRegion.getU();
        this.vertices[17] = textureRegion.getV2();
        this.vertices[22] = textureRegion.getU2();
        this.vertices[23] = textureRegion.getV2();
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.material.textureRegion = textureRegion;
        updateUVs();
    }

    public TextureRegion getTextureRegion() {
        return this.material.textureRegion;
    }

    public void setBlending(int i, int i2) {
        DecalMaterial decalMaterial = this.material;
        decalMaterial.srcBlendFactor = i;
        decalMaterial.dstBlendFactor = i2;
    }

    public DecalMaterial getMaterial() {
        return this.material;
    }

    public void setMaterial(DecalMaterial decalMaterial) {
        this.material = decalMaterial;
    }

    public void lookAt(Vector3 vector3, Vector3 vector32) {
        dir.set(vector3).sub(this.position).nor();
        setRotation(dir, vector32);
    }

    public static Decal newDecal(TextureRegion textureRegion) {
        return newDecal((float) textureRegion.getRegionWidth(), (float) textureRegion.getRegionHeight(), textureRegion, -1, -1);
    }

    public static Decal newDecal(TextureRegion textureRegion, boolean z) {
        float regionWidth = (float) textureRegion.getRegionWidth();
        float regionHeight = (float) textureRegion.getRegionHeight();
        int i = -1;
        int i2 = z ? GL20.GL_SRC_ALPHA : -1;
        if (z) {
            i = GL20.GL_ONE_MINUS_SRC_ALPHA;
        }
        return newDecal(regionWidth, regionHeight, textureRegion, i2, i);
    }

    public static Decal newDecal(float f, float f2, TextureRegion textureRegion) {
        return newDecal(f, f2, textureRegion, -1, -1);
    }

    public static Decal newDecal(float f, float f2, TextureRegion textureRegion, boolean z) {
        int i = -1;
        int i2 = z ? GL20.GL_SRC_ALPHA : -1;
        if (z) {
            i = GL20.GL_ONE_MINUS_SRC_ALPHA;
        }
        return newDecal(f, f2, textureRegion, i2, i);
    }

    public static Decal newDecal(float f, float f2, TextureRegion textureRegion, int i, int i2) {
        Decal decal = new Decal();
        decal.setTextureRegion(textureRegion);
        decal.setBlending(i, i2);
        Vector2 vector2 = decal.dimensions;
        vector2.x = f;
        vector2.y = f2;
        decal.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        return decal;
    }

    public static Decal newDecal(float f, float f2, TextureRegion textureRegion, int i, int i2, DecalMaterial decalMaterial) {
        Decal decal = new Decal(decalMaterial);
        decal.setTextureRegion(textureRegion);
        decal.setBlending(i, i2);
        Vector2 vector2 = decal.dimensions;
        vector2.x = f;
        vector2.y = f2;
        decal.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        return decal;
    }
}
