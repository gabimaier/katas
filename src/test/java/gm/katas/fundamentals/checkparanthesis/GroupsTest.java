package gm.katas.fundamentals.checkparanthesis;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(DataProviderRunner.class)
public class GroupsTest {

    @DataProvider
    public static Object[][] complexGroups() {
        return new Object[][]{{"()", true}, {"({", false},
                {"({})", true}, {"[[]()]", true}, {"[{()}]", true},
                {"{(})", false}, {"([]", false}, {"[])", false},
                {"", true}, {"(", false},
                {"()", true}, {"[]", true}, {"{}", true}
        };
    }

    @Test
    @UseDataProvider("complexGroups")
    public void myTests(String group, Boolean expectedValue) {
        assertThat(Groups.groupCheck(group)).isEqualTo(expectedValue);
    }
}