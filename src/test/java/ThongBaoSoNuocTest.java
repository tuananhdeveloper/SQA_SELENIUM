import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ThongBaoSoNuoc;
import utils.SeleniumUtils;

public class ThongBaoSoNuocTest{

    ThongBaoSoNuoc thongBaoSoNuoc;
    @BeforeClass
    public void setUp() {
        // code that will be invoked when this test is instantiated
        System.setProperty("webdriver.chrome.driver","src\\test\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://localhost:4200/notify");
        thongBaoSoNuoc = new ThongBaoSoNuoc(webDriver);
    }

    @Test(description = "Lọc với các giá trị không cho ra kết quả")
    public void testFilter1() {
        String data = thongBaoSoNuoc.enterDate("09/2021")
                .enterDistrict("Cầu Giấy").filter().getData();
        Assert.assertNull(data);
    }

    @Test(description = "Lọc với giá trị cho ra kết quả")
    public void testFilter2() {
        String data = thongBaoSoNuoc.enterDate("04/2021")
                .enterDistrict("Cầu Giấy").filter().getData();
        Assert.assertNotNull(data);
    }

}
