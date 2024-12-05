package test_data;

public class TestData {

    public static class UserData {
        public static final String STANDART_USER_NAME = "standard_user";
        public static final String LOCKED_OUT_USER_NAME = "locked_out_user";
        public static final String PROBLEM_USER_NAME = "problem_user";
        public static final String PERFORMANCE_GLITCH_USER_NAME = "performance_glitch_user";
        public static final String WRONG_USER_NAME = "wrong_user";
        public static final String PASSWORD = "secret_sauce";
        public static final String WRONG_PASSWORD = "wrong_password";
    }

    public static class TextData {
        public static final String LOCKED_USER_TEXT = "Epic sadface: Sorry, this user has been locked out.";
        public static final String WRONG_USER_TEXT = "Epic sadface: Username and password do not match any user in this service";
        public static final String EMPTY_USER_TEXT = "Epic sadface: Username is required";
        public static final String EMPTY_PASSWORD_TEXT = "Epic sadface: Password is required";
        public static final String EMPTY_FIRST_NAME_TEXT = "Error: First Name is required";
        public static final String EMPTY_LAST_NAME_TEXT = "Error: Last Name is required";
        public static final String EMPTY_CODE_TEXT = "Error: Postal Code is required";
    }

    public static class UserInfo {
        public static final String FIRST_NAME = "IVanov";
        public static final String LAST_NAME = "Ivan";
        public static final String POSTAL_CODE = "8765432";
    }
}
