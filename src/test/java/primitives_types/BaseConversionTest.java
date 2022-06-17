package primitives_types;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BaseConversionTest {
    private BaseConversion baseConversion;

    private String base2String_short;
    private String base2String_long;

    private String base3String_short;
    private String base3String_long;

    private String base4String_short;
    private String base4String_long;

    private String base5String_short;
    private String base5String_long;

    private String base8String_short;
    private String base8String_long;

    private String base10String_short;
    private String base10String_long;

    private String base15String_short;
    private String base15String_long;

    private String base16String_short;
    private String base16String_long;

    @Before
    public void setUp() throws Exception {
        base2String_short = "111010110111100110100010110001";
        base2String_long = "111110101011101000110010010000110100010100100011010000010010010100110100110111100010001101000101110010101111111011101110111011101111001000110101010101001101111001000011001000110100010111111101";

        base3String_short = "2112211110001000200";
        base3String_long = "10102101000012211002212120220021011211100022201222101112111220001221012000001220000212022001100120100111101111111010111011";

        base4String_short = "322313212202301";
        base4String_long = "332223220302100310110203100102110310313202031011302233323232323233020311111031321003020310113331";

        base5String_short = "4010314414241";
        base5String_long = "24413012431123103030022023423324210244401412411022300423411342034210231340001243324";

        base8String_short = "7267464261";
        base8String_long = "7653506220642443202224646742150562577356735710652515710310642775";

        base10String_short = "987654321";
        base10String_long = "6147816229662395492367752320174711361444400384690371118589";

        base15String_short = "5BA934B6";
        base15String_long = "16A625BCA7E2A62458236121E07890EE72454C6894C2728C94";

        base16String_short = "3ADE68B1";
        base16String_long = "FABA32434523412534DE2345CAFEEEEEF23554DE432345FD";
    }


    private String getConvertedBase(int base1, int base2, String inputValue) {
        baseConversion = new BaseConversion(inputValue, base1, base2);
        return baseConversion.getConvertedInProvidedBase();
    }

    private void assertBaseConversion(int base1, int base2, String inputValue, String expected) {
        String convertedBase = getConvertedBase(base1, base2, inputValue);
        assertEquals(expected, convertedBase);
    }

    @Test(expected = Test.None.class /* no exception expected */)
    public void test_InitialisationBaseConversion() {
        baseConversion = new BaseConversion(base10String_short, 10, 2);
    }

    @Test(expected = BaseConversion.NullInput.class)
    public void test_NullInput() {
        new BaseConversion(null, 2, 4);
    }

    @Test(expected = BaseConversion.NoInput.class)
    public void test_NoInput() {
        new BaseConversion("", 2, 4);
    }

    @Test(expected = BaseConversion.InputOtherThanBaseSupportedDigit.class)
    public void test_NumberIncompatibleWithBaseProvided() {
        new BaseConversion(base16String_long, 15, 4);
    }

    @Test(expected = BaseConversion.InputOtherThanBaseSupportedDigit.class)
    public void test_NumberIncompatibleWithBaseProvided2() {
        new BaseConversion(base15String_long, 14, 4);
    }

    @Test(expected = BaseConversion.InputOtherThanBaseSupportedDigit.class)
    public void test_NumberIncompatibleWithBaseProvided3() {
        new BaseConversion(base16String_short, 2, 4);
    }

    @Test(expected = BaseConversion.BaseRangeInvalid.class)
    public void test_BaseRangeLowerThanSupported() {
        new BaseConversion(base2String_short, 1, 4);
    }

    @Test(expected = BaseConversion.BaseRangeInvalid.class)
    public void test_BaseRangeHigherThanSupported() {
        new BaseConversion(base10String_short, 2, BaseConversion.MAX_BASE + 1);
    }

    @Test
    public void test_SameBaseConversion_short() {
        assertBaseConversion(5, 5, base5String_short, base5String_short);
    }

    @Test
    public void test_SameBaseConversion_long() {
        assertBaseConversion(5, 5, base5String_long, base5String_long);
    }

    @Test
    public void test_Base5toBase10Conversion_short() {
        assertBaseConversion(5, 10, base5String_short, base10String_short);
    }

    @Test
    public void test_Base5toBase10Conversion_long() {
        assertBaseConversion(5, 10, base5String_long, base10String_long);
    }

    @Test
    public void test_Base10toBase5Conversion_short() {
        assertBaseConversion(10, 5, base10String_short, base5String_short);
    }

    @Test
    public void test_Base10toBase5Conversion_long() {
        assertBaseConversion(10, 5, base10String_long, base5String_long);
    }

    @Test
    public void test_Multiply() {
        String multiply = StringMathsUtils.multiply("4707379232454323443243", 9);
        assertEquals("42366413092088910989187", multiply);
    }

    @Test
    public void test_Add() {
        String multiply = StringMathsUtils.multiply("4707379232454323443243", 9);
        assertEquals("42366413092088910989187", multiply);
    }

    @Test
    public void test_Base8toBase15Conversion_short() {
        assertBaseConversion(8, 15, base8String_short, base15String_short);
    }

    @Test
    public void test_Base8toBase15Conversion_long() {
        assertBaseConversion(8, 15, base8String_long, base15String_long);
    }

    @Test
    public void test_Base15toBase8Conversion_short() {
        assertBaseConversion(15, 8, base15String_short, base8String_short);
    }

    @Test
    public void test_Base15toBase8Conversion_long() {
        assertBaseConversion(15, 8, base15String_long, base8String_long);
    }

    @Test
    public void test_DifferentBase8() {
        assertBaseConversion(16, 15, base16String_short, base15String_short);
    }

    @Test
    public void test_SameBase() {
        assertBaseConversion(10, 10, base10String_long, base10String_long);
    }

    @Test(expected = Test.None.class)
    public void test_BaseHigherEnoughToIncorporateCharacterSet() {
        new BaseConversion(base15String_long, 15, 4);
    }

    @Test(expected = Test.None.class)
    public void test_BaseHigherEnoughToIncorporateCharacterSet2() {
        new BaseConversion(base16String_long, 16, 4);
    }

    @Test
    public void test_DifferentBase() {
        assertBaseConversion(10, 8, "710", "1306");
    }

    @Test
    public void test_DifferentBase2() {
        assertBaseConversion(10, 16, "710", "2C6");
    }

    @Test
    public void test_DifferentBase3() {
        assertBaseConversion(16, 8, "2C6", "1306");
    }

    @Test
    public void test_DifferentBase4() {
        assertBaseConversion(2, 10, "1011000110", "710");
    }

    @Test
    public void test_DifferentBase5() {
        assertBaseConversion(16, 10, "2C6", "710");
    }

    @Test
    public void test_DifferentBase6() {
        assertBaseConversion(2, 8, "1011000110", "1306");
    }

    @Test
    public void test_DifferentBase7() {
        assertBaseConversion(15, 10, "-ACDDEEDD2", "-27837927872");
    }

    @Test
    public void test_DifferentBaseNegativeNumber() {
        assertBaseConversion(10, 10, "-1", "-1");
    }

    @Test
    public void test_DifferentBaseNegative2() {
        assertBaseConversion(2, 8, "-1011000110", "-1306");
    }

    @Test
    public void test_DifferentBase9() {
        assertBaseConversion(10, 3, "890", "1012222");
    }

    @Test
    public void test_Base2ToBase16_short() {
        assertBaseConversion(2, 16, base2String_short, base16String_short);
    }

    @Test
    public void test_Base10ToBase36() {
        assertBaseConversion(10, 36, "35", "Z");
    }

    @Test
    public void test_Base36ToBase10() {
        assertBaseConversion(36, 10, "Z", "35");
    }

    @Test
    public void test_Base10ToBase36_3() {
        assertBaseConversion(10, 36,
                "147527216971109045296134222382645832477539947229035443086862709355009750952442070258529834123014307288817",
                "SDFKASDKFJASALSDJFIDOFSDJKDFJFDKGJASLDKJFASDHAJSDHFASJDJHSFKASDJGFL");
    }

    @Test
    public void test_Base16ToBase10() {
        assertBaseConversion(16, 10, "F", "15");
    }

    @Test
    public void test_Base16ToBase10_2() {
        assertBaseConversion(16, 10, "10", "16");
    }

    @Test
    public void test_Base36ToBase10_3() {
        assertBaseConversion(36, 10,
                "SDFKASDKFJASALSDJFIDOFSDJKDFJFDKGJASLDKJFASDHAJSDHFASJDJHSFKASDJGFL",
                "147527216971109045296134222382645832477539947229035443086862709355009750952442070258529834123014307288817");
    }

    @Test
    public void test_Base10ToBase16() {
        assertBaseConversion(10, 16, "15", "F");
    }

    @Test
    public void test_Base10ToBase16_2() {
        assertBaseConversion(10, 16, "16", "10");
    }

    @Test
    public void test_Base36ToBase10_2() {
        assertBaseConversion(36, 10, "10", "36");
    }

    @Test
    public void test_Base2ToBase16_long() {
        assertBaseConversion(2, 16, base2String_long, base16String_long);
    }

    @Test
    public void test_Base16ToBase2_short() {
        assertBaseConversion(16, 2, base16String_short, base2String_short);
    }

    @Test
    public void test_Base16ToBase2_long() {
        assertBaseConversion(16, 2, base16String_long, base2String_long);
    }

    @Test
    public void test_Base3ToBase4_short() {
        assertBaseConversion(3, 4, base3String_short, base4String_short);
    }

    @Test
    public void test_Base3ToBase4_long() {
        assertBaseConversion(3, 4, base3String_long, base4String_long);
    }

    @Test
    public void test_Base4ToBase3_short() {
        assertBaseConversion(4, 3, base4String_short, base3String_short);
    }

    @Test
    public void test_Base4ToBase3_long() {
        assertBaseConversion(4, 3, base4String_long, base3String_long);
    }
}