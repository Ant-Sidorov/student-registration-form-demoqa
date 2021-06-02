package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitForm() {
//Test values
        String firstName = "Anton",
                lastName = "Sidorov",
                userEmail = "ant@mail.com",
                gender = "Male",
                userNumber = "1234567890",
                monthOfBirth = "July",
                yearOfBirth = "1991",
                dayOfBirth = "01",
                subjects = "Commerce",
                hobbies = "Sports",
                picture = "test1.jpg",
                currentAddress = "Sport street",
                state = "NCR",
                city = "Gurgaon";
//Open test form
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//Entering test values
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(monthOfBirth);
        $(".react-datepicker__year-select").selectOption(yearOfBirth);
        $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dayOfBirth)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        //File file = $("#uploadPicture").uploadFile(
                //new File("src/test/resources/test_upload.jpg"));
        $("#uploadPicture").uploadFromClasspath("img/"+picture);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();
//Checking result
        $(".table-responsive").shouldHave(text("Student Name"), text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text("Student Email"), text(userEmail));
        $(".table-responsive").shouldHave(text("Gender"), text(gender));
        $(".table-responsive").shouldHave(text("Mobile"), text(userNumber));
        $(".table-responsive").shouldHave(text("Date of Birth"), text(dayOfBirth+" "+monthOfBirth+","+yearOfBirth));
        $(".table-responsive").shouldHave(text("Subjects"), text(subjects));
        $(".table-responsive").shouldHave(text("Hobbies"), text(hobbies));
        $(".table-responsive").shouldHave(text("Picture"), text(picture));
        $(".table-responsive").shouldHave(text("Address"), text(currentAddress));
        $(".table-responsive").shouldHave(text("State and City"), text(state + " " + city));
    }
}
