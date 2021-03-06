/*
 * The MIT License
 *
 * Copyright 2016 Johannes Sarpola.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package fi.johannes.kata.ocr.core;

import fi.johannes.kata.ocr.cells.CellRow;
import fi.johannes.kata.ocr.cells.CellRows;
import fi.johannes.kata.ocr.entry.OCREntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Johannes Sarpola
 * @date Jul 1, 2016
 */
public class OCREntries {

  List<OCREntry> entries;

  OCREntries(List<OCREntry> entries) {
    this.entries = entries;
  }

  public List<OCREntry> getEntries() {
    return entries;
  }

  public static class Builder {

    /**
     * Creates the OCREntries from CellRows
     *
     * @param cellRows
     * @return
     */
    public static OCREntries build(CellRows cellRows) {
      List<OCREntry> entries = new ArrayList<>();
      Iterator<CellRow> iterator = cellRows.iterator();
      while (iterator.hasNext()) {
        CellRow cr = iterator.next();
        OCREntry entry = new OCREntry(cr);
        entries.add(entry);
      }
      OCREntries ocrentries = new OCREntries(entries);
      return ocrentries;
    }
  }

}
