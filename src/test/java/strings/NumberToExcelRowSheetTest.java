package strings;

import org.junit.Test;
import strings.NumberToExcelRowSheet;

import static org.junit.Assert.assertEquals;

public class NumberToExcelRowSheetTest {

    private NumberToExcelRowSheet numberToExcelRowSheet;

    @Test(expected = Test.None.class)
    public void test_initializationNumberToExcel() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(34343);
    }

    @Test(expected = NumberToExcelRowSheet.NonPositiveRowNumber.class)
    public void test_negativeNumber() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(-4);
    }

    @Test(expected = NumberToExcelRowSheet.NonPositiveRowNumber.class)
    public void test_invalidRowNumber() {
        new NumberToExcelRowSheet(0);
    }

    @Test
    public void test_singleChar1() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(1);
        String actual = numberToExcelRowSheet.getExcelColumn();
        assertEquals("A", actual);
    }

    @Test
    public void test_singleChar2() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(2);
        String actual = numberToExcelRowSheet.getExcelColumn();
        assertEquals("B", actual);
    }

    @Test
    public void test_singleChar3() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(3);
        String actual = numberToExcelRowSheet.getExcelColumn();
        assertEquals("C", actual);
    }

    @Test
    public void test_singleCharBoundary1() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(26);
        String actual = numberToExcelRowSheet.getExcelColumn();
        assertEquals("Z", actual);
    }

    @Test
    public void test_twoCharsBoundary2() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(27);
        String actual = numberToExcelRowSheet.getExcelColumn();
        assertEquals("AA", actual);
    }

    @Test
    public void test_twoChars() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(52);
        String actual = numberToExcelRowSheet.getExcelColumn();
        assertEquals("AZ", actual);
    }

    @Test
    public void test_twoChars2() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(53);
        String actual = numberToExcelRowSheet.getExcelColumn();
        assertEquals("BA", actual);
    }

    @Test
    public void test_bigNumber() {
        numberToExcelRowSheet = new NumberToExcelRowSheet(7383);
        String actual = numberToExcelRowSheet.getExcelColumn();
        assertEquals("JWY", actual);
    }
}