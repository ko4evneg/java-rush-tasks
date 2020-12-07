package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.ImageTypes;
import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes z) {
        ImageReader ir = null;
        if (z == null)
            throw new IllegalArgumentException("Неизвестный тип картинки");
        switch (z) {
            case JPG:
                ir = new JpgReader();
                break;
            case BMP:
                ir = new BmpReader();
                break;
            case PNG:
                ir = new PngReader();
                break;

        }

        return ir;
    }
}

