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
package fi.johannes.kata.ocr.core.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Mockup POJO for the entries generated by OCR
 *
 * @author Johannes Sarpola <johannes.sarpola at gmail.com>
 * @date Jun 25, 2016
 */
public class ApplicationData {

    public static final char VERTICAL_BASE = '|';
    public static final char HORIZONTAL_BASE = '_';
    public static final char EMPTY = ' ';
    public static final char[] CHAR_ALTERATIONS = {VERTICAL_BASE, HORIZONTAL_BASE, EMPTY};

    private static class TetrisBlocks {

        private static final String empty = "   ";
        private static final String L = "|_ ";
        private static final String reverseL = " _|";
        private static final String ramp = "|_|";
        private static final String lineInMid = " | ";
        private static final String lineOnRight = "  |";
        private static final String lineOnLeft = "|  ";
        private static final String underscoreOnLeft = "_  ";
        private static final String underscoreInMid = " _ ";
        private static final String underscoreOnRight = "  _";
        private static final String lineOnLeftAndRight = "| |";

    }



    public static class Digits {

        private static final String ZERO = TetrisBlocks.underscoreInMid + TetrisBlocks.lineOnLeftAndRight + TetrisBlocks.ramp;
        private static final String ONE = TetrisBlocks.empty + TetrisBlocks.lineOnRight + TetrisBlocks.lineOnRight;
        private static final String TWO = TetrisBlocks.underscoreInMid + TetrisBlocks.reverseL + TetrisBlocks.L;
        private static final String THREE = TetrisBlocks.underscoreInMid + TetrisBlocks.reverseL + TetrisBlocks.reverseL;
        private static final String FOUR = TetrisBlocks.empty + TetrisBlocks.ramp + TetrisBlocks.lineOnRight;
        private static final String FIVE = TetrisBlocks.underscoreInMid + TetrisBlocks.L + TetrisBlocks.reverseL;
        private static final String SIX = TetrisBlocks.underscoreInMid + TetrisBlocks.L + TetrisBlocks.ramp;
        private static final String SEVEN = TetrisBlocks.underscoreInMid + TetrisBlocks.lineOnRight + TetrisBlocks.lineOnRight;
        private static final String EIGHT = TetrisBlocks.underscoreInMid + TetrisBlocks.ramp + TetrisBlocks.ramp;
        private static final String NINE = TetrisBlocks.underscoreInMid + TetrisBlocks.ramp + TetrisBlocks.reverseL;

        public static String Zero() {
            return ZERO;
        }

        public static String One() {
            return ONE;
        }

        public static String Two() {
            return TWO;
        }

        public static String Three() {
            return THREE;
        }

        public static String Four() {
            return FOUR;
        }

        public static String Five() {
            return FIVE;
        }

        public static String Six() {
            return SIX;
        }

        public static String Seven() {
            return SEVEN;
        }

        public static String Eight() {
            return EIGHT;
        }

        public static String Nine() {
            return NINE;
        }

        /**
         * Gets all digits in a list in order from 0 -> 9
         *
         * @return
         */
        public static List<String> getAsList() {
            List<String> list = new ArrayList<>();
            list.add(ZERO);
            list.add(ONE);
            list.add(TWO);
            list.add(THREE);
            list.add(FOUR);
            list.add(FIVE);
            list.add(SIX);
            list.add(SEVEN);
            list.add(EIGHT);
            list.add(NINE);
            return list;
        }

        /**
         * Gets digits as a Integer -> String map
         *
         * @return
         */
        public static Map<Integer, String> getAsMap() {
            List<String> list = getAsList();
            HashMap<Integer, String> map = new HashMap<>();
            Integer i = 0;
            for (String s : list) {
                map.put(i, s);
                i++;
            }
            return map;
        }
    }

}
