package org.rak.doodles;

import java.util.Objects;

final class Pixel {
    private final float x;
    private final float y;
    private int index;

    public Pixel(float x, float y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Pixel o) {
            return x == o.x && y == o.y && index == o.index;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, index);
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int newIndex) {
        this.index = newIndex;
    }
}