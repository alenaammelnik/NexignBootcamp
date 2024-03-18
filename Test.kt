import com.codeborne.selenide.Selectors.byText
import com.codeborne.selenide.Selenide
import jdk.incubator.vector.VectorOperators.Test
import org.junit.jupiter.api.AfterEach
import java.util.concurrent.locks.Condition

    class Test {
        @Test
        fun test() {
            Selenide.open("https://nexign.com/ru")

            Selenide.`$`(byText("Store")).click()

            Selenide.`$`(byText("Продукты для разработчиков")).click()

            Selenide.`$`("h1").shouldHave(Condition.text("Продукты для разработчиков"))
        }

        @AfterEach
        fun tearDown() {
            Selenide.closeWebDriver()
        }
    }
}