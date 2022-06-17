package strings;

import org.junit.Test;
import strings.ExcelRowToNumberSheet;

import static org.junit.Assert.assertEquals;

public class ExcelRowToNumberSheetTest {

    private ExcelRowToNumberSheet excelRowToNumberSheet;

    @Test(expected = ExcelRowToNumberSheet.NullInput.class)
    public void test_nullInput() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet(null);
        excelRowToNumberSheet.getRowNumber();
    }

    @Test(expected = ExcelRowToNumberSheet.NoInput.class)
    public void test_noInput() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet("");
        excelRowToNumberSheet.getRowNumber();
    }

    @Test
    public void test_getRowNumber() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet("A");
        int actual = excelRowToNumberSheet.getRowNumber();
        assertEquals(1, actual);
    }

    @Test
    public void test_getRowNumber2() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet("Z");
        int actual = excelRowToNumberSheet.getRowNumber();
        assertEquals(26, actual);
    }

    @Test
    public void test_getRowNumber3() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet("AA");
        int actual = excelRowToNumberSheet.getRowNumber();
        assertEquals(27, actual);
    }

    @Test
    public void test_getRowNumber4() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet("AZ");
        int actual = excelRowToNumberSheet.getRowNumber();
        assertEquals(52, actual);
    }

    @Test
    public void test_getRowNumber5() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet("BY");
        int actual = excelRowToNumberSheet.getRowNumber();
        assertEquals(77, actual);
    }

    @Test
    public void test_getRowNumber6() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet("BZ");
        int actual = excelRowToNumberSheet.getRowNumber();
        assertEquals(78, actual);
    }

    @Test
    public void test_getRowNumber7() {
        excelRowToNumberSheet = new ExcelRowToNumberSheet("JWY");
        int actual = excelRowToNumberSheet.getRowNumber();
        assertEquals(7383, actual);
    }
}