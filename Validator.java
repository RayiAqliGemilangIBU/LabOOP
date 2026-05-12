class InvalidUserException extends Exception {
    public InvalidUserException(String message) {
        super(message);
    }
}

class Validator {
    public void validateAge(int age) throws InvalidUserException {
        if (age < 0) throw new InvalidUserException("Age cannot be negative.");
        if (age < 18) throw new InvalidUserException("User must be at least 18 years old.");
    }

    public void validateUsername(String username) throws InvalidUserException {
        if (username == null || username.trim().length() < 5) 
            throw new InvalidUserException("Username must be at least 5 characters.");
        if (username.contains(" ")) 
            throw new InvalidUserException("Username cannot contain spaces.");
    }

    public void validateEmail(String email) throws InvalidUserException {
        if (email == null || !email.contains("@") || !email.substring(email.indexOf("@")).contains("."))
            throw new InvalidUserException("Invalid email format.");
    }

    public void validateUser(String username, String email, int age) throws InvalidUserException {
        validateUsername(username);
        validateEmail(email);
        validateAge(age);
        System.out.println("User is valid.");
    }

    public static void main(String[] args) {
        Validator v = new Validator();
        Object[][] tests = {
            {"amina123", "amina@example.com", 21},
            {"ali", "ali@example.com", 20},
            {"sara 22", "sara@example.com", 19},
            {"kerim99", "kerimexample.com", 17}
        };

        for (Object[] test : tests) {
            try {
                v.validateUser((String)test[0], (String)test[1], (int)test[2]);
            } catch (InvalidUserException e) {
                System.out.println("Validation Error: " + e.getMessage());
            }
        }
    }
}
