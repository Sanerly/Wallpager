package com.sanerly.paper.model;

/**
 * 作者：Sanerly
 * 时间；2019/3/26 16:51
 */
public class VerticalBean {
    private String thumb;
    private String img;
    private String preview;

    public String getThumb() {
        return thumb == null ? "" : thumb;
    }

    public VerticalBean setThumb(String thumb) {
        this.thumb = thumb;
        return this;
    }

    public String getImg() {
        return img == null ? "" : img;
    }

    public VerticalBean setImg(String img) {
        this.img = img;
        return this;
    }

    public String getPreview() {
        return preview == null ? "" : preview;
    }

    public VerticalBean setPreview(String preview) {
        this.preview = preview;
        return this;
    }
}
