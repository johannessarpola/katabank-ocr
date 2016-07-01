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
package fi.johannes.kata.ocr.cells;

import java.util.List;

/**
 * Cell for the numbers, designed to be built by appending when read line by line, basically a wrapper around StringBuilder.
 * @author Johannes Sarpola <johannes.sarpola at gmail.com>
 * @date Jun 25, 2016
 */
public class Cell {
    StringBuilder cellContent;
    
    public Cell(String completeString) {
        cellContent = new StringBuilder(completeString);
    }
    public Cell(List<String> lines){
        cellContent = new StringBuilder();
        for(String line : lines) {
            cellContent.append(line);
        }
    }
    public Cell(){
        cellContent = new StringBuilder();
    }
    public void append(String stuff){
        cellContent.append(stuff);
    }
    @Override
    public String toString(){
        return cellContent.toString();
    }
    
}