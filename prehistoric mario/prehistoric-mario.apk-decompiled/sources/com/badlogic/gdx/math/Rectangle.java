package com.badlogic.gdx.math;

import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.NumberUtils;
import java.io.Serializable;

public class Rectangle implements Serializable, Shape2D {
    private static final long serialVersionUID = 5733252015138115702L;
    public static final Rectangle tmp = new Rectangle();
    public static final Rectangle tmp2 = new Rectangle();
    public float height;
    public float width;
    public float x;
    public float y;

    public Rectangle() {
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public Rectangle(Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public Rectangle set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
        return this;
    }

    public float getX() {
        return this.x;
    }

    public Rectangle setX(float f) {
        this.x = f;
        return this;
    }

    public float getY() {
        return this.y;
    }

    public Rectangle setY(float f) {
        this.y = f;
        return this;
    }

    public float getWidth() {
        return this.width;
    }

    public Rectangle setWidth(float f) {
        this.width = f;
        return this;
    }

    public float getHeight() {
        return this.height;
    }

    public Rectangle setHeight(float f) {
        this.height = f;
        return this;
    }

    public Vector2 getPosition(Vector2 vector2) {
        return vector2.set(this.x, this.y);
    }

    public Rectangle setPosition(Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public Rectangle setPosition(float f, float f2) {
        this.x = f;
        this.y = f2;
        return this;
    }

    public Rectangle setSize(float f, float f2) {
        this.width = f;
        this.height = f2;
        return this;
    }

    public Rectangle setSize(float f) {
        this.width = f;
        this.height = f;
        return this;
    }

    public Vector2 getSize(Vector2 vector2) {
        return vector2.set(this.width, this.height);
    }

    @Override // com.badlogic.gdx.math.Shape2D
    public boolean contains(float f, float f2) {
        float f3 = this.x;
        if (f3 <= f && f3 + this.width >= f) {
            float f4 = this.y;
            return f4 <= f2 && f4 + this.height >= f2;
        }
    }

    @Override // com.badlogic.gdx.math.Shape2D
    public boolean contains(Vector2 vector2) {
        return contains(vector2.x, vector2.y);
    }

    public boolean contains(Circle circle) {
        return circle.x - circle.radius >= this.x && circle.x + circle.radius <= this.x + this.width && circle.y - circle.radius >= this.y && circle.y + circle.radius <= this.y + this.height;
    }

    public boolean contains(Rectangle rectangle) {
        float f = rectangle.x;
        float f2 = rectangle.width + f;
        float f3 = rectangle.y;
        float f4 = rectangle.height + f3;
        float f5 = this.x;
        if (f > f5) {
            float f6 = this.width;
            if (f < f5 + f6 && f2 > f5 && f2 < f5 + f6) {
                float f7 = this.y;
                if (f3 > f7) {
                    float f8 = this.height;
                    return f3 < f7 + f8 && f4 > f7 && f4 < f7 + f8;
                }
            }
        }
    }

    public boolean overlaps(Rectangle rectangle) {
        float f = this.x;
        float f2 = rectangle.x;
        if (f < rectangle.width + f2 && f + this.width > f2) {
            float f3 = this.y;
            float f4 = rectangle.y;
            return f3 < rectangle.height + f4 && f3 + this.height > f4;
        }
    }

    public Rectangle set(Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
        return this;
    }

    public Rectangle merge(Rectangle rectangle) {
        float min = Math.min(this.x, rectangle.x);
        float max = Math.max(this.x + this.width, rectangle.x + rectangle.width);
        this.x = min;
        this.width = max - min;
        float min2 = Math.min(this.y, rectangle.y);
        float max2 = Math.max(this.y + this.height, rectangle.y + rectangle.height);
        this.y = min2;
        this.height = max2 - min2;
        return this;
    }

    public Rectangle merge(float f, float f2) {
        float min = Math.min(this.x, f);
        float max = Math.max(this.x + this.width, f);
        this.x = min;
        this.width = max - min;
        float min2 = Math.min(this.y, f2);
        float max2 = Math.max(this.y + this.height, f2);
        this.y = min2;
        this.height = max2 - min2;
        return this;
    }

    public Rectangle merge(Vector2 vector2) {
        return merge(vector2.x, vector2.y);
    }

    public Rectangle merge(Vector2[] vector2Arr) {
        float f = this.x;
        float f2 = this.width + f;
        float f3 = this.y;
        float f4 = this.height + f3;
        for (Vector2 vector2 : vector2Arr) {
            f = Math.min(f, vector2.x);
            f2 = Math.max(f2, vector2.x);
            f3 = Math.min(f3, vector2.y);
            f4 = Math.max(f4, vector2.y);
        }
        this.x = f;
        this.width = f2 - f;
        this.y = f3;
        this.height = f4 - f3;
        return this;
    }

    public float getAspectRatio() {
        float f = this.height;
        if (f == 0.0f) {
            return Float.NaN;
        }
        return this.width / f;
    }

    public Vector2 getCenter(Vector2 vector2) {
        vector2.x = this.x + (this.width / 2.0f);
        vector2.y = this.y + (this.height / 2.0f);
        return vector2;
    }

    public Rectangle setCenter(float f, float f2) {
        setPosition(f - (this.width / 2.0f), f2 - (this.height / 2.0f));
        return this;
    }

    public Rectangle setCenter(Vector2 vector2) {
        setPosition(vector2.x - (this.width / 2.0f), vector2.y - (this.height / 2.0f));
        return this;
    }

    public Rectangle fitOutside(Rectangle rectangle) {
        float aspectRatio = getAspectRatio();
        if (aspectRatio > rectangle.getAspectRatio()) {
            float f = rectangle.height;
            setSize(aspectRatio * f, f);
        } else {
            float f2 = rectangle.width;
            setSize(f2, f2 / aspectRatio);
        }
        setPosition((rectangle.x + (rectangle.width / 2.0f)) - (this.width / 2.0f), (rectangle.y + (rectangle.height / 2.0f)) - (this.height / 2.0f));
        return this;
    }

    public Rectangle fitInside(Rectangle rectangle) {
        float aspectRatio = getAspectRatio();
        if (aspectRatio < rectangle.getAspectRatio()) {
            float f = rectangle.height;
            setSize(aspectRatio * f, f);
        } else {
            float f2 = rectangle.width;
            setSize(f2, f2 / aspectRatio);
        }
        setPosition((rectangle.x + (rectangle.width / 2.0f)) - (this.width / 2.0f), (rectangle.y + (rectangle.height / 2.0f)) - (this.height / 2.0f));
        return this;
    }

    public String toString() {
        return "[" + this.x + "," + this.y + "," + this.width + "," + this.height + "]";
    }

    public Rectangle fromString(String str) {
        int indexOf = str.indexOf(44, 1);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(44, i);
        int i2 = indexOf2 + 1;
        int indexOf3 = str.indexOf(44, i2);
        if (!(indexOf == -1 || indexOf2 == -1 || indexOf3 == -1 || str.charAt(0) != '[' || str.charAt(str.length() - 1) != ']')) {
            try {
                return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(i, indexOf2)), Float.parseFloat(str.substring(i2, indexOf3)), Float.parseFloat(str.substring(indexOf3 + 1, str.length() - 1)));
            } catch (NumberFormatException unused) {
            }
        }
        throw new GdxRuntimeException("Malformed Rectangle: " + str);
    }

    public float area() {
        return this.width * this.height;
    }

    public float perimeter() {
        return (this.width + this.height) * 2.0f;
    }

    public int hashCode() {
        return ((((((NumberUtils.floatToRawIntBits(this.height) + 31) * 31) + NumberUtils.floatToRawIntBits(this.width)) * 31) + NumberUtils.floatToRawIntBits(this.x)) * 31) + NumberUtils.floatToRawIntBits(this.y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) obj;
        return NumberUtils.floatToRawIntBits(this.height) == NumberUtils.floatToRawIntBits(rectangle.height) && NumberUtils.floatToRawIntBits(this.width) == NumberUtils.floatToRawIntBits(rectangle.width) && NumberUtils.floatToRawIntBits(this.x) == NumberUtils.floatToRawIntBits(rectangle.x) && NumberUtils.floatToRawIntBits(this.y) == NumberUtils.floatToRawIntBits(rectangle.y);
    }
}
