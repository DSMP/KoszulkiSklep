package com.koszulki.Utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Base64;
import java.util.List;

/**
 * Created by Damian on 16.06.2017.
 */
public class MyPageWrapper<T> extends PageImpl<T> {
    private String pictureEncoded;

    public String getPictureEncoded() {
        return pictureEncoded;
    }

    public void setPictureEncoded(byte[] picture) {
        this.pictureEncoded = Base64.getEncoder().encodeToString(picture);
    }

    public MyPageWrapper(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public MyPageWrapper(List<T> content) {
        super(content);
    }
}
