/* 
 * The MIT License
 *
 * Copyright 2016 Johannes Sarpola.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fi.johannes.kata.ocr.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import org.apache.commons.io.IOUtils;

/**
  Gets files in the Resoures folder
 * @author Johannes Sarpola <johannes.sarpola at gmail.com>
 * @date Jun 30, 2016
 */
public class ResourceGetter {

    public static String getContents(String fileName) {
        String result = "";
        Reader r = getReader(fileName);
        try {
            result = IOUtils.toString(r);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Reader getReader(String fileName) {
        ClassLoader classLoader = ResourceGetter.class.getClassLoader();
        Reader r = new InputStreamReader(classLoader.getResourceAsStream(fileName));
        return r;
    }

    public static URL getUrl(String fileName) {
        ClassLoader classLoader = ResourceGetter.class.getClassLoader();
        URL url =  classLoader.getResource(fileName);
        return url;
    }
    public static String getPath(String fileName) {
        URL url =  getUrl(fileName);
        if(url.getPath().startsWith("/")) {
            return url.getPath().substring(1);
        }
        return url.getPath();
    }
}