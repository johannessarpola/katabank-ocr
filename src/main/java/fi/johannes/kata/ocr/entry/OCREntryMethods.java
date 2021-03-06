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
package fi.johannes.kata.ocr.entry;

import fi.johannes.kata.ocr.checksum.Checksum;
import fi.johannes.kata.ocr.core.data.ApplicationProperties;
import fi.johannes.kata.ocr.digits.Digit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Johannes Sarpola
 * @date Jul 3, 2016
 */
class OCREntryMethods {

  /**
   * Creates alternative String representations
   *
   * @param alternative
   * @return
   */
  static String createSecondaryRepresentation(String wholeRepresentation,
      String originalDigitRepresentation, Integer alternative, Integer index) {
    StringBuilder alternativeOcrStr = new StringBuilder(wholeRepresentation);
    // Gets the String representation of Digits number
    String repr = Digit.getRepresentationForInteger(alternative);
    // Remove the old representation
    alternativeOcrStr.delete(index, originalDigitRepresentation.length() + index);
    // Insert the new one
    alternativeOcrStr.insert(index, repr);
    // Add it to alternative representations
    return alternativeOcrStr.toString();

  }

  /**
   * Creates alternative list of integers
   *
   * @param integers
   * @param index
   * @param alternative
   * @return
   */
  static List<Integer> createSecondaryIntegerList(List<Integer> integers, int index,
      Integer alternative) {
    List<Integer> ints = new ArrayList<>();
    for (int i : integers) {
      ints.add(i);
    }
    ints.set(index, alternative);
    return ints;
  }

  static Checksum buildChecksum(List<Integer> integers) {
    return new Checksum(integers, ApplicationProperties.Validation.CHECKSUM_MODULO);
  }

  static boolean isValidIntegerList(List<Integer> integers) {
    return !integers.contains(ApplicationProperties.Cells.INVALID_NUMBER);
  }
}
