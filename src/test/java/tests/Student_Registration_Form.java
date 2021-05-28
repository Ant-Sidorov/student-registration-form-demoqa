package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Student_Registration_Form {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitForm() {
        //Test values
        String firstName = "Anton";
        String lastName = "Sidorov";
        String userEmail = "ant@mail.com";
        String userNumber = "1234567890";
        String subjects = "Commerce";
        String currentAddress = "Sport street";
        String state = "NCR";
        String city = "Gurgaon";
        //Open test form
        open("https://demoqa.com/automation-practice-form");
        //Entering test values
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(6);
        $(".react-datepicker__year-select").selectOption("1991");
        $("[aria-label=\"Choose Friday, July 5th, 1991\"]").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("[for=hobbies-checkbox-1]").click();
        File file = $("#uploadPicture").uploadFile(
                new File("src/test/resources/test_upload.jpg"));
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
        //Checking result
        $(".table-responsive").shouldHave(text("Student Name"), text(firstName+" "+lastName));
        $(".table-responsive").shouldHave(text("Student Email"), text(userEmail));
        $(".table-responsive").shouldHave(text("Gender"), text("Male"));
        $(".table-responsive").shouldHave(text("Mobile"), text(userNumber));
        $(".table-responsive").shouldHave(text("Date of Birth"), text("05 July,1991"));
        $(".table-responsive").shouldHave(text("Subjects"), text(subjects));
        $(".table-responsive").shouldHave(text("Hobbies"), text("Sports"));
        $(".table-responsive").shouldHave(text("Picture"), text("test_upload.jpg"));
        $(".table-responsive").shouldHave(text("Address"), text(currentAddress));
        $(".table-responsive").shouldHave(text("State and City"), text(state+" "+city));
    }
}
