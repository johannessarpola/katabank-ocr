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

import com.google.common.collect.ImmutableMap;
import fi.johannes.kata.ocr.cells.Cell;
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
public class Lexicons {

    public static final char VERTICAL_BASE = '|';
    public static final char HORIZONTAL_BASE = '_';

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

    public static class DigitLexiconResolver {

        private static final Map<String, Integer> MAPPED_DIGITS = ImmutableMap.<String, Integer>builder()
                .put(Digits.One(), 1)
                .put(Digits.Two(), 2)
                .put(Digits.Three(), 3)
                .put(Digits.Four(), 4)
                .put(Digits.Five(), 5)
                .put(Digits.Six(), 6)
                .put(Digits.Seven(), 7)
                .put(Digits.Eight(), 8)
                .put(Digits.Nine(), 9)
                .put(Digits.Zero(), 0).build();

        private static final Integer INVALID_NUMBER = -1;

        /**
         * 
         * Uses the static map of Digits
         * @param cell Digit cell
         * @return Integer what's represented in the Cell, or -1 if it couldn't
         * be resolved
         */
        public static Integer resolveNumber(Cell cell) {
            String cStr = cell.toString();
            if(MAPPED_DIGITS.containsKey(cStr)) {
                return MAPPED_DIGITS.get(cStr);
            } else {
                // Preferred as opposed to null as we know what are possible digits
                return INVALID_NUMBER;
            }

        }

        /**
         * Decision tree to figure out numbers from the list of cells
         *
         * @param cells Digit cells
         * @return List of Integers what's represented in the Cells, or -1 for a
         * cell if it couldn't be resolved
         */
        public static List<Integer> resolveNumbers(List<Cell> cells) {
            List<Integer> integers = new ArrayList<>();
            for (Cell cell : cells) {
                integers.add(resolveNumber(cell));
            }
            return integers;
        }
        public static List<Integer> resolveNumberPossibilities(Cell cell){
            List<Cell> permutations = resolvePermutations(cell);
            List<Integer> possibleNumbers = new ArrayList<>();
            
            // first gets added which can be invalid as well
            possibleNumbers.add(resolveNumber(cell));
            for(Cell c : permutations) {
                Integer n = resolveNumber(c);
                // No need for extra invalid numbers
                if(!n.equals(INVALID_NUMBER)) {
                    possibleNumbers.add(n);
                }
            }
            return possibleNumbers;
        }
        
        private static List<Cell> resolvePermutations(Cell cell) {
            // arr 0-8
            List<Cell> permutations = permutate(cell);
            return permutations;
        }

        private static List<Cell> permutate(Cell cell) {
            int length = cell.toString().length();
            List<Cell> validPermutations = new ArrayList<>();
            char original;
            for (int i = 0; i < length; i++) {
                try {
                    // Deep copy of original
                    Cell copyOfCell = cell.deepCopyOf();
                    // Try with vertical base
                    original = copyOfCell.swapChar(i, VERTICAL_BASE);
                    cell = checkCell(cell, original, i);
                    if (copyOfCell.doKeep() && !cell.equals(copyOfCell)) {
                        validPermutations.add(copyOfCell);
                    }

                    copyOfCell = cell.deepCopyOf();
                    // Try with horizontal
                    original = copyOfCell.swapChar(i, HORIZONTAL_BASE);
                    cell = checkCell(cell, original, i);
                    if (copyOfCell.doKeep() && !cell.equals(copyOfCell)) {
                        validPermutations.add(copyOfCell);
                    }

                } catch (Exception e) {

                }

            }
            return validPermutations;
        }

        /**
         * Checks the cell is it resolvable
         *
         * @param cell
         * @param original
         * @param position
         * @return original if it was not, altered if it was
         */
        private static Cell checkCell(Cell cell, char original, int position) {
            // Check if it's valid
            if (!resolveNumber(cell).equals(INVALID_NUMBER)) {
                cell.keep();
                return cell;
            } else {
                // Swap to original
                cell.setKeep(false);
                cell.swapChar(position, original);
            }
            return cell;
        }

        /**
         * Gets the numerical value of invalid Number
         *
         * @return
         */
        public static Integer InvalidNumber() {
            return INVALID_NUMBER;
        }

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
    // Could add alphabet too

}
