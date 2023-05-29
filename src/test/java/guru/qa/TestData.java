package guru.qa;

import com.github.javafaker.Faker;
import io.netty.util.internal.ThreadLocalRandom;

public class TestData {

    String[] userStateArray = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    String userState = getRandomFieldFromArray(userStateArray);

    //Constants
    String userImageThePath = "src/test/resources/image/";
    String userCity = userCityMetod(); // Для проверки(Check) требуется сначала назвать переменную, а потом конструкция if then else

    //Faker
    Faker faker = new Faker();
    String
            userName = faker.name().firstName(),
            userLastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            userAddress = faker.address().fullAddress();

    //SimpleRandom
    String userPhone = "903" + getRandomInt(1000000, 9999999);

    //List
    String[] userGenderArray = {"Female", "Male", "Other"};
    String userGender = getRandomFieldFromArray(userGenderArray); // Female , Male , Other

    String[] userImageNamesArray = {"379-scaled.jpg", "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg"};
    String userImageName = getRandomFieldFromArray(userImageNamesArray);
    String userImage = userImageThePath + userImageName;

    String[] userSubjectArray = {"Chemistry", "Maths", "Arts", "Accounting", "Hindi", "English", "History"};
    String userSubject = getRandomFieldFromArray(userSubjectArray);

    String[] userHobbyArray = {"Music", "Sports", "Reading"};
    String userHobby = getRandomFieldFromArray(userHobbyArray);


    public int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }


    public String getRandomFieldFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);
        return values[index];
    }

    public String userCityMetod() {
        switch (userState) {
            case "NCR": {
                String[] userCityArray = {"Delhi", "Gurgaon", "Noida"};
                userCity = getRandomFieldFromArray(userCityArray);
                break;
            }
            case "Uttar Pradesh": {
                String[] userCityArray = {"Agra", "Lucknow", "Merrut"};
                userCity = getRandomFieldFromArray(userCityArray);
                break;
            }
            case "Haryana": {
                String[] userCityArray = {"Karnal", "Panipat"};
                userCity = getRandomFieldFromArray(userCityArray);
                break;
            }
            case "Rajasthan": {
                String[] userCityArray = {"Jaipur", "Jaiselmer"};
                userCity = getRandomFieldFromArray(userCityArray);
                break;
            }
        }
        return userCity;
    }
}

