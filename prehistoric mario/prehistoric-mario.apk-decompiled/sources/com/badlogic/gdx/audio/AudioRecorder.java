package com.badlogic.gdx.audio;

import com.badlogic.gdx.utils.Disposable;

public interface AudioRecorder extends Disposable {
    @Override // com.badlogic.gdx.utils.Disposable
    void dispose();

    void read(short[] sArr, int i, int i2);
}
