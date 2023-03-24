package ilsia.sabirzianova.dcs.model;

import javax.validation.constraints.NotNull;

public class MedicationDataChecker {

    //(allowed only letters, numbers, ‘-‘, ‘_’);
    public static boolean checkName(@NotNull String name) {
        return name.matches("^[A-Za-z0-9_-]*$");
    }
    // (allowed only upper case letters, underscore and numbers);
    public static boolean checkCode(String code){
        return code.matches("^[A-Z0-9_]*$");
    }
}
