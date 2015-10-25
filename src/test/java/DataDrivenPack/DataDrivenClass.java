package DataDrivenPack;

import core.Config;
import core.Utils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YaskoYA on 27.07.2015.
 */
public class DataDrivenClass {

    @DataProvider(name = "Test_01", parallel = false)
    public static Iterator<Object[]> createTest01() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[] {Utils.genRandomText(29)});
        return data.iterator();
    }

    @DataProvider(name = "Test_02", parallel = false)
    public static Iterator<Object[]> createTest02() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[] {Utils.genRandomText(29), Config.getProperty("test.file1")});
        return data.iterator();
    }

    @DataProvider(name = "Test_03", parallel = false)
    public static Iterator<Object[]> createTest03() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[] {Utils.genRandomText(29), Config.getProperty("test.file1"), Config.getProperty("test.file2"), Config.getProperty("test.file3"), Config.getProperty("test.file4")});
        return data.iterator();
    }

    @DataProvider(name = "Test_04", parallel = false)
    public static Iterator<Object[]> createTest04() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[] {Utils.genRandomText(29)});
        return data.iterator();
    }

    @DataProvider(name = "Test_10", parallel = false)
    public static Iterator<Object[]> createTest10() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[] {Utils.genRandomText(11)});
        return data.iterator();
    }
}
