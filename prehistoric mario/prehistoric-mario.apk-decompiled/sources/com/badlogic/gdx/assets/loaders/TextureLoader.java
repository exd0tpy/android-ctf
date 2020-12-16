package com.badlogic.gdx.assets.loaders;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetLoaderParameters;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.utils.Array;

public class TextureLoader extends AsynchronousAssetLoader<Texture, TextureParameter> {
    TextureLoaderInfo info = new TextureLoaderInfo();

    public static class TextureLoaderInfo {
        TextureData data;
        String filename;
        Texture texture;
    }

    public static class TextureParameter extends AssetLoaderParameters<Texture> {
        public Pixmap.Format format = null;
        public boolean genMipMaps = false;
        public Texture.TextureFilter magFilter = Texture.TextureFilter.Nearest;
        public Texture.TextureFilter minFilter = Texture.TextureFilter.Nearest;
        public Texture texture = null;
        public TextureData textureData = null;
        public Texture.TextureWrap wrapU = Texture.TextureWrap.ClampToEdge;
        public Texture.TextureWrap wrapV = Texture.TextureWrap.ClampToEdge;
    }

    public Array<AssetDescriptor> getDependencies(String str, FileHandle fileHandle, TextureParameter textureParameter) {
        return null;
    }

    public TextureLoader(FileHandleResolver fileHandleResolver) {
        super(fileHandleResolver);
    }

    public void loadAsync(AssetManager assetManager, String str, FileHandle fileHandle, TextureParameter textureParameter) {
        this.info.filename = str;
        if (textureParameter == null || textureParameter.textureData == null) {
            boolean z = false;
            Pixmap.Format format = null;
            this.info.texture = null;
            if (textureParameter != null) {
                format = textureParameter.format;
                z = textureParameter.genMipMaps;
                this.info.texture = textureParameter.texture;
            }
            this.info.data = TextureData.Factory.loadFromFile(fileHandle, format, z);
        } else {
            this.info.data = textureParameter.textureData;
            this.info.texture = textureParameter.texture;
        }
        if (!this.info.data.isPrepared()) {
            this.info.data.prepare();
        }
    }

    public Texture loadSync(AssetManager assetManager, String str, FileHandle fileHandle, TextureParameter textureParameter) {
        TextureLoaderInfo textureLoaderInfo = this.info;
        if (textureLoaderInfo == null) {
            return null;
        }
        Texture texture = textureLoaderInfo.texture;
        if (texture != null) {
            texture.load(this.info.data);
        } else {
            texture = new Texture(this.info.data);
        }
        if (textureParameter != null) {
            texture.setFilter(textureParameter.minFilter, textureParameter.magFilter);
            texture.setWrap(textureParameter.wrapU, textureParameter.wrapV);
        }
        return texture;
    }
}
