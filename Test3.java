import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import org.languagetool.JLanguageTool;
import org.languagetool.language.Russian;

import java.io.IOException;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagName;

public class Test3 {

    @Test
    public void tesst() throws IOException {
      
        Selenide.open("https://nexign.com/ru");

        List<String> pageLinks = $$(byAttribute("href")).texts();
        pageLinks.add("https://nexign.com/ru");
        JLanguageTool langTool = new JLanguageTool(new Russian());

        
        for (String pageLink : pageLinks) {
            
            Selenide.open(pageLink);

            String pageContent = Selenide.$(byTagName("body")).text();

            List<String> errors = langTool.check(pageContent);

            for (String error : errors) {
                System.out.println("Ошибка на странице " + pageLink + ": " + error);
            }
        }
    }
}

