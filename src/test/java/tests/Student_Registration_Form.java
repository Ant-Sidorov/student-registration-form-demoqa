package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.*;

public class Student_Registration_Form {

    static void setup() {
        Configuration.startMaximized = true;
    }


    @Test
    void successfulSubmitForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Sidorov");
        $("#userEmail").setValue("ant@mail.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(3);
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label=\"Choose Monday, April 8th, 1991\"]").click();
        $("#subjectsInput").setValue("Commerce").pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        File file = $("#uploadPicture").uploadFile(new File("src/test/resources/test_upload.jpg"));
        $("#currentAddress").setValue("Sport street");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Gurgaon").pressEnter();
        $("#submit").click();


        sleep(5000);
    }
}
